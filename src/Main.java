import net.objecthunter.exp4j.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String expression;
    public static ArrayList<Double[]> XandYPositions;
    public static int[] res = {1280, 720};
    public static double acc = 0.001;
    public static String title = "Graph Of: ";

    public static void main(String[] args) {
        if (args.length == 3) {
            res[0] = Integer.parseInt(args[0]);
            res[1] = Integer.parseInt(args[1]);
            acc = Double.parseDouble(args[2]);
        }

        Scanner scan = new Scanner(System.in);

        System.out.print("Expressions: ");
        int amount = scan.nextInt();

        Expression[] eArray = new Expression[amount];

        for (int i = 0; i < amount; i++) {
            System.out.print("Input Your Expression: ");
            expression = scan.next();
            title = title.concat(expression + " & ");

            eArray[i] = new ExpressionBuilder(expression)
                    .variables("x")
                    .build();
        }

        XandYPositions = getDataPoints(eArray);

        new FrameManager();
    }

    public static ArrayList<Double[]> getDataPoints(Expression[] e) {
        ArrayList<Double[]> dataList = new ArrayList<>();

        for (Expression ex : e) {
            double scope = res[0];
            double lowerBound = 0 - scope * 0.5;
            double upperBound = scope * 0.5;
            double accuracy = acc;

            for (double d = lowerBound; d <= upperBound; d += accuracy) {
                double result = ex.setVariable("x", d).evaluate();

                Double[] data = new Double[2];
                data[0] = d;
                data[1] = result;
                dataList.add(data);
            }
        }

        return dataList;
    }
}


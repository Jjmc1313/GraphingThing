import net.objecthunter.exp4j.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String expression;
    public static ArrayList<ArrayList<Double[]>> XYData = new ArrayList<>();
    public static int[] res = {1280, 720};
    public static double acc = 0.01;
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
        int tracker = 1;

        for (int i = 0; i < amount; i++) {
            System.out.print("Input Your Expression: ");
            expression = scan.next();
            if (amount > 1 && tracker != amount) {
                title = title.concat(expression + " & "); // Add more robust title generation
                tracker++;
            } else {
                title = title.concat(expression);
            }

            Expression e = new ExpressionBuilder(expression)
                    .variables("x")
                    .build();

            XYData.add(getDataPoints(e));
        }

        new FrameManager();
    }

    public static ArrayList<Double[]> getDataPoints(Expression e) {
        ArrayList<Double[]> dataList = new ArrayList<>();

        double scope = res[0];
        double lowerBound = 0 - scope * 0.5;
        double upperBound = scope * 0.5;
        double accuracy = acc;

        for (double d = lowerBound; d <= upperBound; d += accuracy) {
            double result = e.setVariable("x", d).evaluate();

            Double[] data = new Double[2];
            data[0] = d;
            data[1] = result;
            dataList.add(data);
        }

        return dataList;
    }
}


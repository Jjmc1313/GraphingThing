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
                title = title.concat(expression + " & ");
                tracker++;
            } else {
                title = title.concat(expression);
            }

            Expression e = new ExpressionBuilder(expression)
                    .variables("x")
                    .build();

            XYData.add(GetDataPoints.getDataPoints(e));
        }

        new FrameManager();
    }
}
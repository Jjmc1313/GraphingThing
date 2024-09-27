import net.objecthunter.exp4j.Expression;

import java.util.ArrayList;

public class GetDataPoints {
    public static ArrayList<Double[]> getDataPoints(Expression e) {
        ArrayList<Double[]> dataList = new ArrayList<>();

        double scope = Main.res[0];
        double lowerBound = 0 - scope * 0.5;
        double upperBound = scope * 0.5;
        double accuracy = Main.acc;

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

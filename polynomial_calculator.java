import org.json.JSONObject;  

import java.util.HashMap;  
import java.util.Map;  

public class CatalogProblemSolution {  

    public static int decodeValue(int base, String value) {  
        return Integer.parseInt(value, base);  
    }  

    public static double lagrangeInterpolation(int[] xValues, double[] yValues, int k) {  
        double total = 0.0;  
        int n = xValues.length;  

        for (int i = 0; i < k; i++) {  
            double term = yValues[i];  
            for (int j = 0; j < k; j++) {  
                if (i != j) {  
                    term *= (0 - xValues[j]) / (xValues[i] - xValues[j]);  
                }  
            }  
            total += term;  
        }  

        return total;  
    }  

    public static void main(String[] args) {  
        String inputJson = "{ \"n\": 5, \"k\": 3, \"data\": { \"0\": \"10\", \"1\": \"11\", \"2\": \"100\", \"3\": \"101\", \"4\": \"110\" }, \"base\": 2 }";  

        JSONObject jsonObject = new JSONObject(inputJson);  
        int n = jsonObject.getInt("n");  
        int k = jsonObject.getInt("k");  
        JSONObject data = jsonObject.getJSONObject("data");  
        int base = jsonObject.getInt("base");  

        int[] xValues = new int[k];  
        double[] yValues = new double[k];  

        for (int i = 0; i < k; i++) {  
            xValues[i] = i;  
            String value = data.getString(String.valueOf(i));  
            yValues[i] = decodeValue(base, value);   
        }  

        double c = lagrangeInterpolation(xValues, yValues, k);  
        System.out.println((int) c); r  
    }  
}

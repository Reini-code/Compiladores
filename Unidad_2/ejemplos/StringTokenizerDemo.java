package Unidad_2.ejemplos;
import java.util.StringTokenizer;

public class StringTokenizerDemo {

    public static void main(String[] args) {

        String codigo = "int x = 10 + 20;";

        StringTokenizer tokenizer = new StringTokenizer(codigo, " +-;=", true);

        while(tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken();
            System.out.println("Token: " + token);

        }
    }
}
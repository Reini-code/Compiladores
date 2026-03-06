package Unidad_2.lexer;
import java.util.StringTokenizer;

public class LexerSimple {

    public static void analizar(String codigo) {

        StringTokenizer tokenizer =
                new StringTokenizer(codigo," +-*/=();",true);

        while(tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken().trim();

            if(token.isEmpty())
                continue;

            if(token.equals("int") ||
               token.equals("if") ||
               token.equals("while")) {

                System.out.println(token + " -> PALABRA_RESERVADA");

            }

            else if(token.matches("[0-9]+")) {

                System.out.println(token + " -> NUMERO");

            }

            else if(token.matches("[a-zA-Z][a-zA-Z0-9]*")) {

                System.out.println(token + " -> IDENTIFICADOR");

            }

            else {

                System.out.println(token + " -> OPERADOR/SIMBOLO");

            }

        }

    }

    public static void main(String[] args) {

        String codigo = "int suma = a + 25;";

        analizar(codigo);

    }
}
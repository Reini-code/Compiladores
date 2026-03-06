package Unidad_2.ejemplos;
public class ReconocimientoNumeros {

    public static void main(String[] args) {

        String[] tokens = {"10", "25", "hola", "123", "x"};

        for(String token : tokens) {

            if(token.matches("[0-9]+")) {

                System.out.println(token + " es un NUMERO");

            } else {

                System.out.println(token + " NO es numero");

            }

        }
    }
}
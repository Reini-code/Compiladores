package Unidad_2.ejemplos;
public class ReconocimientoIdentificadores {

    public static void main(String[] args) {

        String[] palabras = {
                "x",
                "contador",
                "sumaTotal",
                "1variable",
                "_temp"
        };

        for(String palabra : palabras) {

            if(palabra.matches("[a-zA-Z][a-zA-Z0-9]*")) {

                System.out.println(palabra + " es IDENTIFICADOR");

            } else {

                System.out.println(palabra + " NO es identificador valido");

            }

        }
    }
}
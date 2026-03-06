package Unidad_2.automatas;

public class AFIdentificadores {

    public static boolean esIdentificador(String cadena) {

        int estado = 0;

        for(char c : cadena.toCharArray()) {

            switch(estado) {

                case 0:

                    if(Character.isLetter(c))
                        estado = 1;
                    else
                        return false;

                    break;

                case 1:

                    if(Character.isLetterOrDigit(c))
                        estado = 1;
                    else
                        return false;

                    break;

            }

        }

        return estado == 1;
    }

    public static void main(String[] args) {

        String[] pruebas = {
                "x",
                "contador",
                "suma1",
                "1error"
        };

        for(String p : pruebas) {

            System.out.println(p + " -> " + esIdentificador(p));

        }

    }
}
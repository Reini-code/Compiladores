package Unidad_2.automatas;
public class AFNumeros {

    public static boolean esNumero(String cadena) {

        int estado = 0;

        for(char c : cadena.toCharArray()) {

            switch(estado) {

                case 0:

                    if(Character.isDigit(c))
                        estado = 1;
                    else
                        return false;

                    break;

                case 1:

                    if(Character.isDigit(c))
                        estado = 1;
                    else
                        return false;

                    break;

            }

        }

        return estado == 1;
    }

    public static void main(String[] args) {

        String[] pruebas = {"123", "45", "9a", "abc"};

        for(String p : pruebas) {

            System.out.println(p + " -> " + esNumero(p));

        }

    }
}
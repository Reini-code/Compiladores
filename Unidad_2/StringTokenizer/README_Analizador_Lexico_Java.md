# Analizador Léxico en Java (Paso a Paso)

Este material contiene **5 programas en Java** diseñados para enseñar a
construir un **analizador léxico desde cero**.

La progresión didáctica sigue estos pasos:

1.  Separar tokens con `StringTokenizer`
2.  Mostrar tokens claramente
3.  Clasificar tokens
4.  Reconocer tokens de un lenguaje
5.  Construir un mini analizador léxico

Estos ejercicios son ideales para cursos de **Compiladores** en
Ingeniería en Software.

------------------------------------------------------------------------

# Estructura del proyecto

    analizador-lexico-java/

    README.md

    Ejemplo1Tokenizer.java
    Ejemplo2ListaTokens.java
    Ejemplo3ClasificadorTokens.java
    Ejemplo4TokensLenguaje.java
    MiniAnalizadorLexico.java

------------------------------------------------------------------------

# 1. Separar palabras con StringTokenizer

Archivo: **Ejemplo1Tokenizer.java**

Objetivo: comprender cómo dividir un texto en tokens.

``` java
import java.util.StringTokenizer;

public class Ejemplo1Tokenizer {

    public static void main(String[] args) {

        String texto = "Hola mundo esto es Java";

        StringTokenizer tokenizer = new StringTokenizer(texto);

        while (tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken();

            System.out.println(token);

        }

    }

}
```

Salida esperada:

    Hola
    mundo
    esto
    es
    Java

Concepto aprendido:

Tokenización básica.

------------------------------------------------------------------------

# 2. Mostrar tokens numerados

Archivo: **Ejemplo2ListaTokens.java**

Objetivo: visualizar tokens de forma ordenada.

``` java
import java.util.StringTokenizer;

public class Ejemplo2ListaTokens {

    public static void main(String[] args) {

        String codigo = "int x = 10 + 5";

        StringTokenizer tokenizer = new StringTokenizer(codigo);

        int contador = 1;

        while (tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken();

            System.out.println("Token " + contador + ": " + token);

            contador++;

        }

    }

}
```

Salida:

    Token 1: int
    Token 2: x
    Token 3: =
    Token 4: 10
    Token 5: +
    Token 6: 5

Concepto aprendido:

Identificación de tokens.

------------------------------------------------------------------------

# 3. Clasificación simple de tokens

Archivo: **Ejemplo3ClasificadorTokens.java**

Objetivo: identificar números, identificadores y operadores.

``` java
import java.util.StringTokenizer;

public class Ejemplo3ClasificadorTokens {

    public static void main(String[] args) {

        String codigo = "x = 25 + y";

        StringTokenizer tokenizer = new StringTokenizer(codigo);

        while (tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken();

            if (token.matches("[0-9]+")) {

                System.out.println(token + " -> NUMERO");

            } 
            else if (token.matches("[a-zA-Z]+")) {

                System.out.println(token + " -> IDENTIFICADOR");

            } 
            else {

                System.out.println(token + " -> OPERADOR");

            }

        }

    }

}
```

Salida:

    x -> IDENTIFICADOR
    = -> OPERADOR
    25 -> NUMERO
    + -> OPERADOR
    y -> IDENTIFICADOR

Concepto aprendido:

Clasificación básica de tokens usando expresiones regulares.

------------------------------------------------------------------------

# 4. Reconocer tokens de un lenguaje

Archivo: **Ejemplo4TokensLenguaje.java**

Objetivo: reconocer tokens típicos de un lenguaje de programación.

``` java
import java.util.StringTokenizer;

public class Ejemplo4TokensLenguaje {

    public static void main(String[] args) {

        String codigo = "int suma = a + 10 ;";

        StringTokenizer tokenizer = new StringTokenizer(codigo);

        while (tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken();

            if (token.equals("int") || token.equals("float") || token.equals("double")) {

                System.out.println(token + " -> PALABRA_RESERVADA");

            }
            else if (token.matches("[0-9]+")) {

                System.out.println(token + " -> NUMERO");

            }
            else if (token.matches("[a-zA-Z]+")) {

                System.out.println(token + " -> IDENTIFICADOR");

            }
            else if (token.matches("[+\\-*/=]")) {

                System.out.println(token + " -> OPERADOR");

            }
            else if (token.matches("[;]")) {

                System.out.println(token + " -> SIMBOLO");

            }

        }

    }

}
```

Salida:

    int -> PALABRA_RESERVADA
    suma -> IDENTIFICADOR
    = -> OPERADOR
    a -> IDENTIFICADOR
    + -> OPERADOR
    10 -> NUMERO
    ; -> SIMBOLO

Concepto aprendido:

Diseño de tokens para un lenguaje de programación.

------------------------------------------------------------------------

# 5. Mini Analizador Léxico

Archivo: **MiniAnalizadorLexico.java**

Este programa simula la **primera fase de un compilador**.

``` java
import java.util.StringTokenizer;

public class MiniAnalizadorLexico {

    public static void main(String[] args) {

        String codigo = "int x = 10 + y ;";

        StringTokenizer tokenizer = new StringTokenizer(codigo);

        System.out.println("ANALISIS LEXICO");
        System.out.println("----------------");

        while (tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken();

            analizarToken(token);

        }

    }

    public static void analizarToken(String token) {

        if (token.equals("int") || token.equals("float") || token.equals("double")) {

            System.out.println(token + " -> PALABRA RESERVADA");

        }
        else if (token.matches("[0-9]+")) {

            System.out.println(token + " -> NUMERO");

        }
        else if (token.matches("[a-zA-Z]+")) {

            System.out.println(token + " -> IDENTIFICADOR");

        }
        else if (token.matches("[+\\-*/]")) {

            System.out.println(token + " -> OPERADOR ARITMETICO");

        }
        else if (token.equals("=")) {

            System.out.println(token + " -> OPERADOR DE ASIGNACION");

        }
        else if (token.equals(";")) {

            System.out.println(token + " -> FIN DE SENTENCIA");

        }
        else {

            System.out.println(token + " -> TOKEN DESCONOCIDO");

        }

    }

}
```

Salida:

    ANALISIS LEXICO
    ----------------
    int -> PALABRA RESERVADA
    x -> IDENTIFICADOR
    = -> OPERADOR DE ASIGNACION
    10 -> NUMERO
    + -> OPERADOR ARITMETICO
    y -> IDENTIFICADOR
    ; -> FIN DE SENTENCIA

------------------------------------------------------------------------

# Resultado del aprendizaje

Después de estos ejercicios los estudiantes comprenden:

-   Qué es un token
-   Cómo separar tokens
-   Cómo clasificar tokens
-   Cómo reconocer estructuras de lenguaje
-   Cómo funciona la primera fase de un compilador

Este conjunto de programas representa una **introducción práctica al
análisis léxico en compiladores**.

# Manual de StringTokenizer en Java

## De lo básico al análisis léxico

Este manual explica cómo utilizar `StringTokenizer` en Java desde cero
hasta aplicarlo en la construcción de un **analizador léxico simple**,
útil en la materia de Compiladores.

------------------------------------------------------------------------

# 1. Introducción

En Java, una de las tareas más comunes cuando se trabaja con texto es
**dividir una cadena en partes más pequeñas llamadas tokens**.

Un **token** es la unidad mínima de información dentro de un texto.

Ejemplo de código:

    int suma = a + b;

Los tokens serían:

    int
    suma
    =
    a
    +
    b
    ;

Para separar estos elementos, Java proporciona varias herramientas. Una
de las más sencillas y clásicas es:

    StringTokenizer

Clase ubicada en:

    java.util

Aunque existen alternativas modernas como `split()` o `Scanner`,
`StringTokenizer` es muy útil para **aprender los fundamentos del
análisis léxico**.

------------------------------------------------------------------------

# 2. ¿Qué es StringTokenizer?

`StringTokenizer` es una clase que permite **dividir una cadena en
tokens usando delimitadores**.

### Delimitador

Un **delimitador** es el carácter que separa los tokens.

Ejemplo:

Cadena:

    Java es un lenguaje poderoso

Delimitador:

    espacio

Tokens:

    Java
    es
    un
    lenguaje
    poderoso

------------------------------------------------------------------------

# 3. Importar la clase

Antes de usar `StringTokenizer` debes importar la clase.

``` java
import java.util.StringTokenizer;
```

------------------------------------------------------------------------

# 4. Constructor básico

La forma más simple de crear un tokenizer es:

``` java
StringTokenizer st = new StringTokenizer(cadena);
```

Esto usa **espacios como delimitadores por defecto**.

------------------------------------------------------------------------

# 5. Primer ejemplo básico

## Archivo: `Ejemplo1Tokenizer.java`

``` java
import java.util.StringTokenizer;

public class Ejemplo1Tokenizer {

    public static void main(String[] args) {

        String texto = "Java es un lenguaje poderoso";

        StringTokenizer st = new StringTokenizer(texto);

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

    }

}
```

### Salida

    Java
    es
    un
    lenguaje
    poderoso

------------------------------------------------------------------------

# 6. Métodos importantes

## hasMoreTokens()

Verifica si aún existen tokens disponibles.

``` java
boolean hasMoreTokens()
```

Ejemplo:

``` java
while(st.hasMoreTokens())
```

------------------------------------------------------------------------

## nextToken()

Obtiene el siguiente token.

``` java
String nextToken()
```

Ejemplo:

``` java
String palabra = st.nextToken();
```

------------------------------------------------------------------------

## countTokens()

Cuenta cuántos tokens quedan.

``` java
int cantidad = st.countTokens();
```

------------------------------------------------------------------------

# 7. Ejemplo contando tokens

## Archivo: `Ejemplo2ContarTokens.java`

``` java
import java.util.StringTokenizer;

public class Ejemplo2ContarTokens {

    public static void main(String[] args) {

        String texto = "uno dos tres cuatro";

        StringTokenizer st = new StringTokenizer(texto);

        System.out.println("Cantidad de tokens: " + st.countTokens());

    }

}
```

Salida:

    Cantidad de tokens: 4

------------------------------------------------------------------------

# 8. Usar delimitadores personalizados

Podemos definir **qué caracteres separan los tokens**.

Constructor:

``` java
StringTokenizer st = new StringTokenizer(cadena, delimitadores);
```

Ejemplo:

Cadena:

    1,2,3,4,5

Delimitador:

    ,

------------------------------------------------------------------------

## Archivo: `Ejemplo3Delimitador.java`

``` java
import java.util.StringTokenizer;

public class Ejemplo3Delimitador {

    public static void main(String[] args) {

        String numeros = "1,2,3,4,5";

        StringTokenizer st = new StringTokenizer(numeros, ",");

        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }

    }

}
```

Salida:

    1
    2
    3
    4
    5

------------------------------------------------------------------------

# 9. Múltiples delimitadores

Podemos usar **varios delimitadores al mismo tiempo**.

Ejemplo:

    + - * / ;

------------------------------------------------------------------------

## Archivo: `Ejemplo4MultiplesDelimitadores.java`

``` java
import java.util.StringTokenizer;

public class Ejemplo4MultiplesDelimitadores {

    public static void main(String[] args) {

        String expresion = "10+20-5*3/2";

        StringTokenizer st = new StringTokenizer(expresion, "+-*/");

        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }

    }

}
```

Salida:

    10
    20
    5
    3
    2

------------------------------------------------------------------------

# 10. Mantener los delimitadores

En análisis léxico muchas veces **los operadores también son tokens**.

Para eso usamos el tercer parámetro:

``` java
true
```

Constructor:

``` java
StringTokenizer st = new StringTokenizer(cadena, delimitadores, true);
```

------------------------------------------------------------------------

## Archivo: `Ejemplo5ConOperadores.java`

``` java
import java.util.StringTokenizer;

public class Ejemplo5ConOperadores {

    public static void main(String[] args) {

        String expresion = "10+20-5";

        StringTokenizer st = new StringTokenizer(expresion, "+-", true);

        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }

    }

}
```

Salida:

    10
    +
    20
    -
    5

Esto ya se parece mucho al análisis léxico real.

------------------------------------------------------------------------

# 11. Uso para un analizador léxico simple

Supongamos el siguiente código:

    int a = 5 + 3;

Queremos identificar:

  Token   Tipo
  ------- -------------------
  int     palabra reservada
  a       identificador
  =       operador
  5       número
  \+      operador
  3       número
  ;       delimitador

------------------------------------------------------------------------

# 12. Analizador léxico básico con StringTokenizer

## Archivo: `AnalizadorLexicoSimple.java`

``` java
import java.util.StringTokenizer;

public class AnalizadorLexicoSimple {

    public static void main(String[] args) {

        String codigo = "int a = 5 + 3;";

        String delimitadores = " +-*/=;()";

        StringTokenizer st = new StringTokenizer(codigo, delimitadores, true);

        while(st.hasMoreTokens()){

            String token = st.nextToken().trim();

            if(token.isEmpty())
                continue;

            if(token.matches("\\d+")){
                System.out.println(token + " -> NUMERO");
            }
            else if(token.matches("[a-zA-Z]+")){
                System.out.println(token + " -> IDENTIFICADOR");
            }
            else if(token.matches("[+\\-*/=]")){
                System.out.println(token + " -> OPERADOR");
            }
            else if(token.equals(";")){
                System.out.println(token + " -> FIN DE INSTRUCCION");
            }
        }

    }

}
```

Salida:

    int -> IDENTIFICADOR
    a -> IDENTIFICADOR
    = -> OPERADOR
    5 -> NUMERO
    + -> OPERADOR
    3 -> NUMERO
    ; -> FIN DE INSTRUCCION

------------------------------------------------------------------------

# 13. Ejemplo más cercano a un compilador

Entrada:

    float resultado = a * 10 + 20;

Salida esperada:

    float -> PALABRA RESERVADA
    resultado -> IDENTIFICADOR
    = -> OPERADOR
    a -> IDENTIFICADOR
    * -> OPERADOR
    10 -> NUMERO
    + -> OPERADOR
    20 -> NUMERO
    ; -> DELIMITADOR

Esto simula la **fase de análisis léxico de un compilador**.

------------------------------------------------------------------------

# 14. Limitaciones de StringTokenizer

Aunque es útil para aprender, tiene algunas limitaciones.

No maneja bien:

-   strings `"hola mundo"`
-   comentarios
-   números decimales complejos
-   operadores dobles `==`, `<=`, `>=`
-   identificadores complejos

Por eso los compiladores reales utilizan:

-   expresiones regulares
-   autómatas finitos
-   generadores de analizadores léxicos

------------------------------------------------------------------------

# 15. Ejercicios para estudiantes

## Ejercicio 1

Separar la siguiente cadena:

    10+20*30-5

Mostrar cada token.

------------------------------------------------------------------------

## Ejercicio 2

Analizar:

    x = 100;

Identificar:

-   identificadores
-   números
-   operadores
-   delimitadores

------------------------------------------------------------------------

## Ejercicio 3

Analizar:

    if (a > 10)

Clasificar:

    if -> palabra reservada
    a -> identificador
    > -> operador
    10 -> número

------------------------------------------------------------------------

# 16. Conclusión

`StringTokenizer` es una herramienta muy útil para aprender:

-   cómo dividir cadenas
-   cómo reconocer tokens
-   cómo funciona un analizador léxico

Permite introducir conceptos fundamentales del área de compiladores
como:

-   tokenización
-   delimitadores
-   reconocimiento de patrones
-   clasificación léxica

Antes de pasar a herramientas más avanzadas como generadores de
analizadores léxicos.

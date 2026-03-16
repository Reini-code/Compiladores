# 📘 Manual de StringTokenizer en Java

## Uso básico para procesamiento de texto y análisis léxico

Este documento explica **desde cero** cómo funciona la clase
`StringTokenizer` en Java y cómo puede utilizarse para **separar texto
en partes (tokens)**.\
Este conocimiento es muy útil para:

-   Procesamiento de texto
-   Lectura de archivos
-   Interpretación de comandos
-   Construcción de analizadores léxicos
-   Desarrollo de compiladores

------------------------------------------------------------------------

# 1. ¿Qué es un Token?

Un **token** es una **unidad mínima de información dentro de un texto**.

Ejemplo:

    int x = 10;

Tokens:

    int
    x
    =
    10
    ;

Los compiladores primero **dividen el código en tokens** antes de
analizar su estructura.

Este proceso se llama:

**Análisis Léxico**.

------------------------------------------------------------------------

# 2. ¿Qué es StringTokenizer?

`StringTokenizer` es una clase de Java que permite **dividir una cadena
de texto en partes más pequeñas llamadas tokens**.

Se encuentra en el paquete:

``` java
import java.util.StringTokenizer;
```

Su función principal es **separar un texto usando delimitadores**.

------------------------------------------------------------------------

# 3. Importar la clase

Antes de usar `StringTokenizer`, debemos importarla.

``` java
import java.util.StringTokenizer;
```

------------------------------------------------------------------------

# 4. Crear un StringTokenizer

Forma básica:

``` java
StringTokenizer tokenizer = new StringTokenizer(texto);
```

Ejemplo:

``` java
import java.util.StringTokenizer;

public class Ejemplo1 {

    public static void main(String[] args) {

        String texto = "Hola mundo esto es Java";

        StringTokenizer tokenizer = new StringTokenizer(texto);

    }
}
```

Por defecto separa usando:

-   espacios
-   tabulaciones
-   saltos de línea

------------------------------------------------------------------------

# 5. Obtener tokens

Para obtener cada token usamos:

    nextToken()

Ejemplo:

``` java
import java.util.StringTokenizer;

public class Ejemplo2 {

    public static void main(String[] args) {

        String texto = "Hola mundo esto es Java";

        StringTokenizer tokenizer = new StringTokenizer(texto);

        System.out.println(tokenizer.nextToken());
        System.out.println(tokenizer.nextToken());
        System.out.println(tokenizer.nextToken());

    }
}
```

Salida:

    Hola
    mundo
    esto

------------------------------------------------------------------------

# 6. Saber si aún hay tokens

Usamos:

    hasMoreTokens()

Ejemplo:

``` java
import java.util.StringTokenizer;

public class Ejemplo3 {

    public static void main(String[] args) {

        String texto = "Hola mundo esto es Java";

        StringTokenizer tokenizer = new StringTokenizer(texto);

        while(tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken();

            System.out.println(token);

        }

    }
}
```

Salida:

    Hola
    mundo
    esto
    es
    Java

------------------------------------------------------------------------

# 7. Usar delimitadores personalizados

Sintaxis:

    StringTokenizer(texto, delimitador)

Ejemplo:

Texto:

    rojo,verde,azul,amarillo

Código:

``` java
import java.util.StringTokenizer;

public class Ejemplo4 {

    public static void main(String[] args) {

        String colores = "rojo,verde,azul,amarillo";

        StringTokenizer tokenizer = new StringTokenizer(colores, ",");

        while(tokenizer.hasMoreTokens()) {

            System.out.println(tokenizer.nextToken());

        }

    }
}
```

Salida:

    rojo
    verde
    azul
    amarillo

------------------------------------------------------------------------

# 8. Usar múltiples delimitadores

Ejemplo:

    Juan;Pedro,María:Luis

Código:

``` java
import java.util.StringTokenizer;

public class Ejemplo5 {

    public static void main(String[] args) {

        String texto = "Juan;Pedro,María:Luis";

        StringTokenizer tokenizer = new StringTokenizer(texto, ";,:" );

        while(tokenizer.hasMoreTokens()) {

            System.out.println(tokenizer.nextToken());

        }

    }
}
```

Salida:

    Juan
    Pedro
    María
    Luis

------------------------------------------------------------------------

# 9. Contar tokens

Podemos saber cuántos tokens existen con:

    countTokens()

Ejemplo:

``` java
import java.util.StringTokenizer;

public class Ejemplo6 {

    public static void main(String[] args) {

        String texto = "uno dos tres cuatro";

        StringTokenizer tokenizer = new StringTokenizer(texto);

        System.out.println("Total de tokens: " + tokenizer.countTokens());

    }
}
```

Salida:

    Total de tokens: 4

------------------------------------------------------------------------

# 10. Ejemplo práctico con números

Texto:

    10,20,30,40,50

Código:

``` java
import java.util.StringTokenizer;

public class Ejemplo7 {

    public static void main(String[] args) {

        String numeros = "10,20,30,40,50";

        StringTokenizer tokenizer = new StringTokenizer(numeros, ",");

        while(tokenizer.hasMoreTokens()) {

            int numero = Integer.parseInt(tokenizer.nextToken());

            System.out.println(numero * 2);

        }

    }
}
```

Salida:

    20
    40
    60
    80
    100

------------------------------------------------------------------------

# 11. Uso en análisis léxico

Código fuente:

    int suma = a + b;

Programa:

``` java
import java.util.StringTokenizer;

public class AnalizadorSimple {

    public static void main(String[] args) {

        String codigo = "int suma = a + b ;";

        StringTokenizer tokenizer = new StringTokenizer(codigo);

        while(tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken();

            System.out.println("TOKEN -> " + token);

        }

    }
}
```

Salida:

    TOKEN -> int
    TOKEN -> suma
    TOKEN -> =
    TOKEN -> a
    TOKEN -> +
    TOKEN -> b
    TOKEN -> ;

------------------------------------------------------------------------

# 12. Limitaciones de StringTokenizer

Aunque es útil, tiene algunas limitaciones:

-   No soporta expresiones regulares
-   No clasifica tipos de token automáticamente
-   No maneja estructuras complejas

Por eso, analizadores más avanzados usan:

-   `split()`
-   expresiones regulares
-   autómatas
-   herramientas como **JFlex o Lex**

------------------------------------------------------------------------

# 13. Ejercicio para estudiantes

Crear un programa que:

1.  Reciba la cadena:

```{=html}
<!-- -->
```
    x = 10 + 20 * 5

2.  Utilice `StringTokenizer`.

3.  Muestre cada token.

Salida esperada:

    x
    =
    10
    +
    20
    *
    5

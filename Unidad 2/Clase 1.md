# Unidad II -- Análisis Léxico

## Asignatura: Compiladores

Esta unidad introduce **el análisis léxico**, la primera fase del
proceso de compilación.\
Su objetivo principal es **leer el código fuente y transformarlo en
unidades significativas llamadas tokens**, que posteriormente serán
analizadas por el analizador sintáctico.

------------------------------------------------------------------------

# Índice

1.  Introducción al análisis léxico
2.  Aspectos formales
3.  Analizadores léxicos
4.  Tokens y reconocimiento de tokens
5.  Funciones del analizador léxico
6.  Autómatas de estado finito
7.  Teoría de lenguajes
8.  Expresiones regulares
9.  Expresiones regulares y autómatas finitos no determinísticos
10. Ejemplo práctico

------------------------------------------------------------------------

# 1. Introducción al análisis léxico

El **análisis léxico** es la primera etapa de un compilador.\
Su función es **leer el programa fuente carácter por carácter y
agruparlos en unidades llamadas tokens**.

### Ejemplo

Código fuente:

``` c
int suma = a + b;
```

Salida del analizador léxico:

    [INT] [IDENTIFICADOR:suma] [=] [IDENTIFICADOR:a] [+] [IDENTIFICADOR:b] [;]

El análisis léxico transforma el **texto plano** en una **secuencia
estructurada de tokens**.

También se conoce como:

-   Scanner
-   Tokenizador
-   Analizador lexicográfico

------------------------------------------------------------------------

# 2. Aspectos formales

El análisis léxico se basa en la **teoría de lenguajes formales**.

## Alfabeto

Un **alfabeto (Σ)** es un conjunto finito de símbolos.

Ejemplo:

    Σ = {a,b,c}

En programación puede incluir:

    Σ = {letras, dígitos, operadores, símbolos especiales}

Ejemplo real:

    Σ = {a..z, A..Z, 0..9, +, -, *, /, =, ;}

------------------------------------------------------------------------

## Cadena

Una **cadena** es una secuencia finita de símbolos del alfabeto.

Ejemplos:

    hola
    variable
    x1

------------------------------------------------------------------------

## Lenguaje

Un **lenguaje** es un conjunto de cadenas construidas a partir de un
alfabeto.

Ejemplo:

Lenguaje de identificadores:

    x
    contador
    resultadoFinal
    temp1

------------------------------------------------------------------------

## Longitud de una cadena

La longitud de una cadena es el número de símbolos que contiene.

Ejemplo:

    |hola| = 4
    |x| = 1
    |""| = 0

La cadena vacía se representa con:

    ε

------------------------------------------------------------------------

## Concatenación

Operación de unir dos cadenas.

Ejemplo:

    "progra" + "macion" = "programacion"

------------------------------------------------------------------------

## Cerradura de Kleene

Representada con:

    *

Permite repetir una cadena **cero o más veces**.

Ejemplo:

    a*

Significa:

    ε
    a
    aa
    aaa
    aaaa

------------------------------------------------------------------------

# 3. Analizadores Léxicos

El **analizador léxico** recibe el código fuente y lo transforma en
tokens.

Flujo del proceso:

    Código fuente
         ↓
    Analizador léxico
         ↓
    Lista de tokens
         ↓
    Analizador sintáctico

Ejemplo:

Código:

    x = 10 + 20;

Tokens:

    IDENTIFICADOR(x)
    ASIGNACION
    NUMERO(10)
    SUMA
    NUMERO(20)
    PUNTO_Y_COMA

------------------------------------------------------------------------

# 4. Tokens y reconocimiento de tokens

## Token

Un **token** es una categoría léxica dentro del lenguaje.

Ejemplos:

-   IDENTIFICADOR
-   NUMERO
-   OPERADOR
-   PALABRA_RESERVADA
-   DELIMITADOR

------------------------------------------------------------------------

## Lexema

El **lexema** es el texto exacto que aparece en el código.

Ejemplo:

Código:

    contador = 5;

Tabla:

  Token                 Lexema
  --------------------- ----------
  IDENTIFICADOR         contador
  OPERADOR_ASIGNACION   =
  NUMERO                5
  PUNTO_Y_COMA          ;

------------------------------------------------------------------------

## Tipos comunes de tokens

### Palabras reservadas

Ejemplo:

    if
    while
    for
    return
    int

------------------------------------------------------------------------

### Identificadores

Son nombres definidos por el programador.

Ejemplo:

    x
    contador
    sumaTotal
    ``

    Regla típica:

letra (letra\|digito)\*


    ---

    ### Literales

    Valores constantes.

    Ejemplo:

10 3.14 "Hola"


    ---

    ### Operadores

-   

-   

-   # /

    ==

```{=html}
<!-- -->
```

    ---

    ### Delimitadores

; , () {} \[\]


    ---

    # 5. Funciones principales del analizador léxico

    ## 1. Convertir caracteres en tokens

    Ejemplo:

a + b


    Se convierte en:

IDENTIFICADOR SUMA IDENTIFICADOR


    ---

    ## 2. Ignorar elementos irrelevantes

    El analizador ignora:

    - espacios
    - saltos de línea
    - tabulaciones
    - comentarios

    Ejemplo:

int x; // variable


    El comentario se ignora.

    ---

    ## 3. Detectar errores léxicos

    Ejemplo:

int #variable;


    Error:

Símbolo ilegal \#


    ---

    ## 4. Interfaz con el analizador sintáctico

    El analizador sintáctico solicita tokens mediante funciones como:

getNextToken()


    ---

    ## 5. Manejo de tabla de símbolos

    Cuando se detecta un identificador, se registra en la tabla de símbolos.

    Ejemplo:

    | Identificador | Tipo |
    |---|---|
    | contador | variable |

    ---

    # 6. Autómatas de Estado Finito

    Los analizadores léxicos se implementan mediante **Autómatas de Estado Finito (AF)**.

    Definición formal:

AF = (Q, Σ, δ, q0, F)


    Donde:

    - Q = conjunto de estados
    - Σ = alfabeto
    - δ = función de transición
    - q0 = estado inicial
    - F = estados finales

    ---

    ## Ejemplo: reconocer números

    Autómata:

(q0) --digito--\> (q1) (q1) --digito--\> (q1)


    Estado final:

q1


    Acepta:

5 10 345 999


    ---

    # 7. Diagrama de transición

    Representación gráfica del autómata.

digito (q0) -----\> (q1) ↑ \| digito \| └------


    ---

    # 8. Introducción a la teoría de lenguajes

    La teoría de lenguajes clasifica los lenguajes formales.

    ## Jerarquía de Chomsky

    1. Lenguajes Regulares
    2. Lenguajes Libres de Contexto
    3. Lenguajes Sensibles al Contexto
    4. Lenguajes Recursivamente Enumerables

    Los analizadores léxicos utilizan **lenguajes regulares**.

    ---

    # 9. Expresiones regulares

    Las **expresiones regulares** describen patrones dentro de cadenas.

    Ejemplo:

a\*


    Significa:

ε a aa aaa


    ---

    ## Operadores principales

    ### Unión

a\|b


    Acepta:

a b


    ---

    ### Concatenación

ab


    Acepta:

ab


    ---

    ### Cerradura de Kleene

a\*


    Repetición infinita.

    ---

    # 10. Expresiones regulares y AFN

    Las expresiones regulares pueden transformarse en **autómatas finitos no determinísticos (AFN)**.

    Proceso:

Expresión Regular ↓ AFN ↓ AFD ↓ Analizador Léxico


    ---

    ## Autómata Finito No Determinístico

    Un **AFN** permite:

    - múltiples transiciones
    - transiciones vacías (ε)

    Ejemplo:

    Expresión:

a\|b


    Acepta:

a b


    ---

    # 11. Ejemplo práctico de analizador léxico en Java

    ```java
    import java.util.StringTokenizer;

    public class Lexer {

        public static void main(String[] args) {

            String codigo = "int x = 10 + 20;";

            StringTokenizer tokenizer = new StringTokenizer(codigo," +-;=",true);

            while(tokenizer.hasMoreTokens()){

                String token = tokenizer.nextToken();

                if(token.matches("[0-9]+"))
                    System.out.println("NUMERO: " + token);

                else if(token.matches("[a-zA-Z][a-zA-Z0-9]*"))
                    System.out.println("IDENTIFICADOR: " + token);

                else
                    System.out.println("SIMBOLO: " + token);

            }
        }
    }

------------------------------------------------------------------------

# Conclusión

El análisis léxico es fundamental en el diseño de compiladores porque:

-   transforma el código fuente en tokens
-   detecta errores léxicos
-   simplifica el análisis sintáctico
-   utiliza expresiones regulares y autómatas

Comprender esta fase permite desarrollar **scanners, intérpretes y
compiladores**.

------------------------------------------------------------------------

# Autor

Material de apoyo para la asignatura **Compiladores -- Ingeniería de
Software**.

# EJERCICIO-2
Ejercicio 2 de examen. 
Calculadora de Matrices
Esta es una aplicación de Java que permite realizar operaciones matriciales básicas. Dadas dos matrices A y C, la aplicación calcula la matriz B tal que A + B = C. Las matrices se leen desde archivos de texto en formato CSV, y el resultado se guarda en otro archivo de texto.

# Requisitos
Java Development Kit (JDK) 8 o superior.
JUnit 4 para ejecutar las pruebas unitarias.
Cómo ejecutar la aplicación
Clona el repositorio desde GitHub o descárgalo como archivo ZIP y descomprímelo.

Abre un terminal y navega hasta el directorio raíz del proyecto.

Compila el código fuente ejecutando el siguiente comando:

javac -d bin src/*.java
Ejecuta la aplicación con el siguiente comando:

java -cp bin MatrixCalculatorApp
Sigue las instrucciones en pantalla para proporcionar los nombres de archivo de las matrices A, B y C, así como el nombre de archivo de salida para la matriz B calculada.

El resultado de la multiplicación de matrices se guardará en el archivo especificado.

# Estructura del proyecto
El proyecto tiene la siguiente estructura de directorios:

src/: Contiene los archivos fuente de la aplicación.
bin/: Directorio donde se guardarán los archivos compilados.
test/: Contiene los archivos de prueba unitaria utilizando JUnit.
data/: Directorio donde se pueden colocar los archivos de matrices de entrada.
# Pruebas unitarias
El proyecto incluye pruebas unitarias para garantizar la funcionalidad correcta de la aplicación. Estas pruebas utilizan el framework JUnit 4.
Para ejecutar las pruebas unitarias, asegúrate de tener JUnit 4 en tu classpath y ejecuta el siguiente comando en el directorio raíz del proyecto:
java -cp bin:test org.junit.runner.JUnitCore MatrixCalculatorTest



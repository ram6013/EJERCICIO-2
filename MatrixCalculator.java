import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MatrixCalculator {
    private static final String FILE_A = "matrixA.txt";
    private static final String FILE_C = "matrixC.txt";
    private static final String FILE_B = "matrixB.txt";

    public static void main(String[] args) {
        try {
            // Leer las matrices A y C desde los archivos
            BigDecimal[][] matrixA = readMatrixFromFile(FILE_A);
            BigDecimal[][] matrixC = readMatrixFromFile(FILE_C);

            // Verificar si se pudieron leer las matrices correctamente
            if (matrixA == null || matrixC == null) {
                System.out.println("Error: No se pudieron leer las matrices correctamente.");
                return;
            }

            // Verificar si las dimensiones de las matrices son válidas para la multiplicación
            if (!areMatrixDimensionsValidForMultiplication(matrixA, matrixC)) {
                System.out.println("Error: Las dimensiones de las matrices no son compatibles para la multiplicación.");
                return;
            }

            // Calcular la matriz B mediante la multiplicación de las matrices A y C
            BigDecimal[][] matrixB = calculateMatrixMultiplication(matrixA, matrixC);

            // Escribir la matriz B en un archivo
            writeMatrixToFile(matrixB, FILE_B);

            System.out.println("La matriz B se ha calculado correctamente y se ha guardado en " + FILE_B);
        } catch (IOException e) {
            System.out.println("Error al leer o escribir en el archivo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error: Se esperaban valores numéricos en los archivos de matriz.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static BigDecimal[][] readMatrixFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int rows = Integer.parseInt(reader.readLine());
            int cols = Integer.parseInt(reader.readLine());
            BigDecimal[][] matrix = new BigDecimal[rows][cols];

            // Leer los valores de la matriz desde el archivo
            for (int i = 0; i < rows; i++) {
                line = reader.readLine();
                String[] values = line.split(",");
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = new BigDecimal(values[j]);
                }
            }

            return matrix;
        }
    }

    private static void writeMatrixToFile(BigDecimal[][] matrix, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            // Escribir las dimensiones de la matriz en el archivo
            writer.write(String.valueOf(rows));
            writer.newLine();
            writer.write(String.valueOf(cols));
            writer.newLine();

            // Escribir los valores de la matriz en el archivo
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    BigDecimal value = matrix[i][j].setScale(2, RoundingMode.HALF_UP);
                    writer.write(value.toString());
                    if (j < cols - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
        }
    }

    public static BigDecimal[][] calculateMatrixMultiplication(BigDecimal[][] matrixA, BigDecimal[][] matrixC) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsC = matrixC.length;
        int colsC = matrixC[0].length;

        BigDecimal[][] matrixB = new BigDecimal[rowsA][colsC];

        // Realizar la multiplicación de las matrices A y C para obtener la matriz B
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsC; j++) {
                matrixB[i][j] = BigDecimal.ZERO;
                for (int k = 0; k < colsA; k++) {
                    matrixB[i][j] = matrixB[i][j].add(matrixA[i][k].multiply(matrixC[k][j]));
                }
            }
        }

        return matrixB;
    }

    private static boolean areMatrixDimensionsValidForMultiplication(BigDecimal[][] matrixA, BigDecimal[][] matrixC) {
        int colsA = matrixA[0].length;
        int rowsC = matrixC.length;

        return colsA == rowsC;
    }
}

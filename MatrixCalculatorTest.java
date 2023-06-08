import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MatrixCalculatorTest {

    @Test
    public void testMatrixMultiplication() {
        // Matriz A
        BigDecimal[][] matrixA = {
                {new BigDecimal("1"), new BigDecimal("2")},
                {new BigDecimal("3"), new BigDecimal("4")}
        };

        // Matriz C
        BigDecimal[][] matrixC = {
                {new BigDecimal("5"), new BigDecimal("6")},
                {new BigDecimal("7"), new BigDecimal("8")}
        };

        // Matriz B resultante de la multiplicación
        BigDecimal[][] expectedMatrixB = {
                {new BigDecimal("19"), new BigDecimal("22")},
                {new BigDecimal("43"), new BigDecimal("50")}
        };

        // Calcular la matriz B utilizando el método de multiplicación
        BigDecimal[][] actualMatrixB = MatrixCalculator.calculateMatrixMultiplication(matrixA, matrixC);

        // Verificar que las matrices B sean iguales
        for (int i = 0; i < expectedMatrixB.length; i++) {
            Assert.assertArrayEquals(expectedMatrixB[i], actualMatrixB[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMatrixDimensions() {
        // Matriz A
        BigDecimal[][] matrixA = {
                {new BigDecimal("1"), new BigDecimal("2")},
                {new BigDecimal("3"), new BigDecimal("4")}
        };

        // Matriz C con dimensiones incompatibles para la multiplicación
        BigDecimal[][] matrixC = {
                {new BigDecimal("5"), new BigDecimal("6"), new BigDecimal("7")},
                {new BigDecimal("8"), new BigDecimal("9"), new BigDecimal("10")}
        };

        MatrixCalculator.calculateMatrixMultiplication(matrixA, matrixC);
    }
}

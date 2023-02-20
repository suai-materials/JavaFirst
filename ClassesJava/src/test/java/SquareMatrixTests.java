import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.SquareMatrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pankov Vasya
 * @author ChatGPT (help with math tests)
 */
@DisplayName("Тестирование матрицы")
public class SquareMatrixTests {
    @Test
    @DisplayName("Проверка инициализации")
    public void InitTest() throws Exception {
        SquareMatrix matrix = new SquareMatrix(2);
        int[][] myMatrix = new int[2][2];
        myMatrix[0][0] = 0;
        myMatrix[0][1] = 0;
        myMatrix[1][1] = 0;
        myMatrix[1][0] = 0;
        assertArrayEquals(matrix.get_matrix(), myMatrix);
        myMatrix[0][1] = 1;
        matrix = new SquareMatrix(2, myMatrix);
        assertArrayEquals(matrix.get_matrix(), myMatrix);
    }

    @Test
    @DisplayName("Проверка вывода в строку")
    public void StringTest() throws Exception {
        assertEquals((new SquareMatrix(1)).toString(), "[\n\t0\t\n]");
    }

    @Test
    @DisplayName("Проверка, верхнетреугольной или нижнетреугольной ли у нас матрица?")
    public void TriangularTest() throws Exception {
        int[][] myMatrix = {
                {1, 0},
                {1, 1}
        };
        SquareMatrix matrix = new SquareMatrix(2, myMatrix);
        assert matrix.IsBottomTriangular();
        assert !matrix.IsUpperTriangular();
    }

    @Nested
    @DisplayName("Математические тесты")
    public class MathTests{
        @Test
        @DisplayName("Сложение двух матриц")
        public void testAddition() throws Exception {
            int[][] a = {{1, 2}, {3, 4}};
            int[][] b = {{5, 6}, {7, 8}};
            SquareMatrix matrixA = new SquareMatrix(2, a);
            SquareMatrix matrixB = new SquareMatrix(2, b);
            SquareMatrix result = matrixA.add(matrixB);
            int[][] expected = {{6, 8}, {10, 12}};
            assertArrayEquals(expected, result.get_matrix());
        }

        @Test
        @DisplayName("Вычитание двух матриц")
        public void testSubtraction() throws Exception {
            int[][] a = {{1, 2}, {3, 4}};
            int[][] b = {{5, 6}, {7, 8}};
            SquareMatrix matrixA = new SquareMatrix(2, a);
            SquareMatrix matrixB = new SquareMatrix(2, b);
            SquareMatrix result = matrixA.subtract(matrixB);
            int[][] expected = {{-4, -4}, {-4, -4}};
            assertArrayEquals(expected, result.get_matrix());
        }

        @Test
        @DisplayName("Скалярное умножение матрицы")
        public void testScalarMultiplication() throws Exception {
            int[][] a = {{1, 2}, {3, 4}};
            SquareMatrix matrixA = new SquareMatrix(2, a);
            SquareMatrix result = matrixA.multiply(2);
            int[][] expected = {{2, 4}, {6, 8}};
            assertArrayEquals(expected, result.get_matrix());
        }

        @Test
        @DisplayName("Умножение матриц")
        public void testMatrixMultiplication() throws Exception {
            int[][] a = {{1, 2}, {3, 4}};
            int[][] b = {{5, 6}, {7, 8}};
            SquareMatrix matrixA = new SquareMatrix(2, a);
            SquareMatrix matrixB = new SquareMatrix(2, b);
            SquareMatrix result = matrixA.multiply(matrixB);
            int[][] expected = {{19, 22}, {43, 50}};
            assertArrayEquals(expected, result.get_matrix());
        }
    }
}

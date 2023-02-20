package org.example;


/** Класс квадратная матрица, поля класса – размерность и элементы матрицы.
 * Методы класса: проверка, является ли матрица верхнетреугольной или нижнетреугольной, вывод матрицы.
 * В классе предусмотреть методы: сложение, вычитание, умножение матриц, умножение матрицы на число.
 *
 * @author Vasya Pankov
 * @author ChatGPT(help) */
public class SquareMatrix {
    private int _n;

    public int get_n() {
        return _n;
    }

    private int[][] _matrix;

    public int[][] get_matrix() {
        return _matrix;
    }

    public void set_matrix(int[][] _matrix) throws Exception {
        if (_matrix.length != _n || _matrix[0].length != _n)
            throw new Exception("Вводимая матрица неподходит по размерности");
        this._matrix = _matrix;
    }

    public void set_n(int _n) throws Exception {
        if (_n <= 0) {
            throw new Exception("Размерность матрицы должна быть больше 0");
        }
        this._n = _n;
    }

    public SquareMatrix(int n) throws Exception {
        set_n(n);
        set_matrix(new int[n][n]);
    }

    public SquareMatrix(int n, int[][] matrixList) throws Exception {
        set_n(n);
        set_matrix(matrixList.clone());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("[\n");
        for (int[] list : get_matrix()) {
            output.append('\t');
            for (int el : list) {
                output.append(el + "\t");
            }
            output.append('\n');
        }

        output.append("]");
        return output.toString();
    }

    public boolean IsUpperTriangular() {
        for (int i = 0; i < _n; i++) {
            for (int j = 0; j < i; j++) {
                if (_matrix[i][j] != 0)
                    return false;
            }
        }

        return true;
    }

    // Это нижняя треугольная матрица?
    public boolean IsBottomTriangular() {
        for (int i = 0; i < _n; i++) {
            for (int j = _n - 1; j > i; j--) {
                if (_matrix[i][j] != 0)
                    return false;
            }
        }

        return true;
    }

    public SquareMatrix add(SquareMatrix squareMatrix2) throws Exception {
        if (squareMatrix2._n != this._n)
            throw new RuntimeException("Матрицы не совпадают по размерности");
        SquareMatrix newMatrix = new SquareMatrix(this._n);
        for (int i = 0; i < this._n; i++) {
            for (int j = 0; j < this._n; j++) {
                newMatrix._matrix[i][j] = this._matrix[i][j] + squareMatrix2._matrix[i][j];
            }
        }

        return newMatrix;

    }

    public SquareMatrix subtract(SquareMatrix squareMatrix2) throws Exception {
        if (squareMatrix2._n != this._n)
            throw new RuntimeException("Матрицы не совпадают по размерности");
        SquareMatrix newMatrix = new SquareMatrix(this._n);
        for (int i = 0; i < this._n; i++) {
            for (int j = 0; j < this._n; j++) {
                newMatrix._matrix[i][j] = this._matrix[i][j] - squareMatrix2._matrix[i][j];
            }
        }

        return newMatrix;
    }

    public SquareMatrix multiply(int n) throws Exception {
        SquareMatrix newMatrix = new SquareMatrix(this._n);
        for (int i = 0; i < this._n; i++) {
            for (int j = 0; j < this._n; j++) {
                newMatrix._matrix[i][j] = this._matrix[i][j] * n;
            }
        }

        return newMatrix;
    }

    public SquareMatrix multiply(SquareMatrix squareMatrix2) throws Exception {
        if (squareMatrix2._n != this._n)
            throw new RuntimeException("Матрицы не совпадают по размерности");
        SquareMatrix newMatrix = new SquareMatrix(this._n);
        for (int i = 0; i < this._n; i++) {
            for (int j = 0; j < this._n; j++) {
                int cellValue = 0;
                for (int j1 = 0; j1 < this._n; j1++) {
                    cellValue += this._matrix[i][j1] * squareMatrix2._matrix[j1][j];
                }

                newMatrix._matrix[i][j] = cellValue;
            }
        }

        return newMatrix;
    }
}
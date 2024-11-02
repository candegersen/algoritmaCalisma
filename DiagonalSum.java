
public class DiagonalSum {

    //ana köşede bulunan toplamın metodu
    public static int mainDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    //yan köşegeni toplayan metod 
    public static int antiDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int mainDiagonal = mainDiagonalSum(matrix);
        int antiDiagonal = antiDiagonalSum(matrix);

        System.out.println("Ana köşegenin toplamı: " + mainDiagonal);
        System.out.println("Yan köşegenin toplamı: " + antiDiagonal);

    }
}

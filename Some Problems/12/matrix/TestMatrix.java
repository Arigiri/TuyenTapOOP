package matrix;

public class TestMatrix {
    public static void main(String[] args) {
        java.util.Random random = new java.util.Random();
        int size = random.nextInt(6) + 5; // Generates a random number in [5, 10]

        MySquareMatrix matrix1 = new MySquareMatrix(size);
        MySquareMatrix matrix2 = new MySquareMatrix(size);

        System.out.println("Matrix 1:");
        System.out.println(matrix1);
        System.out.println("Transpose of Matrix 1:");
        System.out.println(matrix1.transpose());

        System.out.println("\nMatrix 2:");
        System.out.println(matrix2);
        System.out.println("Transpose of Matrix 2:");
        System.out.println(matrix2.transpose());

        System.out.println("\nPrincipal Diagonal of Matrix 1: " + java.util.Arrays.toString(matrix1.principalDiagonal()));
        System.out.println("Secondary Diagonal of Matrix 1: " + java.util.Arrays.toString(matrix1.secondaryDiagonal()));

        System.out.println("\nPrincipal Diagonal of Matrix 2: " + java.util.Arrays.toString(matrix2.principalDiagonal()));
        System.out.println("Secondary Diagonal of Matrix 2: " + java.util.Arrays.toString(matrix2.secondaryDiagonal()));

        System.out.println("\nSum of Matrix 1 and Matrix 2:");
        System.out.println(matrix1.add(matrix2));

        System.out.println("\nDifference of Matrix 1 and Matrix 2 (Matrix 1 - Matrix 2):");
        System.out.println(matrix1.minus(matrix2));

        System.out.println("\nProduct of Matrix 1 and Matrix 2:");
        System.out.println(matrix1.multiply(matrix2));

        System.out.println("\nPrime numbers in Matrix 1: " + java.util.Arrays.toString(matrix1.primes()));
        System.out.println("Prime numbers in Matrix 2: " + java.util.Arrays.toString(matrix2.primes()));

        /*
         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         Để lưu output vào file, bạn có thể chạy chương trình từ terminal và chuyển hướng output, ví dụ:
         javac matrix/*.java
         java matrix.TestMatrix > NguyenVanA_123456_Matrix.txt
         */
    }
}

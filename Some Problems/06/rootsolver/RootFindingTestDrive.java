package hus.oop.rootsolver;

public class RootFindingTestDrive {
    public static void main(String[] args) {
        /*
        TODO

        Chạy các hàm test để test chương trình.
        Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_RootFinding>.txt
        (ví dụ, NguyenVanA_123456_RootFinding.txt).
        Nén tất cả các file source code và file kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_RootFinding>.zip (ví dụ, NguyenVanA_123456_RootFinding.txt), và nộp bài
        lên classroom.
        */
        testRootSolver();
    }

    public static void testRootSolver() {
        /*
         TODO

         - Viết chương trình tìm nghiệm của hàm (sin(x).x - 3) theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           UnivariateRealRootFinding. Các phương pháp tìm nghiệm của thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, hàm và nghiệm của hàm tìm được.
         */
        System.out.println("f(x) = x * sin(x) - 3 = 0");
        AbstractFunction function =
                new UnivariateRealFunction();
        UnivariateRealRootFinding finding =
                new UnivariateRealRootFinding(function);
        finding.setRootSolver(
                new BisectionSolver(0.000001, 500));
        System.out.println("BisectionSolver Method: " + finding.solve(12, 14));
        finding.setRootSolver(
                new BisectionSolver(0.000001, 500));
        System.out.println("SecantSolver Method: " + finding.solve(12, 14));
        finding.setRootSolver(
                new NewtonRaphsonSolver(0.000001, 500));
        System.out.println("NewtonRaphsonSolver Method: " + finding.solve(12, 14));
    }
}

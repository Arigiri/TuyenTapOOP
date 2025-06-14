package integration;
import java.util.*;

public class TestIntegrationCalculator {
    private MyPolynomial polynomial;

    public TestIntegrationCalculator(MyPolynomial polynomial) {
        this.polynomial = polynomial;
    }

    public static void main(String[] args) {
        /* TODO
         - Thực hiện các yêu cầu trong từng hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        testArrayPolynomial();
        System.out.println();
        testListPolynomial();
        System.out.println();
        testIntegrationCalculator();
    }

    private static MyArrayPolynomial creatMyArrayPolynomial() {
        Random random = new Random();
        int degree = random.nextInt(10) + 1;
        MyArrayPolynomial polynomial = new MyArrayPolynomial();
        for (int i = 0; i <= degree; i++) {
            polynomial.append(random.nextInt(10) + 1);
        }
        return polynomial;
    }

    private static MyListPolynomial creatMyListPolynomial() {
        Random random = new Random();
        int degree = random.nextInt(10) + 1;
        MyListPolynomial polynomial = new MyListPolynomial();
        for (int i = 0; i <= degree; i++) {
            polynomial.append(random.nextInt(10) + 1);
        }
        return polynomial;
    }

    public static void testArrayPolynomial() {
        /* TODO
         - Sinh ngẫu nhiên một số nguyên, lưu vào biến size. Sinh ngẫu nhiên size số thực. Tạo đa thức kiểu MyArrayPolynomial
           với các hệ số là các số thực vừa sinh ra, lưu vào biến polynomial.
         - Viết chương trình test các chức năng đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - Tính tích phân xác định của đa thức được tạo ban đầu với các cận tích phân là 1.0 và 5.0.
         */
        System.out.println("testArrayPolynomial:");
        MyArrayPolynomial polynomial1 = creatMyArrayPolynomial();
        MyArrayPolynomial polynomial2 = creatMyArrayPolynomial();
        System.out.println("polynomial: " + polynomial1);
        System.out.println("polynomial 2: " + polynomial2);

        System.out.println("add: " + polynomial1.plus(polynomial2));
        System.out.println("minus: " + polynomial1.minus(polynomial2));
        System.out.println("times: " + polynomial1.multiply(polynomial2));
        System.out.println("polynomial with x = 2: " + polynomial1.evaluate(2));
    }

    public static void testListPolynomial() {
        /*
           - Tạo ra các đa thức MyListPolynomial, trong đó bậc của đa thức là số tự nhiên được sinh ngẫu nhiên trong đoạn [1, 10],
             và các hệ số của đa thức được sinh ngẫu nhiên trong đoạn [1, 10].
           - Viết chương trình test các chức năng của MyListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
             sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
             giá trị của x).
         */
        System.out.println("testListPolynomial:");
        MyListPolynomial polynomial1 = creatMyListPolynomial();
        MyListPolynomial polynomial2 = creatMyListPolynomial();
        System.out.println("polynomial: " + polynomial1);
        System.out.println("polynomial 2: " + polynomial2);

        System.out.println("add: " + polynomial1.plus(polynomial2));
        System.out.println("minus: " + polynomial1.minus(polynomial2));
        System.out.println("times: " + polynomial1.multiply(polynomial2));
        System.out.println("polynomial with x = 2: " + polynomial1.evaluate(2));
    }

    public static void testIntegrationCalculator() {
        /*
           - Tạo ra các đa thức MyArrayPolynomial và MyListPolynomial, trong đó bậc của đa thức là số tự nhiên được sinh
             ngẫu nhiên trong đoạn [1, 10], và các hệ số của đa thức được sinh ngẫu nhiên trong đoạn [1, 10].
           - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho
             (MidpointMethod, TrapezoidMethod, SimpsonMethod) sử dụng IntegrationCalculator. Các phương pháp tính tích phân
             có thể thay đổi ở thời gian chạy chương trình.
           - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
         */
        System.out.println("testIntegrationCalculator:");
        MyArrayPolynomial polynomial1 = creatMyArrayPolynomial();
        MyListPolynomial polynomial2 = creatMyListPolynomial();
        System.out.println("array polynomial: " + polynomial1);
        System.out.println("list polynomial: " + polynomial2);

        IntegrationCalculator calculator = new IntegrationCalculator(new MidpointRule(0.0001, 1000), polynomial1);
        System.out.println("MidpointRule: " + calculator.integrate(1, 2));
        calculator.setIntegrator(new TrapezoidRule(0.0001, 1000));
        System.out.println("TrapezoidRule: " + calculator.integrate(1, 2));
        calculator.setIntegrator(new SimpsonRule(0.0001, 1000));
        System.out.println("SimpsonRule: " + calculator.integrate(1, 2));
    }
}

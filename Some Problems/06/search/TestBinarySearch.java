package hus.oop.search;

import java.util.Arrays;

public class TestBinarySearch {
    public static void main(String[] args) {
        /* Yêu cầu:
        - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [20 - 30].
        - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
        - Tạo đối tượng có kiểu dữ liệu BinarySearch. Dùng đối tượng này test thuật toán tìm kiếm nhị phân với
          mảng dữ liệu đã sinh ra, và sử dụng 3 thuật toán sắp xếp khác nhau như đã cho.

          Các kết quả test được in ra terminal theo định dạng: ví dụ
          Using Bubble Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]
          Binary search giá trị 3.0: 2

          Using Insertion Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]
          Binary search giá trị 6.0:-1

        - Kết quả chạy chương trình lưu vào file text được đặt tên <TenSinhVien_MaSinhVien_BinarySearch.txt.
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BinarySearch>.zip (Ví dụ, NguyenVanA_123456_BinarySearch.zip),
          nộp lên classroom
         */
        double[] arr = generateArray();
        double[] arr2 = Arrays.copyOf(arr, arr.length);
        double[] arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Using Bubble Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(arr));
        BinarySearch.getInstance().setSorter(new BubbleSort());
        double searchValue = 2.23;
        double searchResult = BinarySearch.getInstance().search(arr, searchValue);
        System.out.println("After sorting: " + Arrays.toString(arr));
        System.out.println("Binary search value of " + searchValue + ": " + searchResult);

        System.out.println();
        System.out.println("Using Insertion Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(arr2));
        BinarySearch.getInstance().setSorter(new InsertionSort());
        searchValue = 3.23;
        searchResult = BinarySearch.getInstance().search(arr2, searchValue);
        System.out.println("After sorting: " + Arrays.toString(arr2));
        System.out.println("Binary search value of " + searchValue + ": " + searchResult);

        System.out.println();
        System.out.println("Using Selection Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(arr3));
        BinarySearch.getInstance().setSorter(new SelectionSort());
        searchValue = 4.23;
        searchResult = BinarySearch.getInstance().search(arr3, searchValue);
        System.out.println("After sorting: " + Arrays.toString(arr3));
        System.out.println("Binary search value of " + searchValue + ": " + searchResult);
    }

    public static double[] generateArray() {
        double[] array = new double[20 + ((int) (Math.random() * 11))];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.round(Math.random() * 10000) / 100.0;
        }
        return array;
    }
}

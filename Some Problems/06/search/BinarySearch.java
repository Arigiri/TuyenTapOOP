package hus.oop.search;

public class BinarySearch implements Search {
    private static BinarySearch instance;
    private Sorter sorter;

    private BinarySearch() {
        /* TODO */
        sorter = null;
    }

    /**
     * Tạo đối tượng BinarySearch.
     * @return
     */
    public static BinarySearch getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new BinarySearch();
        }
        return instance;
    }

    public void setSorter(Sorter sorter) {
        /* TODO */
        this.sorter = sorter;
    }

    @Override
    public int search(double[] data, double value) {
        sort(data);
        return binarySearch(data, value);
    }

    private int binarySearch(double[] data, double value) {
        /* TODO */
        sort(data);
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid] == value) {
                return mid;
            }
            if (data[mid] < value) {
                low = mid + 1;
            }
            if (data[mid] > value) {
                high = mid - 1;
            }
        }
        return -1;
    }

    private void sort(double[] data) {
        /* TODO */
        if (sorter != null) {
            sorter.sort(data, true);
        }
    }
}

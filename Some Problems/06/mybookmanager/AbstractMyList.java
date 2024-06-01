package hus.oop.mybookmanager;

public abstract class AbstractMyList implements MyList {
    /**
     * Phương thức kiểm tra xem index có nằm trong đoạn [0 - limit] không.
     * @param index
     * @param limit
     * @return
     */
    public boolean checkBoundaries(int index, int limit) {
        /* TODO */
        return index >= 0 && index <= limit;
    }

    public String toString() {
        /* TODO */
        StringBuilder result = new StringBuilder();
        int length = size();
        result.append("[");
        for (int i = 0; i < length; i++) {
            result.append(get(i));
            if (i < length - 1) {
                result.append("] [");
            }
        }
        result.append("]");
        return result.toString();
    }
}

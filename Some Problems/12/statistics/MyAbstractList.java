package statistics;

public abstract class MyAbstractList implements MyList {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        MyIterator iterator = iterator(0);
        if (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        while (iterator.hasNext()) {
            sb.append(" ").append(iterator.next());
        }
        sb.append("]");
        return sb.toString();
    }
}

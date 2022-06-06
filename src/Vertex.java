public class Vertex<T> {
    private T label;
    private int index;

    public Vertex() {

    }

    public Vertex(T label, int index) {
        this.label = label;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                ", index=" + index +
                '}';
    }
}

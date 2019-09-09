import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author torrent
 * @date 19-9-8 下午2:43
 */
public class Stack<E> {
    private E[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack(int capacity) {
        elements = (E[]) new Object[capacity];
        size = 0;
    }

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public void push(E e) {
        expandCapacity();
        elements[size++] = e;
    }

    private void expandCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    public E pop() {

        if (size == 0) {
            throw new EmptyStackException();
        }

        E res = elements[--size];
        elements[size] = null;

        reduceCapacity();

        return res;
    }

    private void reduceCapacity() {
        if (size <= elements.length / 2){
            elements = Arrays.copyOf(elements, elements.length / 2);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("capacity:");
        builder.append(size);
        builder.append("/");
        builder.append(elements.length);

        builder.append(" [");

        for (int i = 0; i < size; i++) {

            builder.append(elements[i]);
            if (i != size - 1) {
                builder.append(",");
            }

        }

        builder.append("]");
        return builder.toString();
    }

}

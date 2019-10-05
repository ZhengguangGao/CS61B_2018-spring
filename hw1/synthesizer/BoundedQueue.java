package synthesizer;

import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T> {

    int capacity();

    int fillCount();

    void enqueue(T x);

    T dequeue();

    T peek();

    Iterator<T> iterator();

    default boolean isEmpty() {

        boolean state = false;

        if (fillCount() == 0) {

            state = true;

        }

        return  state;

    }

    default boolean isFull() {

        boolean state = false;

        if (fillCount() == capacity()) {

            state = true;

        }

        return state;
    }


}

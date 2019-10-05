package synthesizer;

import java.util.Iterator;


public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {

    private int first;

    private int last;

    private T[] rb;

    public Iterator<T> iterator() {

        return new ArraySetIterator();

    }

    private class ArraySetIterator implements Iterator<T> {

        private int wizPos;

        public ArraySetIterator() {
            wizPos = first;
        }

        public boolean hasNext() {

            return wizPos != last;

        }

        public T next() {

            T returnItem = rb[wizPos];

            wizPos = (wizPos+1) % capacity;

            return returnItem;
        }

    }



    public ArrayRingBuffer(int capacity) {

        rb = (T[]) new Object[capacity];

        first = 0;

        last = 0;

        fillCount = 0;

        this.capacity = capacity;

    }



    public void enqueue(T x) {


        if (isFull()) {

            throw new RuntimeException("Ring Buffer Overflow");

        } else {

            rb[last] = x;

            last = (last + 1) % this.capacity;

            fillCount += 1;

        }

    }



    public T dequeue() {


        if (isEmpty()) {

            throw new RuntimeException("Ring Buffer Underflow");

        } else {

            T item = rb[first];

            rb[first] = null;

            first = (first + 1) % this.capacity;

            fillCount -= 1;

            return item;
        }

    }


    public T peek() {


        if (isEmpty()) {

            throw new RuntimeException("Ring Buffer Underflow");

        } else {

            return rb[first];

        }

    }

}

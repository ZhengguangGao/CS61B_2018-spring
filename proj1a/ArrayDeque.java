import java.security.PublicKey;

/*    private int size;

    private  T[] items;

    public ArrayDeque() {

        items = (T[]) new Object[8];

        size = 0;

    }

    private void resize(int capacity) {

        T[] a = (T[]) new Object[capacity];

        System.arraycopy(items,0, a, 0, size);

        items = null;

        items = a;

        a = null;

    }

    public boolean isEmpty() {

        boolean result = false;

        if (size == 0) {

            result = true;
        }

        return  result;
    }



    public int size() {

        return size;

    }

    public void addFirst(T x) {

        if (size == items.length) {

            resize(size*2);

        }

        System.arraycopy(items,0,items,1,size);

        items[0] = x;

        size += 1;

    }

    public void addLast(T x) {

        if (size == items.length) {

            resize(size*2);

        }

        items[size] = x;

        size += 1;

    }




    public T get (int index) {

        if (size == 0) {

            return null;

        } else {

            if (index >= size) {

                return  null;
            }

            return items[index];

        }

    }

    public T removeFirst() {

        if (size == 0) {

            return null;

        } else {

            T result = items[0];

            items[0] = null;

            System.arraycopy(items,1,items,0,size-1);

            items[size-1] = null;

            size -= 1;

            if ((float) size / (float) items.length <= 0.25 && size > 8) {

                resize(items.length/2);

            }

            return result;

        }
    }

    public T removeLast() {

        if (size == 0) {

            return null;

        } else {

            T result = items[size-1];

            items[size-1] = null;

            size = size-1;

            if ((float) size / (float) items.length <= 0.25 && size > 8) {

                resize(items.length/2);

            }

            return result;
        }
    }

    public void printDeque() {

        int flag = 0;

        for (int i = 0; i < size; i++) {

            if (flag == 0) {
                System.out.print(items[i]);
                flag = 1;
            } else {
                System.out.print(" ");
                System.out.print(items[i]);
            }
        }
    }*/

import java.util.Random;

public class ArrayDeque<T> {

    private int size;

    private int start;

    private int end;

    private  T[] items;


    public ArrayDeque() {

        items = (T[]) new Object[8];

        size = 0;

        start = 0;

        end = 0;

    }

    private void resize(int capacity) {

        T[] a = (T[]) new Object[capacity];

        if (end > start) {

            System.arraycopy(items,start,a,0,size);



        } else {

            System.arraycopy(items,start,a,0,(items.length - start));

            System.arraycopy(items,0,a,(items.length - start),end);


        }

        items = null;

        items = a;

        start = 0;

        end = size;

        a = null;

    }

    public boolean isEmpty() {

        boolean result = false;

        if (size == 0) {

            result = true;
        }

        return  result;
    }

    public int size() {

        return size;

    }



    public void addFirst(T x) {

        if (size == items.length) {

            resize(size*2);

        }

        items[(start-1+items.length) % items.length] = x;

        start = (start-1+items.length) % items.length;


        size += 1;

    }

    public void addLast(T x) {

        if (size == items.length) {

            resize(size * 2);

        }

        items[end] = x;

        end = (end + 1) % items.length;

        size += 1;

    }

    public T get (int index) {

        if (size == 0) {

            return null;

        } else {

            if (index >= size) {

                return  null;
            }

            return items[(start + index) % items.length];

        }

    }

    public T removeFirst() {

        if (size == 0) {

            return null;

        } else {

            T result = items[start];

            items[start] = null;

            size -= 1;

            start = (start + 1) % items.length;

            if ((float) size / (float) items.length <= 0.25 && items.length > 8) {

                resize(items.length/2);

            }

            return result;

        }
    }

    public T removeLast() {

        if (size == 0) {

            return null;

        } else {

            T result = items[(end-1+items.length) % items.length];

            items[(end-1+items.length) % items.length] = null;

            size = size-1;

            end = (end -1 + items.length) % items.length;

            if ((float) size / (float) items.length <= 0.25 && items.length > 8) {

                resize(items.length/2);

            }

            return result;
        }
    }

    public void printDeque() {

        int flag = 0;

        if (end > start) {

            for (int i = start; i < end; i++) {

                if (flag == 0) {

                    System.out.print(items[i]);

                    flag = 1;

                } else {

                    System.out.print(" ");

                    System.out.print(items[i]);
                }
            }

        } else {

            for (int i = start; i < items.length; i++) {

                if (flag == 0) {

                    System.out.print(items[i]);

                    flag = 1;
                } else {

                    System.out.print(" ");

                    System.out.print(items[i]);
                }
            }

            for (int i = 0; i < start; i++) {

                if (flag == 0) {

                    System.out.print(items[i]);

                    flag = 1;

                } else {

                    System.out.print(" ");

                    System.out.print(items[i]);
                }

            }

        }

    }





/*
    public static void main(String[] args) {

        Random rand = new Random();

        ArrayDeque<Integer> L = new ArrayDeque<>();
        ArrayDeque.addLast(0);
        ArrayDeque.addFirst(1);
        ArrayDeque.addFirst(2);
        ArrayDeque.get(1);
        ArrayDeque.removeLast();
        ArrayDeque.addLast(5);
        ArrayDeque.removeLast();
        ArrayDeque.removeFirst();
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(9);
        ArrayDeque.removeLast();
        ArrayDeque.addLast(11);
        ArrayDeque.get(0);
        ArrayDeque.removeLast();
        ArrayDeque.addFirst(14);
        ArrayDeque.addLast(15);
        ArrayDeque.removeFirst();
        ArrayDeque.addLast(17);
        ArrayDeque.get(0);
        ArrayDeque.get(0);
        ArrayDeque.addLast(20);
        ArrayDeque.get(2);
        ArrayDeque.addFirst(22);
        System.out.println(ArrayDeque.removeLast());


        for (int i = 0; i < 256; i++) {
            int rd = rand.nextDouble() > 0.5 ? 1 : 0;
            if (rd == 1) {
                L.addFirst(i);
            } else {
                L.addLast(i);
            }
        }

        for (int i = 0; i < 190; i++) {
            System.out.println(L.removeFirst());
            //System.out.println(L.removeLast());
        }

        for (int i = 0; i < 66; i++) {
            System.out.println(L.removeFirst());
            //System.out.println(L.removeLast());
        }






    }*/


}


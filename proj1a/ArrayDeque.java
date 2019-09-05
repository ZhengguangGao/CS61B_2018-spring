import java.security.PublicKey;

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

            System.arraycopy(items,start,a,start,size);

        } else {

            System.arraycopy(items,start,a,start,(items.length - start));

            System.arraycopy(items,0,a,items.length,start);
        }

        items = null;

        items = a;

        end = start+size;

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

        if (start == 0) {

            items[items.length-1] = x;

            start = items.length-1;

        } else {

            items[start-1] = x;

            start = start - 1;

        }

        size += 1;

    }

    public void addLast(T x) {

        if (size == items.length) {

            resize(size*2);

        }

        if (end < items.length) {

            items[end] = x;

            end = end + 1;

        } else {

            items[0] = x;

            end = 0;

        }

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

            T result = items[(end-1+items.length) % items.length];

            items[(end-1+items.length) % items.length] = null;

            size = size-1;

            end = (end -1 + items.length) % items.length;

            if ((float) size / (float) items.length <= 0.25 && size > 8) {

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




/*    public static void main(String[] args) {

        ArrayDeque<Integer> L = new ArrayDeque<>();

        for (int i = 0; i < 256; i++) {
            L.addLast(i);
        }

        for (int i = 0; i < 190; i++) {
            L.removeLast();
        }

        for (int i = 0; i < 3; i++) {
            L.removeFirst();
        }



*//*        for (int i = 0; i < 2; i++) {
            L.removeFirst();
        }

        //L.removeLast();

        System.out.println((float) 10 / (float) 128);*//*

        System.out.println(L.get(0));



    }*/


}


public class LinkedListDeque<T> {

    private class IntNode {

        public IntNode prev;

        public T item;

        public IntNode next;

        public IntNode(IntNode p, T i, IntNode n) {

            prev = p;

            item = i;

            next = n;

        }

    }



    /* The first item (if it exists) is at sentinel.next. */

    private IntNode sentinel;

    private int size;





    /** Creates an empty SLList. */

    public LinkedListDeque() {

        sentinel = new IntNode(null,null,null);

        sentinel.next = sentinel;

        sentinel.prev = sentinel;

        size = 0;

    }

    /** Adds x to the front of the list. */

    public void addFirst(T x) {

        IntNode ptr = sentinel;

        if (ptr == ptr.next) {

            ptr.next = new IntNode(sentinel,x,sentinel);

            ptr.prev = ptr.next;

        } else {

            IntNode item = new IntNode(sentinel,x,ptr.next);

            //ptr.next = new IntNode(sentinel,x,ptr.next);

            ptr.next = item;

            ptr.next.next.prev = item;

        }

        size += 1;

    }


    /** Adds x to the last of the list. */

    public void addLast(T x) {

        sentinel.prev.next = new IntNode(sentinel.prev,x,sentinel);

        sentinel.prev = sentinel.prev.next;

        size += 1;

    }


    /** isEmpty() is to determine if the linked list is empty.*/

    public boolean isEmpty() {

        boolean result = false;

        if (sentinel.next == sentinel) {

            result = true;

        }

        return result;

    }



    public int size() {

        return size;

    }


    /** Print the items of the link from the first to the last.*/

    public void printDeque() {

        printDequeHelper(sentinel.next);

    }
    private void printDequeHelper(IntNode L) {

        if (L == sentinel) {

            //System.out.println("The List is empty");

            return;

        } else {

            int flag =0;

            while(L != sentinel){

                if (flag == 0) {

                    System.out.print(L.item);

                    flag = 1;
                } else{

                    System.out.print(" ");

                    System.out.print(L.item);

                }

                L = L.next;

            }
        }
    }

    public T removeFirst() {

        if (sentinel != sentinel.next) {

            size -= 1;

        }

        T result = sentinel.next.item;

        sentinel.next = sentinel.next.next;

        return result;

    }

    public T removeLast() {

        if (sentinel.next != sentinel.prev) {

            size -= 1;

        }

        T result = sentinel.prev.item;

        //sentinel.prev.prev.next = sentinel;

        sentinel.prev = sentinel.prev.prev;

        return result;

    }

    public T get(int index) {

        IntNode ptr = sentinel.next;

        while (ptr != sentinel) {

            if (index == 0) {

                return ptr.item;

            } else {

                index -= 1;

                ptr = ptr.next;

            }
        }

        return ptr.item;
    }

    public T getRecursive(int index) {

        T result = getRecursiveHelper(sentinel.next, index);

        return  result;

    }

    private T getRecursiveHelper(IntNode L, int m) {

        if (L == sentinel) {

            return  null;

            } else {

            if (m==0) {

                return L.item;

            } else {

                return getRecursiveHelper(L.next, m-1);
            }

        }
    }

/**

    public static void main(String[] args) {


        LinkedListDeque<Integer> L = new LinkedListDeque<>();

        L.addFirst(0);
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addFirst(4);
        System.out.println(L.removeLast());
        System.out.println(L.removeLast());

    }
    **/

}

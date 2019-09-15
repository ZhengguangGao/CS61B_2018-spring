public interface Deque<Item> {

    public void addFirst(Item item);

    public void addLast(Item item);

    public boolean isEmpty();

    public int size();

    public void printDeque();

    public Item removeFirst();

    public Item removeLast();

    public Item get(int index);

    public class ArrayDeque<Item> implements Deque<Item>{

        private int size;

        private int start;

        private int end;

        private  Item[] items;

        public ArrayDeque() {

            items = (Item[]) new Object[8];

            size = 0;

            start = 0;

            end = 0;

        }

        private void resize(int capacity) {

            Item[] a = (Item[]) new Object[capacity];

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

        @Override
        public boolean isEmpty() {

            boolean result = false;

            if (size == 0) {

                result = true;
            }

            return  result;
        }

        @Override
        public int size() {

            return size;

        }

        @Override
        public void addFirst(Item x) {

            if (size == items.length) {

                resize(size*2);

            }

            items[(start-1+items.length) % items.length] = x;

            start = (start-1+items.length) % items.length;


            size += 1;

        }

        @Override
        public void addLast(Item x) {

            if (size == items.length) {

                resize(size * 2);

            }

            items[end] = x;

            end = (end + 1) % items.length;

            size += 1;

        }

        @Override
        public Item get (int index) {

            if (size == 0) {

                return null;

            } else {

                if (index >= size) {

                    return  null;
                }

                return items[(start + index) % items.length];

            }

        }

        @Override
        public Item removeFirst() {

            if (size == 0) {

                return null;

            } else {

                Item result = items[start];

                items[start] = null;

                size -= 1;

                start = (start + 1) % items.length;

                if ((float) size / (float) items.length <= 0.25 && items.length > 8) {

                    resize(items.length/2);

                }

                return result;

            }
        }

        @Override
        public Item removeLast() {

            if (size == 0) {

                return null;

            } else {

                Item result = items[(end-1+items.length) % items.length];

                items[(end-1+items.length) % items.length] = null;

                size = size-1;

                end = (end -1 + items.length) % items.length;

                if ((float) size / (float) items.length <= 0.25 && items.length > 8) {

                    resize(items.length/2);

                }

                return result;
            }
        }

        @Override
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

    }

}

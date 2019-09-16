import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayDequeGold {

    StudentArrayDeque<Integer> std1 = new StudentArrayDeque<>();

    ArrayDequeSolution<Integer> std2 = new ArrayDequeSolution<>();

    Integer item1;

    Integer item2;


    @Test
    public void testArrayDequeGold() {

        for (int i = 0; i < 10; i += 1) {

            double seed1 = StdRandom.uniform();

            if (seed1 < 0.5) {

                std1.addLast(i);

                std2.addLast(i);

                System.out.printf("addLast(%d)\n",i);

            } else {

                std1.addFirst(i);

                std2.addFirst(i);

                System.out.printf("addFirst(%d)\n",i);
            }
        }

        for (int j = 0; j < 10; j++) {

            double seed2 = StdRandom.uniform();

            if (seed2 < 0.5) {

                Integer item1 = std1.removeFirst();

                Integer item2 = std2.removeFirst();

                System.out.printf("removeFirst()\n");

                assertEquals(item2, item1);


            } else {

                Integer item1 = std1.removeLast();

                Integer item2 = std2.removeLast();

                System.out.printf("removeLast()\n");

                assertEquals(item2, item1);

            }

        }


    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestArrayDequeGold.class);
    }



}

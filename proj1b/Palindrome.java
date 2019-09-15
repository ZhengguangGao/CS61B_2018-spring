public class Palindrome {

    public Deque<Character> wordToDeque(String word) {

        Deque<Character> array = new Deque.ArrayDeque<>();

        for (int i = 0; i < word.length(); i++) {

            Character item = word.charAt(i);

            array.addLast(item);

        }

        return array;

    }

    public boolean isPalindrome(String word) {

        Deque<Character> array = wordToDeque(word);

        Deque<Character> arrayReverse = new Deque.ArrayDeque<>();

        for (int i = 0; i < word.length(); i++) {
            arrayReverse.addFirst(word.charAt(i));
        }


        for (int i = 0; i < word.length(); i++) {
            Character a = array.removeFirst();
            Character re = arrayReverse.removeFirst();
            if (re!= a) {
                return false;
            }


        }

        return true;



    }

    public boolean isPalindrome(String word, CharacterComparator cc) {

        if (word == null || word.length() == 1) {

            return true;

        }

        int index = word.length();

        if (index % 2 == 1) {

            index = index / 2;

        }


        Deque<Character> array = wordToDeque(word);

        Deque<Character> arrayReverse = new Deque.ArrayDeque<>();

        for (int i = 0; i < word.length(); i++) {

            arrayReverse.addFirst(word.charAt(i));

        }


        for (int i = 0; i < index; i++) {

            Character a = array.removeFirst();

            Character re = arrayReverse.removeFirst();

            if (cc.equalChars(a,re) == false) {

                return false;

            }

        }

        return true;

    }


}

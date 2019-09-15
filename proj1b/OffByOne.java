public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {

        int flag = x -y;

        if (flag == 1 || flag == -1) {

            return true;

        }

        return false;

    }

}

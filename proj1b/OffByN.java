public class OffByN implements CharacterComparator{

    private int gap;

    public OffByN(int N) {

        gap = N;

    }

    @Override

    public boolean equalChars(char x, char y) {

        int flag = x -y;

        if (flag == gap || flag == -gap) {

            return true;

        }

        return false;

    }

}

import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {

    @Test

    public void testisSameNumber() {
        int a = 128;
        int b = 0;
        int c = 3;
        int d = 128;
        assertTrue(Flik.isSameNumber(a,d));
        assertFalse(Flik.isSameNumber(a,b));
        assertFalse(Flik.isSameNumber(a,c));
    }

}

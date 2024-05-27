package current;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.current.Solution.createReadableString;

public class TestCreateReadableString {

    @Test
    void testCreateReadableString() {
        int[] t1 = new int[]{1};
        int[] t2 = new int[]{2};
        int length = 4;
        String readableString = createReadableString(t1, t2, length);
        Assertions.assertEquals(readableString, "0vv0");
    }
}

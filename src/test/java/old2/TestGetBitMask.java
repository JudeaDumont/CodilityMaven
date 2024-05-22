package old2;

import org.example.old2.Old2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestGetBitMask {
    @Test
    void TestGetBitmask() {
        Old2 s = new Old2();
        Assertions.assertEquals("[0]", Arrays.toString(s.getBitmask(
                1
        )));
    }
}

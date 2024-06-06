package leetcode.ZigZagConvert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.leetcode.ZigzagString.zigzagString.convert;

public class TestZigZagConvert {
    @Test
    void testZigZagConvert(){

        String s = convert("paypalishiring", 3);
        Assertions.assertEquals(s, "pahnaplsiigyir");
    }
    @Test
    void testZigZagConvert2(){

        String s = convert("a", 1);
        Assertions.assertEquals(s, "a");
    }

    @Test
    void testZigZagConvert3(){

        String s = convert("ab", 1);
        Assertions.assertEquals(s, "ab");
    }
}

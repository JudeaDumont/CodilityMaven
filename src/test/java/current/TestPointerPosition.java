package current;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.example.current.Solution.getStationaryPointerPositions;
import static org.example.current.Solution.getInbetweenPointerPositions;

public class TestPointerPosition {
    @Test
    void testGetPointerPositions(){
        int[] pointerPositions = getStationaryPointerPositions(7);
        Assertions.assertEquals(Arrays.toString(pointerPositions), "[6]");
    }
    @Test
    void testGetPointerPositions2(){
        int[] pointerPositions = getStationaryPointerPositions(14);
        Assertions.assertEquals(Arrays.toString(pointerPositions), "[6, 13]");
    }
    @Test
    void testGetPointerPositions3(){
        int[] pointerPositions = getStationaryPointerPositions(8);
        Assertions.assertEquals(Arrays.toString(pointerPositions), "[6]");
    }
    @Test
    void testGetPointerPositions4(){
        int[] pointerPositions = getStationaryPointerPositions(13);
        Assertions.assertEquals(Arrays.toString(pointerPositions), "[6]");
    }
    @Test
    void testGetPointerPositions5(){
        int[] pointerPositions = getStationaryPointerPositions(20);
        Assertions.assertEquals(Arrays.toString(pointerPositions), "[6, 13]");
    }
    @Test
    void testGetPointerPositions6(){
        int[] pointerPositions = getInbetweenPointerPositions(new int[]{6, 13});
        Assertions.assertEquals(Arrays.toString(pointerPositions), "[0, 7]");
    }
}

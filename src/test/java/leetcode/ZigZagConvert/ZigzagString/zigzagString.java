package leetcode.ZigZagConvert.ZigzagString;

import java.util.ArrayList;

public class zigzagString {
    //3
    //P   A   H   N
    //A P L S I I G
    //Y   I   R

    // pahnaplsiigyir

    //4
    //P    I     N
    //A  L S   I G
    //Y A  H R
    //P    I

    //0, 4, 8, 12
    //1, 3, 5, 7, 9, 11, 13
    //2, 6, 10

    //0, 6, 12
    //1, 5, 7, 11, 13
    //2, 4, 8, 10
    //3, 9
    public static String convert(String from, int rows) {

        if(rows == 1){
            return from;
        }
        ArrayList<StringBuilder> words = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            words.add(new StringBuilder());
        }
        boolean upTrueDownFalse = true;
        int iterator = 0;
        for (int i = 0; i < from.length(); i++) {
            words.get(iterator).append(from.charAt(i));
            if (upTrueDownFalse) {
                ++iterator;
                if (iterator == words.size() - 1) {
                    upTrueDownFalse = false;
                }
            } else {
                --iterator;
                if (iterator == 0) {
                    upTrueDownFalse = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder word : words) {
            sb.append(word.toString());
        }
        return sb.toString();
    }
}

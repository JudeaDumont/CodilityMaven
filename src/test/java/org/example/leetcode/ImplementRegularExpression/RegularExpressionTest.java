package org.example.leetcode.ImplementRegularExpression;

import org.junit.jupiter.api.Test;

import static org.example.leetcode.ImplementRegularExpression.ImplementRegularExpression.RegularExpression.isMatch;

class RegularExpressionTest {

    @Test
    public void testRegularExpression() {
        isMatch("greeen","gre*n");
    }
}
package com.edaakyil.generator.range;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntRangeTest {
    @Test
    public void givenValues_whenParameters_thenIterate()
    {
        var a = 10;
        var b = 20;
        var index = 0;

        for (int val : IntRange.of(a, b)) {
            System.out.printf("%d ", val);
            assertEquals(a + index++, val);
        }

        System.out.println();
    }
}

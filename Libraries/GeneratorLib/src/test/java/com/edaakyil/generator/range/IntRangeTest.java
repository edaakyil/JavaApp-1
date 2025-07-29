package com.edaakyil.generator.range;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntRangeTest {
    @Test
    public void givenValues_whenBounds_thenIterate()
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

    @Test
    public void givenValues_whenBoundsAndStep_thenIterate()
    {
        var a = 10;
        var b = 21;
        var index = 0;

        for (int val : IntRange.of(a, b, 2)) {
            System.out.printf("%d ", val);
            assertEquals(a + index++ * 2, val);
        }

        System.out.println();
    }
}

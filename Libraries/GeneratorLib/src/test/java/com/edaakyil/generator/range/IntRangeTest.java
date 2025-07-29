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
        var b = 23;
        var step = 3;
        var index = 0;

        for (int val : IntRange.of(a, b, step)) {
            System.out.printf("%d ", val);
            assertEquals(a + index++ * step, val);
        }

        System.out.println();
    }

    @Test
    public void givenValues_whenBoundsAndOperator_thenIterate()
    {
        var a = 10;
        var b = 23;
        var step = 2;
        var index = 0;

        for (int val : IntRange.of(a, b, val -> val + step)) {
            System.out.printf("%d ", val);
            assertEquals(a + index++ * step, val);
        }

        System.out.println();
    }
}

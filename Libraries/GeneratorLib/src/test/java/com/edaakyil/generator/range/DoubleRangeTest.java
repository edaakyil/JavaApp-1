package com.edaakyil.generator.range;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@Ignore("Tested before")
public class DoubleRangeTest {
    @Test
    public void givenValues_whenBoundsAndOperator_thenIterate()
    {
        var a = -2 * Math.PI;
        var b = 2 * Math.PI;
        var delta = 0.001;
        var index = 0;

        for (double val : DoubleRange.of(a, b, delta)) {
            System.out.println(Math.sin(val));
        }

        System.out.println();
    }
}

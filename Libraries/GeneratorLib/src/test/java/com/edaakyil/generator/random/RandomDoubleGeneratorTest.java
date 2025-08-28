package com.edaakyil.generator.random;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Ignore("Tested before")
public class RandomDoubleGeneratorTest {
    @Test
    public void givenValue_whenOriginBoundCountAndRandomGenerator_thenIterate()
    {
        var count = 1_000_000;
        var origin = 2.3456;
        var bound = 2.345601;
        var arr = new double[count];
        var index = 0;

        for (double val : RandomDoubleGenerator.of(new Random(), origin, bound, count))
            arr[index++] = val;

        System.out.println();

        assertTrue(Arrays.stream(arr).allMatch(val -> origin <= val && val < bound)); // tüm değerlerin bu koşulu sağlayıp sağlamadığına geri dönüyor
        assertEquals(count, arr.length); // count tane üretildimi diye bakıyoruz
    }
}

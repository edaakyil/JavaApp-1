package com.edaakyil.generator.random;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomIntGeneratorTest {
    @Test
    public void givenValue_whenOriginBoundCountAndRandomGenerator_thenIterate()
    {
        var count = 5;
        var origin = 0;
        var bound = 100;
        var arr = new int[count];
        var index = 0;

        for (int val : RandomIntGenerator.of(new Random(), origin, bound, count)) {
            System.out.printf("%d ", val);
            arr[index++] = val;
        }

        System.out.println();

        assertTrue(Arrays.stream(arr).allMatch(val -> origin <= val && val < bound)); // tüm değerlerin bu koşulu sağlayıp sağlamadığına geri dönüyor
        assertEquals(count, arr.length); // count tane üretildimi diye bakıyoruz
    }
}

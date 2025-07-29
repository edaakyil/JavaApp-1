package com.edaakyil.generator.range;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntRange implements Iterable<Integer> {
    private final int m_a;
    private final int m_b;
    private final int m_step;

    private IntRange(int a, int b, int step)
    {
        m_a = a;
        m_b = b;
        m_step = step;
    }

    public static IntRange of(int a, int b)
    {
        return of(a, b, 1);
    }

    public static IntRange of(int a, int b, int step)
    {
        if (a > b)
            throw new IllegalArgumentException(String.format("a cannot be greater than b: a = %d, b = %d", a, b));

        return new IntRange(a, b, step);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int index;  // index start with 0

            @Override
            public boolean hasNext()
            {
                return m_a + index * m_step <= m_b;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such element!...");

                return m_a + index++ * m_step;
            }
        };
    }
}
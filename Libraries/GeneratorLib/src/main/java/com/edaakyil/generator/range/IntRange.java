package com.edaakyil.generator.range;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.IntUnaryOperator;

public class IntRange implements Iterable<Integer> {
    private final int m_a;
    private final int m_b;
    private final IntUnaryOperator m_intUnaryOperator;

    private IntRange(int a, int b, IntUnaryOperator intUnaryOperator)
    {
        m_a = a;
        m_b = b;
        m_intUnaryOperator = intUnaryOperator;
    }

    public static IntRange of(int a, int b)
    {
        return of(a, b, 1);
    }

    public static IntRange of(int a, int b, int step)
    {
        if (step <= 0)
            throw new IllegalArgumentException(String.format("Step must be positive: %d", step));

        return of(a, b, val -> val + step);
    }

    public static IntRange of(int a, int b, IntUnaryOperator intUnaryOperator)
    {
        if (a > b)
            throw new IllegalArgumentException(String.format("a cannot be greater than b: a = %d, b = %d", a, b));

        return new IntRange(a, b, intUnaryOperator);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int index;  // index start with 0

            @Override
            public boolean hasNext()
            {
                return m_a + index <= m_b;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such element!...");

                var result = m_a + index;
                index = m_intUnaryOperator.applyAsInt(index);

                return result;
            }
        };
    }
}
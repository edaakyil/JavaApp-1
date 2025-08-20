package com.edaakyil.generator.range;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.IntUnaryOperator;

public class IntRange implements Iterable<Integer> {
    private final int m_a;
    private final int m_b;
    private final IntUnaryOperator m_unaryOperator;

    private IntRange(int a, int b, IntUnaryOperator unaryOperator)
    {
        m_a = a;
        m_b = b;
        m_unaryOperator = unaryOperator;
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

    public static IntRange of(int a, int b, IntUnaryOperator unaryOperator)
    {
        if (a > b)
            throw new IllegalArgumentException(String.format("a cannot be greater than b: a = %d, b = %d", a, b));

        return new IntRange(a, b, unaryOperator);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int value = m_a;

            @Override
            public boolean hasNext()
            {
                return value <= m_b;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such element!...");

                var result = value;
                value = m_unaryOperator.applyAsInt(value);

                return result;
            }
        };
    }
}
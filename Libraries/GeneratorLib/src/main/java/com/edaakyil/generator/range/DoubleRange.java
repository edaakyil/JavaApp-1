package com.edaakyil.generator.range;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.DoubleUnaryOperator;

public class DoubleRange implements Iterable<Double> {
    private final double m_a;
    private final double m_b;
    private final DoubleUnaryOperator m_unaryOperator;

    private DoubleRange(double a, double b, DoubleUnaryOperator unaryOperator)
    {
        m_a = a;
        m_b = b;
        m_unaryOperator = unaryOperator;
    }

    public static DoubleRange of(double a, double b, double delta)
    {
        if (delta <= 0)
            throw new IllegalArgumentException(String.format("Step must be positive: %d", delta));

        return of(a, b, val -> val + delta);
    }

    public static DoubleRange of(double a, double b, DoubleUnaryOperator unaryOperator)
    {
        if (a > b)
            throw new IllegalArgumentException(String.format("a cannot be greater than b: a = %d, b = %d", a, b));

        return new DoubleRange(a, b, unaryOperator);
    }

    @Override
    public Iterator<Double> iterator()
    {
        return new Iterator<>() {
            double value = m_a;

            @Override
            public boolean hasNext()
            {
                return value <= m_b;
            }

            @Override
            public Double next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such element!...");

                var result = value;
                value = m_unaryOperator.applyAsDouble(value);

                return result;
            }
        };
    }
}
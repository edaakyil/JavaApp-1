package com.edaakyil.generator.random;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;

public class RandomDoubleGenerator implements Iterable<Double> {
    private final double m_origin;
    private final double m_bound;
    private final int m_count;
    private final RandomGenerator m_randomGenerator;

    private RandomDoubleGenerator(RandomGenerator randomGenerator, double origin, double bound, int count)
    {
        m_origin = origin;
        m_bound = bound;
        m_count = count;
        m_randomGenerator = randomGenerator;
    }

    public static RandomDoubleGenerator of(RandomGenerator randomGenerator, double origin, double bound, int count)
    {
        return new RandomDoubleGenerator(randomGenerator, origin, bound, count);
    }

    @Override
    public Iterator<Double> iterator()
    {
        return new Iterator<>() {
            int count;

            @Override
            public boolean hasNext()
            {
                return count < m_count;
            }

            @Override
            public Double next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("Can not generate a value!...");

                count++;

                return m_randomGenerator.nextInt(m_origin, m_bound);
            }
        };
    }
}

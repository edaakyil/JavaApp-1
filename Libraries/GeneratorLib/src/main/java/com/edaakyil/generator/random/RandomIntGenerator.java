package com.edaakyil.generator.random;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;

public class RandomIntGenerator implements Iterable<Integer> {
    private final int m_origin;
    private final int m_bound;
    private final int m_count;
    private final RandomGenerator m_randomGenerator;

    private RandomIntGenerator(RandomGenerator randomGenerator, int origin, int bound, int count)
    {
        m_origin = origin;
        m_bound = bound;
        m_count = count;
        m_randomGenerator = randomGenerator;
    }

    public static RandomIntGenerator of(RandomGenerator randomGenerator, int origin, int bound, int count)
    {
        return new RandomIntGenerator(randomGenerator, origin, bound, count);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int count;

            @Override
            public boolean hasNext()
            {
                return count < m_count;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("Can not generate a value!...");

                count++;

                return m_randomGenerator.nextInt(m_origin, m_bound);
            }
        };
    }
}

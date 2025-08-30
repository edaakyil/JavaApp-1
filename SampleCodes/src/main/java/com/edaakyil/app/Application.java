package com.edaakyil.app;

import java.util.Iterator;

public class Application {
    public static void main(String[] args)
    {
        var s = new Sample();

        for (var val : s)
            ;
    }
}

class Sample implements Iterable<Integer> {
    //...

    @Override
    public Iterator<Integer> iterator()
    {
        return null;
    }
}


package com.edaakyil;

import org.csystem.util.console.Console;

class Main {
    public static void main(String[] args)
    {
        A.foo(10);
    }
}

class A {
    //...
    public static void foo(int x)
    {
        Console.writeLine("A.foo");

        B.foo(x);
    }

    public static class B {
        //...
        private static void foo(int x)
        {
            Console.writeLine("B.foo");
        }
    }
}
package com.edaakyil.app;
import org.csystem.util.console.Console;

class Application {
    public static void main(String[] args)
    {
        var value = Console.readInt("Input a value: ");

        Sample s1 = new Sample() {
            // foo metodunu override ediyoruz
            public void foo()
            {
                Console.writeLine("Sample 1: %d", value);
            }
        };

        Sample s2 = new Sample() {
            // foo metodunu override ediyoruz
            public void foo()
            {
                Console.writeLine("Sample 2: %d", value);
            }
        };




        s1.foo();  // s1 üzerinden foo çağırılıyor - ilgili anonim sınıf nesnesine ilişkin override edilmiş metot çağırılacak
        s2.foo();  // s2 üzerinden foo çağırılıyor - ilgili anonim sınıf nesnesine ilişkin override edilmiş metot çağırılacak
    }
}

abstract class Sample {
    public abstract void foo();
}


/*


 */
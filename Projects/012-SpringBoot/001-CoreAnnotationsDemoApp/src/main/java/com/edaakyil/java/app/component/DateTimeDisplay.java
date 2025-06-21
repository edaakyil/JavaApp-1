package com.edaakyil.java.app.component;

import com.karandev.io.util.console.Console;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class DateTimeDisplay {
    public DateTimeDisplay()
    {
        Console.writeLine("I am a default ctor of DateTimeDisplay");
    }
}

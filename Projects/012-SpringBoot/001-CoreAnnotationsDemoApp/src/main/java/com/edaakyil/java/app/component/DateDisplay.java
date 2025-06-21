package com.edaakyil.java.app.component;

import com.karandev.io.util.console.Console;
import org.springframework.stereotype.Component;

@Component
public class DateDisplay {
    public DateDisplay()
    {
        Console.writeLine("I am a default ctor of DateDisplay");
    }
}

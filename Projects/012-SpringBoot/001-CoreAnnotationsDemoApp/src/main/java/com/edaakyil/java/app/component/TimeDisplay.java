package com.edaakyil.java.app.component;

import com.karandev.io.util.console.Console;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TimeDisplay {
    public TimeDisplay()
    {
        Console.writeLine("I am a default ctor of TimeDisplay");
    }
}

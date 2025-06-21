package com.edaakyil.java.app.component;

import com.karandev.io.util.console.Console;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TimeDisplay {
    public TimeDisplay()
    {
        Console.writeLine("I am a default ctor of TimeDisplay");
    }
}

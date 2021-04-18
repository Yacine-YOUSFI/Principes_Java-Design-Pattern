package fr.uvsq.poo.Builder_Composite_Iterator;

import java.time.LocalDateTime;

public class Logger implements  InterfaceLog{
    @Override
    public void write(String string) {
        System.out.println(LocalDateTime.now() + ": " + string);
    }
}
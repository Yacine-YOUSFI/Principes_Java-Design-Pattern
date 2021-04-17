package fr.uvsq.poo.Builder_Composite_Iterator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Serialiser {


    public static void main (String[] args) throws FileNotFoundException {
        Personnel ph ;


        ph = new Personnel.Builder("Jean", "Jacques", "Plombier")
                .dateNaissance(LocalDate.parse("1970-01-01", DateTimeFormatter.ISO_DATE)).build();
        System.out.println(ph);

        try {
            FileOutputStream fos= new FileOutputStream("pers.ser");
            ObjectOutputStream ops= new ObjectOutputStream(fos);

            ops.writeObject(ph);

            ops.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}


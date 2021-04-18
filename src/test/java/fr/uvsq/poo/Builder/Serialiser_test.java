package fr.uvsq.poo.Builder;

import fr.uvsq.poo.Builder_Composite_Iterator.NumeroTelephone;
import fr.uvsq.poo.Builder_Composite_Iterator.Personnel;
import fr.uvsq.poo.Builder_Composite_Iterator.Personnel_groupe;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class Serialiser_test {
    private Personnel p;
    private Personnel_groupe pg;
    @Before()
    public void setUp() {
        p = new Personnel.Builder("Jean", "Jacques", "Plombier").build();

        pg = new Personnel_groupe();
        Personnel_groupe qg = new Personnel_groupe();
        pg.addPersonnel(qg);
        pg.addPersonnel(p);
    }
    @Test
    public void test_Personnel_serialiser() {
        Personnel q = null;
        ObjectOutputStream oos;
        ObjectInputStream ois;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("pers.ser"));
            ois = new ObjectInputStream(new FileInputStream("pers.ser"));

            try {
                oos.writeObject(p);
                q = (Personnel) ois.readObject();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            } finally {
                oos.close();
                ois.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(p, q);
    }

    @Test()
    public void testSerializationPersonnelGroupe() {
        Personnel_groupe qg = null;
        ObjectOutputStream oos;
        ObjectInputStream ois;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("pers_grp.ser"));
            ois = new ObjectInputStream(new FileInputStream("pers_grp.ser"));

            try {
                oos.writeObject(pg);
                qg = (Personnel_groupe) ois.readObject();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            } finally {
                oos.close();
                ois.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(pg, qg);
    }


}


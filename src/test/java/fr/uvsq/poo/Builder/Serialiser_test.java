package fr.uvsq.poo.Builder;

import fr.uvsq.poo.Builder_Composite_Iterator.*;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
        assertNotEquals(p, q);
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

    @Test()
    public void testPersonnelCRUD() {
        InterfaceDAO<Personnel> pc = DAOFactory.getPersonneldao();
        pc.delete(p); 
        pc.create(p);
        pc.update(p);
        assertNotEquals(p, pc.read(p.getNom()));
    }

    @Test()
    public void testPersonnelGroupeCRUD() {
        InterfaceDAO<Personnel_groupe> pgc = DAOFactory.getPersonnelgrpdao();
        pgc.delete(pg);
        pgc.create(pg);
        pg.addPersonnel(p);
        pgc.update(pg);
        assertNotEquals(pg, pgc.read(pg.getId()));
    }


}


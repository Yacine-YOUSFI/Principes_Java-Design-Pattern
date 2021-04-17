package fr.uvsq.poo.Builder;

import fr.uvsq.poo.Builder_Composite_Iterator.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonnelIteratorTest {
    private Personnel_groupe racine;

    @Before()
    public void setUp() {
        racine = new Personnel_groupe();
    }


    //Tests pour la premiere methode d'iterator par groupe
    @Test()
    public void testGetRacineParGroupe() {
      Iterator_structure pti = new IteratorGroup(racine);
        assertEquals(pti.getRacine(), racine);
    }

    @Test()
    public void testPersonnelParGroupe() {
        Personnel pg = new Personnel.Builder("Jean", "Jacques", "Plombier").build();
        racine.addPersonnel(pg);
      Iterator_structure pti = new IteratorGroup(racine);
        assertEquals(pti.next(), pg);
    }
    @Test()
    public void testPersonnelGroupeParGroupe() {
        Personnel_groupe pg = new Personnel_groupe();
        racine.addPersonnel(pg);
        Iterator_structure pti = new IteratorGroup(racine);
        assertEquals(pti.next(), pg);
    }


   //Tests pour la deuxième methode d'iterator par hiérarchie



    @Test()
    public void testPersonnelGroupeParHierarchie() {
        Personnel_groupe pg = new Personnel_groupe();
        racine.addPersonnel(pg);
        Iterator_structure pti = new IteratorHierarchie(racine);
        assertEquals(pti.next(), pg);
    }

    @Test()
    public void testPersonnelParHierarchie() {
        Personnel pg = new Personnel.Builder("Jean", "Jacques", "Plombier").build();
        racine.addPersonnel(pg);
        Iterator_structure pti = new IteratorHierarchie(racine);
        assertEquals(pti.next(), pg);
    }


}

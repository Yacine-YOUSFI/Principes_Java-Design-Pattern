package fr.uvsq.poo.Builder_Composite_Iterator;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Personnel_groupe implements PersonnelInterface, Serializable {
    private final List<PersonnelInterface> personnelInterace;

    public Personnel_groupe() {
        personnelInterace = new ArrayList<PersonnelInterface>();
    }

    public void addPersonnel(PersonnelInterface p) {
        personnelInterace.add(p);
    }

    public void removePersonnel(PersonnelInterface p) {
        personnelInterace.remove(p);
    }

    public List<PersonnelInterface> getAllPersonnel() {
        return personnelInterace;

    }

    @Override
    public String Afficher() {
        return  "Plusieurs personnes";
    }
}

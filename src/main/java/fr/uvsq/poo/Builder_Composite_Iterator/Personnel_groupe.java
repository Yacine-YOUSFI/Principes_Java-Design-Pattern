package fr.uvsq.poo.Builder_Composite_Iterator;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.UUID;

public class Personnel_groupe implements PersonnelInterface, Serializable {
    private final List<PersonnelInterface> personnelInterace;
    private static final long serialVersionUID = 1L;
    private String identifier;
    public Personnel_groupe() {
        personnelInterace = new ArrayList<PersonnelInterface>();
    }
    public Personnel_groupe(String id) {
        personnelInterace = new ArrayList<PersonnelInterface>();
        this.identifier = id;
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
    public String getId(){

        return identifier.toString();
    }

    @Override
    public String Afficher() {

        return  "Plusieurs personnes";
    }
}

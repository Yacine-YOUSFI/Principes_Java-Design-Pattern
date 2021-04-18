package fr.uvsq.poo.Builder_Composite_Iterator;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.UUID;

public class Personnel_groupe implements PersonnelInterface, Serializable {
    private final List<PersonnelInterface> personnelInterace;
    private UUID id;

    public Personnel_groupe() {
        personnelInterace = new ArrayList<PersonnelInterface>();

    }
    public Personnel_groupe(String id) {
        personnelInterace = new ArrayList<PersonnelInterface>();
        this.id = UUID.fromString(id);
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
        return id.toString();
    }

    @Override
    public String Afficher() {
        return  "Plusieurs personnes";
    }
}

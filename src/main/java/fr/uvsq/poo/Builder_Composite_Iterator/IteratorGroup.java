package fr.uvsq.poo.Builder_Composite_Iterator;

import java.util.ArrayDeque;
import java.util.Collection;

public class IteratorGroup extends Iterator_structure{

    public IteratorGroup(Personnel_groupe personnelGrp) {
        super(personnelGrp, new ArrayDeque<PersonnelInterface>());
    }

    @Override
    protected PersonnelInterface getCollection() {
        return ((ArrayDeque<PersonnelInterface>) collection).remove();
    }
}

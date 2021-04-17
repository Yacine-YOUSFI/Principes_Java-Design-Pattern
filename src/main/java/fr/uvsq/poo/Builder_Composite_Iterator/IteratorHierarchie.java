package fr.uvsq.poo.Builder_Composite_Iterator;

import java.util.Collection;
import java.util.Stack;

public class IteratorHierarchie extends  Iterator_structure{
    public IteratorHierarchie(Personnel_groupe personnelGrp) {
        super(personnelGrp, new Stack<PersonnelInterface>());
    }

    @Override
    protected PersonnelInterface getCollection() {
        return ((Stack<PersonnelInterface>) collection).pop();
    }
}

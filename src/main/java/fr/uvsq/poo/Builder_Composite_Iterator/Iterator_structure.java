package fr.uvsq.poo.Builder_Composite_Iterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class Iterator_structure implements Iterator<PersonnelInterface> {

    private Personnel_groupe racine;
    protected Collection<PersonnelInterface> collection;

    public Iterator_structure(Personnel_groupe personnelGroupe,Collection<PersonnelInterface> collection) {
        this.racine = personnelGroupe;
        this.collection = collection;
        this.collection.addAll(racine.getAllPersonnel());
    }

    @Override
    public boolean hasNext() {
        return !collection.isEmpty();
    }

    @Override
    public PersonnelInterface next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        PersonnelInterface pt = getCollection();
        if(pt.Afficher()=="Plusieurs personnes") {
            collection.addAll(((Personnel_groupe) pt).getAllPersonnel());
        }
        return pt;
    }

        abstract protected PersonnelInterface getCollection();

        public PersonnelInterface getRacine() {
            return racine;
        }
    }


package fr.uvsq.poo.Builder_Composite_Iterator;

public class PersonnelDAOSerialiser extends DAOSerialiser<Personnel>{

    @Override
    public String getFilename(String id) {
        return id + ".personnel";
    }

    @Override
    public String getFilename(Personnel objet) {
        return getFilename(objet.getNom());
    }
}
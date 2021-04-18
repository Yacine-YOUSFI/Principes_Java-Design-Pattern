package fr.uvsq.poo.Builder_Composite_Iterator;

public class GrpPersonnelDAOSerialiser extends DAOSerialiser<Personnel_groupe>{
    @Override
    public String getFilename(String id) {
        return id + ".pg";
    }

    @Override
    public String getFilename(Personnel_groupe objet) {
        return getFilename(objet.getId());
    }
}
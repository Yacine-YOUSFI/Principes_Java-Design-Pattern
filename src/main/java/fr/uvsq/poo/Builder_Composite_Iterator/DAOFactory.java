package fr.uvsq.poo.Builder_Composite_Iterator;

public class DAOFactory {
    public static InterfaceDAO<Personnel> getPersonneldao(){
        return new PersonnelDAOSerialiser();
    }

    public static InterfaceDAO<Personnel_groupe> getPersonnelgrpdao(){
        return new GrpPersonnelDAOSerialiser();
    }
}

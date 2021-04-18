package fr.uvsq.poo.Builder_Composite_Iterator;

public class DAOFactory {

    /**
     *
     * @return Personnel
     */
    public static InterfaceDAO<Personnel> getPersonneldao(){
        return new PersonnelDAOSerialiser();
    }
    /**
     *
     * @return Personnel_groupe
     */
    public static InterfaceDAO<Personnel_groupe> getPersonnelgrpdao(){
        return new GrpPersonnelDAOSerialiser();
    }
}

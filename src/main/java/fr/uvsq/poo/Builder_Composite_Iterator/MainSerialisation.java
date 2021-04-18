package fr.uvsq.poo.Builder_Composite_Iterator;

public enum MainSerialisation {
    ENVIRONNEMENT;



    private void run(String[] args) {



        InterfaceDAO<Personnel> PDAO = DAOFactory.getPersonneldao();

        InterfaceDAO<Personnel_groupe> CDAO = DAOFactory.getPersonnelgrpdao();

        Personnel NADJIB = new Personnel.Builder("YOUSFI", "Yacine", "DATASCALE").build();

        Personnel FARID = new Personnel.Builder("YSF", "YCN", "etudiant").build();

        Personnel_groupe personnalGroup = new Personnel_groupe("personnalGroup");

        Personnel_groupe souspersonnalgroup = new Personnel_groupe("sousPersonnalGroup");

        personnalGroup.addPersonnel(souspersonnalgroup);

        personnalGroup.addPersonnel(NADJIB);

        souspersonnalgroup.addPersonnel(FARID);

        System.out.println("Creation de PersonnalGroup:");

        CDAO.create(personnalGroup);

        System.out.println("Creation de SousPersonnalGroup:");

        CDAO.create(souspersonnalgroup);

        PDAO.create(NADJIB);

        PDAO.create(FARID);

        System.out.println("\t" + CDAO.read(souspersonnalgroup.getId()));

        System.out.println("\t" + PDAO.read("YOUSFI"));

    }



    public static void main(String[] args)

    {

        ENVIRONNEMENT.run(args);
}
}

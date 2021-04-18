package fr.uvsq.poo.Builder_Composite_Iterator;

public enum MainSerialisation {
    ENVIRONNEMENT;



    private void run(String[] args) {



        InterfaceDAO<Personnel> PDAO = DAOFactory.getPersonneldao();

        InterfaceDAO<Personnel_groupe> CDAO = DAOFactory.getPersonnelgrpdao();
    //Creation de l'objet yacine
        Personnel yacine = new Personnel.Builder("YOUSFI", "Yacine", "DATASCALE").build();
//Creation de l'objet ycn
        Personnel ycn = new Personnel.Builder("YSF", "YCN", "etudiant").build();

        Personnel_groupe personnalGroup = new Personnel_groupe("personnalGroup");

        Personnel_groupe souspersonnalgroup = new Personnel_groupe("sousPersonnalGroup");

        personnalGroup.addPersonnel(souspersonnalgroup);

        personnalGroup.addPersonnel(yacine);

        souspersonnalgroup.addPersonnel(ycn);

        System.out.println("Creation de PersonnalGroup:");

        CDAO.create(personnalGroup);

        System.out.println("Creation de SousPersonnalGroup:");

        CDAO.create(souspersonnalgroup);

        PDAO.create(yacine);

        PDAO.create(ycn);

        System.out.println("\t" + CDAO.read(souspersonnalgroup.getId()));

        System.out.println("\t" + PDAO.read("YOUSFI"));

    }



    public static void main(String[] args)

    {

        ENVIRONNEMENT.run(args);
}
}

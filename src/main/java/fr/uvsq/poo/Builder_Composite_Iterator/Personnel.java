package fr.uvsq.poo.Builder_Composite_Iterator;
import java.io.Serializable;
import java.time.LocalDate;

import java.util.List;

public class Personnel implements  PersonnelInterface, Serializable  {

    private  String nom;
    private String prenom;
    private  String fonction;
    private LocalDate date;
    private List<NumeroTelephone> numerosTelephone;

    private Personnel(Builder builder) {
        nom = builder.nom;
        prenom = builder.prenom;
        fonction = builder.fonction;
        date= builder.date;
        numerosTelephone= builder.numerosTelephone;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getfonction() {
        return fonction;
    }

    public LocalDate getdate() {
        return date;
    }

    public List<NumeroTelephone> getNumerosTelephone() {
        return numerosTelephone;
    }

    void print() {
        print();
    }

    @Override
    public String Afficher() {
        return "Une seule personne";
    }


    public static  class Builder {
        private String nom;
        private String prenom;
        private String fonction;
        private LocalDate date;
        private List<NumeroTelephone> numerosTelephone;

        public Builder(String nom, String prenom, String fonction) {
            this.nom = nom;
            this.prenom = prenom;
            this.fonction = fonction;
        }

        public Builder dateNaissance(LocalDate dateNaissance) {
            this.date = dateNaissance;
            return this;
        }

        public Builder addNumeroTelephone(NumeroTelephone numeroTelephone) {
            this.numerosTelephone.add(numeroTelephone);
            return this;
        }
        public Personnel build() {
            return new Personnel(this);
        }


    }

}

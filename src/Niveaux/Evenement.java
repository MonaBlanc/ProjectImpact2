package Niveaux;
import Personnages.*;

import java.util.Scanner;

public class Evenement implements GestionCombat {

    Heros user;
    Ennemis cible;
    int PV_Combat_Héros;
    int PV_Combat_Ennemi;


    public Evenement(Heros NomHeros, Ennemis NomEnnemi){
        this.user = NomHeros;
        this.cible = NomEnnemi;
    }

    public int recupNiveau() {
        return user.niveau;
    }

    public void setNiveau(int level) {
        user.niveau = level;
    }

    public int monterNiveau() {
        return (user.niveau+1);
    }

    public boolean estVaincu(String camp) {
        if (camp == "Héros"){
            if (PV_Combat_Héros<=0){
                return true;
            }
            else return false;
        }
        else{
            if (PV_Combat_Ennemi<=0){
                return true;
            }
            else return false;
        }

    }

    public int recupHP(String camp) {
        if (camp == "Héros"){
            return PV_Combat_Héros;
        }
        else return PV_Combat_Ennemi;

    }

    public int recupHPmax(String camp) {
        if (camp == "Héros"){
            PV_Combat_Héros = user.getPV();
            return user.getPV();
        }
        else{
            PV_Combat_Ennemi = cible.getPV();
            return cible.getPV();
        }
    }

    public int setHP(int newHP, String camp) {
        if (camp == "Héros"){
            PV_Combat_Héros = newHP;
            return PV_Combat_Héros;
        }
        else{
            PV_Combat_Ennemi = newHP;
            return PV_Combat_Ennemi;
        }
    }

    public String getElement(Heros heros){
        String element = user.getElement();
        return element;
    }

    public String getElement(Ennemis cible){
        String elementEnnemi = user.getElement();
        return elementEnnemi;
    }

    public double faiblesse(String element, String element_ennemi) {

        double faiblesse = 0;

        switch(element) {
            case "pyro": {
                if (element_ennemi == "pyro") {
                    faiblesse = 0;
                }
                if (element_ennemi == "hydro") {
                    faiblesse = 0.5;
                }
                if (element_ennemi == "electro") {
                    faiblesse = 1.5;
                }
                if (element_ennemi == "cryo") {
                    faiblesse = 2;
                } else {
                    faiblesse = 1;
                }
            }

            case "electro": {
                if (element_ennemi == "electro") {
                    faiblesse = 0;
                }
                if (element_ennemi == "pyro") {
                    faiblesse = 0.5;
                }
                if (element_ennemi == "hydro") {
                    faiblesse = 1.5;
                }
                if (element_ennemi == "cryo") {
                    faiblesse = 1.5;
                } else{
                    faiblesse = 1;
                }
            }

                case "cryo":
                {
                    if (element_ennemi == "cryo") {
                        faiblesse = 0;
                    }
                    if (element_ennemi == "pyro") {
                        faiblesse = 0.5;
                    }
                    if (element_ennemi == "hydro") {
                        faiblesse = 1.5;
                    }
                    if (element_ennemi == "electro") {
                        faiblesse = 0.5;
                    } else{
                        faiblesse = 1;
                    }
                }

            case "hydro": {
                if (element_ennemi == "hydro") {
                    faiblesse = 0;
                }
                if (element_ennemi == "pyro") {
                    faiblesse = 2;
                }
                if (element_ennemi == "electro") {
                    faiblesse = 0.5;
                } else{
                    faiblesse = 1;
                }
            }

            case "anemo": {
                if (element_ennemi == "anemo") {
                    faiblesse = 0;
                } else{
                    faiblesse = 1.25;
                }
            }

            case "geo": {
                if (element_ennemi == "geo") {
                    faiblesse = 0;
                } else{
                    faiblesse = 1.25;
                }
            }
        }
        return faiblesse;
    }

    public void degat(int degatInflige, String camp) {
        if(camp == "Héros"){
            int newHP = recupHP("Héros") - degatInflige;
            setHP(newHP, "Héros");
        }
        else{
            int newHPCible = recupHP("Cible") - degatInflige;
            setHP(newHPCible, "Cible");
        }
    }

    public boolean attaque(Heros Héros, Ennemis cible) {
        LancerDe LancerDé = new LancerDe();
        recupHPmax("Héros");
        recupHPmax("cible");
        if (LancerDé.lancer6() == 6) {
            System.out.println("Coup Critique !");
            int degatInflige = (int) (Héros.getAttaque() * faiblesse(getElement(Héros), getElement(cible))) * 2;
            System.out.println("Vous faites" + degatInflige + "de degat ! ");
            System.out.println("\nVous avez " + PV_Combat_Héros + " PV, votre ennemi en a " + PV_Combat_Ennemi + "! \n");
            if (estVaincu("Ennemi")) {
                System.out.println("Ennemi vaincu !");
                return false;
            }
        }
        if (LancerDé.lancer6() == 1) {
            System.out.println("Dommage ! Attaque manquée...");
            return true;
        } else {
            System.out.println("Vous attaquez l'ennemi !");
            int degatInflige = (int) (Héros.getAttaque() * faiblesse(getElement(Héros), getElement(cible)));
            //TODO : Déduire les dégats des pv de l'ennemi
            //degat(degatInflige,"Cible");
            System.out.println("\nVous faites " + degatInflige + " de degat ! \n");
            System.out.println("\nVous avez " + PV_Combat_Héros + " PV, votre ennemi en a " + PV_Combat_Ennemi + "! \n");
            if (estVaincu("Ennemi")) {
                System.out.println("Ennemi vaincu !");
                return false;
            }
        }
        return true;

    }

    public void debutCombat(Heros NomHeros, Ennemis cible){
        Scanner selectionUser = new Scanner(System.in);  // Create a Scanner object
        int choixDebut;
        do{
        //identifer le héros
        System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Afficher mes statistiques \n [2] - Afficher les statistiques de l'ennemi \n [3] - Attaquer\n");
        choixDebut = Integer.parseInt(selectionUser.nextLine());

        switch(choixDebut){
            case 1:
                //lire les statistique du héros/ de l'ennemi
                NomHeros.displayStats();
                break;
            case 2:
                cible.displayStats();
                break;
            case 3:
                attaque(NomHeros, cible);
                cible.getPV();
                break;
            default :{
                break;
            }
        }
        }while (estVaincu("Ennemi") != true || estVaincu("Héros") != true);

        if (estVaincu("Ennemi") != false) {
            System.out.println("Vous avez gagné le combat ! \n\n");
        }
        else {
            System.out.println("Vous êtes mort... \n\n");
        }

    }

}
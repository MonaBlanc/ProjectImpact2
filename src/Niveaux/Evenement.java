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
            if (user.getPV()<=0){
                return true;
            }
            else return false;
        }
        else{
            if (cible.getPV()<=0){
                return true;
            }
            else return false;
        }

    }

    public int recupHP(String camp) {
        if (camp == "Héros"){
            return user.getPV();
        }
        else return cible.getPV();

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
            int newPV = recupHP("Héros") - degatInflige;
            user.setPV(newPV);
        }
        else{
            int newPVCible = recupHP("Cible") - degatInflige;
            cible.setPV(newPVCible);
        }
    }

    public boolean attaque(Heros Héros, Ennemis cible) {
        LancerDe LancerDé = new LancerDe();
        int Lancer6 = LancerDé.lancer6();
        recupHPmax("Héros");
        recupHPmax("cible");
        if (Lancer6 == 6) {
            System.out.println("Coup Critique !");
            int degatInflige = (int) (Héros.getAttaque() * faiblesse(getElement(Héros), getElement(cible))) * 2;
            degat(degatInflige,"Cible");
            System.out.println("Vous faites " + degatInflige + " de degat ! ");
            if (estVaincu("Ennemi")) {
                System.out.println("Ennemi vaincu !");
                return false;
            }
        }
        else if (Lancer6 == 1) {
            System.out.println("Dommage ! Attaque manquée...");
            return true;
        } else  {
            System.out.println("Vous attaquez l'ennemi !");
            int degatInflige = (int) (Héros.getAttaque() * faiblesse(getElement(Héros), getElement(cible)));
            //TODO : Déduire les dégats des pv de l'ennemi
            degat(degatInflige,"Cible");
            System.out.println("\nVous faites " + degatInflige + " de degat ! \n");
            if (estVaincu("Ennemi")) {
                System.out.println("Ennemi vaincu !");
                return false;
            }
        }
        return true;

    }

    public boolean défense(Heros Héros, Ennemis cible) {
        LancerDe LancerDé = new LancerDe();
        int Lancer6 = LancerDé.lancer6();
        recupHPmax("Héros");
        recupHPmax("cible");
        if (Lancer6 == 6) {
            System.out.println("Coup Critique !");
            int degatInflige = (int) (cible.getAttaque() * faiblesse(getElement(cible), getElement(Héros))) * 2;
            degat(degatInflige,"Héros");
            System.out.println("Vous perdez " + degatInflige + " PV ! ");
            System.out.println("\nVous avez " + user.getPV() + " PV, votre ennemi en a " + cible.getPV() + "! \n");
            if (estVaincu("Héros")) {
                System.out.println("Vous avez perdu !");
                return false;
            }
        }
        else if (Lancer6 == 1) {
            System.out.println("Attaque manquée...");
            return true;
        } else {
            System.out.println("L'ennemi vous attaque !");
            int degatInflige = (int) (cible.getAttaque() * faiblesse(getElement(cible), getElement(Héros)));
            degat(degatInflige,"Héros");
            System.out.println("Vous perdez " + degatInflige + " PV ! ");
            System.out.println("\nVous avez " + user.getPV() + " PV, votre ennemi en a " + cible.getPV() + "! \n");
            if (estVaincu("Héros")) {
                System.out.println("Vous avez perdu !");
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
                if(estVaincu("Cible")==false){
                   défense(NomHeros, cible);
                }
                break;
            default :{
                break;
            }
        }
        }while(estVaincu("Ennemi")!=true && estVaincu("Héros")!=true );

        if (estVaincu("Ennemi") == true) {
            System.out.println("Vous avez gagné le combat ! \n\n");
        }
        else {
            System.out.println("Vous êtes mort... \n\n");
        }

    }

}
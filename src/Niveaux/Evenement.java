package Niveaux;
import Personnages.*;

import java.util.Scanner;

public class Evenement implements GestionCombat {

    Heros user;
    Ennemis cible;

    String choixArtefact;

    public Evenement(Heros NomHeros, Ennemis NomEnnemi, String Choisi){
        this.user = NomHeros;
        this.cible = NomEnnemi;
        this.choixArtefact = Choisi;
    }


    public void monterExp(int exp) {
        int cap = 1000;
        user.exp += exp;
        if (user.exp > cap){
            user.exp -=  user.exp%cap;
            user.niveau += user.exp%cap;
        }
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
        if (Lancer6 == 6) {
            System.out.println("Coup Critique !");
            int degatInflige = (int) (Héros.getAttaque() + Héros.getmaîtriseElem() * faiblesse(getElement(Héros), getElement(cible))) * 2;
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
            int degatInflige = (int) (Héros.getAttaque() + Héros.getmaîtriseElem() * faiblesse(getElement(Héros), getElement(cible)));
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
        if (Lancer6 == 6) {
            System.out.println("Coup Critique !");
            int degatInflige = (int) (cible.getAttaque() + cible.getmaîtriseElem() * faiblesse(getElement(cible), getElement(Héros))) * 2;
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
            int degatInflige = (int) (cible.getAttaque() + cible.getmaîtriseElem() * faiblesse(getElement(cible), getElement(Héros)));
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

    public void debutCombat(Heros user, Ennemis cible){
        Scanner selectionUser = new Scanner(System.in);  // Create a Scanner object
        int choixDebut;
        if(choixArtefact != null){
            switch (choixArtefact){
                case "SACRIFICIEUR":
                    int newAttaque = user.getAttaque() + 50;
                    user.setAttaque(newAttaque);
                    int newPV = user.getPV() / 2;
                    user.setPV(newPV);
                    break;
                case "COEURDUGARDIEN" :
                    newAttaque = user.getAttaque() - 20;
                    user.setAttaque(newAttaque);
                    newPV = user.getPV() + 300;
                    user.setPV(newPV);
                    break;
                case "ERUDIT" :
                    int newME = user.getmaîtriseElem() + 40;
                    user.setMaitriseElem(newME);
                    newPV = user.getPV() / 2;
                    user.setPV(newPV);
                    break;
                case default :
                    user.setPV(user.getPVInit());
            }
        } else user.setPV(user.getPVInit());

        do{
        System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Afficher mes statistiques \n [2] - Afficher les statistiques de l'ennemi \n [3] - Attaquer\n [4] - Me proteger");
        choixDebut = Integer.parseInt(selectionUser.nextLine());

            switch (choixDebut) {
                case 1 ->
                    //lire les statistique du héros/ de l'ennemi
                        user.displayStats();
                case 2 -> cible.displayStats();
                case 3 -> {
                    attaque(user, cible);
                    cible.getPV();
                    if (estVaincu("Cible") == false) {
                        défense(user, cible);
                    }
                }
                case 4 -> {
                    System.out.println("\nVous passez votre tour ! Vos PV remontent, mais vous ne ferez pas de dégats...\n\n");
                    user.setPV(user.getPV() + 100);
                }
                default -> {
                    break;
                }
            }
        }while(estVaincu("Ennemi")!=true && estVaincu("Héros")!=true );

        if (estVaincu("Ennemi") == true) {
            System.out.println("Vous avez gagné le combat ! \n\n");
            monterExp(500);
        }
        else {
            System.out.println("Vous êtes mort... \n\n");
        }

    }

}
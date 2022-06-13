package Niveaux;
import Personnages.*;
import main.Display;

import java.util.Scanner;

public class Evenement implements GestionCombat {

    Ennemis cible;


    String choixArtefact;

    public Evenement(Heros NomHeros, Ennemis NomEnnemi, String Choisi){
        this.cible = NomEnnemi;
        this.choixArtefact = Choisi;
    }


    public void monterExp(int exp, Heros NomHeros) {
        int cap = 1000;
        NomHeros.exp += exp;
        if (NomHeros.exp > cap){
            NomHeros.exp -=  NomHeros.exp%cap;
            NomHeros.niveau += NomHeros.exp%cap;
        }
    }

    public boolean estVaincu(String camp, Heros NomHeros) {
        if (camp == "Héros"){
            if (NomHeros.getPV()<=0){
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

            case default : {
                faiblesse = 1;
            }
        }
        return faiblesse;
    }

    public void degat(int degatInflige, String camp, Heros NomHeros, Ennemis cible) {
        if(camp == "Héros"){
            int newPV = NomHeros.getPV() - degatInflige;
            NomHeros.setPV(newPV);
        }
        else{
            int newPVCible = cible.getPV() - degatInflige;
            cible.setPV(newPVCible);
        }
    }

    public boolean attaque(Heros NomHeros, Ennemis cible) {
        LancerDe LancerDé = new LancerDe();
        int Lancer6 = LancerDé.lancer6();
        if (Lancer6 == 6) {
            System.out.println("Coup Critique !");
            int degatInflige = (int) (NomHeros.getAttaque() + NomHeros.getmaîtriseElem() * faiblesse(cible.getElementEnnemi(), NomHeros.getElement())) * 2;
            degat(degatInflige,"Cible", NomHeros, cible);
            System.out.println("Vous faites " + degatInflige + " de degat ! ");
            if (estVaincu("Ennemi",NomHeros)) {
                System.out.println("Ennemi vaincu !");
                return false;
            }
        }
        else if (Lancer6 == 1) {
            System.out.println("Dommage ! Attaque manquée...");
            return true;
        } else  {
            System.out.println("Vous attaquez l'ennemi !");
            int degatInflige = (int) (NomHeros.getAttaque() + NomHeros.getmaîtriseElem() * faiblesse(cible.getElementEnnemi(), NomHeros.getElement()));
            //TODO : Déduire les dégats des pv de l'ennemi
            degat(degatInflige,"Cible", NomHeros, cible);
            System.out.println("\nVous faites " + degatInflige + " de degat ! \n");
            if (estVaincu("Ennemi", NomHeros)) {
                System.out.println("Ennemi vaincu !");
                return false;
            }
        }
        return true;

    }

    public boolean défense(Heros NomHeros, Ennemis cible) {
        LancerDe LancerDé = new LancerDe();
        int Lancer6 = LancerDé.lancer6();
        if (Lancer6 == 6) {
            System.out.println("Coup Critique !");
            int degatInflige = (int) (cible.getAttaque() + cible.getmaîtriseElem() * faiblesse(cible.getElementEnnemi(), NomHeros.getElement())) * 2;
            degat(degatInflige,"Héros", NomHeros, cible);
            System.out.println("Vous perdez " + degatInflige + " PV ! ");
            System.out.println("\nVous avez " + NomHeros.getPV() + " PV, votre ennemi en a " + cible.getPV() + "! \n");
            if (estVaincu("Héros", NomHeros)) {
                System.out.println("Vous avez perdu !");
                return false;
            }
        }
        else if (Lancer6 == 1) {
            System.out.println("Attaque manquée...");
            return true;
        } else {
            System.out.println("L'ennemi vous attaque !");
            int degatInflige = (int) (cible.getAttaque() + cible.getmaîtriseElem() * faiblesse(cible.getElementEnnemi(), NomHeros.getElement()));
            degat(degatInflige,"Héros", NomHeros, cible);
            System.out.println("Vous perdez " + degatInflige + " PV ! ");
            System.out.println("\nVous avez " + NomHeros.getPV() + " PV, votre ennemi en a " + cible.getPV() + "! \n");
            if (estVaincu("Héros", NomHeros)) {
                System.out.println("Vous avez perdu !");
                return false;
            }
        }
        return true;

    }

    public void debutCombat(Heros NomHeros, Ennemis cible){
        Scanner selectionUser = new Scanner(System.in);  // Create a Scanner object
        int choixDebut;
        if(choixArtefact != null){
            switch (choixArtefact){
                case "SACRIFICIEUR":
                    int newAttaque = NomHeros.getAttaque() + 50;
                    NomHeros.setAttaque(newAttaque);
                    int newPV = NomHeros.getPV() / 2;
                    NomHeros.setPV(newPV);
                    break;
                case "COEURDUGARDIEN" :
                    newAttaque = NomHeros.getAttaque() - 20;
                    NomHeros.setAttaque(newAttaque);
                    newPV = NomHeros.getPV() + 300;
                    NomHeros.setPV(newPV);
                    break;
                case "ERUDIT" :
                    int newME = NomHeros.getmaîtriseElem() + 40;
                    NomHeros.setMaitriseElem(newME);
                    newPV = NomHeros.getPV() / 2;
                    NomHeros.setPV(newPV);
                    break;
                case default :
                    break;
            }
        }

        do{
        System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Afficher mes statistiques \n [2] - Afficher les statistiques de l'ennemi \n [3] - Attaquer\n [4] - Me proteger");
        choixDebut = Integer.parseInt(selectionUser.nextLine());

            switch (choixDebut) {
                case 1 ->
                    //lire les statistique du héros/ de l'ennemi
                        NomHeros.displayStats();
                case 2 -> cible.displayStats();
                case 3 -> {
                    attaque(NomHeros, cible);
                    if (!estVaincu("Cible", NomHeros)) {
                        défense(NomHeros, cible);
                    }

                }
                case 4 -> {
                    System.out.println("\nVous passez votre tour ! Vos PV remontent, mais vous ne ferez pas de dégats...\n\n");
                    NomHeros.setPV(NomHeros.getPV() + 100);
                }
                default -> {
                    System.out.println("\n Merci d'entrer une valeur valide !\n\n");
                    ;
                }
            }
        }while(!estVaincu("Ennemi", NomHeros) && !estVaincu("Héros", NomHeros));

        if (estVaincu("Ennemi", NomHeros)) {
            System.out.println("Vous avez gagné le combat ! \n\n");
            monterExp(500, NomHeros);
        }
        else {
            System.out.println("Vous êtes mort... Retour à la case départ. \n\n");

            NomHeros.setPV(NomHeros.getPVInit());
            Display EcranTitre = new Display();
            EcranTitre.displayMenu(NomHeros);

        }


    }

}
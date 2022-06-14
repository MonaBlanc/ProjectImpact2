package Niveaux;
import Objets.*;
import main.Display;

import java.util.Scanner;

/**
 * Classe Evenement qui gère les actions possibles par l'ennemi ou le héros
 */
public class Evenement implements GestionCombat {

    /*
    Variables locales
     */
    Ennemis cible;
    String choixArtefact;

    /**
     * Constructeur
     * @param heros Aventurier qui part au combat
     * @param ennemi Ennemi envoyé au combat
     * @param artefact
     */
    public Evenement(Heros heros, Ennemis ennemi, String artefact){
        this.cible = ennemi;
        this.choixArtefact = artefact;
    }

    /**
     * Fonction qui monte l'expérience du héros
     * @param exp Expérience gagné
     * @param heros On envoie l'aventurier à monter
     */
    public void monterExp(int exp, Heros heros) {
        int cap = 1000;
        heros.getArme().setExp(heros.getArme().getExp()+exp);
        if (heros.getArme().getExp() > cap){
            heros.getArme().setExp(heros.getArme().getExp() - (exp - heros.getArme().getExp()%cap));
            heros.getArme().setNiveau(heros.getArme().getNiveau() + heros.getArme().getExp()%cap);
        }
    }

    /**
     * Fonction qui test si un des camps est vaincu ou non
     * @param camp On envoie le camp que l'on teste
     * @param heros On envoie l'aventurier à tester
     * @return renvoie l'état du participant
     */
    public boolean estVaincu(String camp, Heros heros) {
        if (camp == "Héros"){
            if (heros.getPV()<=0){
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

    /**
     * Fonction qui test les faiblesses entre les deux camps
     * @param element Element du héros à tester
     * @param element_ennemi Element de l'ennemi à tester
     * @return on renvoit un facteur qui sera appliqué lors du calcul des dégats
     */
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

    /**
     * Fonction qui applique les dats au camp choisi
     * @param degatInflige Dégâts déjà calculés à appliquer
     * @param camp Camp auquel on applique les dégâts
     * @param heros Héros participant au combat
     * @param cible Ennemi envoyé au combat
     */
    public void degat(int degatInflige, String camp, Heros heros, Ennemis cible) {
        if(camp == "Héros"){
            int newPV = heros.getPV() - degatInflige;
            heros.setPV(newPV);
        }
        else{
            int newPVCible = cible.getPV() - degatInflige;
            cible.setPV(newPVCible);
        }
    }

    /**
     * Gestion de l'attaque du héros envers l'ennemi
     * @param heros Héros participant au combat
     * @param cible Ennemi envoyé au combat
     */
    public void attaque(Heros heros, Ennemis cible) {
        /*
        Gestion aléatoire : (1/6) Coup critique et (1/6) Attaque manquée tandis que (4/6) pour Attaque normale
         */
        LancerDe LancerDé = new LancerDe();
        int Lancer6 = LancerDé.lancer6();
        if (Lancer6 == 6) {
            System.out.println("Coup Critique !");
            int degatInflige = (int) (heros.getAttaque() + heros.getMaitriseElem() * faiblesse(cible.getElement(), heros.getElement())) * 2;
            degat(degatInflige,"Cible", heros, cible);
            System.out.println("Vous faites " + degatInflige + " de degat ! ");
            if (estVaincu("Ennemi",heros)) {
                System.out.println("Ennemi vaincu !");
            }
        }
        else if (Lancer6 == 1) {
            System.out.println("Dommage ! Attaque manquée...");
        } else  {
            System.out.println("Vous attaquez l'ennemi !");
            int degatInflige = (int) (heros.getAttaque() + heros.getMaitriseElem() * faiblesse(cible.getElement(), heros.getElement()));
            //TODO : Déduire les dégats des pv de l'ennemi
            degat(degatInflige,"Cible", heros, cible);
            System.out.println("\nVous faites " + degatInflige + " de degat ! \n");
            if (estVaincu("Ennemi", heros)) {
                System.out.println("Ennemi vaincu !");
            }
        }
    }

    /**
     * Gestion de l'attaque de l'ennemi envers le héros
     * @param heros Héros participant au combat
     * @param cible Ennemi envoyé au combat
     */
    public void défense(Heros heros, Ennemis cible) {
        LancerDe LancerDé = new LancerDe();
        int Lancer6 = LancerDé.lancer6();
        if (Lancer6 == 6) {
            System.out.println("Coup Critique !");
            int degatInflige = (int) (cible.getAttaque() + cible.getMaitriseElem() * faiblesse(cible.getElement(), heros.getElement())) * 2;
            degat(degatInflige,"Héros", heros, cible);
            System.out.println("Vous perdez " + degatInflige + " PV ! ");
            System.out.println("\nVous avez " + heros.getPV() + " PV, votre ennemi en a " + cible.getPV() + "! \n");
            if (estVaincu("Héros", heros)) {
                System.out.println("Vous avez perdu !");
            }
        }
        else if (Lancer6 == 1) {
            System.out.println("Attaque manquée...");
        } else {
            System.out.println("L'ennemi vous attaque !");
            int degatInflige = (int) (cible.getAttaque() + cible.getMaitriseElem() * faiblesse(cible.getElement(), heros.getElement()));
            degat(degatInflige,"Héros", heros, cible);
            System.out.println("Vous perdez " + degatInflige + " PV ! ");
            System.out.println("\nVous avez " + heros.getPV() + " PV, votre ennemi en a " + cible.getPV() + "! \n");
            if (estVaincu("Héros", heros)) {
                System.out.println("Vous avez perdu !");
            }
        }
    }

    /**
     * Fonction avec le déroulement d'un combat
     * @param heros Héros participant au combat
     * @param cible Ennemi envoyé au combat
     */
    public void debutCombat(Heros heros, Ennemis cible){
        Scanner selectionUser = new Scanner(System.in);  // Create a Scanner object
        int choixDebut;
        if(choixArtefact != null){
            switch (choixArtefact){
                case "SACRIFICIEUR":
                    int newAttaque = heros.getAttaque() + 50;
                    heros.setAttaque(newAttaque);
                    int newPV = heros.getPV() / 2;
                    heros.setPV(newPV);
                    break;
                case "COEURDUGARDIEN" :
                    newAttaque = heros.getAttaque() - 20;
                    heros.setAttaque(newAttaque);
                    newPV = heros.getPV() + 300;
                    heros.setPV(newPV);
                    break;
                case "ERUDIT" :
                    int newME = heros.getMaitriseElem() + 40;
                    heros.setMaitriseElem(newME);
                    newPV = heros.getPV() / 2;
                    heros.setPV(newPV);
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
                        heros.displayStats();
                case 2 -> cible.displayStats();
                case 3 -> {
                    attaque(heros, cible);
                    if (!estVaincu("Cible", heros)) {
                        défense(heros, cible);
                    }

                }
                case 4 -> {
                    System.out.println("\nVous passez votre tour ! Vos PV remontent, mais vous ne ferez pas de dégats...\n\n");
                    heros.setPV(heros.getPV() + 100);
                }
                default -> {
                    System.out.println("\n Merci d'entrer une valeur valide !\n\n");
                    ;
                }
            }
        }while(!estVaincu("Ennemi", heros) && !estVaincu("Héros", heros));

        if (estVaincu("Ennemi", heros)) {
            System.out.println("Vous avez gagné le combat ! \n\n");
            monterExp(500, heros);
        }
        else {
            System.out.println("Vous êtes mort... Retour à la case départ. \n\n");

            heros.setPV(heros.getPVInit());
            Display EcranTitre = new Display();
            EcranTitre.displayMenu(heros);

        }


    }

}
package Niveaux;

import Objets.Ennemis;
import Objets.Heros;
import java.util.Scanner;

/**
 * Classe comprenant les différents niveaux du Donjon d'Entrainement
 */
public class Donjon {

    /*
    Variable locale
     */
    public String artefactChoisi;

    /*
    Constructeur vide
     */
    public Donjon() {
    }

    /**
     * Premier niveau du donjon constitué de deux sbires
     * @param heros On envoie l'aventurier qui ira au combat
     */
    public void PremierNiveau(Heros heros) {
        /*
        Partie aléatoire de la fonction
         */
        LancerDe lancerDe = new LancerDe();
        int Lancer6 = lancerDe.lancer6();

        System.out.println("Vous vous engagez dans le premier niveau ! Plus que 3 avant de rencontrer la Shogun..\n\n");
        Ennemis sbire1 = new Ennemis("sbire", 3, "geo");
        /*
        On lance le premier combat
         */
        Evenement premierCombat = new Evenement(heros, sbire1, null);
        premierCombat.debutCombat(heros, sbire1);
        System.out.println("\nPremier sbire vaincu ! Restez sur vos gardes, un autre approche...\n\n");
        /*
        De même pour le deuxième combat
         */
        Ennemis sbire2 = new Ennemis("sbire", 3, "geo");
        Evenement deuxiemeCombat = new Evenement(heros, sbire2, null);
        deuxiemeCombat.debutCombat(heros, sbire2);

        System.out.println("Vous êtes venu à bout du premier niveau ! Avec plus d'expériences votre puissance augmente !");
        System.out.println("\nUn coffre se cache avant la prochaine porte, vous y trouvez un set d'artefacts avec une inscription : ");
        Scanner selectionUser = new Scanner(System.in);

        /*
        On attribue une récompense aléatoire à l'utilisateur
         */
        if (Lancer6 == 6) {
            System.out.println("SACRIFICIEUR\n");
            System.out.println("Le set du sacrificieur vous offrera 50 d'attaque en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "SACRIFICIEUR";
                    break;
                case 2:
                    heros.setPV(heros.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 5) {
            System.out.println("SACRIFICIEUR\n");
            System.out.println("Le set du sacrificieur vous offrera 50 d'attaque en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "SACRIFICIEUR";
                    break;
                case 2:
                    heros.setPV(heros.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 4) {
            System.out.println("COEURDUGARDIEN\n");
            System.out.println("Le set du coeur du gardien vous offrera 400PV en échange de la moitié de 20 points d'attaque.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "COEURDUGARDIEN";
                    break;
                case 2:
                    heros.setPV(heros.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 3) {
            System.out.println("COEURDUGARDIEN\n");
            System.out.println("Le set du coeur du gardien vous offrera 400PV en échange de la moitié de 20 points d'attaque.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi = "COEURDUGARDIEN";
                    break;
                case 2:
                    heros.setPV(heros.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 2) {
            System.out.println("ERUDIT\n");
            System.out.println("Le set de l'érudit vous offrera 40 de maitrise élémentaire en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi =  "ERUDIT";
                    break;
                case 2:
                    heros.setPV(heros.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 1) {
            System.out.println("ERUDIT\n");
            System.out.println("Le set de l'érudit vous offrera 40 de maitrise élémentaire en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch(choixArtefact) {
                case 1:
                    artefactChoisi =  "ERUDIT";
                    break;
                case 2:
                    heros.setPV(heros.getPVInit());
                    artefactChoisi =  null;
                    break;
                default :
                    System.out.println("Merci de faire un choix !\n");
            }
        }
    }

    /**
     * Deuxième niveau du donjon constitué de trois Fatuis
     * @param heros On envoie l'aventurier qui ira au combat
     */
    public void DeuxiemeNiveau(Heros heros) {
        LancerDe lancerDe = new LancerDe();
        int Lancer6 = lancerDe.lancer6();
        System.out.println("Vous vous engagez dans le deuxieme niveau ! Plus que 2 avant de rencontrer la Shogun..\n\n");
        /*
        Premier combat
         */
        Ennemis fatui1 = new Ennemis("fatui", 10, "geo");
        Evenement premierCombat = new Evenement(heros, fatui1, artefactChoisi);
        premierCombat.debutCombat(heros, fatui1);
        System.out.println("\nPremier Fatui vaincu ! Restez sur vos gardes, cette fois il en reste deux...\n\n");
        /*
        Deuxième combat
         */
        Ennemis fatui2 = new Ennemis("fatui", 10, "geo");
        Evenement deuxiemeCombat = new Evenement(heros, fatui2, artefactChoisi);
        deuxiemeCombat.debutCombat(heros, fatui2);
        System.out.println("\nLe dernier Fatui approche...\n\n");
        /*
        Troisième combat
         */
        Ennemis fatui3 = new Ennemis("sbire", 10, "geo");
        Evenement troisiemeCombat = new Evenement(heros, fatui3, artefactChoisi);
        troisiemeCombat.debutCombat(heros, fatui3);

        System.out.println("Vous êtes venu à bout du deuxieme niveau ! Avec plus d'expériences votre puissance augmente !");
        System.out.println("\nUn coffre se cache avant la prochaine porte, vous y trouvez un set d'artefacts avec une inscription : ");
        Scanner selectionUser = new Scanner(System.in);
        /*
        On attribue de nouveau des récompenses aléatoires
         */
        if (Lancer6 == 6) {
            System.out.println("SACRIFICIEUR\n");
            System.out.println("Le set du sacrificieur vous offrera 50 d'attaque en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch (choixArtefact) {
                case 1 -> artefactChoisi = "SACRIFICIEUR";
                case 2 -> {
                    heros.setPV(heros.getPVInit());
                    artefactChoisi = null;
                }
                default -> System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 5) {
            System.out.println("SACRIFICIEUR\n");
            System.out.println("Le set du sacrificieur vous offrera 50 d'attaque en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch (choixArtefact) {
                case 1 -> artefactChoisi = "SACRIFICIEUR";
                case 2 -> {
                    heros.setPV(heros.getPVInit());
                    artefactChoisi = null;
                }
                default -> System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 4) {
            System.out.println("COEURDUGARDIEN\n");
            System.out.println("Le set du coeur du gardien vous offrera 400PV en échange de la moitié de 20 points d'attaque.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch (choixArtefact) {
                case 1 -> artefactChoisi = "COEURDUGARDIEN";
                case 2 -> {
                    heros.setPV(heros.getPVInit());
                    artefactChoisi = null;
                }
                default -> System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 3) {
            System.out.println("COEURDUGARDIEN\n");
            System.out.println("Le set du coeur du gardien vous offrera 400PV en échange de la moitié de 20 points d'attaque.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch (choixArtefact) {
                case 1 -> artefactChoisi = "COEURDUGARDIEN";
                case 2 -> {
                    heros.setPV(heros.getPVInit());
                    artefactChoisi = null;
                }
                default -> System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 2) {
            System.out.println("ERUDIT\n");
            System.out.println("Le set de l'érudit vous offrera 40 de maitrise élémentaire en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch (choixArtefact) {
                case 1 -> artefactChoisi = "ERUDIT";
                case 2 -> {
                    heros.setPV(heros.getPVInit());
                    artefactChoisi = null;
                }
                default -> System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 1) {
            System.out.println("ERUDIT\n");
            System.out.println("Le set de l'érudit vous offrera 40 de maitrise élémentaire en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch (choixArtefact) {
                case 1 -> artefactChoisi = "ERUDIT";
                case 2 -> {
                    heros.setPV(heros.getPVInit());
                    artefactChoisi = null;
                }
                default -> System.out.println("Merci de faire un choix !\n");
            }
        }

    }

    /**
     * Troisième niveau du donjon constitué d'un Hyposthase
     * @param heros On envoie l'aventurier qui ira au combat
     */
    public void TroisiemeNiveau(Heros heros) {
        LancerDe lancerDe = new LancerDe();
        int Lancer6 = lancerDe.lancer6();
        System.out.println("Vous vous engagez dans le troisieme niveau ! Le dernier avant de rencontrer la Shogun..\n\n");
        /*
        Combat
         */
        Ennemis hyposthase1 = new Ennemis("hyposthase", 15, "geo");
        Evenement premierCombat = new Evenement(heros, hyposthase1, artefactChoisi);
        premierCombat.debutCombat(heros, hyposthase1);
        System.out.println("Vous êtes venu à bout du troisieme niveau ! Avec plus d'expériences votre puissance augmente !");
        System.out.println("\nUn coffre se cache avant la prochaine porte, vous y trouvez un set d'artefacts avec une inscription : ");
        Scanner selectionUser = new Scanner(System.in);
        /*
        Attribution aléatoire des récompenses
         */
        if (Lancer6 == 6) {
            System.out.println("SACRIFICIEUR\n");
            System.out.println("Le set du sacrificieur vous offrera 50 d'attaque en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch (choixArtefact) {
                case 1 -> artefactChoisi = "SACRIFICIEUR";
                case 2 -> {
                    heros.setPV(heros.getPVInit());
                    artefactChoisi = null;
                }
                default -> System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 5) {
            System.out.println("SACRIFICIEUR\n");
            System.out.println("Le set du sacrificieur vous offrera 50 d'attaque en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch (choixArtefact) {
                case 1 -> artefactChoisi = "SACRIFICIEUR";
                case 2 -> {
                    heros.setPV(heros.getPVInit());
                    artefactChoisi = null;
                }
                default -> System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 4) {
            System.out.println("COEURDUGARDIEN\n");
            System.out.println("Le set du coeur du gardien vous offrera 300PV en échange de 20 points d'attaque.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch (choixArtefact) {
                case 1 -> artefactChoisi = "COEURDUGARDIEN";
                case 2 -> {
                    heros.setPV(heros.getPVInit());
                    artefactChoisi = null;
                }
                default -> System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 3) {
            System.out.println("COEURDUGARDIEN\n");
            System.out.println("Le set du coeur du gardien vous offrera 300PV en échange de 20 points d'attaque.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch (choixArtefact) {
                case 1 -> artefactChoisi = "COEURDUGARDIEN";
                case 2 -> {
                    heros.setPV(heros.getPVInit());
                    artefactChoisi = null;
                }
                default -> System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 2) {
            System.out.println("ERUDIT\n");
            System.out.println("Le set de l'érudit vous offrera 40 de maitrise élémentaire en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch (choixArtefact) {
                case 1 -> artefactChoisi = "ERUDIT";
                case 2 -> {
                    heros.setPV(heros.getPVInit());
                    artefactChoisi = null;
                }
                default -> System.out.println("Merci de faire un choix !\n");
            }
        } else if (Lancer6 == 1) {
            System.out.println("ERUDIT\n");
            System.out.println("Le set de l'érudit vous offrera 40 de maitrise élémentaire en échange de la moitié de vos PV.");
            System.out.println("\n\nQue souhaitez vous faire ? \n [1] - Equiper ce set et ne pas se soigner. \n [2] - Ce set ne m'intéresse pas, je me soigne avant le prochain combat. ");
            int choixArtefact = Integer.parseInt(selectionUser.nextLine());
            switch (choixArtefact) {
                case 1 -> artefactChoisi = "ERUDIT";
                case 2 -> {
                    heros.setPV(heros.getPVInit());
                    artefactChoisi = null;
                }
                default -> System.out.println("Merci de faire un choix !\n");
            }
        }

    }

    /**
     * Boss final de notre donjon d'entrainement
     * @param heros On envoie l'aventurier qui ira au combat
     */
    public void Shogun(Heros heros) {
        LancerDe lancerDe = new LancerDe();
        int Lancer6 = lancerDe.lancer6();
        System.out.println("Vous sentez une ambiance électrifiante... Cette derniere vous glace le sang ! vous allez rencontrer la Shogun..\n\n");
        /*
        Combat
         */
        Ennemis shogunRaiden = new Ennemis("Boss", 30, "electro");
        Evenement premierCombat = new Evenement(heros, shogunRaiden, artefactChoisi);
        premierCombat.debutCombat(heros, shogunRaiden);
        System.out.println("Vous êtes venu à bout de la grande Shogun ! C'est malheureusement la fin de notre aventure...");
        /*
        Fin du jeu
         */
        System.out.println("\nCe fut un plaisir, voyageur. Merci d'avoir joué avec nous.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n[APPUYER SUR ENTREE]");
        scanner.nextLine();
    }

    }


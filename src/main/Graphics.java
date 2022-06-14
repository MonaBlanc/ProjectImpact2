package main;

/**
 * Classe pouvant permettre plusieurs types de "nettoiement" d'écran
 */
public class Graphics {

    /**
     * Fonction permettant de "changer" d'écran
     */
    public static void clear() {
        //Saut de 15 lignes suffisant pour le moment
        for (int i = 0; i<15; i++) {
            System.out.println("\b");
        }
    }

    /**
     * Fonction permettant d'afficher un texte justifié
     */
    public String wrapTexte(String texte) {
        //On peut modifier la largeur de la justification avec largeurMax
        int largeurMax = 99;

        //On créé un tableau qui va stocker et séparer notre texte
        String[] separationTexte = texte.split("");
        //Valeur finale renvoyée
        String texteFinal = "";
        String ligne = "";

        //On parcourt notre texte tant qu'il n'est pas fini
        for (int i = 0; i < separationTexte.length; i++) {
            if (ligne.isEmpty()) {
                ligne += separationTexte[i];
            } else if (ligne.length() + separationTexte[i].length() <= largeurMax) { //On sépare le texte dès que l'on dépasse la largeur indiquée
                ligne += separationTexte[i];
            } else {
                texteFinal += ligne + "\n"; //On remplit texte final tant que la fonction n'est pas finie
                ligne = "";
            }
        }
        if(!ligne.isEmpty()){
            texteFinal += ligne + "\n"; //On ajoute la dernère ligne
        }
        /*
        On renvoie la version finale du texte justifié
         */
        return texteFinal;
    }

}
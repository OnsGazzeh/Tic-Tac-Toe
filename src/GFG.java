// A simple program to demonstrate
// Tic-Tac-Toe Game.
import java.util.*;

public class GFG {
    static String tour;
    static String[] board;



    // La méthode verifgagnant décider de la combinaison de trois boîte ci-dessous.
    static String VerifGagnant()
    {
        for (int i = 0; i < 8; i++) {
            String ligne = null;

            switch (i) {
                case 0:
                    ligne = board[0] + board[1] + board[2];
                    break;
                case 1:
                    ligne = board[3] + board[4] + board[5];
                    break;
                case 2:
                    ligne = board[6] + board[7] + board[8];
                    break;
                case 3:
                    ligne = board[0] + board[3] + board[6];
                    break;
                case 4:
                    ligne = board[1] + board[4] + board[7];
                    break;
                case 5:
                    ligne = board[2] + board[5] + board[8];
                    break;
                case 6:
                    ligne = board[0] + board[4] + board[8];
                    break;
                case 7:
                    ligne = board[2] + board[4] + board[6];
                    break;
            }
            //X est le gagnant
            if (ligne.equals("XXX")) {
                return "X";
            }

            // o est le gagnant
            else if (ligne.equals("OOO")) {
                return "O";

            }
        }

        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(i + 1))) {
                break;
            }
            else if (i== 8) {
                return "draw";
            }
        }

        // Pour entrer X ou o à la place exact
        System.out.println(
                " c'est le tour de "+tour+ " ; donner un numero de case pour placer  "
                        + tour );
        return null;
    }

    // pour afficher la table de la maniere suivante.
   /*
   | 1 | 2 | 3 |
   | 4 | 5 | 6 |
   | 7 | 8 | 9 |
   */

    static void afficheTable()
    {

        System.out.println(board[0] + " | "
                + board[1] + " | " + board[2]
        );

        System.out.println(board[3] + " | "
                + board[4] + " | " + board[5]
        );

        System.out.println(board[6] + " | "
                + board[7] + " | " + board[8]
        );

    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        board = new String[9];
        tour= "X";
        String Gagnant = null;


        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        afficheTable();

        System.out.println(
                "X jouera en premier. Entrez un numéro de case pour placer X dans:");

        while (Gagnant == null) {
            int numSaisi;

            /* Gestion des exceptions.
             numSaisi prendra l'entrée de l'utilisateur comme de 1 à 9.
             S'il n'est pas compris entre 1 et 9.
             alors il vous montrera une erreur "num invalide."*/
            try {
                numSaisi = in.nextInt();
                if (!(numSaisi > 0 && numSaisi<= 9)) {
                    System.out.println(
                            " num invalide; ressaisissez avec un autre numéro :");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                        " num invalide; ressaisissez avec un autre numéro :");
                continue;
            }

            // Ce jeu a deux joueurs x et O.
            // Voici la logique pour décider du tour.
            if (board[numSaisi - 1].equals(
                    String.valueOf(numSaisi))) {
                board[numSaisi - 1] = tour;

                if (tour.equals("X")) {
                    tour = "O";
                }
                else {
                    tour = "X";
                }

                afficheTable();
                Gagnant = VerifGagnant();
            }
            else {
                System.out.println(
                        "case deja occupée;ressaisissez avec un autre numéro  :");
            }
        }

        // Si personne ne gagne ou ne perd à la fois des joueurs x et o.
        // alors voici la logique pour imprimer "draw".
        if (Gagnant.equalsIgnoreCase("draw")) {
            System.out.println(
                    "It's a draw! Thanks for playing.");
        }

        // Pour le gagnant on affiche un message de Félicitation!
        else {
            System.out.println(
                    "Félicitation! " + Gagnant
                            + " a gagné ! Thanks for playing.");
        }
    }
}


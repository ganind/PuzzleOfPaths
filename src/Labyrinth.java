import java.util.ArrayList;

public class Labyrinth {

    //champs de l'objet Labyrinth
    private int nbLignes;
    private int nbColonnes;
    //private String row;
    private Cellule matrixCellule[][];  //matrice du type cellule

    // Constructeur : construir un nouveau objet matrixCellule de type matrice de cellules
    public Labyrinth(int nbLignes, int nbColonnes, String row) {
        //System.out.println(row);
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        //this.row = row;
        matrixCellule = new Cellule[nbLignes][nbColonnes]; //réserver l'espace en mémoire
        int index = 0;

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matrixCellule[i][j] = new Cellule(row.charAt(index++), i, j) ; // Iterate over characters of a String
                //System.out.println(matrixCellule[i][j].toString()); //matrixCellule[][] est une instruction qui va récuperer une célule à une adresse donnée
            }
        }
    }

    //le cerveau du programme qui va trouver les chemins
    //sans parametre car le départ et l'arrivé sont tjrs les mêmes (0,0) et (N-1, M-1)
    public void pathFinder() {
        Cellule celluleCourrente = matrixCellule[0][0]; //cellule de départ
        ArrayList chemin = new ArrayList<Cellule>(); //ArrayList = tableau de taille dynamique

        celluleCourrente = prochaineCellule(celluleCourrente);

    }

    // recherche de la prochaine cellule de la matrice
    public Cellule prochaineCellule(Cellule uneCellule){

        Cellule nextCellule;
        System.out.println(uneCellule.toString());

        if (uneCellule.getLigne() == nbLignes -1 && uneCellule.getColonne() == nbColonnes - 1) {
            return null;
        }

        if (uneCellule.getColonne() == nbColonnes-1) {
            nextCellule = matrixCellule[uneCellule.getLigne()+1][uneCellule.getColonne()];
            if (nextCellule.getValeur() == '0') {
                return prochaineCellule(nextCellule);
            } else {
                return null;
            }
        }

        if (uneCellule.getLigne() == nbLignes-1) {
            nextCellule = matrixCellule[uneCellule.getLigne()][uneCellule.getColonne()+1];
            if (nextCellule.getValeur() == '0') {
                return prochaineCellule(nextCellule);
            } else {
                return null;
            }
        }

        nextCellule = matrixCellule[uneCellule.getLigne()][uneCellule.getColonne() + 1];
        if (nextCellule.getValeur() == '0') {
            return prochaineCellule(nextCellule);
        } else {
            nextCellule = matrixCellule[uneCellule.getLigne() +1][uneCellule.getColonne()];
            if (nextCellule.getValeur() == '0') {
                return prochaineCellule(nextCellule);
            } else {
                return null;
            }
        }
    }
}

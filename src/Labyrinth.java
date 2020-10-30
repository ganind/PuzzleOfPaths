import java.util.ArrayList;

public class Labyrinth {

    //champs de l'objet Labyrinth
    private int nbLignes;
    private int nbColonnes;
    private Cellule matrixCellule[][];  //matrice du type cellule

    // Constructeur : construir un nouveau objet matrixCellule de type matrice de cellules
    public Labyrinth(int nbLignes, int nbColonnes, String row) {
        //System.out.println(row);
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        matrixCellule = new Cellule[nbLignes][nbColonnes]; //réserver l'espace en mémoire
        int index = 0;

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matrixCellule[i][j] = new Cellule(row.charAt(index++), i, j) ; // Iterate over characters of a String
            }
        }
    }

    //le cerveau du programme qui va trouver les chemins
    //sans parametre car le départ et l'arrivé sont tjrs les mêmes (0,0) et (N-1, M-1)
    public void pathFinder() {
        Cellule celluleCourrente = matrixCellule[0][0]; //cellule de départ
        ArrayList chemin = new ArrayList<Cellule>(); //ArrayList = tableau de taille dynamique
        int compteur = 0;

        chemin = prochaineCellule(celluleCourrente, chemin);
        for (int i = 0; i < chemin.size(); i++) {
            Cellule cell = (Cellule) chemin.get(i); //cast
            if (cell.getLigne() == nbLignes -1 && cell.getColonne() == nbColonnes - 1) {
                compteur++;
            }
        }
        System.out.println(chemin);
        System.out.println(compteur);


    }

    // recherche de la prochaine cellule de la matrice
    public ArrayList<Cellule> prochaineCellule(Cellule uneCellule, ArrayList chemin){

        Cellule nextCellule;
        System.out.println(uneCellule.toString());
        chemin.add(uneCellule);

        if (uneCellule.getLigne() == nbLignes -1 && uneCellule.getColonne() == nbColonnes - 1) {
            return chemin;
        }

        if (uneCellule.getColonne() == nbColonnes-1) {
            nextCellule = matrixCellule[uneCellule.getLigne()+1][uneCellule.getColonne()];
            if (nextCellule.getValeur() == '0') {
                 prochaineCellule(nextCellule, chemin);
            } else {
                return chemin;
            }
        } else

        if (uneCellule.getLigne() == nbLignes-1) {
            nextCellule = matrixCellule[uneCellule.getLigne()][uneCellule.getColonne()+1];
            if (nextCellule.getValeur() == '0') {
                prochaineCellule(nextCellule, chemin);
            } else {
                return chemin;
            }
        } else {

            nextCellule = matrixCellule[uneCellule.getLigne()][uneCellule.getColonne() + 1];
            if (nextCellule.getValeur() == '0') {
                prochaineCellule(nextCellule, chemin);
            }

            nextCellule = matrixCellule[uneCellule.getLigne() + 1][uneCellule.getColonne()];

            if (nextCellule.getValeur() == '0') {
                prochaineCellule(nextCellule, chemin);
            } else {
                return chemin;
            }
        }
        return chemin;
    }
}

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 */

public class Solution {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        int M = in.nextInt();
        int N = in.nextInt();

        if (in.hasNextLine()) {
            in.nextLine();
        }

        String ROW = ""; //résoudre problème de manque de visibilité en dehors de la boucle for

        for (int i = 0; i < M; i++) {
            if (i == 0) {
                ROW = in.nextLine();
            } else {
                ROW = ROW + in.nextLine(); //concatenation pour éviter d'ecraser la première saisie
            }
        }

        Labyrinth matrix = new Labyrinth(M, N, ROW);
        matrix.pathFinder();
    }
}

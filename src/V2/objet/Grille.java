package V2.objet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import V2.outils.Constantes; // Il faut importer des constantes pour accèder au nom des fichiers
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  Ne pas modifier !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Grille {

	public final static int LONGUEUR_RUE = 74;
	
	public final static int LARGEUR_RUE = 31;
	
	public final static int LARGEUR_RIVE = 30;

	// Lecture de la rue en se basant sur les deux fichiers riveDroite.txt et riveGauche.txt
	public static char[][] lireRue() {
		char[][] rue = new char[LONGUEUR_RUE][LARGEUR_RUE + 2 * LARGEUR_RIVE];
		try (BufferedReader gauche = new BufferedReader(new FileReader(Constantes.rivegauche));
				BufferedReader droite = new BufferedReader(new FileReader(Constantes.rivedroite))) {
			for (int y = 0; y < LONGUEUR_RUE; y++) {
				char[] rg = gauche.readLine().toCharArray();
				char[] rd = droite.readLine().toCharArray();
				for (int x = 0; x < LARGEUR_RIVE; x++) {
					// on remplit la carte, la rue est remplie de \0
					if (x < rg.length)
						rue[y][x] = rg[x];
					if (x < rd.length)
						rue[y][LARGEUR_RUE + LARGEUR_RIVE + x] = rd[x];
				}
			}
		} catch (IOException e) {
			// en cas de problèmes on ne peut pas générer la rue ...
			e.printStackTrace();
			return null;
		}
		return rue;
	}
}

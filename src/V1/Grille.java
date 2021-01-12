package V1;

import java.util.ArrayList;

public class Grille {

	private static int LONGUEUR_RUE = 74;
	private static int LARGEUR_RUE = 20;
	private static int LARGEUR_RIVE = 30;
	
	// uniquement la gestion de l'affichage, la gestion des conflits se fait dans la boucle de jeu
	public static void afficherPersonnagesVoieCentrale(int y, Heros h, ArrayList<Zombi> zombis) {
		int x, i;
		boolean vide = true;
		for (x = 0; x < LARGEUR_RUE; x++) {
			// Affichage du Héros?
			if (h.getposX() == x && h.getposY() == y) {
				System.out.print("H");
				Log.message("H");
				vide = false;
			} else {
				// Affichage d'un Zombi?
				i = 0;
				while (i < zombis.size() && vide==true) {
					if (zombis.get(i).getposX() == x && zombis.get(i).getposY() == y) {
						System.out.print("Z");
						Log.message("Z");
						vide = false;
						
					}
					i++;
				}
			}
			// Si ni héros, ni zombi
			if (vide == true) {
				System.out.print(" ");
				Log.message(" ");
			}
			else vide=true; // On remet vide à true
		}

	}

	public static void afficherRueSavidan(Heros h, ArrayList<Zombi> zombis) {
		int y;
		for (y = 0; y <= h.getposY(); y++) {
			afficherRiveGauche(y);
			afficherPersonnagesVoieCentrale(y, h, zombis);
			afficherRiveDroite(y);
			System.out.println();
			Log.message("\n");

		}
	}

	static void afficherRiveGauche(int l) {
		String[] riveGauche = { "----------------------------||", "Rue des Ursulines  !! HELP!!||",
				"----------------------------||", "        .       .           ||", "        ..........          ||",
				"        .       .           ||", "        .       .           ||", "        ..........          ||",
				"        .       .           ||", "        .       .           ||", "        .       .           ||",
				"----------------------------||", "Impasse ancienne gendarmerie||", "----------------------------||",
				"        .       .           ||", "        .       .           ||", "        .       .           ||",
				"        .........           ||", "        .I       .          ||", "        . M      .          ||",
				"        .  A   .            ||", "        .   G   .           ||", "        .    E   .          ||",
				"        .    R   .          ||", "        .   I    .          ||", "        ...E......          ||",
				"        .       .           ||", "        .       .           ||", "        .       .           ||",
				"        ..........          ||", "        .       .           ||", "        .       .           ||",
				"----------------------------||", "rue compagnie Roger Barbe   ||", "----------------------------||",
				"        .       .           ||", "        .       .           ||", "        .       .           ||",
				"        ..........          ||", "        .       .           ||", "        .       .           ||",
				"        .       .           ||", "----------------------------||", "----------------------------||",
				"        .       .           ||", "        .       .           ||", "        .       .           ||",
				"        .       .           ||", "        .       .           ||", "        .       .           ||",
				"        .       .           ||", "        ..........          ||", "        .       .           ||",
				"        .       .           ||", "        .       .           ||", "        ..........          ||",
				"        .       .           ||", "        .       .           ||", "        .       .           ||",
				"----------------------------||", "Venelle des 3 avocats       ||", "----------------------------||",
				"        .       .           ||", "        .       .           ||", "        .       .           ||",
				"        .       .           ||", "        ..........          ||", "        .       .           ||",
				"        .       .           ||", "        ..........          ||", "        .       .           ||",
				"        .       .           ||", "        .       .           ||", "****************************||" };
		System.out.print(riveGauche[l]);

		Log.message(riveGauche[l]);

	}

	static void afficherRiveDroite(int l) {
		String[] riveDroite = { "||. .", "||. .", "||..........", "||. .", "||. .", "||. .", "||. .",
				"||----------------------------", "||Venelle des écoles", "||----------------------------", "||. .",
				"||. .", "||. .", "||. .", "||..........", "||. .", "||. .", "||. .", "||. .", "||. .", "||. .",
				"||. .", "||..........", "||. .", "||. .", "||. .", "||----------------------------",
				"||Rue de Keriavily", "||----------------------------", "||. .", "||. .", "||. .", "||. .",
				"||..........", "||. .", "||. .", "||. .", "||. .", "||. .", "||. .", "||----------------------------",
				"||. .", "||. .", "||. .", "||. .", "||. .", "||..........", "||. .", "||. .", "||. .", "||. .",
				"||. .", "||----------------------------", "||rue Emile le Taillandier",
				"||----------------------------", "||. .", "||..........", "||.M .", "||. A .", "||. I .", "||. R .",
				"||. I .", "||......E...", "||----------------------------", "||place des halles",
				"||----------------------------", "||. .", "||. .", "||. .", "||. .", "||. .", "||. .", "||. .",
				"||****************************" };
		System.out.print(riveDroite[l]);
		Log.message(riveDroite[l]);
	}

	public static int get_LONGUEUR_RUE() {
		return LONGUEUR_RUE;
	}

	public static int get_LARGEUR_RUE() {
		return LARGEUR_RUE;
	}

	public static int get_LARGEUR_RIVE() {
		return LARGEUR_RIVE;
	}
}

package V2.objet;
import poo.zombi.ui. IObjAffichable;
import java.util.ArrayList;

import V2.Jeu;
import V2.outils.Log;


// fourni mais Ã  compléter avec l'utilisation de l'interface IObjAffichable
public class Zombi implements IObjAffichable{
	private int posX;
	private int posY;

	public final static char CODE = 'Z';

	public Zombi(Jeu jeu) {
			//Le zombis est initialisé à une position aléatoire
			posX = (int) (Grille.LARGEUR_RUE * Math.random());
			posY = (int) (Grille.LONGUEUR_RUE * Math.random() / 4);

		Log.message("gÃ©nÃ©ration d'un zombi en("+posX+","+posY+")");
	}

	public static void deplacerZombi(Zombi z) {
		//déplacement aléatoire du zombi dans une direction
		int t = (int) (3 * Math.random());
		switch (t) {
		case 0:
			if (z.posY < Grille.LONGUEUR_RUE - 1)
				z.posY++;
			break;
		case 1:
			if (z.posX > 0)
				z.posX--;
			break;
		case 2:
			if (z.posX < Grille.LARGEUR_RUE - 1)
				z.posX++;
			break;
		}
	}

	public static void deplacerZombis(ArrayList<Zombi> zombis) {
		int i;
		for (i = 0; i < zombis.size(); i++) {
			deplacerZombi(zombis.get(i));
		}
	}

	public int getposX() {
		return posX + Grille.LARGEUR_RIVE;
	}

	public int getposY() {
		return posY;
	}

	public char getCode() {
		return CODE;
	}
}

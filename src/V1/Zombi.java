package V1;
import java.util.ArrayList;

public class Zombi {
	private int vitesse;
	private int posX;
	private int posY;

	public Zombi() {
		//initialisation du zombi avec une position et une vitesse aléatoire
		posX = (int) (Grille.get_LARGEUR_RUE()*Math.random()); 
		posY = (int) (Grille.get_LONGUEUR_RUE()*Math.random()  / 2);
		vitesse = (int) (2 + Math.random() % 2);
	}

	public static void deplacerZombi(Zombi z) {
		//déplacement aléatoire du zombi - 3 direction possible - bas - droite - gauche
		int t = (int) (3*Math.random());
		switch (t) {
		case 0:
			if (z.posY < Grille.get_LONGUEUR_RUE() - 1)
				z.posY++;
			break;
		case 1:
			if (z.posX > 0)
				z.posX--;
			break;
		case 2:
			if (z.posX < Grille.get_LARGEUR_RUE() - 1)
				z.posX++;
			break;
		}
	}
	
	//déplacement de la liste de zombis
	public static void deplacerZombis(ArrayList<Zombi> zombis) {
		int i;
		for (i = 0; i < zombis.size(); i++) {
			deplacerZombi(zombis.get(i));
		}
	}

	public int getposX() {
		return posX;
	}

	public int getposY() {
		return posY;
	}
}

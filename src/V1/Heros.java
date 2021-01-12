package V1;


public class Heros {
	//attributs
	private String nom;
	private int arme;
	private int posX;
	private int posY;
	private boolean enVie;
	
	//constructeur 
	public Heros(String nom) {
		posX = Grille.get_LARGEUR_RUE() / 2;
		posY = Grille.get_LONGUEUR_RUE() - 1;
		enVie = true;
		this.nom = nom;
	}

	public void deplacement(char sens) {

		switch (sens) {
		case 'z': // vers le haut
			if (posY > 0)
				posY--;
			break;
		case 'q': // vers la gauche
			if (posX > 0)
				posX--;
			break;
		case 'd':	// vers la droite
			if (posX < Grille.get_LARGEUR_RUE() - 1)
				posX++;
			break;
		case 's': // vers le bas
			if (posY < Grille.get_LONGUEUR_RUE() - 1)
				posY++;
			break;
		}
	}
	//si le héro arrive en haut de la rue il a gagné
	public boolean estVictorieux() {
		Boolean retour = false;
		if (posY == 0)
			retour = true;
		return retour;
	}

	public boolean estEnVie() {
		return enVie;
	}

	public int getposX() {
		return posX;
	}

	public int getposY() {
		return posY;
	}
	
	public void setposX(int posX) {
		this.posX=posX;
	}

	public void setposY(int posY) {
		this.posY=posY;
	}

	public void setenVie(boolean i) {
		enVie = i;
	}
}

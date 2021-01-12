package V2.objet;


import poo.zombi.ui.IObjAffichable;
// Classe fournie pour illustrer l'utilisation de l'interface IObAffichable
public class Heros implements IObjAffichable{

	private String nom;
	private int posX;
	private int posY;
	private boolean enVie;
	private boolean arme;
	
	public final static char CODE = '@';
	public final static char CODEARME = '�';

	public Heros(String nom) {
		posX = Grille.LARGEUR_RUE / 2;
		posY = Grille.LONGUEUR_RUE - 1;
		enVie = true;
		this.nom = nom;
	}

	public void deplacement(int sens) {

		switch (sens) {
		case 'z':
			if (posY > 0)
				posY--;
			break;
		case 'q':
			if (posX > 0)
				posX--;
			break;
		case 'd':
			if (posX < Grille.LARGEUR_RUE - 1)
				posX++;
			break;
		case 's':
			if (posY < Grille.LONGUEUR_RUE - 1)
				posY++;
			break;
		}
	}

	public boolean estVictorieux() {
		return posY == 0;
	}

	public boolean estEnVie() {
		return enVie;
	}

	public int getposX() {
		return posX+Grille.LARGEUR_RIVE;
	}

	public int getposY() {
		return posY;
	}
	
	
	public void prendArme() {
			arme = true;
	}
	
	public boolean estArme() {
		return arme;
}
	/**
	 * le heros est touché, il utilise son arme ou meurt.
	 */
	public void touche() {
		//on gère une arme
		if(arme)
			arme = false;
		else
			enVie = false;
	}

	public String getNom() {
		return nom;
	}

	public char getCode() {
		if(arme)
			return CODEARME;
		return CODE;
	}
	
	
}

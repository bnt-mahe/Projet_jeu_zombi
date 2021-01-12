package V2.objet;

import V1.Zombi;
import V2.Jeu;
import V2.outils.Log;
import poo.zombi.ui.IObjAffichable;

public class Arme implements IObjAffichable {
	private int posX;
	private int posY;
	
	public final static char CODE = 'A';

	public Arme(Jeu jeu) {

				
				posX = (int) (Grille.LARGEUR_RUE * Math.random());
				posY = (int) (Grille.LONGUEUR_RUE * Math.random());
				
				// une arme ne peut pas être déposée sur une case déjà  utilisée

			Log.message("gÃ©nÃ©ration d'une arme en("+posX+","+posY+")");
	}
	public int getposX() {
		return posX+Grille.LARGEUR_RIVE;
	}

	public int getposY() {
		return posY;
	}

	@Override
	public char getCode() {
		return CODE;
	}
	
}

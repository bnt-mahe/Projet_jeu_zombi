package V2;

import java.awt.Color;

import V2.objet.Arme;
import V2.objet.Grille;
import V2.objet.Heros;
import V2.objet.Zombi;
import V2.outils.Constantes;
import V2.outils.Log;
import poo.zombi.ui.Affichage;

public class Lanceur {
	// fourni Ã  complÃ©ter pour les textures des Armes et Zombis
	public static void main(String[] args) {

		//Initialisation de l'affichage et du log
		Log.createLog();
		Affichage ui = new Affichage(1280, 800);
		//Affichage affichage = new Affichage(0, 0);
		ui.definirRue(Grille.lireRue());
		
		//initialisation cosmétique
		ui.definirCouleurConsole(Color.white);
		ui.definirTexture(Heros.CODE, Constantes.tx_heros, null);
		ui.definirTexture(Zombi.CODE, Constantes.tx_zombi, null);
		ui.definirTexture(Arme.CODE, Constantes.tx_arme, null);
		ui.definirTexture(Heros.CODEARME, Constantes.tx_herosArme, null);
		ui.definirTexture('|', Constantes.tx_mur, null);
		ui.definirTexture((char) 0, Constantes.tx_pave, null);
		ui.definirTexture('*', Constantes.tx_exit, null);
		ui.definirTexture('-', Constantes.tx_ruelle, null);

		Log.message("affichage initialisÃ©");
		
		//Initialisation du jeu : on créers un objet et on lui passe en paramètre l'UI
		Jeu jeu = new Jeu(ui);
		
		Log.message("jeu initialisÃ©");
		
		// debut de jeu
		jeu.demarrer(); // boucle du jeu
		
		// Fin Partie
		ui.println("");
		ui.println("[appuyez sur une touche pour quitter]");
		ui.AttenteDeTouche();
		Log.close();
		ui.close();

	}
}

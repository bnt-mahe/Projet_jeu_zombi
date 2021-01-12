package V2;

import java.util.ArrayList;

import V1.Grille;
import V2.objet.Arme;
import V2.objet.Heros;
import V2.objet.Zombi;
import V2.outils.Constantes;
import V2.outils.Log;
import poo.zombi.ui.Affichage;
import poo.zombi.ui.IObjAffichable;

/**
 * classe de description de comportement du jeu: Tout va se jouer ici !
 * 
 */
public class Jeu {
	
	//attributs
	private Affichage ui;
	private Heros heros;
	private Zombi zombi;
	private Arme arme;
	ArrayList<Arme> armes = new ArrayList<Arme>();
	ArrayList<Zombi> zombis = new ArrayList<Zombi>();
	
	

	/**
	 * on attend un affichage avec les textures, Ã  partir de lÃ  on initialise le jeu
	 * avec les objets qui y sont liÃ©s.
	 * 
	 */
	//Constructeur
	public Jeu(Affichage affichage) {
		heros = new Heros("Bob"); //création du héro et affichage
		ui = affichage;
		ui.setHeros(heros);
		
		for(int i=0 ; i< Constantes.max_armes ; i++) {//initialisation et affichage des armes
			armes.add(new Arme(null));
			ui.addObject(armes.get(i));
		}
		
		
		for (int i=0 ; i< Constantes.max_zombis ; i++) {//initialisation et affichage des zombis
		zombi = new Zombi(null);
        ui.addObject(zombi);
        zombis.add(zombi);
		}
		
		affichage.println("La touche [Echap] vous permet de quitter le jeu Ã  tout moment");
		ui.println("Utilisez les touches z,q,s,d pour dÃ©placer votre hÃ©ros.");
	}

	

	//-----------------------------------------------boucle de jeu-------------------------------------------------------------
	/**
	 * tant que le heros est en vie, mais qu'il n'est pas victorieux, le jeu se dÃ©roule
	 * 
	 */
	//Méthodes
	public void demarrer() {
		
		while (heros.estEnVie() && !heros.estVictorieux()) {//boucle de jeu 
			ui.update(); //mise à jour de l'affichage
			int sens = attenteCommande(); //commande de déplacement héro
			heros.deplacement(sens);
			testCollisionZombi(); //test de collision avant le déplacement des zombis
			Zombi.deplacerZombis(zombis); //déplacement des zombis
			testCollisionZombi(); //test de collision après le déplacement des zombis
			for ( int i= 0 ; i< zombis.size() ; i++) {
				if(positionLibre(zombis.get(i).getposX(),zombis.get(i).getposY())==false) {//test de la position libre
					Zombi.deplacerZombi(zombis.get(i));//si elle est fausse on déplace le zombi
				}
			}
			//tests de collision
			testCollisionArmes();
			testCollisionZombi();
		}
		
		// Boucle pour le déplacement aléatoire du héro
		/*
		while (heros.estEnVie() && !heros.estVictorieux()) {
			ui.update();
			char sens = 'z';
			int t = (int) (3*Math.random());
			switch (t) {
			case 0:
				sens = 'z';
				break;
			case 1:
				sens = 'q';
				break;
			case 2:
				sens = 'd';
				break;
			}
			heros.deplacement(sens);
			Zombi.deplacerZombis(zombis);
			for ( int i= 0 ; i< zombis.size() ; i++) {
				if(positionLibre(zombis.get(i).getposX(),zombis.get(i).getposY())==false) {
					Zombi.deplacerZombi(zombis.get(i));
				}
			}
			testCollisionArmes();
			testCollisionZombi();
		}
		*/
		
		// victoire/défaite
		String message = "BRAVO VOUS AVEZ SAUVE VOS AMIS SANS VOUS FAIRE TUER PAR LES ZOMBIS !!!";
		if (!heros.estEnVie())
			message = "VOUS ET VOS AMIS ETES MORTS";
		ui.println(message);
		Log.message(message);
	}
	//--------------------------------------------fin boucle de jeu------------------------------------------------------------

	
		
	private void testCollisionZombi() {
	
		
		for(IObjAffichable o : zombis) { //parcours de la liste de zombis
			if (heros.getposX() == o.getposX() && heros.getposY()== o.getposY()) {//test pour savoir si les position sont les même
				
				if(!heros.estArme()) {//si le héro n'est pas armée il disparait
				ui.removeObject(heros); 
				}
				else { ui.removeObject(o);}//sinon c'est le zombi qui se fait tuer
				heros.touche();
			}
			
		}
	}
	private void testCollisionArmes() {
		if(!heros.estArme()) {
			for (IObjAffichable o : armes) {//parcours de la liste des armes 
				if(heros.getposX()== o.getposX() && heros.getposY()== o.getposY()) {// si le héro est sur une arme et qu'il n'est pas armé
					heros.prendArme(); //il prend l'arme
					ui.removeObject(o);// l'arme est retirée de l'affichage
				}
				
			}
		}
	}

	
	private int attenteCommande() {
		int sens = 0;
		while (sens != 'z' && sens != 's' && sens != 'q' && sens != 'd') {
			sens = ui.AttenteDeTouche();
		}
		return sens;
	}

	/** 
	 * on teste que la position est libre ...
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean positionLibre(int x, int y) {
		boolean retour= true;
		for(int u = 0 ; u < armes.size() ; u++) {
				if(armes.get(u).getposX()==x && armes.get(u).getposY()==y){//test si un zombi et une arme on la même position
					retour = false;
				}
			
		}
		return retour;
	}

}

package V1;
import java.util.ArrayList;
import java.util.Scanner;

public class LanceurZal {
	public static void main(String[] args) {

		//Initialisation de la liste de zombis, des zombis et du héro
		int NBZOMBIS = 20;
		Heros leHeros = new Heros("Toto");
		ArrayList<Zombi> lesZombis = new ArrayList<Zombi>();
    	Scanner clavier = new Scanner(System.in);
    	Log.createLog();
    	
		for (int i = 0; i < NBZOMBIS; i++) {
			lesZombis.add(new Zombi());
			System.out.println("Z"+(i+1)+": x = "+lesZombis.get(i).getposX() + " y = " + lesZombis.get(i).getposY());
		}
		
		//Affichage de la rue
		 Grille.afficherRueSavidan(leHeros,lesZombis);
		 
		//boucle principale de jeu qui tourne tant que le héro n'est pas mort ou n'a pas gagné
		while (leHeros.estEnVie()  && !leHeros.estVictorieux()) {
			
	       char sens = 'r';
	       //On demande une saisie clavier correcte
	       while(sens != 'z' && sens != 's' &&  sens != 'q' && sens != 'd'){
	            System.out.println("\nUtilisez les touches z s q d pour déplacer votre héros : ");
	            String saisie=clavier.nextLine();
	            sens=saisie.charAt(0);
	            leHeros.deplacement(sens);
	        }	
	       //test si il y a collision entre le héro et un zombi 
	       for (Zombi zombi  : lesZombis) {
				if (zombi.getposX() == leHeros.getposX() && zombi.getposY() == leHeros.getposY()) {
					leHeros.setenVie(false);
			}
			}
	       //déplacement des zombis
			Zombi.deplacerZombis(lesZombis);
			
			//test si il y a collision entre le héro et un zombi après déplacement des zombis 
			for (Zombi zombi  : lesZombis) {
				if (zombi.getposX() == leHeros.getposX() && zombi.getposY() == leHeros.getposY()) {
					leHeros.setenVie(false);
			}
			}
			//Mise a jour de l'affichage 
			Grille.afficherRueSavidan(leHeros,lesZombis);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (leHeros.estEnVie()) {
			System.out.println("BRAVO VOUS AVEZ SAUVEZ VOS AMIS SANS VOUS FAIRE TUER PAR LES ZOMBIS !!!");
		} else {
			System.out.println("VOUS ET VOS AMIS SONT MORTS");

		} // Fin Partie 1 en autonomie
		clavier.close();

		Log.close();

	}
}

package V1;

public class TestHeros {

	public static void main(String[] args) {
		System.out.println("Test de la classe Heros PROF 2019-2020");
		Heros leHeros = new Heros("Toto");
		System.out.println("Position initiale");
		System.out.println(leHeros.getposX() + ":" + leHeros.getposY());
		System.out.println("Déplacement haut");
		leHeros.deplacement('z');
		System.out.println(leHeros.getposX() + ":" + leHeros.getposY());
		System.out.println("Déplacement droite");
		leHeros.deplacement('d');
		System.out.println(leHeros.getposX() + ":" + leHeros.getposY());
		System.out.println("Déplacement bas");
		leHeros.deplacement('s');
		System.out.println(leHeros.getposX() + ":" + leHeros.getposY());
		System.out.println("Déplacement gauche");
		leHeros.deplacement('q');
		System.out.println(leHeros.getposX() + ":" + leHeros.getposY());
		
		System.out.println("Limite  gauche");
		for(int i=leHeros.getposX();i>-10;i--) {
			leHeros.deplacement('q');
		}
		System.out.println(leHeros.getposX() + ":" + leHeros.getposY());
		
		System.out.println("Limite  droite");
		for(int i=leHeros.getposX();i<Grille.get_LARGEUR_RUE()+10;i++) {
			leHeros.deplacement('d');
		}
		System.out.println(leHeros.getposX() + ":" + leHeros.getposY());
		
		System.out.println("Limite  haute");
		for(int i=leHeros.getposY();i>-10;i--) {
			leHeros.deplacement('z');
		}
		System.out.println(leHeros.getposX() + ":" + leHeros.getposY());
		
		System.out.println("Limite  basse");
		for(int i=leHeros.getposY();i< Grille.get_LONGUEUR_RUE() +10 ;i++) {
			leHeros.deplacement('s');
		}
		System.out.println(leHeros.getposX() + ":" + leHeros.getposY());
	
		System.out.println("Test Gagné / perdu");
		leHeros.setposY(0);
		System.out.println(leHeros.estVictorieux());
		leHeros.setposY(10);
		System.out.println(leHeros.estVictorieux());
		
		System.out.println("Test enVie");
		leHeros.setenVie(false);
		System.out.println(leHeros.estEnVie());
	
	}

}

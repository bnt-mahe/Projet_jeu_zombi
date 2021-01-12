package V1;

public class TestZombi {

	public static void main(String[] args) {
		System.out.println("Test de la classe Zombi PROF 2019-2020");
		Zombi zombi = new Zombi();
		System.out.println("Position initiale");
		System.out.println(zombi.getposX() + ":" + zombi.getposY());
		System.out.println("D�placement al�atoire d'un zombi al�atoire : reste-t-il dans la rue?");
		System.out.println("Boucle de test de non sortie à gauche");
		zombi = new Zombi();
		while (zombi.getposX() > 1) {
			Zombi.deplacerZombi(zombi);
		}
		System.out.println(zombi.getposX() + ":" + zombi.getposY());
		System.out.println("Boucle de test de non sortie à droite");

		zombi = new Zombi();
		while (zombi.getposX() < Grille.get_LARGEUR_RUE()-1) {
			Zombi.deplacerZombi(zombi);			
		}
		System.out.println(zombi.getposX() + ":" + zombi.getposY());

		System.out.println("Boucle de test de non sortie en bas");
		zombi = new Zombi();
		while (zombi.getposY() < Grille.get_LONGUEUR_RUE()-1) {
			Zombi.deplacerZombi(zombi);			
		}
		System.out.println(zombi.getposX() + ":" + zombi.getposY());
	}

}

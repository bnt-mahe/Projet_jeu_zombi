package V1;

import java.util.ArrayList;
import java.util.Scanner;

public class TestListeZombis {

	public static void main(String[] args) {
		System.out.println("Test d'une liste de Zombis PROF 2019-2020");
		int NBZOMBIS = 20;
		ArrayList<Zombi> lesZombis = new ArrayList<Zombi>();

		for (int i = 0; i < NBZOMBIS; i++) {
			lesZombis.add(new Zombi());
			System.out.println("Z"+(i+1)+": x = "+lesZombis.get(i).getposX() + " y = " + lesZombis.get(i).getposY());
		}

		Zombi.deplacerZombis(lesZombis);
		System.out.println("----------- Déplacement ----------------------");
		for (int i = 0; i < NBZOMBIS; i++) {
			System.out.println("Z"+(i+1)+": x = "+lesZombis.get(i).getposX() + " y = " + lesZombis.get(i).getposY());
		}
	}
}

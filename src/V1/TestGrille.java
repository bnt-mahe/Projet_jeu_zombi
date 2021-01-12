package V1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestGrille {
	public static void main(String[] args) {

		int NBZOMBIS = 20;
		Heros leHeros = new Heros("Toto");
		ArrayList<Zombi> lesZombis = new ArrayList<Zombi>();
    	Log.createLog();
    	
		for (int i = 0; i < NBZOMBIS; i++) {
			lesZombis.add(new Zombi());
			System.out.println("Z"+(i+1)+": x = "+lesZombis.get(i).getposX() + " y = " + lesZombis.get(i).getposY());
		}

		Grille.afficherRueSavidan(leHeros,lesZombis);


	}
}

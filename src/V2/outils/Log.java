package V2.outils;

import java.io.FileWriter;
import java.io.IOException;

public class Log {
	private static FileWriter fichierLog=null;
	
	public static void createLog()  {
		try {
			fichierLog = new FileWriter("logs.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void message(String message) {
			try {
				fichierLog.append(message);
				fichierLog.append(System.lineSeparator());
				System.out.println(message);
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

	public static void close() {
		try {
			fichierLog.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

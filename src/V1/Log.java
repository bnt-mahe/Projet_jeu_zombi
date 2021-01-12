package V1;

import java.io.FileWriter;
import java.io.IOException;

public class Log {
	public static FileWriter fichierLog=null;	
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

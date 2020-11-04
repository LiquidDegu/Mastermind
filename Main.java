import java.util.*;


public class Main {

	public static void main(String[] args) {
		/*
		 * Mastermind ist ein Spiel mit normalerweise 6 Farben und 4 Pl�tze wo man diese anordnen kann
		 * Es gibt auch Versionen mit mehr Farben oder mit mehr L�chern
		 * 
		 * Ziel ist es Variable Anzahl an L�chern und Farben zu haben ggf. mit Grafischem Interface
		 * Zusatz w�re ein 2 Spieler modi???
		 * 
		 * 
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		int NumTrys = 9;
		int NumRows = 4;
		int NumCol = 6;
		int Black = 0;
		int White = 0;
		
		
		//Abfrage ob man unter den "Normalen" Regeln Spielen m�chte oder ob man die Regeln �ndern m�chte
		
		System.out.println("Wollen sie mit den normalen Regeln Spielen (6 Farben 4 L�cher und 9 Versuchen)    J/N");
		String Regeln = sc.nextLine();
		if (Regeln.toUpperCase().contains("N")) {
			System.out.println("Wie viele Farben Wollen sie haben?");
				NumCol = sc.nextInt();
			
			System.out.println("Wie viele L�cher wollen sie haben?");
				NumRows = sc.nextInt();
				
			System.out.println("Wie viele Versuche wollen sie haben?");
				NumTrys = sc.nextInt();
			
			System.out.println("Wollen sie die Einstellungen Verwenden?"); // Abfrage ob man die geschriebenen EInstellungen Speichern m�chte falls nicht zur�ck auf Standard
				String SaveSettings = sc.nextLine();
					if (SaveSettings.toUpperCase().contains("N")) {
						NumTrys = 9;
						NumRows = 4;
						NumCol = 6;						
					}
		}
		int NumColl = NumCol  -1;
		int [] Farbkombi = new int[NumRows];
		int [] Ratekombi = new int[NumRows];
		//Abfrage ob man gegen den Computer oder einen Menshcen spielt damit ggf. der Computer den Farbcode generiert
		System.out.println("EinzelSpieler oder Mehrspieler");
		String DoYouHaveFriends = sc.nextLine();
		if (DoYouHaveFriends.toUpperCase().contains("M")) {			// M weil der Buchstabe nur in Mehrspieler vorkommt
			
			System.out.println("Trage bitte f�r deinen Farbcode ein den Spieler 2 L�sen muss");
			System.out.println("Der Farbcode hat " + NumRows + " stellen und du kannst aus " + NumCol + " ausw�hlen");
			System.out.println("Bitte schreibe jede Farbe einzelnd und anstelle von Farben verwendest du bitte Zahlen");
			System.out.println("Die Zahlen die du w�hlst sollten kleiner oder gleich deiner Maximalen Farben sein siehe mehr dazu im LOG"); //Schreibe ein Log zu den verhaltensweisen
		
			for (int EingegebeneFarben = 1; EingegebeneFarben <= NumRows; EingegebeneFarben++) {
					//Array f�r die Farbcombination
				System.out.println("Bitte geben sie die Farbe f�r die " + EingegebeneFarben +". Stelle ein");
				int ArrayInput = EingegebeneFarben -1;
				Farbkombi[ArrayInput] = sc.nextInt();
				if (Farbkombi[ArrayInput] > NumColl) {
					System.out.println("Bitte geben sie Ausschlie�lich Farben von 0 bis " + NumColl + " ein");
					Farbkombi[ArrayInput] = sc.nextInt();
				}
			
			
			
		}		
			
			
			
		}else if (DoYouHaveFriends.toUpperCase().contains("Z")) {	// Z weil der Buchstabe nur in Einzelspieler vorhanden ist 
			DoYouHaveFriends = "no";
			
			System.out.println("Der Computer generiert die Farbkombination Bitte warten");
			for (int EingegebeneFarben = 1; EingegebeneFarben <= NumRows; EingegebeneFarben++) {
				int ArrayInput = EingegebeneFarben -1;
				int ArrayPC = new Random().nextInt(NumCol);
				Farbkombi[ArrayInput] = ArrayPC;
			}
			
			
		}
		
		//Spielz�ge und Abfrage mit output von Wei� und Schwarz bis die Z�ge Vorbei sind
		
		for(int Spielz�ge = 1; Spielz�ge <=NumTrys; Spielz�ge++) {
			int [] Farbkombi1 = new int[NumRows];
			Farbkombi1 = Farbkombi;
			int [] Ratekombi1 =new int[NumRows];
			Ratekombi1 = Ratekombi;
			White = 0;
			Black = 0;

			
			System.out.println("Spieler1 bitte geben sie ihren Spielzug Nummer " + Spielz�ge + " ein");
						
			for (int EingegebeneFarben = 1; EingegebeneFarben <= NumRows; EingegebeneFarben++) {
				System.out.println("Bitte geben sie die Farbe f�r die " + EingegebeneFarben +". Stelle ein");
				int ArrayInput = EingegebeneFarben -1;
				Ratekombi[ArrayInput] = sc.nextInt();
				if (Ratekombi[ArrayInput] > NumColl) {
					System.out.println("Bitte geben sie Ausschlie�lich Farben von 0 bis " + NumColl + " ein");
					Ratekombi[ArrayInput] = sc.nextInt();
				}
			}
			Ratekombi1 = Ratekombi;
			
			for (int Checker = 0; Checker < NumRows; Checker++) {
				// Durchlaufung ob an der ersten stelle die 2 �berein stimmen dann an der 2. etc bis alle reihen durch sind
				
				if (Farbkombi1[Checker] == Ratekombi[Checker]) {
					Black++;
					Farbkombi1[Checker] = NumCol + 1; //Da der stein dann schon abgehandelt wurde
				}	
			}
			
			
			for (int Checker = 0; Checker < NumRows; Checker++) {
				
				
				
				for (int Checker1 = 0; Checker1 < NumRows; Checker1++) {
					if (Farbkombi1[Checker1] == Ratekombi[Checker]) {
						if (Ratekombi[Checker] == Ratekombi1[Checker]) {
							White++;
							Ratekombi1[Checker] = NumCol +2;
							
						}
					
						Farbkombi1[Checker1] = NumCol +1;
						
					}
				}
				
				
				

				
				
			}
			
			if (Black == NumRows) {
				System.out.println("Sie haben alles Richtig geraten und haben gewonnen!");
				break;
				
			}
			
			
			System.out.println("Sie haben " + White + "wei�e Kugeln und " + Black + "Schwarze Kugeln");
			
			
		}
		
		

		System.out.println(Arrays.toString(Ratekombi));

		sc.close();
		
		
	}

}

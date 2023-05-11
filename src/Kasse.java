import java.util.Arrays;
import java.util.Scanner;

/* Die Klasse "Kasse" bietet eine M�glichkeit, einen Warenkorb zu verwalten
 * und eine Rechnung sowie einen zwischenstand auszudrucken.
 */
public class Kasse{

	/*
	 * Die Methode printRechnung erstellt eine Rechnung, basierend auf den Produkten
	 * im Warenkorb und der Gesamtsumme. Die Warenkorb-Produkte werden als Array von
	 * Produkt-IDs warenkorb und die Gesamtsumme als double summe �bergeben. Die
	 * Methode erstellt eine Rechnung, indem sie den Produktnamen, den Preis und die
	 * Gesamtsumme in einen String ret einf�gt. Die Schleife wird verwendet, um den
	 * Produktnamen und den Preis f�r jedes Produkt im Warenkorb abzurufen und in
	 * den String ret einzuf�gen. Schlie�lich wird die Gesamtsumme am Ende des
	 * Strings angezeigt.
	 */
	static String printRechnung(int[] warenkorb, double summe) {
		// erstellt einen leeren String ret, der am Ende der Funktion zur�ckgegeben wird
		String ret = "";
		// String zusammensetzen
		ret += "----- RECHNUNG -----";
		ret += "\n";
		ret += "Produkt \t Preis in EUR";
		ret += "\n";
		// Durchlaufe den Warenkorb komplett
		for (int warenkorbIndex = 0; warenkorbIndex < warenkorb.length; warenkorbIndex++) {
			// f�gt an den String ret die Produktinfos hinzu, die anhand des gespeicherten
			// Index im Array warenkorb mithilfe der Methoden getProduktName und
			// getProduktPreis
			// ausgelesen werden k�nnen
			ret += getProduktName(warenkorb[warenkorbIndex]) + " \t" + getProduktPreis(warenkorb[warenkorbIndex])
					+ " EUR";
			ret += "\n";
		}
		ret += "--------------------";
		ret += "\n";
		ret += "Summe: \t\t" + summe + " EUR";
		// gibt den fertigen String ret zur�ck
		return ret;
	}

	/**
	 * Diese Methode gibt den Warenkorb in einem lesbar formatierten String zur�ck.
	 * Zuerst wird der Titel "WARENKORB" angezeigt, gefolgt von einer Tabelle, die
	 * die Produkte und Preise enth�lt. Die Produkte und Preise werden aus dem
	 * �bergebenen int-Array 'warenkorb' extrahiert, indem die Methoden
	 * 'getProduktName' und 'getProduktPreis' aufgerufen werden. Der resultierende
	 * String wird zur�ckgegeben.
	 */
	static String printWarenkorb(int[] warenkorb) {
		// erstellt einen leeren String ret, der am Ende der Funktion returned wird
		String ret = "";
		// String zusammensetzen
		ret += "----- WARENKORB -----";
		ret += "\n";
		ret += "Produkt \t Preis in EUR";
		ret += "\n";
		// Durchl�uft den Warenkorb komplett
		for (int warenkorbIndex = 0; warenkorbIndex < warenkorb.length; warenkorbIndex++) {
			// f�gt an den String ret die Produktinfos hinzu, die anhand des gespeicherten
			// Index im Array warenkorb mithilfe der Methoden getProduktName und
			// getProduktPreis
			// ausgelesen werden k�nnen
			ret += getProduktName(warenkorb[warenkorbIndex]) + " \t" + getProduktPreis(warenkorb[warenkorbIndex])
					+ " EUR";
			ret += "\n";
		}
		// gibt den fertigen String ret zur�ck
		return ret;
	}

	static int[] entferneLetztesProdukt(int[] warenkorb) {
		// Pr�ft ob Warenkorb leer ist
		if (warenkorb.length == 0) {
			// gibt eine Fehlermeldung aus, wenn der Warenkorb leer ist und kein Produkt
			// entfernt werden kann
			System.out.println("Letztes Produkt konnte NICHT entfernt werden");
			// gibt den Warenkorb zur�ck
			return warenkorb;
		} else {
			// gibt eine Meldung aus, dass das letzte Produkt erfolgreich entfernt wurde
			System.out.println("Letztes Produkt erfolgreich entfernt");
			// k�rzt das Array um den letzten Index und gibt das kleinere Array zur�ck
			return Arrays.copyOf(warenkorb, warenkorb.length - 1);
		}
	}

	static int[] fuegeNeuesProduktHinzu(int[] warenkorb, int warenId) {
		// Pr�ft ob die �bergebene warenId zwischen 1 und 20 liegt
		if (warenId > 0 && warenId <= 20) {
			// Erweitert das Array um ein weiteres freies Feld
			warenkorb = Arrays.copyOf(warenkorb, warenkorb.length + 1);
			// f�gt die neue warenId in das neue letzte Feld ein
			warenkorb[warenkorb.length - 1] = warenId;
			// gibt eine Meldung aus, dass das Produkt "getProduktName(warenId)" erfolgreich
			// hinzugef�gt wurde
			System.out.println(getProduktName(warenId) + " erfolgreich hinzugefuegt");
		} else {
			// gibt eine Fehlermeldung aus, dass das Produkt nicht hinzugef�gt werden konnte
			System.out.println("Produkt konnte NICHT hinzugefuegt werden");
		}
		// gibt den Warenkorb zur�ck
		return warenkorb;
	}

	// ab hier zum selber schreiben
    
    public static double getProduktPreis(int produktId){

        double[] preis = { 0.79, 1.99, 1.29, 1.19, 0.79, 1.99, 0.89, 2.49, 0.59, 0.99, 0.99, 0.29, .29, 1.99, 1.49,0.79, 0.69, 0.79, 0.89, 0.99 };
        
        //Ausgabe des Preis für die entsprechende Produkt Id.
        //-1, weil die kleinste Produkt Id 1 ist, ein Array aber bei 0 beginnt.
        return preis[produktId-1];
    }

    public static String getProduktName(int produktId){
        String[] produktname = { "Milch (1 Liter)", "Eier (10 Stück)", "Brot (500g)", "Butter (250g)", "Nudeln (500g)","Reis (1kg)", "Kartoffeln (1kg)", "Tomaten (1kg)", "Gurke (1 Stück)", "Paprika (1 Stück)", "Zwiebeln (1kg)", "Knoblauch (1 Stück)", "Bananen (1kg)", "Orangen (1kg)", "Äpfel (1kg)", "Karotten (1kg)", "Joghurt (500g)", "Quark (500g)", "Frischkäse (200g)", "Schokolade (100g)" };
        
        //Ausgabe des Produktnames entsprechend der Produkt Id.
        return produktname[produktId-1];
    }

    public static double warenkorbSumme(int[] warenkorb){

        double summe = 0;

        //schleife von 0 bis länge des Warenkorbs
        for(int x = 0; x<warenkorb.length;x++){
            //zu der summe wird durch aufrufen der 'getProduktPreis' Funktion der Preis
            //des im Warenkorb liegenden Produkts dazugerechnet
            summe+= getProduktPreis(warenkorb[x]);
        }
        
		//runden und ausgabe der Summe um sie leslicher zu machen
        return Math.round(summe * 100.0) / 100.0;
    }

	public static String printLebensmittel(){

		String lebensmittel = "";
		// String zusammensetzen
		lebensmittel += "----- Lebensmittel -----";
		lebensmittel += "\n";
		lebensmittel += "Produkt \t \t Id";
		lebensmittel += "\n";
			
			for(int i = 1; i<21;i++){
				lebensmittel += getProduktName(i) + "\t \t" + i;
				lebensmittel += "\n";
			}

		return lebensmittel;
	}
	public static void main(String[] args) {

        //dekleration der Variablen
		int[] warenkorb = new int[0];
		Scanner scanner = new Scanner(System.in);
        int eingabeProduktId = 1;

		System.out.println(printLebensmittel());

        //schleife, die durch eingabe von 0 abgebrochen wird
        while(eingabeProduktId != 0){

            //eingabe eines Produkts durch die Konsole
            System.out.println("Füge ein Produkt zum Warenkorb hinzu");
            eingabeProduktId = scanner.nextInt();
            
            //wenn eingabe -1 ist
            if(eingabeProduktId == -1){
                //entfernen des zuletzt hinzugefügten Produkts im Warenkorb
                warenkorb = entferneLetztesProdukt(warenkorb);
            }

            else{
                //hinzufügen einer Produkt Id in den Warenkorb
                warenkorb = fuegeNeuesProduktHinzu(warenkorb, eingabeProduktId);
            }

            System.out.println("Aktueller Warenkorb:");

            System.out.println("\n");

			//ausgabe bisheriger Warenkorb
			System.out.println(printWarenkorb(warenkorb));

            System.out.println("\n");

		
	    }

        // Kassenzettel drucken
		System.out.println(printRechnung(warenkorb, warenkorbSumme(warenkorb)));
        
        scanner.close();
    }
}
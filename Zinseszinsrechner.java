
public class Zinseszinsrechner{

	public static void main(String[] args) {
		double zahl = SimpleIO.getDouble("Bitte geben Sie den Startbetrag ein.");
		double zinProcent = SimpleIO.getDouble("Bitte geben Sie den Zinssatz als Prozentwert ein.");
		double geld = zahl;
		int zeit = 0;
		double zielBetrag = 0;

		SimpleIO.output("Bitte waehlen Sie aus:" + "\n" + "Ziel : Berechnet die Zeit , bis ein gegebener Betrag angespart wurde ." + "\n" + "Zeit : Berechnet den Betrag , der nach einer gegebenen Zeit angespart wurde .", "Zinseszinsrechner");
		String str = SimpleIO.getString("Bitte waehlen Sie aus:");
		
		if(str.equals("Ziel")){
			
			zielBetrag = SimpleIO.getDouble("Bitte geben Sie den Zielbetrag ein.");
			while(zahl < zielBetrag){
				zahl = zahl * (1 + zinProcent / 100);
				zeit++;
			}
			SimpleIO.output("Es dauert " + zeit + " Jahre bei einem Zinssatz von " + zinProcent + " %, um von " + geld + " auf den Betrag " + zielBetrag + " zu sparen . Nach dieser Zeit hat man " + zahl + ".","Zinseszinsrechner");
		
		}else if(str.equals("Zeit")){
			
			zeit = SimpleIO.getInt("Bitte geben Sie die Zeit ein.");
			for(int i = 1; i <= zeit; i++){
				zahl = zahl * (1 + zinProcent / 100);
			}
			SimpleIO.output("Es dauert " + zeit + " Jahre bei einem Zinssatz von " + zinProcent + " %, um von " + geld + " auf den Betrag " + zahl + " zu haben .","Zinseszinsrechner");
		
		}else{

			SimpleIO.output("Keine gueltige Eingabe. Programm sagt: BBYYEE!!!","Fehlermeldung");
			return;

		}

		
	}
}
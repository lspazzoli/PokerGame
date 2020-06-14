import java.util.Scanner;

public class helpers{
	
	Scanner scanner;
	 
	public helpers() {
		scanner = new Scanner(System.in);
	}

	public void displayText(String outputText) {
		for(int numOfChar = 0; numOfChar < outputText.length(); numOfChar++) {
			System.out.print(outputText.charAt(numOfChar));
			try {
				Thread.sleep(20);
				} catch (InterruptedException e) {e.printStackTrace();}
		}
		System.out.println();
	}

	public String fetchInput() {
		String input = scanner.next();
		return input;
	}
	
	public void displayFiveCards(card[] hand) {
		String delt ="";
		for(int card = 0; card < 5; card++) {
			delt=delt+hand[card].getName()+"-";
		}
		displayText("Your Hand: "+delt);
	}
}

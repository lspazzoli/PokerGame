
public class pokerMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		helpers assistant = new helpers();
		rules rule = new rules();
		int pokerCardHand = 5;
		//Welcome message
		assistant.displayText("Welcome to The Ultimate Simulated Poker Game");
		assistant.displayText("This has been created For your entertainment durning lockdown ");
		assistant.displayText("It has also been created for you to see if I am the missing semicolon to your Java code, So Enjoy.\n");
		
		//Legal Agreement Cover
		assistant.displayText("This Program proudly supports the National Responsible Gambling Programme.");
		assistant.displayText("Winners know when to stop.");
		assistant.displayText("Only persons 18 years and older are permitted to gamble.");
		assistant.displayText("National problem gambling counselling toll-free helpline 0800 006 008.\n");
		
		
		//Acceptance of Use
		assistant.displayText("Please Type in Yes to confirm you are are 18 years or older:");
		String ageCheck = assistant.fetchInput();
		
		if(ageCheck.equals("Yes")) {
			//Proceed 
			cardDeck deck= new cardDeck();
			assistant.displayText("Creating Deck");
			card[] newDeck = deck.createDeck();
			assistant.displayText("Shuffling … Shuffling … Shuffling …");
			card[] pokerdeck = deck.shuffelDeck(newDeck);
			card [] hand = deck.deal(pokerdeck,pokerCardHand);
			assistant.displayFiveCards(hand);
			String outcome = rules.handStrengthPoker(hand);
			assistant.displayText("You Have:"+outcome);
			
			assistant.displayText("Another Hand?  Y/N\n\n");
			String ans = assistant.fetchInput();
			while(ans.equals("Y")) {
				newDeck = deck.createDeck();
				assistant.displayText("Shuffling … Shuffling … Shuffling …");
				pokerdeck = deck.shuffelDeck(newDeck);
				hand = deck.deal(pokerdeck,pokerCardHand);
				assistant.displayFiveCards(hand);
				outcome = rules.handStrengthPoker(hand);
				assistant.displayText("You Have:"+outcome+"");
				assistant.displayText("Another Hand?  Y/N\n\n");
				ans = assistant.fetchInput();			
			}
			
		}else {
			assistant.displayText("Error, you did not agree to T&C Program Terminating. GoodBye!");
		}
	}

}

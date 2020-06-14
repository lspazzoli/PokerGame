
public class cardDeck {
	char[] suitIcon = {'H','D','C','S'}; //{'\u2660','\u2666','\u2663','\u2764'};//"♣","♦","♥","♠".//Hearts Diamonds Clubs Spades
	
	
	public card[] createDeck() {
		//Gen 52 Cards
		card[] deck= new card[52];
		String name;
		for(int suit = 0 ; suit< 4; suit++) {
			for(int val = 1 ; val< 14; val++) {
				if (val == 1) {
					name = "A";
				} else if (val == 11) {
					name = "J";
				} else if (val == 12) {
					name = "Q";
				} else if (val == 13) {
					name = "K";
				} else{
					name = ""+val;
				}
				deck[suit*13+val-1]= new card(name+""+suitIcon[suit], suit*13+val, suitIcon[suit]+"", val);
			}
		}
		return deck;
	}
	
	public card[] shuffelDeck(card[] inputDeck) {

		card[] shuffledDeck= new card[52];
		int shufflecount = 0;
		for(int cardsLeft = 51; 0< cardsLeft; cardsLeft-- )//Move and pop the card
		{
			int randomCard = (int) Math.round((Math.random()*cardsLeft));
			shuffledDeck[shufflecount]=inputDeck[randomCard];//Pick a random card
			inputDeck[randomCard] = inputDeck[cardsLeft];//replace it with the end card
			shufflecount++;
		}
		return shuffledDeck;
	}
	
	public card[] deal(card[] inputDeck, int number) {
		card[] cardsDelt= new card[number];
		
		for(int cardsLeft = 0; cardsLeft<number; cardsLeft++ )//Move and pop the card
		{
			cardsDelt[cardsLeft]= inputDeck[cardsLeft];
			
		}
		return cardsDelt;//If multiplayer each player gets 5
		
	}

}

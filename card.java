//Note Cards can only ever be created and read, not edited, The cards are read only :)
public class card {
		
	String name;// IE 3♣ 7♦ 7♥ 7♠ K♥
	int number;//Out of 52 cards
	String suit;//"♣","♦","♥","♠".//Changed to letter instead
	int value;// 1-13 A=1 K=13
	
	public card(String name, int number, String suit, int value) {
		super();
		this.name = name;
		this.number = number;
		this.suit = suit;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value;
	}
	
	public String toString() {
		return this.name;
	}

	public String rankAsString(int val) {
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
		return name;
	}
}

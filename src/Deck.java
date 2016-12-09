
/*
 * A class which can be applied to heroes and contains a maximum of 60 cards
 * All cards in the deck must match the affinity of its hero
 */
public class Deck{
	private Card[] cards;
	private String name;
	private HERONAME hero;
	
	Deck()
	{
		cards = new Card[60];
	}
}
/*
 * A class which can be applied to heroes and contains a maximum of 60 cards
 * All cards in the deck must match the affinity of its hero
 */
public class Deck{
	private Card[] deckToPlay;
	private String name;
	private HERONAME hero;
	private boolean fullDeck;
	private int numCardsInDeck;
	
	Deck()
	{
		deckToPlay     = new Card[60];
		numCardsInDeck = 0;
	}
	
	/*
	 * Add a card to the deck
	 * Return 0 on success
	 * Return 1 if the deck is full
	 * Return 2 if the card does not match the hero's affinity 
	 */
	public int addCardToDeck(Hero currentHero, Card cardToAdd)
	{	
		//Is the deck full?
		if(fullDeck)
			return 1;
		
		//Does the card we want to add's affinity match the Hero's affinity
		for(int i =0; i<currentHero.getAffinity().length; i++)
		{
			if(currentHero.getAffinity()[i] == cardToAdd.getAffinity())
			{
				break;
			}
			
			if(i == currentHero.getAffinity().length - 1)
				return 2;
		}
		
		// We can add the card to the deck now!
		for(int i=0; i<=60; i++)
		{
			if(deckToPlay[i] == null)
				continue;
			
			deckToPlay[i++] = cardToAdd;
		}
		
		//Now we can set the full deck to true
		fullDeck = true;
	
		return 0;
	}
	
	
	/*
	 * Remove a card from the deck
	 * Return 0 on success 
	 */
	//TODO: This method will search an array to find which element to remove
	public int removeCardFromDeck(Deck deck, Card cardToRemove)
	{
		for(int i=0; i<=60; i++)
		{
			if(deckToPlay[i] == cardToRemove)
				deckToPlay[i] = null;
		}
		
		return 0;
	}
	
	
}
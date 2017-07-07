package deckBuilder;
import res.CONSTANTS.HERONAME;

/*
 * The Deck class can be applied to heroes and contains a maximum of 60 cards
 * All cards in the deck must match the affinity of its hero
 */
public class Deck{
	private Card[] deckToPlay;
	private String name;
	private HERONAME heroName;
	private boolean fullDeck;
	private int numCardsInDeck;
	

	Deck(HERONAME hero)
	{
		deckToPlay     = new Card[60];
		numCardsInDeck = 0;
		heroName       = hero;
	}
	
	/*
	 * Add a card to the deck
	 * Return 0 on success
	 * Return 1 if the deck is full
	 * Return 2 if the card does not match the hero's affinity 
	 */
	public int addCardToDeck(Card cardToAdd)
	{	
		//Is the deck full?
		if(fullDeck)
			return 1;

		
		//Does the card we want to add's affinity match the Hero's affinity
		if(cardToAdd.getAffinity() != heroName.getAffinity1() && cardToAdd.getAffinity() != heroName.getAffinity2())
			return 2;
		
		
		//We can add the card to the deck now!
		for(int i=0; i < numCardsInDeck; i++)
		{
			deckToPlay[numCardsInDeck] = cardToAdd;
		}
		
		// Now, is the deck full?
		if (numCardsInDeck >= 60)
			fullDeck = true;

		return 0;
	}
	
	
	/*
	 * Remove a card from the deck
	 * Return 0 on success 
	 * Return 1 if the deck is empty
	 */

	public int removeCardFromDeck(String nameOfCard)
	{
		
		//Is the deck empty?
		if(numCardsInDeck == 0)
			return 1;
		
		// Remove the card
		for(int i=0; i<numCardsInDeck; i++)
		{
			if(deckToPlay[i].getName() == nameOfCard)
			{
				deckToPlay[i] = deckToPlay[numCardsInDeck - 1];
				deckToPlay[numCardsInDeck - 1] = null;
				i--;
				break;
			}
			
		}
		
		return 0;
	}
	
	
}

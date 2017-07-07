package heroBuilder;

import res.CONSTANTS.HERONAME;
import res.CONSTANTS.AFFINITY;
import res.Tools;

import deckBuilder.Deck;
import deckBuilder.Card;
import deckBuilder.EquipmentCard;

/*
 * The Hero class contains all stats which belong to a hero
 * TODO: Will also need new constructor based on all input
 */
public class Hero{
	// Basic Rules
	private HERONAME name;
	private AFFINITY[] affinity;
	private int level;
	private double cardScale;
	private boolean fullHand;
	private boolean emptyHand;
	
	// Offensive Stats
	private double lc_BaseDmg;
	private double q_BaseDmg;
	private double e_BaseDmg;
	private double r_BaseDmg;
	private double rc_BaseDmg;	
	
	private double lc_Cooldown;
	private double q_Cooldown;
	private double e_Cooldown;
	private double r_Cooldown;
	private double rc_Cooldown;	
	
	// Defensive Stats
	private double health;
	private double basicResist;
	private double abilityResist;
	
	// Misc Stats
	private double mana;
	private double manaRegen;
	private double healthRegen;
	
	// Cards and a Deck for the Hero
	private Deck deck;
	private Card[] hand;

	//TODO: This constructor will be useless. We want the constructor to be based on input
	public Hero(HERONAME name){
		affinity = Tools.getHeroAffinity(name);
	}
	
	// This constructor will be able to deep copy a Hero for later use.
	//TODO: Edit this
	public Hero(Hero hero)
	{
		hero.getAbilityResist();
		hero.getAffinity();
		hero.getBasicResist();
		hero.getCardScale();
		hero.getDeck();
		hero.getE_BaseDmg();
		hero.getE_Cooldown();
		hero.getHand();
		hero.getHealth();
		hero.gethealthRegen();
		hero.getLc_BaseDmg();
		hero.getLc_Cooldown();
		hero.getLevel();
		hero.getMana();
		hero.getmanaRegen();
		hero.getName();
		hero.getQ_BaseDmg();
		hero.getQ_Cooldown();
		hero.getR_BaseDmg();
		hero.getR_Cooldown();
		hero.getRc_BaseDmg();
		hero.getRc_Cooldown();
	}
	

	/*
	 *  Add an Equipment Card to a Hero's Hand
	 *  Return 0 on success
	 *  Return 1 if the hand is full
	 *  Return 2 if the index is 4 or 5 and the card is active
	 *  Return 3 if the index is occupied
	 */
	
	public int addEquipmentCardToHand(EquipmentCard cardToAdd, int indexInHand)
	{
		//Is the hand full
		if(fullHand)
			return 1;
		
		// Active cards cannot be in index 4 or 5
		if(indexInHand == 4 || indexInHand == 5 && cardToAdd.isActive())
			return 2;
		
		// Is that index occupied?
		if(hand[indexInHand] != null)
			return 3;
		
		//Allowed to add the card to the hand now at that particular index
		hand[indexInHand] = cardToAdd;

		return 0;
	}
	
	/*
	 *  Remove a Card from a Hero's Hand
	 *  Return 0 on success
	 *  Return 1 if the hand is empty
	 */
	
	public int removeCardFromHand(int indexInHand)
	{
		//Is the Hand empty?
		if(emptyHand)
			return 1;
		
		//We need to remove that certain index in the array
		hand[indexInHand] = null;
		
		return 0;
	}
	
	
	// Getters to expose the Hero for later use
	public HERONAME getName() {return name;}

	public AFFINITY[] getAffinity() {return affinity;}

	public int getLevel() {return level;}

	public double getCardScale() {return cardScale;}

	public double getLc_BaseDmg() {return lc_BaseDmg;}

	public double getQ_BaseDmg() {return q_BaseDmg;}

	public double getE_BaseDmg() {return e_BaseDmg;}

	public double getR_BaseDmg() {return r_BaseDmg;}

	public double getRc_BaseDmg() {return rc_BaseDmg;}

	public double getLc_Cooldown() {return lc_Cooldown;}

	public double getQ_Cooldown() {return q_Cooldown;}

	public double getE_Cooldown() {return e_Cooldown;}

	public double getR_Cooldown() {return r_Cooldown;}

	public double getRc_Cooldown() {return rc_Cooldown;}

	public double getHealth() {return health;}

	public double getBasicResist() {return basicResist;}

	public double getAbilityResist() {return abilityResist;}

	public double getMana() {return mana;}

	public double getmanaRegen() {return manaRegen;}

	public double gethealthRegen() {return healthRegen;}

	public Deck getDeck() {return deck;}

	// We want to set the deck inside a hero
	public void setDeck(Deck deck) {this.deck = deck;}

	public Card[] getHand() {return hand;}

	// We will want to set the hand inside a hero
	public void setHand(Card[] hand) {this.hand = hand;}

	
}
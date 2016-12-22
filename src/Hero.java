/*
 * The Hero class contains all stats which belong to a hero
 * Majority of class will only require getters (no setters)
 * Will also need new constructor based on all input
 */
public class Hero{
	// rules
	private HERONAME name;
	private AFFINITY[] affinity;
	private ROLE role;
	private int level;
	private double cardScale;
	private boolean completeActiveHand;
	private boolean completePassiveHand;
	
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
	
	private Deck deck;
	private Card[] hand;
	private int numActiveCardsInHand  = 0;
	private int numPassiveCardsInHand = 0;
	
	public Hero(HERONAME name){
		affinity = Tools.getHeroAffinity(name);
		role = Tools.getHeroRole(name);
		cardScale = Tools.getHeroCardScale(role);		
	}
	

	// TODO: Do we want a separate active card/passive card method?

	/*
	 *  Add a Card to a Hero's Hand
	 *  Return 0 on success
	 *  Return 1 if active positions in hand are full
	 *  Return 2 if passive positions in hand are full
	 *  Reutrn 3 if the card cannot be added based on the affinity
	 */
	//TODO: We will need to add the card from the player's deck
	public int addCardtoHand(Hero currentHero, Deck[] deck, EquipmentCard cardToAdd)
	{
		//We need to get the deck
		
		//Are the active positions full?
		if(completeActiveHand)
		{
			return 1;
		}
		
		//Are the passive positions full?
		if(completePassiveHand)
		{
			return 2;
		}
		
		
		// We can add the card to the hero's hand now!
		// Which slot does it go into?
		
		// Now, are the Active positions in the hand filled?
		if (numActiveCardsInHand >= 4)
			completeActiveHand = true;
		
		// What about the passive hand?
		if (numPassiveCardsInHand >= 2)
			completePassiveHand = true;
		
		return 0;
	}
	
	/*
	 *  Remove a card from a Hero's Hand
	 *  Return 0 on success
	 *  Return 1 if card can not be added based on stats of the card
	 */
	//TODO: We will have to remove this card from the Hand and add it back to
	//The player's deck
	public int removeCardFromHand(Hero currentHero, EquipmentCard cardToRemove)
	{
		currentHero.getHand();
		
		//Will an active card or passive card be removed?
		cardToRemove.isActive();
	
		
		
		return 0;
	}
	
	
	public HERONAME getName() {return name;}

	public AFFINITY[] getAffinity() {return affinity;}

	public ROLE getRole() {return role;}

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

	public double getMana_regen() {return manaRegen;}

	public double getHealth_regen() {return healthRegen;}

	public Deck getDeck() {return deck;}

	public void setDeck(Deck deck) {this.deck = deck;}

	public Card[] getHand() {return hand;}

	public void setHand(Card[] hand) {this.hand = hand;}

	
}
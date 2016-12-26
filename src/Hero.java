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
	
	private Deck deck;
	private Card[] hand;
	private int maxCardsInHand = 6;
	
	public Hero(HERONAME name){
		affinity = Tools.getHeroAffinity(name);
		role = Tools.getHeroRole(name);
		cardScale = Tools.getHeroCardScale(role);		
	}
	

	/*
	 *  Add an Equipment Card to a Hero's Hand
	 *  Return 0 on success
	 *  Return 1 if hand is full
	 */
	
	public int addEquipmentCardToHand(EquipmentCard cardToAdd, int indexInHand)
	{
		//Check if the hand is full
		if(fullHand)
			return 1;
		
		//Allowed to add the card to the hand now
		for(int i=0; i<=maxCardsInHand; i++)
		{
			if(hand[i] == null)
				hand[i] = cardToAdd;
		}
		
		if(indexInHand == maxCardsInHand)
			fullHand = true;
		
		return 0;
	}
	
	
	/*
	 * Add an Upgrade Card to a Hero's hand
	 * Return 0 on success
	 * Return 1 when the hand is full
	 */
	
	public int addUpgradeCardToHand(UpgradeCard cardToAdd, int indexInHand)
	{
		//Check if the hand is full
		if(fullHand)
			return 1;
		
		//Allowed to add the card to the hand now
		for(int i=0; i<=maxCardsInHand; i++)
		{
			if(hand[i] == null)
				hand[i] = cardToAdd;
		}
		if(indexInHand == maxCardsInHand)
			fullHand = true;
		
		return 0;
	}
	
	/*
	 *  Remove a Card from a Hero's Hand
	 *  Return 0 on success
	 *  Return 1 if the hand is empty
	 */

	//TODO: Do we really care about what card to remove? upgrade vs. equipment?
	public int removeCardFromHand(int indexInHand)
	{
		//Is the Hand empty?
		if(emptyHand)
			return 1;
		
		//We need to remove that certain index in the array
		//TODO: Do we need to loop through our hand?
		hand[indexInHand] = null;
		
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
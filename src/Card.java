/*
 * The Card class templates what a card is and where it can be used
 */
public class Card
{
	private String name;
	private int cost;
	private AFFINITY affinity;
	
	public void setName(String name) {this.name = name;}
	public String getName(){return name;}

	public void setCost(int cost) {this.cost = cost;}
	public int getCost(){return this.cost;}

	public void setAffinity(AFFINITY affinity) {this.affinity = affinity;}
	public AFFINITY getAffinity(){return this.affinity;}
}

/*
 * A specific card which is placed in a Hero's deck and can be selected for usage
 * Equipment cards can have at most 3 UpgradeCards assigned to them
 * UpgradeCards must match at least one of the passives the card exhibits
 * Equipment cards can be active or passive
 * Some EquipmentCards provide bonuses when filled with 3 UpgradeCards
 */
class EquipmentCard extends Card
{
	// Ignore actual active bonuses but keep in mind only 4 active cards may be placed in a hand
	private boolean active;
	// Not all cards are slotted
	// Not all cards which are slotted, provide bonuses
	private boolean slotted;
	private boolean filled; //This says the Equipment card is completely filled with 3 upgrade cards.
	
	private UPGRADE[] fillBonus;
	private UPGRADE[] passives;
	
	
	private UpgradeCard[] slots; //Ranges 0-2 in the array

	
	
	
	/*
	 *  This prototype doesn't make much sense.  There are far too many cards in the game to do this manually
	 *  These should be handled by reading a CSV which loads all cards into a class containing all cards.
	 *  There are currently about 300 cards in the game with more to come (including UpgradeCards)
	 */
	
	public EquipmentCard(String name, int cost, AFFINITY affinity, boolean active, boolean slotted, UPGRADE[] passives, UPGRADE[] fillBonus)
	{
		super.setName(name);
		super.setCost(cost);
		super.setAffinity(affinity);
		
		this.active = active;
		this.slotted = slotted;		
		if (slotted)
			slots = new UpgradeCard[3];
	
		this.passives = passives;
		this.fillBonus = fillBonus;
	}
	
	public UPGRADE[] getFillBonus() {return fillBonus;}

	public void setFillBonus(UPGRADE[] fillBonus) {this.fillBonus = fillBonus;}

	
	/*
	 *  Add upgradeCard to this equipment card
	 *  Return 0 on success
	 *  Return 1 if card is not slotted
	 *  Return 2 if card is slotted, but full
	 *  Return 3 if upgrade card does not match equipment card upgrade
	 */
	
	public int addUpgradeCard(UpgradeCard upgradeCard)
	{
		
		// What upgrade card is this?
		String name           = upgradeCard.getName();
		int cost              = upgradeCard.getCost();
		AFFINITY cardAffinity = upgradeCard.getAffinity();
		UPGRADE stats         = upgradeCard.getUpgrade();
		int numSlots          = 0;
		
		//Is the card full?
		if(filled)
		{
			return 2;
		}
		
		//Is this upgrade card allowed to be inside of this equipment card?
		
		
		
		
		
		//Is the equipment card slotted, and how many slots are filled?

		
		
		//How many slots does the equipment card currently have?
		
		
		
		//Does this card deal with Fill Bonuses?
		
		
		//Now we can add the Upgrade Card!
		
		
/*
		
		//Get upgradecard value and compare against all values in passives
		else if (false)
			return 3;
		
		else
		upgrades[numUpgrades] = upgradeCard;
		numUpgrades++;
		
		if (numUpgrades >= 2)
			filled = true;
		*/
		
		//Flip the filled flag back 
		
		numSlots++;
		return 0;			
	}

	/*

	public UpgradeCard[] getUpgrades() {
		return upgrades;
	}

	public void setUpgrades(UpgradeCard[] upgrades) {
		this.upgrades = upgrades;
	}

	public int getNumUpgrades() {
		return numUpgrades;
	}

	public void setNumUpgrades(int numUpgrades) {
		this.numUpgrades = numUpgrades;
	}
		*/



}

/*
 * A specific type of card which can only be applied to an Equipment Card
 * Output of upgrade card = cost * value of upgrade
 * Should UpgradeCards be created like this or loaded in via CSV as well?
 * CSV will maintain consistency with other cards
 * However, Upgrade cards are much more simplistic in their efficiency being a 1:1 output(pt:value)
 */
class UpgradeCard extends Card
{
	private UPGRADE upgrade;
	
	UpgradeCard(String name, int cost, AFFINITY affinity, UPGRADE upgrade)
	{
		super.setName(name);
		super.setCost(cost);
		super.setAffinity(affinity);
		this.upgrade = upgrade;
	}
	
	public UPGRADE getUpgrade(){return this.upgrade;}
}
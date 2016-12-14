/*
 * The Card class templates what a card is and where it can be used
 */
public class Card{
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
class EquipmentCard extends Card{
	// Ignore actual active bonuses but keep in mind only 4 active cards may be placed in a hand
	private boolean active;
	private boolean filled;
	// Not all cards are slotted
	// Not all cards which are slotted, provide bonuses
	private boolean slotted;
	
	// The size of this array will range between 1-3 (or 4)
	private UPGRADE[] passives;
	private UpgradeCard[] upgrades;
	private int numUpgrades;
	
	private UPGRADE[] fillBonus;
	
	/*
	 *  This prototype doesn't make much sense.  There are far too many cards in the game to do this manually
	 *  These should be handled by reading a CSV which loads all cards into a class containing all cards.
	 *  There are currently about 300 cards in the game with more to come (including UpgradeCards)
	 */
	
	public EquipmentCard(boolean slotted)
	{
		if (slotted)
			passives = new UPGRADE[3];
	}
	
	/*
	 *  Add upgradeCard to this equipment card
	 *  Return 0 on success
	 *  Return 1 if card is not slotted
	 *  Return 2 if card is slotted, but full
	 *  Return 3 if upgrade card does not match equipment card upgrade
	 */
	public int addUpgradeCard(UpgradeCard upgradeCard)
	{
		if (!slotted)
			return 1;
		
		else if (filled)
			return 2;
		
		//Get upgradecard value and compare against all values in passives
		else if (false)
			return 3;
		
		else
		upgrades[numUpgrades] = upgradeCard;
		numUpgrades++;
		
		if (numUpgrades >= 2)
			filled = true;
		
		return 0;			
	}

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

	public UPGRADE[] getFillBonus() {
		return fillBonus;
	}

	public void setFillBonus(UPGRADE[] fillBonus) {
		this.fillBonus = fillBonus;
	}

	

}

/*
 * A specific type of card which can only be applied to an Equipment Card
 * Output of upgrade card = cost * value of upgrade
 * Should UpgradeCards be created like this or loaded in via CSV as well?
 * CSV will maintain consistency with other cards
 * However, Upgrade cards are much more simplistic in their efficiency being a 1:1 output(pt:value)
 */
class UpgradeCard extends Card{
	private UPGRADE upgrade;
	
	UpgradeCard(UPGRADE upgrade)
	{
		this.upgrade = upgrade;
	}
	
	public UPGRADE getUpgrade(){return this.upgrade;}
}
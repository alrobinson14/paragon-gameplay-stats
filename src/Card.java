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
	private boolean filled; //This says if the Equipment card is completely filled with 3 upgrade cards.


	private int numOfUpgradeCards = 0;
	
	private UPGRADE[] fillBonus;
	private UPGRADE[] passives;
	
	
	private UpgradeCard[] upgradeCards; //How many upgrade cards do we have.

	
	
	
	/*
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
			upgradeCards = new UpgradeCard[3];
	
		this.passives = passives;
		this.fillBonus = fillBonus;
	}
	
	public UPGRADE[] getFillBonus() {return fillBonus;}
	
	public UPGRADE[] getPassives() {return passives;}
	
	public boolean isActive() {return active;}

	public UPGRADE[] getUpgrades()
	{
		if(!slotted)
			return null;
		
		if(numOfUpgradeCards == 0)
			return null;
		
		int totalUpgradeValue = 0;
		
		for(int i=0; i < numOfUpgradeCards; i++)
		{
			totalUpgradeValue += upgradeCards[i].getCost();
		}
				
		UPGRADE[] upgrades = new UPGRADE[totalUpgradeValue];
				
		for(int i=0; i < numOfUpgradeCards; i++)
		{
			for(int j=0; j < upgradeCards[j].getCost(); j++)
			{
				upgrades[i] = upgradeCards[i].getUpgrade();
			}
		}
				
		return upgrades;
	}
	
	/*
	 *  Add upgradeCard to this equipment card
	 *  Return 0 on success
	 *  Return 1 if card is not slotted
	 *  Return 2 if card is full
	 *  Return 3 if upgrade card does not match equipment card upgrade
	 */


	public int addUpgradeCard(UpgradeCard currentUpgradeCard)
	{
		//Is the card slotted?
		if (!slotted)
			return 1;

		
		//Is the card full?
		if (filled)
			return 2; 

	
		//Is this upgrade card allowed to be inside of this equipment card?
		for(int i = 0; i < passives.length; i++)
		{
			//What stat does the card contain?
			if(currentUpgradeCard.getUpgrade() == passives[i])
				break;
			
			if(i == passives.length - 1)
				return 3;
			
		}		
		
		//Now we can add the Upgrade Card!
		upgradeCards[numOfUpgradeCards] = currentUpgradeCard;
		numOfUpgradeCards++;
		
		// Now, is the Equipment card filled?
		if (numOfUpgradeCards >= 2)
			filled = true;

		return 0;			
	}
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

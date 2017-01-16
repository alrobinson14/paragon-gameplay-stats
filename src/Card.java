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
 * class EquipmentCard is extension of card that specifies what an equipment card is and what it can do.
 * 
 * Equipment cards- specific card which is placed in a Hero's deck and can be selected for usage
 * Can have at most 3 UpgradeCards assigned to them
 * UpgradeCards must match at least one of the passives the card exhibits
 * Equipment cards can be active or passive
 * Some EquipmentCards provide bonuses when filled with 3 UpgradeCards
 */

class EquipmentCard extends Card
{
	// Is the card active? If not - passive.
	private boolean active;
	
	// Not all cards are slotted
	// Not all cards which are slotted, provide bonuses
	private boolean slotted;
	
	// Is the card filled with 3 upgrade cards?
	private boolean filled; 

	private int numOfUpgradeCards = 0;
	
	// Inside of an upgrade card is it's "attribute" power, speed, etc. 
	private UPGRADE[] fillBonus;
	private UPGRADE[] passives;
	
	
	// This is the array of upgrade cards - total of 3 cards can be in this array.
	private UpgradeCard[] upgradeCards; 

	
	
	
	/*
	 *  Equipment card constructor that will pass in what is in the CSV
	 *  
	 *  These should be handled by reading a CSV which loads all cards into a class containing all cards.
	 *  There are currently about 300 cards in the game with more to come (including UpgradeCards)
	 */
	
	public EquipmentCard(String name, int cost, AFFINITY affinity, boolean active, boolean slotted, UPGRADE[] passives, UPGRADE[] fillBonus)
	{
		super.setName(name);
		super.setCost(cost);
		super.setAffinity(affinity);
		
		this.active  = active;
		this.slotted = slotted;		
		if (slotted)
			upgradeCards = new UpgradeCard[3];
	
		this.passives  = passives;
		this.fillBonus = fillBonus;
	}
	
	/*
	 * getUpgrades()
	 * 
	 * Allows us to get the attributes of an equipment card for further processing
	 * 
	 */
	
	public UPGRADE[] getUpgrades()
	{
		// We want the card to be slotted
		if(!slotted)
			return null;
		
		// We want an upgrade card to get, otherwise we can't get the upgrade card.
		if(numOfUpgradeCards == 0)
			return null;
		
		// Keeping track of the value of the upgrades
		int totalUpgradeValue = 0;
		
		// Looping through the number of upgrade cards, and getting the total cost of the cards.
		for(int i=0; i < numOfUpgradeCards; i++)
		{
			totalUpgradeValue += upgradeCards[i].getCost();
		}
				
		// Creating a new array of upgrades with the total value of the cards
		UPGRADE[] upgrades = new UPGRADE[totalUpgradeValue];
				
		// Looping through the total number of upgrade cards
		for(int i=0; i < numOfUpgradeCards; i++)
		{
			// Looping through the cost of the card
			for(int j=0; j < upgradeCards[j].getCost(); j++)
			{
				// Get the upgrade, and place it into the upgrades array
				upgrades[i] = upgradeCards[i].getUpgrade();
			}
		}
				
		return upgrades;
	}
	
	// Getter methods to expose to other classes
	public UPGRADE[] getFillBonus() {return fillBonus;}
	public UPGRADE[] getPassives()  {return passives;}
	public boolean isActive()       {return active;}

	
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
		if (numOfUpgradeCards >= 3)
			filled = true;

		return 0;			
	}
}

/*
 * UpgradeCard is extension of card that specifies what an equipment card is and what it can do.
 * 
 * A specific type of card which can only be applied to an Equipment Card
 * Output of upgrade card = cost * value of upgrade
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

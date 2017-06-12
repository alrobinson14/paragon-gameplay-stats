package epicComm.objects.cards;

import epicComm.objects.misc.Images;

public class Card {
	
	private String id,
					name,
					slotType,
					rarity;

	private Images images;
	private String[] affinities;
	
	private int cost,
				upgradeSlots;
	
	private Effect[] effects,
					 maxedEffects;
	
	public Card(String id, String name, String slotType, String rarity, Images images, String[] affinities, int cost, int upgradeSlots, Effect[] effects, Effect[] maxedEffects){
		this.id=id;
		this.name=name;
		this.slotType=slotType;
		this.rarity=rarity;
		this.images=images;
		this.affinities=affinities;
		this.cost=cost;
		this.upgradeSlots=upgradeSlots;
		this.effects=effects;
		this.maxedEffects=maxedEffects;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSlotType() {
		return slotType;
	}

	public String getRarity() {
		return rarity;
	}

	public Images getImages() {
		return images;
	}

	public String[] getAffinities() {
		return affinities;
	}
	
	public String getAffinity(){
		return affinities[0];
	}

	public int getCost() {
		return cost;
	}

	public int getUpgradeSlots() {
		return upgradeSlots;
	}

	public Effect[] getEffects() {
		return effects;
	}

	public Effect[] getMaxedEffects() {
		return maxedEffects;
	}

}

package epicComm.objects.heroes;

import epicComm.objects.misc.Images;

public class Ability {
	
	private String name,
				  description,
				  shortDescription,
				  type,
				  binding,
				  damageType;
	
	private int maxLevel;	
	
	private ModifiersByLevel[] modifiersByLevel;
	
	private Images images;
	
	public Ability(String name, String description, String shortDescription, String type, String binding, String damageType,
				   int maxLevel, ModifiersByLevel[] modifiersByLevel, Images images){
		this.name=name;
		this.description=description;
		this.shortDescription=shortDescription;
		this.type=type;
		this.binding=binding;
		this.damageType=damageType;
		this.maxLevel=maxLevel;
		this.modifiersByLevel=modifiersByLevel;
		this.images=images;
		
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public String getType() {
		return type;
	}

	public String getBinding() {
		return binding;
	}

	public String getDamageType() {
		return damageType;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public ModifiersByLevel[] getModifiersByLevel() {
		return modifiersByLevel;
	}
	
	public ModifiersByLevel getModifiersForLevel(int level) {
		return modifiersByLevel[level];
	}

	public Images getImages() {
		return images;
	}
}

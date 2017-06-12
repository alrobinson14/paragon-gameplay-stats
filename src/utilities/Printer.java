package utilities;

import epicComm.objects.cards.Card;
import epicComm.objects.cards.Effect;
import epicComm.objects.heroes.Ability;
import epicComm.objects.heroes.AttributesByLevel;
import epicComm.objects.heroes.Hero;
import epicComm.objects.heroes.ModifiersByLevel;
import epicComm.objects.heroes.Stats;
import epicComm.objects.misc.Images;

public class Printer {
	
	public static void printCard(Card card){
		System.out.println("ID: "+card.getId());
		System.out.println("Name: "+card.getName());
		System.out.println("Slot Type: "+card.getSlotType());
		
		System.out.println("Images: ");
		Images images = card.getImages();
			System.out.println("   Icon: "+images.getIcon());
			System.out.println("   Medium: "+images.getMedium());
			System.out.println("   Medium Stats: "+images.getMedium_stats());
			System.out.println("   Large: "+images.getLarge());
			System.out.println("   Large Stats: "+images.getLarge_stats());
		
		System.out.println("Rarity: "+card.getRarity());

		System.out.println("Affinities: ");
		for (String affinity : card.getAffinities())
			System.out.println("  "+affinity);
		
		System.out.println("Cost: "+card.getCost());
		System.out.println("Upgrade Slots: "+card.getUpgradeSlots());
		
		if (card.getEffects()!=null)
			for (Effect effect : card.getEffects()){
				System.out.println("Effects: ");
				System.out.println("   Description: "+effect.getDescription());
				System.out.println("   Stat: "+effect.getStat());
				System.out.println("   Value: "+effect.getValue());
				System.out.println("   Passive: "+effect.isPassive());
				System.out.println("   Unique: "+effect.isUnique());
				System.out.println("   Cooldown: "+effect.getCooldown());
			}
		if (card.getMaxedEffects()!=null){
			for (Effect effect : card.getMaxedEffects()){
				System.out.println("Maxed Effects: ");
				System.out.println("   Description: "+effect.getDescription());
				System.out.println("   Stat: "+effect.getStat());
				System.out.println("   Value: "+effect.getValue());
				System.out.println("   Passive: "+effect.isPassive());
				System.out.println("   Unique: "+effect.isUnique());
				System.out.println("   Cooldown: "+effect.getCooldown());
			}
		}
		System.out.println("");
		
	}
	
	public static void printHero(Hero hero){
		System.out.println("ID: "+hero.getId());
		System.out.println("Name: "+hero.getName());
		System.out.println("Attack: "+hero.getAttack());
		
		System.out.println("Traits: ");
		for (String trait: hero.getTraits())
			System.out.println("   "+trait);
		
		System.out.println("Scale: "+hero.getScale());
		System.out.println("Release Date: "+hero.getReleaseDate());
		
		System.out.println("Affinities: ");
		for (String affinity : hero.getAffinities())
			System.out.println("  "+affinity);
		
		System.out.println("Difficulty: "+hero.getDifficulty());
		System.out.println("Stats:");
		Stats stats = hero.getStats();
		System.out.println("  Mobility: "+stats.getMobility());
		System.out.println("  Basic Attack: "+stats.getBasicAttack());
		System.out.println("  Durability: "+stats.getDurability());
		System.out.println("  Ability Attack: "+stats.getAbilityAttack());
		
		System.out.println("Images: ");
		Images images = hero.getImages();
			System.out.println("   Icon: "+images.getIcon());
			System.out.println("   Medium: "+images.getMedium());
			System.out.println("   Medium Stats: "+images.getMedium_stats());
			System.out.println("   Large: "+images.getLarge());
			System.out.println("   Large Stats: "+images.getLarge_stats());
		
		AttributesByLevel[] attributesByLevel = hero.getAttributesByLevel();
		for (int n = 0; n<15; n++){
			System.out.println("Level "+(n+1)+" Attributes: ");
			System.out.println("Offensive Traits:");
			System.out.println("   Basic Cooldown: "+attributesByLevel[n].getBaseAttackTime());
			System.out.println("   Attack Speed Rating: " +attributesByLevel[n].getAttackSpeedRating()); 
			System.out.println("   Basic Pen: "+attributesByLevel[n].getBasicPenetrationRating()); 
			System.out.println("   Ability Pen: "+attributesByLevel[n].getAbilityPenetrationRating()); 
			System.out.println("   Cleave Rating: "+attributesByLevel[n].getCleaveRating()); 

			System.out.println("Defensive Traits:");
			System.out.println("   Max Health: "+attributesByLevel[n].getMaxHealth()); 
			System.out.println("   Health Regen: "+attributesByLevel[n].getHealthRegenRate()); 
			System.out.println("   Basic Resist: "+attributesByLevel[n].getBasicResistanceRating()); 
			System.out.println("   Ability Resist: "+attributesByLevel[n].getAbilityResistanceRating()); 

			System.out.println("Utility Traits:");
			System.out.println("   Mana: "+attributesByLevel[n].getMaxEnergy()); 
			System.out.println("   Mana Regen: "+attributesByLevel[n].getEnergyRegenRate()); 
			System.out.println("");
		}
			
			Ability[] abilities = hero.getAbilities();
			
			for (int n = 0; n<5; n++){
				Ability ability = abilities[n];
				System.out.println("Name: "+ability.getName());
				System.out.println("Description: "+ability.getDescription());
				System.out.println("Short Description: "+ability.getShortDescription());
				System.out.println("Type: "+ability.getType());
				System.out.println("Binding: "+ability.getBinding());
				System.out.println("Damage Type: "+ability.getDamageType());
				System.out.println("Max Level: "+ability.getMaxLevel()); 
				ModifiersByLevel[] mods = ability.getModifiersByLevel();
				for (int m = 0; m<ability.getMaxLevel(); m++){
					System.out.println("Modifiers at Level "+(m+1)+":");
					System.out.println("   Damage: "+mods[m].getDamage());
					System.out.println("   Damage Ability Ult: "+mods[m].getDamageAbilityUlt());
					System.out.println("   Attack Rating: "+mods[m].getAttackRatingCoefficient());
					System.out.println("   Cooldown: "+mods[m].getCooldown());
					System.out.println("   Mana Cost: "+mods[m].getEnergyCost());
					System.out.println("   Health Passive: "+mods[m].getHealthPassive());
					System.out.println("   Damage Passive: "+mods[m].getDamagePassive());
					System.out.println("   Damage Ability Primary: "+mods[m].getDamageAbilityPrimary());
					System.out.println("   Slow Secondary: "+mods[m].getSlowSecondary());
					System.out.println("   Slow Long: "+mods[m].getSlowLong());
					System.out.println("   Root Short: "+mods[m].getRootShort());	
					System.out.println("");
				}
			}
		}
}

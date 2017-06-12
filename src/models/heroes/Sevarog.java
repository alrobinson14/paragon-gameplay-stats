package models.heroes;

import epicComm.objects.heroes.Ability;
import epicComm.objects.heroes.Hero;
import epicComm.objects.heroes.ModifiersByLevel;

public class Sevarog extends Hero{
	
	private int soulStacks = 0;
	private final int maxStacks = 200;
		
	public Sevarog(Hero hero){
		super(hero.getId(), hero.getName(), hero.getAttack(), hero.getTraits(), hero.getScale(), hero.getReleaseDate(), 
				hero.getAffinities(), hero.getDifficulty(), hero.getStats(), hero.getImages(), hero.getAttributesByLevel(),
				hero.getAbilities());	
		
		soulStacks = 0;
	}
		
	public void setSoulStacks(int stacks){
		if (stacks > maxStacks)
			return;
		else{
			soulStacks=stacks;
		}
	}
	
	public int getSoulStacks(){
		return soulStacks;
	}
	
	
	public float getBonusHealth(){
		// Bonus Health per stack
		float healthMultiplier = 0;
		Ability[] abilities = getAbilities();
		for (int n=0; n<abilities.length; n++)
			if ("Siphon".equals((abilities[n].getName()))){
				ModifiersByLevel[] mods = abilities[n].getModifiersByLevel();
				healthMultiplier = mods[0].getHealthPassive();
			}

		// Bonus Health per growth
		float growStacks = 0;
		if (soulStacks >=140)
			growStacks=140;
		else if (soulStacks >=90)
			growStacks=90;
		else if (soulStacks >=50)
			growStacks=50;
		else if (soulStacks >=20)
			growStacks=20;
		return (soulStacks * healthMultiplier) + growStacks;
	}
	
	public float getBonusAbilityDamage(){
		// Bonus Ability damage per soul
		float damageMultiplier = 0;
		Ability[] abilities = getAbilities();
		for (int n=0; n<abilities.length; n++)
			if ("Siphon".equals((abilities[n].getName()))){
				ModifiersByLevel[] mods = abilities[n].getModifiersByLevel();
				damageMultiplier = mods[0].getDamagePassive();
			}
		
		// Bonus Ability damage per growth
		float growStacks = 0;
		if (soulStacks >=140)
			growStacks=25;
		else if (soulStacks >=90)
			growStacks=20;
		else if (soulStacks >=50)
			growStacks=15;
		else if (soulStacks >=20)
			growStacks=10;
		return (soulStacks * damageMultiplier) + growStacks;
	}
}

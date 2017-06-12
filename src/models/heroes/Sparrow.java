package models.heroes;

import java.util.HashMap;

import ai.Player;
import epicComm.objects.heroes.Hero;

public class Sparrow extends Hero{
		
	private HashMap<Player, Integer> relentlessStacks;
	
	public Sparrow(Hero hero){
		super(hero.getId(), hero.getName(), hero.getAttack(), hero.getTraits(), hero.getScale(), hero.getReleaseDate(), 
				hero.getAffinities(), hero.getDifficulty(), hero.getStats(), hero.getImages(), hero.getAttributesByLevel(),
				hero.getAbilities());	
		
		relentlessStacks = new HashMap<>();
	}
	
	public Integer getStacks(Player target){
		return relentlessStacks.get(target);
	}
	
	public void setStacks(Player target, int stacks)
	{
		relentlessStacks.put(target,  stacks);
	}
	
	public void incStacks(Player target){
		if (relentlessStacks.containsKey(target)){
			int stacks = relentlessStacks.get(target);
			if (stacks>=5)
				return;
			else{
				stacks++;
				relentlessStacks.put(target,  stacks);
			}
		}
	}
}

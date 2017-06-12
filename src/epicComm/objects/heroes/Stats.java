package epicComm.objects.heroes;

public class Stats {
	
	private int Mobility,
	   BasicAttack,
	   Durability,
	   AbilityAttack;
	
	public Stats(int mobility, int basicAttack, int durability, int abilityAttack){
		this.Mobility = mobility;
		this.BasicAttack = basicAttack;
		this.Durability = durability;
		this.AbilityAttack = abilityAttack;
	}
	
	public int[] getStats(){
		return new int[]{Mobility, BasicAttack, Durability, AbilityAttack};
	}
	
	public int getMobility(){
		return Mobility;
	}
	
	public int getBasicAttack(){
		return BasicAttack;
	}
	
	public int getDurability(){
		return Durability;
	}
	
	public int getAbilityAttack(){
		return AbilityAttack;
	}
}

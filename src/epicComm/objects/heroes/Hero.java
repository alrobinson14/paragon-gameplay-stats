package epicComm.objects.heroes;

import java.util.ArrayList;

import ai.Abilities;
import ai.GameState;
import ai.Player;
import epicComm.objects.misc.Images;

public class Hero implements Abilities{
	
	// Raw JSON Variables
	
	private String id,
				   name,
				   attack,
				   scale,
				   releaseDate;
	
	private String[] traits,
					 affinities;
	
	private int difficulty;
	
	private Stats stats;
	
	private Images images;
	
	private AttributesByLevel[] attributesByLevel;
	
	private Ability[] abilities;
	
	private Player player;
	
	public Hero(String id, String name, String attack, String[] traits, String scale, String releaseDate, String[] affinities, 
			int difficulty, Stats stats, Images images, AttributesByLevel[] attributesByLevel, Ability[] abilities){
		this.id=id;
		this.name=name;
		this.attack=attack;
		this.traits = traits;
		this.scale=scale;
		this.releaseDate=releaseDate;
		this.affinities=affinities;
		this.difficulty=difficulty;
		this.stats=stats;
		this.images=images;	
		this.attributesByLevel = attributesByLevel;
		this.abilities = abilities;
	}
	
	public Ability getBasic(){
		for (int n=0; n<abilities.length; n++){
			if ("Basic".equals(abilities[n].getType()))
			return abilities[n];
		}
		return null;
	}
	
	public Ability getAlternate(){
		for (int n=0; n<abilities.length; n++){
			if ("Alternate".equals(abilities[n].getType()))
			return abilities[n];
		}
		return null;
	}
	
	public Ability getSecondary(){
		for (int n=0; n<abilities.length; n++){
			if ("Secondary".equals(abilities[n].getType()))
			return abilities[n];
		}
		return null;
	}
	
	public Ability getPrimary(){
		for (int n=0; n<abilities.length; n++){
			if ("Primary".equals(abilities[n].getType()))
			return abilities[n];
		}
		return null;
	}
	
	public Ability getUlt(){
		for (int n=0; n<abilities.length; n++){
			if ("Ultimate".equals(abilities[n].getType()))
			return abilities[n];
		}
		return null;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAttack() {
		return attack;
	}

	public String getScale() {
		return scale;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public String[] getTraits() {
		return traits;
	}

	public String[] getAffinities() {
		return affinities;
	}

	public Stats getStats() {
		return stats;
	}

	public Images getImages() {
		return images;
	}

	public AttributesByLevel[] getAttributesByLevel() {
		return attributesByLevel;
	}

	public Ability[] getAbilities() {
		return abilities;
	}

	@Override
	public void useBasic(GameState gameState, ArrayList<Player> targets) {
		System.out.println("Basic Attack for this Hero has not been implemented yet!");
	}

	@Override
	public void usePrimary(GameState gameState, ArrayList<Player> targets) {
		System.out.println("Primary Ability for this Hero has not been implemented yet!");
	}

	@Override
	public void useAlternate(GameState gameState, ArrayList<Player> targets) {
		System.out.println("Alternate Ability for this Hero has not been implemented yet!");
	}

	@Override
	public void useSecondary(GameState gameState, ArrayList<Player> targets) {
		System.out.println("Secondary Ability for this Hero has not been implemented yet!");
	}

	@Override
	public void useUltimate(GameState gameState, ArrayList<Player> targets) {
		System.out.println("Ultimate Ability for this Hero has not been implemented yet!");
	}
	
	public void attachPlayer(Player player){
		this.player = player;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public float getBaseHealth(Hero hero, Player player){
		// The player will be at level 1 always for base health
		player.setLevel(1);
		AttributesByLevel[] attributesByLevel = hero.getAttributesByLevel();
		float baseHealth = attributesByLevel[player.getLevel()].getMaxHealth();
		
		return baseHealth;
	}
	
	public float getBaseArmor(Hero hero, Player player){
		player.setLevel(1);
		AttributesByLevel[] attributesByLevel = hero.getAttributesByLevel();
		float baseArmor = attributesByLevel[player.getLevel()].getBasicResistanceRating();
		
		return baseArmor;
	}
	
	//TODO: This function needs some work
	public float getBaseDamage(Hero hero, Player player){
		player.setLevel(1);
		Ability baseAttack = hero.getBasic();
		float baseDamage = 0;
		return baseDamage;
	}
	
	
}

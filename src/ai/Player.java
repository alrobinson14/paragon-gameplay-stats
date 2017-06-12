package ai;

import java.util.ArrayList;

import epicComm.objects.cards.Card;
import epicComm.objects.heroes.AttributesByLevel;
import epicComm.objects.heroes.Hero;

public class Player implements Abilities{
	
	private boolean dawn;
	private boolean dusk;
	
	// Levels
	private int level;
	
	private int primaryLevel;
	private int basicLevel;
	private int alternateLevel;
	private int secondaryLevel;
	private int ultimateLevel;
	
	private Status status;
	private Hero hero;
	
	private Deck deck;
	private ArrayList<Card> hand;
	
	public void setHand(ArrayList<Card> hand){
		this.hand=hand;
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	public void setDeck(Deck deck){
		this.deck = deck;
	}
	
	public Deck getDeck(){
		return deck;
	}
	
	public void setDusk()
	{
		dusk = true;
		dawn = false;
	}
	
	public void setDawn()
	{
		dawn = true;
		dusk = false;
	}
	
	public boolean isDusk(){
		return dusk;
	}
	public boolean isDawn(){
		return dawn;
	}
	
	public Player(){
		status = new Status();
	}
	
	public Player(Hero hero){
		status = new Status();
		this.hero = hero;
		hero.attachPlayer(this);
	}
	
	public void setStatus(Status status){
		this.status = status;
	}
	
	public Status getStatus(){
		return status;
	}
	
	public void setHero(Hero hero){
		this.hero = hero;
	}
	
	public Hero getHero(){
		return hero;
	}
		
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int level){
		if (level >=1 && level <=15){
			this.level = level;
			AttributesByLevel[] atts = hero.getAttributesByLevel();
			status.setMaxMana(atts[level-1].getMaxEnergy());
			status.setMaxHealth(atts[level-1].getMaxHealth());
		}
		else
			System.err.println("Hero level must be between 1-15");
	}
	
	public void incrementLevel(){
		if (level>=15)
			System.err.println("Hero level must be between 1-15");	
		else{
			level++;
			AttributesByLevel[] atts = hero.getAttributesByLevel();
			status.setMaxMana(atts[level-1].getMaxEnergy());
			status.setMaxHealth(atts[level-1].getMaxHealth());
		}
	}

	public int getPrimaryLevel() {
		return primaryLevel;
	}

	public void setPrimaryLevel(int level) {
		if (level >=1 && level <=4)
			primaryLevel = level;
		else
			System.err.println("Primary level must be between 0-4");
	}

	public int getBasicLevel() {
		return basicLevel;
	}

	public void setBasicLevel(int level) {
		if (level >=1 && level <=15)
			basicLevel = level;
		else
			System.err.println("Basic level must be between 1-15");
	}

	public int getAlternateLevel() {
		return alternateLevel;
	}

	public void setAlternateLevel(int level) {
		if (level >=1 && level <=4)
			alternateLevel = level;
		else
			System.err.println("Alternate level must be between 0-4");
	}

	public int getSecondaryLevel() {
		return secondaryLevel;
	}

	public void setSecondaryLevel(int level) {
		if (level >=1 && level <=4)
			secondaryLevel = level;
		else
			System.err.println("Secondary level must be between 0-4");
	}

	public int getUltimateLevel() {
		return ultimateLevel;
	}

	public void setUltimateLevel(int level) {
		if (level >=1 && level <=4)
			ultimateLevel = level;
		else
			System.err.println("Ultimate level must be between 0-4");
	}

	@Override
	public void useBasic(GameState gameState, ArrayList<Player> targets) {
		hero.useBasic(gameState, targets);
	}

	@Override
	public void usePrimary(GameState gameState, ArrayList<Player> targets) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useAlternate(GameState gameState, ArrayList<Player> targets) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useSecondary(GameState gameState, ArrayList<Player> targets) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useUltimate(GameState gameState, ArrayList<Player> targets) {
		// TODO Auto-generated method stub
		
	}
}

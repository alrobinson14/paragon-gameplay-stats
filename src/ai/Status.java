package ai;

public class Status {
	
	// Basics
	private float currHealth;
	private float maxHealth;
	
	private float currMana;
	private float maxMana;
	
	private boolean isDead;
	private boolean isCritical;
	
	// Status Effects
	private boolean isBlight;
	private boolean isPoisoned;
	private boolean isBleeding;
	private boolean isSlowed;
	private boolean isSnared;
	private boolean isBurning;
	private boolean isShielded;
	
	private float blightDuration;
	private float poisonDuration;
	private int poisonStacks;
	private float bleedDuration;
	private int bleedStacks;
	private float slowDuration;
	private float slowValue;
	private float snareDuration;
	private float burningDuration;
	private float shieldDuration;
	private float shieldValue;
	
	public float getCurrMana() {
		return currMana;
	}
	
	public void setCurrMana(float value){
		currMana = value;
	}

	public void increaseCurrMana(float value) {
		if (currMana+value > maxMana){
			currMana = maxMana;
		}
		else
			currMana+=value;
	}

	public void decreaseCurrMana(float value) {
		if (currMana - value < 0){
			currMana = 0;
		}
		else
			currMana-=value;
	}

	public float getMaxHealth() {
		return maxHealth;
	}
	
	public void setMaxHealth(float value){
		maxHealth = value;
	}

	public float getMaxMana() {
		return maxMana;
	}
	
	public void setMaxMana(float value) {
		maxMana = value;;
	}
		
	public float getCurrHealth() {
		return currHealth;
	}
	
	public void setCurrHealth(float value){
		currHealth = value;
	}

	public void increaseCurrHealth(float value) {
		if (currHealth+value > maxHealth){
			currHealth = maxHealth;
		}
		else
			currHealth+=value;
	}

	public void decreaseCurrHealth(float value) {
		if (currHealth - value < 0){
			setDead(true);
			currHealth = 0;
		}
		else if (currHealth - value <= (.25 * maxHealth)){
			setCritical(true);
		}
		else
			currHealth-=value;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public void setDead(boolean value){
		isDead = value;
	}

	public boolean isCritical() {
		return isCritical;
	}
	
	public void setCritical(boolean value){
		isCritical = value;
	}

	public boolean isBlight() {
		return isBlight;
	}

	public boolean isBleeding() {
		return isBleeding;
	}

	public boolean isSnared() {
		return isSnared;
	}

	public boolean isSlowed() {
		return isSlowed;
	}

	public boolean isPoisoned() {
		return isPoisoned;
	}
	
	public boolean isBurning() {
		return isBurning;
	}

	public boolean isShielded() {
		return isShielded;
	}

	public void setBlight(float duration) {
		isBlight=true;
	}

	public void setPoisoned(float duration, int stacks) {
		this.poisonDuration = duration;
	}

	public void setBleeding(float duration, int stacks) {
		bleedDuration = duration;
		bleedStacks = stacks;
	}

	public void setSlowed(float duration, float value) {
		slowDuration = duration;
		slowValue = value;		
	}

	public void setSnared(float duration) {
		snareDuration = duration;		
	}

	public void setBurning(float duration) {
		burningDuration = duration;		
	}

	public void setShield(float duration, float value) {
		shieldDuration = duration;
		shieldValue = value;
	}

	public float getBlightDuration() {
		return blightDuration;
	}

	public float getPoisonDuration() {
		return poisonDuration;
	}
	
	public int getPoisonStacks() {
		return poisonStacks;
	}

	public int getBleedStacks() {
		return bleedStacks;
	}

	public float getBleedDuration() {
		return bleedDuration;
	}

	public float getSlowDuration() {
		return slowDuration;
	}

	public float getSlowValue() {
		return slowValue;
	}

	public float getSnareDuration() {
		return snareDuration;
	}

	public float getBurningDuration() {
		return burningDuration;
	}

	public float getShieldDuration() {
		return shieldDuration;
	}

	public float getShieldValue() {
		return shieldValue;
	}
}

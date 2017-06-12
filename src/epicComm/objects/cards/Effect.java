package epicComm.objects.cards;

public class Effect {
	
	private String description,
				   stat;
	
	private float value;

	private boolean passive,
					unique;
	
	private int cooldown;
	
	public Effect(String description, String stat, float value, boolean passive, boolean unique, int cooldown){
		this.description = description;
		this.stat = stat;
		this.value = value;
		this.passive = passive;
		this.unique = unique;
		this.cooldown = cooldown;
	}

	public String getDescription() {
		return description;
	}

	public String getStat() {
		return stat;
	}

	public float getValue() {
		return value;
	}

	public boolean isPassive() {
		return passive;
	}

	public boolean isUnique() {
		return unique;
	}

	public int getCooldown() {
		return cooldown;
	}
}

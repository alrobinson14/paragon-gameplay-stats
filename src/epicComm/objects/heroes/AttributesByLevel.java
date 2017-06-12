package epicComm.objects.heroes;

public class AttributesByLevel {
	
	private float MaxEnergy,
				  BasicPenetrationRating,
				  BaseAttackTime,
				  AbilityPenetrationRating,
				  HealthRegenRate,
				  AbilityResistanceRating,
				  MaxHealth,
				  BasicResistanceRating,
				  CleaveRating,
				  AttackSpeedRating,
				  EnergyRegenRate;
	
	public AttributesByLevel(float maxEnergy, float basicPenetrationRating, float baseAttackTime,
			float abilityPenetrationRating, float healthRegenRate, float abilityResistanceRating, float maxHealth,
			float basicResistanceRating, float cleaveRating, float attackSpeedRating, float energyRegenRate) {

		this.MaxEnergy = maxEnergy;
		this.BasicPenetrationRating = basicPenetrationRating;
		this.BaseAttackTime = baseAttackTime;
		this.AbilityPenetrationRating = abilityPenetrationRating;
		this.HealthRegenRate = healthRegenRate;
		this.AbilityResistanceRating = abilityResistanceRating;
		this.MaxHealth = maxHealth;
		this.BasicResistanceRating = basicResistanceRating;
		this.CleaveRating = cleaveRating;
		this.AttackSpeedRating = attackSpeedRating;
		this.EnergyRegenRate = energyRegenRate;
	}

	public float getMaxEnergy() {
		return MaxEnergy;
	}

	public float getBasicPenetrationRating() {
		return BasicPenetrationRating;
	}

	public float getBaseAttackTime() {
		return BaseAttackTime;
	}

	public float getAbilityPenetrationRating() {
		return AbilityPenetrationRating;
	}

	public float getHealthRegenRate() {
		return HealthRegenRate;
	}

	public float getAbilityResistanceRating() {
		return AbilityResistanceRating;
	}

	public float getMaxHealth() {
		return MaxHealth;
	}

	public float getBasicResistanceRating() {
		return BasicResistanceRating;
	}

	public float getCleaveRating() {
		return CleaveRating;
	}

	public float getAttackSpeedRating() {
		return AttackSpeedRating;
	}

	public float getEnergyRegenRate() {
		return EnergyRegenRate;
	}
}

package epicComm.objects.heroes;

public class ModifiersByLevel {
	
	private float damage,
			     damageabilityult,
				 attackratingcoefficient,
				 cooldown,
				 energycost,
				 healthpassive,
				 damagepassive,
				 damageabilityprimary,
				 slowsecondary,
				 slowlong,
				 rootshort,
				 movespeed,
				 slowduration,
				 airwalkspeedboost,
				 airwalkduration,
				 shield,
				 maxhealth,
				 markchance,
				 atkcount,
				 lifetime,
				 maxhealthpercent,
				 ultduration,
				 bonusdamage,
				 stunduration,
				 range;
	
	public ModifiersByLevel(float damage, float damageAbilityUlt, float attackRatingCoefficient, float cooldown,
			float energyCost, float healthPassive, float damagePassive, float damageAbilityPrimary, float slowSecondary,
			float slowLong, float rootShort, float moveSpeed, float slowDuration, float airWalkSpeedBoost, float airWalkDuration,
			float shield, float maxHealth, float markChance, float atkCount, float lifeTime, float maxHealthPercent, float ultDuration,
			float bonusDamage, float stunDuration, float range) {

		this.damage=damage;
		this.damageabilityult=damageAbilityUlt;
		this.attackratingcoefficient=attackRatingCoefficient;
		this.cooldown=cooldown;
		this.energycost=energyCost;
		this.healthpassive=healthPassive;
		this.damagepassive=damagePassive;
		this.damageabilityprimary=damageAbilityPrimary;
		this.slowsecondary=slowSecondary;
		this.slowlong=slowLong;
		this.rootshort=rootShort;
		this.ultduration=ultDuration;
		this.bonusdamage=bonusDamage;
		this.stunduration=stunDuration;
		this.movespeed=moveSpeed;
		this.slowduration=slowDuration;
		this.airwalkspeedboost=airWalkSpeedBoost;
		this.airwalkduration=airWalkDuration;
		this.shield=shield;
		this.maxhealth=maxHealth;
		this.markchance=markChance;
		this.atkcount=atkCount;
		this.lifetime=lifeTime;
		this.maxhealthpercent=maxHealthPercent;
		this.range=range;
		
	}
	
	public float getAtkCount() {
		return atkcount;
	}
	
	public float getStunDuration() {
		return stunduration;
	}
	
	public float getBonusDamage() {
		return bonusdamage;
	}
	
	public float getUltDuration() {
		return ultduration;
	}

	public float getLifeTime() {
		return lifetime;
	}

	public float getMaxHealthPercent() {
		return maxhealthpercent;
	}

	public float getShield() {
		return shield;
	}

	public float getMaxHealth() {
		return maxhealth;
	}

	public float getMarkChance() {
		return markchance;
	}

	public float getSlowDuration() {
		return slowduration;
	}

	public float getMoveSpeed() {
		return movespeed;
	}

	public float getAirWalkSpeedBoost() {
		return airwalkspeedboost;
	}

	public float getAirWalkDuration() {
		return airwalkduration;
	}

	public float getDamage() {
		return damage;
	}

	public float getDamageAbilityUlt() {
		return damageabilityult;
	}

	public float getAttackRatingCoefficient() {
		return attackratingcoefficient;
	}

	public float getCooldown() {
		return cooldown;
	}

	public float getEnergyCost() {
		return energycost;
	}

	public float getHealthPassive() {
		return healthpassive;
	}

	public float getDamagePassive() {
		return damagepassive;
	}

	public float getDamageAbilityPrimary() {
		return damageabilityprimary;
	}

	public float getSlowSecondary() {
		return slowsecondary;
	}

	public float getSlowLong() {
		return slowlong;
	}

	public float getRootShort() {
		return rootshort;
	}
	
	public float getRange() {
		return range;
	}
}

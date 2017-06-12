package epicComm.Deserializers.heroes;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import epicComm.objects.heroes.ModifiersByLevel;

public class ModifiersByLevelDes implements JsonDeserializer<ModifiersByLevel>{

	@Override
	public ModifiersByLevel deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
		final JsonObject jsonObject = jsonElement.getAsJsonObject();
		
		final JsonElement jsonDamage = jsonObject.get("damage");
		Float damage = (jsonDamage !=null ? jsonDamage.getAsFloat(): 0);
		
		final JsonElement jsonDamageAbilityUlt = jsonObject.get("damageabilityult");
		
		Float damageAbilityUlt = (jsonDamageAbilityUlt != null ? jsonDamageAbilityUlt.getAsFloat(): 0);
		
		final JsonElement jsonAttackRatingCoefficient = jsonObject.get("attackratingcoefficient");
		Float attackRatingCoefficient = (jsonAttackRatingCoefficient !=null ? jsonAttackRatingCoefficient.getAsFloat(): 0);
		
		final JsonElement jsonCooldown = jsonObject.get("cooldown");
		Float cooldown = (jsonCooldown !=null ? jsonCooldown.getAsFloat(): 0);
		
		final JsonElement jsonEnergyCost = jsonObject.get("energycost");
		Float energyCost = (jsonEnergyCost !=null ? jsonEnergyCost.getAsFloat(): 0);
		
		final JsonElement jsonHealthPassive = jsonObject.get("healthpassive");
		Float healthPassive = (jsonHealthPassive !=null ? jsonHealthPassive.getAsFloat(): 0);
		
		final JsonElement jsonDamagePassive = jsonObject.get("damagepassive");
		Float damagePassive = (jsonDamagePassive !=null ? jsonDamagePassive.getAsFloat(): 0);
		
		final JsonElement jsonDamageAbilityPrimary = jsonObject.get("damageabilityprimary");
		Float damageAbilityPrimary = (jsonDamageAbilityPrimary !=null ? jsonDamageAbilityPrimary.getAsFloat(): 0);
		
		final JsonElement jsonSlowSecondary = jsonObject.get("slowsecondary");
		Float slowSecondary = (jsonSlowSecondary !=null ? jsonSlowSecondary.getAsFloat(): 0);
		
		final JsonElement jsonSlowLong = jsonObject.get("slowlong");
		Float slowLong = (jsonSlowLong !=null ? jsonSlowLong.getAsFloat(): 0);
		
		final JsonElement jsonRootShort = jsonObject.get("rootshort");
		Float rootShort = (jsonRootShort !=null ? jsonRootShort.getAsFloat(): 0);
		
		final JsonElement jsonUltDuration = jsonObject.get("ultduration");
		Float ultDuration = (jsonUltDuration !=null ? jsonUltDuration.getAsFloat(): 0);
		
		final JsonElement jsonBonusDamage = jsonObject.get("bonusdamage");
		Float bonusDamage = (jsonBonusDamage !=null ? jsonBonusDamage.getAsFloat(): 0);
		
		final JsonElement jsonStunDuration = jsonObject.get("stunduration");
		Float stunDuration = (jsonStunDuration !=null ? jsonStunDuration.getAsFloat(): 0);

		final JsonElement jsonMoveSpeed= jsonObject.get("movespeed");
		Float moveSpeed = (jsonMoveSpeed !=null ? jsonMoveSpeed.getAsFloat(): 0);
		
		final JsonElement jsonSlowDuration = jsonObject.get("slowduration");
		Float slowDuration = (jsonSlowDuration !=null ? jsonSlowDuration.getAsFloat(): 0);
		
		final JsonElement jsonAirWalkSpeedBoost = jsonObject.get("airwalkspeedboost");
		Float airWalkSpeedBoost = (jsonAirWalkSpeedBoost !=null ? jsonAirWalkSpeedBoost.getAsFloat(): 0);
		
		final JsonElement jsonAirWalkDuration = jsonObject.get("airwalkduration");
		Float airWalkDuration = (jsonAirWalkDuration !=null ? jsonAirWalkDuration.getAsFloat(): 0);
		
		final JsonElement jsonShield = jsonObject.get("shield");
		Float shield = (jsonShield !=null ? jsonShield.getAsFloat(): 0);
		
		final JsonElement jsonMaxHealth = jsonObject.get("maxhealth");
		Float maxHealth = (jsonMaxHealth !=null ? jsonMaxHealth.getAsFloat(): 0);
		
		final JsonElement jsonMarkChance = jsonObject.get("markchance");
		Float markChance = (jsonMarkChance !=null ? jsonMarkChance.getAsFloat(): 0);
		
		final JsonElement jsonAtkCount = jsonObject.get("atkcount");
		Float atkCount = (jsonAtkCount !=null ? jsonAtkCount.getAsFloat(): 0);
		
		final JsonElement jsonLifeTime= jsonObject.get("lifetime");
		Float lifeTime = (jsonLifeTime !=null ? jsonLifeTime.getAsFloat(): 0);
		
		final JsonElement jsonMaxHealthPercent= jsonObject.get("maxhealthpercent");
		Float maxHealthPercent = (jsonMaxHealthPercent !=null ? jsonMaxHealthPercent.getAsFloat(): 0);
		
		final JsonElement jsonRange= jsonObject.get("range");
		Float range = (jsonRange !=null ? jsonRange.getAsFloat(): 0);
				
		return new ModifiersByLevel(damage, damageAbilityUlt, attackRatingCoefficient, cooldown, energyCost, healthPassive,
				   				    damagePassive, damageAbilityPrimary, slowSecondary, slowLong, rootShort, moveSpeed,
				   				    slowDuration, airWalkSpeedBoost, airWalkDuration, shield, maxHealth, markChance,
				   				    atkCount, lifeTime, maxHealthPercent, ultDuration, bonusDamage, stunDuration, range);
	}

}
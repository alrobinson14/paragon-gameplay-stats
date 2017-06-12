package epicComm.Deserializers.heroes;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import epicComm.objects.heroes.AttributesByLevel;

public class AttributesByLevelDes implements JsonDeserializer<AttributesByLevel>{

	@Override
	public AttributesByLevel deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
		final JsonObject jsonObject = jsonElement.getAsJsonObject();
		
		final JsonElement jsonMaxEnergy = jsonObject.get("MaxEnergy");
		float MaxEnergy = jsonMaxEnergy.getAsFloat();
		
		final JsonElement jsonBasicPenetrationRating = jsonObject.get("BasicPenetrationRating");
		float BasicPenetrationRating = jsonBasicPenetrationRating.getAsFloat();
		
		final JsonElement jsonBaseAttackTime = jsonObject.get("BaseAttackTime");
		float BaseAttackTime = jsonBaseAttackTime.getAsFloat();
		
		final JsonElement jsonAbilityPenetrationRating = jsonObject.get("AbilityPenetrationRating");
		float AbilityPenetrationRating = jsonAbilityPenetrationRating.getAsFloat();
		
		final JsonElement jsonHealthRegenRate = jsonObject.get("HealthRegenRate");
		float HealthRegenRate = jsonHealthRegenRate.getAsFloat();
		
		final JsonElement jsonAbilityResistanceRating = jsonObject.get("AbilityResistanceRating");
		float AbilityResistanceRating = jsonAbilityResistanceRating.getAsFloat();
		
		final JsonElement jsonMaxHealth= jsonObject.get("MaxHealth");
		float MaxHealth = jsonMaxHealth.getAsFloat();
		
		final JsonElement jsonBasicResistanceRating = jsonObject.get("BasicResistanceRating");
		float BasicResistanceRating = jsonBasicResistanceRating.getAsFloat();
		
		final JsonElement jsonCleaveRating = jsonObject.get("CleaveRating");
		float CleaveRating = jsonCleaveRating.getAsFloat();
		
		final JsonElement jsonAttackSpeedRating = jsonObject.get("AttackSpeedRating");
		float AttackSpeedRating = jsonAttackSpeedRating.getAsFloat();
		
		final JsonElement jsonEnergyRegenRate = jsonObject.get("EnergyRegenRate");
		float EnergyRegenRate = jsonEnergyRegenRate.getAsFloat();
		
		
		return new AttributesByLevel(MaxEnergy, BasicPenetrationRating, BaseAttackTime, AbilityPenetrationRating, HealthRegenRate,
									 AbilityResistanceRating, MaxHealth, BasicResistanceRating, CleaveRating, AttackSpeedRating,
									 EnergyRegenRate);
	}

}

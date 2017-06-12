package epicComm.Deserializers.heroes;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import epicComm.objects.heroes.Stats;

public class StatsDes implements JsonDeserializer<Stats>{

	@Override
	public Stats deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
		final JsonObject jsonObject = jsonElement.getAsJsonObject();
		
		final JsonElement jsonMobility = jsonObject.get("Mobility");
		int Mobility = jsonMobility.getAsInt();
		
		final JsonElement jsonBasicAttack= jsonObject.get("BasicAttack");
		int BasicAttack = jsonBasicAttack.getAsInt();
		
		final JsonElement jsonDurability= jsonObject.get("Durability");
		int Durability = jsonDurability.getAsInt();
		
		final JsonElement jsonAbilityAttack= jsonObject.get("AbilityAttack");
		int AbilityAttack = jsonAbilityAttack.getAsInt();
			
		return new Stats(Mobility, BasicAttack, Durability, AbilityAttack);
	}

}

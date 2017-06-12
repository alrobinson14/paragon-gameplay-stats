package epicComm.Deserializers.cards;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import epicComm.objects.cards.Effect;


public class EffectDes implements JsonDeserializer<Effect>{

	@Override
	public Effect deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
		final JsonObject jsonObject = jsonElement.getAsJsonObject();
		
		final JsonElement jsonDescription = jsonObject.get("description");
		String description = (jsonDescription!=null ? jsonDescription.getAsString(): "");
		
		final JsonElement jsonStat = jsonObject.get("stat");
		String stat = jsonStat.getAsString();
		
		final JsonElement jsonValue= jsonObject.get("value");
		float value = jsonValue.getAsFloat();
		
		final JsonElement jsonPassive= jsonObject.get("passive");
		boolean passive = (jsonPassive !=null ? jsonPassive.getAsBoolean(): false);
		
		final JsonElement jsonUnique= jsonObject.get("unique");
		boolean unique = (jsonUnique !=null ? jsonUnique.getAsBoolean(): false);
		
		final JsonElement jsonCooldown= jsonObject.get("cooldown");
		int cooldown = (jsonCooldown !=null ? jsonCooldown.getAsInt(): 0);
		
		return new Effect(description, stat, value, passive, unique, cooldown);
	}

}

/*
 * 	private String description,
				   stat;
	
	private float value;

	private boolean passive,
					unique;
	
	private int cooldown;
*/

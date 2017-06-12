package epicComm.Deserializers.heroes;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import epicComm.objects.heroes.Ability;
import epicComm.objects.heroes.ModifiersByLevel;
import epicComm.objects.misc.Images;


public class AbilityDes implements JsonDeserializer<Ability>{

	@Override
	public Ability deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
		final JsonObject jsonObject = jsonElement.getAsJsonObject();
		
		final JsonElement jsonName = jsonObject.get("name");
		String name = (jsonName !=null ? jsonName.getAsString(): "");
		
		final JsonElement jsonDescription = jsonObject.get("description");
		String description = (jsonDescription !=null ? jsonDescription.getAsString(): "");
		
		final JsonElement jsonShortDescription= jsonObject.get("shortDescription");
		String shortDescription = (jsonShortDescription !=null ? jsonShortDescription.getAsString(): "");
		
		final JsonElement jsonType= jsonObject.get("type");
		String type1 = (jsonType !=null ? jsonType.getAsString(): "");
		
		final JsonElement jsonBinding = jsonObject.get("binding");
		String binding = (jsonBinding !=null ? jsonBinding.getAsString(): "");
		
		final JsonElement jsonDamageType= jsonObject.get("damageType");
		String damageType= (jsonDamageType !=JsonNull.INSTANCE ? jsonDamageType.getAsString(): "");
		
		final JsonElement jsonMaxLevel= jsonObject.get("maxLevel");
		int maxLevel = (jsonMaxLevel !=null ? jsonMaxLevel.getAsInt(): 0);
		
		ModifiersByLevel[] modifiersByLevel = context.deserialize(jsonObject.get("modifiersByLevel"),  ModifiersByLevel[].class);
		
		Images images = context.deserialize(jsonObject.get("images"),  Images.class);
	
		return new Ability(name, description, shortDescription, type1, binding, damageType, maxLevel, modifiersByLevel, images);
	}
}
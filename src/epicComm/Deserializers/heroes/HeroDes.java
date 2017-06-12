package epicComm.Deserializers.heroes;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import epicComm.objects.heroes.Ability;
import epicComm.objects.heroes.AttributesByLevel;
import epicComm.objects.heroes.Hero;
import epicComm.objects.heroes.Stats;
import epicComm.objects.misc.Images;

public class HeroDes implements JsonDeserializer<Hero>{

	@Override
	public Hero deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
		final JsonObject jsonObject = jsonElement.getAsJsonObject();
		
		final JsonElement jsonId = jsonObject.get("id");
		String id = jsonId.getAsString();
		
		final JsonElement jsonName = jsonObject.get("name");
		String name = jsonName.getAsString();
		
		final JsonElement jsonAttack = jsonObject.get("attack");
		String attack = jsonAttack.getAsString();
	
		final JsonElement jsonTraits = jsonObject.get("traits");
		final JsonArray jsonTraitsArray = jsonTraits.getAsJsonArray();
		final String[] traits = new String[jsonTraitsArray.size()];
		for (int n=0; n<traits.length; n++){
			final JsonElement jsonTrait = jsonTraitsArray.get(n);
			traits[n] = jsonTrait.getAsString();
		}			

		final JsonElement jsonScale= jsonObject.get("scale");
		String scale = jsonScale.getAsString();

		final JsonElement jsonReleaseDate= jsonObject.get("releaseDate");
		String releaseDate = jsonReleaseDate.getAsString();
	
		final JsonElement jsonAffinities = jsonObject.get("affinities");
		final JsonArray jsonAffinitiesArray = jsonAffinities.getAsJsonArray();
		final String[] affinities = new String[jsonAffinitiesArray.size()];
		for (int n=0; n<affinities.length; n++){
			final JsonElement jsonAffinity = jsonAffinitiesArray.get(n);
			affinities[n] = jsonAffinity.getAsString();
		}	
		
		final JsonElement jsonDifficulty = jsonObject.get("difficulty");
		int difficulty = jsonDifficulty.getAsInt();

		Stats stats = context.deserialize(jsonObject.get("stats"),  Stats.class);	

		Images images = context.deserialize(jsonObject.get("images"),  Images.class);
		
		AttributesByLevel[] attributesByLevel = context.deserialize(jsonObject.get("attributesByLevel"), AttributesByLevel[].class);		
		
		Ability[] abilities = context.deserialize(jsonObject.get("abilities"), Ability[].class);

		return new Hero(id, name, attack, traits, scale, releaseDate, affinities, difficulty, stats, images, attributesByLevel, abilities);
	}

}

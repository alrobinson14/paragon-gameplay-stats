package epicComm.Deserializers.cards;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import epicComm.objects.cards.Card;
import epicComm.objects.cards.Effect;
import epicComm.objects.misc.Images;

public class CardDes implements JsonDeserializer<Card>{

	@Override
	public Card deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
		final JsonObject jsonObject = jsonElement.getAsJsonObject();
		
		final JsonElement jsonId = jsonObject.get("id");
		String id = jsonId.getAsString();
		
		final JsonElement jsonName = jsonObject.get("name");
		String name = jsonName.getAsString();
		
		final JsonElement jsonSlotType = jsonObject.get("slotType");
		String slotType = jsonSlotType.getAsString();
		
		Images images = context.deserialize(jsonObject.get("images"),  Images.class);
		
		final JsonElement jsonRarity = jsonObject.get("rarity");
		String rarity = jsonRarity.getAsString();
		
		final JsonElement jsonAffinities = jsonObject.get("affinities");
		final JsonArray jsonAffinitiesArray = jsonAffinities.getAsJsonArray();
		final String[] affinities = new String[jsonAffinitiesArray.size()];
		for (int n=0; n<affinities.length; n++){
			final JsonElement jsonAffinity = jsonAffinitiesArray.get(n);
			affinities[n] = jsonAffinity.getAsString();
		}	
		
		final JsonElement jsonCost= jsonObject.get("cost");
		int cost = jsonCost.getAsInt();
		
		final JsonElement jsonUpgradeSlots= jsonObject.get("upgradeSlots");
		int upgradeSlots = jsonUpgradeSlots.getAsInt();
		
		Effect[] effects = context.deserialize(jsonObject.get("effects"), Effect[].class);	
		Effect[] maxedEffects = context.deserialize(jsonObject.get("maxedEffects"), Effect[].class);	
		
		return new Card(id, name, slotType, rarity, images, affinities, cost, upgradeSlots, effects, maxedEffects);
	}
}

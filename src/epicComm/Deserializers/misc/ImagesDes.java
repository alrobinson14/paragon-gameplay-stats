package epicComm.Deserializers.misc;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import epicComm.objects.misc.Images;

public class ImagesDes implements JsonDeserializer<Images>{

	@Override
	public Images deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
		final JsonObject jsonObject = jsonElement.getAsJsonObject();

		final JsonElement jsonIcon = jsonObject.get("icon");
		String icon = (jsonIcon !=null ? jsonIcon.getAsString(): "");
		
		final JsonElement jsonMedium = jsonObject.get("medium");
		String medium = (jsonMedium != null ? jsonMedium.getAsString(): "");
		
		final JsonElement jsonMediumStats= jsonObject.get("medium_stats");
		String mediumStats= (jsonMediumStats != null ? jsonMediumStats.getAsString(): "");
		
		final JsonElement jsonLarge = jsonObject.get("large");
		String large = (jsonLarge != null ? jsonLarge.getAsString(): "");
		
		final JsonElement jsonLargeStats = jsonObject.get("large_stats");
		String largeStats = (jsonLargeStats != null ? jsonLargeStats.getAsString(): "");
		
		return new Images(icon, medium, mediumStats, large, largeStats);
	}

}

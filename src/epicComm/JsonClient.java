package epicComm;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import epicComm.Deserializers.cards.CardDes;
import epicComm.Deserializers.cards.EffectDes;
import epicComm.Deserializers.heroes.AbilityDes;
import epicComm.Deserializers.heroes.AttributesByLevelDes;
import epicComm.Deserializers.heroes.HeroDes;
import epicComm.Deserializers.heroes.ModifiersByLevelDes;
import epicComm.Deserializers.heroes.StatsDes;
import epicComm.Deserializers.misc.ImagesDes;
import epicComm.objects.cards.Card;
import epicComm.objects.cards.Effect;
import epicComm.objects.heroes.Ability;
import epicComm.objects.heroes.AttributesByLevel;
import epicComm.objects.heroes.Hero;
import epicComm.objects.heroes.ModifiersByLevel;
import epicComm.objects.heroes.Stats;
import epicComm.objects.misc.Images;

public class JsonClient {
	
	private final static String baseURL = "https://developer-paragon.epicgames.com/";
	
	//cards
	private final static String completeAllCards = baseURL+"/v1/cards/complete";
	private final static String CARD = "CARD";
	
	//heroes	
	private final static String completeAllHeroes = baseURL+"/v1/heroes/complete";
	private final static String HERO = "HERO";
	
	// IO
	private final static String apiKeyFile = "apiKey.txt";
	private static String apiKey;
	
	private final static String cardsOutputFile = "./res/cards.json";
	private final static String heroesOutputFile = "./res/heroes.json";

	private final static String cardsInputFile = "/cards.json";
	private final static String heroesInputFile = "/heroes.json";

	
		
	/**
	 * Send the request to Epic to provide us with the complete Card information
	 * Parse the information using our custom deserializers
	 * Write the JSON objects to file for later use.
	 * 
	 * @throws IOException
	 */
	public static final void updateCardsFile() throws IOException {		
		// Initialize our parser
		Gson gson = getGson(HERO);
		HttpURLConnection conn = null;
		Card[] cards = null;
		
		// Send Epic the request and have the gson Hero deserializer parse the response
		try {
			Reader reader = sendRequest(conn, completeAllCards);
			cards = gson.fromJson(reader,  Card[].class);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if (conn!=null)
				conn.disconnect();
		}	
		
		// Write the JSON to file
		Writer writer = new FileWriter(cardsOutputFile, false);
		Gson gsonWriter = new GsonBuilder().create();
		gsonWriter.toJson(cards, writer);
		writer.close();
	}

	
	/**
	 * Send the request to Epic to provide us with the complete Hero information
	 * Parse the information using our custom deserializers
	 * Write the JSON objects to file for later use.
	 * 
	 * @throws IOException
	 */
	public static final void updateHeroesFile() throws IOException {		
		// Initialize our parser
		Gson gsonReader = getGson(HERO);
		HttpURLConnection conn = null;
		Hero[] heroes = null;
		
		// Send Epic the request and have the gson Hero deserializer parse the response
		try {
			Reader reader = sendRequest(conn, completeAllHeroes);
			heroes = gsonReader.fromJson(reader,  Hero[].class);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if (conn!=null)
				conn.disconnect();
		}		
		
		Writer writer = new FileWriter(heroesOutputFile, false);
		Gson gsonWriter = new GsonBuilder().create();
		gsonWriter.toJson(heroes, writer);
		writer.close();
		
	}
	

	/**
	 * Helper function to send a JSON request and return a Reader, ready to parse
	 * @param conn null connection object allows the caller to close the stream when finished
	 * @param request JSON request to be sent over the wire
	 * @return Reader object populated with response stream
	 * @throws IOException
	 */
	private static final Reader sendRequest(HttpURLConnection conn, String request) throws IOException{	
		URL url = new URL(request);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("X-Epic-ApiKey", apiKey);
		conn.setRequestProperty("Accept", "application/json; charset=utf-8");
				
		int rc = conn.getResponseCode();
		if (rc !=200 )
			throw new IOException("Server responded with "+rc);
		
		return (Reader) new InputStreamReader(conn.getInputStream());
	}
	
	

	/**
	 * 
	 * @param type CARD or HERO type used to register the appropriate deserializer
	 * @return Gson for deserializing JSON objects
	 */
	private static final Gson getGson(String type){
		GsonBuilder gsonBuilder = new GsonBuilder();
		switch(type){
		case HERO:
			gsonBuilder.registerTypeAdapter(Hero.class, new HeroDes());
			gsonBuilder.registerTypeAdapter(Stats.class, new StatsDes());
			gsonBuilder.registerTypeAdapter(Images.class, new ImagesDes());
			gsonBuilder.registerTypeAdapter(ModifiersByLevel.class, new ModifiersByLevelDes());
			gsonBuilder.registerTypeAdapter(AttributesByLevel.class, new AttributesByLevelDes());
			gsonBuilder.registerTypeAdapter(Ability.class, new AbilityDes());
			break;
			
		case CARD:
			gsonBuilder.registerTypeAdapter(Card.class, new CardDes());
			gsonBuilder.registerTypeAdapter(Effect.class, new EffectDes());
			break;
		}	
		
		return gsonBuilder.create();
	}	
	
	/**
	 * Loads the API key from file into memory
	 * @throws IOException
	 */
	public static final void loadAPIKey() throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(JsonClient.class.getClassLoader().getResourceAsStream(apiKeyFile)));
		apiKey = br.readLine();
		System.out.println("Loaded API Key: "+apiKey);
	}
	
	/**
	 * Parses the Heroes JSON file, loading all Heroes into memory as Java Heroes
	 * @return Hero[] array containing all parsed JSON Hero objects
	 */
	public static final Hero[] loadHeroesFromFile(){
		// Initialize our parser
		Gson gsonReader = getGson(HERO);
		Hero[] heroes = null;
		
		try {
			Reader reader = new InputStreamReader(JsonClient.class.getResourceAsStream(heroesInputFile), "UTF-8");
			heroes = gsonReader.fromJson(reader,  Hero[].class);
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return heroes;		
	}
	
	/**
	 * Parses the Card JSON file, loading all Cards into memory as Java Cards
	 * @return Card[] array containing all parsed JSON Card objects
	 */
	public static final Card[] loadCardsFromFile(){
		// Initialize our parser
		Gson gsonReader = getGson(HERO);
		Card[] cards = null;
		
		try {
			Reader reader = new InputStreamReader(JsonClient.class.getResourceAsStream(cardsInputFile), "UTF-8");
			cards = gsonReader.fromJson(reader,  Card[].class);
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return cards;	
	}
}

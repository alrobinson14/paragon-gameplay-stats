package main;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

import ai.Deck;
import ai.GameState;
import ai.Player;
import epicComm.JsonClient;
import epicComm.objects.cards.Card;
import epicComm.objects.heroes.Ability;
import epicComm.objects.heroes.AttributesByLevel;
import epicComm.objects.heroes.Hero;
import epicComm.objects.heroes.ModifiersByLevel;
import models.heroes.Sevarog;
import models.heroes.Sparrow;
import utilities.Finder;
import utilities.Printer;

public class Main {

	public static void main(String[] args) {	
		// Connection tests
		boolean loadAPITest = false;
		boolean updateCardsTest = false;
		boolean updateHeroesTest = false;
		
		// File Tests
		boolean cardTest = false;
		boolean cardsTest = false;
		boolean heroTest = false;
		boolean heroesTest = false;
		boolean sparrowTest = false;
		
		boolean AlleyTest = true;
		
		boolean deckTest = false;
		
		if (deckTest){
			Hero[] heroes = JsonClient.loadHeroesFromFile();
			Card[] cards = JsonClient.loadCardsFromFile();
			new Finder(cards, heroes);
			Sevarog sev = new Sevarog(Finder.getHeroByName("Sevarog"));
			
			Deck myDeck = new Deck(sev);
			System.out.println(myDeck.getAffinities()[0]);
			System.out.println(myDeck.getAffinities()[1]);
		}
		
		if (AlleyTest){
			Hero[] heroes = JsonClient.loadHeroesFromFile();
			Card[] cards = JsonClient.loadCardsFromFile();
			new Finder(cards, heroes);
			
			Sevarog sev = new Sevarog(Finder.getHeroByName("Sevarog"));
		
			Player brett = new Player(sev);
			brett.setLevel(1);
			brett.setBasicLevel(1);
			
			
		
			float basicHealth = sev.getBaseHealth(sev, brett);
			float basicArmor  = sev.getBaseArmor(sev, brett);

			
			
			System.out.println("Basic Health: "+ basicHealth + "\n" + "Basic Armour: " + basicArmor + "\n" + "Basic Damage: " );
		}
		
		if (sparrowTest){
			Hero[] heroes = JsonClient.loadHeroesFromFile();
			Card[] cards = JsonClient.loadCardsFromFile();
			new Finder(cards, heroes);
			
			Sevarog sev = new Sevarog(Finder.getHeroByID("7399ecfbab365cdb8543da3dfbe830e6"));
			Sparrow sparrow = new Sparrow(Finder.getHeroByID("fb582fe82f0956269d7d656189d8b845"));
			
			Player player1 = new Player(sparrow);
				player1.setDawn();
				Point location1 = new Point(1000, 1000);
				
			Player player2 = new Player(sev);
				player2.setDusk();
				Point location2 = new Point(1200, 1250);
				
			GameState gameState = new GameState();
				gameState.addPlayer(player1,location1);
				gameState.addPlayer(player2, location2);
				
			ArrayList<Player> targets = new ArrayList<>();
				targets.add(player2);

				player1.setBasicLevel(14);
				player1.setSecondaryLevel(3);
				player1.useBasic(gameState, targets);
				player1.useBasic(gameState, targets);
				player1.useBasic(gameState, targets);
				player1.useBasic(gameState, targets);
				player1.useBasic(gameState, targets);
				player1.useBasic(gameState, targets);
				player1.useBasic(gameState, targets);
		}
		
		
		if (loadAPITest){
			try {
				JsonClient.loadAPIKey();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (updateCardsTest){
			try {
				JsonClient.loadAPIKey();
				JsonClient.updateCardsFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if (updateHeroesTest){
			try {
				JsonClient.loadAPIKey();
				JsonClient.updateHeroesFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (cardsTest){
			Card[] cards = JsonClient.loadCardsFromFile();
			for (int n = 0; n<cards.length; n++){
				Printer.printCard(cards[n]);
			}
		}
		
		if (heroesTest){
			Hero[] heroes = JsonClient.loadHeroesFromFile();
			for (int n = 0; n<heroes.length; n++){
				Printer.printHero(heroes[n]);
			}
		}

		
		if (heroTest){	
			
			Hero[] heroes = JsonClient.loadHeroesFromFile();
			Card[] cards = JsonClient.loadCardsFromFile();
			new Finder(cards, heroes);
			
			// Load a hero from the JSON
			Sevarog sev = new Sevarog(Finder.getHeroByID("7399ecfbab365cdb8543da3dfbe830e6"));
			
			Player myPlayer = new Player();
			myPlayer.setHero(sev);
			myPlayer.setLevel(14);
			
			// Set the Number of soul stacks
			sev.setSoulStacks(140);
			
			// Let's calculate his maxHealth by adding BonusHealth + Base Health at his current level
			AttributesByLevel[] atts = sev.getAttributesByLevel();
			float maxHealth = atts[myPlayer.getLevel()].getMaxHealth();
			maxHealth+= sev.getBonusHealth();	
			
			// Let's see what we've got
			System.out.println(maxHealth);
			
			//Printer.printHero(sev);
		}
		
		if (cardTest){
			Card CircletofMana = Finder.getCardByID("e6c87a333cf003ba7738c452985b782b");
			Printer.printCard(CircletofMana);
		}
				
	}
}

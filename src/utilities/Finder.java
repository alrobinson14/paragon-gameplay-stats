package utilities;

import epicComm.objects.cards.Card;
import epicComm.objects.heroes.Hero;

public class Finder {
	private static Card[] cards;
	private static Hero[] heroes;
	
	
	public Finder(Card[] cards, Hero[] heroes){
		Finder.cards=cards;
		Finder.heroes=heroes;
	}
		
	public static Hero getHeroByName(String name){
		for (int n=0; n<heroes.length; n++){
			if (name.equals(heroes[n].getName()))
					return heroes[n];
		}
		return null;
	}
	
	public static Hero getHeroByID(String ID){
		for (int n=0; n<heroes.length; n++){
			if (ID.equals(heroes[n].getId()))
					return heroes[n];
		}
		return null;
	}
	

	
	public static Card getCardByName(String name){
		for (int n=0; n<cards.length; n++){
			if (name.equals(cards[n].getName()))
					return cards[n];
		}
		return null;
	}
	
	public static Card getCardByID(String ID){
		for (int n=0; n<cards.length; n++){
			if (ID.equals(cards[n].getId()))
					return cards[n];
		}
		return null;
	}

}

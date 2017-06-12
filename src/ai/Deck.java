package ai;

import java.util.ArrayList;

import epicComm.objects.cards.Card;
import epicComm.objects.heroes.Hero;

public class Deck {
	
	private String[] affinities;
	private ArrayList<Card> cards;
	
	public Deck(Hero hero){
		this.affinities=hero.getAffinities();
	}
	
	public void setAffinities(String[] affinities){
		this.affinities = affinities;
	}
	
	public String[] getAffinities(){
		return affinities;
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public void setCards(ArrayList<Card> cards){
		this.cards = cards;
	}
	
	public void addCard(Card card){
		if (cards.size() < 60){
			if (card.getAffinity().equals(affinities[0]) || 
				card.getAffinity().equals(affinities[1])){
				cards.add(card);
			}
		}
	}
	
	public void removeCard(Card card){
		if (cards.contains(card))
			cards.remove(card);	
	}
}

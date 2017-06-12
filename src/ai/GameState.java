package ai;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class GameState {
	
	private ArrayList<Player> teamDusk;
	private ArrayList<Player> teamDawn;
	
	private HashMap<Player, Point> locations;
		
	public GameState(){
		teamDusk = new ArrayList<Player>();
		teamDawn = new ArrayList<Player>();
		locations = new HashMap<Player, Point>();		
	}
	
	public void addPlayer(Player player, Point location)
	{
		if (player.isDawn())
			teamDawn.add(player);
		else
			teamDusk.add(player);
		
		locations.put(player, location);
	}
	
	public void removePlayer(Player player)
	{
		if (teamDawn.contains(player))
			teamDawn.remove(player);
		else
			teamDusk.remove(player);
		
		locations.remove(player);
	}
	
	public Point getLocation(Player player){
		return locations.get(player);
	}
		
	//TODO fix this
	public double getDistance(Player player1, Player player2){
		Point player1Location = getLocation(player1);
		Point player2Location = getLocation(player2);
		
		return Point.distance(player1Location.getX(), player1Location.getY(), player2Location.getX(), player2Location.getY());
	}	
}

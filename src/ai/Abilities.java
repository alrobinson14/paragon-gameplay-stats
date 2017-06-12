package ai;

import java.util.ArrayList;

public interface Abilities {
	public void useBasic(GameState gameState, ArrayList<Player> targets);
	public void usePrimary(GameState gameState, ArrayList<Player> targets);
	public void useAlternate(GameState gameState, ArrayList<Player> targets);
	public void useSecondary(GameState gameState, ArrayList<Player> targets);
	public void useUltimate(GameState gameState, ArrayList<Player> targets);
}

package com.cardgame.deckofcards.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {

	// public enum State {OPEN, PLAYING, FINISHED}

	private long gameId;	
	private Map<String, Integer> deckMap;
	private Deck deck;
	// private State state;
	private ArrayList<Player> players;
	private int noOfPlayers;
	private ArrayList<Player> sortedPlayers;

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	
	public int getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}
	

	/*public Map<String, Integer> getDeckMap() {
		return deckMap;
	}

	public void setDeckMap(Map<String, Integer> deckMap) {
		this.deckMap = deckMap;
	}*/

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public ArrayList<Player> getSortedPlayers() {
		return sortedPlayers;
	}

	public void setSortedPlayers(ArrayList<Player> sortedPlayers) {
		this.sortedPlayers = sortedPlayers;
	}	

}

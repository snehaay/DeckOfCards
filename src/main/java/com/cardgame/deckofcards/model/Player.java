package com.cardgame.deckofcards.model;

import java.util.HashMap;
import java.util.Map;

public class Player {
	
	private String name;
	private Map<String, Integer> cards;
	private int addCardValue;

	public Player() {		
		cards = new HashMap<String, Integer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Integer> getCards() {
		return cards;
	}

	public void setCards(Map<String, Integer> cards) {
		this.cards = cards;
	}

	public int getAddCardValue() {
		return addCardValue;
	}

	public void setAddCardValue(int addCardValue) {
		this.addCardValue = addCardValue;
	}

	

	
	
	

}

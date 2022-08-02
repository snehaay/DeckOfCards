package com.cardgame.deckofcards.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Deck {

	private static final String[] SUITS = { "Clubs", "Hearts", "Spades", "Diamonds" };
	public static final String[] RANK = { "Ace ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "10 ", "Jack ", "Queen ",
			"King " };
	private static final Integer[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	private static int deckNum;
	private static int totalCards;
	private Map<String,Integer> deckCardValues =  null;
	private ArrayList<String> initialDeck = null;
	private ArrayList<String> shuffledArray = null;
	private String[] deck = null;
	
	public Deck(int deckNum) {
		Deck.deckNum = deckNum;
		Deck.totalCards = deckNum * 52;
		this.deckCardValues = new HashMap<>();
		this.initialDeck = new ArrayList<>();
		this.shuffledArray = new ArrayList<>();
		deck = new String[totalCards];
	}
	
	public static int getDeckNum() {
		return deckNum;
	}

	public static void setDeckNum(int deckNum) {
		Deck.deckNum = deckNum;
	}

	public static int getTotalCards() {	
		return totalCards;
	}

	public static void setTotalCards(int totalCards) {
		Deck.totalCards = totalCards;
	}

	public Map<String,Integer> getdeckCardValues() {
		return deckCardValues;
	}

	public void setdeckCardValues(Map<String,Integer> deckCardValues) {
		this.deckCardValues = deckCardValues;
	}

	public ArrayList<String> getInitialDeck() {
		return initialDeck;
	}

	public void setInitialDeck(ArrayList<String> initialDeck) {
		this.initialDeck = initialDeck;
	}

	public ArrayList<String> getShuffledArray() {
		return shuffledArray;
	}

	public void setShuffledArray(ArrayList<String> shuffledArray) {
		this.shuffledArray = shuffledArray;
	}


	public ArrayList<String> ReadDeck()
	{
		ArrayList<String> initialDeck = new ArrayList<String>();
		for(int j=0; j < totalCards; j++)
		{						
			deck[j] = Deck.RANK[j%13] + Deck.SUITS[j/13];
			initialDeck.add(j, deck[j]);						
			deckCardValues.put(deck[j], Deck.values[j%13]);		
		}	
		return initialDeck;
	}

	public ArrayList<String> Shuffle()
	{				
		ArrayList<String> shuffledDeck = new ArrayList<String>();
		//Shuffling cards
		for(int i =0; i < totalCards; i++)
		{
			int index = (int)(Math.random()*totalCards);
			String temp = deck[i];
			deck[i]=deck[index];
			deck[index]= temp;
			shuffledDeck.add(i, deck[i]);
		}
		return shuffledDeck;		
	}
	
	public ArrayList<Player> DealCards(int noOfPlayers, int noOfDistribute)
	{
		ArrayList<Player> playerList = new ArrayList<>();
		int cnt = 0;
		int cardValues =0;
		for(int p =0; p < noOfPlayers; p++)
		{
			Player player = new Player();
			player.setName("Player-"+(p+1));
			Map<String, Integer> cardMap = new HashMap<>();
			for(int card=(p*noOfDistribute) ; card < (noOfDistribute+(p*noOfDistribute)); card++)
			{					
				cardMap.put(deck[card], deckCardValues.get(deck[card]));				
				cnt++;
				cardValues = cardValues + cardMap.get(deck[card]);				
			}
			player.setAddCardValue(cardValues);
			player.setCards(cardMap);			
			playerList.add(player);						   
		}		
			
		System.out.println("Remaining cards from Deck");
		
		//Remaining cards from Deck
		for(int rem = cnt; rem < totalCards; rem++)
		{
			System.out.println(deck[rem]);
		}
		
		return playerList;
	}
	
	public ArrayList<Player> SortPlayer(ArrayList<Player> playerList)
	{
		Collections.sort(playerList, new Comparator<Player>() {
		    public int compare(Player p1, Player p2) {
		    	Integer v1 = p1.getAddCardValue();
				Integer v2 = p1.getAddCardValue();
				return Integer.compare(v2, v1);
		    }
		});
		return playerList ;	
	}

}

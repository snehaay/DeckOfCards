package com.cardgame.deckofcards.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cardgame.deckofcards.excption.GameServiceException;
import com.cardgame.deckofcards.model.Deck;
import com.cardgame.deckofcards.model.Game;
import com.cardgame.deckofcards.model.Player;


@Service
public class GameService {
	
	private static List<Game> gameList = new ArrayList<Game>();

	public Game createGame(Game game) {
		// TODO Auto-generated method stub
		
		int noOfPlayers = game.getNoOfPlayers();		
		Deck deck = new Deck(1);
		ArrayList<String> deckList= deck.ReadDeck();
		//deck.setDeckvalues(deckMap);
		deck.setInitialDeck(deckList);
		game.setDeck(deck);
		//game.setDeckMap(deckMap);
		gameList.add(game);
		return game;	
	}
	
	public void DeleteGame(int id)
	{
		for(Game game : gameList) {
			if(game.getGameId() == id)
				gameList.remove(id);
		}
	}
	
	
	public Game findOne(int id)
	{
		boolean found = false;
		for(Game game : gameList) {
			if(game.getGameId() == id)
			{
				found = true;
				return game;	
			}
		}
		
		if(!found)
			throw new GameServiceException("Game with this id is not present");
		return null;
		
	}
	
	
	public Game Shuffle(int id)
	{
		boolean found = false;
		for(Game game : gameList) {
			if(game.getGameId() == id)
			{
				Deck deck = game.getDeck();					
				ArrayList<String> shuffledList =   deck.Shuffle();
				deck.setShuffledArray(shuffledList);			
				return game;
			}
		}
		if(!found)
			throw new GameServiceException("Game with this id is not present");
		return null;		
	}
	
	
	public Game DealOfCards(int id)
	{
		boolean found = false;
		for(Game game : gameList) {
			if(game.getGameId() == id)
			{
				Deck deck = game.getDeck();				
				ArrayList<Player> PlayerList = deck.DealCards(game.getNoOfPlayers(), 5);
				ArrayList<Player> sortedPlayerList = deck.SortPlayer(PlayerList);
				game.setPlayers(PlayerList);
				game.setSortedPlayers(sortedPlayerList);
				return game;
			}
		}
		if(!found)
			throw new GameServiceException("Game with this id is not present");
		return null;
	}

}

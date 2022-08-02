package com.cardgame.deckofcards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cardgame.deckofcards.model.Deck;
import com.cardgame.deckofcards.model.Game;
import com.cardgame.deckofcards.service.GameService;
import org.springframework.hateoas.EntityModel;


@RestController
public class GameController {
	
	@Autowired
	GameService gameService;
	
	@GetMapping("/games/{gamesid}")
	public EntityModel<Game> retriveGame(@PathVariable int gamesid)
	{
		Game gamereturned = gameService.findOne(gamesid);		
		EntityModel<Game> model =  EntityModel.of(gamereturned);
		return model;			
	}
	
	@GetMapping("/shuffle/{gamesid}")
	public EntityModel<Game> Shuffle(@PathVariable int gamesid)
	{
		Game gamereturned = gameService.Shuffle(gamesid);		
		EntityModel<Game> model =  EntityModel.of(gamereturned);		
		return model;			
	}
	
	@GetMapping("/display/{gamesid}")
	public EntityModel<Game> Deal(@PathVariable int gamesid)
	{
		Game gamereturned = gameService.DealOfCards(gamesid);		
		EntityModel<Game> model =  EntityModel.of(gamereturned);		
		return model;			
	}
	
	@PostMapping(path="/games")
	public ResponseEntity<Game> create(@RequestBody Game game)
	{
		Game gamereturned = gameService.createGame(game);		
		return new ResponseEntity<Game>(HttpStatus.CREATED);		
	}
	
	@DeleteMapping("/delete/{gamesid}")
	public ResponseEntity<Game> create(@PathVariable int gamesid)
	{
		gameService.DeleteGame(gamesid);		
		return new ResponseEntity<Game>(HttpStatus.GONE);		
	}

}

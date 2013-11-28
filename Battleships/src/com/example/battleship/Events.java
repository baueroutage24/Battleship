package com.example.battleship;

public enum Events 
{
	PLAYER_REGISTRED('A'),
	ALL_PLAYERS_FOUND('B'),
	ALL_PLAYERS_READY('C'),
	GAME_OVER('D'),
	PLAYER_READY('E'),
	GAME_START('F'),
	ATTACK_RESULT('G'),
	TURN_OVER('H');
	
	private char code;
		 
	 private Events(char c) {
	   code = c;
	 }
		 
	 public char getCode() {
	   return code;
	 }	 
}

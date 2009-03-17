grammar Actions;

options {
	language = Java;
	output=AST;
	backtrack=true;
}

tokens{
  ACTION;
  PARAMETERS;
  PRECONDITIONS;
  EFFECTS;
  CHARACTER;
}

@header {package parser;}

@lexer::header {package parser;}

// Parser

document: action* EOF -> action*;

action: name=NAME parameters? preconditions* effects -> ^(ACTION[name] parameters? preconditions* effects);

parameters: 'involves' parameter+ -> ^(PARAMETERS parameter+);

parameter: name=NAME '-' 'Character' -> CHARACTER[name];

preconditions: 'or'? 'when' precondition+ -> ^(PRECONDITIONS precondition+);

precondition: proposition | property;

effects: 'then' proposition+ -> ^(EFFECTS proposition+);

proposition: NAME EXTRAS* PROPOSITION2 EXTRAS* NAME -> ^(PROPOSITION2 NAME NAME) |
             NAME EXTRAS* NEGATIVE EXTRAS* prop=PROPOSITION2 EXTRAS* NAME -> ^(PROPOSITION2["!" + prop.getText()] NAME NAME) |
             
             NAME EXTRAS* PROPOSITION1 -> ^(PROPOSITION1 NAME);

property: NAME EXTRAS* PROPERTY -> ^(PROPERTY NAME);

// Lexer

PROPERTY : 'attractive';

PROPOSITION1 : 'drunk';

PROPOSITION2 : 'flirts' | 'likes' | 'at' | 'fancies' | 'fancy';

NEGATIVE: 'doesn\'t' | 'not';

EXTRAS : 'with' | 'is'; 

NAME : LETTER+;

fragment LETTER : 'a'..'z' | 'A'..'Z' | '_' ;

WS  :  (
  ' '|
  '\r'|
  '\t' {input.setCharPositionInLine(input.getCharPositionInLine() + 3);}
  |'\u000C'
  |'\n'
  ) {$channel=HIDDEN;}
    ;
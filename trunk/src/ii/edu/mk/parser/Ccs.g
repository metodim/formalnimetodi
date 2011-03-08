grammar Ccs;

options {
	output=AST;
	ASTLabelType=CommonTree;
}

tokens {
	DEF;
	ADD;
	SYNC;
	RESTRICT;
	RENAME;
	PROCESS;
	TRANSITION;
	ZAGRADI;
}

@header {
	package ii.edu.mk.parser;
}

process_def
	: var=PROCESS_VAR '=' proc=process -> ^(DEF $var $proc)
	;
	
process
	: 
	( proc=PROCESS_VAR r=process -> ^($r $proc)
	| trans=TRANSITION_VAR r=process -> ^($r $trans)
	| parentheses r=process -> ^(ZAGRADI $r)
	| transition r=process -> ^(TRANSITION $r)
	| renaming r=process -> ^(RENAME $r)
	| restriction r=process -> ^(RESTRICT $r)
	| WS)
	//(  addition -> ^(ADD addition)
	//| synchronization -> ^(SYNC synchronization))*	
	;

parentheses
	: 	'(' process ')' ->  process
	;
	
transition
	: 	'.' -> ^()
	;

renaming
	: 	'[' rens+=(TRANSITION_VAR '/' TRANSITION_VAR) (',' rens+=(TRANSITION_VAR '/' TRANSITION_VAR))* ']' -> ^($rens)
	;

restriction
	:	'\{' rests+=TRANSITION_VAR (',' rests+=TRANSITION_VAR)* '}' {System.out.println("cmd="+$rests.toString());} -> ^($rests)
	;

addition
	: 	'+' process -> process
	;

synchronization
	:	'|' process -> process
	;	


TRANSITION_VAR
	: ('a'..'z'|'_')('a'..'z'|'0'..'9'|'_')*
	;
PROCESS_VAR  	
	:('A'..'Z'|'_')('A'..'Z'|'0'..'9'|'_')*
	;
WS  	:   ( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; }
	;
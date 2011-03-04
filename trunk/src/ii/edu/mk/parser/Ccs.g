grammar Ccs;

options {
	output=AST;
	language=Java;
	ASTLabelType=CommonTree;
}

tokens {
	DEF;
	ADD;
	SYNC;
//	RESTRICT;
//	RENAME;
//	PROCESS;
	TRANSITION;
}

@header {
	package ii.edu.mk.parser;
}

process_def
	: PROCESS_VAR '=' process -> ^(DEF PROCESS_VAR process)
	;
	
process
	: (PROCESS_VAR process
	| parentheses
	| transition
	| renaming
	| restriction
	| WS)
//	(  addition | synchronization )*	
	;

parentheses
	: 	'(' process ')'	
	;
	
transition
	: 	TRANSITION_VAR '.' process -> ^(TRANSITION TRANSITION_VAR process)
	//| 	PROCESS_VAR '.' process -> ^(TRANSITION PROCESS_VAR process)
	;

renaming
	: 	'[' (TRANSITION_VAR '/' TRANSITION_VAR) (',' TRANSITION_VAR '/' TRANSITION_VAR)* ']'
	;

restriction
	:	'\{' (TRANSITION_VAR) (',' TRANSITION_VAR)* '}'
	;

//addition
//	: 	'+' process 
//	;
//
//synchronization
//	:	'|' process
//	;	


TRANSITION_VAR
	: ('a'..'z'|'_')('a'..'z'|'0'..'9'|'_')*
	;
PROCESS_VAR  	
	:('A'..'Z'|'_')('A'..'Z'|'0'..'9'|'_')*
	;
WS  	:   ( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; }
	;
grammar Ccs1;

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
}

@header {
	package ii.edu.mk.parser;
}

expr
	: var=PROCESS_VAR '=' proc=start -> ^(DEF $var $proc)
	| start
	;
	catch[RecognitionException e] { throw e; }

start 	: 	'(' start ')' (extended_operator)?
	| 	TRANSITION_VAR (operator)?
	| 	PROCESS_VAR  (extended_operator)?
	;
	catch[RecognitionException e] { throw e; }
	
extended_operator
	:	restriction
	| 	operator
	;
	catch[RecognitionException e] { throw e; }
	
operator:	start
	|	trans
	|	plus
	|	sync
	;
	catch[RecognitionException e] { throw e; }
	
trans	: 	'.' start
	;
	catch[RecognitionException e] { throw e; }
	
plus 	: 	'+' start
	;
	catch[RecognitionException e] { throw e; }
	
sync	: 	'|' start
	;
	catch[RecognitionException e] { throw e; }
	
renaming
	: 	'[' rens+=(TRANSITION_VAR '/' TRANSITION_VAR) (',' rens+=(TRANSITION_VAR '/' TRANSITION_VAR))* ']' (extended_operator)?
	;
	catch[RecognitionException e] { throw e; }
	
restriction
	:	'\{' rests+=TRANSITION_VAR (',' rests+=TRANSITION_VAR)* '}' (start)?
	;	
	catch[RecognitionException e] { throw e; }

TRANSITION_VAR
	: '#' | (('_')?('a'..'z')('a'..'z'|'0'..'9'|'_')*)
	;
	
PROCESS_VAR  	
	: '0' | (('A'..'Z'|'_')('A'..'Z'|'0'..'9'|'_')*)
	;
	
	
WS  	:   ( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; }
	;
	
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


@parser::members {

	@Override
	protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
		throw new MismatchedTokenException(ttype, input);
	}
	
	@Override
	public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException {
		throw e;
	}

}

@rulecatch {
	catch (RecognitionException e) {
		throw e;
	}
}

@lexer::members {
	@Override
	public void reportError(RecognitionException e) {
		throw new RuntimeException(e);
	}
} 

@header {
	package ii.edu.mk.parser;
}

expr
	: var=PROCESS_VAR '=' proc=start EOF -> ^(DEF $var $proc)
	| start EOF
	;

start 	: 	'(' start ')' (extended_operator | renaming)?
	| 	TRANSITION_VAR (operator)?
	| 	PROCESS_VAR  (extended_operator | renaming)?
	;
	
extended_operator
	:	restriction
	| 	operator
	;
	
operator:
		trans
	|	plus
	|	sync
	;
	
trans	: 	'.' start
	;
	
plus 	: 	'+' start
	;
	
sync	: 	'|' start
	;
	
renaming
	: 	'[' rens+=(TRANSITION_VAR '/' TRANSITION_VAR) (',' rens+=(TRANSITION_VAR '/' TRANSITION_VAR))* ']' (extended_operator)?
	;
	
restriction
	:	'\{' rests+=TRANSITION_VAR (',' rests+=TRANSITION_VAR)* '}' (start)?
	;	

TRANSITION_VAR
	:	'#' | (('_')?('a'..'z')('a'..'z'|'0'..'9'|'_')*)
	;
	
PROCESS_VAR  	
	: 	'0' | (('A'..'Z')('A'..'Z'|'0'..'9'|'_')*)
	;
	
	
WS  	:   	( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; }
	;
	
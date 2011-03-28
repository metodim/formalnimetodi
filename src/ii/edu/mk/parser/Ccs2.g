grammar Ccs2;

options {
	output=AST;
	ASTLabelType=CommonTree;
}

tokens {
	DEF;
	RESTRICT;
	RESTRICT_LABELS;
	RENAME;
	RENAME_CLAUSE;
	RENAME_SINGLE;
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
/* 
	Excerpt from the book: Reactive Systems 
	Section "2.2. CCS, formally" 
	page 23
	
	... we use the convention that the operators have decreasing binding strength in the following
	order: restriction and relabelling (the tightest binding), action prefixing, parallel
	composition and summation. For example, the expression a.0 | b.P \ L + c.0
	stands for ((a.0) | (b.(P \ L))) + (c.0).
*/

expr
	: var=PROCESS '=' proc=sync EOF 	-> ^(DEF $var $proc)
	| sync EOF!
	;

sync	: plus ('|'^ p=plus)*;	// TODO: we should try to produce non-binary AST tree

plus	: start ('+'^ start)*;	// TODO: we should try to produce non-binary AST tree
 
start 	: 	trans
 	| 	('(' s=sync ')' | p=process)	 (	rest=restriction 	-> ^(RESTRICT $s? $p? $rest) 
 						| 	ren=renaming 		-> ^(RENAME $s? $p? $ren)
 						|	WS* 			-> $s? $p?)

	;
	
trans	:	t+=trans_var ('.' (t+=trans_var | t+=process | t+=sync))+ -> ^(TRANSITION $t+);

process	:	PROCESS;

trans_var
	:	action;
	
renaming
	: 	'[' r+=ren1 (',' r+=ren1)* ']' 		-> ^(RENAME_CLAUSE $r+)
	;
ren1	:	action '/' action 	-> ^(RENAME_SINGLE action+);

restriction
	:	'\\{' rests+=label_or_colabel (',' rests+=label_or_colabel)* '}' -> ^(RESTRICT_LABELS $rests+)
	;	

action
	:	TAU | CO_LABEL | LABEL
	;
	
label_or_colabel
	:	LABEL|CO_LABEL
	;
	
LABEL	
	: 	(('a'..'z')('a'..'z'|'0'..'9'|'_')*)
	;

CO_LABEL	
	: 	'_'LABEL
	;

TAU
	:	'#'
	;
		
PROCESS  	
	: 	'0' | (('A'..'Z')('A'..'Z'|'0'..'9'|'_')*)
	;
	
	
WS  	:   	( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; }
	;
	
grammar Ccs2;

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
	RENAME_SINGLE;
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
	: var=PROCESS_VAR '=' proc=sync EOF 	-> ^(DEF $var $proc)
	| sync EOF!
	;
	 
sync	: plus ('|'^ p=plus)*;	// TODO: we should try to produce non-binary AST tree

plus	: start ('+'^ start)*;	// TODO: we should try to produce non-binary AST tree
 
start 	: 	trans
 	| 	('('! s=sync ')'! | p=process) (rest=restriction | ren=renaming)?
	;
	
trans	:	t+=trans_var ('.' (t+=trans_var | t+=process | t+=sync))+ -> ^(TRANSITION $t+);

process	:	PROCESS_VAR;

trans_var
	:	action;
	
renaming
	: 	'[' r+=ren1 (',' r+=ren1)* ']' 		-> ^(RENAME $r+)
	;
ren1	:	action '/' action 	-> ^(RENAME_SINGLE action+);

restriction
	:	'\\{' rests+=label_or_colabel (',' rests+=label_or_colabel)* '}' -> ^(RESTRICT $rests+)
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
		
PROCESS_VAR  	
	: 	'0' | (('A'..'Z')('A'..'Z'|'0'..'9'|'_')*)
	;
	
	
WS  	:   	( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; }
	;
	
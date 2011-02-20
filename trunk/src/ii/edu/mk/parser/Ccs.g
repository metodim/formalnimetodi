grammar Ccs;

options {
language=Java;
}

@header {
package mk.edu.ii.parser;
}

process_def
	: process_var '=' process
	;

process 
	: process_var
	| '(' process ')'
	| transition_var '.' process
	| add_process
	| sync_process
	| '[' transition_var '/' transition_var ']'
	| '\{' transition_var '}'	
	;
	
add_process
	: 	'+' process	
	;
	
sync_process
	:	'|' process
	;
	
process_var
	: ('A'..'Z') ('A'..'Z' |'0'..'9' )*
	;
transition_var
	: ('a'..'z') ('a'..'z' |'0'..'9' )*
	;

// $ANTLR 3.3 Nov 30, 2010 12:45:30 /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g 2011-03-17 23:27:22

	package ii.edu.mk.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class Ccs1Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DEF", "ADD", "SYNC", "RESTRICT", "RENAME", "PROCESS", "TRANSITION", "PROCESS_VAR", "TRANSITION_VAR", "WS", "'='", "'('", "')'", "'.'", "'+'", "'|'", "'['", "'/'", "','", "']'", "'\\{'", "'}'"
    };
    public static final int EOF=-1;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int DEF=4;
    public static final int ADD=5;
    public static final int SYNC=6;
    public static final int RESTRICT=7;
    public static final int RENAME=8;
    public static final int PROCESS=9;
    public static final int TRANSITION=10;
    public static final int PROCESS_VAR=11;
    public static final int TRANSITION_VAR=12;
    public static final int WS=13;

    // delegates
    // delegators


        public Ccs1Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public Ccs1Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return Ccs1Parser.tokenNames; }
    public String getGrammarFileName() { return "/home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g"; }



    	@Override
    	protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
    		throw new MismatchedTokenException(ttype, input);
    	}
    	
    	@Override
    	public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException {
    		throw e;
    	}



    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:50:1: expr : (var= PROCESS_VAR '=' proc= start EOF -> ^( DEF $var $proc) | start EOF );
    public final Ccs1Parser.expr_return expr() throws RecognitionException {
        Ccs1Parser.expr_return retval = new Ccs1Parser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token var=null;
        Token char_literal1=null;
        Token EOF2=null;
        Token EOF4=null;
        Ccs1Parser.start_return proc = null;

        Ccs1Parser.start_return start3 = null;


        CommonTree var_tree=null;
        CommonTree char_literal1_tree=null;
        CommonTree EOF2_tree=null;
        CommonTree EOF4_tree=null;
        RewriteRuleTokenStream stream_PROCESS_VAR=new RewriteRuleTokenStream(adaptor,"token PROCESS_VAR");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_14=new RewriteRuleTokenStream(adaptor,"token 14");
        RewriteRuleSubtreeStream stream_start=new RewriteRuleSubtreeStream(adaptor,"rule start");
        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:51:2: (var= PROCESS_VAR '=' proc= start EOF -> ^( DEF $var $proc) | start EOF )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==PROCESS_VAR) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==14) ) {
                    alt1=1;
                }
                else if ( (LA1_1==EOF||(LA1_1>=17 && LA1_1<=20)||LA1_1==24) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==TRANSITION_VAR||LA1_0==15) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:51:4: var= PROCESS_VAR '=' proc= start EOF
                    {
                    var=(Token)match(input,PROCESS_VAR,FOLLOW_PROCESS_VAR_in_expr95);  
                    stream_PROCESS_VAR.add(var);

                    char_literal1=(Token)match(input,14,FOLLOW_14_in_expr97);  
                    stream_14.add(char_literal1);

                    pushFollow(FOLLOW_start_in_expr101);
                    proc=start();

                    state._fsp--;

                    stream_start.add(proc.getTree());
                    EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_expr103);  
                    stream_EOF.add(EOF2);



                    // AST REWRITE
                    // elements: var, proc
                    // token labels: var
                    // rule labels: retval, proc
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_var=new RewriteRuleTokenStream(adaptor,"token var",var);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_proc=new RewriteRuleSubtreeStream(adaptor,"rule proc",proc!=null?proc.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 51:39: -> ^( DEF $var $proc)
                    {
                        // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:51:42: ^( DEF $var $proc)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEF, "DEF"), root_1);

                        adaptor.addChild(root_1, stream_var.nextNode());
                        adaptor.addChild(root_1, stream_proc.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:52:4: start EOF
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_start_in_expr120);
                    start3=start();

                    state._fsp--;

                    adaptor.addChild(root_0, start3.getTree());
                    EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_expr122); 
                    EOF4_tree = (CommonTree)adaptor.create(EOF4);
                    adaptor.addChild(root_0, EOF4_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		throw e;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class start_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "start"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:55:1: start : ( '(' start ')' ( extended_operator | renaming )? | TRANSITION_VAR ( operator )? | PROCESS_VAR ( extended_operator | renaming )? );
    public final Ccs1Parser.start_return start() throws RecognitionException {
        Ccs1Parser.start_return retval = new Ccs1Parser.start_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal5=null;
        Token char_literal7=null;
        Token TRANSITION_VAR10=null;
        Token PROCESS_VAR12=null;
        Ccs1Parser.start_return start6 = null;

        Ccs1Parser.extended_operator_return extended_operator8 = null;

        Ccs1Parser.renaming_return renaming9 = null;

        Ccs1Parser.operator_return operator11 = null;

        Ccs1Parser.extended_operator_return extended_operator13 = null;

        Ccs1Parser.renaming_return renaming14 = null;


        CommonTree char_literal5_tree=null;
        CommonTree char_literal7_tree=null;
        CommonTree TRANSITION_VAR10_tree=null;
        CommonTree PROCESS_VAR12_tree=null;

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:55:8: ( '(' start ')' ( extended_operator | renaming )? | TRANSITION_VAR ( operator )? | PROCESS_VAR ( extended_operator | renaming )? )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt5=1;
                }
                break;
            case TRANSITION_VAR:
                {
                alt5=2;
                }
                break;
            case PROCESS_VAR:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:55:11: '(' start ')' ( extended_operator | renaming )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal5=(Token)match(input,15,FOLLOW_15_in_start134); 
                    char_literal5_tree = (CommonTree)adaptor.create(char_literal5);
                    adaptor.addChild(root_0, char_literal5_tree);

                    pushFollow(FOLLOW_start_in_start136);
                    start6=start();

                    state._fsp--;

                    adaptor.addChild(root_0, start6.getTree());
                    char_literal7=(Token)match(input,16,FOLLOW_16_in_start138); 
                    char_literal7_tree = (CommonTree)adaptor.create(char_literal7);
                    adaptor.addChild(root_0, char_literal7_tree);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:55:25: ( extended_operator | renaming )?
                    int alt2=3;
                    int LA2_0 = input.LA(1);

                    if ( ((LA2_0>=17 && LA2_0<=19)||LA2_0==24) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==20) ) {
                        alt2=2;
                    }
                    switch (alt2) {
                        case 1 :
                            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:55:26: extended_operator
                            {
                            pushFollow(FOLLOW_extended_operator_in_start141);
                            extended_operator8=extended_operator();

                            state._fsp--;

                            adaptor.addChild(root_0, extended_operator8.getTree());

                            }
                            break;
                        case 2 :
                            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:55:46: renaming
                            {
                            pushFollow(FOLLOW_renaming_in_start145);
                            renaming9=renaming();

                            state._fsp--;

                            adaptor.addChild(root_0, renaming9.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:56:5: TRANSITION_VAR ( operator )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    TRANSITION_VAR10=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_start153); 
                    TRANSITION_VAR10_tree = (CommonTree)adaptor.create(TRANSITION_VAR10);
                    adaptor.addChild(root_0, TRANSITION_VAR10_tree);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:56:20: ( operator )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>=17 && LA3_0<=19)) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:56:21: operator
                            {
                            pushFollow(FOLLOW_operator_in_start156);
                            operator11=operator();

                            state._fsp--;

                            adaptor.addChild(root_0, operator11.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:57:5: PROCESS_VAR ( extended_operator | renaming )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PROCESS_VAR12=(Token)match(input,PROCESS_VAR,FOLLOW_PROCESS_VAR_in_start164); 
                    PROCESS_VAR12_tree = (CommonTree)adaptor.create(PROCESS_VAR12);
                    adaptor.addChild(root_0, PROCESS_VAR12_tree);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:57:18: ( extended_operator | renaming )?
                    int alt4=3;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=17 && LA4_0<=19)||LA4_0==24) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==20) ) {
                        alt4=2;
                    }
                    switch (alt4) {
                        case 1 :
                            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:57:19: extended_operator
                            {
                            pushFollow(FOLLOW_extended_operator_in_start168);
                            extended_operator13=extended_operator();

                            state._fsp--;

                            adaptor.addChild(root_0, extended_operator13.getTree());

                            }
                            break;
                        case 2 :
                            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:57:39: renaming
                            {
                            pushFollow(FOLLOW_renaming_in_start172);
                            renaming14=renaming();

                            state._fsp--;

                            adaptor.addChild(root_0, renaming14.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		throw e;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "start"

    public static class extended_operator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "extended_operator"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:60:1: extended_operator : ( restriction | operator );
    public final Ccs1Parser.extended_operator_return extended_operator() throws RecognitionException {
        Ccs1Parser.extended_operator_return retval = new Ccs1Parser.extended_operator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ccs1Parser.restriction_return restriction15 = null;

        Ccs1Parser.operator_return operator16 = null;



        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:61:2: ( restriction | operator )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==24) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=17 && LA6_0<=19)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:61:4: restriction
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_restriction_in_extended_operator186);
                    restriction15=restriction();

                    state._fsp--;

                    adaptor.addChild(root_0, restriction15.getTree());

                    }
                    break;
                case 2 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:62:5: operator
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_operator_in_extended_operator192);
                    operator16=operator();

                    state._fsp--;

                    adaptor.addChild(root_0, operator16.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		throw e;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "extended_operator"

    public static class operator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operator"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:65:1: operator : ( trans | plus | sync );
    public final Ccs1Parser.operator_return operator() throws RecognitionException {
        Ccs1Parser.operator_return retval = new Ccs1Parser.operator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ccs1Parser.trans_return trans17 = null;

        Ccs1Parser.plus_return plus18 = null;

        Ccs1Parser.sync_return sync19 = null;



        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:65:9: ( trans | plus | sync )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt7=1;
                }
                break;
            case 18:
                {
                alt7=2;
                }
                break;
            case 19:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:66:3: trans
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_trans_in_operator204);
                    trans17=trans();

                    state._fsp--;

                    adaptor.addChild(root_0, trans17.getTree());

                    }
                    break;
                case 2 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:67:4: plus
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_plus_in_operator209);
                    plus18=plus();

                    state._fsp--;

                    adaptor.addChild(root_0, plus18.getTree());

                    }
                    break;
                case 3 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:68:4: sync
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_sync_in_operator214);
                    sync19=sync();

                    state._fsp--;

                    adaptor.addChild(root_0, sync19.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		throw e;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "operator"

    public static class trans_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "trans"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:71:1: trans : '.' start ;
    public final Ccs1Parser.trans_return trans() throws RecognitionException {
        Ccs1Parser.trans_return retval = new Ccs1Parser.trans_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal20=null;
        Ccs1Parser.start_return start21 = null;


        CommonTree char_literal20_tree=null;

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:71:7: ( '.' start )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:71:10: '.' start
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal20=(Token)match(input,17,FOLLOW_17_in_trans226); 
            char_literal20_tree = (CommonTree)adaptor.create(char_literal20);
            adaptor.addChild(root_0, char_literal20_tree);

            pushFollow(FOLLOW_start_in_trans228);
            start21=start();

            state._fsp--;

            adaptor.addChild(root_0, start21.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		throw e;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "trans"

    public static class plus_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "plus"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:74:1: plus : '+' start ;
    public final Ccs1Parser.plus_return plus() throws RecognitionException {
        Ccs1Parser.plus_return retval = new Ccs1Parser.plus_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal22=null;
        Ccs1Parser.start_return start23 = null;


        CommonTree char_literal22_tree=null;

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:74:7: ( '+' start )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:74:10: '+' start
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal22=(Token)match(input,18,FOLLOW_18_in_plus241); 
            char_literal22_tree = (CommonTree)adaptor.create(char_literal22);
            adaptor.addChild(root_0, char_literal22_tree);

            pushFollow(FOLLOW_start_in_plus243);
            start23=start();

            state._fsp--;

            adaptor.addChild(root_0, start23.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		throw e;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "plus"

    public static class sync_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sync"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:77:1: sync : '|' start ;
    public final Ccs1Parser.sync_return sync() throws RecognitionException {
        Ccs1Parser.sync_return retval = new Ccs1Parser.sync_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal24=null;
        Ccs1Parser.start_return start25 = null;


        CommonTree char_literal24_tree=null;

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:77:6: ( '|' start )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:77:9: '|' start
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal24=(Token)match(input,19,FOLLOW_19_in_sync255); 
            char_literal24_tree = (CommonTree)adaptor.create(char_literal24);
            adaptor.addChild(root_0, char_literal24_tree);

            pushFollow(FOLLOW_start_in_sync257);
            start25=start();

            state._fsp--;

            adaptor.addChild(root_0, start25.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		throw e;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "sync"

    public static class renaming_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "renaming"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:80:1: renaming : '[' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR ) ( ',' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR ) )* ']' ( extended_operator )? ;
    public final Ccs1Parser.renaming_return renaming() throws RecognitionException {
        Ccs1Parser.renaming_return retval = new Ccs1Parser.renaming_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal26=null;
        Token TRANSITION_VAR27=null;
        Token char_literal28=null;
        Token TRANSITION_VAR29=null;
        Token char_literal30=null;
        Token TRANSITION_VAR31=null;
        Token char_literal32=null;
        Token TRANSITION_VAR33=null;
        Token char_literal34=null;
        Token rens=null;
        List list_rens=null;
        Ccs1Parser.extended_operator_return extended_operator35 = null;


        CommonTree char_literal26_tree=null;
        CommonTree TRANSITION_VAR27_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree TRANSITION_VAR29_tree=null;
        CommonTree char_literal30_tree=null;
        CommonTree TRANSITION_VAR31_tree=null;
        CommonTree char_literal32_tree=null;
        CommonTree TRANSITION_VAR33_tree=null;
        CommonTree char_literal34_tree=null;
        CommonTree rens_tree=null;

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:81:2: ( '[' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR ) ( ',' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR ) )* ']' ( extended_operator )? )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:81:5: '[' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR ) ( ',' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR ) )* ']' ( extended_operator )?
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal26=(Token)match(input,20,FOLLOW_20_in_renaming270); 
            char_literal26_tree = (CommonTree)adaptor.create(char_literal26);
            adaptor.addChild(root_0, char_literal26_tree);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:81:15: ( TRANSITION_VAR '/' TRANSITION_VAR )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:81:16: TRANSITION_VAR '/' TRANSITION_VAR
            {
            TRANSITION_VAR27=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_renaming275); 
            TRANSITION_VAR27_tree = (CommonTree)adaptor.create(TRANSITION_VAR27);
            adaptor.addChild(root_0, TRANSITION_VAR27_tree);

            char_literal28=(Token)match(input,21,FOLLOW_21_in_renaming277); 
            char_literal28_tree = (CommonTree)adaptor.create(char_literal28);
            adaptor.addChild(root_0, char_literal28_tree);

            TRANSITION_VAR29=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_renaming279); 
            TRANSITION_VAR29_tree = (CommonTree)adaptor.create(TRANSITION_VAR29);
            adaptor.addChild(root_0, TRANSITION_VAR29_tree);


            }

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:81:51: ( ',' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:81:52: ',' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR )
            	    {
            	    char_literal30=(Token)match(input,22,FOLLOW_22_in_renaming283); 
            	    char_literal30_tree = (CommonTree)adaptor.create(char_literal30);
            	    adaptor.addChild(root_0, char_literal30_tree);

            	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:81:62: ( TRANSITION_VAR '/' TRANSITION_VAR )
            	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:81:63: TRANSITION_VAR '/' TRANSITION_VAR
            	    {
            	    TRANSITION_VAR31=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_renaming288); 
            	    TRANSITION_VAR31_tree = (CommonTree)adaptor.create(TRANSITION_VAR31);
            	    adaptor.addChild(root_0, TRANSITION_VAR31_tree);

            	    char_literal32=(Token)match(input,21,FOLLOW_21_in_renaming290); 
            	    char_literal32_tree = (CommonTree)adaptor.create(char_literal32);
            	    adaptor.addChild(root_0, char_literal32_tree);

            	    TRANSITION_VAR33=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_renaming292); 
            	    TRANSITION_VAR33_tree = (CommonTree)adaptor.create(TRANSITION_VAR33);
            	    adaptor.addChild(root_0, TRANSITION_VAR33_tree);


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            char_literal34=(Token)match(input,23,FOLLOW_23_in_renaming297); 
            char_literal34_tree = (CommonTree)adaptor.create(char_literal34);
            adaptor.addChild(root_0, char_literal34_tree);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:81:104: ( extended_operator )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=17 && LA9_0<=19)||LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:81:105: extended_operator
                    {
                    pushFollow(FOLLOW_extended_operator_in_renaming300);
                    extended_operator35=extended_operator();

                    state._fsp--;

                    adaptor.addChild(root_0, extended_operator35.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		throw e;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "renaming"

    public static class restriction_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "restriction"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:84:1: restriction : '\\{' rests+= TRANSITION_VAR ( ',' rests+= TRANSITION_VAR )* '}' ( start )? ;
    public final Ccs1Parser.restriction_return restriction() throws RecognitionException {
        Ccs1Parser.restriction_return retval = new Ccs1Parser.restriction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal36=null;
        Token char_literal37=null;
        Token char_literal38=null;
        Token rests=null;
        List list_rests=null;
        Ccs1Parser.start_return start39 = null;


        CommonTree char_literal36_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree rests_tree=null;

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:85:2: ( '\\{' rests+= TRANSITION_VAR ( ',' rests+= TRANSITION_VAR )* '}' ( start )? )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:85:4: '\\{' rests+= TRANSITION_VAR ( ',' rests+= TRANSITION_VAR )* '}' ( start )?
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal36=(Token)match(input,24,FOLLOW_24_in_restriction314); 
            char_literal36_tree = (CommonTree)adaptor.create(char_literal36);
            adaptor.addChild(root_0, char_literal36_tree);

            rests=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_restriction318); 
            rests_tree = (CommonTree)adaptor.create(rests);
            adaptor.addChild(root_0, rests_tree);

            if (list_rests==null) list_rests=new ArrayList();
            list_rests.add(rests);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:85:31: ( ',' rests+= TRANSITION_VAR )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==22) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:85:32: ',' rests+= TRANSITION_VAR
            	    {
            	    char_literal37=(Token)match(input,22,FOLLOW_22_in_restriction321); 
            	    char_literal37_tree = (CommonTree)adaptor.create(char_literal37);
            	    adaptor.addChild(root_0, char_literal37_tree);

            	    rests=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_restriction325); 
            	    rests_tree = (CommonTree)adaptor.create(rests);
            	    adaptor.addChild(root_0, rests_tree);

            	    if (list_rests==null) list_rests=new ArrayList();
            	    list_rests.add(rests);


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            char_literal38=(Token)match(input,25,FOLLOW_25_in_restriction329); 
            char_literal38_tree = (CommonTree)adaptor.create(char_literal38);
            adaptor.addChild(root_0, char_literal38_tree);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:85:64: ( start )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=PROCESS_VAR && LA11_0<=TRANSITION_VAR)||LA11_0==15) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:85:65: start
                    {
                    pushFollow(FOLLOW_start_in_restriction332);
                    start39=start();

                    state._fsp--;

                    adaptor.addChild(root_0, start39.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        	catch (RecognitionException e) {
        		throw e;
        	}
        finally {
        }
        return retval;
    }
    // $ANTLR end "restriction"

    // Delegated rules


 

    public static final BitSet FOLLOW_PROCESS_VAR_in_expr95 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_expr97 = new BitSet(new long[]{0x0000000000009800L});
    public static final BitSet FOLLOW_start_in_expr101 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expr103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_start_in_expr120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expr122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_start134 = new BitSet(new long[]{0x0000000000009800L});
    public static final BitSet FOLLOW_start_in_start136 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_start138 = new BitSet(new long[]{0x00000000011E0002L});
    public static final BitSet FOLLOW_extended_operator_in_start141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_renaming_in_start145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_start153 = new BitSet(new long[]{0x00000000010E0002L});
    public static final BitSet FOLLOW_operator_in_start156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROCESS_VAR_in_start164 = new BitSet(new long[]{0x00000000011E0002L});
    public static final BitSet FOLLOW_extended_operator_in_start168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_renaming_in_start172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_restriction_in_extended_operator186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operator_in_extended_operator192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_trans_in_operator204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_operator209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sync_in_operator214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_trans226 = new BitSet(new long[]{0x0000000000009800L});
    public static final BitSet FOLLOW_start_in_trans228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_plus241 = new BitSet(new long[]{0x0000000000009800L});
    public static final BitSet FOLLOW_start_in_plus243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_sync255 = new BitSet(new long[]{0x0000000000009800L});
    public static final BitSet FOLLOW_start_in_sync257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_renaming270 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_renaming275 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_renaming277 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_renaming279 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_renaming283 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_renaming288 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_renaming290 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_renaming292 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_renaming297 = new BitSet(new long[]{0x00000000010E0002L});
    public static final BitSet FOLLOW_extended_operator_in_renaming300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_restriction314 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_restriction318 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_22_in_restriction321 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_restriction325 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_25_in_restriction329 = new BitSet(new long[]{0x0000000000009802L});
    public static final BitSet FOLLOW_start_in_restriction332 = new BitSet(new long[]{0x0000000000000002L});

}
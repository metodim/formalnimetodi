// $ANTLR 3.3 Nov 30, 2010 12:45:30 /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g 2011-03-08 23:12:19

	package ii.edu.mk.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;

import org.antlr.runtime.tree.*;

public class Ccs1Parser extends DebugParser {
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

    public static final String[] ruleNames = new String[] {
        "invalidRule", "plus", "restriction", "start", "trans", "operator", 
        "renaming", "expr", "sync", "extended_operator"
    };
    public static final boolean[] decisionCanBacktrack = new boolean[] {
        false, // invalid decision
        false, false, false, false, false, false, false, false, false, false, 
            false
    };

     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public Ccs1Parser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public Ccs1Parser(TokenStream input, int port, RecognizerSharedState state) {
            super(input, state);
            DebugEventSocketProxy proxy =
                new DebugEventSocketProxy(this,port,adaptor);
            setDebugListener(proxy);
            setTokenStream(new DebugTokenStream(input,proxy));
            try {
                proxy.handshake();
            }
            catch (IOException ioe) {
                reportError(ioe);
            }
            TreeAdaptor adap = new CommonTreeAdaptor();
            setTreeAdaptor(adap);
            proxy.setTreeAdaptor(adap);
        }
    public Ccs1Parser(TokenStream input, DebugEventListener dbg) {
        super(input, dbg);

         
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);

    }
    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }

    protected DebugTreeAdaptor adaptor;
    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = new DebugTreeAdaptor(dbg,adaptor);

    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }


    public String[] getTokenNames() { return Ccs1Parser.tokenNames; }
    public String getGrammarFileName() { return "/home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g"; }


    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:22:1: expr : (var= PROCESS_VAR '=' proc= start -> ^( DEF $var $proc) | start );
    public final Ccs1Parser.expr_return expr() throws RecognitionException {
        Ccs1Parser.expr_return retval = new Ccs1Parser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token var=null;
        Token char_literal1=null;
        Ccs1Parser.start_return proc = null;

        Ccs1Parser.start_return start2 = null;


        CommonTree var_tree=null;
        CommonTree char_literal1_tree=null;
        RewriteRuleTokenStream stream_PROCESS_VAR=new RewriteRuleTokenStream(adaptor,"token PROCESS_VAR");
        RewriteRuleTokenStream stream_14=new RewriteRuleTokenStream(adaptor,"token 14");
        RewriteRuleSubtreeStream stream_start=new RewriteRuleSubtreeStream(adaptor,"rule start");
        try { dbg.enterRule(getGrammarFileName(), "expr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(22, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:23:2: (var= PROCESS_VAR '=' proc= start -> ^( DEF $var $proc) | start )
            int alt1=2;
            try { dbg.enterDecision(1, decisionCanBacktrack[1]);

            int LA1_0 = input.LA(1);

            if ( (LA1_0==PROCESS_VAR) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==14) ) {
                    alt1=1;
                }
                else if ( (LA1_1==EOF||(LA1_1>=PROCESS_VAR && LA1_1<=TRANSITION_VAR)||LA1_1==15||(LA1_1>=17 && LA1_1<=19)||LA1_1==24) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;
                }
            }
            else if ( (LA1_0==TRANSITION_VAR||LA1_0==15) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(1);}

            switch (alt1) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:23:4: var= PROCESS_VAR '=' proc= start
                    {
                    dbg.location(23,7);
                    var=(Token)match(input,PROCESS_VAR,FOLLOW_PROCESS_VAR_in_expr69);  
                    stream_PROCESS_VAR.add(var);

                    dbg.location(23,20);
                    char_literal1=(Token)match(input,14,FOLLOW_14_in_expr71);  
                    stream_14.add(char_literal1);

                    dbg.location(23,28);
                    pushFollow(FOLLOW_start_in_expr75);
                    proc=start();

                    state._fsp--;

                    stream_start.add(proc.getTree());


                    // AST REWRITE
                    // elements: proc, var
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
                    // 23:35: -> ^( DEF $var $proc)
                    {
                        dbg.location(23,38);
                        // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:23:38: ^( DEF $var $proc)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(23,40);
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEF, "DEF"), root_1);

                        dbg.location(23,44);
                        adaptor.addChild(root_1, stream_var.nextNode());
                        dbg.location(23,49);
                        adaptor.addChild(root_1, stream_proc.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:24:4: start
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(24,4);
                    pushFollow(FOLLOW_start_in_expr92);
                    start2=start();

                    state._fsp--;

                    adaptor.addChild(root_0, start2.getTree());

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
        dbg.location(25, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "expr"

    public static class start_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "start"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:28:1: start : ( '(' start ')' ( extended_operator )? | TRANSITION_VAR ( operator )? | PROCESS_VAR ( extended_operator )? );
    public final Ccs1Parser.start_return start() throws RecognitionException {
        Ccs1Parser.start_return retval = new Ccs1Parser.start_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal3=null;
        Token char_literal5=null;
        Token TRANSITION_VAR7=null;
        Token PROCESS_VAR9=null;
        Ccs1Parser.start_return start4 = null;

        Ccs1Parser.extended_operator_return extended_operator6 = null;

        Ccs1Parser.operator_return operator8 = null;

        Ccs1Parser.extended_operator_return extended_operator10 = null;


        CommonTree char_literal3_tree=null;
        CommonTree char_literal5_tree=null;
        CommonTree TRANSITION_VAR7_tree=null;
        CommonTree PROCESS_VAR9_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "start");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(28, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:28:8: ( '(' start ')' ( extended_operator )? | TRANSITION_VAR ( operator )? | PROCESS_VAR ( extended_operator )? )
            int alt5=3;
            try { dbg.enterDecision(5, decisionCanBacktrack[5]);

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

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(5);}

            switch (alt5) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:28:11: '(' start ')' ( extended_operator )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(28,11);
                    char_literal3=(Token)match(input,15,FOLLOW_15_in_start110); 
                    char_literal3_tree = (CommonTree)adaptor.create(char_literal3);
                    adaptor.addChild(root_0, char_literal3_tree);

                    dbg.location(28,15);
                    pushFollow(FOLLOW_start_in_start112);
                    start4=start();

                    state._fsp--;

                    adaptor.addChild(root_0, start4.getTree());
                    dbg.location(28,21);
                    char_literal5=(Token)match(input,16,FOLLOW_16_in_start114); 
                    char_literal5_tree = (CommonTree)adaptor.create(char_literal5);
                    adaptor.addChild(root_0, char_literal5_tree);

                    dbg.location(28,25);
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:28:25: ( extended_operator )?
                    int alt2=2;
                    try { dbg.enterSubRule(2);
                    try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                    int LA2_0 = input.LA(1);

                    if ( ((LA2_0>=PROCESS_VAR && LA2_0<=TRANSITION_VAR)||LA2_0==15||(LA2_0>=17 && LA2_0<=19)||LA2_0==24) ) {
                        alt2=1;
                    }
                    } finally {dbg.exitDecision(2);}

                    switch (alt2) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:28:26: extended_operator
                            {
                            dbg.location(28,26);
                            pushFollow(FOLLOW_extended_operator_in_start117);
                            extended_operator6=extended_operator();

                            state._fsp--;

                            adaptor.addChild(root_0, extended_operator6.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(2);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:29:5: TRANSITION_VAR ( operator )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(29,5);
                    TRANSITION_VAR7=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_start125); 
                    TRANSITION_VAR7_tree = (CommonTree)adaptor.create(TRANSITION_VAR7);
                    adaptor.addChild(root_0, TRANSITION_VAR7_tree);

                    dbg.location(29,20);
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:29:20: ( operator )?
                    int alt3=2;
                    try { dbg.enterSubRule(3);
                    try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>=PROCESS_VAR && LA3_0<=TRANSITION_VAR)||LA3_0==15||(LA3_0>=17 && LA3_0<=19)) ) {
                        alt3=1;
                    }
                    } finally {dbg.exitDecision(3);}

                    switch (alt3) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:29:21: operator
                            {
                            dbg.location(29,21);
                            pushFollow(FOLLOW_operator_in_start128);
                            operator8=operator();

                            state._fsp--;

                            adaptor.addChild(root_0, operator8.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(3);}


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:30:5: PROCESS_VAR ( extended_operator )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(30,5);
                    PROCESS_VAR9=(Token)match(input,PROCESS_VAR,FOLLOW_PROCESS_VAR_in_start136); 
                    PROCESS_VAR9_tree = (CommonTree)adaptor.create(PROCESS_VAR9);
                    adaptor.addChild(root_0, PROCESS_VAR9_tree);

                    dbg.location(30,18);
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:30:18: ( extended_operator )?
                    int alt4=2;
                    try { dbg.enterSubRule(4);
                    try { dbg.enterDecision(4, decisionCanBacktrack[4]);

                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=PROCESS_VAR && LA4_0<=TRANSITION_VAR)||LA4_0==15||(LA4_0>=17 && LA4_0<=19)||LA4_0==24) ) {
                        alt4=1;
                    }
                    } finally {dbg.exitDecision(4);}

                    switch (alt4) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:30:19: extended_operator
                            {
                            dbg.location(30,19);
                            pushFollow(FOLLOW_extended_operator_in_start140);
                            extended_operator10=extended_operator();

                            state._fsp--;

                            adaptor.addChild(root_0, extended_operator10.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(4);}


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
        dbg.location(31, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "start");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "start"

    public static class extended_operator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "extended_operator"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:34:1: extended_operator : ( restriction | operator );
    public final Ccs1Parser.extended_operator_return extended_operator() throws RecognitionException {
        Ccs1Parser.extended_operator_return retval = new Ccs1Parser.extended_operator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ccs1Parser.restriction_return restriction11 = null;

        Ccs1Parser.operator_return operator12 = null;



        try { dbg.enterRule(getGrammarFileName(), "extended_operator");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(34, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:35:2: ( restriction | operator )
            int alt6=2;
            try { dbg.enterDecision(6, decisionCanBacktrack[6]);

            int LA6_0 = input.LA(1);

            if ( (LA6_0==24) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=PROCESS_VAR && LA6_0<=TRANSITION_VAR)||LA6_0==15||(LA6_0>=17 && LA6_0<=19)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(6);}

            switch (alt6) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:35:4: restriction
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(35,4);
                    pushFollow(FOLLOW_restriction_in_extended_operator160);
                    restriction11=restriction();

                    state._fsp--;

                    adaptor.addChild(root_0, restriction11.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:36:5: operator
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(36,5);
                    pushFollow(FOLLOW_operator_in_extended_operator166);
                    operator12=operator();

                    state._fsp--;

                    adaptor.addChild(root_0, operator12.getTree());

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
        dbg.location(37, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "extended_operator");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "extended_operator"

    public static class operator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operator"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:40:1: operator : ( start | trans | plus | sync );
    public final Ccs1Parser.operator_return operator() throws RecognitionException {
        Ccs1Parser.operator_return retval = new Ccs1Parser.operator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ccs1Parser.start_return start13 = null;

        Ccs1Parser.trans_return trans14 = null;

        Ccs1Parser.plus_return plus15 = null;

        Ccs1Parser.sync_return sync16 = null;



        try { dbg.enterRule(getGrammarFileName(), "operator");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(40, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:40:9: ( start | trans | plus | sync )
            int alt7=4;
            try { dbg.enterDecision(7, decisionCanBacktrack[7]);

            switch ( input.LA(1) ) {
            case PROCESS_VAR:
            case TRANSITION_VAR:
            case 15:
                {
                alt7=1;
                }
                break;
            case 17:
                {
                alt7=2;
                }
                break;
            case 18:
                {
                alt7=3;
                }
                break;
            case 19:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(7);}

            switch (alt7) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:40:11: start
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(40,11);
                    pushFollow(FOLLOW_start_in_operator182);
                    start13=start();

                    state._fsp--;

                    adaptor.addChild(root_0, start13.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:41:4: trans
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(41,4);
                    pushFollow(FOLLOW_trans_in_operator187);
                    trans14=trans();

                    state._fsp--;

                    adaptor.addChild(root_0, trans14.getTree());

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:42:4: plus
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(42,4);
                    pushFollow(FOLLOW_plus_in_operator192);
                    plus15=plus();

                    state._fsp--;

                    adaptor.addChild(root_0, plus15.getTree());

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:43:4: sync
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(43,4);
                    pushFollow(FOLLOW_sync_in_operator197);
                    sync16=sync();

                    state._fsp--;

                    adaptor.addChild(root_0, sync16.getTree());

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
        dbg.location(44, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "operator");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "operator"

    public static class trans_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "trans"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:47:1: trans : '.' start ;
    public final Ccs1Parser.trans_return trans() throws RecognitionException {
        Ccs1Parser.trans_return retval = new Ccs1Parser.trans_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal17=null;
        Ccs1Parser.start_return start18 = null;


        CommonTree char_literal17_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "trans");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(47, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:47:7: ( '.' start )
            dbg.enterAlt(1);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:47:10: '.' start
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(47,10);
            char_literal17=(Token)match(input,17,FOLLOW_17_in_trans215); 
            char_literal17_tree = (CommonTree)adaptor.create(char_literal17);
            adaptor.addChild(root_0, char_literal17_tree);

            dbg.location(47,14);
            pushFollow(FOLLOW_start_in_trans217);
            start18=start();

            state._fsp--;

            adaptor.addChild(root_0, start18.getTree());

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
        dbg.location(48, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "trans");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "trans"

    public static class plus_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "plus"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:51:1: plus : '+' start ;
    public final Ccs1Parser.plus_return plus() throws RecognitionException {
        Ccs1Parser.plus_return retval = new Ccs1Parser.plus_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal19=null;
        Ccs1Parser.start_return start20 = null;


        CommonTree char_literal19_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "plus");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(51, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:51:7: ( '+' start )
            dbg.enterAlt(1);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:51:10: '+' start
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(51,10);
            char_literal19=(Token)match(input,18,FOLLOW_18_in_plus236); 
            char_literal19_tree = (CommonTree)adaptor.create(char_literal19);
            adaptor.addChild(root_0, char_literal19_tree);

            dbg.location(51,14);
            pushFollow(FOLLOW_start_in_plus238);
            start20=start();

            state._fsp--;

            adaptor.addChild(root_0, start20.getTree());

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
        dbg.location(52, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "plus");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "plus"

    public static class sync_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sync"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:55:1: sync : '|' start ;
    public final Ccs1Parser.sync_return sync() throws RecognitionException {
        Ccs1Parser.sync_return retval = new Ccs1Parser.sync_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal21=null;
        Ccs1Parser.start_return start22 = null;


        CommonTree char_literal21_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "sync");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(55, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:55:6: ( '|' start )
            dbg.enterAlt(1);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:55:9: '|' start
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(55,9);
            char_literal21=(Token)match(input,19,FOLLOW_19_in_sync256); 
            char_literal21_tree = (CommonTree)adaptor.create(char_literal21);
            adaptor.addChild(root_0, char_literal21_tree);

            dbg.location(55,13);
            pushFollow(FOLLOW_start_in_sync258);
            start22=start();

            state._fsp--;

            adaptor.addChild(root_0, start22.getTree());

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
        dbg.location(56, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "sync");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "sync"

    public static class renaming_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "renaming"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:59:1: renaming : '[' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR ) ( ',' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR ) )* ']' ( extended_operator )? ;
    public final Ccs1Parser.renaming_return renaming() throws RecognitionException {
        Ccs1Parser.renaming_return retval = new Ccs1Parser.renaming_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal23=null;
        Token TRANSITION_VAR24=null;
        Token char_literal25=null;
        Token TRANSITION_VAR26=null;
        Token char_literal27=null;
        Token TRANSITION_VAR28=null;
        Token char_literal29=null;
        Token TRANSITION_VAR30=null;
        Token char_literal31=null;
        Token rens=null;
        List list_rens=null;
        Ccs1Parser.extended_operator_return extended_operator32 = null;


        CommonTree char_literal23_tree=null;
        CommonTree TRANSITION_VAR24_tree=null;
        CommonTree char_literal25_tree=null;
        CommonTree TRANSITION_VAR26_tree=null;
        CommonTree char_literal27_tree=null;
        CommonTree TRANSITION_VAR28_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree TRANSITION_VAR30_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree rens_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "renaming");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(59, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:60:2: ( '[' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR ) ( ',' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR ) )* ']' ( extended_operator )? )
            dbg.enterAlt(1);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:60:5: '[' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR ) ( ',' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR ) )* ']' ( extended_operator )?
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(60,5);
            char_literal23=(Token)match(input,20,FOLLOW_20_in_renaming277); 
            char_literal23_tree = (CommonTree)adaptor.create(char_literal23);
            adaptor.addChild(root_0, char_literal23_tree);

            dbg.location(60,13);
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:60:15: ( TRANSITION_VAR '/' TRANSITION_VAR )
            dbg.enterAlt(1);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:60:16: TRANSITION_VAR '/' TRANSITION_VAR
            {
            dbg.location(60,16);
            TRANSITION_VAR24=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_renaming282); 
            TRANSITION_VAR24_tree = (CommonTree)adaptor.create(TRANSITION_VAR24);
            adaptor.addChild(root_0, TRANSITION_VAR24_tree);

            dbg.location(60,31);
            char_literal25=(Token)match(input,21,FOLLOW_21_in_renaming284); 
            char_literal25_tree = (CommonTree)adaptor.create(char_literal25);
            adaptor.addChild(root_0, char_literal25_tree);

            dbg.location(60,35);
            TRANSITION_VAR26=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_renaming286); 
            TRANSITION_VAR26_tree = (CommonTree)adaptor.create(TRANSITION_VAR26);
            adaptor.addChild(root_0, TRANSITION_VAR26_tree);


            }

            dbg.location(60,51);
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:60:51: ( ',' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR ) )*
            try { dbg.enterSubRule(8);

            loop8:
            do {
                int alt8=2;
                try { dbg.enterDecision(8, decisionCanBacktrack[8]);

                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }


                } finally {dbg.exitDecision(8);}

                switch (alt8) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:60:52: ',' rens+= ( TRANSITION_VAR '/' TRANSITION_VAR )
            	    {
            	    dbg.location(60,52);
            	    char_literal27=(Token)match(input,22,FOLLOW_22_in_renaming290); 
            	    char_literal27_tree = (CommonTree)adaptor.create(char_literal27);
            	    adaptor.addChild(root_0, char_literal27_tree);

            	    dbg.location(60,60);
            	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:60:62: ( TRANSITION_VAR '/' TRANSITION_VAR )
            	    dbg.enterAlt(1);

            	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:60:63: TRANSITION_VAR '/' TRANSITION_VAR
            	    {
            	    dbg.location(60,63);
            	    TRANSITION_VAR28=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_renaming295); 
            	    TRANSITION_VAR28_tree = (CommonTree)adaptor.create(TRANSITION_VAR28);
            	    adaptor.addChild(root_0, TRANSITION_VAR28_tree);

            	    dbg.location(60,78);
            	    char_literal29=(Token)match(input,21,FOLLOW_21_in_renaming297); 
            	    char_literal29_tree = (CommonTree)adaptor.create(char_literal29);
            	    adaptor.addChild(root_0, char_literal29_tree);

            	    dbg.location(60,82);
            	    TRANSITION_VAR30=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_renaming299); 
            	    TRANSITION_VAR30_tree = (CommonTree)adaptor.create(TRANSITION_VAR30);
            	    adaptor.addChild(root_0, TRANSITION_VAR30_tree);


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);
            } finally {dbg.exitSubRule(8);}

            dbg.location(60,100);
            char_literal31=(Token)match(input,23,FOLLOW_23_in_renaming304); 
            char_literal31_tree = (CommonTree)adaptor.create(char_literal31);
            adaptor.addChild(root_0, char_literal31_tree);

            dbg.location(60,104);
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:60:104: ( extended_operator )?
            int alt9=2;
            try { dbg.enterSubRule(9);
            try { dbg.enterDecision(9, decisionCanBacktrack[9]);

            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=PROCESS_VAR && LA9_0<=TRANSITION_VAR)||LA9_0==15||(LA9_0>=17 && LA9_0<=19)||LA9_0==24) ) {
                alt9=1;
            }
            } finally {dbg.exitDecision(9);}

            switch (alt9) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:60:105: extended_operator
                    {
                    dbg.location(60,105);
                    pushFollow(FOLLOW_extended_operator_in_renaming307);
                    extended_operator32=extended_operator();

                    state._fsp--;

                    adaptor.addChild(root_0, extended_operator32.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(9);}


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
        dbg.location(61, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "renaming");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "renaming"

    public static class restriction_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "restriction"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:64:1: restriction : '\\{' rests+= TRANSITION_VAR ( ',' rests+= TRANSITION_VAR )* '}' ( start )? ;
    public final Ccs1Parser.restriction_return restriction() throws RecognitionException {
        Ccs1Parser.restriction_return retval = new Ccs1Parser.restriction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal33=null;
        Token char_literal34=null;
        Token char_literal35=null;
        Token rests=null;
        List list_rests=null;
        Ccs1Parser.start_return start36 = null;


        CommonTree char_literal33_tree=null;
        CommonTree char_literal34_tree=null;
        CommonTree char_literal35_tree=null;
        CommonTree rests_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "restriction");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(64, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:65:2: ( '\\{' rests+= TRANSITION_VAR ( ',' rests+= TRANSITION_VAR )* '}' ( start )? )
            dbg.enterAlt(1);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:65:4: '\\{' rests+= TRANSITION_VAR ( ',' rests+= TRANSITION_VAR )* '}' ( start )?
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(65,4);
            char_literal33=(Token)match(input,24,FOLLOW_24_in_restriction327); 
            char_literal33_tree = (CommonTree)adaptor.create(char_literal33);
            adaptor.addChild(root_0, char_literal33_tree);

            dbg.location(65,14);
            rests=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_restriction331); 
            rests_tree = (CommonTree)adaptor.create(rests);
            adaptor.addChild(root_0, rests_tree);

            if (list_rests==null) list_rests=new ArrayList();
            list_rests.add(rests);

            dbg.location(65,31);
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:65:31: ( ',' rests+= TRANSITION_VAR )*
            try { dbg.enterSubRule(10);

            loop10:
            do {
                int alt10=2;
                try { dbg.enterDecision(10, decisionCanBacktrack[10]);

                int LA10_0 = input.LA(1);

                if ( (LA10_0==22) ) {
                    alt10=1;
                }


                } finally {dbg.exitDecision(10);}

                switch (alt10) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:65:32: ',' rests+= TRANSITION_VAR
            	    {
            	    dbg.location(65,32);
            	    char_literal34=(Token)match(input,22,FOLLOW_22_in_restriction334); 
            	    char_literal34_tree = (CommonTree)adaptor.create(char_literal34);
            	    adaptor.addChild(root_0, char_literal34_tree);

            	    dbg.location(65,41);
            	    rests=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_restriction338); 
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
            } finally {dbg.exitSubRule(10);}

            dbg.location(65,60);
            char_literal35=(Token)match(input,25,FOLLOW_25_in_restriction342); 
            char_literal35_tree = (CommonTree)adaptor.create(char_literal35);
            adaptor.addChild(root_0, char_literal35_tree);

            dbg.location(65,64);
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:65:64: ( start )?
            int alt11=2;
            try { dbg.enterSubRule(11);
            try { dbg.enterDecision(11, decisionCanBacktrack[11]);

            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=PROCESS_VAR && LA11_0<=TRANSITION_VAR)||LA11_0==15) ) {
                alt11=1;
            }
            } finally {dbg.exitDecision(11);}

            switch (alt11) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:65:65: start
                    {
                    dbg.location(65,65);
                    pushFollow(FOLLOW_start_in_restriction345);
                    start36=start();

                    state._fsp--;

                    adaptor.addChild(root_0, start36.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(11);}


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
        dbg.location(66, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "restriction");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "restriction"

    // Delegated rules


 

    public static final BitSet FOLLOW_PROCESS_VAR_in_expr69 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_expr71 = new BitSet(new long[]{0x0000000000009800L});
    public static final BitSet FOLLOW_start_in_expr75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_start_in_expr92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_start110 = new BitSet(new long[]{0x0000000000009800L});
    public static final BitSet FOLLOW_start_in_start112 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_start114 = new BitSet(new long[]{0x00000000010E9802L});
    public static final BitSet FOLLOW_extended_operator_in_start117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_start125 = new BitSet(new long[]{0x00000000010E9802L});
    public static final BitSet FOLLOW_operator_in_start128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROCESS_VAR_in_start136 = new BitSet(new long[]{0x00000000010E9802L});
    public static final BitSet FOLLOW_extended_operator_in_start140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_restriction_in_extended_operator160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operator_in_extended_operator166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_start_in_operator182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_trans_in_operator187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_operator192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sync_in_operator197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_trans215 = new BitSet(new long[]{0x0000000000009800L});
    public static final BitSet FOLLOW_start_in_trans217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_plus236 = new BitSet(new long[]{0x0000000000009800L});
    public static final BitSet FOLLOW_start_in_plus238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_sync256 = new BitSet(new long[]{0x0000000000009800L});
    public static final BitSet FOLLOW_start_in_sync258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_renaming277 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_renaming282 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_renaming284 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_renaming286 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_22_in_renaming290 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_renaming295 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_renaming297 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_renaming299 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_23_in_renaming304 = new BitSet(new long[]{0x00000000010E9802L});
    public static final BitSet FOLLOW_extended_operator_in_renaming307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_restriction327 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_restriction331 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_22_in_restriction334 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_restriction338 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_25_in_restriction342 = new BitSet(new long[]{0x0000000000009802L});
    public static final BitSet FOLLOW_start_in_restriction345 = new BitSet(new long[]{0x0000000000000002L});

}
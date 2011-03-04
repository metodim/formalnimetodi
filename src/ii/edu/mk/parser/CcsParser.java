// $ANTLR 3.3 Nov 30, 2010 12:45:30 /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g 2011-03-04 18:09:56

	package ii.edu.mk.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;

import org.antlr.runtime.tree.*;

public class CcsParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DEF", "ADD", "SYNC", "TRANSITION", "PROCESS_VAR", "WS", "TRANSITION_VAR", "'='", "'('", "')'", "'.'", "'['", "'/'", "','", "']'", "'\\{'", "'}'"
    };
    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int DEF=4;
    public static final int ADD=5;
    public static final int SYNC=6;
    public static final int TRANSITION=7;
    public static final int PROCESS_VAR=8;
    public static final int WS=9;
    public static final int TRANSITION_VAR=10;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "parentheses", "process_def", "process", "restriction", 
        "renaming", "transition"
    };
    public static final boolean[] decisionCanBacktrack = new boolean[] {
        false, // invalid decision
        false, false, false
    };

     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public CcsParser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public CcsParser(TokenStream input, int port, RecognizerSharedState state) {
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
    public CcsParser(TokenStream input, DebugEventListener dbg) {
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


    public String[] getTokenNames() { return CcsParser.tokenNames; }
    public String getGrammarFileName() { return "/home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g"; }


    public static class process_def_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "process_def"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:23:1: process_def : PROCESS_VAR '=' process -> ^( DEF PROCESS_VAR process ) ;
    public final CcsParser.process_def_return process_def() throws RecognitionException {
        CcsParser.process_def_return retval = new CcsParser.process_def_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PROCESS_VAR1=null;
        Token char_literal2=null;
        CcsParser.process_return process3 = null;


        CommonTree PROCESS_VAR1_tree=null;
        CommonTree char_literal2_tree=null;
        RewriteRuleTokenStream stream_PROCESS_VAR=new RewriteRuleTokenStream(adaptor,"token PROCESS_VAR");
        RewriteRuleTokenStream stream_11=new RewriteRuleTokenStream(adaptor,"token 11");
        RewriteRuleSubtreeStream stream_process=new RewriteRuleSubtreeStream(adaptor,"rule process");
        try { dbg.enterRule(getGrammarFileName(), "process_def");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(23, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:24:2: ( PROCESS_VAR '=' process -> ^( DEF PROCESS_VAR process ) )
            dbg.enterAlt(1);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:24:4: PROCESS_VAR '=' process
            {
            dbg.location(24,4);
            PROCESS_VAR1=(Token)match(input,PROCESS_VAR,FOLLOW_PROCESS_VAR_in_process_def64);  
            stream_PROCESS_VAR.add(PROCESS_VAR1);

            dbg.location(24,16);
            char_literal2=(Token)match(input,11,FOLLOW_11_in_process_def66);  
            stream_11.add(char_literal2);

            dbg.location(24,20);
            pushFollow(FOLLOW_process_in_process_def68);
            process3=process();

            state._fsp--;

            stream_process.add(process3.getTree());


            // AST REWRITE
            // elements: process, PROCESS_VAR
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 24:28: -> ^( DEF PROCESS_VAR process )
            {
                dbg.location(24,31);
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:24:31: ^( DEF PROCESS_VAR process )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(24,33);
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEF, "DEF"), root_1);

                dbg.location(24,37);
                adaptor.addChild(root_1, stream_PROCESS_VAR.nextNode());
                dbg.location(24,49);
                adaptor.addChild(root_1, stream_process.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(25, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "process_def");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "process_def"

    public static class process_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "process"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:27:1: process : ( PROCESS_VAR process | parentheses | transition | renaming | restriction | WS ) ;
    public final CcsParser.process_return process() throws RecognitionException {
        CcsParser.process_return retval = new CcsParser.process_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PROCESS_VAR4=null;
        Token WS10=null;
        CcsParser.process_return process5 = null;

        CcsParser.parentheses_return parentheses6 = null;

        CcsParser.transition_return transition7 = null;

        CcsParser.renaming_return renaming8 = null;

        CcsParser.restriction_return restriction9 = null;


        CommonTree PROCESS_VAR4_tree=null;
        CommonTree WS10_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "process");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(27, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:28:2: ( ( PROCESS_VAR process | parentheses | transition | renaming | restriction | WS ) )
            dbg.enterAlt(1);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:28:4: ( PROCESS_VAR process | parentheses | transition | renaming | restriction | WS )
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(28,4);
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:28:4: ( PROCESS_VAR process | parentheses | transition | renaming | restriction | WS )
            int alt1=6;
            try { dbg.enterSubRule(1);
            try { dbg.enterDecision(1, decisionCanBacktrack[1]);

            switch ( input.LA(1) ) {
            case PROCESS_VAR:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case TRANSITION_VAR:
                {
                alt1=3;
                }
                break;
            case 15:
                {
                alt1=4;
                }
                break;
            case 19:
                {
                alt1=5;
                }
                break;
            case WS:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(1);}

            switch (alt1) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:28:5: PROCESS_VAR process
                    {
                    dbg.location(28,5);
                    PROCESS_VAR4=(Token)match(input,PROCESS_VAR,FOLLOW_PROCESS_VAR_in_process91); 
                    PROCESS_VAR4_tree = (CommonTree)adaptor.create(PROCESS_VAR4);
                    adaptor.addChild(root_0, PROCESS_VAR4_tree);

                    dbg.location(28,17);
                    pushFollow(FOLLOW_process_in_process93);
                    process5=process();

                    state._fsp--;

                    adaptor.addChild(root_0, process5.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:29:4: parentheses
                    {
                    dbg.location(29,4);
                    pushFollow(FOLLOW_parentheses_in_process98);
                    parentheses6=parentheses();

                    state._fsp--;

                    adaptor.addChild(root_0, parentheses6.getTree());

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:30:4: transition
                    {
                    dbg.location(30,4);
                    pushFollow(FOLLOW_transition_in_process103);
                    transition7=transition();

                    state._fsp--;

                    adaptor.addChild(root_0, transition7.getTree());

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:31:4: renaming
                    {
                    dbg.location(31,4);
                    pushFollow(FOLLOW_renaming_in_process108);
                    renaming8=renaming();

                    state._fsp--;

                    adaptor.addChild(root_0, renaming8.getTree());

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:32:4: restriction
                    {
                    dbg.location(32,4);
                    pushFollow(FOLLOW_restriction_in_process113);
                    restriction9=restriction();

                    state._fsp--;

                    adaptor.addChild(root_0, restriction9.getTree());

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:33:4: WS
                    {
                    dbg.location(33,4);
                    WS10=(Token)match(input,WS,FOLLOW_WS_in_process118); 
                    WS10_tree = (CommonTree)adaptor.create(WS10);
                    adaptor.addChild(root_0, WS10_tree);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(1);}


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(35, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "process");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "process"

    public static class parentheses_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parentheses"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:37:1: parentheses : '(' process ')' ;
    public final CcsParser.parentheses_return parentheses() throws RecognitionException {
        CcsParser.parentheses_return retval = new CcsParser.parentheses_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal11=null;
        Token char_literal13=null;
        CcsParser.process_return process12 = null;


        CommonTree char_literal11_tree=null;
        CommonTree char_literal13_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "parentheses");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(37, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:38:2: ( '(' process ')' )
            dbg.enterAlt(1);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:38:5: '(' process ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(38,5);
            char_literal11=(Token)match(input,12,FOLLOW_12_in_parentheses132); 
            char_literal11_tree = (CommonTree)adaptor.create(char_literal11);
            adaptor.addChild(root_0, char_literal11_tree);

            dbg.location(38,9);
            pushFollow(FOLLOW_process_in_parentheses134);
            process12=process();

            state._fsp--;

            adaptor.addChild(root_0, process12.getTree());
            dbg.location(38,17);
            char_literal13=(Token)match(input,13,FOLLOW_13_in_parentheses136); 
            char_literal13_tree = (CommonTree)adaptor.create(char_literal13);
            adaptor.addChild(root_0, char_literal13_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(39, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "parentheses");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "parentheses"

    public static class transition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "transition"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:41:1: transition : TRANSITION_VAR '.' process -> ^( TRANSITION TRANSITION_VAR process ) ;
    public final CcsParser.transition_return transition() throws RecognitionException {
        CcsParser.transition_return retval = new CcsParser.transition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TRANSITION_VAR14=null;
        Token char_literal15=null;
        CcsParser.process_return process16 = null;


        CommonTree TRANSITION_VAR14_tree=null;
        CommonTree char_literal15_tree=null;
        RewriteRuleTokenStream stream_14=new RewriteRuleTokenStream(adaptor,"token 14");
        RewriteRuleTokenStream stream_TRANSITION_VAR=new RewriteRuleTokenStream(adaptor,"token TRANSITION_VAR");
        RewriteRuleSubtreeStream stream_process=new RewriteRuleSubtreeStream(adaptor,"rule process");
        try { dbg.enterRule(getGrammarFileName(), "transition");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(41, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:42:2: ( TRANSITION_VAR '.' process -> ^( TRANSITION TRANSITION_VAR process ) )
            dbg.enterAlt(1);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:42:5: TRANSITION_VAR '.' process
            {
            dbg.location(42,5);
            TRANSITION_VAR14=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_transition150);  
            stream_TRANSITION_VAR.add(TRANSITION_VAR14);

            dbg.location(42,20);
            char_literal15=(Token)match(input,14,FOLLOW_14_in_transition152);  
            stream_14.add(char_literal15);

            dbg.location(42,24);
            pushFollow(FOLLOW_process_in_transition154);
            process16=process();

            state._fsp--;

            stream_process.add(process16.getTree());


            // AST REWRITE
            // elements: process, TRANSITION_VAR
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 42:32: -> ^( TRANSITION TRANSITION_VAR process )
            {
                dbg.location(42,35);
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:42:35: ^( TRANSITION TRANSITION_VAR process )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(42,37);
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TRANSITION, "TRANSITION"), root_1);

                dbg.location(42,48);
                adaptor.addChild(root_1, stream_TRANSITION_VAR.nextNode());
                dbg.location(42,63);
                adaptor.addChild(root_1, stream_process.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(44, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "transition");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "transition"

    public static class renaming_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "renaming"
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:46:1: renaming : '[' ( TRANSITION_VAR '/' TRANSITION_VAR ) ( ',' TRANSITION_VAR '/' TRANSITION_VAR )* ']' ;
    public final CcsParser.renaming_return renaming() throws RecognitionException {
        CcsParser.renaming_return retval = new CcsParser.renaming_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal17=null;
        Token TRANSITION_VAR18=null;
        Token char_literal19=null;
        Token TRANSITION_VAR20=null;
        Token char_literal21=null;
        Token TRANSITION_VAR22=null;
        Token char_literal23=null;
        Token TRANSITION_VAR24=null;
        Token char_literal25=null;

        CommonTree char_literal17_tree=null;
        CommonTree TRANSITION_VAR18_tree=null;
        CommonTree char_literal19_tree=null;
        CommonTree TRANSITION_VAR20_tree=null;
        CommonTree char_literal21_tree=null;
        CommonTree TRANSITION_VAR22_tree=null;
        CommonTree char_literal23_tree=null;
        CommonTree TRANSITION_VAR24_tree=null;
        CommonTree char_literal25_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "renaming");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(46, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:47:2: ( '[' ( TRANSITION_VAR '/' TRANSITION_VAR ) ( ',' TRANSITION_VAR '/' TRANSITION_VAR )* ']' )
            dbg.enterAlt(1);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:47:5: '[' ( TRANSITION_VAR '/' TRANSITION_VAR ) ( ',' TRANSITION_VAR '/' TRANSITION_VAR )* ']'
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(47,5);
            char_literal17=(Token)match(input,15,FOLLOW_15_in_renaming178); 
            char_literal17_tree = (CommonTree)adaptor.create(char_literal17);
            adaptor.addChild(root_0, char_literal17_tree);

            dbg.location(47,9);
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:47:9: ( TRANSITION_VAR '/' TRANSITION_VAR )
            dbg.enterAlt(1);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:47:10: TRANSITION_VAR '/' TRANSITION_VAR
            {
            dbg.location(47,10);
            TRANSITION_VAR18=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_renaming181); 
            TRANSITION_VAR18_tree = (CommonTree)adaptor.create(TRANSITION_VAR18);
            adaptor.addChild(root_0, TRANSITION_VAR18_tree);

            dbg.location(47,25);
            char_literal19=(Token)match(input,16,FOLLOW_16_in_renaming183); 
            char_literal19_tree = (CommonTree)adaptor.create(char_literal19);
            adaptor.addChild(root_0, char_literal19_tree);

            dbg.location(47,29);
            TRANSITION_VAR20=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_renaming185); 
            TRANSITION_VAR20_tree = (CommonTree)adaptor.create(TRANSITION_VAR20);
            adaptor.addChild(root_0, TRANSITION_VAR20_tree);


            }

            dbg.location(47,45);
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:47:45: ( ',' TRANSITION_VAR '/' TRANSITION_VAR )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:47:46: ',' TRANSITION_VAR '/' TRANSITION_VAR
            	    {
            	    dbg.location(47,46);
            	    char_literal21=(Token)match(input,17,FOLLOW_17_in_renaming189); 
            	    char_literal21_tree = (CommonTree)adaptor.create(char_literal21);
            	    adaptor.addChild(root_0, char_literal21_tree);

            	    dbg.location(47,50);
            	    TRANSITION_VAR22=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_renaming191); 
            	    TRANSITION_VAR22_tree = (CommonTree)adaptor.create(TRANSITION_VAR22);
            	    adaptor.addChild(root_0, TRANSITION_VAR22_tree);

            	    dbg.location(47,65);
            	    char_literal23=(Token)match(input,16,FOLLOW_16_in_renaming193); 
            	    char_literal23_tree = (CommonTree)adaptor.create(char_literal23);
            	    adaptor.addChild(root_0, char_literal23_tree);

            	    dbg.location(47,69);
            	    TRANSITION_VAR24=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_renaming195); 
            	    TRANSITION_VAR24_tree = (CommonTree)adaptor.create(TRANSITION_VAR24);
            	    adaptor.addChild(root_0, TRANSITION_VAR24_tree);


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);
            } finally {dbg.exitSubRule(2);}

            dbg.location(47,86);
            char_literal25=(Token)match(input,18,FOLLOW_18_in_renaming199); 
            char_literal25_tree = (CommonTree)adaptor.create(char_literal25);
            adaptor.addChild(root_0, char_literal25_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(48, 2);

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
    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:50:1: restriction : '\\{' ( TRANSITION_VAR ) ( ',' TRANSITION_VAR )* '}' ;
    public final CcsParser.restriction_return restriction() throws RecognitionException {
        CcsParser.restriction_return retval = new CcsParser.restriction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal26=null;
        Token TRANSITION_VAR27=null;
        Token char_literal28=null;
        Token TRANSITION_VAR29=null;
        Token char_literal30=null;

        CommonTree char_literal26_tree=null;
        CommonTree TRANSITION_VAR27_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree TRANSITION_VAR29_tree=null;
        CommonTree char_literal30_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "restriction");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(50, 1);

        try {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:51:2: ( '\\{' ( TRANSITION_VAR ) ( ',' TRANSITION_VAR )* '}' )
            dbg.enterAlt(1);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:51:4: '\\{' ( TRANSITION_VAR ) ( ',' TRANSITION_VAR )* '}'
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(51,4);
            char_literal26=(Token)match(input,19,FOLLOW_19_in_restriction210); 
            char_literal26_tree = (CommonTree)adaptor.create(char_literal26);
            adaptor.addChild(root_0, char_literal26_tree);

            dbg.location(51,9);
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:51:9: ( TRANSITION_VAR )
            dbg.enterAlt(1);

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:51:10: TRANSITION_VAR
            {
            dbg.location(51,10);
            TRANSITION_VAR27=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_restriction213); 
            TRANSITION_VAR27_tree = (CommonTree)adaptor.create(TRANSITION_VAR27);
            adaptor.addChild(root_0, TRANSITION_VAR27_tree);


            }

            dbg.location(51,26);
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:51:26: ( ',' TRANSITION_VAR )*
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:51:27: ',' TRANSITION_VAR
            	    {
            	    dbg.location(51,27);
            	    char_literal28=(Token)match(input,17,FOLLOW_17_in_restriction217); 
            	    char_literal28_tree = (CommonTree)adaptor.create(char_literal28);
            	    adaptor.addChild(root_0, char_literal28_tree);

            	    dbg.location(51,31);
            	    TRANSITION_VAR29=(Token)match(input,TRANSITION_VAR,FOLLOW_TRANSITION_VAR_in_restriction219); 
            	    TRANSITION_VAR29_tree = (CommonTree)adaptor.create(TRANSITION_VAR29);
            	    adaptor.addChild(root_0, TRANSITION_VAR29_tree);


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);
            } finally {dbg.exitSubRule(3);}

            dbg.location(51,48);
            char_literal30=(Token)match(input,20,FOLLOW_20_in_restriction223); 
            char_literal30_tree = (CommonTree)adaptor.create(char_literal30);
            adaptor.addChild(root_0, char_literal30_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        dbg.location(52, 2);

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


 

    public static final BitSet FOLLOW_PROCESS_VAR_in_process_def64 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_process_def66 = new BitSet(new long[]{0x0000000000089700L});
    public static final BitSet FOLLOW_process_in_process_def68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROCESS_VAR_in_process91 = new BitSet(new long[]{0x0000000000089700L});
    public static final BitSet FOLLOW_process_in_process93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parentheses_in_process98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_transition_in_process103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_renaming_in_process108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_restriction_in_process113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_process118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parentheses132 = new BitSet(new long[]{0x0000000000089700L});
    public static final BitSet FOLLOW_process_in_parentheses134 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parentheses136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_transition150 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_transition152 = new BitSet(new long[]{0x0000000000089700L});
    public static final BitSet FOLLOW_process_in_transition154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_renaming178 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_renaming181 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_renaming183 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_renaming185 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_renaming189 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_renaming191 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_renaming193 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_renaming195 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_renaming199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_restriction210 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_restriction213 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_restriction217 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_TRANSITION_VAR_in_restriction219 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_20_in_restriction223 = new BitSet(new long[]{0x0000000000000002L});

}
// $ANTLR 3.3 Nov 30, 2010 12:45:30 /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g 2011-03-23 17:38:56

	package ii.edu.mk.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class Ccs2Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DEF", "ADD", "SYNC", "RESTRICT", "RENAME", "RENAME_SINGLE", "PROCESS", "TRANSITION", "PROCESS_VAR", "TAU", "CO_LABEL", "LABEL", "WS", "'='", "'|'", "'+'", "'('", "')'", "'.'", "'['", "','", "']'", "'/'", "'\\\\{'", "'}'"
    };
    public static final int EOF=-1;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int DEF=4;
    public static final int ADD=5;
    public static final int SYNC=6;
    public static final int RESTRICT=7;
    public static final int RENAME=8;
    public static final int RENAME_SINGLE=9;
    public static final int PROCESS=10;
    public static final int TRANSITION=11;
    public static final int PROCESS_VAR=12;
    public static final int TAU=13;
    public static final int CO_LABEL=14;
    public static final int LABEL=15;
    public static final int WS=16;

    // delegates
    // delegators


        public Ccs2Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public Ccs2Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return Ccs2Parser.tokenNames; }
    public String getGrammarFileName() { return "/home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g"; }



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
    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:51:1: expr : (var= PROCESS_VAR '=' proc= sync EOF -> ^( DEF $var $proc) | sync EOF );
    public final Ccs2Parser.expr_return expr() throws RecognitionException {
        Ccs2Parser.expr_return retval = new Ccs2Parser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token var=null;
        Token char_literal1=null;
        Token EOF2=null;
        Token EOF4=null;
        Ccs2Parser.sync_return proc = null;

        Ccs2Parser.sync_return sync3 = null;


        CommonTree var_tree=null;
        CommonTree char_literal1_tree=null;
        CommonTree EOF2_tree=null;
        CommonTree EOF4_tree=null;
        RewriteRuleTokenStream stream_PROCESS_VAR=new RewriteRuleTokenStream(adaptor,"token PROCESS_VAR");
        RewriteRuleTokenStream stream_17=new RewriteRuleTokenStream(adaptor,"token 17");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_sync=new RewriteRuleSubtreeStream(adaptor,"rule sync");
        try {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:52:2: (var= PROCESS_VAR '=' proc= sync EOF -> ^( DEF $var $proc) | sync EOF )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==PROCESS_VAR) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==17) ) {
                    alt1=1;
                }
                else if ( (LA1_1==EOF||(LA1_1>=18 && LA1_1<=19)||LA1_1==23||LA1_1==27) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA1_0>=TAU && LA1_0<=LABEL)||LA1_0==20) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:52:4: var= PROCESS_VAR '=' proc= sync EOF
                    {
                    var=(Token)match(input,PROCESS_VAR,FOLLOW_PROCESS_VAR_in_expr99);  
                    stream_PROCESS_VAR.add(var);

                    char_literal1=(Token)match(input,17,FOLLOW_17_in_expr101);  
                    stream_17.add(char_literal1);

                    pushFollow(FOLLOW_sync_in_expr105);
                    proc=sync();

                    state._fsp--;

                    stream_sync.add(proc.getTree());
                    EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_expr107);  
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
                    // 52:39: -> ^( DEF $var $proc)
                    {
                        // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:52:42: ^( DEF $var $proc)
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
                    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:53:4: sync EOF
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_sync_in_expr125);
                    sync3=sync();

                    state._fsp--;

                    adaptor.addChild(root_0, sync3.getTree());
                    EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_expr127); 

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

    public static class sync_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sync"
    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:56:1: sync : plus ( '|' p= plus )* ;
    public final Ccs2Parser.sync_return sync() throws RecognitionException {
        Ccs2Parser.sync_return retval = new Ccs2Parser.sync_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal6=null;
        Ccs2Parser.plus_return p = null;

        Ccs2Parser.plus_return plus5 = null;


        CommonTree char_literal6_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:56:6: ( plus ( '|' p= plus )* )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:56:8: plus ( '|' p= plus )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_plus_in_sync140);
            plus5=plus();

            state._fsp--;

            adaptor.addChild(root_0, plus5.getTree());
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:56:13: ( '|' p= plus )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==18) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:56:14: '|' p= plus
            	    {
            	    char_literal6=(Token)match(input,18,FOLLOW_18_in_sync143); 
            	    char_literal6_tree = (CommonTree)adaptor.create(char_literal6);
            	    root_0 = (CommonTree)adaptor.becomeRoot(char_literal6_tree, root_0);

            	    pushFollow(FOLLOW_plus_in_sync148);
            	    p=plus();

            	    state._fsp--;

            	    adaptor.addChild(root_0, p.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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

    public static class plus_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "plus"
    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:58:1: plus : start ( '+' start )* ;
    public final Ccs2Parser.plus_return plus() throws RecognitionException {
        Ccs2Parser.plus_return retval = new Ccs2Parser.plus_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal8=null;
        Ccs2Parser.start_return start7 = null;

        Ccs2Parser.start_return start9 = null;


        CommonTree char_literal8_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:58:6: ( start ( '+' start )* )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:58:8: start ( '+' start )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_start_in_plus159);
            start7=start();

            state._fsp--;

            adaptor.addChild(root_0, start7.getTree());
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:58:14: ( '+' start )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:58:15: '+' start
            	    {
            	    char_literal8=(Token)match(input,19,FOLLOW_19_in_plus162); 
            	    char_literal8_tree = (CommonTree)adaptor.create(char_literal8);
            	    root_0 = (CommonTree)adaptor.becomeRoot(char_literal8_tree, root_0);

            	    pushFollow(FOLLOW_start_in_plus165);
            	    start9=start();

            	    state._fsp--;

            	    adaptor.addChild(root_0, start9.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


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

    public static class start_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "start"
    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:60:1: start : ( trans | ( '(' s= sync ')' | p= process ) (rest= restriction | ren= renaming )? );
    public final Ccs2Parser.start_return start() throws RecognitionException {
        Ccs2Parser.start_return retval = new Ccs2Parser.start_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal11=null;
        Token char_literal12=null;
        Ccs2Parser.sync_return s = null;

        Ccs2Parser.process_return p = null;

        Ccs2Parser.restriction_return rest = null;

        Ccs2Parser.renaming_return ren = null;

        Ccs2Parser.trans_return trans10 = null;


        CommonTree char_literal11_tree=null;
        CommonTree char_literal12_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:60:8: ( trans | ( '(' s= sync ')' | p= process ) (rest= restriction | ren= renaming )? )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=TAU && LA6_0<=LABEL)) ) {
                alt6=1;
            }
            else if ( (LA6_0==PROCESS_VAR||LA6_0==20) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:60:11: trans
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_trans_in_start179);
                    trans10=trans();

                    state._fsp--;

                    adaptor.addChild(root_0, trans10.getTree());

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:61:6: ( '(' s= sync ')' | p= process ) (rest= restriction | ren= renaming )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:61:6: ( '(' s= sync ')' | p= process )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==20) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==PROCESS_VAR) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:61:7: '(' s= sync ')'
                            {
                            char_literal11=(Token)match(input,20,FOLLOW_20_in_start187); 
                            pushFollow(FOLLOW_sync_in_start192);
                            s=sync();

                            state._fsp--;

                            adaptor.addChild(root_0, s.getTree());
                            char_literal12=(Token)match(input,21,FOLLOW_21_in_start194); 

                            }
                            break;
                        case 2 :
                            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:61:26: p= process
                            {
                            pushFollow(FOLLOW_process_in_start201);
                            p=process();

                            state._fsp--;

                            adaptor.addChild(root_0, p.getTree());

                            }
                            break;

                    }

                    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:61:37: (rest= restriction | ren= renaming )?
                    int alt5=3;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==27) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==23) ) {
                        alt5=2;
                    }
                    switch (alt5) {
                        case 1 :
                            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:61:38: rest= restriction
                            {
                            pushFollow(FOLLOW_restriction_in_start207);
                            rest=restriction();

                            state._fsp--;

                            adaptor.addChild(root_0, rest.getTree());

                            }
                            break;
                        case 2 :
                            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:61:57: ren= renaming
                            {
                            pushFollow(FOLLOW_renaming_in_start213);
                            ren=renaming();

                            state._fsp--;

                            adaptor.addChild(root_0, ren.getTree());

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

    public static class trans_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "trans"
    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:64:1: trans : t+= trans_var ( '.' (t+= trans_var | t+= process | t+= sync ) )+ -> ^( TRANSITION ( $t)+ ) ;
    public final Ccs2Parser.trans_return trans() throws RecognitionException {
        Ccs2Parser.trans_return retval = new Ccs2Parser.trans_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal13=null;
        List list_t=null;
        RuleReturnScope t = null;
        CommonTree char_literal13_tree=null;
        RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
        RewriteRuleSubtreeStream stream_trans_var=new RewriteRuleSubtreeStream(adaptor,"rule trans_var");
        RewriteRuleSubtreeStream stream_process=new RewriteRuleSubtreeStream(adaptor,"rule process");
        RewriteRuleSubtreeStream stream_sync=new RewriteRuleSubtreeStream(adaptor,"rule sync");
        try {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:64:7: (t+= trans_var ( '.' (t+= trans_var | t+= process | t+= sync ) )+ -> ^( TRANSITION ( $t)+ ) )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:64:9: t+= trans_var ( '.' (t+= trans_var | t+= process | t+= sync ) )+
            {
            pushFollow(FOLLOW_trans_var_in_trans228);
            t=trans_var();

            state._fsp--;

            stream_trans_var.add(t.getTree());
            if (list_t==null) list_t=new ArrayList();
            list_t.add(t.getTree());

            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:64:22: ( '.' (t+= trans_var | t+= process | t+= sync ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:64:23: '.' (t+= trans_var | t+= process | t+= sync )
            	    {
            	    char_literal13=(Token)match(input,22,FOLLOW_22_in_trans231);  
            	    stream_22.add(char_literal13);

            	    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:64:27: (t+= trans_var | t+= process | t+= sync )
            	    int alt7=3;
            	    switch ( input.LA(1) ) {
            	    case TAU:
            	    case CO_LABEL:
            	    case LABEL:
            	        {
            	        alt7=1;
            	        }
            	        break;
            	    case PROCESS_VAR:
            	        {
            	        alt7=2;
            	        }
            	        break;
            	    case 20:
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
            	            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:64:28: t+= trans_var
            	            {
            	            pushFollow(FOLLOW_trans_var_in_trans236);
            	            t=trans_var();

            	            state._fsp--;

            	            stream_trans_var.add(t.getTree());
            	            if (list_t==null) list_t=new ArrayList();
            	            list_t.add(t.getTree());


            	            }
            	            break;
            	        case 2 :
            	            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:64:43: t+= process
            	            {
            	            pushFollow(FOLLOW_process_in_trans242);
            	            t=process();

            	            state._fsp--;

            	            stream_process.add(t.getTree());
            	            if (list_t==null) list_t=new ArrayList();
            	            list_t.add(t.getTree());


            	            }
            	            break;
            	        case 3 :
            	            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:64:56: t+= sync
            	            {
            	            pushFollow(FOLLOW_sync_in_trans248);
            	            t=sync();

            	            state._fsp--;

            	            stream_sync.add(t.getTree());
            	            if (list_t==null) list_t=new ArrayList();
            	            list_t.add(t.getTree());


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);



            // AST REWRITE
            // elements: t
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: t
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"token t",list_t);
            root_0 = (CommonTree)adaptor.nil();
            // 64:67: -> ^( TRANSITION ( $t)+ )
            {
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:64:70: ^( TRANSITION ( $t)+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TRANSITION, "TRANSITION"), root_1);

                if ( !(stream_t.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_t.hasNext() ) {
                    adaptor.addChild(root_1, stream_t.nextTree());

                }
                stream_t.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
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

    public static class process_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "process"
    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:66:1: process : PROCESS_VAR ;
    public final Ccs2Parser.process_return process() throws RecognitionException {
        Ccs2Parser.process_return retval = new Ccs2Parser.process_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PROCESS_VAR14=null;

        CommonTree PROCESS_VAR14_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:66:9: ( PROCESS_VAR )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:66:11: PROCESS_VAR
            {
            root_0 = (CommonTree)adaptor.nil();

            PROCESS_VAR14=(Token)match(input,PROCESS_VAR,FOLLOW_PROCESS_VAR_in_process269); 
            PROCESS_VAR14_tree = (CommonTree)adaptor.create(PROCESS_VAR14);
            adaptor.addChild(root_0, PROCESS_VAR14_tree);


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
    // $ANTLR end "process"

    public static class trans_var_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "trans_var"
    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:68:1: trans_var : action ;
    public final Ccs2Parser.trans_var_return trans_var() throws RecognitionException {
        Ccs2Parser.trans_var_return retval = new Ccs2Parser.trans_var_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ccs2Parser.action_return action15 = null;



        try {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:69:2: ( action )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:69:4: action
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_action_in_trans_var278);
            action15=action();

            state._fsp--;

            adaptor.addChild(root_0, action15.getTree());

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
    // $ANTLR end "trans_var"

    public static class renaming_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "renaming"
    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:71:1: renaming : '[' r+= ren1 ( ',' r+= ren1 )* ']' -> ^( RENAME ( $r)+ ) ;
    public final Ccs2Parser.renaming_return renaming() throws RecognitionException {
        Ccs2Parser.renaming_return retval = new Ccs2Parser.renaming_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal16=null;
        Token char_literal17=null;
        Token char_literal18=null;
        List list_r=null;
        RuleReturnScope r = null;
        CommonTree char_literal16_tree=null;
        CommonTree char_literal17_tree=null;
        CommonTree char_literal18_tree=null;
        RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
        RewriteRuleTokenStream stream_24=new RewriteRuleTokenStream(adaptor,"token 24");
        RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");
        RewriteRuleSubtreeStream stream_ren1=new RewriteRuleSubtreeStream(adaptor,"rule ren1");
        try {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:72:2: ( '[' r+= ren1 ( ',' r+= ren1 )* ']' -> ^( RENAME ( $r)+ ) )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:72:5: '[' r+= ren1 ( ',' r+= ren1 )* ']'
            {
            char_literal16=(Token)match(input,23,FOLLOW_23_in_renaming289);  
            stream_23.add(char_literal16);

            pushFollow(FOLLOW_ren1_in_renaming293);
            r=ren1();

            state._fsp--;

            stream_ren1.add(r.getTree());
            if (list_r==null) list_r=new ArrayList();
            list_r.add(r.getTree());

            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:72:17: ( ',' r+= ren1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==24) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:72:18: ',' r+= ren1
            	    {
            	    char_literal17=(Token)match(input,24,FOLLOW_24_in_renaming296);  
            	    stream_24.add(char_literal17);

            	    pushFollow(FOLLOW_ren1_in_renaming300);
            	    r=ren1();

            	    state._fsp--;

            	    stream_ren1.add(r.getTree());
            	    if (list_r==null) list_r=new ArrayList();
            	    list_r.add(r.getTree());


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            char_literal18=(Token)match(input,25,FOLLOW_25_in_renaming304);  
            stream_25.add(char_literal18);



            // AST REWRITE
            // elements: r
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: r
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"token r",list_r);
            root_0 = (CommonTree)adaptor.nil();
            // 72:38: -> ^( RENAME ( $r)+ )
            {
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:72:41: ^( RENAME ( $r)+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RENAME, "RENAME"), root_1);

                if ( !(stream_r.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_r.hasNext() ) {
                    adaptor.addChild(root_1, stream_r.nextTree());

                }
                stream_r.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
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

    public static class ren1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ren1"
    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:74:1: ren1 : action '/' action -> ^( RENAME_SINGLE ( action )+ ) ;
    public final Ccs2Parser.ren1_return ren1() throws RecognitionException {
        Ccs2Parser.ren1_return retval = new Ccs2Parser.ren1_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal20=null;
        Ccs2Parser.action_return action19 = null;

        Ccs2Parser.action_return action21 = null;


        CommonTree char_literal20_tree=null;
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        try {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:74:6: ( action '/' action -> ^( RENAME_SINGLE ( action )+ ) )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:74:8: action '/' action
            {
            pushFollow(FOLLOW_action_in_ren1325);
            action19=action();

            state._fsp--;

            stream_action.add(action19.getTree());
            char_literal20=(Token)match(input,26,FOLLOW_26_in_ren1327);  
            stream_26.add(char_literal20);

            pushFollow(FOLLOW_action_in_ren1329);
            action21=action();

            state._fsp--;

            stream_action.add(action21.getTree());


            // AST REWRITE
            // elements: action
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 74:27: -> ^( RENAME_SINGLE ( action )+ )
            {
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:74:30: ^( RENAME_SINGLE ( action )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RENAME_SINGLE, "RENAME_SINGLE"), root_1);

                if ( !(stream_action.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_action.hasNext() ) {
                    adaptor.addChild(root_1, stream_action.nextTree());

                }
                stream_action.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
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
    // $ANTLR end "ren1"

    public static class restriction_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "restriction"
    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:76:1: restriction : '\\\\{' rests+= label_or_colabel ( ',' rests+= label_or_colabel )* '}' -> ^( RESTRICT ( $rests)+ ) ;
    public final Ccs2Parser.restriction_return restriction() throws RecognitionException {
        Ccs2Parser.restriction_return retval = new Ccs2Parser.restriction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal22=null;
        Token char_literal23=null;
        Token char_literal24=null;
        List list_rests=null;
        RuleReturnScope rests = null;
        CommonTree string_literal22_tree=null;
        CommonTree char_literal23_tree=null;
        CommonTree char_literal24_tree=null;
        RewriteRuleTokenStream stream_24=new RewriteRuleTokenStream(adaptor,"token 24");
        RewriteRuleTokenStream stream_27=new RewriteRuleTokenStream(adaptor,"token 27");
        RewriteRuleTokenStream stream_28=new RewriteRuleTokenStream(adaptor,"token 28");
        RewriteRuleSubtreeStream stream_label_or_colabel=new RewriteRuleSubtreeStream(adaptor,"rule label_or_colabel");
        try {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:77:2: ( '\\\\{' rests+= label_or_colabel ( ',' rests+= label_or_colabel )* '}' -> ^( RESTRICT ( $rests)+ ) )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:77:4: '\\\\{' rests+= label_or_colabel ( ',' rests+= label_or_colabel )* '}'
            {
            string_literal22=(Token)match(input,27,FOLLOW_27_in_restriction348);  
            stream_27.add(string_literal22);

            pushFollow(FOLLOW_label_or_colabel_in_restriction352);
            rests=label_or_colabel();

            state._fsp--;

            stream_label_or_colabel.add(rests.getTree());
            if (list_rests==null) list_rests=new ArrayList();
            list_rests.add(rests.getTree());

            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:77:34: ( ',' rests+= label_or_colabel )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==24) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:77:35: ',' rests+= label_or_colabel
            	    {
            	    char_literal23=(Token)match(input,24,FOLLOW_24_in_restriction355);  
            	    stream_24.add(char_literal23);

            	    pushFollow(FOLLOW_label_or_colabel_in_restriction359);
            	    rests=label_or_colabel();

            	    state._fsp--;

            	    stream_label_or_colabel.add(rests.getTree());
            	    if (list_rests==null) list_rests=new ArrayList();
            	    list_rests.add(rests.getTree());


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            char_literal24=(Token)match(input,28,FOLLOW_28_in_restriction363);  
            stream_28.add(char_literal24);



            // AST REWRITE
            // elements: rests
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: rests
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_rests=new RewriteRuleSubtreeStream(adaptor,"token rests",list_rests);
            root_0 = (CommonTree)adaptor.nil();
            // 77:69: -> ^( RESTRICT ( $rests)+ )
            {
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:77:72: ^( RESTRICT ( $rests)+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RESTRICT, "RESTRICT"), root_1);

                if ( !(stream_rests.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_rests.hasNext() ) {
                    adaptor.addChild(root_1, stream_rests.nextTree());

                }
                stream_rests.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
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

    public static class action_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "action"
    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:80:1: action : ( TAU | CO_LABEL | LABEL );
    public final Ccs2Parser.action_return action() throws RecognitionException {
        Ccs2Parser.action_return retval = new Ccs2Parser.action_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set25=null;

        CommonTree set25_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:81:2: ( TAU | CO_LABEL | LABEL )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set25=(Token)input.LT(1);
            if ( (input.LA(1)>=TAU && input.LA(1)<=LABEL) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set25));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "action"

    public static class label_or_colabel_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "label_or_colabel"
    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:84:1: label_or_colabel : ( LABEL | CO_LABEL );
    public final Ccs2Parser.label_or_colabel_return label_or_colabel() throws RecognitionException {
        Ccs2Parser.label_or_colabel_return retval = new Ccs2Parser.label_or_colabel_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set26=null;

        CommonTree set26_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:85:2: ( LABEL | CO_LABEL )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set26=(Token)input.LT(1);
            if ( (input.LA(1)>=CO_LABEL && input.LA(1)<=LABEL) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set26));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "label_or_colabel"

    // Delegated rules


 

    public static final BitSet FOLLOW_PROCESS_VAR_in_expr99 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_expr101 = new BitSet(new long[]{0x000000000010F000L});
    public static final BitSet FOLLOW_sync_in_expr105 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expr107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sync_in_expr125 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expr127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_sync140 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_sync143 = new BitSet(new long[]{0x000000000010F000L});
    public static final BitSet FOLLOW_plus_in_sync148 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_start_in_plus159 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_plus162 = new BitSet(new long[]{0x000000000010F000L});
    public static final BitSet FOLLOW_start_in_plus165 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_trans_in_start179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_start187 = new BitSet(new long[]{0x000000000010F000L});
    public static final BitSet FOLLOW_sync_in_start192 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_start194 = new BitSet(new long[]{0x0000000008800002L});
    public static final BitSet FOLLOW_process_in_start201 = new BitSet(new long[]{0x0000000008800002L});
    public static final BitSet FOLLOW_restriction_in_start207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_renaming_in_start213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_trans_var_in_trans228 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_trans231 = new BitSet(new long[]{0x000000000010F000L});
    public static final BitSet FOLLOW_trans_var_in_trans236 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_process_in_trans242 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_sync_in_trans248 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_PROCESS_VAR_in_process269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_trans_var278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_renaming289 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_ren1_in_renaming293 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_renaming296 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_ren1_in_renaming300 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_25_in_renaming304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_ren1325 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ren1327 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_action_in_ren1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_restriction348 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_label_or_colabel_in_restriction352 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_24_in_restriction355 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_label_or_colabel_in_restriction359 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_28_in_restriction363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_action0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_label_or_colabel0 = new BitSet(new long[]{0x0000000000000002L});

}
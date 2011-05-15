// $ANTLR 3.3 Nov 30, 2010 12:45:30 /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g 2011-05-15 18:51:18

	package ii.edu.mk.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class Ccs2Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DEF", "RESTRICT", "RESTRICT_LABELS", "RENAME", "RENAME_CLAUSE", "RENAME_SINGLE", "TRANSITION", "PROCESS", "WS", "TAU", "CO_LABEL", "LABEL", "'='", "'|'", "'+'", "'('", "')'", "'.'", "'['", "','", "']'", "'/'", "'\\\\{'", "'}'"
    };
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int SYNC=17;
    public static final int ADD=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int DEF=4;
    public static final int RESTRICT=5;
    public static final int RESTRICT_LABELS=6;
    public static final int RENAME=7;
    public static final int RENAME_CLAUSE=8;
    public static final int RENAME_SINGLE=9;
    public static final int TRANSITION=10;
    public static final int PROCESS=11;
    public static final int WS=12;
    public static final int TAU=13;
    public static final int CO_LABEL=14;
    public static final int LABEL=15;

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
    public String getGrammarFileName() { return "/home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g"; }



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
    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:63:1: expr : (var= PROCESS '=' proc= sync EOF -> ^( DEF $var $proc) | sync EOF );
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
        RewriteRuleTokenStream stream_PROCESS=new RewriteRuleTokenStream(adaptor,"token PROCESS");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_16=new RewriteRuleTokenStream(adaptor,"token 16");
        RewriteRuleSubtreeStream stream_sync=new RewriteRuleSubtreeStream(adaptor,"rule sync");
        try {
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:64:2: (var= PROCESS '=' proc= sync EOF -> ^( DEF $var $proc) | sync EOF )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==PROCESS) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==16) ) {
                    alt1=1;
                }
                else if ( (LA1_1==EOF||LA1_1==WS||(LA1_1>=17 && LA1_1<=18)||LA1_1==22||LA1_1==26) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA1_0>=TAU && LA1_0<=LABEL)||LA1_0==19) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:64:4: var= PROCESS '=' proc= sync EOF
                    {
                    var=(Token)match(input,PROCESS,FOLLOW_PROCESS_in_expr100);  
                    stream_PROCESS.add(var);

                    char_literal1=(Token)match(input,16,FOLLOW_16_in_expr102);  
                    stream_16.add(char_literal1);

                    pushFollow(FOLLOW_sync_in_expr106);
                    proc=sync();

                    state._fsp--;

                    stream_sync.add(proc.getTree());
                    EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_expr108);  
                    stream_EOF.add(EOF2);



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
                    // 64:35: -> ^( DEF $var $proc)
                    {
                        // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:64:38: ^( DEF $var $proc)
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
                    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:65:4: sync EOF
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_sync_in_expr126);
                    sync3=sync();

                    state._fsp--;

                    adaptor.addChild(root_0, sync3.getTree());
                    EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_expr128); 

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
    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:68:1: sync : plus ( '|' p= plus )* ;
    public final Ccs2Parser.sync_return sync() throws RecognitionException {
        Ccs2Parser.sync_return retval = new Ccs2Parser.sync_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal6=null;
        Ccs2Parser.plus_return p = null;

        Ccs2Parser.plus_return plus5 = null;


        CommonTree char_literal6_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:68:6: ( plus ( '|' p= plus )* )
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:68:8: plus ( '|' p= plus )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_plus_in_sync139);
            plus5=plus();

            state._fsp--;

            adaptor.addChild(root_0, plus5.getTree());
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:68:13: ( '|' p= plus )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:68:14: '|' p= plus
            	    {
            	    char_literal6=(Token)match(input,17,FOLLOW_17_in_sync142); 
            	    char_literal6_tree = (CommonTree)adaptor.create(char_literal6);
            	    root_0 = (CommonTree)adaptor.becomeRoot(char_literal6_tree, root_0);

            	    pushFollow(FOLLOW_plus_in_sync147);
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
    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:70:1: plus : start ( '+' start )* ;
    public final Ccs2Parser.plus_return plus() throws RecognitionException {
        Ccs2Parser.plus_return retval = new Ccs2Parser.plus_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal8=null;
        Ccs2Parser.start_return start7 = null;

        Ccs2Parser.start_return start9 = null;


        CommonTree char_literal8_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:70:6: ( start ( '+' start )* )
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:70:8: start ( '+' start )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_start_in_plus157);
            start7=start();

            state._fsp--;

            adaptor.addChild(root_0, start7.getTree());
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:70:14: ( '+' start )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==18) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:70:15: '+' start
            	    {
            	    char_literal8=(Token)match(input,18,FOLLOW_18_in_plus160); 
            	    char_literal8_tree = (CommonTree)adaptor.create(char_literal8);
            	    root_0 = (CommonTree)adaptor.becomeRoot(char_literal8_tree, root_0);

            	    pushFollow(FOLLOW_start_in_plus163);
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
    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:72:1: start : ( trans | ( '(' s= sync ')' | p= process ) (rest= restriction -> ^( RESTRICT ( $s)? ( $p)? $rest) | ren= renaming -> ^( RENAME ( $s)? ( $p)? $ren) | ( WS )* -> ( $s)? ( $p)? ) );
    public final Ccs2Parser.start_return start() throws RecognitionException {
        Ccs2Parser.start_return retval = new Ccs2Parser.start_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal11=null;
        Token char_literal12=null;
        Token WS13=null;
        Ccs2Parser.sync_return s = null;

        Ccs2Parser.process_return p = null;

        Ccs2Parser.restriction_return rest = null;

        Ccs2Parser.renaming_return ren = null;

        Ccs2Parser.trans_return trans10 = null;


        CommonTree char_literal11_tree=null;
        CommonTree char_literal12_tree=null;
        CommonTree WS13_tree=null;
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_19=new RewriteRuleTokenStream(adaptor,"token 19");
        RewriteRuleSubtreeStream stream_process=new RewriteRuleSubtreeStream(adaptor,"rule process");
        RewriteRuleSubtreeStream stream_sync=new RewriteRuleSubtreeStream(adaptor,"rule sync");
        RewriteRuleSubtreeStream stream_restriction=new RewriteRuleSubtreeStream(adaptor,"rule restriction");
        RewriteRuleSubtreeStream stream_renaming=new RewriteRuleSubtreeStream(adaptor,"rule renaming");
        try {
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:72:8: ( trans | ( '(' s= sync ')' | p= process ) (rest= restriction -> ^( RESTRICT ( $s)? ( $p)? $rest) | ren= renaming -> ^( RENAME ( $s)? ( $p)? $ren) | ( WS )* -> ( $s)? ( $p)? ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=TAU && LA7_0<=LABEL)) ) {
                alt7=1;
            }
            else if ( (LA7_0==PROCESS||LA7_0==19) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:72:11: trans
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_trans_in_start176);
                    trans10=trans();

                    state._fsp--;

                    adaptor.addChild(root_0, trans10.getTree());

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:73:4: ( '(' s= sync ')' | p= process ) (rest= restriction -> ^( RESTRICT ( $s)? ( $p)? $rest) | ren= renaming -> ^( RENAME ( $s)? ( $p)? $ren) | ( WS )* -> ( $s)? ( $p)? )
                    {
                    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:73:4: ( '(' s= sync ')' | p= process )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==19) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==PROCESS) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:73:5: '(' s= sync ')'
                            {
                            char_literal11=(Token)match(input,19,FOLLOW_19_in_start182);  
                            stream_19.add(char_literal11);

                            pushFollow(FOLLOW_sync_in_start186);
                            s=sync();

                            state._fsp--;

                            stream_sync.add(s.getTree());
                            char_literal12=(Token)match(input,20,FOLLOW_20_in_start188);  
                            stream_20.add(char_literal12);


                            }
                            break;
                        case 2 :
                            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:73:22: p= process
                            {
                            pushFollow(FOLLOW_process_in_start194);
                            p=process();

                            state._fsp--;

                            stream_process.add(p.getTree());

                            }
                            break;

                    }

                    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:73:33: (rest= restriction -> ^( RESTRICT ( $s)? ( $p)? $rest) | ren= renaming -> ^( RENAME ( $s)? ( $p)? $ren) | ( WS )* -> ( $s)? ( $p)? )
                    int alt6=3;
                    switch ( input.LA(1) ) {
                    case 26:
                        {
                        alt6=1;
                        }
                        break;
                    case 22:
                        {
                        alt6=2;
                        }
                        break;
                    case EOF:
                    case WS:
                    case 17:
                    case 18:
                    case 20:
                        {
                        alt6=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }

                    switch (alt6) {
                        case 1 :
                            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:73:35: rest= restriction
                            {
                            pushFollow(FOLLOW_restriction_in_start201);
                            rest=restriction();

                            state._fsp--;

                            stream_restriction.add(rest.getTree());


                            // AST REWRITE
                            // elements: s, rest, p
                            // token labels: 
                            // rule labels: retval, s, p, rest
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                            RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.tree:null);
                            RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.tree:null);
                            RewriteRuleSubtreeStream stream_rest=new RewriteRuleSubtreeStream(adaptor,"rule rest",rest!=null?rest.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 73:53: -> ^( RESTRICT ( $s)? ( $p)? $rest)
                            {
                                // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:73:56: ^( RESTRICT ( $s)? ( $p)? $rest)
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RESTRICT, "RESTRICT"), root_1);

                                // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:73:67: ( $s)?
                                if ( stream_s.hasNext() ) {
                                    adaptor.addChild(root_1, stream_s.nextTree());

                                }
                                stream_s.reset();
                                // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:73:71: ( $p)?
                                if ( stream_p.hasNext() ) {
                                    adaptor.addChild(root_1, stream_p.nextTree());

                                }
                                stream_p.reset();
                                adaptor.addChild(root_1, stream_rest.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;
                            }
                            break;
                        case 2 :
                            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:74:12: ren= renaming
                            {
                            pushFollow(FOLLOW_renaming_in_start235);
                            ren=renaming();

                            state._fsp--;

                            stream_renaming.add(ren.getTree());


                            // AST REWRITE
                            // elements: s, p, ren
                            // token labels: 
                            // rule labels: retval, s, p, ren
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                            RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.tree:null);
                            RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.tree:null);
                            RewriteRuleSubtreeStream stream_ren=new RewriteRuleSubtreeStream(adaptor,"rule ren",ren!=null?ren.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 74:27: -> ^( RENAME ( $s)? ( $p)? $ren)
                            {
                                // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:74:30: ^( RENAME ( $s)? ( $p)? $ren)
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RENAME, "RENAME"), root_1);

                                // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:74:39: ( $s)?
                                if ( stream_s.hasNext() ) {
                                    adaptor.addChild(root_1, stream_s.nextTree());

                                }
                                stream_s.reset();
                                // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:74:43: ( $p)?
                                if ( stream_p.hasNext() ) {
                                    adaptor.addChild(root_1, stream_p.nextTree());

                                }
                                stream_p.reset();
                                adaptor.addChild(root_1, stream_ren.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;
                            }
                            break;
                        case 3 :
                            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:75:11: ( WS )*
                            {
                            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:75:11: ( WS )*
                            loop5:
                            do {
                                int alt5=2;
                                int LA5_0 = input.LA(1);

                                if ( (LA5_0==WS) ) {
                                    alt5=1;
                                }


                                switch (alt5) {
                            	case 1 :
                            	    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:75:11: WS
                            	    {
                            	    WS13=(Token)match(input,WS,FOLLOW_WS_in_start266);  
                            	    stream_WS.add(WS13);


                            	    }
                            	    break;

                            	default :
                            	    break loop5;
                                }
                            } while (true);



                            // AST REWRITE
                            // elements: p, s
                            // token labels: 
                            // rule labels: retval, s, p
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                            RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.tree:null);
                            RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 75:18: -> ( $s)? ( $p)?
                            {
                                // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:75:21: ( $s)?
                                if ( stream_s.hasNext() ) {
                                    adaptor.addChild(root_0, stream_s.nextTree());

                                }
                                stream_s.reset();
                                // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:75:25: ( $p)?
                                if ( stream_p.hasNext() ) {
                                    adaptor.addChild(root_0, stream_p.nextTree());

                                }
                                stream_p.reset();

                            }

                            retval.tree = root_0;
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
    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:79:1: trans : t= trans_var '.' (p= process | s= sync ) -> ^( TRANSITION $t ( $p)? ( $s)? ) ;
    public final Ccs2Parser.trans_return trans() throws RecognitionException {
        Ccs2Parser.trans_return retval = new Ccs2Parser.trans_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal14=null;
        Ccs2Parser.trans_var_return t = null;

        Ccs2Parser.process_return p = null;

        Ccs2Parser.sync_return s = null;


        CommonTree char_literal14_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleSubtreeStream stream_trans_var=new RewriteRuleSubtreeStream(adaptor,"rule trans_var");
        RewriteRuleSubtreeStream stream_process=new RewriteRuleSubtreeStream(adaptor,"rule process");
        RewriteRuleSubtreeStream stream_sync=new RewriteRuleSubtreeStream(adaptor,"rule sync");
        try {
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:79:7: (t= trans_var '.' (p= process | s= sync ) -> ^( TRANSITION $t ( $p)? ( $s)? ) )
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:79:9: t= trans_var '.' (p= process | s= sync )
            {
            pushFollow(FOLLOW_trans_var_in_trans302);
            t=trans_var();

            state._fsp--;

            stream_trans_var.add(t.getTree());
            char_literal14=(Token)match(input,21,FOLLOW_21_in_trans304);  
            stream_21.add(char_literal14);

            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:79:25: (p= process | s= sync )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==PROCESS) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=TAU && LA8_0<=LABEL)||LA8_0==19) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:79:26: p= process
                    {
                    pushFollow(FOLLOW_process_in_trans309);
                    p=process();

                    state._fsp--;

                    stream_process.add(p.getTree());

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:79:38: s= sync
                    {
                    pushFollow(FOLLOW_sync_in_trans315);
                    s=sync();

                    state._fsp--;

                    stream_sync.add(s.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: t, s, p
            // token labels: 
            // rule labels: retval, t, s, p
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.tree:null);
            RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.tree:null);
            RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 79:46: -> ^( TRANSITION $t ( $p)? ( $s)? )
            {
                // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:79:49: ^( TRANSITION $t ( $p)? ( $s)? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TRANSITION, "TRANSITION"), root_1);

                adaptor.addChild(root_1, stream_t.nextTree());
                // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:79:65: ( $p)?
                if ( stream_p.hasNext() ) {
                    adaptor.addChild(root_1, stream_p.nextTree());

                }
                stream_p.reset();
                // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:79:69: ( $s)?
                if ( stream_s.hasNext() ) {
                    adaptor.addChild(root_1, stream_s.nextTree());

                }
                stream_s.reset();

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
    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:82:1: process : PROCESS ;
    public final Ccs2Parser.process_return process() throws RecognitionException {
        Ccs2Parser.process_return retval = new Ccs2Parser.process_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PROCESS15=null;

        CommonTree PROCESS15_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:82:9: ( PROCESS )
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:82:11: PROCESS
            {
            root_0 = (CommonTree)adaptor.nil();

            PROCESS15=(Token)match(input,PROCESS,FOLLOW_PROCESS_in_process344); 
            PROCESS15_tree = (CommonTree)adaptor.create(PROCESS15);
            adaptor.addChild(root_0, PROCESS15_tree);


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
    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:84:1: trans_var : action ;
    public final Ccs2Parser.trans_var_return trans_var() throws RecognitionException {
        Ccs2Parser.trans_var_return retval = new Ccs2Parser.trans_var_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Ccs2Parser.action_return action16 = null;



        try {
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:85:2: ( action )
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:85:4: action
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_action_in_trans_var353);
            action16=action();

            state._fsp--;

            adaptor.addChild(root_0, action16.getTree());

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
    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:87:1: renaming : '[' r+= ren1 ( ',' r+= ren1 )* ']' -> ^( RENAME_CLAUSE ( $r)+ ) ;
    public final Ccs2Parser.renaming_return renaming() throws RecognitionException {
        Ccs2Parser.renaming_return retval = new Ccs2Parser.renaming_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal17=null;
        Token char_literal18=null;
        Token char_literal19=null;
        List list_r=null;
        RuleReturnScope r = null;
        CommonTree char_literal17_tree=null;
        CommonTree char_literal18_tree=null;
        CommonTree char_literal19_tree=null;
        RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
        RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
        RewriteRuleTokenStream stream_24=new RewriteRuleTokenStream(adaptor,"token 24");
        RewriteRuleSubtreeStream stream_ren1=new RewriteRuleSubtreeStream(adaptor,"rule ren1");
        try {
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:88:2: ( '[' r+= ren1 ( ',' r+= ren1 )* ']' -> ^( RENAME_CLAUSE ( $r)+ ) )
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:88:5: '[' r+= ren1 ( ',' r+= ren1 )* ']'
            {
            char_literal17=(Token)match(input,22,FOLLOW_22_in_renaming364);  
            stream_22.add(char_literal17);

            pushFollow(FOLLOW_ren1_in_renaming368);
            r=ren1();

            state._fsp--;

            stream_ren1.add(r.getTree());
            if (list_r==null) list_r=new ArrayList();
            list_r.add(r.getTree());

            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:88:17: ( ',' r+= ren1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:88:18: ',' r+= ren1
            	    {
            	    char_literal18=(Token)match(input,23,FOLLOW_23_in_renaming371);  
            	    stream_23.add(char_literal18);

            	    pushFollow(FOLLOW_ren1_in_renaming375);
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

            char_literal19=(Token)match(input,24,FOLLOW_24_in_renaming379);  
            stream_24.add(char_literal19);



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
            // 88:38: -> ^( RENAME_CLAUSE ( $r)+ )
            {
                // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:88:41: ^( RENAME_CLAUSE ( $r)+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RENAME_CLAUSE, "RENAME_CLAUSE"), root_1);

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
    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:90:1: ren1 : action '/' action -> ^( RENAME_SINGLE ( action )+ ) ;
    public final Ccs2Parser.ren1_return ren1() throws RecognitionException {
        Ccs2Parser.ren1_return retval = new Ccs2Parser.ren1_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal21=null;
        Ccs2Parser.action_return action20 = null;

        Ccs2Parser.action_return action22 = null;


        CommonTree char_literal21_tree=null;
        RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");
        RewriteRuleSubtreeStream stream_action=new RewriteRuleSubtreeStream(adaptor,"rule action");
        try {
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:90:6: ( action '/' action -> ^( RENAME_SINGLE ( action )+ ) )
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:90:8: action '/' action
            {
            pushFollow(FOLLOW_action_in_ren1400);
            action20=action();

            state._fsp--;

            stream_action.add(action20.getTree());
            char_literal21=(Token)match(input,25,FOLLOW_25_in_ren1402);  
            stream_25.add(char_literal21);

            pushFollow(FOLLOW_action_in_ren1404);
            action22=action();

            state._fsp--;

            stream_action.add(action22.getTree());


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
            // 90:27: -> ^( RENAME_SINGLE ( action )+ )
            {
                // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:90:30: ^( RENAME_SINGLE ( action )+ )
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
    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:92:1: restriction : '\\\\{' rests+= label_or_colabel ( ',' rests+= label_or_colabel )* '}' -> ^( RESTRICT_LABELS ( $rests)+ ) ;
    public final Ccs2Parser.restriction_return restriction() throws RecognitionException {
        Ccs2Parser.restriction_return retval = new Ccs2Parser.restriction_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal23=null;
        Token char_literal24=null;
        Token char_literal25=null;
        List list_rests=null;
        RuleReturnScope rests = null;
        CommonTree string_literal23_tree=null;
        CommonTree char_literal24_tree=null;
        CommonTree char_literal25_tree=null;
        RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleTokenStream stream_27=new RewriteRuleTokenStream(adaptor,"token 27");
        RewriteRuleSubtreeStream stream_label_or_colabel=new RewriteRuleSubtreeStream(adaptor,"rule label_or_colabel");
        try {
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:93:2: ( '\\\\{' rests+= label_or_colabel ( ',' rests+= label_or_colabel )* '}' -> ^( RESTRICT_LABELS ( $rests)+ ) )
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:93:4: '\\\\{' rests+= label_or_colabel ( ',' rests+= label_or_colabel )* '}'
            {
            string_literal23=(Token)match(input,26,FOLLOW_26_in_restriction423);  
            stream_26.add(string_literal23);

            pushFollow(FOLLOW_label_or_colabel_in_restriction427);
            rests=label_or_colabel();

            state._fsp--;

            stream_label_or_colabel.add(rests.getTree());
            if (list_rests==null) list_rests=new ArrayList();
            list_rests.add(rests.getTree());

            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:93:34: ( ',' rests+= label_or_colabel )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==23) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:93:35: ',' rests+= label_or_colabel
            	    {
            	    char_literal24=(Token)match(input,23,FOLLOW_23_in_restriction430);  
            	    stream_23.add(char_literal24);

            	    pushFollow(FOLLOW_label_or_colabel_in_restriction434);
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

            char_literal25=(Token)match(input,27,FOLLOW_27_in_restriction438);  
            stream_27.add(char_literal25);



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
            // 93:69: -> ^( RESTRICT_LABELS ( $rests)+ )
            {
                // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:93:72: ^( RESTRICT_LABELS ( $rests)+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(RESTRICT_LABELS, "RESTRICT_LABELS"), root_1);

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
    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:96:1: action : ( TAU | CO_LABEL | LABEL );
    public final Ccs2Parser.action_return action() throws RecognitionException {
        Ccs2Parser.action_return retval = new Ccs2Parser.action_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set26=null;

        CommonTree set26_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:97:2: ( TAU | CO_LABEL | LABEL )
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set26=(Token)input.LT(1);
            if ( (input.LA(1)>=TAU && input.LA(1)<=LABEL) ) {
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
    // $ANTLR end "action"

    public static class label_or_colabel_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "label_or_colabel"
    // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:100:1: label_or_colabel : ( LABEL | CO_LABEL );
    public final Ccs2Parser.label_or_colabel_return label_or_colabel() throws RecognitionException {
        Ccs2Parser.label_or_colabel_return retval = new Ccs2Parser.label_or_colabel_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set27=null;

        CommonTree set27_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:101:2: ( LABEL | CO_LABEL )
            // /home/dragan/Dragan/workspaces/fax/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set27=(Token)input.LT(1);
            if ( (input.LA(1)>=CO_LABEL && input.LA(1)<=LABEL) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set27));
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


 

    public static final BitSet FOLLOW_PROCESS_in_expr100 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_expr102 = new BitSet(new long[]{0x000000000008E800L});
    public static final BitSet FOLLOW_sync_in_expr106 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expr108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sync_in_expr126 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expr128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_plus_in_sync139 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_sync142 = new BitSet(new long[]{0x000000000008E800L});
    public static final BitSet FOLLOW_plus_in_sync147 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_start_in_plus157 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_plus160 = new BitSet(new long[]{0x000000000008E800L});
    public static final BitSet FOLLOW_start_in_plus163 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_trans_in_start176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_start182 = new BitSet(new long[]{0x000000000008E800L});
    public static final BitSet FOLLOW_sync_in_start186 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_start188 = new BitSet(new long[]{0x0000000004401002L});
    public static final BitSet FOLLOW_process_in_start194 = new BitSet(new long[]{0x0000000004401002L});
    public static final BitSet FOLLOW_restriction_in_start201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_renaming_in_start235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_start266 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_trans_var_in_trans302 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_trans304 = new BitSet(new long[]{0x000000000008E800L});
    public static final BitSet FOLLOW_process_in_trans309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sync_in_trans315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROCESS_in_process344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_trans_var353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_renaming364 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_ren1_in_renaming368 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_renaming371 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_ren1_in_renaming375 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_renaming379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_ren1400 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ren1402 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_action_in_ren1404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_restriction423 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_label_or_colabel_in_restriction427 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_23_in_restriction430 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_label_or_colabel_in_restriction434 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_27_in_restriction438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_action0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_label_or_colabel0 = new BitSet(new long[]{0x0000000000000002L});

}
package ii.edu.mk.parser;
// $ANTLR 3.3 Nov 30, 2010 12:45:30 /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g 2011-03-23 15:50:02

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Ccs2Lexer extends Lexer {
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

    	@Override
    	public void reportError(RecognitionException e) {
    		throw new RuntimeException(e);
    	}


    // delegates
    // delegators

    public Ccs2Lexer() {;} 
    public Ccs2Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Ccs2Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g"; }

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:10:7: ( '=' )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:10:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:11:7: ( '|' )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:11:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:12:7: ( '+' )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:12:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:13:7: ( '(' )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:13:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:14:7: ( ')' )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:14:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:15:7: ( '.' )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:15:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:16:7: ( '[' )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:16:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:17:7: ( ',' )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:17:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:18:7: ( ']' )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:18:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:19:7: ( '/' )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:19:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:20:7: ( '\\\\{' )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:20:9: '\\\\{'
            {
            match("\\{"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:21:7: ( '}' )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:21:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "LABEL"
    public final void mLABEL() throws RecognitionException {
        try {
            int _type = LABEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:89:2: ( ( ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' )* ) )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:89:5: ( ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' )* )
            {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:89:5: ( ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' )* )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:89:6: ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' )*
            {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:89:6: ( 'a' .. 'z' )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:89:7: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:89:16: ( 'a' .. 'z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LABEL"

    // $ANTLR start "CO_LABEL"
    public final void mCO_LABEL() throws RecognitionException {
        try {
            int _type = CO_LABEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:93:2: ( '_' LABEL )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:93:5: '_' LABEL
            {
            match('_'); 
            mLABEL(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CO_LABEL"

    // $ANTLR start "TAU"
    public final void mTAU() throws RecognitionException {
        try {
            int _type = TAU;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:97:2: ( '#' )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:97:4: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TAU"

    // $ANTLR start "PROCESS_VAR"
    public final void mPROCESS_VAR() throws RecognitionException {
        try {
            int _type = PROCESS_VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:101:2: ( '0' | ( ( 'A' .. 'Z' ) ( 'A' .. 'Z' | '0' .. '9' | '_' )* ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='0') ) {
                alt3=1;
            }
            else if ( ((LA3_0>='A' && LA3_0<='Z')) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:101:5: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:101:11: ( ( 'A' .. 'Z' ) ( 'A' .. 'Z' | '0' .. '9' | '_' )* )
                    {
                    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:101:11: ( ( 'A' .. 'Z' ) ( 'A' .. 'Z' | '0' .. '9' | '_' )* )
                    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:101:12: ( 'A' .. 'Z' ) ( 'A' .. 'Z' | '0' .. '9' | '_' )*
                    {
                    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:101:12: ( 'A' .. 'Z' )
                    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:101:13: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }

                    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:101:22: ( 'A' .. 'Z' | '0' .. '9' | '_' )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_') ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROCESS_VAR"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:105:6: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:105:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:105:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\t' && LA4_0<='\n')||LA4_0=='\r'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:8: ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | LABEL | CO_LABEL | TAU | PROCESS_VAR | WS )
        int alt5=17;
        switch ( input.LA(1) ) {
        case '=':
            {
            alt5=1;
            }
            break;
        case '|':
            {
            alt5=2;
            }
            break;
        case '+':
            {
            alt5=3;
            }
            break;
        case '(':
            {
            alt5=4;
            }
            break;
        case ')':
            {
            alt5=5;
            }
            break;
        case '.':
            {
            alt5=6;
            }
            break;
        case '[':
            {
            alt5=7;
            }
            break;
        case ',':
            {
            alt5=8;
            }
            break;
        case ']':
            {
            alt5=9;
            }
            break;
        case '/':
            {
            alt5=10;
            }
            break;
        case '\\':
            {
            alt5=11;
            }
            break;
        case '}':
            {
            alt5=12;
            }
            break;
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt5=13;
            }
            break;
        case '_':
            {
            alt5=14;
            }
            break;
        case '#':
            {
            alt5=15;
            }
            break;
        case '0':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
            {
            alt5=16;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt5=17;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;
        }

        switch (alt5) {
            case 1 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:10: T__17
                {
                mT__17(); 

                }
                break;
            case 2 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:16: T__18
                {
                mT__18(); 

                }
                break;
            case 3 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:22: T__19
                {
                mT__19(); 

                }
                break;
            case 4 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:28: T__20
                {
                mT__20(); 

                }
                break;
            case 5 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:34: T__21
                {
                mT__21(); 

                }
                break;
            case 6 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:40: T__22
                {
                mT__22(); 

                }
                break;
            case 7 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:46: T__23
                {
                mT__23(); 

                }
                break;
            case 8 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:52: T__24
                {
                mT__24(); 

                }
                break;
            case 9 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:58: T__25
                {
                mT__25(); 

                }
                break;
            case 10 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:64: T__26
                {
                mT__26(); 

                }
                break;
            case 11 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:70: T__27
                {
                mT__27(); 

                }
                break;
            case 12 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:76: T__28
                {
                mT__28(); 

                }
                break;
            case 13 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:82: LABEL
                {
                mLABEL(); 

                }
                break;
            case 14 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:88: CO_LABEL
                {
                mCO_LABEL(); 

                }
                break;
            case 15 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:97: TAU
                {
                mTAU(); 

                }
                break;
            case 16 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:101: PROCESS_VAR
                {
                mPROCESS_VAR(); 

                }
                break;
            case 17 :
                // /home/dragan/Dragan/workspaces/egradebook-workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs2.g:1:113: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}
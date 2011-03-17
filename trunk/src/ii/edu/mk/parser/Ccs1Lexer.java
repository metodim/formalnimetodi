package ii.edu.mk.parser;


import org.antlr.runtime.CharStream;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class Ccs1Lexer extends Lexer {
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

    	@Override
    	public void reportError(RecognitionException e) {
    		throw new RuntimeException(e);
    	}


    // delegates
    // delegators

    public Ccs1Lexer() {;} 
    public Ccs1Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Ccs1Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:10:7: ( '=' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:10:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:11:7: ( '(' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:11:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:12:7: ( ')' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:12:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:13:7: ( '.' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:13:9: '.'
            {
            match('.'); 

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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:14:7: ( '+' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:14:9: '+'
            {
            match('+'); 

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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:15:7: ( '|' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:15:9: '|'
            {
            match('|'); 

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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:16:7: ( '[' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:16:9: '['
            {
            match('['); 

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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:17:7: ( '/' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:17:9: '/'
            {
            match('/'); 

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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:18:7: ( ',' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:18:9: ','
            {
            match(','); 

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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:19:7: ( ']' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:19:9: ']'
            {
            match(']'); 

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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:20:7: ( '\\{' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:20:9: '\\{'
            {
            match('{'); 

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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:21:7: ( '}' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:21:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "TRANSITION_VAR"
    public final void mTRANSITION_VAR() throws RecognitionException {
        try {
            int _type = TRANSITION_VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:89:2: ( '#' | ( ( '_' )? ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' )* ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='#') ) {
                alt3=1;
            }
            else if ( (LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:89:4: '#'
                    {
                    match('#'); 

                    }
                    break;
                case 2 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:89:10: ( ( '_' )? ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' )* )
                    {
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:89:10: ( ( '_' )? ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' )* )
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:89:11: ( '_' )? ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' )*
                    {
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:89:11: ( '_' )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0=='_') ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:89:12: '_'
                            {
                            match('_'); 

                            }
                            break;

                    }

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:89:17: ( 'a' .. 'z' )
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:89:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:89:27: ( 'a' .. 'z' | '0' .. '9' | '_' )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:
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
    // $ANTLR end "TRANSITION_VAR"

    // $ANTLR start "PROCESS_VAR"
    public final void mPROCESS_VAR() throws RecognitionException {
        try {
            int _type = PROCESS_VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:93:2: ( '0' | ( ( 'A' .. 'Z' ) ( 'A' .. 'Z' | '0' .. '9' | '_' )* ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='0') ) {
                alt5=1;
            }
            else if ( ((LA5_0>='A' && LA5_0<='Z')) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:93:5: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:93:11: ( ( 'A' .. 'Z' ) ( 'A' .. 'Z' | '0' .. '9' | '_' )* )
                    {
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:93:11: ( ( 'A' .. 'Z' ) ( 'A' .. 'Z' | '0' .. '9' | '_' )* )
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:93:12: ( 'A' .. 'Z' ) ( 'A' .. 'Z' | '0' .. '9' | '_' )*
                    {
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:93:12: ( 'A' .. 'Z' )
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:93:13: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:93:22: ( 'A' .. 'Z' | '0' .. '9' | '_' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_') ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:
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
                    	    break loop4;
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:97:6: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:97:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:97:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\t' && LA6_0<='\n')||LA6_0=='\r'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
        // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | TRANSITION_VAR | PROCESS_VAR | WS )
        int alt7=15;
        switch ( input.LA(1) ) {
        case '=':
            {
            alt7=1;
            }
            break;
        case '(':
            {
            alt7=2;
            }
            break;
        case ')':
            {
            alt7=3;
            }
            break;
        case '.':
            {
            alt7=4;
            }
            break;
        case '+':
            {
            alt7=5;
            }
            break;
        case '|':
            {
            alt7=6;
            }
            break;
        case '[':
            {
            alt7=7;
            }
            break;
        case '/':
            {
            alt7=8;
            }
            break;
        case ',':
            {
            alt7=9;
            }
            break;
        case ']':
            {
            alt7=10;
            }
            break;
        case '{':
            {
            alt7=11;
            }
            break;
        case '}':
            {
            alt7=12;
            }
            break;
        case '#':
        case '_':
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
            alt7=13;
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
            alt7=14;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt7=15;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 7, 0, input);

            throw nvae;
        }

        switch (alt7) {
            case 1 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:46: T__20
                {
                mT__20(); 

                }
                break;
            case 8 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:52: T__21
                {
                mT__21(); 

                }
                break;
            case 9 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:58: T__22
                {
                mT__22(); 

                }
                break;
            case 10 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:64: T__23
                {
                mT__23(); 

                }
                break;
            case 11 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:70: T__24
                {
                mT__24(); 

                }
                break;
            case 12 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:76: T__25
                {
                mT__25(); 

                }
                break;
            case 13 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:82: TRANSITION_VAR
                {
                mTRANSITION_VAR(); 

                }
                break;
            case 14 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:97: PROCESS_VAR
                {
                mPROCESS_VAR(); 

                }
                break;
            case 15 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:1:109: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}
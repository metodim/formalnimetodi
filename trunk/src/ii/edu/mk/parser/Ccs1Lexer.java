package ii.edu.mk.parser;


import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:3:7: ( '=' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:3:9: '='
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:4:7: ( '(' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:4:9: '('
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:5:7: ( ')' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:5:9: ')'
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:6:7: ( '.' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:6:9: '.'
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:7:7: ( '+' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:7:9: '+'
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:8:7: ( '|' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:8:9: '|'
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:9:7: ( '[' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:9:9: '['
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:10:7: ( '/' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:10:9: '/'
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:11:7: ( ',' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:11:9: ','
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:12:7: ( ']' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:12:9: ']'
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:13:7: ( '\\{' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:13:9: '\\{'
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:14:7: ( '}' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:14:9: '}'
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:70:2: ( '#' | ( ( '_' )? ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' )* ) )
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
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:70:4: '#'
                    {
                    match('#'); 

                    }
                    break;
                case 2 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:70:10: ( ( '_' )? ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' )* )
                    {
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:70:10: ( ( '_' )? ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' )* )
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:70:11: ( '_' )? ( 'a' .. 'z' ) ( 'a' .. 'z' | '0' .. '9' | '_' )*
                    {
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:70:11: ( '_' )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0=='_') ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:70:12: '_'
                            {
                            match('_'); 

                            }
                            break;

                    }

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:70:17: ( 'a' .. 'z' )
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:70:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:70:27: ( 'a' .. 'z' | '0' .. '9' | '_' )*
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:75:2: ( '0' | ( ( 'A' .. 'Z' | '_' ) ( 'A' .. 'Z' | '0' .. '9' | '_' )* ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='0') ) {
                alt5=1;
            }
            else if ( ((LA5_0>='A' && LA5_0<='Z')||LA5_0=='_') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:75:4: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:75:10: ( ( 'A' .. 'Z' | '_' ) ( 'A' .. 'Z' | '0' .. '9' | '_' )* )
                    {
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:75:10: ( ( 'A' .. 'Z' | '_' ) ( 'A' .. 'Z' | '0' .. '9' | '_' )* )
                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:75:11: ( 'A' .. 'Z' | '_' ) ( 'A' .. 'Z' | '0' .. '9' | '_' )*
                    {
                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:75:25: ( 'A' .. 'Z' | '0' .. '9' | '_' )*
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:79:6: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:79:10: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs1.g:79:10: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
        alt7 = dfa7.predict(input);
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


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\16\uffff\1\17\2\uffff";
    static final String DFA7_eofS =
        "\21\uffff";
    static final String DFA7_minS =
        "\1\11\15\uffff\1\141\2\uffff";
    static final String DFA7_maxS =
        "\1\175\15\uffff\1\172\2\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\uffff\1\16\1\17";
    static final String DFA7_specialS =
        "\21\uffff}>";
    static final String[] DFA7_transitionS = {
            "\2\20\2\uffff\1\20\22\uffff\1\20\2\uffff\1\15\4\uffff\1\2\1"+
            "\3\1\uffff\1\5\1\11\1\uffff\1\4\1\10\1\17\14\uffff\1\1\3\uffff"+
            "\32\17\1\7\1\uffff\1\12\1\uffff\1\16\1\uffff\32\15\1\13\1\6"+
            "\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\32\15",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | TRANSITION_VAR | PROCESS_VAR | WS );";
        }
    }
 

}
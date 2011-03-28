package ii.edu.mk.parser;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class CcsLexer extends Lexer {
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

    public CcsLexer() {;} 
    public CcsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CcsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:7:7: ( '=' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:7:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:8:7: ( '(' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:8:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:9:7: ( ')' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:9:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:10:7: ( '.' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:10:9: '.'
            {
            match('.'); 

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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:11:7: ( '[' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:11:9: '['
            {
            match('['); 

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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:12:7: ( '/' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:12:9: '/'
            {
            match('/'); 

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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:13:7: ( ',' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:13:9: ','
            {
            match(','); 

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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:14:7: ( ']' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:14:9: ']'
            {
            match(']'); 

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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:15:7: ( '\\{' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:15:9: '\\{'
            {
            match('{'); 

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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:16:7: ( '}' )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:16:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "TRANSITION_VAR"
    public final void mTRANSITION_VAR() throws RecognitionException {
        try {
            int _type = TRANSITION_VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:64:2: ( ( 'a' .. 'z' | '_' ) ( 'a' .. 'z' | '0' .. '9' | '_' )* )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:64:4: ( 'a' .. 'z' | '_' ) ( 'a' .. 'z' | '0' .. '9' | '_' )*
            {
            if ( input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:64:18: ( 'a' .. 'z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:67:2: ( ( 'A' .. 'Z' | '_' ) ( 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:67:3: ( 'A' .. 'Z' | '_' ) ( 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:67:17: ( 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:
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
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:69:6: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:69:10: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:69:10: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\t' && LA3_0<='\n')||LA3_0=='\r'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:
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
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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
        // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | TRANSITION_VAR | PROCESS_VAR | WS )
        int alt4=13;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:1:10: T__11
                {
                mT__11(); 

                }
                break;
            case 2 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:1:16: T__12
                {
                mT__12(); 

                }
                break;
            case 3 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:1:22: T__13
                {
                mT__13(); 

                }
                break;
            case 4 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:1:28: T__14
                {
                mT__14(); 

                }
                break;
            case 5 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:1:34: T__15
                {
                mT__15(); 

                }
                break;
            case 6 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:1:40: T__16
                {
                mT__16(); 

                }
                break;
            case 7 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:1:46: T__17
                {
                mT__17(); 

                }
                break;
            case 8 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:1:52: T__18
                {
                mT__18(); 

                }
                break;
            case 9 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:1:58: T__19
                {
                mT__19(); 

                }
                break;
            case 10 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:1:64: T__20
                {
                mT__20(); 

                }
                break;
            case 11 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:1:70: TRANSITION_VAR
                {
                mTRANSITION_VAR(); 

                }
                break;
            case 12 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:1:85: PROCESS_VAR
                {
                mPROCESS_VAR(); 

                }
                break;
            case 13 :
                // /home/carevski/workspace/formalnimetodi/src/ii/edu/mk/parser/Ccs.g:1:97: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\13\uffff\1\14\3\uffff\1\14";
    static final String DFA4_eofS =
        "\20\uffff";
    static final String DFA4_minS =
        "\1\11\12\uffff\1\60\3\uffff\1\60";
    static final String DFA4_maxS =
        "\1\175\12\uffff\1\137\3\uffff\1\137";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\uffff\1\13"+
        "\1\14\1\15\1\uffff";
    static final String DFA4_specialS =
        "\20\uffff}>";
    static final String[] DFA4_transitionS = {
            "\2\16\2\uffff\1\16\22\uffff\1\16\7\uffff\1\2\1\3\2\uffff\1\7"+
            "\1\uffff\1\4\1\6\15\uffff\1\1\3\uffff\32\15\1\5\1\uffff\1\10"+
            "\1\uffff\1\13\1\uffff\32\14\1\11\1\uffff\1\12",
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
            "\12\17\7\uffff\32\15\4\uffff\1\17",
            "",
            "",
            "",
            "\12\17\7\uffff\32\15\4\uffff\1\17"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | TRANSITION_VAR | PROCESS_VAR | WS );";
        }
    }
 

}
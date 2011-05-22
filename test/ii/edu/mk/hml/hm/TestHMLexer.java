package ii.edu.mk.hml.hm;

import static org.hamcrest.number.OrderingComparison.comparesEqualTo;
import static org.junit.Assert.assertThat;
import ii.edu.mk.gui.Parameters;
import ii.edu.mk.hml.hm.HMLexer;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class TestHMLexer {
  
  private static final String folderPath = "test" + File.separator + Parameters.RESOURCE_PATH.getValue() + File.separator;
  private HMLexer lexer;

  @Before
  public void prepareTests() {
    lexer = new HMLexer(new File(folderPath + "lts019.aut"));
  }
  
  @Test
  public void testTokenization() throws Exception {
    assertThat(lexer.tokenization("<a>TT"),
        comparesEqualTo("<a>TT => true"));
    assertThat(lexer.tokenization("<b>TT"),
        comparesEqualTo("<b>TT => false"));
    assertThat(lexer.tokenization("[a]FF"),
        comparesEqualTo("[a]FF => false"));
    assertThat(lexer.tokenization("[b]FF"),
        comparesEqualTo("[b]FF => true"));
    
    assertThat(lexer.tokenization("[a]<b>TT"),
        comparesEqualTo("[a]<b>TT => false"));
    assertThat(lexer.tokenization("<a><b>TT"),
        comparesEqualTo("<a><b>TT => true"));
    assertThat(lexer.tokenization("[a]<a>[a][b]FF"),
        comparesEqualTo("[a]<a>[a][b]FF => true"));
    
    assertThat(lexer.tokenization("<a>(<a>TT AND <b>TT)"),
        comparesEqualTo("<a>(<a>TT AND <b>TT) => true"));
    assertThat(lexer.tokenization("<a>(<a>TT OR <b>TT)"),
        comparesEqualTo("<a>(<a>TT OR <b>TT) => true"));
    
    assertThat(lexer.tokenization("<a>([b][a]FF AND <b>TT)"),
        comparesEqualTo("<a>([b][a]FF AND <b>TT) => false"));
    assertThat(lexer.tokenization("<a>([a](<a>TT AND [b]FF) AND <b>FF)"),
        comparesEqualTo("<a>([a](<a>TT AND [b]FF) AND <b>FF) => true"));
    
    assertThat(lexer.tokenization("<a><a>tt UW <b>tt"),
        comparesEqualTo("<a><a>tt UW <b>tt => false"));
    assertThat(lexer.tokenization("<a><a>tt US <b>tt"),
        comparesEqualTo("<a><a>tt US <b>tt => true"));
  }
}
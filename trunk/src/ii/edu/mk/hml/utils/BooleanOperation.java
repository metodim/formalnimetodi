
package ii.edu.mk.hml.utils;

import ii.edu.mk.hml.exceptions.ParseException;

/**
 * This class is needed to evaluate boolean expression with brackets.
 * It contains one boolean field: value, and one char field: previousOperation
 * (can be: 'A' = AND, 'O' = OR, 'N' = NOT, 'R' = replace).
 */
public class BooleanOperation {
  private boolean value;
  private char previousOperation;
  
  /**
   * @param value
   * @param previousOperation
   */
  public BooleanOperation(boolean value, char previousOperation) {
    this.value = value;
    this.previousOperation = previousOperation;
  }
  
  /**
   * Copy constructor.
   * @param booleanOperation
   */
  public BooleanOperation(BooleanOperation booleanOperation) {
    this.value = booleanOperation.isValueTrue();
    this.previousOperation = booleanOperation.getPreviousOperation();
  }

  
  /**
   * @return the value
   */
  public boolean isValueTrue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(boolean value) {
    this.value = value;
  }

  /**
   * @return the previousOperation
   */
  public char getPreviousOperation() {
    return previousOperation;
  }

  /**
   * @param previousOperation the previousOperation to set
   */
  public void setPreviousOperation(char previousOperation) {
    this.previousOperation = previousOperation;
  }
  
  
  /**
   * Evaluates the value according to previousOperation and the given result. 
   * @param result The boolean to add to value
   * @throws ParseException if the previous operation is not one of: AND, OR, NOT, replace.
   */
  public void evaluateBoolean(boolean result) throws ParseException {
    switch (previousOperation) {
      case 'A':
        value = value && result;
        break;
      case 'O':
        value = value || result;
        break;
      case 'N':
        value = !value;
        break;
      case 'R':
        value = result;
        break;
      default:
        throw new ParseException("The boolean operation is not valid");
    }
  }

  
  
  @Override
  public String toString() {
    return "BooleanOperation [value=" + value + ", previousOperation="
        + previousOperation + "]";
  }
  
}

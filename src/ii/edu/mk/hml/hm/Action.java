
package ii.edu.mk.hml.hm;

/**
 * <p>Creates new action with a given name and form.
 * <br />
 * The form can be: forAll ([a]) or forAny (&lt;a&gt;).</p>
 * <p>Examples:<br />
 * <ul>
 * <li>Action: [a], can be created with: new Action("a", true)
 * <li>Action: {b}, can be created with: new Action("b", false) 
 * </ul>
 * </p>
 */
public class Action {
  private String name;
  private boolean forAll;
  
  /**
   * Creates new action.
   * @param name Action's name
   * @param forAll Action's form (forAll or forAny)
   */
  public Action(String name, boolean forAll) {
    this.name = name;
    this.forAll = forAll;
  }
  
  /**
   * @return Returns the name.
   */
  public String getName() {
    return name;
  }
  
  /**
   * @return Returns true if action for is forAll.
   */
  public boolean isForAll() {
    return forAll;
  }
  
  /**
   * @return Returns true if action for is forAny.
   */
  public boolean isForAny() {
    return !forAll;
  }

  
  /**
   * @param form sets Action's form (true = forAll, false = forAny)
   */
  public void setForm(boolean form) {
    this.forAll = form;
  }

  
  /**
   * Example: [a]
   * @return action representation
   */
  @Override
  public String toString() {
    if (isForAll()) {
      return "[" + name + "]";
    }
    else {
      return "<" + name + ">";
    }
  }
}

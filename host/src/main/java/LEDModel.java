import com.chuckstechtalk.alchitry.RegisterInterface;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class LEDModel {
  private final RegisterInterface reg;

  public final BooleanProperty Selected;

  /**
   * Create a model accepting RegisterInterface as a dependency.
   * @param reg A RegisterInterface that is connected and ready to communicate.
   */
  public LEDModel(RegisterInterface reg) {
    // Set internal reference to register interface dependency for later use.
    this.reg = reg;

    // Instantiate property that can be bound to views.
    Selected = new SimpleBooleanProperty();

    // Wire up a change listener to the property that can call into
    // the register interface to send address commands to the Alchitry Au.
    Selected.addListener((observable, oldValue, newValue) -> {
      try {
        setSelected(newValue);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
  }

  /**
   * Call the register interface to send the state of the model to
   * the Alchitry Au board.
   * @param value A boolean representing the state to send.
   * @throws Exception
   */
  private void setSelected(boolean value) throws Exception {
    reg.write(1, value ? 1 : 0);
  }
}

import javafx.beans.property.Property;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Represents a view with a checkbox to control the state
 * of any LED on the Alchitry Au.
 */
public class LEDView {
  private final Pane layout;
  private final CheckBox checkBox;

  /**
   * Build the internal representation of the view.
   */
  public LEDView() {
    // Use the HBox layout manager class to arrange controls horizontally.
    layout = new HBox();

    // One might move the label creation to a parameter within
    // the constructor.
    checkBox = new CheckBox("LED0");
    
    // Add the checkbox node to the layout.
    layout.getChildren().add(checkBox);
  }

  /**
   * Represents the state of the checkbox that can be used
   * for binding to a model.
   * @return  The Boolean property representing the state of the checkbox.
   */
  public Property<Boolean> getSelectedProperty() {
    return checkBox.selectedProperty();
  };

  /**
   * Gets the layout of the view in the form of a Pane that can be
   * assembled into a larger group of nodes and included within a scene.
   * @return  The Pane containing the layout.
   */
  public Pane getLayout() {
    return layout;
  }
}

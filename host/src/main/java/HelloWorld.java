import com.chuckstechtalk.alchitry.RegisterInterface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A simple HelloWorld JavaFX application to demonstrate how to
 * control the Alchitry Au FPGA from a desktop application over
 * USB serial using MVC techniques. You will need to change the 
 * connect method call in start to reference the serial port on 
 * your system.
 */
public class HelloWorld extends Application {
  RegisterInterface reg = new RegisterInterface();

  /*
  Changed from the video. This method is not needed. See comment in App.main.

  public static void runme(String[] args) {
    launch(args);
  }
  */

  @Override
  public void start(Stage window) {
    // Connect to Alchitry Au USB serial port. Modify to match
    // the serial port that is found on your system. See device manager
    // on Windows or something like `dmesg | grep tty` on Linux. 
    reg.connect("COM8", 1000000);

    // Create the view
    LEDView ledView = new LEDView();

    // Create the model
    LEDModel ledModel = new LEDModel(reg);

    // Simple "controller" tht binds the view to the model.
    ledModel.Selected.bind(ledView.getSelectedProperty());

    // Wire up the rest of JavaFx components to show the view.
    Scene scene = new Scene(ledView.getLayout());
    window.setScene(scene);
    window.show();
  }
}

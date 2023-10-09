package nz.ac.auckland.se206;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;

/**
 * The Sound class manages the sound settings for the application. The class is implemented as a
 * singleton to ensure a single instance throughout the application.
 */
public class Sound {

  /** Singleton instance of the Sound class. */
  private static Sound instance = null;

  /**
   * Retrieves the singleton instance of the Sound class.
   *
   * @return The singleton instance of the Sound class.
   */
  public static Sound getInstance() {
    if (instance == null) {
      instance = new Sound();
    }
    return instance;
  }

  private BooleanProperty isSoundOn = new SimpleBooleanProperty(true);
  private ObjectProperty<Image> soundImage = new SimpleObjectProperty<>();

  /**
   * Gets the object property representing the sound icon image.
   *
   * @return The object property for the sound icon image.
   */
  public ObjectProperty<Image> soundImageProperty() {
    return soundImage;
  }

  /**
   * Gets the boolean property representing whether sound is enabled.
   *
   * @return The boolean property for sound state (on/off).
   */
  public BooleanProperty isSoundOnProperty() {
    return isSoundOn;
  }

  /**
   * Toggles the sound icon to on or off depending on the isSoundOn boolean property.
   *
   * @throws FileNotFoundException
   */
  public void toggleImage() throws FileNotFoundException {
    isSoundOn.set(!isSoundOnProperty().get());

    // Sets icon to sound on version if sound is on and off if sound is off.
    if (isSoundOn.get()) {
      InputStream soundOn = new FileInputStream("src/main/resources/images/soundicon.png");
      Image soundOnImage = new Image(soundOn);
      soundImage.set(soundOnImage);
    } else {
      InputStream soundOff = new FileInputStream("src/main/resources/images/soundicondisable.png");
      Image soundOffImage = new Image(soundOff);
      soundImage.set(soundOffImage);
    }
  }
}

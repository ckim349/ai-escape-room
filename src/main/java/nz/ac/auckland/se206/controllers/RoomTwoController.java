package nz.ac.auckland.se206.controllers;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import nz.ac.auckland.se206.App;
import nz.ac.auckland.se206.GameState;
import nz.ac.auckland.se206.GameTimer;
import nz.ac.auckland.se206.MathQuestionSelector;
import nz.ac.auckland.se206.SceneManager;
import nz.ac.auckland.se206.SceneManager.AppUi;

public class RoomTwoController {
  @FXML private Label timerLabel;
  @FXML private ImageView toolBoxOpenImage;
  @FXML private ImageView toolBoxCollectedImage;
  @FXML private Rectangle door;
  @FXML private Rectangle goBackRectangle;
  @FXML private Label questionOneLabel;
  @FXML private Label questionTwoLabel;

  public void initialize() {
    System.out.println("RoomTwoController.initialize()");
    GameTimer gameTimer = GameTimer.getInstance();
    timerLabel.textProperty().bind(gameTimer.timeDisplayProperty());

    MathQuestionSelector selector = MathQuestionSelector.getInstance();
    questionOneLabel.setText(selector.getFirstQuestion());
    questionTwoLabel.setText(selector.getSecondQuestion());

    // Make the overlay images not visible
    toolBoxOpenImage.setOpacity(0);
    toolBoxCollectedImage.setOpacity(0);
  }

  @FXML
  public void clickDoor(MouseEvent event) throws IOException {
    System.out.println("door clicked");

    Parent roomThreeRoot = SceneManager.getUiRoot(AppUi.ROOM_THREE);
    App.getScene().setRoot(roomThreeRoot);
  }

  @FXML
  public void clickGoBackRectangle(MouseEvent event) throws IOException {
    System.out.println("go back clicked");

    Parent roomOneRoot = SceneManager.getUiRoot(AppUi.ROOM_ONE);
    App.getScene().setRoot(roomOneRoot);
  }

  @FXML
  public void clickToolCompartment(MouseEvent event) throws IOException {
    System.out.println("Tool Compartment Clicked");

    // If the passcode hasn't been solved
    // Go to enter access key screen
    if (!GameState.isPasscodeSolved) {
      Parent passcodeScreen = SceneManager.getUiRoot(AppUi.PASSCODE);
      App.getScene().setRoot(passcodeScreen);
    } else if (!GameState.isToolboxRevealed) {
      revealToolbox();
      GameState.isToolboxRevealed = true;
    } else if (!GameState.isToolboxCollected) {
      collectToolbox();
      GameState.isToolboxCollected = true;
    }
  }

  public void revealToolbox() {
    // Fade in the tool box to seem like it was 'unlocked'
    FadeTransition fadeTransition = new FadeTransition();
    fadeTransition.setNode(toolBoxOpenImage);
    fadeTransition.setFromValue(0); // starting opacity value
    fadeTransition.setToValue(1); // ending opacity value (1 is fully opaque)
    fadeTransition.setDuration(Duration.seconds(1)); // transition duration

    fadeTransition.play();
  }

  private void collectToolbox() {
    // Fade in the tool box to seem like it was 'unlocked'
    FadeTransition fadeTransition = new FadeTransition();
    fadeTransition.setNode(toolBoxCollectedImage);
    fadeTransition.setFromValue(0); // starting opacity value
    fadeTransition.setToValue(1); // ending opacity value (1 is fully opaque)
    fadeTransition.setDuration(Duration.seconds(0.5)); // transition duration

    fadeTransition.play();
  }

  /**
   * Handles the key pressed event.
   *
   * @param event the key event
   */
  @FXML
  public void onKeyPressed(KeyEvent event) {
    System.out.println("key " + event.getCode() + " pressed");
  }

  /**
   * Handles the key released event.
   *
   * @param event the key event
   */
  @FXML
  public void onKeyReleased(KeyEvent event) {
    System.out.println("key " + event.getCode() + " released");
  }
}

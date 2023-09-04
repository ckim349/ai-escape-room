package nz.ac.auckland.se206.controllers;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import nz.ac.auckland.se206.App;
import nz.ac.auckland.se206.GameState;
import nz.ac.auckland.se206.SceneManager;
import nz.ac.auckland.se206.SceneManager.AppUi;
import nz.ac.auckland.se206.gpt.openai.ApiProxyException;
import nz.ac.auckland.se206.speech.TextToSpeech;

public class WinScreenController {

  @FXML private ImageView restartButton;

  private TextToSpeech textToSpeech = new TextToSpeech();

  @FXML
  public void initialize() throws ApiProxyException {
    new Thread(
            () -> {
              try {
                textToSpeech.speak("Congratulations you win!");
              } catch (Exception e) {
                e.printStackTrace();
              }
            })
        .start();
  }

  @FXML
  private void onExitButtonClicked(ActionEvent event) {
    Platform.exit();
    System.exit(0);
  }

  @FXML
  private void clickRestartButton(MouseEvent event) throws IOException {
    // TODO: Update this
    // Reset all game state variables
    GameState.isRiddleResolved = false;
    GameState.isJokeResolved = false;

    Parent startRoot = SceneManager.getUiRoot(AppUi.START);
    App.getScene().setRoot(startRoot);
  }
}
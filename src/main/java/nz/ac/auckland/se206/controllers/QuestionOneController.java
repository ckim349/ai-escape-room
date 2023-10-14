package nz.ac.auckland.se206.controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import nz.ac.auckland.se206.App;
import nz.ac.auckland.se206.ChatCentralControl;
import nz.ac.auckland.se206.GameState;
import nz.ac.auckland.se206.GameTimer;
import nz.ac.auckland.se206.MathQuestionSelector;
import nz.ac.auckland.se206.MyControllers;
import nz.ac.auckland.se206.SceneManager;
import nz.ac.auckland.se206.SceneManager.AppUi;
import nz.ac.auckland.se206.gpt.ChatMessage;
import nz.ac.auckland.se206.gpt.GptPromptEngineering;

/**
 * Controller class for the Question One view. This class handles user interactions and UI updates
 * for the Question One view.
 */
public class QuestionOneController implements MyControllers {

  @FXML private Label timerLabel;
  @FXML private Label questionOneLabel;
  @FXML private Button questionOneHintButton;

  /**
   * Initializes the Question One view when it loads. This method sets up the timer label and
   * displays the first math question.
   */
  public void initialize() {
    System.out.println("QuestionOneController.initialize()");

    GameTimer gameTimer = GameTimer.getInstance();
    timerLabel.textProperty().bind(gameTimer.timeDisplayProperty());

    MathQuestionSelector selector = MathQuestionSelector.getInstance();
    questionOneLabel.setText(selector.getFirstQuestion());

    if (GameState.hard) {
      questionOneHintButton.setVisible(false);
    }
  }

  @FXML
  private void onClickQuestionOneHintButton() {

    if(GptPromptEngineering.checkIfAuthorisedAndPrintMessage()) {
      return;
    }

    ChatMessage msg = new ChatMessage("user", "Please give me a hint for the first question");

    // Add asking for hint message to chat
    ChatCentralControl.getInstance().addMessage(msg);
    ChatCentralControl.getInstance().runGpt(msg);
  }

  /**
   * Handles the click event on the "Go Back" button. Navigates back to Room Two when the button is
   * clicked.
   */
  @FXML
  private void onGoBack() {
    Parent roomTwoRoot = SceneManager.getUiRoot(AppUi.ROOM_TWO);
    App.getScene().setRoot(roomTwoRoot);
  }

  @Override
  public void disableHintButton() {
    questionOneHintButton.setDisable(true);
  }
}

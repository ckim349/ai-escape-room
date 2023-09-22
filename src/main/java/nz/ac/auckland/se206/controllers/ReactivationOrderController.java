package nz.ac.auckland.se206.controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import nz.ac.auckland.se206.App;
import nz.ac.auckland.se206.ButtonOrder;
import nz.ac.auckland.se206.GameState;
import nz.ac.auckland.se206.GameTimer;
import nz.ac.auckland.se206.SceneManager;
import nz.ac.auckland.se206.SceneManager.AppUi;

public class ReactivationOrderController {
  @FXML private Label timerLabel;
  @FXML private Label orderLabel;

  public void initialize() {
    System.out.println("ReactivationOrderController.initialize()");

    GameTimer gameTimer = GameTimer.getInstance();
    timerLabel.textProperty().bind(gameTimer.timeDisplayProperty());

    ButtonOrder buttonOrder = ButtonOrder.getInstance();
    orderLabel.setText(buttonOrder.getCorrectOrderString());
  }

  @FXML
  private void onGoBack() {
    if (GameState.isPartFixed) {
      // If part is fixed, go to room with reactivate button
      Parent roomOneRoot = SceneManager.getUiRoot(AppUi.ROOM_ONE_FINAL);
      App.getScene().setRoot(roomOneRoot);
    } else {
      Parent roomOneRoot = SceneManager.getUiRoot(AppUi.ROOM_ONE);
      App.getScene().setRoot(roomOneRoot);
    }
  }
}

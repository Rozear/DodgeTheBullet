package utilities;

import gui.GameScreen;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import logic.BulletSpawner;
import logic.GameLogic;
import main.IRenderableHolder;
import main.Main;

public class GameLoop {
	
	GameScreen gameScreen;
	GameLogic logic;
	
	public GameLoop(GameScreen gameScreen){
		this.gameScreen = gameScreen;
		this.logic = gameScreen.getLogic();
	}
	
	public void start(){
		new AnimationTimer(){

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				gameScreen.paintComponent();
				logic.logicUpdate();
				IRenderableHolder.getInstance().update();
				if(logic.getPlayer().isDestroy()){
					System.out.println("GAME OVER");
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setContentText("GAME OVER");
							alert.showAndWait();
						}
					});
					this.stop();
				}
			}
			
			
		}.start();
	}
	
}
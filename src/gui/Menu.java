package gui;

import java.util.ResourceBundle;
import java.util.concurrent.Delayed;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.Media;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import main.Main;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

public class Menu extends Application {
	@FXML
	private Text Start;
	@FXML
	private Text Option;
	@FXML
	private Text Exit;
	@FXML
	private Text yeah;
	@FXML
	private Text Back;
	@FXML
	private Text BGM;
	@FXML
	private Text secretbase;
	@FXML
	private Text trancingpulse;
	@FXML
	private ImageView bg;
	
	boolean playing;
	Scene scene,scene2;
	MediaPlayer mediaPlayer,mediaPlayer2;
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
		scene = new Scene(loader.load());
		
		Menu a = loader.getController();
	
		stage.setScene(scene);
		a.setstage(stage);
		a = loader.getController();
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
		
		MyMediaPlayer.musicplay();
	}

	private void setstage(Stage stage) {
		// start
		TranslateTransition transStart =  new TranslateTransition(Duration.millis(1000), Start);
		transStart.toXProperty().bind(stage.widthProperty().add(0));
		TranslateTransition transOption =  new TranslateTransition(Duration.millis(1200), Option);
		transOption.toXProperty().bind(stage.widthProperty().add(0));
		TranslateTransition transExit =  new TranslateTransition(Duration.millis(1300), Exit);
		transExit.toXProperty().bind(stage.widthProperty().add(0));
		
	
//		SequentialTransition trans = new SequentialTransition(transStart,transOption,transExit);
		Start.setOnMouseClicked(a -> {
			transStart.play();
			transOption.play();
			transExit.play();
			Timeline timeline =new Timeline(new KeyFrame(
			        Duration.millis(1500),
			        ae -> {
			        	try {
							Main.instance.toggleScene();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }));
			timeline.play();
		
//			trans.play();
		
		});
		
		Option.setOnMouseClicked(a -> {
	
			BGM.setVisible(true);
			secretbase.setVisible(true);
			yeah.setVisible(true);
			Start.setVisible(false);
			Option.setVisible(false);
			Exit.setVisible(false);
			Back.setVisible(true);
		});
		
		Back.setOnMouseClicked(a -> {
			BGM.setVisible(false);
			secretbase.setVisible(false);
			trancingpulse.setVisible(false);
			yeah.setVisible(false);
			Start.setVisible(true);
			Option.setVisible(true);
			Exit.setVisible(true);
			Back.setVisible(false);
		});
		
		Exit.setOnMouseClicked(a -> {
			stage.close();
		});
		secretbase.setOnMouseClicked(a -> {
			MyMediaPlayer.changemusic();
			secretbase.setVisible(false);
			trancingpulse.setVisible(true);
		});
		trancingpulse.setOnMouseClicked(a -> {
			MyMediaPlayer.changemusic();
			secretbase.setVisible(true);
			trancingpulse.setVisible(false);
		});
		
		new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				
			}
		}.start();
	}
	
	public static void main(String[] args){
		launch(args);
	}

	
}

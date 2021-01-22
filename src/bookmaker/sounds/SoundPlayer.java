package bookmaker.sounds;

import java.io.File;
import java.util.Random;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundPlayer {

	private static SoundPlayer instance;

	private Random random;
	private MediaPlayer mediaPlayer;
	
	
	private SoundPlayer() {
		random = new Random();
	}
	
	public static SoundPlayer getInstance() {
		if(instance == null)
			instance = new SoundPlayer();
		
		return instance;
	}
	
	
	public void playRandomPageTurn() {
		String fileName = "Page_turn";
		int randomInt = random.nextInt(3) + 1;
		fileName += randomInt + ".mp3";
		
		if(mediaPlayer != null)
			mediaPlayer.stop();
		mediaPlayer = new MediaPlayer(new Media(new File("res/sounds/" + fileName).toURI().toString()));
		mediaPlayer.play();	
	}
	
}

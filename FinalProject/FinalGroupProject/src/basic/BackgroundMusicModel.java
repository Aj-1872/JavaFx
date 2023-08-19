package basic;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BackgroundMusicModel {

    private MediaPlayer mediaPlayer; // MediaPlayer instance to manage background music

    public BackgroundMusicModel() {
        // Load the audio file from the resources folder
        Media media = new Media(getClass().getResource("img/Pokemon.mp3").toExternalForm());

        // Create a MediaPlayer with the loaded audio file
        mediaPlayer = new MediaPlayer(media);

        // Set the media player to repeat indefinitely
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    // Start playing the background music
    public void playMusic() {
        mediaPlayer.play();
    }

    // Stop the background music and release resources
    public void stopMusic() {
        mediaPlayer.stop();
        mediaPlayer.dispose();
    }
}

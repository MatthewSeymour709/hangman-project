
import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

public class Music {

    private final URL CORRECT_PATH = this.getClass().getResource("/assets/correct.mp3");
    private final URL WRONG_PATH = this.getClass().getResource("/assets/wrong.mp3");
    private final URL WIN_PATH = this.getClass().getResource("/assets/win.mp3");
    private final URL LOSE_PATH = this.getClass().getResource("/assets/lose.mp3");

    public Music () {
        try {
            InputStream BACKGROUND_PATH = new BufferedInputStream(Objects.requireNonNull(this.getClass().getResourceAsStream("/assets/background.mp3")));
            AudioInputStream audioBkgd = AudioSystem.getAudioInputStream(BACKGROUND_PATH);
            Clip backgroundClip = AudioSystem.getClip();
            backgroundClip.open(audioBkgd);
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            System.out.println("Background Music Unavailable");
        }
    }

    public void gameSoundEffect(int effect) {
        try {
            AudioInputStream audioInputStream = null;

            if (effect == 1) {
                assert CORRECT_PATH != null;
                audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(CORRECT_PATH.openStream()));
            }
            if (effect == 2) {
                assert WRONG_PATH != null;
                audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(WRONG_PATH.openStream()));
            }
            if (effect == 3) {
                assert WIN_PATH != null;
                audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(WIN_PATH.openStream()));
            }
            if (effect == 4) {
                assert LOSE_PATH != null;
                audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(LOSE_PATH.openStream()));
            }
            Clip soundEffectClip = AudioSystem.getClip();
            soundEffectClip.open(audioInputStream);
            soundEffectClip.start();
        } catch (Exception e) {
            System.out.println("Sound Effect Unavailable");
        }
    }

}

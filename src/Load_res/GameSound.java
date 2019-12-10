package Load_res;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.sql.Time;

public class GameSound {
    public final static File over = new File("res/sound/gameOver.wav");
    private static Clip clip;
    public final static File intro = new File("res/sound/welcome.mid");
    public final static File fire1 =new File("res/sound/fire1.wav");
    public final static File fire2 =new File("res/sound/fire2.wav");
    public final static File fire3 =new File("res/sound/fire3.wav");
    public final static File gameSound =new File("res/sound/gameS.wav");
    public final static File gameOverSound =new File("res/sound/xlost.mid");
    public final static File winSound =new File("res/sound/Music5.mid");
    public final static File enemyDie =new File("res/sound/dieEnemy.wav");
    public final static File tick =new File("res/sound/tick.wav");
    public static final File welcome = new File("res/sound/welcome.wav");
    public GameSound(){
    }
    public static void play(File file) {
            try {
                AudioInputStream stream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(stream);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    public static   void stop() {
        try {

            clip.stop();
        }
        catch (Exception e){

        }
    }
}

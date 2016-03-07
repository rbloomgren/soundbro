package soundbro;

import java.io.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class Soundbro {

    public Soundbro() {

        try {
            File myFile = new File("C:\\soundbro\\sound.wav");//file location
            URL myUrl = myFile.toURI().toURL();
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(myUrl);

            Clip clip = AudioSystem.getClip();//get resource
            clip.open(audioIn);// Open audio clip and load samples from the audio input stream.
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            while(true)try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Soundbro.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Soundbro();
    }
}

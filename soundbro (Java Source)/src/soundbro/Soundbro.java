/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soundbro;

import java.io.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class Soundbro {

    // Constructor
    public Soundbro() {

        try {
            File myFile = new File("C:\\soundbro\\sound.wav");
            URL myUrl = myFile.toURI().toURL();
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(myUrl);

            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
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
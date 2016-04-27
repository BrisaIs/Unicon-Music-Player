package controller.player;

import javazoom.jlgui.basicplayer.BasicPlayer;
import java.io.File;

public class Player {
	private BasicPlayer player;
	
	public Player(){
		 player = new BasicPlayer();
	}
	
	public void play() throws Exception {
		 player.play();
	}
		 
	public void openFile(String path) throws Exception {
		 File song = new File(path);
		 player.open(song);
	}
		 
	public void pause() throws Exception {
		 player.pause();
	}
		 
	public void resume() throws Exception {
		 player.resume();
	}
		 
	public void stop() throws Exception {
		 player.stop();
	}
}

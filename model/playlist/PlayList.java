package model.playlist;

import java.util.ArrayList;
import java.util.Iterator;

import model.song.Song;

public class PlayList extends ArrayList<Song>{
	
	public PlayList(){
		
	}
	
	public void show(){
		for(Song s : this){
			System.out.println(s);
		}
	}
}

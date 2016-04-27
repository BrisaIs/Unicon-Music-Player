package model.library;

import java.io.File;
import java.util.ArrayList;

import model.song.Song;
import model.song.SongBuilder;

public class Library {
	private ArrayList <Directory> directories;
	private ArrayList<Song> songs;
	
	public Library(){
		directories = new ArrayList<Directory>();
		songs = new ArrayList<Song>();
	}
	
	public Directory add(String path){
		return add(null, path);
	}
	
	public Directory add(Directory dir, String path){
		Directory newDir = new Directory(dir,path);
		directories.add(newDir);
		return newDir;
	}
	
	public ArrayList<Song> getSongs(){
		return songs;
	}
	
	public void update(){
		directories.forEach(this::readSongs);
	}
	
	public void readSongs(Directory dir){
		if(dir.getFiles() != null){
			for(File file : dir.getFiles()){
				if(file != null)
					if(file.isDirectory()){
						Directory newDir = new Directory(dir, file.getName()+"\\");
						readSongs(newDir);
					}else if(file.isFile())
						if(isSong(file))
							songs.add(SongBuilder.newInstance(dir,file.getName()));
						
			} 	
		}
	}
	
	private boolean isSong(File file){
		return file.getName().endsWith(".mp3");
	}
	
}

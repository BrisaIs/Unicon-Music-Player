package model.song;

import java.io.File;

import org.blinkenlights.jid3.*;
import org.blinkenlights.jid3.v1.*;
import org.blinkenlights.jid3.v2.*;

import model.library.Directory;

public class Song{
	/* Song information*/
	
	private String title;
	private String artist;
	private String album;
	private String gender = Gender.UNKNOWN;
	private Double duration;
	
	private int playCount;
	private int score;
	
	private String namePath;
	private Directory containerDirectory;
	
	private static int count = 0;
	private int id;
	
	public Song(String path){
		this.namePath = path;
		title = "unknown";
		artist = "unknown";
		album = "unknown";
		gender = "unknown";
		score = 0;
		playCount = 0;
		id = count;
		count += 1;
	}
	
	public Song(){
		this("");
	}
	
	
	public void setDirectory(Directory container){
		containerDirectory = container;
	}
	
	public String getPath(){
		return containerDirectory.getPath()+namePath;
	}
	
	public void setPath(String path){
		namePath = path;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString(){
		String song = String.format("%s-%10.3f min", title+" Album:"+album, duration);
		return song;
	}
	
	public int getId(){
		return id;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}
	
}

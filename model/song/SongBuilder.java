package model.song;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.tritonus.share.sampled.file.TAudioFileFormat;

import model.library.Directory;

public class SongBuilder {
	public static Song newInstance(Directory directory, String songNamePath){
		Song newSong = new Song(songNamePath);
		newSong.setDirectory(directory);
		try {
			readTags(newSong);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newSong;
	}
	
	public static void readTags(Song newSong) throws UnsupportedAudioFileException, IOException {
		File file = new File(newSong.getPath());
		AudioFileFormat baseFileFormat = null;
		AudioFormat baseFormat = null;
		baseFileFormat = AudioSystem.getAudioFileFormat(file);
		baseFormat = baseFileFormat.getFormat();
		
		// TAudioFileFormat properties
		if (baseFileFormat instanceof TAudioFileFormat)
		{
		    Map properties = ((TAudioFileFormat)baseFileFormat).properties();
		    newSong.setTitle((String) properties.get("title"));
		    newSong.setAlbum((String) properties.get("album"));
		    newSong.setArtist((String) properties.get("author"));
		    newSong.setDuration(toMinutes((Long) properties.get("duration")));
		}
	}
	
	private static Double toMinutes(Long input){
		double miliseconds = input/1000;
		double seconds = miliseconds/1000;
		double minutes = seconds/60;
		return  minutes;
	}
}

package structure.tree;

import java.util.Comparator;

import model.song.Song;

public class Comparators {
	public static Comparator<Song> byTitle = new Comparator<Song>(){

		@Override
		public int compare(Song a, Song b) {
			if(a.getTitle().compareTo(b.getTitle())  == 0)
				return a.getId() > b.getId() ? 1 : -1;
			else 
				return a.getTitle().compareTo(b.getTitle());
		}
		
	};
	
	public static Comparator<Song> byArtist = new Comparator<Song>(){

		@Override
		public int compare(Song a, Song b) {
			if(a.getArtist().compareTo(b.getArtist()) == 0)
					return Comparators.byTitle.compare(a,b);
			return a.getArtist().compareTo(b.getArtist());
		}
		
	};
	
	public static Comparator<Song> byAlbum = new Comparator<Song>(){

		@Override
		public int compare(Song a, Song b) {
			if(a.getAlbum().compareTo(b.getAlbum())==0)
					return Comparators.byTitle.compare(a, b);
			return a.getAlbum().compareTo(b.getAlbum());
		}
		
	};
}

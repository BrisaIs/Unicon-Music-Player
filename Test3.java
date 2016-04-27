import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import controller.player.Player;
import model.library.Directory;
import model.library.Library;
import model.song.Song;
import model.song.SongBuilder;

import structure.tree.*;

public class Test3 {
	public static void main(String args[]){
		Map<String, String> env = System.getenv();
		Library library = new Library();
		AVL avlArtist = new AVL(Comparators.byTitle);
		BST bstArtist = new BST(Comparators.byTitle);
		
		Arrays.asList("C:\\Users\\"+env.get("USERNAME")+"\\Music\\Breaking Benjamin\\",
					  "C:\\Users\\"+env.get("USERNAME")+"\\Music\\Three day grace\\",
					  "C:\\Users\\"+env.get("USERNAME")+"\\Music\\Three day grace\\Starset - Transmissions (2014) [Bonus Edition] By RESERVoir"
					  ).forEach(library::add);
	
		library.update();
		ArrayList<Song> songs = library.getSongs();
		
		songs.forEach(bstArtist::insert);
		songs.forEach(avlArtist::insert);
		
		System.out.println(songs.size());
		//bstTitle.inOrder();
		System.out.println("\n\nBY ARTIST");
		//bstArtist.inOrder();
		System.out.println("\n\nBST\n");
		bstArtist.mostrar();
		System.out.println("\n\nAVL\n");
		avlArtist.mostrar();
	}
}

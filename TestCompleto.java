import java.util.Arrays;
import java.util.Map;

import model.library.Library;
import model.playlist.PlayList;
import structure.tree.AVL;
import structure.tree.BST;
import structure.tree.Comparators;
import structure.tree.DataBase;
import structure.tree.Select;

public class TestCompleto {
	public static void main(String args[]){
		Map<String, String> env = System.getenv();
		Library library = new Library();
		DataBase dataBase = new DataBase();
		
		Arrays.asList("C:\\Users\\"+env.get("USERNAME")+"\\Music\\Breaking Benjamin\\",
					  "C:\\Users\\"+env.get("USERNAME")+"\\Music\\Three day grace\\",
					  "C:\\Users\\"+env.get("USERNAME")+"\\Music\\Starset\\"
					  ).forEach(library::add);
		library.update();
		
		dataBase.add(library);
		
		PlayList breakingBenjamin = dataBase.whereAuthorIs("Breaking Benjamin");
		System.out.println("Author: Breakning Benjamin");
		breakingBenjamin.show();
		
		PlayList transmissions = dataBase.whereAlbumIs("Transmissions");
		System.out.println("\nAlbum: Transmissions");
		transmissions.show();
		
		PlayList lessThan2 = dataBase.whereDurationIsLessThan(3d);
		System.out.println("\nDurarion less than 4");
		lessThan2.show();
		
		PlayList greaterThan2 = dataBase.whereDurationIsGreaterThan(4d);
		System.out.println("\nDurarion greater than 4");
		greaterThan2.show();
		
		PlayList between2and4 = dataBase.whereDurationIsBetween(2d, 3.5d);
		System.out.println("\nDurarion is between 2 and 3.5");
		between2and4.show();
		
		PlayList title = dataBase.whereTitleIs("Time of Dying");
		System.out.println("\n Search for a Song");
		title.show();
		
	}
}

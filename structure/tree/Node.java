package structure.tree;

import model.song.Song;

public class Node {
	public Node left;
	public Node right;
	
	public Song value;
	public int balanceFactor;
	
	public Node(Song dato){
		value = dato;
		balanceFactor = 0;
		left = null;
		right = null;
	}
}

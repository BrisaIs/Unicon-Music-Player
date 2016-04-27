package structure.tree;

import model.library.Library;
import model.playlist.PlayList;
import model.song.Song;

public class DataBase {
	private AVL avlTitle;
	private AVL avlAuthor;
	private AVL avlDuration;
	private AVL avlAlbum;
	
	PlayList result;
	
	public DataBase(){
		avlTitle = new AVL(Comparators.byTitle);
		avlAuthor = new AVL(Comparators.byArtist);
		avlAlbum = new AVL(Comparators.byAlbum);
		avlDuration = new AVL(Comparators.byDuration);
	}
	
	public void add(Song s){
		AVL []avls = {avlTitle,avlAuthor,avlDuration,avlAlbum};
		for(AVL avl : avls)
			avl.insert(s);
	}
	
	public void add(Library library){
		for(Song s : library.getSongs())
			add(s);
	}
	
	public PlayList whereAuthorIs(String author){
		result = new PlayList();
		authorIsImpl(author,avlAuthor.root);
		return result;
	}
	
	private void authorIsImpl(String name, Node root){
		if(root.value.getArtist().equals(name)) result.add(root.value);
		if(root.value.getArtist().compareTo(name)>=0 && root.left != null) authorIsImpl(name,root.left); 
		if(root.value.getArtist().compareTo(name)<=0 && root.right != null) authorIsImpl(name,root.right);
	}
	
	public PlayList whereAlbumIs(String album){
		result = new PlayList();
		albumIsImpl(album,avlAlbum.root);
		return result;
	}
	
	private void albumIsImpl(String name, Node root){
		if(root.value.getAlbum().equals(name)) result.add(root.value);
		if(root.value.getAlbum().compareTo(name)>=0 && root.left != null) albumIsImpl(name,root.left); 
		if(root.value.getAlbum().compareTo(name)<=0 && root.right != null) albumIsImpl(name,root.right);
	}
	
	public PlayList whereDurationIsGreaterThan(Double duration){
		result = new PlayList();
		durationIsGreaterImpl(duration,avlDuration.root);
		return result;
	}
	
	private void durationIsGreaterImpl(Double duration, Node root){
		if(root.value.getDuration() > duration) result.add(root.value);
		if(root.value.getDuration() > duration && root.left != null) durationIsGreaterImpl(duration,root.left); 
		if(root.right != null) durationIsGreaterImpl(duration,root.right);
	}
	
	public PlayList whereDurationIsLessThan(Double duration){
		result = new PlayList();
		durationIsLessImpl(duration,avlDuration.root);
		return result;
	}
	
	private void durationIsLessImpl(Double duration, Node root){
		if(root.value.getDuration() < duration) result.add(root.value);
		if(root.left != null) durationIsLessImpl(duration,root.left); 
		if(root.value.getDuration() < duration && root.right != null) durationIsLessImpl(duration,root.right); 
	}
	
	
	public PlayList whereDurationIsBetween(Double min, Double max){
		result = new PlayList();
		durationIsBetweenImpl(min,max,avlDuration.root);
		return result;
	}
	
	private void durationIsBetweenImpl(Double min, Double max, Node root){
		if(root.value.getDuration() < max && root.value.getDuration() > min) result.add(root.value);
		if(root.value.getDuration() > min && root.left != null) durationIsBetweenImpl(min,max,root.left); 
		if(root.value.getDuration() < max && root.right != null) durationIsBetweenImpl(min,max,root.right);
	}
	
	public PlayList whereTitleIs(String title){
		result = new PlayList();
		titleIsImpl(title,avlTitle.root);
		return result;
	}
	
	private void titleIsImpl(String title, Node root){
		if(root.value.getTitle().equals(title)) result.add(root.value);
		if(root.value.getArtist().compareTo(title)>=0 && root.left != null) titleIsImpl(title,root.left); 
		if(root.value.getArtist().compareTo(title)<=0 && root.right != null) titleIsImpl(title,root.right);
	}
	
}

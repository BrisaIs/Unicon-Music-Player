package model.library;

import java.io.File;
import java.util.ArrayList;

public class Directory {
	private String path;
	private Directory father;
	
	public Directory(Directory father, String path){
		this.father = father;
		this.path = path;
	}
	
	public void setPath(String path){
		this.path = path;
	}
	
	public String getPath(){
		if(father != null)
			return father.getPath()+path;
		else 
			return path;
	}
	
	public File[] getFiles(){
		ArrayList<File> result = new ArrayList<File>();
		File directory = new File(getPath());
		
		if(directory.exists())
			return directory.listFiles();
		else
			return null;
	}
}

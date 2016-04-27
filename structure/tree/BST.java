package structure.tree;

import java.util.Comparator;

import model.song.Song;

public class BST implements Tree<Song>{
	
	private Song value;
	private BST left, right;
	private BST father;
	private Comparator<Song> comparator;
	
	public BST(Comparator<Song> c){
		comparator = c;
	}
	
	@Override
	public void insert(Song a) {
		insert(a,null);
	}
	
	private void insert(Song a, BST father){
		if(value == null){
			value = a;
			this.father = father;
		}else if(comparator.compare(a, value) < 0){
			if(left == null) left = new BST(comparator);
			left.insert(a, this);
		}else if(comparator.compare(a, value) > 0){
			if(right == null) right = new BST(comparator);
			right.insert(a,this);
		}
	}

	@Override
	public boolean exist(Song a) {
		if(value != null){
			if(comparator.compare(a, value) == 0)
				return true;
			else if(comparator.compare(a, value) < 0 && left!= null){
				return left.exist(a);
			}else if(comparator.compare(a, value) > 0 && right!= null){
				return right.exist(a);
			}
		}
		return false;
	}

	@Override
	public Song get(Song a) {
		if(value != null){
			if(value == a)
				return value;
			else if(comparator.compare(a, value) < 0 && left != null){
				return left.get(a);
			}else if(comparator.compare(a, value) > 0 && right != null){
				return right.get(a);
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return value == null;
	}

	@Override
	public boolean isLeaf() {
		return value != null && left == null && right == null;
	}

	@Override
	public String inOrder() {
		if(value != null){
			if(left != null) left.inOrder();
			System.out.println(value);
			if(right != null) right.inOrder();
		}
		
		return "";
	}

	@Override
	public String posOrder() {
		if(value != null){
			if(left != null) left.inOrder();
			if(right != null) right.inOrder();
			System.out.println(value);
		}
		
		return "";
	}

	@Override
	public String preOrder() {
		if(value != null){
			System.out.println(value);
			if(left != null) left.inOrder();
			if(right != null) right.inOrder();
		}
		
		return "";
	}

	@Override
	public void remove(Song a) {
		if(value != null){
			if(comparator.compare(a, value) == 0){
				removeNode(a);
			}else if(comparator.compare(a, value) < 0 && left != null){
				left.remove(a);
			}else if(comparator.compare(a, value) > 0 && right != null){
				right.remove(a);
			}
		}
	}
	
	
	private void removeNode(Song a){
		if(left!= null && right != null){
			removeTwoChildren();
		}else if(left != null || right != null){
			removeWithAChild();
		}else{
			removeLeaf();
		}
	}
	
	public BST minimum(){
		if(left != null && !left.isEmpty()) return left.minimum();
		else return this;
	}
	
	public void removeLeaf(){
		if(father != null){
			if(this == father.left) father.left = null;
			if(this == father.right) father.right = null;
			father = null;
		}
		value = null;
	}
	
	public void removeWithAChild(){
		BST substitute = left != null ? left : right;
		this.value = substitute.value;
		left = substitute.left;
		right = substitute.right;
	}
	
	public void removeTwoChildren(){
		BST minimo = right.minimum();
		this.value = minimo.value;
		right.remove(minimo.value);
	}

	public void  implMostrar(String espacio){
		if(value != null){
			System.out.println(espacio+value);
			if(left != null) left.implMostrar(espacio+"  ");
			if(right != null) right.implMostrar(espacio+"  ");
		}
	}
	
	public void mostrar(){
		implMostrar("");
	}
	
	
}

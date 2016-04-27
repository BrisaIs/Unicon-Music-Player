package structure.tree;

import java.util.Comparator;

import model.song.Song;
import structure.tree.Node;

public class AVL implements Tree<Song>{
	Node root;
	private Comparator<Song> comparator;
	
	public AVL(Comparator<Song> c){
		comparator = c;
	}

	String recorrido;

	public int getBalanceFactor(Node root){
		if(root == null)
			return -1;
		else
			return root.balanceFactor;
	}

	public Node rotationToLeftImpl(Node c){
		Node aux = c.left;
		c.left = aux.right;
		aux.right = c;
		c.balanceFactor = Math.max(getBalanceFactor(c.left), getBalanceFactor(c.right))+1;
		aux.balanceFactor = Math.max(getBalanceFactor(aux.left), getBalanceFactor(aux.right))+1;
		return aux;
	}

	public Node rotationToRightImpl(Node c){
		Node aux = c.right;
		c.right = aux.left;
		aux.left = c;
		c.balanceFactor = Math.max(getBalanceFactor(c.left), getBalanceFactor(c.right))+1;
		aux.balanceFactor = Math.max(getBalanceFactor(aux.left), getBalanceFactor(aux.right))+1;
		return aux;
	}

	public Node rotationDoubleToLeftImpl(Node c){
		Node temp;
		c.left = rotationToRightImpl(c.left);
		temp = rotationToLeftImpl(c);
		return temp;
	}

	public Node rotationDoubleToRightImpl(Node c){
		Node temp;
		c.right = rotationToLeftImpl(c.right);
		temp = rotationToRightImpl(c);
		return temp;
	}


	@Override
	public void insert(Song a){
		Node nuevo = new Node(a);
		if(root == null)
			root = nuevo;
		else
			root = insert(nuevo,root);
	}
	
	private Node insert(Node newNode, Node father){
		Node nuevoPadre = father; 
		
		if(comparator.compare(newNode.value,father.value)<0){
			if(father.left == null) {
				father.left = newNode;
			}else{
				father.left = insert(newNode, father.left);
				if((getBalanceFactor(father.left)-getBalanceFactor(father.right)) == 2){
					if(comparator.compare(newNode.value,father.value)<0){
						nuevoPadre = rotationToLeftImpl(father);
					}else{
						nuevoPadre = rotationDoubleToLeftImpl(father);
					}
				}
			}
		}else if(comparator.compare(newNode.value,father.value)>0){
			if(father.right == null) {
				father.right = newNode;
			}else{
				father.right = insert(newNode, father.right);
				if((getBalanceFactor(father.right)-getBalanceFactor(father.left)) == 2){
					if(comparator.compare(newNode.value,father.value)>0){
						nuevoPadre = rotationToRightImpl(father);
					}else{
						nuevoPadre = rotationDoubleToRightImpl(father);
					}
				}
			}
		}

		if((father.left == null) && (father.right != null)) father.balanceFactor = getBalanceFactor(father.right)+1;
		else if((father.right == null) && (father.left != null)) father.balanceFactor = getBalanceFactor(father.left)+1;
		else father.balanceFactor = Math.max(getBalanceFactor(father.left),getBalanceFactor(father.right))+1;
		
		return nuevoPadre;
	}

	public String getTravel(Song a, Node root){
		String recorrido = root.value+"|";
		if(root.value != null){
			
			if(comparator.compare(root.value,a)==0)
				return recorrido;
			else if((comparator.compare(root.value,a)<0) && root.left != null){
				String r = getTravel(a,root.left);
				if(r != null) return recorrido+=r;
			}else if((comparator.compare(root.value,a)>0) && root.right != null){
				String r = getTravel(a, root.right);
				if(r != null) return recorrido+=r;
			}
		}
		return null;
	}
	
	public String getTravel(Song a){
		return getTravel(a,root);
		
	}
	
	private Song getImpl(Song a, Node raiz){
		if(raiz.value != null){
			if(comparator.compare(root.value,a)==0)
				return raiz.value;
			else if(comparator.compare(root.value,a)<0 && raiz.left != null){
				return getImpl(a,raiz.left);
			}else if(comparator.compare(root.value,a)>0 && raiz.right != null){
				return getImpl(a,raiz.right);
			}
		}
		return null;
	}
	
	@Override
	public Song get(Song a) {
		return getImpl(a,root);
	}

	@Override
	public boolean isEmpty() {
		return root.value == null;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}
	
	public String inOrdenImpl(Node raiz){
		if(raiz.value != null){
			if(raiz.left != null) inOrdenImpl(raiz.left);
			System.out.println(raiz.value);
			if(raiz.right != null) inOrdenImpl(raiz.right);
		}
		return "";
	}
	
	@Override
	public String inOrder() {
		return inOrdenImpl(root);
	}

	private String posOrdenImpl(Node raiz){
		recorrido = "";
		
		if(raiz.value != null){
			if(raiz.left != null) inOrdenImpl(raiz.left);
			if(raiz.right != null) inOrdenImpl(raiz.right);
			System.out.println(raiz.value);
		}
		return recorrido;
	}
	
	@Override
	public String posOrder() {
		return posOrdenImpl(root);
	}
	
	private String preOrdenImpl(Node raiz){
		recorrido = "";
		if(raiz.value != null){
			System.out.println(raiz.value);
			if(raiz.left != null) inOrdenImpl(raiz.left);
			if(raiz.right != null) inOrdenImpl(raiz.right);
		}
		return recorrido;
	}

	@Override
	public String preOrder() {
		return preOrdenImpl(root);
	}
	
	
	
	public void  implMostrar(String espacio, Node raiz){
		if(raiz.value != null){
			System.out.println(espacio+raiz.value);
			if(raiz.left != null) implMostrar(espacio+"  ",raiz.left);
			if(raiz.right != null) implMostrar(espacio+"  ", raiz.right);
		}
	}
	
	public void mostrar(){
		implMostrar("", root);
	}

	@Override
	public boolean exist(Song a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(Song a) {
		// TODO Auto-generated method stub
		
	}
	

}

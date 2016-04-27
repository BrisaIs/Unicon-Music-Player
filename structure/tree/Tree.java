package structure.tree;

public interface Tree<T> {
	public void insert(T a);
	public boolean exist(T a);
	public T get(T a);
	public boolean isEmpty();
	public boolean isLeaf();
	public String inOrder();
	public String posOrder();
	public String preOrder();
	public void remove(T a);
}

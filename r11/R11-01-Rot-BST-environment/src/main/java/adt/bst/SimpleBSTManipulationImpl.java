package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return equals((BSTNode<T>)tree1.getRoot(), (BSTNode<T>)tree2.getRoot());
	}

	public boolean equals(BSTNode<T> node1, BSTNode<T> node2)
	{
		boolean status = false;

		if (node1.isEmpty() && node2.isEmpty()) {
			status = true;
		}

		else if (!node1.isEmpty() && !node1.isEmpty()) {
			if (node1.equals(node2)) {
				status = equals((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft())
						&& equals((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
			}
		}
		return status;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return isSimilar((BSTNode<T>)tree1.getRoot(), (BSTNode<T>)tree2.getRoot());
	}
	private boolean isSimilar(BSTNode<T> node1, BSTNode<T> node2) {
		boolean status = false;

		if (node1.isEmpty() && node2.isEmpty()) {
			status = true;
		} else if (!node1.isEmpty() && !node2.isEmpty()) {
			status = isSimilar((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft())
					&& isSimilar((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
		}

		return status;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T myOrderStatisc = null;
		if (!(k > tree.size()))
		{
			myOrderStatisc = orderStatistic(tree,tree.minimum(), k);
		}
		return myOrderStatisc;
	}

	public T orderStatistic(BST<T> tree,BSTNode<T> node, int k)
	{
		T myElement = null;
		if (k == 1)
		{
			myElement = node.getData();
		}
		else{
			myElement = orderStatistic(tree,tree.sucessor(node.getData()), --k);
		}

		return myElement;
	}

}

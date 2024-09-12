package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
		BTNode<T> left = root.getLeft();
		BTNode<T> right = root.getRight();

		left = new BSTNode<T>();
		right = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() 
	{
		return height(root);
	}
	public int height(BSTNode<T> node)
	{
		int myHeight = 0;
		if (node.isEmpty())
		{
			myHeight = -1;
		}
		else if (node.isLeaf())
		{
			myHeight = 0;
		}
		else{
		
			myHeight += 1 + Math.max(height((BSTNode<T>)node.getLeft()),
									 height((BSTNode<T>)node.getRight()));
		}
		return myHeight;
		
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element, root);
	}

	public BSTNode<T> search(T element, BSTNode<T> node) {
		BSTNode<T> myElement = new BSTNode<T>();
		if (node.isEmpty())
		{}
		else if (node.getData().equals(element))
		{
			myElement = node;
		}
		else
		{
			if(node.getData().compareTo(element) > 0)
			{
				myElement = search(element,(BSTNode<T>)node.getRight());
			}
			else
			{
				myElement = search(element,(BSTNode<T>)node.getLeft());
			}
		}

		return myElement;
	}

	@Override
	public void insert(T element) {
		insert(element, root);
	}

	public void insert(T element, BSTNode<T> node)
	{
		if ((node.isLeaf()))
		{
			BSTNode<T> newNode = new BSTNode<T>();
			newNode.setData(element);
			newNode.setParent(node);

			if (node.getData().compareTo(element) > 0)
			{
				node.setRight(newNode);
				node.getRight().setLeft(new BSTNode<T>());
				node.getRight().setRight(new BSTNode<T>());
			}
			else{
				node.setLeft(newNode);
				node.getLeft().setLeft(new BSTNode<T>());
				node.getLeft().setRight(new BSTNode<T>());
			}	
		}
		else if((node.isEmpty() && node.getParent() != null))
		{
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());

			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		}
		else if (node.getParent() == null && node.isEmpty())
		{
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());

			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		}
		else{
			if (node.getData().compareTo(element) > 0)
			{
				insert(element, (BSTNode<T>)node.getRight());
			}
			else
			{
				insert(element, (BSTNode<T>)node.getLeft());
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> minimum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}

package adt.bst;

import java.util.ArrayList;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;
	private int indexOrder;

	public BSTImpl() {
		root = new BSTNode<T>();
		BTNode<T> left = root.getLeft();
		BTNode<T> right = root.getRight();

		left = new BSTNode<T>();
		right = new BSTNode<T>();
		indexOrder = 0;
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
				myElement = search(element,(BSTNode<T>)node.getLeft());
			}
			else
			{
				myElement = search(element,(BSTNode<T>)node.getRight());
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
				node.setLeft(newNode);
				node.getLeft().setLeft(new BSTNode<T>());
				node.getLeft().setRight(new BSTNode<T>());
			}
			else{
				node.setRight(newNode);
				node.getRight().setLeft(new BSTNode<T>());
				node.getRight().setRight(new BSTNode<T>());
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
				insert(element, (BSTNode<T>)node.getLeft());
			}
			else
			{
				insert(element, (BSTNode<T>)node.getRight());
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> myMaximum = null;
		if (!root.isEmpty())
		{
			myMaximum = maximum(root);
		}
		return myMaximum;
	}
	
	public BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> myMaximum = null;
		if(node.getRight().isEmpty() || node.isLeaf())
		{
			myMaximum = node;
		}
		else{
			myMaximum = maximum((BSTNode<T>)node.getRight());
		}
		return myMaximum;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> myMinimum = null;
		if (!root.isEmpty())
		{
			myMinimum = minimum(root);
		}
		return myMinimum;
	}

	public BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> myMinimum = null;
		if(node.getLeft().isEmpty() || node.isLeaf())
		{
			myMinimum = node;
		}
		else{
			myMinimum = minimum((BSTNode<T>)node.getLeft());
		}
		return myMinimum;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> mySucessor = null;
		
		if(search(element).getData() != null)
		{
			mySucessor = sucessor(element, root);
			if (mySucessor.equals(new BSTNode<T>()))
			{
				mySucessor = null;
			}	
		}
		return mySucessor;
	}

	public BSTNode<T> sucessor(T element, BSTNode<T> node) 
	{
		BSTNode<T> mySucessor = new BSTNode<T>();;
		
		if ( node.isEmpty() )
		{}
		else{
			if ( node.getData().equals(element) && !node.getRight().isEmpty())
			{
				mySucessor = minimum((BSTNode<T>)node.getRight());
			}	
			else
			{
				if (node.getData().compareTo(element) > 0)
				{
					mySucessor = sucessor(element, (BSTNode<T>)node.getLeft());
				}
				else{
					mySucessor = sucessor(element, (BSTNode<T>)node.getRight());
				}
				
			}
		}

		if( mySucessor.isEmpty()  && !node.isEmpty() 
		  && node.getData().compareTo(element) > 0 ) 
		{
			mySucessor = node;
		} 

		return mySucessor;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> myPredecessor = null;
		if (search(element).getData() != null)
		{
			myPredecessor = predecessor(element, root);
			if (myPredecessor.equals(new BSTNode<T>()))
			{
				myPredecessor = null;
			}	
		}

		return myPredecessor;
	}
	public BSTNode<T> predecessor(T element, BSTNode<T> node) {
		BSTNode<T> myPredecessor = new BSTNode<T>();
		
		if ( node.isEmpty() )
		{}
		else{
			if ( node.getData().equals(element) && !node.getLeft().isEmpty())
			{
				myPredecessor = maximum((BSTNode<T>)node.getLeft());
			}	
			else
			{
				if (node.getData().compareTo(element) < 0)
				{
					myPredecessor = predecessor(element, (BSTNode<T>)node.getRight());
				}
				else{
					myPredecessor = predecessor(element, (BSTNode<T>)node.getLeft());
				}
				
			}
		}

		if( myPredecessor.isEmpty()  && !node.isEmpty() 
		  && node.getData().compareTo(element) < 0 ) 
		{
			myPredecessor = node;
		} 

		return myPredecessor;
	}

	@Override
	public void remove(T element) {
		if(search(element).getData() != null)
		{
			remove(element, root);
		}
	}

	public void remove(T element, BSTNode<T> node) {

		if(node.getData().equals(element))
		{
			if(node.isLeaf())
			{
				node.setData(null);
			}
			else if(hasOnlyLeftChild(node) || hasOnlyRightChild(node))
			{
				
				if (hasOnlyLeftChild(node)){
					if(node.equals(root))
					{
						node = (BSTNode<T>)node.getLeft();
						node.setParent(null);
					}
					else{
						node.getParent().setLeft(node.getLeft());
						node.getLeft().setParent(node.getParent());
					}
					
				}
				else{
					if(node.equals(root))
					{
						node = (BSTNode<T>)node.getRight();
						node.setParent(null);
					}
					else{
						node.getParent().setRight(node.getRight());
						node.getRight().setParent(node.getParent());
					}
					
				}
			}
			else if(hasTwoChilds(node))
			{
				//if(!node.equals(root))
				//{
					BSTNode<T> auxSucessor = sucessor(element);
					node.setData(auxSucessor.getData());
					remove(auxSucessor.getData(), auxSucessor);
				//}
				// else{
				// 	node.setData(node.getRight().getData());
				// 	node.getRight().setLeft(node.getRight());
				// 	node.setParent(null);
				// }
			}	
		}
		else{
			if (node.getData().compareTo(element) < 0)
			{
				remove(element, (BSTNode<T>)node.getRight());
			}
			else{
				remove(element, (BSTNode<T>)node.getLeft());
			}
		}
		
	}

	private boolean hasOnlyLeftChild(BSTNode<T> node)
	{
		return node.getRight().isEmpty() && !node.getLeft().isEmpty();
	}
	private boolean hasOnlyRightChild(BSTNode<T> node)
	{
		return node.getLeft().isEmpty() && !node.getRight().isEmpty();
	}
	private boolean hasTwoChilds(BSTNode<T> node)
	{
		return !node.getLeft().isEmpty() && !node.getRight().isEmpty();
	}

	@Override
	public T[] preOrder() {
		indexOrder = 0;
		T[] myElements = (T[]) new Comparable[size()];
		preOrder(root, myElements);
		return myElements;
	}

	public void preOrder(BSTNode<T> node, T[] myArray) {
		if(node.isEmpty())
		{}
		else{
			visit(node, myArray);
			preOrder((BSTNode<T>)node.getLeft(), myArray);
			preOrder((BSTNode<T>)node.getRight(), myArray);
		}
	}

	public void visit(BSTNode<T> root, T[] myArray)
	{
		myArray[indexOrder++] = root.getData();
	}

	@Override
	public T[] order() {
		indexOrder = 0;
		T[] myElements = (T[]) new Comparable[size()];
		order(root, myElements);

		return myElements;
	}

	public void order(BSTNode<T> node, T[] array) 
	{
		if(!node.isEmpty())
		{
			order((BSTNode<T>)node.getLeft(), array);
			visit(node, array);
			order((BSTNode<T>)node.getRight(), array);
		}
	}

	@Override
	public T[] postOrder() {
		indexOrder = 0;
		T[] myElements = (T[]) new Comparable[size()];
		postOrder(root, myElements);

		return myElements;
	}

	public void postOrder(BSTNode<T> node, T[] array){
		if(!node.isEmpty())
		{
			postOrder((BSTNode<T>)node.getLeft(), array);
			postOrder((BSTNode<T>)node.getRight(), array);
			visit(node, array);
		}
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

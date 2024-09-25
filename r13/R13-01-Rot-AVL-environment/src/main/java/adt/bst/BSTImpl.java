package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(root);
	}
	public int height(BSTNode<T> root) {
		int myHeight = -1;
		if (root.isEmpty())
		{
			myHeight = -1;
		}
		else{
			myHeight = 1 + Math.max(height((BSTNode<T>)root.getLeft()),
									height((BSTNode<T>)root.getRight()));
		}

		return myHeight;
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element,root);
	}

	public BSTNode<T> search(T element, BSTNode<T> root)
	{
		BSTNode<T> myElement = new BSTNode<T>();
		if (root.isEmpty())
		{}
		else if(root.getData() == element)
		{
			myElement = root;
		}
		else{
			if(root.getData().compareTo(element) > 0)
			{
				search(element, (BSTNode<T>)root.getLeft());
			}
			else{
				search(element, (BSTNode<T>)root.getRight());
			}
		}

		return myElement;
	}

	@Override
	public void insert(T element) {
		insert(element, root);
	}

	public void insert(T element, BSTNode<T> root)
	{
		if(search(element).equals(new BSTNode<T>()))
		{
			if(root.isEmpty())
			{
				if(root.getParent() == null)
				{
					this.root = root;
				}		
				root.setData(element);
				root.setLeft(new BSTNode<T>());
				root.setRight(new BSTNode<T>());
				root.getLeft().setParent(root);
				root.getRight().setParent(root);
			}
			else{
				if(root.getData().compareTo(element) > 0)
				{
					insert(element, (BSTNode<T>)root.getLeft());
				}
				else{
					insert(element, (BSTNode<T>)root.getRight());
				}
			}
		}
			
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(root);
	}

	public BSTNode<T> maximum(BSTNode<T> root)
	{
		BSTNode<T> myMaximum = new BSTNode<T>();
		if (root.isEmpty() && root.getParent() != null)
		{
			myMaximum = (BSTNode<T>)root.getParent();
		}
		else{
			myMaximum = maximum((BSTNode<T>)root.getRight());
		}

		return myMaximum;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(root);
	}

	public BSTNode<T> minimum(BSTNode<T> root)
	{
		BSTNode<T> myMinimum = new BSTNode<T>();
		if (root.isEmpty() && root.getParent() != null)
		{
			myMinimum = (BSTNode<T>)root.getParent();
		}
		else{
			myMinimum = minimum((BSTNode<T>)root.getLeft());
		}
		return myMinimum;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> myElement = search(element);
		BSTNode<T> mySucessor = null;
		if(myElement != new BSTNode<T>() &&
		  myElement.getRight() != new BSTNode<T>())
		{
			mySucessor = minimum(myElement);
		}
		else
		{
			if(myElement.getParent() != null)
			{
				BSTNode<T> aux = (BSTNode<T>)myElement.getParent();
				while(aux.getData().compareTo(element) < 0)
				{
					aux = (BSTNode<T>)aux.getParent();
				}
				mySucessor = aux;
			}	
		}

		return mySucessor;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> myElement = search(element);
		BSTNode<T> myPredecessor = null;

		if(myElement != new BSTNode<T>() &&
		  myElement.getLeft() != new BSTNode<T>())
		{
			myPredecessor = maximum(myElement);
		}
		else{
			if(myElement.getParent() != null)
			{
				BSTNode<T> aux = (BSTNode<T>)myElement.getParent();
				while(aux.getData().compareTo(element) > 0)
				{
					aux = (BSTNode<T>)aux.getParent();
				}
				myPredecessor = aux;
			}
		}

		return myPredecessor;

	}

	@Override
	public void remove(T element) {
		remove(element, root);
	}

	public void remove(T element, BSTNode<T> root)
	{
		if(search(element) != new BSTNode<T>())
		{
			if(root.getData().equals(element))
			{
				if(root.isLeaf())
				{
					root = new BSTNode<T>();
				}
				else if(hasOnlyLeftChild(root) || hasOnlyRightChild(root))
				{
					if(root.getParent() == null)
					{
						root = new BSTNode<T>();
					}
					else{
						if(root.getParent().getData().compareTo(root.getData()) > 0)
						{
							
							if(hasOnlyLeftChild(root))
							{
								root.getLeft().setParent(root.getParent());
								root.getParent().setLeft(root.getLeft());
							}
							else{
								root.getRight().setParent(root.getParent());
								root.getParent().setLeft(root.getRight());
							}
						}
						else{
							if (hasOnlyLeftChild(root))
							{
								root.getLeft().setParent(root.getParent());
								root.getParent().setRight(root.getLeft());
							}
							else{
								root.getRight().setParent(root.getParent());
								root.getParent().setRight(root.getRight());
							}
						}
					}
				}
				else{
					if(root.getParent() != null)
					{
						BSTNode<T> sucessor = sucessor(element);
						T aux = sucessor.getData();
						sucessor.setData(root.getData());
						root.setData(aux);

						remove(element);
					}
					else{
						root = new BSTNode<T>();
					}
					
				}
			}
			
		}
		else{
			if(root.getData().compareTo(element) > 0)
			{
				remove(element, (BSTNode<T>)root.getLeft());
			}
			else{
				remove(element, (BSTNode<T>)root.getRight());
			}
		}
	}

	public boolean hasOnlyLeftChild(BSTNode<T> node)
	{
	 return !node.getLeft().equals(new BSTNode<T>()) &&
	 node.getRight().equals(new BSTNode<T>());
	}
	public boolean hasOnlyRightChild(BSTNode<T> node)
	{
		return !node.getRight().equals(new BSTNode<T>()) &&
		node.getLeft().equals(new BSTNode<T>());
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

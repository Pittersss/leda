package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		return height((BSTNode<T>)node.getLeft()) - height((BSTNode<T>)node.getRight());
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		if(calculateBalance(node) < -1 || calculateBalance(node) > 1)
		{
			if(calculateBalance(node) > 1 &&
			  (isLeftPending((BSTNode<T>)node.getLeft()) || isBalanced(node)))
			{
				node.setParent(node.getLeft());
				root = (BSTNode<T>)node.getLeft();
				node.getLeft().setParent(null);
				if(!node.getLeft().getRight().isEmpty())
				{
					BSTNode<T> aux = (BSTNode<T>)node.getLeft().getRight();
					aux.setParent(node);
					node.getLeft().setRight(node);
					node.setLeft(aux);
				}
				else{
					node.getLeft().setRight(node);
					node.setLeft(new BSTNode<T>());
				}
				

			}
		}
	}

	

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public boolean isLeftPending(BSTNode<T> node)
	{
		return calculateBalance(node) ==  1;
	}
	public boolean isRightPending(BSTNode<T> node)
	{
		return calculateBalance(node) ==  -1;
	}
	public boolean isBalanced(BSTNode<T> node)
	{
		return calculateBalance(node) == 0;
	}
}

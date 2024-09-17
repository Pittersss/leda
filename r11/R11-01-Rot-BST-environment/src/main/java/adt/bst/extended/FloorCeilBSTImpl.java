package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		int index = array.length - 1;
		fillTree(index, array, numero);
		return floor(root, numero);

	}
	public Integer floor(BSTNode<Integer> node, double numero) 
	{
		Integer myNumber = null;
		if(node.getData() == null)
		{}
		else if (node.isLeaf())
		{
			myNumber = node.getData();
		}
		else
		{
			if (node.getData() == numero)
			{
				myNumber = node.getData();
			}
			else if(node.getData() < numero)
			{
				myNumber = floor((BSTNode<Integer>)node.getRight(), numero);
			}
			else{
				myNumber = floor((BSTNode<Integer>)node.getLeft(), numero);
			}
		}
		
		return myNumber;
	}

	public void fillTree(Integer index, Integer[] array, double numero)
	{
		if (index == -1)
		{}
		else{
			if(array[index] <= numero)
			{
				insert(array[index]);
			}
			fillTree(--index, array, numero);
		}
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		//TODO Implemente seu codigo aqui
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}

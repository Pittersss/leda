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
	public Integer ceil(Integer[] array, double numero) 
	{
		Integer myCeil = null;
		if (array.length != 0)
		{
			myCeil = ceil(array, numero, 0, null);
		}
		
		return myCeil;
	}

	public Integer ceil(Integer[] array, double numero, int index, Integer ceil) 
	{
		Integer myCeil = ceil;
		if(!verifyValidIndex(index + 1, array))
		{
			if (array[index] >= numero)
			{
				if (myCeil != null && array[index] < myCeil)
				{
					myCeil = array[index];
				}
				else{
					myCeil = array[index];
				}	
			}
		}
		else{
			if (verifyValidIndex(index + 1, array) && verifyValidIndex(index + 2, array))
			{
				int biggest = index + 2;
				myCeil = array[index];
				if (array[index + 1] > array[biggest])
				{
					biggest = index + 1;
				}

				if(array[biggest] >= numero)
				{
					if (myCeil != null && array[biggest] < myCeil)
					{
						myCeil = array[biggest];
					}	
				}
				ceil(array, numero, biggest, myCeil);
			}
			else if(verifyValidIndex(index + 1, array))
			{	
				if (array[index + 1] >= numero)
				{
					if (myCeil != null && array[index + 1] < myCeil)
					{
						myCeil = array[index + 1];
					}	
				}		
				ceil(array, numero, index + 1, myCeil);
			}
		}

		return myCeil;
	}

	private boolean verifyValidIndex(int index, Integer[] array)
	{
		return index < array.length;
	}

}

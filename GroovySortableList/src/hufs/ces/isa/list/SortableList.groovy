package hufs.ces.isa.list

import java.util.ArrayList
import java.util.Comparator
import java.util.Collection
import java.util.Iterator
import java.util.List
import java.util.ListIterator

class SortableList<E> extends ArrayList<E> {
	
	public SortableList() {
		super();
	}
	public SortableList(List<E> list) {
		super(list);
	}
	public void sort(Comparator<E> c) {
		SortAlgorithms.quickSort(this, c);
	}
	public void sort() {
		SortAlgorithms.quickSort(this);		
	}
	public void sort5() {
		SortAlgorithms.selectionSort(this);
	}

}

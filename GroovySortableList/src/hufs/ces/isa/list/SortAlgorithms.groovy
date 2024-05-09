package hufs.ces.isa.list

import java.util.ArrayList
import java.util.Comparator
import java.util.List

class SortAlgorithms {

	static public <T> void quickSort(ArrayList<Comparable<T>> list) {
		int n = list.size();
		if (n < 2)
			return;

		ArrayList<Comparable<T>> list1 = new ArrayList<>();
		ArrayList<Comparable<T>> list2 = new ArrayList<>();
		ArrayList<Comparable<T>> listEq = new ArrayList<>();

		T pivot = list.get(0);

		while (!list.isEmpty()) {
			if (list.get(0) < pivot) {
				list1.add(list.get(0));
			}
			else if (list.get(0) == pivot) {
				listEq.add(list.get(0));
			}
			else {
				list2.add(list.get(0));
			}
			list.remove(0);
		}
		quickSort(list1);
		quickSort(list2);

		list.addAll(list1);
		list.addAll(listEq);
		list.addAll(list2);
	}
	static public <T> void quickSort(ArrayList<T> list, Comparator<T> comp) {
		int n = list.size();
		if (n < 2)
			return;

		ArrayList<T> list1 = new ArrayList<T>();
		ArrayList<T> list2 = new ArrayList<T>();
		ArrayList<T> listEq = new ArrayList<T>();

		T pivot = list[0];

		while (!list.isEmpty()) {
			//println "${list[0]},${list[0].getClass()} -- ${pivot}, ${pivot.getClass()} "
			if (comp.compare(list[0],pivot) < 0) {
				list1.add(list[0]);
			}
			else if (comp.compare(list[0],pivot) == 0) {
				listEq.add(list[0]);
			}
			else {
				list2.add(list[0]);
			}
			list.remove(0);
		}
		quickSort(list1, comp);
		quickSort(list2, comp);

		list.addAll(list1);
		list.addAll(listEq);
		list.addAll(list2);

	}
	static public <T> void selectionSort(ArrayList<Comparable<T>> list) {

		int lsize = list.size();
		for (int i=0; i<lsize; ++i){
			int minit = getMinIndex(list, i);
			swapNode(list, i, minit);
		}
	}
	static public <T> void selectionSort(ArrayList<T> list, Comparator<T> comp) {
		int lsize = list.size();
		for (int i=0; i<lsize; ++i){
			int minit = getMinIndex(list, i, comp);
			swapNode(list, i, minit);
		}
	}

	static private <T> void swapNode(ArrayList<T> list, int p, int q) {
		T tempNode = list.get(p);
		list.set(p, list.get(q));
		list.set(q, tempNode);
	}
	static private <T> int getMinIndex(ArrayList<Comparable<T>> list, int rest) {
		assert rest >= 0 && rest < list.size();
		int minInd = rest;
		for (int i=rest+1; i<list.size(); ++i) {
			if (list.get(i) < list.get(minInd)) {
				minInd = i;
			}
		}
		return minInd;
	}
	static private <T> int getMinIndex(ArrayList<T> list, int rest, Comparator<T> comp) {
		assert rest >= 0 && rest < list.size();
		int minInd = rest;
		for (int i=rest+1; i<list.size(); ++i) {
			if (comp.compare(list.get(i),list.get(minInd)) < 0) {
				minInd = i;
			}
		}
		return minInd;
	}

}

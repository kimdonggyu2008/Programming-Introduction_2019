package hufs.ces.sort.closure

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
		//!list.isEmpty()
		while (!list.isEmpty()) {
			//println "${list[0]},${list[0].getClass()} -- ${pivot}, ${pivot.getClass()} "
			int num=comp.compare(list[0],pivot)
			if (num < 0) {
				list1.add(list[0]);
			}
			else if (num == 0) {
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
	static public <T> void selectionSort(ArrayList<Comparable<T>> list, getMinIndex) {

		int lsize = list.size();
		for (int i=0; i<lsize; ++i){
			int minit = getMinIndex(list, i);
			list.swap(i, minit);
		}
	}
	static public <T> void selectionSort(ArrayList<T> list, Comparator<T> comp, getMinIndex) {
		int lsize = list.size();
		for (int i=0; i<lsize; ++i){
			int minit = getMinIndex(list, i, comp);
			list.swap(i, minit);
		}
	}

	static void sortTest(SortableList list) {
		printList(list);
		//list.sort5()
		list.sort5(new Comparator<Card>() {
			public int compare(Card left, Card right){
				return left.toString().compareTo(right.toString());}})
		printList(list);

	}
	static void printList(List list) {
		final int  LINE_MAX = 13;
		int i = 0;
		for (Card c:list) {
			//print "$c ";
			i++;
			if (i % LINE_MAX == 0) println();
		}
		println();
	}
	static main(args) {
		def deck = [];
		// Make a Card Deck
		for (int s=Card.CLUB; s<=Card.SPADE; s++) {
			for (int r=Card.ACE; r<=Card.KING; r++){
				deck.add(new Card(s,r));
			}
		}		
		sortTest(new SortableList(deck));
	}

}

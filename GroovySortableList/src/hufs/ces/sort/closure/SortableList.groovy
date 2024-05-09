package hufs.ces.sort.closure

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
	def getMinIndex = { list, int rest ->
		assert rest >= 0 && rest < list.size();
		int minInd = rest;
		for (int i=rest+1; i<list.size(); ++i) {
			if (list.get(i) < list.get(minInd)) {
				minInd = i;
			}
		}
		minInd
	}
	def getMinIndexWithComp = { list, rest, comp ->
		assert rest >= 0 && rest < list.size();
		int minInd = rest;
		//
		for (int i=rest+1; i<list.size(); ++i) {
			if (comp.compare(list.get(i),list.get(minInd)) < 0) {
				minInd = i;
			}
		}
		minInd
	}
	

	public void sort5() {
		SortAlgorithms.selectionSort(this, getMinIndex);
	}
	public void sort5(Comparator<E> comp) {
		SortAlgorithms.selectionSort(this, comp, getMinIndexWithComp);
	}

}

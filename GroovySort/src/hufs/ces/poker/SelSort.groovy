package hufs.ces.poker

class SelSort<T> implements ISorter<T> {
	
	private List<T> list = null;

	public SelSort(List<T> list) {
		this.list = list.clone();
	}

	@Override
	public List<T> sort() {

		int lsize = list.size();
		for (int i=0; i<lsize; ++i){
			int minit = getMinIndex(i);
			swapNode(i, minit);
		}
		return list;
	}
	@Override
	public List<T> sort(Comparator<T> comp) {
		int lsize = list.size();
		for (int i=0; i<lsize; ++i){
			int minit = getMinIndex(i, comp);
			swapNode(i, minit);
		}
		return list;
	}
	
	private void swapNode(int p, int q) {
		T tempNode = list[p];
		list.set(p, list[q]);
		list.set(q, tempNode);
	}
	private int getMinIndex(int rest) {
		assert rest >= 0 && rest < list.size();
		int minInd = rest;
		for (int i=rest+1; i<list.size(); ++i) {
			if (list[i] < list[minInd]) {
				minInd = i;
			}
		}
		return minInd;
	}
	private int getMinIndex(int rest, Comparator<T> comp) {
		assert rest >= 0 && rest < list.size();
		int minInd = rest;
		for (int i=rest+1; i<list.size(); ++i) {
			if (comp.compare(list[i],list[minInd]) < 0) {
				minInd = i;
			}
		}
		return minInd;
	}

}

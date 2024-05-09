package hufs.ces.hasa.list

import java.util.Comparator

class FiveCardsComparator implements Comparator<FiveCards> {
	int compare (FiveCards left, FiveCards right) {
		return left.compareTo(right);
	}
}

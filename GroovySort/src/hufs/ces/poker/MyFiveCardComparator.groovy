package hufs.ces.poker

class MyFiveCardComparator implements Comparator<FiveCards> {
	
	public int compare(FiveCards left, FiveCards right) {//Ã¹¹øÂ°²¨ÇÏ°í ÇÇ¹þ
		int k;
		k= left.fiveCards[0].compareTo(right.fiveCards[0]);
			if(k==0)
			{
				k=left.fiveCards[1].compareTo(right.fiveCards[1]);
				if(k==0)
				{
					k=left.fiveCards[2].compareTo(right.fiveCards[2]);
						if(k==0)
						{
							k=left.fiveCards[3].compareTo(right.fiveCards[3]);
							if(k==0)
								return left.fiveCards[3].compareTo(right.fiveCards[3]);
						}
						return left.fiveCards[2].compareTo(right.fiveCards[2]);
				}
				return left.fiveCards[1].compareTo(right.fiveCards[1]);
			}
			return left.fiveCards[0].compareTo(right.fiveCards[0]);
		//return left.fiveCards[0].compareTo(right.fiveCards[0]);
	}
		
		/*if(left.fiveCards[0].compareTo(right.fiveCards[0]))
		{
			if(left.fiveCards[1].compareTo(right.fiveCards[1]))
			{
				if(left.fiveCards[2].compareTo(right.fiveCards[2]))
				{
					if(left.fiveCards[3].compareTo(right.fiveCards[3]))
					{
						return left.fiveCards[3].compareTo(right.fiveCards[3]);
					}
					return left.fiveCards[2].compareTo(right.fiveCards[2]);
				}
				return left.fiveCards[1].compareTo(right.fiveCards[1]);
			}
			return left.fiveCards[0].compareTo(right.fiveCards[0]);
		}
		
		return 0;*/
	
}

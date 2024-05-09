package hufs.ces.sort.closure

class SortTest5Cards {

	static main(args) {
		sortTest5Cards()
	}
	
	static SortableList<FiveCards> generate5CardList(int gencount) {

		// Generate List<FiveCards>
		SortableList<FiveCards> p5CardsList = new SortableList<FiveCards>();
		ArrayList<Card> deckCard = new ArrayList<Card>();
		
		// Make a Card Deck
		for (int s=Card.CLUB; s<=Card.SPADE; s++)
			for (int r=Card.ACE; r<=Card.KING; r++){
				deckCard.add(new Card(s,r));
			}

		for (int i=1; i<=gencount; i++) {

			suffle(deckCard);

			// Make a Card Deck
			int indDeck = 0;

			Card[] fc = new Card[5];
			int ipos = 0;
			while (indDeck < deckCard.size()) {
				fc[ipos] = deckCard.get(indDeck);
				indDeck++;
				ipos++;
				if (ipos == 5) {
					p5CardsList.add(new FiveCards(fc));
					ipos = 0;
				}
			}
		}
		return p5CardsList;
	}
	static void suffle (ArrayList<Card> list) {
		final int  SUFFLECOUNT = 100;

		//println "List before Suffle"
		//printList(list);
		Random rand = new Random(1234);
		int oneOrzero = 0;
		int lsize = list.size();
		int ind = 0;
		for (int i=1; i <= SUFFLECOUNT*lsize; i++) {
			// random number  0 or 1
			oneOrzero = rand.nextInt(2);
			//println "ind=$ind rand=$oneOrzero card=${list.get(ind)}"
			if (oneOrzero == 0) {
				// move to back
				list.add(list.remove(ind));
			}
			else {
				ind++;
				ind %= lsize;
			}
		}
		//println "List after Suffle"
		//printList(list);
	}
	static void printFiveCardsList(List<FiveCards> fcList) {
		int ccount = 0;
		for (FiveCards fc : fcList) {
			println "${++ccount} $fc";
		}
	}
	static void sortTest5Cards() {
		println "Sort Test 5 Cards";
		SortableList<FiveCards> list5card = generate5CardList(10);
		SortableList<Card> m = generate5CardList(1);
		// Add more sample data
		
		Card[] fourCards = [new Card(1,1), new Card(2,1), new Card(3,1), new Card(4,1), new Card(1,13)];
		list5card.add(new FiveCards(fourCards));

		Card[] fullhouse = [new Card(1,1), new Card(2,1), new Card(3,1), new Card(4,13), new Card(1,13)];
		list5card.add(new FiveCards(fullhouse));

		Card[] straight = [new Card(1,1), new Card(2,2), new Card(3,3), new Card(4,4), new Card(1,5)];
		list5card.add(new FiveCards(straight));

		Card[] flush = [new Card(1,1), new Card(1,2), new Card(1,3), new Card(1,4), new Card(1,6)];
		list5card.add(new FiveCards(flush));

		Card[] straightflush = [new Card(1,1), new Card(1,2), new Card(1,3), new Card(1,4), new Card(1,5)];
		list5card.add(new FiveCards(straightflush));

		Card[] threeofakind = [new Card(1,1), new Card(2,1), new Card(3,1), new Card(4,10), new Card(1,2)];
		list5card.add(new FiveCards(threeofakind));

		Card[] twopair = [new Card(1,1), new Card(2,1), new Card(3,10), new Card(4,10), new Card(1,2)];
		list5card.add(new FiveCards(twopair));

		Card[] onepair = [new Card(1,1), new Card(2,1), new Card(3,4), new Card(4,5), new Card(1,6)];
		list5card.add(new FiveCards(onepair));

		Card[] nopair = [new Card(1,1), new Card(2,3), new Card(3,5), new Card(4,7), new Card(1,9)];
		list5card.add(new FiveCards(nopair));
		
		// Display the Deck
		println "FiveCards before Sort";
		printFiveCardsList(list5card);
		// List Test
		/*String temp;
		for(int i=0;i<list5card.size();i++)
		{
			temp=list5card[i].change(new FiveCardsComparator());
		}*/
		//temp.sort(new FiveCardsComparator());
		println "FiveCards after Sort";
		//println"$temp"
		
		list5card.sort(new FiveCardsComparator());
		FiveCards left;
		for(int u=0;u<list5card.size();u++)
		{
			m[0]=list5card[u];
			left=m[0];
			int same2=0,same3=0,recent,temp1=0,temp2=0,count=0;
			ArrayList<Integer> ltemp = new ArrayList<Integer>();
			ArrayList<Integer> rtemp = new ArrayList<Integer>();
			//SortableList<FiveCards> temp = new SortableList<FiveCards>();
			//println"�ϴ� �����"
			for(int i=0;i<5;i++)
			{
				recent=left.fiveCards[i].rank;
				if(recent==temp1&&i<4)
				{
					recent==left.fiveCards[i+1].rank;
				}
				//println"����Ʈ $recent"
				for(int k=1+i;k<5;k++)
				{
					int rrecent=left.fiveCards[k].rank;
					//println"���� $recent ������ $rrecent"
					if(rrecent==recent)
					{
						count++;
					}
				}
				if(count>0)
					{
						if(temp1!=0)
						{
							temp2=recent;
						}
						else
						{
							temp1=recent;
						}
					}
					
				if(count==1)
				{
					same2++;
					//println"2�� ������ ����"
				}
				if(count==2)
				{
					same2--;
					same3++;
					//println"3�� ������ ����"
				}
				if(count==3)
				{
					//println"��ī��"
					/*String temp = "[6, ";
					temp += temp1;
					if(left.fiveCards[4].rank!=temp1)
					{
						temp+=", ";
						 temp += left.fiveCards[4].rank;
					}
					if(left.fiveCards[3].rank!=temp1)
					{
						temp+=", ";
						 temp += left.fiveCards[3].rank;
					}
					if(left.fiveCards[2].rank!=temp1)
					{
						temp+=", ";
						 temp += left.fiveCards[2].rank;
					}
					if(left.fiveCards[1].rank!=temp1)
					{
						temp+=", ";
						  temp += left.fiveCards[1].rank;
					}
					if(left.fiveCards[0].rank!=temp1)
					{
						temp+=", ";
						 temp += left.fiveCards[0].rank;
					}
					temp += "]";
					*/
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp=[6,temp1];
					
					if(left.fiveCards[4].rank!=temp1)
					{
						temp.add(left.fiveCards[4].rank);
					}
					if(left.fiveCards[3].rank!=temp1)
					{
						temp.add(left.fiveCards[3].rank);
					}
					if(left.fiveCards[2].rank!=temp1)
					{
						temp.add(left.fiveCards[2].rank);
					}
					if(left.fiveCards[1].rank!=temp1)
					{
						temp.add(left.fiveCards[1].rank);
					}
					if(left.fiveCards[0].rank!=temp1)
					{
						temp.add(left.fiveCards[0].rank);
					}
					//println"$temp"
					
						ltemp=temp;
	
				}
				//println"ī��Ʈ�� $count"
				count=0;
				//println"���� same2= $same2 same3= $same3"
			}
			//println"���� ���� ī�� ���´� $left.fiveCards"
			//println"����� �� 1.   $temp1 ,2.   $temp2"
			//println"���� ����� same2= $same2 same3= $same3"
	
			
			if(same2<0)
			{
				same2=0;
			}
			if(same2==0&&same3==0)//2�� ���� �� ����, 3�� ���� �͵� ������ - �����
			{
				//println"�����"
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp=[1,left.fiveCards[4].rank,left.fiveCards[3].rank,left.fiveCards[2].rank,left.fiveCards[1].rank,left.fiveCards[0].rank];
				//println"$temp"
				/*String temp = "[1";
				for(int i=4; i>=0; i--) {
					if ( i != -1 ) temp+=", ";
					temp += left.fiveCards[i].rank;
			   }
			   temp += "]";*/
				//println"$temp"
						ltemp=temp;
			}
			else if(same2==1&&same3==0)//2�� ���� �� �Ѱ�, 3�� ������ 0�� - �����
			{
				//println"�����"
				/*String temp = "[2";
				temp+=", ";
				temp += temp1;
				for(int i=4; i>=0; i--) {
					if ( left.fiveCards[i].rank!=temp1)
					{
						 temp+=", ";
						 temp += left.fiveCards[i].rank;
					}
			   }
			   temp += "]";*/
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp=[2,temp1];
				for(int i=4;i>=0;i--)
				{
					if(left.fiveCards[i].rank!=temp1)
					{
						temp.add(left.fiveCards[i].rank);
					}
				}
				
						ltemp=temp;
			 // println"$temp"
			}
			else if(same2==2&&same3==0)//2�� ���� �� 2��, 3�� ������ 0�� - ����� ---���̵�� �ʿ�
			{
				//println"�����"
				/*String temp = "[3";
				temp+=", ";
				temp += temp1;
				temp+=", ";
				temp += temp2;
				for(int i=4; i>=0; i--) {
					if (temp1!=left.fiveCards[i].rank&&temp2!=left.fiveCards[i].rank)
						{
							temp+=", ";
							temp += left.fiveCards[i].rank;
					}
			   }
			   temp += "]";*/
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp=[3,temp1,temp2];
				
				for(int i=4;i>=0;i--)
				{
					if(temp1!=left.fiveCards[i].rank&&temp2!=left.fiveCards[i].rank)
					{
						temp.add(left.fiveCards[i].rank);
					}
				}
				//println"$temp"
						ltemp=temp;
			}
			
		
			else if(same2==0&&same3==1)//2�� ���� 0��, 3�� ���� 1�� - Ʈ����
			{
				//println"Ʈ����"
				/*String temp = "[4";
				temp+=", ";
				temp += temp1;
				for(int i=4; i>=0; i--) {
					if ( left.fiveCards[i].rank!=temp1 )
						{
							temp+=", ";
							temp += left.fiveCards[i].rank;
						}
			   }
			   temp += "]";*/
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp=[4,temp1];
				for(int i=4;i>=0;i--)
				{
					if(temp1!=left.fiveCards[i].rank)
					{
						temp.add(left.fiveCards[i].rank);
					}
				}
				//println"$temp"
				
						ltemp=temp;
			}
			else if(same2==1&&same3==1)//2�� ������ 1��, 3�� ������ 1�� - Ǯ�Ͽ콺
			{
				//println"Ǯ�Ͽ콺"
				/*String temp = "[5";
					temp +=", ";
					temp += temp1;
					temp +=", ";
					temp += temp2;
					temp +=	"]";*/
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp=[5,temp1,temp2];
					//println"$temp"
							ltemp=temp;
			}
			
			println"$ltemp";
		}
		
		
		
		//printFiveCardsList(list5card);
		

	}

}

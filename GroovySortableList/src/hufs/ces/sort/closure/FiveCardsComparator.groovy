package hufs.ces.sort.closure
import java.util.ArrayList;
/*
class FiveCardsComparator implements Comparator<FiveCards> {
 int compare (FiveCards left, FiveCards right) {
	 int k=0;
	 for(FiveCards le:left)
	 {
		 println"출력중 ${++k}$le"
	 }
	 return left.compareTo(right);
 }
}
*/
class FiveCardsComparator implements Comparator<FiveCards> {
	int compare (FiveCards left,FiveCards right) {
		//println"받은 왼쪽$left.fiveCards"
		//println"받은 오른쪽$right.fiveCards"
		int same2=0,same3=0,recent,temp1=0,temp2=0,count=0;
		ArrayList<Integer> ltemp = new ArrayList<Integer>();
		ArrayList<Integer> rtemp = new ArrayList<Integer>();
		//SortableList<FiveCards> temp = new SortableList<FiveCards>();
		//println"일단 실행됨" 
		for(int i=0;i<5;i++)
		{
			recent=left.fiveCards[i].rank;
			if(recent==temp1&&i<4)
			{
				recent==left.fiveCards[i+1].rank;
			}
			//println"리센트 $recent"
			for(int k=1+i;k<5;k++)
			{
				int rrecent=left.fiveCards[k].rank;
				//println"왼쪽 $recent 오른쪽 $rrecent"
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
				//println"2번 같은거 실행"
			}
			if(count==2)
			{
				same2--;
				same3++;
				//println"3번 같은거 실행"
			}
			if(count==3)
			{
				//println"포카드"
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
			//println"카운트는 $count"
			count=0;
			//println"현재 same2= $same2 same3= $same3"
		}
		//println"현재 왼쪽 카드 형태는 $left.fiveCards"
		//println"저장된 값 1.   $temp1 ,2.   $temp2"
		//println"왼쪽 결과용 same2= $same2 same3= $same3"

		
		if(same2<0)
		{
			same2=0;
		}
		if(same2==0&&same3==0)//2개 같은 게 없고, 3개 같은 것도 없을때 - 노페어
		{
			//println"노페어"
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
		else if(same2==1&&same3==0)//2개 같은 것 한개, 3개 같은것 0개 - 원페어
		{
			//println"원페어"
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
		else if(same2==2&&same3==0)//2개 같은 것 2개, 3개 같은거 0개 - 투페어 ---아이디어 필요
		{
			//println"투페어"
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
		
	
		else if(same2==0&&same3==1)//2개 같음 0개, 3개 같음 1개 - 트리플
		{
			//println"트리플"
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
		else if(same2==1&&same3==1)//2개 같은거 1개, 3개 같은거 1개 - 풀하우스
		{
			//println"풀하우스"
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
		
		
		//오른쪽
		same2=0;
		same3=0;
		temp1=0;
		temp2=0;
		count=0;
		for(int i=0;i<5;i++)
			{
				recent=right.fiveCards[i].rank;
				if(recent==temp1&&i<4)
				{
					recent==right.fiveCards[i+1].rank;
				}
				//println"리센트 $recent"
				for(int k=1+i;k<5;k++)
				{
					int rrecent=right.fiveCards[k].rank;
					//println"왼쪽 $recent 오른쪽 $rrecent"
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
					//println"2번 같은거 실행"
				}
				if(count==2)
				{
					same2--;
					same3++;
					//println"3번 같은거 실행"
				}
				if(count==3)
				{
					//println"포카드"
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
					
					if(right.fiveCards[4].rank!=temp1)
					{
						temp.add(right.fiveCards[4].rank);
					}
					if(right.fiveCards[3].rank!=temp1)
					{
						temp.add(right.fiveCards[3].rank);
					}
					if(right.fiveCards[2].rank!=temp1)
					{
						temp.add(left.fiveCards[2].rank);
					}
					if(right.fiveCards[1].rank!=temp1)
					{
						temp.add(right.fiveCards[1].rank);
					}
					if(right.fiveCards[0].rank!=temp1)
					{
						temp.add(right.fiveCards[0].rank);
					}
					//println"$temp"
						rtemp=temp;
					
				}
				//println"카운트는 $count"
				count=0;
				//println"현재 same2= $same2 same3= $same3"
			}
			//println"현재 오른쪽 카드 형태는 $right.fiveCards"
			//println"저장된 값 1.   $temp1 ,2.   $temp2"
			//println"오른쪽 결과용 same2= $same2 same3= $same3"
	
			
			if(same2<0)
			{
				same2=0;
			}
			if(same2==0&&same3==0)//2개 같은 게 없고, 3개 같은 것도 없을때 - 노페어
			{
				//println"노페어"
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp=[1,right.fiveCards[4].rank,right.fiveCards[3].rank,right.fiveCards[2].rank,right.fiveCards[1].rank,right.fiveCards[0].rank];
				//println"$temp"
				/*String temp = "[1";
				for(int i=4; i>=0; i--) {
					if ( i != -1 ) temp+=", ";
					temp += left.fiveCards[i].rank;
			   }
			   temp += "]";*/
				//println"$temp";
				rtemp=temp;
			}
			else if(same2==1&&same3==0)//2개 같은 것 한개, 3개 같은것 0개 - 원페어
			{
				//println"원페어"
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
					if(right.fiveCards[i].rank!=temp1)
					{
						temp.add(right.fiveCards[i].rank);
					}
				}
				
				rtemp=temp;
			 // println"$temp"
			}
			else if(same2==2&&same3==0)//2개 같은 것 2개, 3개 같은거 0개 - 투페어 ---아이디어 필요
			{
				//println"투페어"
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
					if(temp1!=right.fiveCards[i].rank&&temp2!=right.fiveCards[i].rank)
					{
						temp.add(right.fiveCards[i].rank);
					}
				}
				//println"$temp"
						rtemp=temp;
			}
			else if(same2==0&&same3==1)//2개 같음 0개, 3개 같음 1개 - 트리플
			{
				//println"트리플"
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
					if(temp1!=right.fiveCards[i].rank)
					{
						temp.add(right.fiveCards[i].rank);
					}
				}
				//println"$temp"
						rtemp=temp;	
			}
			else if(same2==1&&same3==1)//2개 같은거 1개, 3개 같은거 1개 - 풀하우스
			{
				//println"풀하우스"
				/*String temp = "[5";
					temp +=", ";
					temp += temp1;
					temp +=", ";
					temp += temp2;
					temp +=	"]";*/
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp=[5,temp1,temp2];
					//println"$temp"
							rtemp=temp;	
			}	
			
			//println" 왼쪽 데이터$rtemp"
			//println"오른쪽 데이터$ltemp"
			if(ltemp.isEmpty())
			{
				return 0;
			}
		int result=ltemp[0]-rtemp[0];
		if(result==0)
		{
				 result=ltemp[2]-rtemp[2];
				if(result==0)
				{
					 result=ltemp[1]-rtemp[1];
					if(result==0)
					{
						return result;
					}
					return result;
				}
				return result;
		}
		return result;
	}
}	
		
	
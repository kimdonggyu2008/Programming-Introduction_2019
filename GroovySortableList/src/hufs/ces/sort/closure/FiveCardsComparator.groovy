package hufs.ces.sort.closure
import java.util.ArrayList;
/*
class FiveCardsComparator implements Comparator<FiveCards> {
 int compare (FiveCards left, FiveCards right) {
	 int k=0;
	 for(FiveCards le:left)
	 {
		 println"����� ${++k}$le"
	 }
	 return left.compareTo(right);
 }
}
*/
class FiveCardsComparator implements Comparator<FiveCards> {
	int compare (FiveCards left,FiveCards right) {
		//println"���� ����$left.fiveCards"
		//println"���� ������$right.fiveCards"
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
		
		
		//������
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
				//println"����Ʈ $recent"
				for(int k=1+i;k<5;k++)
				{
					int rrecent=right.fiveCards[k].rank;
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
				//println"ī��Ʈ�� $count"
				count=0;
				//println"���� same2= $same2 same3= $same3"
			}
			//println"���� ������ ī�� ���´� $right.fiveCards"
			//println"����� �� 1.   $temp1 ,2.   $temp2"
			//println"������ ����� same2= $same2 same3= $same3"
	
			
			if(same2<0)
			{
				same2=0;
			}
			if(same2==0&&same3==0)//2�� ���� �� ����, 3�� ���� �͵� ������ - �����
			{
				//println"�����"
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
					if(right.fiveCards[i].rank!=temp1)
					{
						temp.add(right.fiveCards[i].rank);
					}
				}
				
				rtemp=temp;
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
					if(temp1!=right.fiveCards[i].rank&&temp2!=right.fiveCards[i].rank)
					{
						temp.add(right.fiveCards[i].rank);
					}
				}
				//println"$temp"
						rtemp=temp;
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
					if(temp1!=right.fiveCards[i].rank)
					{
						temp.add(right.fiveCards[i].rank);
					}
				}
				//println"$temp"
						rtemp=temp;	
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
							rtemp=temp;	
			}	
			
			//println" ���� ������$rtemp"
			//println"������ ������$ltemp"
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
		
	
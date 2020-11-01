import java.io.File;

public class Driver 
{
	public static void main(String[] args)
	{
		DataReaderWriter readWrite = new DataReaderWriter("/src/names.dat", new File(System.getProperty("user.dir") + "/src/players.dat"));
		CollectionOfPlayers collectionOfPlayers = new CollectionOfPlayers("/src/players.dat");
		
		collectionOfPlayers.displayPlayers();
		
		System.out.println("**************************************");
		
		Driver.mergeSort(collectionOfPlayers.getCollectionOfPlayers(), 0, collectionOfPlayers.getCollectionOfPlayers().length - 1);
		
		collectionOfPlayers.displayPlayers();
		
		
		
	}
	
	public static void mergeSort(Player[] playerArray, int begin, int end)
	{
		if(begin != end)
		{
			int begin1 = begin;
			int end1 = begin +(end - begin)/2;
			int begin2 = end1 + 1;
			int end2 = end;
			Driver.mergeSort(playerArray, begin1, end1);
			Driver.mergeSort(playerArray, begin2, end2);
			Driver.merge(playerArray, begin1, end1, begin2, end2);
		}
	}
	
	public static void merge(Player[] playerArray, int begin1, int end1, int begin2, int end2)
	{
		Player[] temp = new Player[(end2 - begin1) + 1];
		int pos1 = begin1;
		int pos2 = begin2;
		
		for(int i = 0; i < temp.length; i++)
		{
			if(pos1 <= end1 && pos2 <= end2)
			{
				if(playerArray[pos1].getAge() < playerArray[pos2].getAge())
				{
					temp[i] = playerArray[pos1];
					pos1++;
				}
				else
				{
					temp[i] = playerArray[pos2];
					pos2++;
				}
			}
			else
			{
				//either pos1 or pos2 is off the end of their list and the other guy is the default winner
				if(pos1 > end1)
				{
					temp[i] = playerArray[pos2];
					pos2++;
				}
				else
				{
					temp[i] = playerArray[pos1];
					pos1++;
				}
			}
		}
		
		int tempCounter = 0;
		for(int j = begin1; j <= end2; j++)
		{
			playerArray[j] = temp[tempCounter];
			tempCounter++;
		}
	}
}



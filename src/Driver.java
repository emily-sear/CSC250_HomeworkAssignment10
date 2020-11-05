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
		
		Player foundThem = Driver.searchForPlayerByAge(collectionOfPlayers.getCollectionOfPlayers(), 99);
		System.out.println("**************************************");
		if(foundThem == null)
		{
			System.out.println("Did not find anybody with that age");
		}
		else
		{
			foundThem.display();
		}
		
		
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
		
	public static Player searchForPlayerByAge(Player[] playerArray, int age)
		{
			//binary search... playerArray MUST be sorted 
			int begin = 0;
			int end = playerArray.length - 1;
			int middle;
			
			while(end >= begin)
			{
				middle = (begin + end) /2;
				if(playerArray[middle].getAge() == age)
				{
					return playerArray[middle];
				}
				else if(age < playerArray[middle].getAge())
				{
					end = middle - 1;
				}
				else
				{
					begin = middle + 1;
				}
			}
			return null;
		}
	}




import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CollectionOfPlayers 
{
	private Player[] arrayOfPlayers;
	
	public CollectionOfPlayers(Player[] arrayOfPlayers)
	{
		this.arrayOfPlayers = arrayOfPlayers;
	}
	
	
	public CollectionOfPlayers(String file)
	{
		this.arrayOfPlayers = new Player[25];
		int spot = 0;
		try
		{
			Scanner input = new Scanner(new File(System.getProperty("user.dir") + file));
			while(input.hasNext())
			{
				this.arrayOfPlayers[spot] = new Player(input.nextLine());
				spot++;
			}
			input.close();
		}
		catch(Exception e)
		{
			System.out.println("No File Found3");
		}
	}
	
	public Player[] getCollectionOfPlayers()
	{
		return this.arrayOfPlayers;
	}
	
	public int[] getCollectionOfAges()
	{
		int[] collectionOfAges = new int[this.arrayOfPlayers.length -1];
		
		for(int i = 0; i < collectionOfAges.length; i++)
		{
			collectionOfAges[i] = arrayOfPlayers[i].getAge();
		}
		
		return collectionOfAges;
	}
	public void displayPlayers()
	{
		for(Player p : arrayOfPlayers)
		{
			p.display();
		}
	}
	

	

}

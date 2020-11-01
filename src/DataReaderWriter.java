import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class DataReaderWriter
{

	//I am well aware this shouldn't be a constructor but this is all I wanted this class to do 
	public DataReaderWriter(String file, File fileToBeWrittenTo)
	{
		Random random = new Random();
		String[] names = new String[175];
		int spot = 0;
		try
		{
			Scanner input = new Scanner(new File(System.getProperty("user.dir") + file));
			while(input.hasNext())
			{
				names[spot] = input.nextLine();
				spot++;
			}
			input.close();
		}
		catch(Exception e)
		{
			System.out.println("No file found1.");
		}
		try
		{
			FileWriter write = new FileWriter(fileToBeWrittenTo, false);
			for(int i = 0; i < 25; i++)
			{
				write.write(random.nextInt(100) + ":" + names[random.nextInt(175)] + ":" + random.nextInt(100) + "\n");
			}
			
			write.close();
		}
		catch(Exception e)
		{
			System.out.println("No file found2.");
		}
	}
}

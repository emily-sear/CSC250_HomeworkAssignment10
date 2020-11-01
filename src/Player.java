public class Player
{
	private int age;
	private String name;
	private int number;
	
	public Player(int age, String name, int number)
	{
		this.age = age;
		this.name = name;
		this.number = number;
	}
	
	public Player(String file)
	{
		String[] holder = file.split(":");
		this.age = Integer.parseInt(holder[0]);
		this.name = holder[1];
		this.number = Integer.parseInt(holder[2]);
	}

	public int getAge()
	{
		return age;
	}

	public String getName() 
	{
		return name;
	}

	public int getNumber()
	{
		return number;
	}

	public void display()
	{
		System.out.println("Name: " + this.name + " Age: " + this.age + " Number: " + this.number);
	}
	
}

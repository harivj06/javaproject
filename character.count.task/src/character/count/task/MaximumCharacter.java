package character.count.task;
import java.util.*;
import java.io.*;
public class MaximumCharacter {
	public void menu()
	{
		boolean condition=true;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int option=0;
		while(condition)
		{
			System.out.println("Press 1 to Enter Sentence");
			System.out.println("Press 0 to Back");
			option=0;
			try
			{
				option=Integer.parseInt(reader.readLine());
				switch(option)
				{
				case 1: System.out.println("Enter the Input");
						String input=reader.readLine();
						process(input);
				break;
				case 0:condition=false;
				break;
				default:System.out.println("Enter valid option");
						
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Enter valid option");
				
			}
			catch(NumberFormatException e)
			{
				System.out.println("Enter valid option");
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
public void process(String sentence)
{
	int max=0;
	char result='a';
	TreeMap <Character,Integer>freqMap=new TreeMap<>();
	for(int i=0;i<sentence.length();i++)
	{
		if(sentence.charAt(i)!=' ')
		{
			if(freqMap.containsKey(sentence.charAt(i)))
			{
				int temp=freqMap.get(sentence.charAt(i)) + 1;
				if(max<temp)
				{
					max=temp;
				}
				freqMap.put(sentence.charAt(i),freqMap.get(sentence.charAt(i))+1);
			}
			else
			{
				freqMap.put(sentence.charAt(i),1);
			}
		}
	}
	if(max!=0)
	{
		for(Map.Entry<Character,Integer> entry:freqMap.entrySet())
		{
			if(entry.getValue()==max)
			{
				result=entry.getKey();
			}
		}
		System.out.println("Maximum Repeated Character :"+result);
		System.out.println("Number of time repeated :"+max);
	}
	else
	{
		System.out.println("No Characters has been Repeated");
	}
}
//	public static void main(String args[])
//	{
//		MaximumCharacter obj=new MaximumCharacter();
//		obj.menu();
//	}
}

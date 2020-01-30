package character.count.task;
import java.util.*;
import java.io.*;
public class User {
	private String name,password;
	private Long phoneNo;
	
	User(String name,String password)
	{
		this.name=name;
		this.password=password;
	}
	public String getName()
	{
		return this.name;
	}
	public String getPassword()
	{
		return this.password;
	}
	public long getPhoneNo()
	{
		return this.phoneNo;
	}
}
class Home
{
	HashMap<String,User> user=new HashMap<>();
	
	public void mainMenu()
	{
		
		boolean condition=true;
		int option=0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(condition)
		{
			System.out.println("Press 1 to Register");
			System.out.println("Press 2 to login");
			System.out.println("Press 0 to Exit");
			try
			{
				option=Integer.parseInt(reader.readLine());
				switch(option)
				{
				case 1:while(condition)
						{
								System.out.println("Enter the name");
								String name=reader.readLine();
								System.out.println("Enter the password");
								String password=reader.readLine();
								System.out.println("Re enter the password");
								String repassword=reader.readLine();
								if(!name.isEmpty() && password.isEmpty())
								{
									if(password.equals(repassword))
									{
										if(user.containsKey(name)!=true)
										{
											user.put(name, new User(name,password));
											System.out.println("Registered successfully");
											condition=false;
										}
										else
										{
											System.out.println("User already registered");
											condition=false;
										}
									}
									else
									{
										System.out.println("Passwords did not match");
									}
								}
								else
								{
									System.out.println("Enter valid name or password");
								}
						}
						condition=true;
					break;
				case 2:
					System.out.println("Enter the name");
					String loginName=reader.readLine();
					System.out.println("Enter password");
					String loginPassword=reader.readLine();
					User temp=user.get(loginName);
					if(user.containsKey(loginName))
					{
						if(temp.getName().equals(loginName)&&temp.getPassword().equals(loginPassword))
						{
							System.out.println("Login successfull..!");
							MaximumCharacter maxChar=new MaximumCharacter();
							maxChar.menu();	
						}
						else
						{
							System.out.println("Ivalid Details...!");
							System.out.println("If you have't registered please register");
						}
					}
					break;
				case 0:condition=false;
				break;
					default:System.out.println("Enter a valid option");
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
		}
		
	}
	public static void main(String args[])
	{
		Home obj=new Home();
		obj.mainMenu();
		System.out.println("ThankYou");
	}
	
	
}

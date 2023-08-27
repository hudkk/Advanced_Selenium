package practise;

import org.testng.annotations.Test;

public class Testng1Practise {
	@Test(priority=1)
	public void createUser()
	{
		System.out.println("create");
	}
	@Test(priority = 2)
	public void updateUser()
	{
		System.out.println("update");
	}
	@Test(priority = -1)
	
	public void deleteUser()
	{
		System.out.println("delete");
	}

}

package practise;

import org.testng.annotations.Test;

public class Testng5Practise {
	@Test(enabled = false)
	public void createUser()
	{
		System.out.println("create");
	}
	@Test
	public void updateUser()
	{
		System.out.println("update");
	}
	@Test
	
	public void deleteUser()
	{
		System.out.println("delete");
	}

}


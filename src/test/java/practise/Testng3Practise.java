package practise;

import org.testng.annotations.Test;

public class Testng3Practise {
	@Test(invocationCount = 0)
		public void createUser()
		{
			System.out.println("create");
		}
	@Test(dependsOnMethods = "createUser")
	
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







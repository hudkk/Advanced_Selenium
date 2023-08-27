package practise;

	import org.testng.annotations.Test;

	public class Testng2Practise {
		@Test(invocationCount = 3 , priority =2)
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




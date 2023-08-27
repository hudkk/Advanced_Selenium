package practise;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractise {
	@Test
	public void sample() {
		System.out.println("step1");
		System.out.println("step2");
		
		Assert.assertEquals(true, true);
		System.out.println("step3");
		System.out.println("step4");
	}
	@Test
	public void sample2()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("step1");
		System.out.println("step2");
		sa.assertEquals(true, false);//failure
		
		System.out.println("step3");
		sa.assertTrue(false);
		
		System.out.println("step4");
		//sa.assertAll();//log all the assert failures
		
	}

}

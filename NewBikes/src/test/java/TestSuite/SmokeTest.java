package TestSuite;

import org.testng.annotations.Test;

import Pages.HondaDetails;


public class SmokeTest 
{
	@Test
	public void testing()
	{
		HondaDetails hd=new HondaDetails();
		hd.openUrl();
		hd.clickUpcomingBikes();
		hd.selectManufacturer();
	}

}

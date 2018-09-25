package pageobject;

import reuseablecomponent.BaseClass;
import uistore.HealthForum_UI;

public class HealthForum_Page extends HealthForum_UI
{
	public static String getCategoryText()
	{
		return BaseClass.driver.findElement(categoryText).getText();
	}
	

}

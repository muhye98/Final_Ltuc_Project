package Final_Project;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
	static WebDriver driver = new ChromeDriver();

	Random rand = new Random();
	int RandomEmail = rand.nextInt(999);
	int randomPassoward = rand.nextInt(99999999);

	static String WebsiteUrl = "https://magento.softwaretestingboard.com/";

	static String signUpPage = "https://magento.softwaretestingboard.com/customer/account/create/";

	static String logOutPage = "https://magento.softwaretestingboard.com/customer/account/logout/";

	static String loginPage = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2NyZWF0ZS8%2C/";
	
	static String TessURL = "https://magento.softwaretestingboard.com/women/tops-women/tees-women.html";

	static String[] FirstNameArray = { "Raed", "Ammar", "khaled", "Jalal", "Ziad" };
	static String[] LastNameArray = { "Ahmed", "Sami", "Khalel", "Saed", "Naser" };

	int randomIndex = rand.nextInt(5);

	String firstName = FirstNameArray[randomIndex];
	String lastNames = LastNameArray[randomIndex];
	String EmailFinal = firstName + lastNames + RandomEmail + "@gmail.com";
	String FinalPassoward = "M##$" + randomPassoward + "m@!#";
	String ExpictedResult = "Contact Information";

}

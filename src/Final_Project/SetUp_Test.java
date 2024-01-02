package Final_Project;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.opentelemetry.api.internal.StringUtils;

public class SetUp_Test extends Parameters {
	SoftAssert softassert = new SoftAssert();

	@BeforeTest
	public void Setup() {
		driver.get(WebsiteUrl);

	}

	@Test(priority = 1)
	public void CreatAccount() throws InterruptedException {
		driver.get(signUpPage);
		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement Button = driver.findElement(By.className("primary"));

		FirstName.sendKeys(firstName);
		LastName.sendKeys(lastNames);
		Email.sendKeys(EmailFinal);
		Password.sendKeys(FinalPassoward);
		confirmPassword.sendKeys(FinalPassoward);
		Button.click();
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void Logout() throws InterruptedException {

		driver.get(logOutPage);
		Thread.sleep(1000);
	}

	@Test(priority = 3)
	public void Login() throws InterruptedException {

		driver.get(loginPage);
		WebElement emailInput = driver.findElement(By.id("email"));
		WebElement passInput = driver.findElement(By.id("pass"));
		WebElement loginbut = driver.findElement(By.id("send2"));

		emailInput.sendKeys(EmailFinal);
		passInput.sendKeys(FinalPassoward);
		loginbut.click();

		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void AddThreeItems() throws InterruptedException {

		
        for (int i = 0; i < 3; i++) {
        	driver.get("https://magento.softwaretestingboard.com/women/tops-women/tees-women.html");
    		WebElement ItemsContainer = driver.findElement(By.cssSelector(".products.wrapper.grid.products-grid"));
    		List<WebElement> allItems = ItemsContainer.findElements(By.tagName("li"));
            WebElement item = allItems.get(i);
			addItem(item);
			Thread.sleep(2000);
		}
        List<WebElement> PriceForItems = driver.findElements(By.cssSelector(".minicart-price .price"));
        double sum = 0;
        driver.findElement(By.className("showcart")).click();
        for (int i = 0; i < 3; i++) {
        	String finalPrice = PriceForItems.get(i).getText().replace("$","");
				sum += Double.parseDouble(finalPrice);

        }
        String TotalPrice = driver.findElement(By.className("price")).getText().replace("$","");
		softassert.assertEquals(Double.parseDouble(TotalPrice), sum);
	}

	private void addItem(WebElement item) throws InterruptedException {
		item.click();
		Thread.sleep(1000);
		WebElement SizeSelect = driver.findElement(By.xpath("//div[@class='swatch-attribute size']//div[@role='listbox']"));
		List<WebElement> AllSizes = SizeSelect.findElements(By.tagName("div"));
		AllSizes.get(1).click();

		WebElement Color = driver.findElement(By.xpath("//div[@class='swatch-attribute color']//div[@role='listbox']"));
		List<WebElement> Allcolors = Color.findElements(By.tagName("div"));
		int RandomColor = rand.nextInt(Allcolors.size());
		Allcolors.get(RandomColor).click();

		WebElement AddtoCart = driver.findElement(By.id("product-addtocart-button"));
		AddtoCart.click();
	}

	@Test(priority = 5)
	public void CheckTheManSection() throws InterruptedException {
		Random random = new Random();
		int RandomItem = random.nextInt(12);
		int RandomSize = random.nextInt(5);
		driver.get("https://magento.softwaretestingboard.com/men/tops-men/tanks-men.html");
		WebElement ItemsContainer = driver.findElement(By.cssSelector(".products.wrapper.grid.products-grid"));
		List<WebElement> allItems = ItemsContainer.findElements(By.tagName("li"));
		WebElement item = allItems.get(RandomItem);
		item.click();
		Thread.sleep(1000);
		
		WebElement SelectSize = driver.findElement(By.xpath("//div[@class='swatch-attribute size']//div[@role='listbox']"));
		List<WebElement> AllSizes = SelectSize.findElements(By.tagName("div"));
		AllSizes.get(RandomSize).click();

		WebElement ColorSelect = driver.findElement(By.xpath("//div[@class='swatch-attribute color']//div[@role='listbox']"));
		List<WebElement> Allcolors = ColorSelect.findElements(By.tagName("div"));
		int RandomColor = rand.nextInt(Allcolors.size());
		Allcolors.get(RandomColor).click();
		WebElement AddtoCart = driver.findElement(By.id("product-addtocart-button"));
		AddtoCart.click();
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.className("showcart")).click();
      	String FinalPrice = driver.findElement(By.className("price")).getText().replace("$","");
      	System.out.println("The Final Price for this items is: " +FinalPrice);
	}

	@AfterTest
	public void AfterTest() {
		softassert.assertAll();

	}
}

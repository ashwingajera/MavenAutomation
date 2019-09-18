package abc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.image.renderable.RenderableImage;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Double.parseDouble;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.partialLinkText;

public class Homework extends Utils {

//    protected static WebDriver driver;

    LoadProps props = new LoadProps();

    @Before

    public void openBrowser(){

        System.setProperty("webdriver.chrome.driver","src\\main\\Resouces\\BroserDriver\\chromedriver.exe");


        // open the browser
        driver = new ChromeDriver();

        //maximise the browser window screen

        driver.manage().window().fullscreen();

        //set implicity wait for driver object
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        //open the website

       //driver.get("https://demo.nopcommerce.com/");
        driver.get(props.getProperty("url"));




    }

    @After
    public void closebrowser (){

         //close the browser window
        driver.quit();
     }

    @Test
    public void userShouldBeAbleToLogInSuccessfully(){

        clickOnElement(By.xpath("//a[@class='ico-register']"));
       // driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        //First Name
        enterText(By.xpath("//input[@id='FirstName']"), props.getProperty("firstname"));
        //driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("vijay");

        //Last name
        enterText(By.id("LastName"),props.getProperty("lastname"));
        //driver.findElement(By.id("LastName")).sendKeys("chabra");

        //Date of birth selection
        selectByVisibleText(By.name("DateOfBirthDay"), props.getProperty("day"));

        //Month drop box select
        selectByValue(By.name("DateOfBirthMonth"),props.getProperty("month"));

        //Birth year drop box select
        selectByIndex(By.name("DateOfBirthYear"), Integer.parseInt(props.getProperty("i")));


        //random email creation
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);

        //Email
        enterText(By.xpath("//input[@id=\"Email\"] "),"chabra"+ randomInt+ "@gmail.com");
        //driver.findElement(By.xpath("//input[@id=\"Email\"] ")).sendKeys("chabra"+ randomInt+ "@gmail.com");



        //Password Entry
        enterText(By.xpath("//input[@id=\"Password\"]"), props.getProperty("password"));
        //driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("12Danda");

        //Confirm Password
        enterText(By.xpath("//input[@id=\"ConfirmPassword\"]"), props.getProperty("confpassword"));
        //driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys("12Danda");
        //Click Register button
        clickOnElement(By.name("register-button"));
        //driver.findElement(By.name("register-button")).click();

//Registration successful (Test Pass or Fail)

        String expectedMSG = "Your registration completed";
        String actualMSG = getTextFromElement(By.xpath("//div[@class=\"result\"]"));

        //driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();

        Assert.assertEquals(actualMSG, expectedMSG);

        //Click on Continue
        clickOnElement(By.name("register-continue"));
        //driver.findElement(By.name("register-continue")).click();
    }

    @Test
    public  void userShouldBeAbleToReferAProductToFriendByEmail () throws InterruptedException {

        clickOnElement(By.xpath("//a[@class='ico-register']"));
        // driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        //First Name
        enterText(By.xpath("//input[@id='FirstName']"), props.getProperty("firstname"));
        //driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("vijay");

        //Last name
        enterText(By.id("LastName"),props.getProperty("lastname"));
        //driver.findElement(By.id("LastName")).sendKeys("chabra");

        //Date of birth selection
        selectByVisibleText(By.name("DateOfBirthDay"), props.getProperty("day"));

        //Month drop box select
        selectByValue(By.name("DateOfBirthMonth"),props.getProperty("month"));

        //Birth year drop box select
        selectByIndex(By.name("DateOfBirthYear"), Integer.parseInt(props.getProperty("i")));


        //random email creation
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);

        //Email
        enterText(By.xpath("//input[@id=\"Email\"] "),"chabra"+ randomInt+ "@gmail.com");
        //driver.findElement(By.xpath("//input[@id=\"Email\"] ")).sendKeys("chabra"+ randomInt+ "@gmail.com");



        //Password Entry
        enterText(By.xpath("//input[@id=\"Password\"]"), props.getProperty("password"));
        //driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("12Danda");

        //Confirm Password
        enterText(By.xpath("//input[@id=\"ConfirmPassword\"]"), props.getProperty("confpassword"));
        //driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys("12Danda");

        //Click Register button
        clickOnElement(By.name("register-button"));
        //driver.findElement(By.name("register-button")).click();


        //Click on Continue
        clickOnElement(By.name("register-continue"));
        //driver.findElement(By.name("register-continue")).click();

        //click on macbook
        clickOnElement(By.xpath("//div/a[@title=\"Show details for Apple MacBook Pro 13-inch\"]"));
        //driver.findElement(By.xpath("//div/a[@title=\"Show details for Apple MacBook Pro 13-inch\"]")).click();

        waitForClikable(By.xpath("//div[@class='email-a-friend']"),30);
        //Thread.sleep(2000);

        //Email a friend
        clickOnElement(By.xpath("//div[@class='email-a-friend']"));
        //driver.findElement(By.xpath("//div[@class='email-a-friend']")).click();

        waitForClikable(By.xpath("//input[@class='friend-email'] "),20);
        //Thread.sleep(2000);

        //Enter Friends email
        enterText(By.xpath("//input[@class='friend-email'] "), props.getProperty("friendemail"));
        //driver.findElement(By.xpath("//input[@class='friend-email'] ")).sendKeys("gajeraashwin2@gmail.com");

        waitForClikable(By.xpath(" //textarea[@placeholder='Enter personal message (optional).'] "),20);
        //Thread.sleep(3000);


        //Personal Message
        enterText(By.xpath(" //textarea[@placeholder='Enter personal message (optional).'] "), props.getProperty("personalmessage"));
       // driver.findElement(By.xpath(" //textarea[@placeholder='Enter personal message (optional).'] ")).sendKeys("Hey check this out a very good deal I found buy this has great features");

        waitForClikable(By.name("send-email"),20);
        //Thread.sleep(3000);

        //Click send email
        clickOnElement(By.name("send-email"));
        //driver.findElement(By.name("send-email")).click();

        waitForClikable(By.xpath("//*[@class=\"result\"]"),20);
        //Thread.sleep(5000);

        //Test Pass or Fail

        String expectM = "Your message has been sent.";
        String actualM = getTextFromElement(By.xpath("//*[@class=\"result\"]"));

                //driver.findElement(By.xpath("//*[@class=\"result\"]")).getText();

        Assert.assertEquals(actualM, expectM);

    }

    @Test
    public void userShouldBeNavigateCameraAndPhoto() throws InterruptedException {

        //click on Electronics category
        clickOnElement(By.linkText("Electronics"));
        //driver.findElement(By.linkText("Electronics")).click();

        waitForClikable(By.xpath("//img[@alt=\"Picture for category Camera & photo\"]"),20);
        //Thread.sleep(2000);
        clickOnElement(By.xpath("//img[@alt=\"Picture for category Camera & photo\"]"));
        //driver.findElement(By.xpath("//img[@alt=\"Picture for category Camera & photo\"]")).click();

        waitForClikable(By.xpath("//h1"),20);
        //Thread.sleep(4000);

        String actualM1 = getTextFromElement(By.xpath("//h1"));
                //driver.findElement(By.xpath("//h1")).getText();
        String expectedM1 = "Camera & photo";

        Assert.assertEquals(actualM1, expectedM1);


    }

    @Test

    public void userShouldBeAbleToFilterJewelleryByPriceRange() {


        //Select Jewellery category
        clickOnElement(partialLinkText("Jewelry"));
        //driver.findElement(partialLinkText("Jewelry")).click();

        //Select Price Range of 700-3000
        clickOnElement(By.xpath("//a[contains(@href,'700-3000')]"));
        // driver.findElement(By.xpath("//a[contains(@href,'700-3000')]")).click();

        //compare

        String actualM2 = getTextFromElement(By.xpath("//span[@class=\"price actual-price\"]"));
                //driver.findElement(By.xpath("//span[@class=\"price actual-price\"]")).getText();
        String expectedM2 = "$700.00 - $3,000.00";
        String s[] = expectedM2.split("-");
        String s4 = s[1].replaceAll(" ", "").replace("$", "").replace("," , "");
        String s3 = s[0].replace("$", "");
        //Convert String to Double
        double p1 = parseDouble(s3);
        double p2 = parseDouble(s4);
        //Converting Actual value to double
        double AM2 = parseDouble(actualM2.replace("$", "").replace(",", ""));

        // Assert.assertTrue(AM2,EM2);

        Assert.assertTrue(AM2>p1 && AM2< p2);
    }




    @Test
    public void userShouldBeAbleToAdd2ItemsToTheBasket() throws InterruptedException {

        //Go to book category
        clickOnElement(By.linkText("Books"));
        //driver.findElement(By.linkText("Books")).click();

        //Add first book to cart
        clickOnElement(By.xpath("//input[@type='button' and contains(@onclick, '38/1/1')]"));
        //driver.findElement(By.xpath("//input[@type='button' and contains(@onclick, '38/1/1')]")).click();

       // waitForElementVisible(By.xpath("//input[@type='button' and contains(@onclick, '38/1/1')]"),3000);

        //unfortunately waitForElementVisible and waitForElementClickable is not working for selecting second book, so thread.sleep used
        Thread.sleep(2000);

        //Add second book to cart
        clickOnElement(By.xpath("//input[@type='button' and contains(@onclick, '37/1/1')]"));
        //driver.findElement(By.xpath("//input[@type='button' and contains(@onclick, '37/1/1')]")).click();
        //waitForElementVisible(By.xpath("//input[@type='button' and contains(@onclick, '37/1/1')]"), 30);

        Thread.sleep(7000);

        //waitForClikable(By.className("ico-cart"),70);

        //Click on shopping cart
        clickOnElement(By.className("ico-cart"));
       // driver.findElement(By.className("ico-cart")).click();

      //waitForClikable(By.xpath("//span[@class='sku-number' and contains(text(), 'FIRST_PRP')]"),40);

        //Check if test was successful or failed
        String actualu1 = getTextFromElement(By.xpath("//span[@class='sku-number' and contains(text(), 'FIRST_PRP')]"));
                //driver.findElement(By.xpath("//span[@class='sku-number' and contains(text(), 'FIRST_PRP')]")).getText();
        String expectedu1 = "FIRST_PRP";
        Assert.assertEquals(actualu1, expectedu1);

        waitForClikable(By.xpath("//span[@class='sku-number' and contains(text(), 'FR_451_RB')]"),40);

        String actualb2 = getTextFromElement(By.xpath("//span[@class='sku-number' and contains(text(), 'FR_451_RB')]"));
                //driver.findElement(By.xpath("//span[@class='sku-number' and contains(text(), 'FR_451_RB')]")).getText();
        String expectedb2 = "FR_451_RB";
        Assert.assertEquals(actualb2, expectedb2);

    }





}

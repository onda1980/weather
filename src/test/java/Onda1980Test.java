import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class Onda1980Test {
//   TC_1-1 - Тест кейс:
// //1.Открыть страницу https://openweathermap.org
    //2.Набрать в строке поиска город Paris
    //3.Нажать пункт меню Search
    //4.Из выпавшего списка выбрать Paris, FR
    //5.Подтвердить,  что заголовок изменился, на "Paris, FR"

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Applications/Chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);


        driver.quit();
    }

//TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой
// https://openweathermap.org/guide и что title этой страницы
// OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void testSearchMenuGuide() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/Chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();

//Arrange
        String url = "https://openweathermap.org/";
        String expectedresult1 = "https://openweathermap.org/";
        String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";

//Act
        driver.get(url);
        WebElement searchGuideButton = driver.findElement(
                By.xpath("//nav[@id = 'nav-website']//ul//div[@id = 'desktop-menu']//ul//li//a[@href = '/guide']")
        );
        Thread.sleep(5000);

        searchGuideButton.click();

//Assert
        String actualResult1 = driver.getCurrentUrl();
        String actualResult2 = driver.getTitle();

    }
//TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//3.  Подтвердить, что температура для города показана в Фарингейтах

    @Test
    public void testTemperatureMeasurements() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Applications/Chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        String expectedResult = "F";

        //Act

        driver.get(url);
        WebElement findTemperatureMeasurements = driver.findElement(
                By.xpath("//div[@class = 'switch-container']//div[text() = 'Imperial: °F, mph']")
        );
        Thread.sleep(5000);
        findTemperatureMeasurements.click();

        WebElement temperatureData = driver.findElement(
                By.xpath("//span[@class = 'heading']")
        );
        String temp = temperatureData.getText();
        //53°F

        String actualResult = String.valueOf(temp.charAt(temp.length() - 1));


        //Assert
        Assert.assertEquals(expectedResult, actualResult);

    }

//TC_11_03
//1.  Открыть базовую ссылку
//2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site to work.
// We also use non-essential cookies to help us improve our services. Any data collected is anonymised.
// You can allow all cookies or manage them individually.”
//3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”

    @Test

    public void testCookiesPAnel_WhenClickingTheTitlePage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/Chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        String expectedResult1 = "We use cookies which are essential for the site to work. " +
                "We also use non-essential cookies to help us improve our services. " +
                "Any data collected is anonymised. You can allow all cookies or manage them individually.";
        boolean expectedResult2 = true;
        boolean expectedResult3 = true;
        //Act
        driver.get(url);
        WebElement cookiesPanel = driver.findElement(
                By.xpath("//div[@class = 'stick-footer-panel__container']//p")
        );
        Thread.sleep(5000);
        String actualResult1 = cookiesPanel.getText();

        WebElement cookiesButtonAllowAll = driver.findElement(
                By.xpath("//div[@class = 'stick-footer-panel__btn-container']//button[@type = 'button']")
        );
        boolean actualResult2 = cookiesButtonAllowAll.isDisplayed();

        WebElement cookiesLinkManageCookies = driver.findElement(
                By.xpath("//a[@class = 'stick-footer-panel__link']")
        );
        boolean actualResult3 = cookiesLinkManageCookies.isDisplayed();


        //Assert
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);
    }

//TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”

    @Test
    public void testSubMenu_WhenOpeningSupportMenu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/Chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        //Arrange
        String url = "https://openweathermap.org/";
        String ExpectedResult1 = "FAQ";
        String ExpectedResult2 = "How to start";
        String ExpectedResult3 = "Ask a question";
        //Act
        driver.get(url);
        WebElement supportMenu = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );
        Thread.sleep(7000);
        supportMenu.click();

        WebElement findFAQ = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']//a[@href =  '/faq']")
        );
        WebElement findHowToStart = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']//a[@href =  '/appid']")
        );
        WebElement findAskAQuestion = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']//" +
                        "a[@href =  'https://home.openweathermap.org/questions']")
        );
        String actualResult1 = findFAQ.getText();
        String actualResult2 = findHowToStart.getText();
        String actualResult3 = findAskAQuestion.getText();
        //Assert
        Assert.assertEquals(actualResult1, ExpectedResult1);
        Assert.assertEquals(actualResult2, ExpectedResult2);
        Assert.assertEquals(actualResult3, ExpectedResult3);
    }

//TC_11_05
//1. Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Заполнить поля Email, Subject, Message
//4. Не подтвердив CAPTCHA, нажать кнопку Submit
//5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”

    @Test
    public void testAvoidCaptcha_WhenOpeningAskAQuestion() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/Chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();

//Arrange
        String url = "https://openweathermap.org/";
        String emailFieldText = "irina.kotenko@gmail.com";
        String subjectTextareaSubject = "request";
        String messageTextareaMessage = "message";
        String expectedResultError = "reCAPTCHA verification failed, please try again.";
//Act
        driver.get(url);
        driver.manage().window().maximize();
        WebElement supportMenu = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );
        Thread.sleep(5000);
        supportMenu.click();
        WebElement findAskAQuestion = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']//" +
                        "a[@href =  'https://home.openweathermap.org/questions']")
        );
        Thread.sleep(5000);
        findAskAQuestion.click();

        String mainWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            if (winHandle.equals(mainWindow) == false) {
                driver.switchTo().window(winHandle);
                break;
            }
        }
        Thread.sleep(1000);
        WebElement fieldEmailElement = driver.findElement(
                By.xpath("//input[@id = 'question_form_email']")
        );
        fieldEmailElement.sendKeys("irina.kotenko@gmail.com");

        Thread.sleep(1000);
        WebElement subjectTextAreaElement = driver.findElement(
                By.xpath("//select[@id = 'question_form_subject']")
        );
        subjectTextAreaElement.click();
        Thread.sleep(2000);

        WebElement subjectOptionElement = driver.findElement(
                By.xpath("//option[@value = 'Other']")
        );
        subjectOptionElement.click();
        Thread.sleep(2000);

        WebElement messageTextAreaElement = driver.findElement(
                By.xpath("//textarea[@id = 'question_form_message']")
        );
        messageTextAreaElement.sendKeys(messageTextareaMessage);
        Thread.sleep(2000);

        WebElement findSubmitButtonElement = driver.findElement(
                By.xpath("//input[@name = 'commit']")
        );
        findSubmitButtonElement.click();

        WebElement reCaptchaVerificationError = driver.findElement(
                By.xpath("//div[@class = 'has-error']")
        );

        String actualResult = reCaptchaVerificationError.getText();

        driver.quit();

//Assert
        Assert.assertEquals(expectedResultError, actualResult);

    }
//TC_11_06
//1. Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
//4. Оставить пустым поле Email
//5. Заполнить поля  Subject, Message
//6. Подтвердить CAPTCHA
//7. Нажать кнопку Submit
//8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”

    @Test
    public void testCaptcha_WhenOpeningAskAQuestion() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/Chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
//Arrange
        String url = "https://openweathermap.org/";
        String emailFieldText = " ";
        String subjectTextareaSubject = "request";
        String messageTextareaMessage = "message";
        String expectedResult = "can't be blank";
//Act
        driver.get(url);
        driver.manage().window().maximize();
        WebElement supportMenu = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );
        Thread.sleep(5000);
        supportMenu.click();
        WebElement findAskAQuestion = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']//" +
                        "a[@href =  'https://home.openweathermap.org/questions']")
        );
        Thread.sleep(5000);
        findAskAQuestion.click();

        String mainWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            if (winHandle.equals(mainWindow) == false) {
                driver.switchTo().window(winHandle);
                //  break;
            }
        }
        WebElement defaultEntryUser = driver.findElement(
                By.xpath("//div[@class = 'col-sm-8']/input[@name = 'question_form[is_user]']")
        );
        Thread.sleep(1000);
        WebElement fieldEmailElement = driver.findElement(
                By.xpath("//input[@id = 'question_form_email']")
        );
        fieldEmailElement.sendKeys(emailFieldText);

        Thread.sleep(1000);
        WebElement subjectTextAreaElement = driver.findElement(
                By.xpath("//select[@id = 'question_form_subject']")
        );
        subjectTextAreaElement.click();
        Thread.sleep(2000);

        WebElement subjectOptionElement = driver.findElement(
                By.xpath("//option[@value = 'Other']")
        );
        subjectOptionElement.click();
        Thread.sleep(2000);

        WebElement messageTextAreaElement = driver.findElement(
                By.xpath("//textarea[@id = 'question_form_message']")
        );
        messageTextAreaElement.sendKeys(messageTextareaMessage);
        Thread.sleep(5000);

        String window2 = driver.getWindowHandle();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        WebElement enterCaptcha = driver.findElement(
                By.xpath("//span[@class= 'recaptcha-checkbox " +
                        "goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']")
        );
        enterCaptcha.click();
        Thread.sleep(10000);
        driver.switchTo().window(window2);
        WebElement findSubmitButtonElement = driver.findElement(
                By.xpath("//input[@data-disable-with = 'Create Question form']")
        );
        Thread.sleep(2000);
        findSubmitButtonElement.click();

        WebElement emailErrorText = driver.findElement(
                By.xpath("//div[@class = 'col-sm-8']/span[@class= 'help-block']")
        );
        String actualResult = emailErrorText.getText();

//Assert
        Assert.assertEquals(expectedResult, actualResult);
    }
//TC_11_07
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//3.  Нажать на единицы измерения Metric: °C, m/s
//4.  Подтвердить, что в результате этих действий, единицы измерения температуры изменились с F на С

    @Test
    public void testWeatherMeasurements_WhenSearchingTitlePage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/Chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        //Arrange
        String url = "https://openweathermap.org/";
        String expectedResult = "C";

        //Act
        driver.get(url);
        driver.manage().window().maximize();
        WebElement findTemperatureMeasurementsF = driver.findElement(
                By.xpath("//div[@class = 'switch-container']//div[text() = 'Imperial: °F, mph']")
        );
        Thread.sleep(5000);
        findTemperatureMeasurementsF.click();

        WebElement findTemperatureMeasurementsC = driver.findElement(
                By.xpath("//div[@class = 'switch-container']//div[text() = 'Metric: °C, m/s']")
        );
        Thread.sleep(5000);
        findTemperatureMeasurementsC.click();

        String tempC = findTemperatureMeasurementsC.getText();

        boolean actualResult = tempC.contains(expectedResult);

        //Assert
        Assert.assertTrue(actualResult, expectedResult);
    }
//TC_11_08
//1.  Открыть базовую ссылку
//2.  Нажать на лого компании
//3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить, что текущая ссылка не изменилась

    @Test
    public void testLogo_WhenSearchingCurrentUrl() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/Applications/Chromedriver/chromedriver");
    WebDriver driver = new ChromeDriver();
//Arrange
    String url = "https://openweathermap.org/";
    String expectedResult = driver.getCurrentUrl();
//Act
    driver.get(url);
    driver.manage().window().maximize();
    WebElement logo = driver.findElement(
         By.xpath("//li[@class = 'logo']")
    );
    Thread.sleep(5000);
    logo.click();



        //div[@class = 'owm-loader-container']

        }
//TC_11_10
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню API
//3.  Подтвердить, что на открывшейся странице пользователь видит 30 оранжевых кнопок

//    @Test
//    public void testAPI_WhenSearchingAPI() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "/Applications/Chromedriver/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        //Arrange
//        String url = "https://openweathermap.org/";
//        int expectedResult = 30;
//
//        //Act
//        driver.get(url);
//        WebElement menuAPI = driver.findElement(
//                By.xpath("//ul//li/a[@href  = '/api']")
//        );
//        Thread.sleep(5000);
//        menuAPI.click();
//        String mainwindow = driver.getWindowHandle();
//
//
//        //a[@class = 'btn_block orange round'] -  29;
//        //a[@class = 'ow-btn round btn-orange'] - 1;
//        driver.findElement(By.className(

           //    -webkit-text-size-adjust: 100%;
                //    -webkit-tap-highlight-color: transparent;
                //    font-family: Arial, sans-serif;
                //    -webkit-font-smoothing: antialiased;
                //    box-sizing: border-box;
                //    background: 0 0;
                //    text-decoration: none;
                //    padding: 2pt 6pt;
                //    line-height: 1.5;
                //    display: inline-block;
                //    margin-bottom: 0;
                //    font-weight: 400;
                //    text-align: center;
                //    vertical-align: middle;
                //    cursor: pointer;
                //    background-image: none;
                //    white-space: nowrap;
                //    color: #ffffff !important;
                //    background-color: #e96e50;
                //    border: 1px solid #e96e50;
                //    border-radius: 16pt;
                //    font-size: 12px;

        //Assert

    }




//  @Test
//    public void testH2TagText_WhenSearchingCityCountry () {
//    System.setProperty("webdriver.chrome.driver", "/Applications/Chromedriver/chromedriver");
//    WebDriver driver = new ChromeDriver();

//    driver.quit();

//    }



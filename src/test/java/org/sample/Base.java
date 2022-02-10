package org.sample;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;

	public static void launchBrowser() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
	}

	public static void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();

	}

	public static void presentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

	}

	public static void getTitles() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void passText(WebElement element, String txt) {
		element.sendKeys(txt);
	}

	public static void btnClicks(WebElement element) {
		element.click();

	}

	public static void browserClose() {
		driver.close();

	}

	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\Kish\\eclipse-workspace\\Tasks\\excel file\\" + imgName + ".png");
		FileUtils.copyFile(source, f);

	}

	public static void selectInd(WebElement element, int ind) {
		Select s = new Select(element);
		s.selectByIndex(ind);
	}

	public static void selectValue(WebElement element, String Value) {
		Select s = new Select(element);
		s.selectByValue(Value);
	}

	public static void selectVisTxt(WebElement element, String VisTxt) {
		Select s = new Select(element);
		s.selectByVisibleText(VisTxt);
	}

	public static void webTable(WebElement element) {
		List<WebElement> tableRows = element.findElements(By.tagName("tr"));

		for (int i = 0; i < tableRows.size(); i++) {

			WebElement row = tableRows.get(i);

			List<WebElement> tableDatas = row.findElements(By.tagName("td"));

			for (int j = 0; j < tableDatas.size(); j++) {

				WebElement data = tableDatas.get(j);

				String text = data.getText();

				System.out.println(text);

			}

		}
	}

	public static void dateFormat(String shtName) {
		Workbook w = new XSSFWorkbook();
		Sheet cs = w.getSheet(shtName);
		int numberOfRows = cs.getPhysicalNumberOfRows();
		for (int i = 0; i < numberOfRows; i++) {
			Row r = cs.getRow(i);

			int numberOfCells = r.getPhysicalNumberOfCells();
			for (int j = 0; j < numberOfCells; j++) {
				Cell c = r.getCell(j);
				int cellType = c.getCellType();

				String Value = "";

				if (cellType == 1) {
					Value = c.getStringCellValue();
				} else if (DateUtil.isCellInternalDateFormatted(c)) {
					Date dd = c.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("dd-mm-yyyy");
					Value = sim.format(dd);
				} else {
					double dd = c.getNumericCellValue();
					long l = (long) dd;
					Value = String.valueOf(l);
				}

			}
		}
	}

	public static void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	public static void scrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public static void getTexts(WebElement element) {
		String text = element.getText();
		System.out.println(text);

	}

	public static String getAttributes(WebElement element) {
		String text = element.getAttribute("value");
		System.out.println(text);
		return text;

	}

	public void mouseHover(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}

	public static void dragDrop(WebElement Src, WebElement Des) {
		Actions a = new Actions(driver);
		a.dragAndDrop(Src, Des).perform();
	}

	public static void clickDouble(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	public static void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	public static void keyActions(WebElement element, String k) {
		Actions a = new Actions(driver);
		a.keyDown(element, k);
		a.keyUp(element, k);
	}

	public static String alertAccept() {
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		al.accept();
		return text;

	}

	public static String alertDismiss() {
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		al.dismiss();
		return text;
	}

	public static void impWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
}

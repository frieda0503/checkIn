package signAuto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckInOutMethod {
	WebDriver driver = null;
	SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

	//    /Users/frieda/Documents/MR/checkIn/chromedriver mac
	public void open() {
		System.setProperty("webdriver.chrome.driver", "C:/checkIn/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://w3.cathaylife.com.tw/eai/ZPWeb/login.jsp?");
	}

	public void signIn(String account, String password) {
		driver.findElement(By.id("UID")).sendKeys(account);
		driver.findElement(By.id("KEY")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();

		this.wait100Secs();

		driver.get(
				"https://w3.cathaylife.com.tw/cxlpt/PTWeb/redirect.jsp?Project=fkEBafPage&csrSysCode=FK&csrPageCode=FKZ5_3000&csrPageType=prompt");

	}

	public void checkIn() {
		try {
			driver.findElement(By.id("CHK_IN_TEXT")).click();
			System.out.println("Check in Success " + sdFormat.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Check in fail " + sdFormat.format(new Date()));
		}

	}

	public void checkOut() {
		try {
			driver.findElement(By.id("LEAVE_TEXT")).click();
			System.out.println("Check out Success " + sdFormat.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Check out fail " + sdFormat.format(new Date()));
		}
	}

	public void logOut() {
		driver.findElement(By.id("logout_btn")).click();
	}

	public void wait100Secs() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void closeWindow() {
		driver.close();
	}

	public CheckInOutMethod() {
	}

//	public void checkInAtMorning() {
//		System.out.println("CheckIn Start");
//		this.open();
//		this.signIn();
//		this.checkIn();
//		this.wait100Secs();
//		this.logOut();
//		this.wait100Secs();
//		this.closeWindow();
//
//		System.out.println("CheckIn Finish");
//	}
//
//	public void checkOutAtNight() {
//		System.out.println("CheckOut Start");
//		this.open();
//		this.signIn();
//		this.checkOut();
//		this.wait100Secs();
//		this.logOut();
//		this.wait100Secs();
//		this.closeWindow();
//
//		System.out.println("CheckOut Finish");
//	}

}

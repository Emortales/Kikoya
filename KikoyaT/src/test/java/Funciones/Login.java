package Funciones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	// LOGIN//
	private By btnRegister = By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/a");
	private By txtUsuario = By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/div/input[1]");
	private By txtContrasena = By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/div/input[2]");
	private By btnlogin = By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/button");
	private By btnConfRegister = By.xpath("/html/body/my-app/div/main/my-register/div/div/form/button");
	
	
	private By txtReUser = By.id("username");
	private By txtReName = By.id("firstName");
	private By txtReLastName = By.id("lastName");
	private By txtRePass = By.id("password");
	private By txtReConfPass = By.id("confirmPassword");


	private WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	public void RegistrarUsuario(String user, String FirstName,String LastName, String Pass, String ConfPass) throws InterruptedException {
		driver.findElement(btnRegister).click();
		Thread.sleep(1000);
		driver.findElement(txtReUser).sendKeys(user);
		driver.findElement(txtReName).sendKeys(FirstName);
		driver.findElement(txtReLastName).sendKeys(LastName);
		driver.findElement(txtRePass).sendKeys(Pass);
		driver.findElement(txtReConfPass).sendKeys(ConfPass);
		Thread.sleep(1000);
		driver.findElement(btnConfRegister).click();
		Thread.sleep(1500);
	}

	public void IniciarSesion(String user, String pass) throws InterruptedException {
		driver.findElement(txtUsuario).sendKeys(user);
		driver.findElement(txtContrasena).sendKeys(pass);
		driver.findElement(btnlogin).click();
		Thread.sleep(2000);
	}
	


}

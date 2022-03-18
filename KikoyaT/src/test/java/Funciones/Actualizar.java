package Funciones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Actualizar {


	private WebDriver driver;

	public Actualizar(WebDriver driver) {
		this.driver = driver;
	}
	
public void Comentar(String texto) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		
                    // Localizadores//
					By linkView = By.xpath("/html/body/my-app/div/main/my-overall/div/div/table/tbody/tr[4]/td[7]/a");
					By sig = By.xpath("/html/body/my-app/div/main/my-overall/div/my-pager/div/div/a[2]");
					By txtComentario = By.id("comment");
					By btnVote = By.xpath("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/div/button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(linkView));
		driver.findElement(sig).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(linkView));
		driver.findElement(linkView).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtComentario));
		driver.findElement(txtComentario).sendKeys(texto);
		driver.findElement(btnVote).click();
			Thread.sleep(3500);
		
	}

}

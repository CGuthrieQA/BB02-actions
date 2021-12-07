package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PainterPage {

	public static final String URL = "https://www.youidraw.com/apps/painter/";

	@FindBy(css = "#brush")
	private WebElement pen;

	public void chooseBrush() {
		pen.click();
	}

}

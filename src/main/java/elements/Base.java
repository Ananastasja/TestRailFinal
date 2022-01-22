package elements;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
@NoArgsConstructor
public class Base {

    protected WebDriver driver;
    protected String label;

}



package uitest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.List;
import java.util.Random;

public class BasePage extends PageGenerator {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    // If we need we can use custom wait in BasePage and all page classes
    protected WebDriverWait wait = new WebDriverWait(this.driver, 20);

    // Click Method by using JAVA Generics (You can use both By or Webelement)
    public <T> void click(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).click();
        } else {
            ((WebElement) elementAttr).click();
        }
    }

    // Write Text by using JAVA Generics (You can use both By or Webelement)
    public <T> void writeText(T elementAttr, String text) {
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).sendKeys(text);
        } else {
            ((WebElement) elementAttr).sendKeys(text);
        }
    }

    public <T> void waitElement(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.elementToBeClickable((By) elementAttr));
        } else {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));
        }
    }

    // Read Text by using JAVA Generics (You can use both By or Webelement)
    public <T> String readText(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            return driver.findElement((By) elementAttr).getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
    }

    // Clear Text
    public <T> void clearText(T elementAttr) {
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        } else {
            ((WebElement) elementAttr).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        }
    }

    // click element from dropdown
    public <T> void click_element_from_dropdown(WebElement elementAttr, List<WebElement> element_List, String text) {
        click(elementAttr);
        for (WebElement element : element_List) {
            if (element.getText().equals(text)) {
                element.click();
                break;
            } else
                continue;
        }
    }

    // Scroll To Element
    public <T> void scrollToElement(WebElement elementAttr) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementAttr);
    }

    // Random Name write text
    public <T> void randomName(T elementAttr) {
        String[] names = { "EARL", "AMELIA", "OLIVIA", "EMILY", "AVA", "ISLA", "JESSICA", "POPPY", "ISABELLA", "SOPHIE",
                "MIA", "RUBY", "LILY", "GRACE", "EVIE", "SOPHIA", "ELLA", "SCARLETT", "CHLOE", "ISABELLE", " FREYA",
                "CHARLOTTE", "SIENNA", "DAISY", "PHOEBE", "MILLIE", "EVA", "ALICE", "LUCY", "FLORENCE", "SOFIA",
                "LAYLA", "LOLA", "HOLLY", "IMOGEN", "MOLLY", "MATILDA", "LILLY", "ROSIE", "ELIZABETH", "ERIN", "MAISIE",
                "LEXI", "ELLIE", "HANNAH", "EVELYN", "ABIGAIL", "ELSIE", "SUMMER", "MEGAN", "JASMINE", "MAYA", "AMELIE",
                "LACEY", "WILLOW", "EMMA", "BELLA", "ELEANOR", "ESME", "ELIZA", "GEORGIA", "HARRIET", "GRACIE",
                "ANNABELLE", "EMILIA", "AMBER", "IVY", "BROOKE", "ROSE", "ANNA", "ZARA", "LEAH", "MOLLIE", "MARTHA",
                "FAITH", "HOLLIE", "AMY", "BETHANY", "VIOLET", "KATIE", "MARYAM", "FRANCESCA", "JULIA", "MARIA",
                "DARCEY", "ISABEL", "TILLY", "MADDISON", "VICTORIA", "ISOBEL", "NIAMH", "SKYE", "MADISON", "DARCY",
                "AISHA", "BEATRICE", "SARAH", "ZOE", "PAIGE", "HEIDI", "LYDIA", "SARA", "OLIVER", "JACK", "HARRY",
                "JACOB", "CHARLIE", "THOMAS", "OSCAR", "WILLIAM", "JAMES", "GEORGE", "ALFIE", "JOSHUA", "NOAH", "ETHAN",
                "MUHAMMAD", "ARCHIE", "LEO", "HENRY", "JOSEPH", "SAMUEL", "RILEY", "DANIEL", "MOHAMMED", "ALEXANDER",
                "MAX", "LUCAS", "MASON", "LOGAN", "ISAAC", "BENJAMIN", "DYLAN", "JAKE", "EDWARD", "FINLEY", "FREDDIE",
                "HARRISON", "TYLER", "SEBASTIAN", "ZACHARY", "ADAM", "THEO", "JAYDEN", "ARTHUR", "TOBY", "LUKE",
                "LEWIS", "MATTHEW", "HARVEY", "HARLEY", "DAVID", "RYAN", "TOMMY", "MICHAEL", "REUBEN", "NATHAN",
                "BLAKE", "MOHAMMAD", "JENSON", "BOBBY", "LUCA", "CHARLES", "FRANKIE", "DEXTER", "KAI", "ALEX", "CONNOR",
                "LIAM", "JAMIE", "ELIJAH", "STANLEY", "LOUIE", "JUDE", "CALLUM", "HUGO", "LEON", "ELLIOT", "LOUIS",
                "THEODORE", "GABRIEL", "OLLIE", "AARON", "FREDERICK", "EVAN", "ELLIOTT", "OWEN", "TEDDY", "FINLAY",
                "CALEB", "IBRAHIM", "RONNIE", "FELIX", "AIDEN", "CAMERON", "AUSTIN", "KIAN", "RORY", "SETH", "ROBERT",
                "ALBERT", "SONNY", };
        Random random = new Random();
        String result = names[random.nextInt(names.length)];
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).sendKeys(result);
        } else {
            ((WebElement) elementAttr).sendKeys(result);
        }
    }

    // Random Email Generator
    public <T> void generateEmail(T elementAttr) {
        String[] names = { "one_sunten@yopmail.com", "two_sunten@yopmail.com", "three_sunten@yopmail.com",
                "four_sunten@yopmail.com", "five_sunten@yopmail.com" };
        Random random = new Random();
        String result = names[random.nextInt(names.length)];
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).sendKeys(result);
        } else {
            ((WebElement) elementAttr).sendKeys(result);
        }
    }

    // Random Number write
    public <T> void randomNumber(T elementAttr) {
        Random number = new Random();
        int randomnumber = number.nextInt(50);
        if (elementAttr.getClass().getName().contains("By")) {
            driver.findElement((By) elementAttr).sendKeys(String.valueOf(randomnumber));
        } else {
            ((WebElement) elementAttr).sendKeys(String.valueOf(randomnumber));
        }
    }

    // Close popup if exists
    public void handlePopup(By by) throws InterruptedException {
        List<WebElement> popup = driver.findElements(by);
        if (!popup.isEmpty()) {
            popup.get(0).click();
            Thread.sleep(200);
        }
    }

    public void assertDownload(String file) {
        File folder = new File(System.getProperty("user.home") + "/Downloads/");
        File[] listOfFiles = folder.listFiles();
        // System.out.println("Files are :" + listOfFiles);
        boolean found = false;
        File f = null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                // System.out.println("File " + listOfFile.getName());
                if (fileName.matches(file)) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(found, "Downloaded document is not found");
        System.out.println("Path of the file is: " + f.getPath());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        f.delete();
    }

    public boolean checkIfFileExists(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

}

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class TestBase(driver: WebDriver) {

    val driver: WebDriver = driver

    fun startTestObject(): Boolean {

        val batchProcessBuilder = ProcessBuilder("cmd", "/c", "startTheTestObject.bat")
        batchProcessBuilder.start()
        return true
    }

    fun openWebPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/kotlin/chromedriver.exe")
        driver.get("foo")
        driver.manage().window().maximize()
        waitForMilliseconds(5000)
    }

    fun loginTestUserUsingCredentials(usrName: String, usrPassword: String) {
        val userNameField = getTextFieldByLabelCaption("Username")
        val userPasswordField = getTextFieldByLabelCaption("Password")
        val loginButton = getButtonByCaption("Login")

        userNameField.sendKeys(usrName)
        userPasswordField.sendKeys(usrPassword)

        loginButton.click()
    }

    fun waitForMilliseconds(milliseconds: Long) {
        Thread.sleep(milliseconds)
    }

    fun getButtonByCaption(caption: String): WebElement {
        val allButtonsOnSettingsPage = driver.findElements(By.className("lm-button"))
        val filteredButtons = allButtonsOnSettingsPage.filter { it.text.contains(caption) }
        return filteredButtons.get(0)
    }

    fun getTextFieldByLabelCaption(caption: String): WebElement {

        val allFormLayoutsOnThisPage = driver.findElements(By.className("v-formlayout-row"))
        val filteredFormLayouts = allFormLayoutsOnThisPage.filter { it.findElement(By.className("v-formlayout-captioncell")).text.contains(caption) }
        val searchedTextField = filteredFormLayouts.get(0).findElement(By.className("v-textfield"))
        return searchedTextField
    }

    fun selectComboboxElementUsingLabelCaption(optionText: String, labelCaption: String) {
        val combobox = getComboboxdByLabelCaption(labelCaption)
        val window = driver.findElement(By.className("v-window"))

        combobox.click()
        waitForMilliseconds(2000)

        var i = 0
        var isEntryFound = false

        while (!isEntryFound){

            var actualElementText = driver.findElements(By.className("gwt-MenuItem")).get(i).text
            isEntryFound = actualElementText.equals(optionText)
            combobox.sendKeys(Keys.UP)
            waitForMilliseconds(700)
            i++
        }

        combobox.sendKeys(Keys.ENTER)
        waitForMilliseconds(1000)
    }

    fun getComboboxdByLabelCaption(caption: String): WebElement {

        waitForMilliseconds(2000)
        val allFormLayoutsOnThisPage = driver.findElements(By.className("v-formlayout-row"))
        val filteredFormLayouts = allFormLayoutsOnThisPage.filter { it.findElement(By.className("v-formlayout-captioncell")).text.contains(caption) }
        val searchedComboboxElement = filteredFormLayouts.get(0).findElement(By.className("v-filterselect-input"))
        return searchedComboboxElement
    }
}
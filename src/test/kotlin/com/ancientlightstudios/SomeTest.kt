
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class BatchProcessTest {

    init {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe")
    }

    private val driver = ChromeDriver() as WebDriver
    private val testBase: TestBase = TestBase(driver)
    private var isTestClassInitialized = false

    @BeforeTest
    private fun initiateTestSuite() {
        testBase.startTestObject()
        testBase.openWebPage()
        testBase.loginTestUserUsingCredentials("foo", "foo")
        testBase.waitForMilliseconds(5000)
        isTestClassInitialized = true
    }

    @Test
    private fun testUnderConstruction() {

        while (!isTestClassInitialized) {
            testBase.waitForMilliseconds(1000)
        }
        setPreconds()
    }

    private fun setPreconds() {

        prepareACategoryWithAtLeastTenEntriesAsK1()
    }

    private fun prepareACategoryWithAtLeastTenEntriesAsK1() {

        createAPattern("ffo", "foo")
        executePatterns()
        testBase.getButtonByCaption("Back").click()
        changeIntoCategory("foo")
        moveTenOfTheMovedEntriesIntoK1("foo")


    }

    private fun createAPattern(text: String, category: String) {

        val settingsButton = driver.findElements(By.className("lm-button")).get(0)
        settingsButton.click()
        testBase.waitForMilliseconds(3000)

        val addButton = testBase.getButtonByCaption("Add")
        addButton.click()

        val patternTextField = testBase.getTextFieldByLabelCaption("Pattern name")
        patternTextField.sendKeys(text)

        testBase.selectComboboxElementUsingLabelCaption(category, "Pattern name")
        testBase.waitForMilliseconds(1000)

        val saveButton = testBase.getButtonByCaption("Save")
        saveButton.click()
    }

    private fun executePatterns() {
        testBase.getButtonByCaption("Execute").click()

    }

    private fun changeIntoCategory(categoryName: String) {
        testBase.getButtonByCaption("foo").click()
        testBase.waitForMilliseconds(3000)
    }

    private fun moveTenOfTheMovedEntriesIntoK1(categoryName: String) {

        val action = Actions(driver)
        val allLines = driver.findElements(By.className("v-grid-row"))
        action.click(allLines.get(0)).perform()
        var i = 0

        while (i < 11) {
            i++
            action.click(allLines.get(i)).perform()
        }

        action.contextClick().perform()
    }

}
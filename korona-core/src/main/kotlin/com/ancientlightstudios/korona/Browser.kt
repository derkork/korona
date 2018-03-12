package com.ancientlightstudios.korona

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver


class Browser(private val contextUrl:String? = null) {
    private val driver: WebDriver

    init {
        // TODO: auto-download components..
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver")
        driver= ChromeDriver()
    }

    fun <T:Page> visit(page: T, receiver : T.()->Unit ): T  {
        page.init(driver)
        driver.get(buildUrl(page))
        page.receiver()
        return page
    }

    fun <T:Page> at(page:T, receiver: T.()->Unit):T {
        page.init(driver)
        if (!page.verify()) {
            throw NotAtPageException()
        } else {
            page.receiver()
            return page
        }

    }

    private fun buildUrl(page:Page): String {
        if (contextUrl != null) {
            return "$contextUrl/${page.location}"
        }
        return page.location
    }

    fun shutdown() {
        driver.close()
    }
}
package com.ancientlightstudios.korona

import org.openqa.selenium.WebDriver

abstract class Page(val location: String) : NavigatorBased() {

    final override lateinit var navigator: Navigator private set
    private lateinit var driver:WebDriver
    val url: String get() = driver.currentUrl

    open fun verify():Boolean = true

    fun init(driver:WebDriver) {
        this.driver = driver
        this.navigator = Navigator.from(driver)
    }



}
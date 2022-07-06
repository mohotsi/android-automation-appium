package com.mrp.automation

import com.mrp.automation
import com.mrp.automation.config.Properties.property
import io.appium.java_client.android.{AndroidDriver, AndroidElement}
import org.openqa.selenium.remote.DesiredCapabilities

import java.io.File
import java.net.URL

case class AndroidAppiumTestExecutor() {
  implicit val driver=getDriver()

  def getDriver(): AndroidDriver[AndroidElement] = {
    val cap = new DesiredCapabilities
    cap.setCapability("deviceName", property.getProperty("deviceName"))
    cap.setCapability("udid", property.getProperty("udid"))
    cap.setCapability("automationName", "UiAutomator2")
    cap.setCapability("platformName", "Android")

    cap.setCapability("platformVersion", property.getProperty("platformVersion"))
    val file= new File(property.getProperty("application.url"))
    val userDir = System.getProperty("user.dir")
    cap.setCapability("app", file.getAbsolutePath)
    val url = new URL(property.getProperty("appium.server.url"))
    new AndroidDriver[AndroidElement](url, cap)

  }

}

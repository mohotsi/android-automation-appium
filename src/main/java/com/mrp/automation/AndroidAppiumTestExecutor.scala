package com.mrp.automation

import io.appium.java_client.MobileElement
import io.appium.java_client.android.{AndroidDriver, AndroidElement}
import org.openqa.selenium.remote.DesiredCapabilities

import java.net.URL

case class AndroidAppiumTestExecutor() {
  implicit val driver=getDriver()

  def getDriver(): AndroidDriver[AndroidElement] = {
    val cap = new DesiredCapabilities
    cap.setCapability("deviceName", "HUAWEI DUB-LX2")
    cap.setCapability("udid", "YGC6R19222003926")
    cap.setCapability("automationName", "UiAutomator2")
    cap.setCapability("platformName", "Android")

    cap.setCapability("platformVersion", "8.1.0")
    val userDir = System.getProperty("user.dir")
    cap.setCapability("app", userDir + "/src/main/resources/app/MrPrice.apk")
    val url = new URL("http://0.0.0.0:4723/wd/hub")
    new AndroidDriver[AndroidElement](url, cap)

  }

}

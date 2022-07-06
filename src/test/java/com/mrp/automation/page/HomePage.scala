package com.mrp.automation.page

import com.mrp.automation.webElement.AndroidElementImplicit.Cuddle
import io.appium.java_client.android.{AndroidDriver, AndroidElement}



case class HomePage()(implicit driver:AndroidDriver[AndroidElement]) {

  def shop:AndroidElement=driver.findElementByXPath("//*[@content-desc=\"SHOP\"]/android.widget.ImageView")

  def navigateToSHop(): Unit ={
    shop.clickRetry()
  }

}

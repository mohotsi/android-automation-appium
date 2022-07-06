package com.mrp.automation.page

import com.mrp.automation.webElement.WebElementImplicit.Cuddle
import io.appium.java_client.android.{AndroidDriver, AndroidElement}


case class ShopPage()(implicit driver:AndroidDriver[AndroidElement]) {

  def ladies:AndroidElement=driver.findElementByXPath("//android.view.View[@content-desc=\"Ladies\"]/android.view.View/android.widget.TextView")

  def navigateToLadies(): Unit ={

    ladies.clickRetry()
  }

}

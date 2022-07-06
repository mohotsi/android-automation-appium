package com.mrp.automation.page

import com.mrp.automation.webElement.AndroidElementImplicit.Cuddle
import io.appium.java_client.android.{AndroidDriver, AndroidElement}


case class LadiesPage()(implicit driver:AndroidDriver[AndroidElement]) {

  def shopClothing:AndroidElement=driver.findElementByXPath("//*[@text=\"Shop Clothing\"]")

  def navigateToShopClothing(): Unit ={
    shopClothing.clickRetry()
  }

}

package com.mrp.automation.page

import com.mrp.automation.page.component.ProductComponent
import com.mrp.automation.page.data.model.ProductData
import com.mrp.automation.webElement.AndroidElementImplicit.Cuddle
import com.mrp.automation.webElement.util.eventually
import io.appium.java_client.android.{AndroidDriver, AndroidElement}

import scala.collection.convert.ImplicitConversions.{`collection AsScalaIterable`, `list asScalaBuffer`}
import scala.util.Try

case class DressesAndTunics()(implicit driver:AndroidDriver[AndroidElement]) {

  def products=driver.findElementsById("za.com.mrp:id/product_container")


  def selectProductByTitle(title:String)={
    Try(    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Slip Dress" + "\").instance(0))"))
   eventually()( driver.findElementById("za.com.mrp:id/product_container").isDisplayed())
    val  product=new ProductComponent(products.toList.filter{product=>
      eventually(){driver.executeScript("return document.readyState").toString().equals("complete")}
      new ProductComponent(product.waitUntilElementIsInDom(30)).getData().title==title}.last)
   val data=product.getData()
    product.getPrice().clickRetry()
   data
  }



}

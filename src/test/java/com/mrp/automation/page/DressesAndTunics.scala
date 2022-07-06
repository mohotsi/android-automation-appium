package com.mrp.automation.page

import com.mrp.automation.webElement.WebElementImplicit.Cuddle
import io.appium.java_client.android.{AndroidDriver, AndroidElement}

import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`

case class DressesAndTunics()(implicit driver:AndroidDriver[AndroidElement]) {

  def products=driver.findElementsById("za.com.mrp:id/product_container")

  def getProduct(item:AndroidElement=>Boolean) ={
    products.filter(item)
      .head

  }


  //*[@id='za.com.mrp:id/category_list_recycler']/

}

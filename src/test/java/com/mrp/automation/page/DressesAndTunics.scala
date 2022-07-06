package com.mrp.automation.page

import com.mrp.automation.page.component.ProductComponent
import com.mrp.automation.page.data.model.ProductData
import com.mrp.automation.webElement.AndroidElementImplicit.Cuddle
import io.appium.java_client.android.{AndroidDriver, AndroidElement}

import scala.collection.convert.ImplicitConversions.{`collection AsScalaIterable`, `list asScalaBuffer`}
import scala.util.Try

case class DressesAndTunics()(implicit driver:AndroidDriver[AndroidElement]) {

  def products=driver.findElementsById("za.com.mrp:id/product_container")


  def getProductByTitleData(title:String) ={
    Try(    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Slip Dress" + "\").instance(0))"))



     var data:ProductData=null;
    Try{data=new ProductComponent(products.toList.filter(product=>new ProductComponent(product).getData().title==title).head).getData()}
    data
  }
  def selectProductByTitle(title:String) ={
    new ProductComponent(products.toList.filter(product=>new ProductComponent(product).getData().title==title).head)
      .getImage().clickRetry()
  }


  //*[@id='za.com.mrp:id/category_list_recycler']/

}

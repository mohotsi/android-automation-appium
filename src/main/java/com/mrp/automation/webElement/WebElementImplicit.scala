package com.mrp.automation.webElement

import io.appium.java_client.android.{AndroidDriver, AndroidElement}
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.{ExpectedConditions, Select, WebDriverWait}

import java.util.concurrent.TimeUnit
import scala.util.Random

object WebElementImplicit {

  implicit class Cuddle(androidElement: =>AndroidElement)(implicit driver:AndroidDriver[AndroidElement]){

    def scrollTo()={
      //scroll until the element is visible on the screen
      driver.executeScript("arguments[0].scrollIntoView(true);", androidElement);
      //hover over the element
      val actions= new Actions(driver);
      actions.moveToElement(androidElement).perform();
      androidElement
    }
    def waitForIt(timeOutInSeconds: Int = 10) = {
      driver.manage().timeouts() implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS)
      androidElement
    }
    def  webDriverWait(): WebDriverWait  ={
     new WebDriverWait(driver, 60);
    }

    def isDisplayed(timeOutInSeconds: Int = 10) = {

      webDriverWait.until(ExpectedConditions.invisibilityOf(androidElement))
      androidElement

    }

    def clickRetry(seconds:Int=30):Unit = {
      try {
        androidElement.click()
      }
      catch {
        case e:Exception=>
          if(seconds>0) {
            Thread.sleep(1000)
            clickRetry(seconds-1)
          }
          else{
            androidElement.click()
          }
      }
    }
    def select(shownText:String)={
      val select= new Select(androidElement)
      select.selectByVisibleText(shownText)
    }
    def highlight()={
      driver.executeScript(s"arguments[0].setAttribute('style', 'background: GreenYellow; border: GreenYellow;color:black;');", androidElement)
    }
    def circle()(): Unit = {
      val width  = androidElement.getSize.width + 10;
      val height = androidElement.getSize.height + 10
      val left   = androidElement.getLocation.x - 5;
      val top    = androidElement.getLocation.y
      val bug    = Random.nextString(1000).take(4)
      driver.executeScript(
        s"""var node = document.createElement("div");node.setAttribute("class","$bug");arguments[0].appendChild(node);""".stripMargin,
        driver.findElementByXPath("//body")
      )

    }



  }
}

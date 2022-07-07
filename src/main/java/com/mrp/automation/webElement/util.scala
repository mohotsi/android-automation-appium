package com.mrp.automation.webElement

object util {


  def eventually(cnt:Int=30)(boolean: =>Boolean): Boolean ={
    try {
      if(boolean)
        true
      else if(cnt<1)
      false
      else{
      Thread.sleep(1000)
        eventually(cnt-1)(boolean)
      }
    }
    catch {
      case e:Exception=>
        if(cnt>0){
          Thread.sleep(1000)
          eventually(cnt-1)(boolean)
        }
        else
          false
    }


  }


}

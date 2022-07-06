package com.mrp.automation.runner

import io.cucumber.testng.{AbstractTestNGCucumberTests, CucumberOptions}
import org.testng.annotations.DataProvider


@CucumberOptions(features = Array("src/test/java/com/mrp/automation/feature"), glue = Array("com.mrp.automation.definition"), monochrome = true, plugin = Array("pretty", "json:target/output/HtmlReports.json", "html:target/output/HtmlReports.html"))
class TestRunner extends AbstractTestNGCucumberTests {
  @DataProvider(parallel = false) override def scenarios: Array[Array[AnyRef]] = super.scenarios
}

package org.fundacionjala.gui.runner;


import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.Logger;
import org.fundacionjala.gui.mailapp.SampleAppAutomation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


/**
 * Edited by German on 11/23/2017.
 */
public class RunCukesTest extends AbstractTestNGCucumberTests {
  private static Logger log = Logger.getLogger("RunCukesTest");

  /**
   * Starts the execution.
   */
  @BeforeTest
  public void beforeExecution() {
    try {
      //ToDo Review if this is executed only once
      SampleAppAutomation.getInstance(); //.startUp();
    } catch (Exception ex) {
      log.error("Exception in before execution", ex);
    }
  }

  /**
   * Closes the execution.
   */
  @AfterTest
  public void afterExecution() {
    try {
      SampleAppAutomation.getInstance().shutDown();
    } catch (Exception ex) {
      log.error("Exception in after execution", ex);
    }
  }


}

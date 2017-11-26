package org.fundacionjala.automationproject.runner;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.Logger;
import org.fundacionjala.automationproject.automation.Automation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by Franco Aldunate on 11/15/2017.
 */
public class RunCukesTest extends AbstractTestNGCucumberTests {
  private static Logger log = Logger.getLogger("RunCukesTest");

  /**
   * <p>This method starts the execution of the test suite.</p>
   */
  @BeforeTest
  public void beforeExecution() {
    try {
      //ToDo Review if this is executed only once
      System.out.println("Initialize");
      Automation.getInstance().startUp();
    } catch (Exception ex) {
      log.error("Exception in before execution", ex);
    }
  }

  /**
   * <p>This method closes the execution of the test suite.</p>
   */
  @AfterTest
  public void afterExecution() {
    try {
      Automation.getInstance().shutDown();
    } catch (Exception ex) {
      log.error("Exception in after execution", ex);
    }
  }
}

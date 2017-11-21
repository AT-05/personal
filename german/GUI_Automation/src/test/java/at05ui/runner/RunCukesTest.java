package at05ui.runner;


import at05ui.sampleapp.SampleAppAutomation;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class RunCukesTest extends AbstractTestNGCucumberTests {
    private static Logger log = Logger.getLogger("RunCukesTest");

    /**
     * Starts the execution
     */
    @BeforeTest
    public void beforeExecution() {
        try {
            //ToDo Review if this is executed only once
            SampleAppAutomation.getInstance();//.startUp();
        } catch (Exception ex) {
            log.error("Exception in before execution", ex);
        }
    }

    /**
     * Closes the execution
     *
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

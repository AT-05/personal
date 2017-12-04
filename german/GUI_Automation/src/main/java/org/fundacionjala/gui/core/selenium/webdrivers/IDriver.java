package org.fundacionjala.gui.core.selenium.webdrivers;

import org.openqa.selenium.WebDriver;
/**
 * Edited by German on 11/23/2017.
 */
interface IDriver {
  /**
   * <p>This method instances a IDriver Browser.</p>
   *
   * @return an implementation of WebDriver.
   */
  WebDriver initDriver();
}

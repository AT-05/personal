package org.fundacionjala.automationproject.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Franco Aldunate on 11/21/2017.
 */
public class AddressInfo {
  public static final String ADDRESS = "address";
  public static final String CITY = "city";
  public static final String STATE = "state";
  public static final String ZIP = "zip";
  public static final String COUNTRY = "country";

  private final Map<String, String> addressInfo;

  /**
   * <p>This constructor initializes the map.</p>
   */
  public AddressInfo() {
    addressInfo = new HashMap<>();
  }


  /**
   * <p>This method adds elements to the map.</p>
   *
   * @param key   is the value key.
   * @param value is the given value to store in the map.
   */
  public void addField(String key, String value) {
    addressInfo.put(key, value);
  }

  /**
   * <p>This method returns the address info map.</p>
   *
   * @return a Map object type.
   */
  public Map<String, String> getAddressInfo() {
    return addressInfo;
  }
}

package org.fundacionjala.automationproject.entities;

import java.util.List;

/**
 * Created by Franco Aldunate on 11/24/2017.
 */
public class Address {
  private String address;
  private String city;
  private String state;
  private String zip;
  private String country;

  /**
   * <p>This method sets address value.</p>
   *
   * @param address is the address value given.
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * <p>This method sets city value.</p>
   *
   * @param city is the city value given.
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * <p>This method sets state value.</p>
   *
   * @param state is the state value given.
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * <p>This method sets postal code value.</p>
   *
   * @param zip is the postal code value given.
   */
  public void setZip(String zip) {
    this.zip = zip;
  }

  /**
   * <p>This method sets country value.</p>
   *
   * @param country is the country value given.
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * <p>This method gets passenger address.</p>
   *
   * @return address value.
   */
  public String getAddress() {
    return address;
  }

  /**
   * <p>This method gets passenger city.</p>
   *
   * @return city value.
   */
  public String getCity() {
    return city;
  }

  /**
   * <p>This method gets passenger state.</p>
   *
   * @return state value.
   */
  public String getState() {
    return state;
  }

  /**
   * <p>This method gets passenger postal code.</p>
   *
   * @return postal code value.
   */
  public String getZip() {
    return zip;
  }

  /**
   * <p>This method gets passenger country.</p>
   *
   * @return country value.
   */
  public String getCountry() {
    return country;
  }

  /**
   * <p>This method sets all class variable values.</p>
   *
   * @param addressList is a list of Address object type.
   */
  public void setData(List<Address> addressList) {
    for (Address itemAddress : addressList) {
      address = itemAddress.getAddress();
      city = itemAddress.getCity();
      state = itemAddress.getState();
      zip = itemAddress.getZip();
      country = itemAddress.getCountry();
    }
  }
}

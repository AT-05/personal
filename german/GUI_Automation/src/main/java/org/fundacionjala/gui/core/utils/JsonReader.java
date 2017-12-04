package org.fundacionjala.gui.core.utils;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Util used to read the configurations from the json file
 * Created by Silvia Valencia on 3/23/2015.
 */
public class JsonReader {

  private Logger log = Logger.getLogger(getClass());
  private JSONObject jsonObjectMain;

  /**
   * <p>This constructor executes parsing of JSON file.</p>
   *
   * @param filePath is the name o the input file.
   */
  public JsonReader(String filePath) {
    parseJSON(filePath);
  }

  /**
   * <p>This method parses the JSON file into a JSONObject.</p>
   *
   * @param filePath is the name o the input file.
   */
  private void parseJSON(String filePath) {
    try {
      FileReader reader = new FileReader(filePath);
      JSONParser jsonParser = new JSONParser();
      jsonObjectMain = (JSONObject) jsonParser.parse(reader);
    } catch (FileNotFoundException ex) {
      log.error("FileNotFoundException when reading the configuration file ", ex);
    } catch (ParseException ex) {
      log.error("ParseException when reading the configuration file ", ex);
    } catch (IOException ex) {
      log.error("IOException when reading the configuration file ", ex);
    } catch (NullPointerException ex) {
      log.error("NullPointerException when reading the configuration file ", ex);
    }
  }

  /**
   * <p>This method returns the JSONObject key.</p>
   *
   * @param key is the key of the JSON value.
   * @return the JSONObject value requested.
   */
  private JSONObject getJSONObject(String key) {
    return (JSONObject) jsonObjectMain.get(key);
  }

  /**
   * <p>This method returns the JSONObject value given a key
   * from a JSONObject instance.</p>
   *
   * @param jsonObject is a JSONObject object type.
   * @param key        is the key of the JSON value.
   * @return the JSONObject value requested.
   */
  private JSONObject getJSONObject(JSONObject jsonObject, String key) {
    return (JSONObject) jsonObject.get(key);
  }

  /**
   * <p>This method returns a String representation
   * of the JSONObject value given a key
   * from a JSONObject instance.</p>
   *
   * @param jsonObject is a JSONObject object type.
   * @param key        is the key of the JSON value.
   * @return the JSONObject value requested as String.
   */
  private String getKeyValueFromJSONObject(JSONObject jsonObject, String key) {
    return (String) jsonObject.get(key);
  }

  /**
   * <p>This method returns the JsonObject which key and value
   * matche the given parameters from a jsonArray.</p>
   *
   * @param objectName is the Object name.
   * @param idKey      is the id key.
   * @param idValue    is the id value.
   * @return a JSONObject object type.
   */
  private JSONObject getJSONObjectFromArrayById(String objectName, String idKey, String idValue) {
    JSONObject jsonObject = null;
    JSONArray arr = (JSONArray) jsonObjectMain.get(objectName);
    for (Object anArr : arr) {
      jsonObject = (JSONObject) anArr;
      if (jsonObject.get(idKey).equals(idValue)) {
        break;
      }
    }
    return jsonObject;
  }

  /**
   * <p>This method returns a JSONObject from the main json
   * and then gets a value given the key.</p>
   *
   * @param objectName is the Object name.
   * @param key        is a key.
   * @return the key value.
   */
  public String getKeyValue(String objectName, String key) {
    JSONObject jsonObject = getJSONObject(objectName);
    return getKeyValueFromJSONObject(jsonObject, key);
  }

  /**
   * <p>Gets the jsonObject from the jsonArray and then gets a value given the key.</p>
   *
   * @param objectName is the Object name.
   * @param idKey      is the id key.
   * @param idValue    is the id value.
   * @param key        is a key.
   * @return the key value.
   */
  public String getKeyValue(String objectName, String idKey, String idValue, String key) {
    JSONObject jsonObject = getJSONObjectFromArrayById(objectName, idKey, idValue);
    return getKeyValueFromJSONObject(jsonObject, key);
  }

  /**
   * <p>Gets the jsonObject from the jsonArray
   * and then gets a jsonObject value and then gets a value given the key.</p>
   *
   * @param objectName is the Object name.
   * @param idKey      is the id key.
   * @param idValue    is the id value.
   * @param objectKey  is the Object key.
   * @param key        is a key.
   * @return the key value.
   */
  public String getKeyValue(String objectName, String idKey, String idValue, String objectKey,
                            String key) {
    JSONObject jsonObject = getJSONObjectFromArrayById(objectName, idKey, idValue);
    JSONObject jsonObjectInternal = getJSONObject(jsonObject, objectKey);
    return getKeyValueFromJSONObject(jsonObjectInternal, key);
  }

  /**
   * <p>Gets a hashMap which key is the user type and value
   * is a hashMap that contains the values for Name, Password.</p>
   *
   * @param objectName is the Object name.
   * @param idKey      is the id key.
   * @param idValue    is the id value.
   * @param key        is a key.
   * @return a map of Objects.
   */
  public HashMap<String, Object> getArrayKeyValues(String objectName, String idKey, String idValue,
                                                   String key) {
    JSONObject jsonObject = getJSONObjectFromArrayById(objectName, idKey, idValue);
    JSONArray arr = (JSONArray) jsonObject.get(key);

    HashMap<String, Object> arrMap = new HashMap<>();

    //Iterate all the array of jsons to add an entry (key, map) in arrValues by each json
    for (Object anArr : arr) {
      JSONObject jsonArrElement = (JSONObject) anArr;

      //Get the key of the json element
      Iterator keysItrElement = jsonArrElement.keySet().iterator();
      String arrMapKey = (String) keysItrElement.next();

      //Get the value of the json element in a map
      JSONObject jsonSubElement = (JSONObject) jsonArrElement.get(arrMapKey);
      Iterator keysItrSubElement = jsonSubElement.keySet().iterator();

      HashMap<String, String> jsonMap = new HashMap<>();
      while (keysItrSubElement.hasNext()) {
        String jsonMapKey = (String) keysItrSubElement.next();
        String jsonMapValue = (String) jsonSubElement.get(jsonMapKey);
        jsonMap.put(jsonMapKey, jsonMapValue);
      }

      //put the json element key and value in a map
      arrMap.put(arrMapKey, jsonMap);
    }
    return arrMap;
  }
}

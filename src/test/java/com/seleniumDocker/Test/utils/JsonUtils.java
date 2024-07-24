package com.seleniumDocker.Test.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seleniumDocker.Test.flightreservation.VendorPortal.model.VendorPortalTestData;
import org.testng.log4testng.Logger;

import java.io.InputStream;

public class JsonUtils {

    private static final Logger log = Logger.getLogger(JsonUtils.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static VendorPortalTestData getTestData(String path)
    {
      try(InputStream stream =  ResourceLoader.getResource(path)) {
          return mapper.readValue(stream,VendorPortalTestData.class);
      }
      catch (Exception e)
      {
          log.error("unable to read test data {}");

      }
      return null;
    }

}

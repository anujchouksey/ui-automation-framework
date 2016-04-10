package com.codewitme.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class PropertiesCache {
	private final Properties configProp = new Properties();
	   
	   private PropertiesCache()
	   {
	      InputStream in = this.getClass().getClassLoader().getResourceAsStream("QA.properties");
	      System.out.println("Read all properties from file");
	      try {
	          configProp.load(in);
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	   }

	   private static class LazyHolder
	   {
	      private static final PropertiesCache INSTANCE = new PropertiesCache();
	   }

	   public static PropertiesCache getInstance()
	   {
	      return LazyHolder.INSTANCE;
	   }
	   
	   public String getProperty(String key){
	      return configProp.getProperty(key);
	   }
	   
	   public Set<String> getAllPropertyNames(){
	      return configProp.stringPropertyNames();
	   }
	   
	   public boolean containsKey(String key){
	      return configProp.containsKey(key);
	   }
}

package com.serviceNow.drivers;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import com.net.gson.GsonClassGen;
import com.serviceNow.entities.*;
import com.serviceNow.xfers.XferBase;

@SuppressWarnings("ConstantConditions")
public class SnTester
{
  private static final SnEntityDriver<SnAstContract> astContractDriver = SnEntityDriverMap.getDriver(SnAstContract.class);
  private static final SnEntityDriver<SnAlmAsset> almAssetDriver = SnEntityDriverMap.getDriver(SnAlmAsset.class);
  private static final SnEntityDriver<SnChangeRequest> changeRequestDriver = SnEntityDriverMap.getDriver(SnChangeRequest.class);
  private static final SnEntityDriver<SnIncident> incidentDriver = SnEntityDriverMap.getDriver(SnIncident.class);
  private static final SnEntityDriver<SnProblem> problemDriver = SnEntityDriverMap.getDriver(SnProblem.class);
  private static final SnEntityDriver<SnSysUser> sysUserDriver = SnEntityDriverMap.getDriver(SnSysUser.class);
  private static final SnEntityDriver<SnCmdbCiService> businessServiceDriver = SnEntityDriverMap.getDriver(SnCmdbCiService.class);
  private static final SnEntityDriver<SnCmdbModelCategory> categoryDriver = SnEntityDriverMap.getDriver(SnCmdbModelCategory.class);

  //region entities

  private static void testIncident() throws IOException
  {
    Set<String> linkSet = new LinkedHashSet<>();
    linkSet.add("location");

    Map<String, String> varMap = new LinkedHashMap<>();
    varMap.put("short_description", "Hello there");
    varMap.put("description", "One ...");

    Map<String, SnEntity> linkMap = new LinkedHashMap<>();
    linkMap.put("caller_id", sysUserDriver.getSample());
    linkMap.put("assigned_to", sysUserDriver.getSample());
    linkMap.put("business_service", businessServiceDriver.getSample());
    linkMap.put("category", categoryDriver.getSample());

    // test entity
    SnIncident newIncident = testEntity(SnIncident.class, linkSet, varMap, linkMap);

    println(newIncident.getLinkActual("caller_id"));
    println(newIncident.getLinkActual("assigned_to"));
    println(newIncident.getLinkActual("business_service"));

    println(incidentDriver.deleteById(newIncident.sys_id));
  }

  private static void testProblem() throws IOException
  {
    System.out.println(problemDriver.getByNumber("PRB0007601"));
  }

  private static void testChangeRequest() throws IOException
  {
    System.out.println(changeRequestDriver.getByNumber("CHG0040007"));
  }

  // both the assets assigned and assets in inventory have same api
  private static void testAlmAsset() throws IOException
  {
    System.out.println(almAssetDriver.getByKey("asset_tag", "P1000241"));
  }

  private static void testAstContract() throws IOException
  {
    System.out.println(astContractDriver.getByNumber("CNTR0009001"));
  }

  //endregion

  //region generic

  private static <T extends SnEntity> void testList(Class<T> entityClass) throws IOException
  {
    SnEntityDriver<T> driver = SnEntityDriverMap.getDriver(entityClass);
    System.out.println(entityClass + " => " + driver.getList(5000).size());
  }

  private static <T extends SnEntity> void testList(Class<T> entityClass, String key, String value) throws IOException
  {
    SnEntityDriver<T> driver = SnEntityDriverMap.getDriver(entityClass);
    System.out.println(entityClass + " => " + driver.getList(5000, key, value).size());
  }

  private static void testAllLists()
  {
    for(SnEntityDriver<? extends SnEntity> driver : SnEntityDriverMap.getDrivers())
    {
      try
      {
        testList(driver.entityClass);
      }
      catch(IOException e)
      {
        System.out.println(e.getMessage());
      }
    }
  }
  
  private static <T extends SnEntity> void dumpVariables(Class<T> entityClass) throws IOException
  {
    SnEntityDriver<T> driver = SnEntityDriverMap.getDriver(entityClass);
    if(driver == null)
    {
      throw new IllegalArgumentException("Driver not found form " + entityClass.getSimpleName());
    }

    T sample = driver.getSample();
    if(sample == null)
    {
      System.out.println("No sample for " + driver.entityClass);
    }
    else
    {
      String sampleStr = sample.toPrettyString();
      System.out.println(driver.entityClass + " => " + sampleStr);
      GsonClassGen.dumpVariables(sample.getOriginal());
    }
  }

  private static <T extends SnEntity> T testEntity(Class<T> entityClass, Set<String> linkSet,
    Map<String, String> fieldMap, Map<String, SnEntity> linkMap) throws IOException
  {
    if(fieldMap == null)
    {
      fieldMap = new LinkedHashMap<>(1);
    }

    if(linkMap == null)
    {
      linkMap = new LinkedHashMap<>(1);
    }

    Map<String, String> varMap = new LinkedHashMap<>(fieldMap.size() + linkMap.size());
    varMap.putAll(fieldMap);

    for(Map.Entry<String, SnEntity> entry : linkMap.entrySet())
    {
      varMap.put(entry.getKey(), entry.getValue().getSysId());
    }
    
    testList(entityClass);

    SnEntityDriver<T> driver = SnEntityDriverMap.getDriver(entityClass);
    T sample = driver.getSample();
    if(sample == null)
    {
      return null;
    }

    String sysId = sample.getSysId();
    T entity = driver.getById(sysId);
    System.out.println("Equality by 'sys_id' passed => " + sample.equals(entity));

    String number = sample.getNumber();
    if(number != null)
    {
      entity = driver.getByNumber(number);
      System.out.println("Equality by 'number' passed => " + sample.equals(entity));
    }

    if(varMap.size() > 0)
    {
      T updatedSample = driver.update(sysId, varMap);
      T sampleCopy = sample.copy();
      sampleCopy.setFields(fieldMap);
      sampleCopy.setLinks(linkMap);
      System.out.println("Update with varMap passed => " + sampleCopy.equals(updatedSample));

      T newEntity = driver.insert(null, varMap);
      T newEntityGet = driver.getById(newEntity.getSysId());
      System.out.println("Insert passed => " + newEntity.equals(newEntityGet) + ", number = " + newEntity.getNumber());
      return newEntity;
    }

    if(linkSet != null && linkSet.size() > 0)
    {
      for(String link : linkSet)
      {
        SnEntity linkEntity = sample.getLinkActual(link);
        System.out.println("Link '" + link + "' " + (linkEntity == null ? "not found" : "found"));
      }
    }

    return null;
  }

  private static void println(SnEntity entity)
  {
    if(entity != null)
    {
      System.out.println(entity.getClass().getSimpleName() + " => " + entity.toString());
    }
  }

  //endregion

  public static void main(String[] args) throws IOException
  {
    testList(SnIncident.class);
    for(String key : XferBase.enumState.keySet())
    {
      testList(SnIncident.class, "state", XferBase.enumState.getIndex(key));
    }

    //testIncident();
    //testProblem();
    //testChangeRequest();
    //testAlmAsset();
    //testAstContract();

    //testAllLists();

    //dumpVariables(SnAstContract.class);
    //testList(SnAstContract.class);
  }
}
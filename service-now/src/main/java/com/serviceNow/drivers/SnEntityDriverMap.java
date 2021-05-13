package com.serviceNow.drivers;

import java.util.*;
import com.serviceNow.entities.*;

@SuppressWarnings("OverlyCoupledClass")
public class SnEntityDriverMap
{
  private static final Map<Class<? extends SnEntity>, SnEntityDriver<? extends SnEntity>> classMap = new LinkedHashMap<>();
  private static final Map<String, SnEntityDriver<? extends SnEntity>> tableMap = new LinkedHashMap<>();
  private static final Set<String> skippedTables = new HashSet<>();

  static
  {
    add("incident", SnIncident.class);
    add("sys_user", SnSysUser.class);
    add("sys_user_group", SnSysUserGroup.class);
    add("core_company", SnCoreCompany.class);
    add("cmn_cost_center", SnCmnCostCenter.class);
    add("cmn_department", SnCmnDepartment.class);
    add("cmn_location", SnCmnLocation.class);
    add("cmdb_ci", SnCmdbCi.class);
    add("cmdb_ci_service", SnCmdbCiService.class);
    add("cmdb_model", SnCmdbModel.class);
    add("cmdb_model_category", SnCmdbModelCategory.class);
    add("alm_asset", SnAlmAsset.class);
    add("problem", SnProblem.class);
    add("change_request", SnChangeRequest.class);
    add("change_task", SnChangeTask.class);
    add("task", SnTask.class);
    add("sc_cat_item", SnScCatItem.class);
    add("sys_phone_territory", SnSysPhoneTerritory.class);
    add("cmn_schedule", SnCmnSchedule.class);
    add("alm_stockroom", SnAlmStockRoom.class);
    add("cmdb_depreciation", SnCmdbDepreciation.class);
    add("alm_stockroom_type", SnAlmStockroomType.class);
    add("business_calendar", SnBusinessCalendar.class);
    add("sc_cat_item_delivery_plan", SnScCatItemDeliveryPlan.class);
    add("sys_scope", SnSysScope.class);
    add("sc_category", SnScCategory.class);
    add("sys_template", SnSysTemplate.class);
    add("sla", SnSla.class);
    add("sc_catalog", SnScCatalog.class);
    add("ast_contract", SnAstContract.class);

    skip("sys_package");
    skip("std_change_producer_version");
    skip("sys_hub_flow");
    skip("wf_workflow");
    skip("sys_calendar");
    skip("sys_perspective");
    skip("sc_homepage_renderer");
    skip("sys_app_module");
    skip("clm_condition_checker");
  }

  public static boolean isSkipped(String entityTable)
  {
    return skippedTables.contains(entityTable);
  }

  public static Set<SnEntityDriver<? extends SnEntity>> getDrivers()
  {
    return new TreeSet<>(tableMap.values());
  }

  public static <T extends SnEntity> SnEntityDriver<T> getDriver(Class<T> entityClass)
  {
    //noinspection unchecked
    return (SnEntityDriver<T>) classMap.get(entityClass);
  }

  public static SnEntityDriver<? extends SnEntity> getDriver(String entityTable)
  {
    return tableMap.get(entityTable);
  }

  private static <T extends SnEntity> void add(String entityTable, Class<T> entityClass)
  {
    SnEntityDriver<T> driver = new SnEntityDriver<>(entityTable, entityClass);
    if(classMap.put(entityClass, driver) != null)
    {
      throw new IllegalArgumentException("Duplicate " + entityClass);
    }

    if(tableMap.put(entityTable, driver) != null)
    {
      throw new IllegalArgumentException("Duplicate " + entityTable);
    }
  }

  private static void skip(String entityTable)
  {
    skippedTables.add(entityTable);
  }
}
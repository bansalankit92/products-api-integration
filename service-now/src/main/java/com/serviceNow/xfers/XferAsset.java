package com.serviceNow.xfers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.integration.extensions.domains.usersupport.Asset;
import com.serviceNow.drivers.SnEntityDriver;
import com.serviceNow.drivers.SnEntityDriverMap;
import com.serviceNow.entities.SnAlmAsset;
import com.serviceNow.entities.SnCmdbModel;
import com.serviceNow.entities.SnCmdbModelCategory;
import com.serviceNow.entities.SnSysUser;

public class XferAsset
{
  private static final SnEntityDriver<SnAlmAsset> assetDriver = SnEntityDriverMap.getDriver(SnAlmAsset.class);
  private static final SnEntityDriver<SnSysUser> sysUserDriver = SnEntityDriverMap.getDriver(SnSysUser.class);

  public static Asset getAssetByTag(String assetTag) throws IOException
  {
    return xfer(assetDriver.getByKey("asset_tag", assetTag));
  }

  public static List getAssetsAssignedTo(String assignedToEmail) throws IOException
  {
    SnSysUser assignedTo = sysUserDriver.getByKey("email", assignedToEmail);
    if(assignedTo != null)
    {
      Map<String, String> varMap = new LinkedHashMap<>();
      varMap.put("assigned_to", assignedTo.sys_id);
      return xfer(assetDriver.getList(10, varMap));
    }

    return Collections.emptyList();
  }

  public static Asset xfer(SnAlmAsset nativeObj) throws IOException
  {
    if(nativeObj == null)
    {
      return null;
    }

    SnCmdbModelCategory model_category = nativeObj.getLinkActual("model_category");
    SnCmdbModel model = nativeObj.getLinkActual("model");
    SnSysUser assignedTo = nativeObj.getLinkActual("assigned_to");

    Asset entity = new Asset();
    entity.sysId = nativeObj.sys_id;
    entity.assignedTo = assignedTo == null ? null : assignedTo.name;
    entity.assignedToEmail = assignedTo == null ? null : assignedTo.email;
    entity.displayName = nativeObj.display_name;
    entity.assetTag = nativeObj.asset_tag;
    entity.model = model == null ? null : model.name;
    entity.modelCategory = model_category == null ? null : model_category.name;
    return entity;
  }

  public static List<Asset> xfer(List<SnAlmAsset> list) throws IOException
  {
    List<Asset> xferList = new ArrayList<>(list.size());
    for(SnAlmAsset obj : list)
    {
      xferList.add(xfer(obj));
    }
    return xferList;
  }

  public static void main(String[] args) throws IOException
  {
    Asset p1000117 = getAssetByTag("P1000117");
    System.out.println(p1000117.displayName);

    System.out.println(getAssetsAssignedTo("miranda.hammitt@example.com").size());
  }
}
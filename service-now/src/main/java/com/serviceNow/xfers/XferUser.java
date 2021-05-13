package com.serviceNow.xfers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import com.integration.extensions.domains.usersupport.User;
import com.serviceNow.drivers.SnEntityDriver;
import com.serviceNow.drivers.SnEntityDriverMap;
import com.serviceNow.entities.SnSysUser;

public class XferUser {

    private static final SnEntityDriver<SnSysUser> sysUserDriver = SnEntityDriverMap.getDriver(SnSysUser.class);

    public static List fetchFieldsSupportingSearch() {
        //return List.of("First Name", "Last Name", "Email");
        return new ArrayList();
    }

    public static List genericSearch(Map<String, String> selectorMap) throws Exception {

        List<Pair<String, String>> res = new ArrayList<>();
        Consumer<SnSysUser> iterator = instance -> res.add(new Pair<>(instance.sys_id,
                instance.first_name + " " + instance.last_name + ", " + instance.email));
        for (Map.Entry<String, String> entry : selectorMap.entrySet()) {
            String matchPattern = entry.getValue().trim();
            String selector = entry.getKey();
            if ("First Name".equalsIgnoreCase(selector)) {
                sysUserDriver.getList(5000, "first_name", matchPattern).forEach(iterator);
            } else if ("Last Name".equalsIgnoreCase(selector)) {
                sysUserDriver.getList(5000, "last_name", matchPattern).forEach(iterator);
            } else if ("Email".equalsIgnoreCase(selector)) {
                sysUserDriver.getList(5000, "email", matchPattern).forEach(iterator);
            }
        }
        return res;
    }

    public static User getUserById(String sysId) throws IOException {
        return xfer(sysUserDriver.getById(sysId));
    }

    public static User xfer(SnSysUser nativeObj) throws IOException {
        User entity = new User();
        entity.firstName = nativeObj.first_name;
        entity.lastName = nativeObj.last_name;
        entity.email = nativeObj.email;
        entity.sysId = nativeObj.sys_id;
        return entity;
    }

    public static List<User> xfer(List<SnSysUser> list) throws IOException {
        List<User> xferList = new ArrayList<>(list.size());
        for (SnSysUser obj : list) {
            xferList.add(xfer(obj));
        }
        return xferList;
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> selectorMap = new LinkedHashMap<>();
        selectorMap.put("First Name", "Abel");
        System.out.println(genericSearch(selectorMap).size());
    }

}
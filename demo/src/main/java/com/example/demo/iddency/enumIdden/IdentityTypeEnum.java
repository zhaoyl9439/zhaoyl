package com.example.demo.iddency.enumIdden;

/**
 * 认证类型枚举
 */
public enum IdentityTypeEnum {

    SMS("SMS", "短信认证", "SmsIdentityServiceImpl"),

    ACC("ACC", "账户认证", "AccIdentityServiceImpl"),

    AD("AD", "广告认证", "AdIdentityServiceImpl");

    private String type;

    private String desc;

    /**
     * 对应的service实现类key
     */
    private String service;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    IdentityTypeEnum(String type, String desc, String service) {
        this.type = type;
        this.desc = desc;
        this.service = service;
    }

    public static IdentityTypeEnum getEnumByType(String type) {
        for (IdentityTypeEnum item : IdentityTypeEnum.values()) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        throw new RuntimeException("通过type获取枚举类时出现异常！");
    }

}

package com.example.demo.enumChannelRule;

public enum ChannelRuleEnum {

    TOUTIAO("TOUTIAO", new TouTiaoChannelRule()),

    TENCENT("TENCENT", new TencentChannelRule());

    public String name;

    public GeneralChannelRule channel;

    ChannelRuleEnum(String name, GeneralChannelRule channel) {
        this.name = name;
        this.channel = channel;
    }

    public static ChannelRuleEnum match(String name) {
        ChannelRuleEnum[] values = ChannelRuleEnum.values();
        for (ChannelRuleEnum value : values) {
            if (value.name.equals(name))
                return value;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public GeneralChannelRule getChannel() {
        return channel;
    }
}

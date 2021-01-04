package com.example.demo.enumChannelRule;

public class TestChannelRule {

    public static void main(String[] args) {
        String sign = "TOUTIAO";
        //根据对应渠道获取对应的具体实类
        ChannelRuleEnum channelRule = ChannelRuleEnum.match(sign);
        GeneralChannelRule rule = channelRule.channel;
        rule.process();

    }
}

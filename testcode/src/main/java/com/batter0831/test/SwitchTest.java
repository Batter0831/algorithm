package com.batter0831.test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Batter on 2018/5/25.
 */
public class SwitchTest {

    public static void main(String[] args) {
        GiftRestriction build = GiftRestriction.builder().type(1).order(3).build();
        initValueForRestrictions(build);
    }

    //像这种两层switch的，最好加上一个标号
    private static void initValueForRestrictions(GiftRestriction restriction) {
        outer:
        switch (restriction.getType()) {
            case 1: {
                switch (restriction.getOrder()) {
                    case 1: {
                        restriction.setValue("{\"min\":\"1.28\"}");
                        break outer;
                    }
                    case 2: {
                        restriction.setValue("{\"max\":\"30\", \"min\":\"3\"}");
                        break outer;
                    }
                    case 3: {
                        restriction.setValue("[\"market1\", \"market2\"]");
//                        break outer;
                        break;
                    }
                    case 4: {
                        restriction.setValue("[\"tournament1\", \"tournament2\"]");
                        break outer;
                    }
                    default:
                        throw new IllegalArgumentException("order value " + restriction.getOrder() + " not exist");
                }
            }
            case 2: {
                switch (restriction.getOrder()) {
                    case 1: {
                        restriction.setValue("{\"time\":\"3\", \"unit\":\"day\", \"count\":\"5\"}");
                        break outer;
                    }
                    case 2: {
                        restriction.setValue("{\"time\":\"3\", \"unit\":\"day\", \"count\":\"5\"}");
                        break outer;
                    }
                    case 3: {
                        break outer;
                    }
                    default:
                        throw new IllegalArgumentException("order value " + restriction.getOrder() + " not exist");
                }
            }
            default:
                throw new IllegalArgumentException("type value " + restriction.getType() + " not exist");
        }
    }

    @Data
    @Builder
    public static class GiftRestriction {
        private String giftRestrictionId;
        private String name;
        private Integer order;
        private Boolean enabled;
        //1：使用限制、2：领取限制
        private Integer type;
        private Boolean reverse;
        private String value;
        private String giftPlanId;
        private String giftTemplateId;
        private Date createTime;
        private Date updateTime;
        private String remark;
        private Boolean isDel;
    }
}

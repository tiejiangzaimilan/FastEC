package com.liweqnaun.fastec.generators;

import com.example.annotations.PayEntryGenerator;
import com.liweqnaun.latte.wxtemplate.WXPayEntryTemplate;

/**
 * Created by liweqnaun on 2018/1/31.
 */
@PayEntryGenerator(
        packageName = "com.liweqnaun.fastec",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}

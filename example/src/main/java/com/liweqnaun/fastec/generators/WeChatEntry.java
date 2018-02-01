package com.liweqnaun.fastec.generators;

import com.example.annotations.EntryGenerator;
import com.liweqnaun.latte.wxtemplate.WXEntryTemplate;

/**
 * Created by liweqnaun on 2018/1/31.
 */
@EntryGenerator(packageName = "com.liweqnaun.fastec",
entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}

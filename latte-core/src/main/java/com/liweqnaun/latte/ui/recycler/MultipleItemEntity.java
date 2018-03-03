package com.liweqnaun.latte.ui.recycler;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.WeakHashMap;

/**
 * Created by liweqnaun on 2018/2/1.
 */

public class MultipleItemEntity implements MultiItemEntity {
    //内存溢出的话 自动释放内存
    private final ReferenceQueue<LinkedHashMap<Object,Object>> ITEM_QUENE = new ReferenceQueue<>();
    private final LinkedHashMap<Object,Object> MULTIPLE_FIELDS = new LinkedHashMap<>();
    private final SoftReference<LinkedHashMap<Object,Object>> FIELDS_REFERENCE = new
            SoftReference<LinkedHashMap<Object, Object>>(MULTIPLE_FIELDS,ITEM_QUENE);

    public MultipleItemEntity(LinkedHashMap<Object,Object> fields) {
        FIELDS_REFERENCE.get().putAll(fields);
    }

    public static MultipleItemEntityBuilder builder() {
        return new MultipleItemEntityBuilder();
    }
    //每一个Item的样式
    @Override
    public int getItemType() {
        return (int) FIELDS_REFERENCE.get().get(MultipleFields.ITEM_TYPE);
    }
    public final <T> T getField(Object key) {
        return (T) FIELDS_REFERENCE.get().get(key);
    }
    public final LinkedHashMap<?,?> getFields() {
        return FIELDS_REFERENCE.get();
    }
    public final MultiItemEntity setField(Object key,Object value) {
        FIELDS_REFERENCE.get().put(key,value);
        return this;
    }
}

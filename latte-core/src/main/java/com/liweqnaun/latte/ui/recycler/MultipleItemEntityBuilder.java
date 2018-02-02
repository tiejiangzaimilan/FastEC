package com.liweqnaun.latte.ui.recycler;

import java.util.LinkedHashMap;
import java.util.WeakHashMap;

/**
 * Created by liweqnaun on 2018/2/1.
 * 这个模式在RestClient和RestClientBuilder的时候用过
 */

public class MultipleItemEntityBuilder {
    private static final LinkedHashMap<Object,Object> FIELDS = new LinkedHashMap<>();

    public MultipleItemEntityBuilder() {
        //先清除之前的数据
        FIELDS.clear();
    }
    public final MultipleItemEntityBuilder setItemType(int itemType) {
        FIELDS.put(MultipleFields.ITEM_TYPE,itemType);
        return this;
    }
    public final MultipleItemEntityBuilder setField(Object key,Object value) {
        FIELDS.put(key,value);
        return this;
    }
    public final MultipleItemEntityBuilder setFields(LinkedHashMap<?,?> map) {
        FIELDS.putAll(map);
        return this;
    }
    public final MultipleItemEntity build() {
         return new MultipleItemEntity(FIELDS);
    }

}

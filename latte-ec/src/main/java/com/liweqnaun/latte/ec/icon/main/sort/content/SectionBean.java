package com.liweqnaun.latte.ec.icon.main.sort.content;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by liweqnaun on 2018/2/2.
 */

public class SectionBean extends SectionEntity<SectionContentItemEntity> {
    //大坨datas是bean，每个商品的信息是SectionContentItemEntity
    private boolean mIsMore = false;
    private int mId = -1;

    public boolean isIsMore() {
        return mIsMore;
    }

    public void setIsMore(boolean isMore) {
        this.mIsMore = isMore;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public SectionBean(SectionContentItemEntity sectionContentItemEntity) {
        super(sectionContentItemEntity);
    }

    public SectionBean(boolean isHeader, String header) {
        super(isHeader, header);
    }

}

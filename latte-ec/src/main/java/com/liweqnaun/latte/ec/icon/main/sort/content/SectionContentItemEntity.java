package com.liweqnaun.latte.ec.icon.main.sort.content;

/**
 * Created by liweqnaun on 2018/2/2.
 */

public class SectionContentItemEntity {
    private int mGoodsId = 0;
    private String mGoodsName = null;
    private String mGoodsThumb = null;

    public int getGoodsId() {
        return mGoodsId;
    }

    public void setGoodsId(int goodsId) {
        this.mGoodsId = goodsId;
    }

    public String getGoodsName() {
        return mGoodsName;
    }

    public String getGoodsThumb() {
        return mGoodsThumb;
    }

    public void setGoodsThumb(String goodsThumb) {
        this.mGoodsThumb = goodsThumb;
    }

    public void setGoodsName(String goodsName) {
        this.mGoodsName = goodsName;
    }
}

package com.liweqnaun.latte.ec.icon.main.sort.list;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.liweqnaun.latte.delegates.LatteDelegate;
import com.liweqnaun.latte.ec.R;
import com.liweqnaun.latte.ec.icon.main.sort.SortDelegate;
import com.liweqnaun.latte.ec.icon.main.sort.content.ContentDelegate;
import com.liweqnaun.latte.ui.recycler.ItemType;
import com.liweqnaun.latte.ui.recycler.MultipleFields;
import com.liweqnaun.latte.ui.recycler.MultipleItemEntity;
import com.liweqnaun.latte.ui.recycler.MultipleRecyclerAdapter;
import com.liweqnaun.latte.ui.recycler.MultipleViewHolder;

import java.util.List;

/**
 * Created by liweqnaun on 2018/2/2.
 */

public class SortRecyclerAdapter extends MultipleRecyclerAdapter {
    private final SortDelegate DELEGATE;
    private int mPrePosition = 0;
    protected SortRecyclerAdapter(List<MultipleItemEntity> data, SortDelegate delegate) {
        //把sortdelegate传进来控制左右的关联关系
        super(data);
        this.DELEGATE = delegate;
        //添加垂直菜单布局
        addItemType(ItemType.VERTICLE_MENU_LIST, R.layout.item_vertical_menu_list);
    }

    @Override
    protected void convert(final MultipleViewHolder holder, final MultipleItemEntity entity) {
        super.convert(holder, entity);
        switch (holder.getItemViewType()) {
            case ItemType.VERTICLE_MENU_LIST:
                final String text = entity.getField(MultipleFields.TEXT);
                final boolean isClicked = entity.getField(MultipleFields.TAG);
                final AppCompatTextView name = holder.getView(R.id.tv_vertical_item_name);
                final View line = holder.getView(R.id.view_line);
                final View itemView = holder.itemView;
                itemView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        final int currentPosition = holder.getAdapterPosition();
                        if(mPrePosition != currentPosition) {
                            //还原上一个
                            getData().get(mPrePosition).setField(MultipleFields.TAG,false);
                            notifyItemChanged(mPrePosition);
                            //更新选中的部分
                            entity.setField(MultipleFields.TAG,true);
                            notifyItemChanged(currentPosition);
                            mPrePosition = currentPosition;

                            final int contentId = getData().get(currentPosition).getField(MultipleFields.ID);
                            showContent(contentId);
                        }
                    }
                });
                if(!isClicked) {
                    line.setVisibility(View.INVISIBLE);
                    name.setTextColor(ContextCompat.getColor(mContext,R.color.we_chat_black));
                    itemView.setBackgroundColor(ContextCompat.getColor(mContext,R.color.item_background));
                }else {
                    line.setVisibility(View.VISIBLE);
                    name.setTextColor(ContextCompat.getColor(mContext,R.color.app_main));
                    line.setBackgroundColor(ContextCompat.getColor(mContext,R.color.app_main));
                    itemView.setBackgroundColor(Color.WHITE);
                }
                holder.setText(R.id.tv_vertical_item_name,text);
                break;
            default:
                break;
        }
    }
    private void showContent(int contentId) {
        final ContentDelegate delegate = ContentDelegate.newInstance(contentId);
        switchContent(delegate);
    }
    private void switchContent(ContentDelegate delegate) {
        final LatteDelegate contentDelegate = DELEGATE.findChildFragment(ContentDelegate.class);
//                SupportHelper.findFragment(DELEGATE.getChildFragmentManager(), ContentDelegate.class);
        if (contentDelegate != null) {
            contentDelegate.replaceFragment(delegate,false);
//            contentDelegate.getSupportDelegate().replaceFragment(delegate, false);
        }
    }
}

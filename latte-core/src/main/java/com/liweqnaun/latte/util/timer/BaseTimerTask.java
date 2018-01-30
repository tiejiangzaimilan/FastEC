package com.liweqnaun.latte.util.timer;

import java.util.TimerTask;

/**
 * Created by liweqnaun on 2018/1/29.
 */

public class BaseTimerTask extends TimerTask {
    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener timerListener) {
        this.mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if(mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }
}

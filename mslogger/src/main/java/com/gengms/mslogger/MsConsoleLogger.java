package com.gengms.mslogger;

import android.util.Log;

public class MsConsoleLogger extends AbsLogger {
    @Override
    public void v(String tag, String msg) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_V)) {
            Log.v(tag, msg);
        }
    }

    @Override
    public void i(String tag, String msg) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_I)) {
            Log.i(tag, msg);
        }
    }

    @Override
    public void d(String tag, String msg) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_D)) {
            Log.d(tag, msg);
        }
    }

    @Override
    public void w(String tag, String msg) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_W)) {
            Log.w(tag, msg);
        }
    }

    @Override
    public void e(String tag, String msg) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_E)) {
            Log.e(tag, msg);
        }
    }

    @Override
    public void v(String tag, String msg, Throwable throwable) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_V)) {
            Log.v(tag, msg, throwable);
        }
    }

    @Override
    public void i(String tag, String msg, Throwable throwable) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_I)) {
            Log.i(tag, msg, throwable);
        }
    }

    @Override
    public void d(String tag, String msg, Throwable throwable) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_D)) {
            Log.d(tag, msg, throwable);
        }
    }

    @Override
    public void w(String tag, String msg, Throwable throwable) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_W)) {
            Log.w(tag, msg, throwable);
        }
    }

    @Override
    public void e(String tag, String msg, Throwable throwable) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_E)) {
            Log.e(tag, msg, throwable);
        }
    }
}

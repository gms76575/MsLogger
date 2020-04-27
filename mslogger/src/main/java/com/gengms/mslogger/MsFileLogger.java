package com.gengms.mslogger;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MsFileLogger extends AbsLogger {

    private static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 日志的输出格式
    private static SimpleDateFormat fileNameFormat = new SimpleDateFormat("yyyy-MM-dd");// 日志文件格式
    private String mFilePath;

    public MsFileLogger(String logFilePath) {
        mFilePath = logFilePath;
    }

    @Override
    public void v(String tag, String msg) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_V)) {
            print(tag, msg, LEVEL_V, null);
        }
    }

    @Override
    public void i(String tag, String msg) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_I)) {
            print(tag, msg, LEVEL_I, null);
        }
    }

    @Override
    public void d(String tag, String msg) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_D)) {
            print(tag, msg, LEVEL_D, null);
        }
    }

    @Override
    public void w(String tag, String msg) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_W)) {
            print(tag, msg, LEVEL_W, null);
        }
    }

    @Override
    public void e(String tag, String msg) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_E)) {
            print(tag, msg, LEVEL_E, null);
        }
    }

    @Override
    public void v(String tag, String msg, Throwable throwable) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_V)) {
            print(tag, msg, LEVEL_V, throwable);
        }
    }

    @Override
    public void i(String tag, String msg, Throwable throwable) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_I)) {
            print(tag, msg, LEVEL_I, throwable);
        }
    }

    @Override
    public void d(String tag, String msg, Throwable throwable) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_D)) {
            print(tag, msg, LEVEL_D, throwable);
        }
    }

    @Override
    public void w(String tag, String msg, Throwable throwable) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_W)) {
            print(tag, msg, LEVEL_W, throwable);
        }
    }

    @Override
    public void e(String tag, String msg, Throwable throwable) {
        if (mPrintController == null || mPrintController.toPrint(LEVEL_E)) {
            print(tag, msg, LEVEL_E, throwable);
        }
    }

    private void print(String tag, String msg, char level, Throwable throwable) {
        Date curTime = new Date();
        String fileName = fileNameFormat.format(curTime);
        StringBuilder sbLine = new StringBuilder(timeFormat.format(curTime));
        sbLine.append('[').append(level).append(']').append(tag).append(':').append(msg);
        if (throwable != null) {
            sbLine.append('\n').append(throwable.toString());
        }
        File dirsFile = new File(mFilePath);
        if (!dirsFile.exists()){
            dirsFile.mkdirs();
        }
        File file = new File(mFilePath, fileName + ".log");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                Log.e("MsFileLogger", e.toString());
            }
        }
        FileWriter filerWriter = null;
        BufferedWriter bufWriter = null;
        try {
            filerWriter = new FileWriter(file, true);
            bufWriter = new BufferedWriter(filerWriter);
            bufWriter.write(sbLine.toString());
            bufWriter.newLine();
        } catch (IOException e) {
            Log.e("MsFileLogger", e.toString());
        } finally {
            close(bufWriter);
            close(filerWriter);
        }
    }

    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e("MsFileLogger", e.toString());
            }
        }
    }
}

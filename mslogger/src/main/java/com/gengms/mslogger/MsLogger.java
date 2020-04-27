package com.gengms.mslogger;

public class MsLogger {
    private static ILogger sLogger = new MsNoneLogger();
    public static void init(ILogger logger) {
        sLogger = logger;
    }
    public static void v(String tag, String msg) {
        sLogger.v(tag, msg);
    }

    public static void i(String tag, String msg) {
        sLogger.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        sLogger.d(tag, msg);
    }

    public static void w(String tag, String msg) {
        sLogger.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        sLogger.e(tag, msg);
    }

    public static void v(String tag, String msg, Throwable throwable) {
        sLogger.v(tag, msg, throwable);
    }

    public static void i(String tag, String msg, Throwable throwable) {
        sLogger.i(tag, msg, throwable);
    }

    public static void d(String tag, String msg, Throwable throwable) {
        sLogger.d(tag, msg, throwable);
    }

    public static void w(String tag, String msg, Throwable throwable) {
        sLogger.w(tag, msg, throwable);
    }

    public static void e(String tag, String msg, Throwable throwable) {
        sLogger.e(tag, msg, throwable);
    }
}

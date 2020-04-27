package com.gengms.mslogger;

public interface ILogger {
    char LEVEL_V = 'v';
    char LEVEL_I = 'i';
    char LEVEL_D = 'd';
    char LEVEL_W = 'w';
    char LEVEL_E = 'e';
    void v(String tag, String msg);
    void i(String tag, String msg);
    void d(String tag, String msg);
    void w(String tag, String msg);
    void e(String tag, String msg);
    void v(String tag, String msg, Throwable throwable);
    void i(String tag, String msg, Throwable throwable);
    void d(String tag, String msg, Throwable throwable);
    void w(String tag, String msg, Throwable throwable);
    void e(String tag, String msg, Throwable throwable);
}

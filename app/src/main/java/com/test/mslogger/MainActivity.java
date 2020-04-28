package com.test.mslogger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;

import com.gengms.mslogger.ILogger;
import com.gengms.mslogger.IPrintController;
import com.gengms.mslogger.MsConsoleLogger;
import com.gengms.mslogger.MsFileLogger;
import com.gengms.mslogger.MsLogger;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLogger();
        testLogger();
    }

    private void testLogger() {
        MsLogger.i(TAG, "iiiiiiiiiiii");
        MsLogger.d(TAG, "dddddddddddd");
        MsLogger.w(TAG, "wwwwwwwwwwww");
        MsLogger.e(TAG, "eeeeeeeeeeee");
    }
    private void initLogger() {
        ILogger logger;
        if (true/*BuildConfig.DEBUG*/) {
            logger = initDebugLogger();
        } else {
            logger = initReleaseLogger();
        }
        MsLogger.init(logger);
    }

    private ILogger initDebugLogger() {
        MsConsoleLogger consoleLogger = new MsConsoleLogger();
        consoleLogger.setPrintController(level-> true);
        return consoleLogger;
    }

    private ILogger initReleaseLogger() {
        MsFileLogger consoleLogger = new MsFileLogger(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)+"/logs");
        consoleLogger.setPrintController(level-> ILogger.LEVEL_E == level);
        return consoleLogger;
    }
}

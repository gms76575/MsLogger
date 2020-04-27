package com.test.mslogger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gengms.mslogger.ILogger;
import com.gengms.mslogger.IPrintController;
import com.gengms.mslogger.MsConsoleLogger;
import com.gengms.mslogger.MsLogger;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initConsoleLogger();
        testLogger();
    }

    private void testLogger() {
        MsLogger.i(TAG, "iiiiiiiiiiii");
        MsLogger.d(TAG, "dddddddddddd");
        MsLogger.w(TAG, "wwwwwwwwwwww");
        MsLogger.e(TAG, "eeeeeeeeeeee");
    }

    private void initConsoleLogger() {
        MsConsoleLogger consoleLogger = new MsConsoleLogger();
        consoleLogger.setPrintController(new IPrintController() {
            @Override
            public boolean toPrint(char level) {
                switch (level) {
                    case ILogger.LEVEL_E:
                    case ILogger.LEVEL_W:
                    case ILogger.LEVEL_I:
                        return true;
                    default:
                        return false;
                }
            }
        });
        MsLogger.init(consoleLogger);
    }
}

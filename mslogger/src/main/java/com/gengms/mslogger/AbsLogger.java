package com.gengms.mslogger;

public abstract class AbsLogger implements ILogger {
    protected IPrintController mPrintController;
    public void setPrintController(IPrintController printController) {
        mPrintController = printController;
    }
}

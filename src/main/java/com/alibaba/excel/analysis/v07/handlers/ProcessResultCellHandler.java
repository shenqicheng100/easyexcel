package com.alibaba.excel.analysis.v07.handlers;

import static com.alibaba.excel.constant.ExcelXmlConstants.ROW_TAG;

import org.xml.sax.Attributes;

import com.alibaba.excel.analysis.v07.XlsxCellHandler;
import com.alibaba.excel.analysis.v07.XlsxRowResultHolder;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.event.EachRowAnalysisFinishEvent;

/**
 * Cell Handler
 *
 * @author jipengfei
 */
public class ProcessResultCellHandler implements XlsxCellHandler {
    private AnalysisContext analysisContext;
    private XlsxRowResultHolder rowResultHandler;

    public ProcessResultCellHandler(AnalysisContext analysisContext, XlsxRowResultHolder rowResultHandler) {
        this.analysisContext = analysisContext;
        this.rowResultHandler = rowResultHandler;
    }

    @Override
    public boolean support(String name) {
        return ROW_TAG.equals(name);
    }

    @Override
    public void startHandle(String name, Attributes attributes) {}

    @Override
    public void endHandle(String name) {
        analysisContext.readSheetHolder()
            .notifyEndOneRow(new EachRowAnalysisFinishEvent(rowResultHandler.getCurRowContent()), analysisContext);
        rowResultHandler.clearResult();
    }

}

package org.jitesh.stockquotes.googleservice.services.crawler;

import java.util.Date;
import java.util.List;

import org.jitesh.stockquotes.livestockquotes.model.HistoricalDataBean;
import org.jitesh.stockquotes.livestockquotes.model.ScriptOverviewBean;

public interface GoogleCrawlerService {

    ScriptOverviewBean getScriptDetailInformation(String scriptCode, String marketType);

    List<HistoricalDataBean> getHistoricalData(String customerId, Date startDate, Date endDate, int noOfRow);

}

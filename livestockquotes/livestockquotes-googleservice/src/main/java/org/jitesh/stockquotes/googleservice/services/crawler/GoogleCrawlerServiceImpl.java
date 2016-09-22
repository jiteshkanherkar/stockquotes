package org.jitesh.stockquotes.googleservice.services.crawler;

import java.util.Date;
import java.util.List;

import org.jitesh.stockquotes.livestockquotes.model.HistoricalDataBean;
import org.jitesh.stockquotes.livestockquotes.model.ScriptOverviewBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogleCrawlerServiceImpl implements GoogleCrawlerService {

    @Autowired
    ScriptOverviewService scriptOverviewService;

    @Autowired
    HistoricalDataService historicalDataService;

    public ScriptOverviewBean getScriptDetailInformation(String scriptCode, String marketType) {
        ScriptOverviewBean scriptOverviewBean = null;
        try {
            scriptOverviewBean = scriptOverviewService.getScriptDetailInformation(scriptCode, marketType);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return scriptOverviewBean;
    }

    public List<HistoricalDataBean> getHistoricalData(String customerId, Date startDate, Date endDate, int noOfRow) {
        List<HistoricalDataBean> historicalDataBeans = null;
        try {
            historicalDataBeans = historicalDataService.getHistoricalData(customerId, startDate, endDate, noOfRow);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return historicalDataBeans;
    }

    public static void main(String[] args) {
        new GoogleCrawlerServiceImpl().getScriptDetailInformation("AXISBANK", "NSE");
    }
}

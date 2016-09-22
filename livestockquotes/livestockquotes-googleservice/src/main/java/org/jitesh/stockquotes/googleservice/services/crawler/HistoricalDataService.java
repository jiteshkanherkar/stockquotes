package org.jitesh.stockquotes.googleservice.services.crawler;

import java.util.Date;
import java.util.List;

import org.jitesh.stockquotes.livestockquotes.model.HistoricalDataBean;

public interface HistoricalDataService {

    List<HistoricalDataBean> getHistoricalData(String customerId, Date startDate, Date endDate, int noOfRow);
}

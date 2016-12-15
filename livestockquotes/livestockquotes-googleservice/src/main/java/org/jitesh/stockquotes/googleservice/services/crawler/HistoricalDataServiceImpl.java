package org.jitesh.stockquotes.googleservice.services.crawler;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.jitesh.stockquotes.googleservice.beans.GoogleConstant;
import org.jitesh.stockquotes.googleservice.util.DateUtil;
import org.jitesh.stockquotes.googleservice.util.JSOUPUtil;
import org.jitesh.stockquotes.googleservice.util.PropertiesReader;
import org.jitesh.stockquotes.googleservice.util.mapper.DocumentMapper;
import org.jitesh.stockquotes.livestockquotes.model.HistoricalDataBean;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class HistoricalDataServiceImpl implements HistoricalDataService {

    @Override
    public List<HistoricalDataBean> getHistoricalData(String customerId, Date startDate, Date endDate, int noOfRow) {
        List<HistoricalDataBean> historicalDataBeanList = null;
        try {
            Document htmlDocument = getHtmlDocument(customerId, startDate, endDate, noOfRow);
            if (htmlDocument == null) {
                return null;
            }

            historicalDataBeanList = new DocumentMapper().mapHistoricalDataBeans(htmlDocument);
            System.out.println(historicalDataBeanList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historicalDataBeanList;
    }

    private Document getHtmlDocument(String customerId, Date startDate, Date endDate, int noOfRow) {
        Document document = null;
        try {
            PropertiesReader propertiesReader = new PropertiesReader("GoogleConfig.properties");
            String ei = propertiesReader.getPropertyValue(GoogleConstant.EI_VALUE);
            String url = propertiesReader.getPropertyValue(GoogleConstant.GOOGLE_FINANCE_URL);

            String startDateStr = DateUtil.formatDate(startDate, "MMM dd, yyyy");
            String endDateStr = DateUtil.formatDate(endDate, "MMM dd, yyyy");

            System.out.println(startDateStr + " >> " + endDateStr);

            StringBuilder builder = new StringBuilder();
            builder.append(url).append("/historical");
            builder.append("?cid=");
            builder.append(customerId);
            builder.append("&startdate=").append(startDateStr);
            builder.append("&enddate=").append(endDateStr);
            builder.append("&num=").append(noOfRow > 0 ? noOfRow : 20);
            builder.append("&ei=").append(ei);
            String requestUrl = builder.toString();

            System.out.println("req url >> " + requestUrl);

            document = JSOUPUtil.parseHtml(requestUrl, Method.GET, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.DATE, 1);
        instance.set(Calendar.MONTH, 8);
        instance.set(Calendar.YEAR, 2016);
        new HistoricalDataServiceImpl().getHistoricalData("672834", instance.getTime(), new Date(), 20);
    }

}

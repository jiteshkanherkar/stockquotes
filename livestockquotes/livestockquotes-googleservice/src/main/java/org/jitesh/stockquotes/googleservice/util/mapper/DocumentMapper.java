package org.jitesh.stockquotes.googleservice.util.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jitesh.stockquotes.googleservice.util.DateUtil;
import org.jitesh.stockquotes.livestockquotes.model.HistoricalDataBean;
import org.jitesh.stockquotes.livestockquotes.model.ScriptOverviewBean;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DocumentMapper {

    public ScriptOverviewBean mapHtmlDocument(Document document) {
        ScriptOverviewBean scriptOverviewBean = null;
        try {
            scriptOverviewBean = new ScriptOverviewBean();

            Element shareDataElement = document.getElementById("sharebox-data");
            scriptOverviewBean.setName(getElementAttributeValue(shareDataElement, "itemprop", "name"));
            scriptOverviewBean.setTickerSymbol(getElementAttributeValue(shareDataElement, "itemprop", "tickerSymbol"));
            scriptOverviewBean.setExchange(getElementAttributeValue(shareDataElement, "itemprop", "exchange"));
            scriptOverviewBean
                    .setExchangeTimezone(getElementAttributeValue(shareDataElement, "itemprop", "exchangeTimezone"));
            scriptOverviewBean.setPrice(getElementAttributeValue(shareDataElement, "itemprop", "price"));
            scriptOverviewBean.setPriceChange(getElementAttributeValue(shareDataElement, "itemprop", "priceChange"));
            scriptOverviewBean.setPriceChangePercent(
                    getElementAttributeValue(shareDataElement, "itemprop", "priceChangePercent"));
            scriptOverviewBean.setQuoteTime(getElementAttributeValue(shareDataElement, "itemprop", "quoteTime"));
            scriptOverviewBean.setDataSource(getElementAttributeValue(shareDataElement, "itemprop", "dataSource"));
            scriptOverviewBean
                    .setPriceCurrency(getElementAttributeValue(shareDataElement, "itemprop", "priceCurrency"));
            scriptOverviewBean.setUrl(getElementAttributeValue(shareDataElement, "itemprop", "url"));
            if (scriptOverviewBean.getUrl() != null) {
                String[] split = scriptOverviewBean.getUrl().split("\\?");
                scriptOverviewBean.setCustomerId(split[1].split("=")[1]);
            }

            Elements snapElementList = document.getElementsByClass("snap-panel-and-plusone");
            Element snapElement = snapElementList.get(0);
            Elements snapTableList = snapElement.getElementsByClass("snap-data");
            Map<String, String> snapTableMap = new LinkedHashMap<String, String>();
            for (Element snapTable : snapTableList) {
                mapTRElementOfTable(snapTable, snapTableMap);
            }

            String range = snapTableMap.get("range");
            String[] ranges = range.split("-");
            scriptOverviewBean.setTodayLow(ranges[0].trim());
            scriptOverviewBean.setTodayHigh(ranges[1].trim());

            String weekRange = snapTableMap.get("range_52week");
            String[] weekRanges = weekRange.split("-");
            scriptOverviewBean.setWeekLow(weekRanges[0].trim());
            scriptOverviewBean.setWeekHigh(weekRanges[1].trim());

            scriptOverviewBean.setTodayOpen(snapTableMap.get("open").trim());
            scriptOverviewBean.setVolume(snapTableMap.get("vol_and_avg").trim());
            scriptOverviewBean.setMarketCapital(snapTableMap.get("market_cap").trim());
            scriptOverviewBean.setPriceEarningRatio(snapTableMap.get("pe_ratio").trim());

            String dividend = snapTableMap.get("latest_dividend-dividend_yield");
            String[] dividends = dividend.split("/");
            scriptOverviewBean.setLatestDividend(dividends[0].trim());
            scriptOverviewBean.setDividendYield(dividends[1].trim());

            scriptOverviewBean.setEarningPerShare(snapTableMap.get("eps").trim());
            scriptOverviewBean.setShares(snapTableMap.get("shares").trim());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return scriptOverviewBean;
    }

    private String getElementAttributeValue(Element element, String key, String value) {
        String attrValue = "";
        try {
            Elements elementsByAttributeValue = element.getElementsByAttributeValue(key, value);
            attrValue = elementsByAttributeValue.attr("content");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return attrValue;
    }

    private void mapTRElementOfTable(Element tableElement, Map<String, String> trValueMap) {
        try {
            Elements trElementList = tableElement.getElementsByTag("tr");
            for (Element trElement : trElementList) {
                Elements keyElementList = trElement.getElementsByClass("key");
                Elements valElementList = trElement.getElementsByClass("val");
                trValueMap.put(keyElementList.get(0).attr("data-snapfield"), valElementList.get(0).html());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<HistoricalDataBean> mapHistoricalDataBeans(Document document) {
        List<HistoricalDataBean> historicalDataBeans = null;
        try {
            Element elementById = document.getElementById("prices");
            Elements elementsByClass = elementById.getElementsByTag("table");
            Element historicalDataTable = elementsByClass.get(0);
            Elements elementsByTagTR = historicalDataTable.getElementsByTag("tr");
            if (elementsByTagTR == null) {
                return null;
            }
            historicalDataBeans = new ArrayList<HistoricalDataBean>();
            for (Element trElement : elementsByTagTR) {
                if (trElement.attr("class") != null && trElement.attr("class").equals("bb")) {
                    continue;
                }
                HistoricalDataBean dataBean = mapHistoricalDataBean(trElement);
                historicalDataBeans.add(dataBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historicalDataBeans;
    }

    private HistoricalDataBean mapHistoricalDataBean(Element trElement) {
        HistoricalDataBean historicalDataBean = new HistoricalDataBean();
        try {
            Elements elementsByTagTd = trElement.getElementsByTag("td");
            Date parseDate = DateUtil.parseDate(elementsByTagTd.get(0).html().trim(), "MMM dd, yyyy");
            historicalDataBean.setDate(parseDate);
            historicalDataBean.setOpenPrice(elementsByTagTd.get(1).html().trim());
            historicalDataBean.setHighPrice(elementsByTagTd.get(2).html().trim());
            historicalDataBean.setLowPrice(elementsByTagTd.get(3).html().trim());
            historicalDataBean.setClosePrice(elementsByTagTd.get(4).html().trim());
            historicalDataBean.setVolume(elementsByTagTd.get(5).html().trim());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return historicalDataBean;
    }
}

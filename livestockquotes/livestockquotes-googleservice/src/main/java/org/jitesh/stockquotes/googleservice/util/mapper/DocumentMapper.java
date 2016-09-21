package org.jitesh.stockquotes.googleservice.util.mapper;

import java.util.LinkedHashMap;
import java.util.Map;

import org.jitesh.stockquotes.livestockquotes.model.ScriptDetailBean;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DocumentMapper {

    public ScriptDetailBean mapHtmlDocument(Document document) {
        ScriptDetailBean scriptDetailBean = null;
        try {
            scriptDetailBean = new ScriptDetailBean();

            Element shareDataElement = document.getElementById("sharebox-data");
            scriptDetailBean.setName(getElementAttributeValue(shareDataElement, "itemprop", "name"));
            scriptDetailBean.setTickerSymbol(getElementAttributeValue(shareDataElement, "itemprop", "tickerSymbol"));
            scriptDetailBean.setExchange(getElementAttributeValue(shareDataElement, "itemprop", "exchange"));
            scriptDetailBean
                    .setExchangeTimezone(getElementAttributeValue(shareDataElement, "itemprop", "exchangeTimezone"));
            scriptDetailBean.setPrice(getElementAttributeValue(shareDataElement, "itemprop", "price"));
            scriptDetailBean.setPriceChange(getElementAttributeValue(shareDataElement, "itemprop", "priceChange"));
            scriptDetailBean.setPriceChangePercent(
                    getElementAttributeValue(shareDataElement, "itemprop", "priceChangePercent"));
            scriptDetailBean.setQuoteTime(getElementAttributeValue(shareDataElement, "itemprop", "quoteTime"));
            scriptDetailBean.setDataSource(getElementAttributeValue(shareDataElement, "itemprop", "dataSource"));
            scriptDetailBean.setPriceCurrency(getElementAttributeValue(shareDataElement, "itemprop", "priceCurrency"));

            Elements snapElementList = document.getElementsByClass("snap-panel-and-plusone");
            Element snapElement = snapElementList.get(0);
            Elements snapTableList = snapElement.getElementsByClass("snap-data");
            Map<String, String> snapTableMap = new LinkedHashMap<String, String>();
            for (Element snapTable : snapTableList) {
                mapTRElementOfTable(snapTable, snapTableMap);
            }

            String range = snapTableMap.get("range");
            String[] ranges = range.split("-");
            scriptDetailBean.setTodayLow(ranges[0].trim());
            scriptDetailBean.setTodayHigh(ranges[1].trim());

            String weekRange = snapTableMap.get("range_52week");
            String[] weekRanges = weekRange.split("-");
            scriptDetailBean.setWeekLow(weekRanges[0].trim());
            scriptDetailBean.setWeekHigh(weekRanges[1].trim());
            
            scriptDetailBean.setTodayOpen(snapTableMap.get("open").trim());
            scriptDetailBean.setVolume(snapTableMap.get("vol_and_avg").trim());
            scriptDetailBean.setMarketCapital(snapTableMap.get("market_cap").trim());
            scriptDetailBean.setPriceEarningRatio(snapTableMap.get("pe_ratio").trim());
            
            String dividend = snapTableMap.get("latest_dividend-dividend_yield");
            String[] dividends = dividend.split("/");
            scriptDetailBean.setLatestDividend(dividends[0].trim());
            scriptDetailBean.setDividendYield(dividends[1].trim());
            
            scriptDetailBean.setEarningPerShare(snapTableMap.get("eps").trim());
            scriptDetailBean.setShares(snapTableMap.get("shares").trim());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scriptDetailBean;
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
}

package org.jitesh.stockquotes.livestockquotes.model;

import java.io.Serializable;

public class ScriptOverviewBean implements Serializable {

    private String name;
    // scriptCode
    private String tickerSymbol;
    // marketType
    private String exchange;
    private String exchangeTimezone;
    private String price;
    private String priceChange;
    private String priceChangePercent;
    private String quoteTime;
    private String dataSource;
    private String priceCurrency;
    private String url;
    private String customerId;

    private String todayLow;
    private String todayHigh;
    private String weekLow;
    private String weekHigh;
    private String todayOpen;
    private String volume;
    private String marketCapital;
    private String priceEarningRatio;
    private String latestDividend;
    private String dividendYield;
    private String earningPerShare;
    private String shares;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getExchangeTimezone() {
        return exchangeTimezone;
    }

    public void setExchangeTimezone(String exchangeTimezone) {
        this.exchangeTimezone = exchangeTimezone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(String priceChange) {
        this.priceChange = priceChange;
    }

    public String getPriceChangePercent() {
        return priceChangePercent;
    }

    public void setPriceChangePercent(String priceChangePercent) {
        this.priceChangePercent = priceChangePercent;
    }

    public String getQuoteTime() {
        return quoteTime;
    }

    public void setQuoteTime(String quoteTime) {
        this.quoteTime = quoteTime;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public String getTodayLow() {
        return todayLow;
    }

    public void setTodayLow(String todayLow) {
        this.todayLow = todayLow;
    }

    public String getTodayHigh() {
        return todayHigh;
    }

    public void setTodayHigh(String todayHigh) {
        this.todayHigh = todayHigh;
    }

    public String getWeekLow() {
        return weekLow;
    }

    public void setWeekLow(String weekLow) {
        this.weekLow = weekLow;
    }

    public String getWeekHigh() {
        return weekHigh;
    }

    public void setWeekHigh(String weekHigh) {
        this.weekHigh = weekHigh;
    }

    public String getTodayOpen() {
        return todayOpen;
    }

    public void setTodayOpen(String todayOpen) {
        this.todayOpen = todayOpen;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getMarketCapital() {
        return marketCapital;
    }

    public void setMarketCapital(String marketCapital) {
        this.marketCapital = marketCapital;
    }

    public String getPriceEarningRatio() {
        return priceEarningRatio;
    }

    public void setPriceEarningRatio(String priceEarningRatio) {
        this.priceEarningRatio = priceEarningRatio;
    }

    public String getLatestDividend() {
        return latestDividend;
    }

    public void setLatestDividend(String latestDividend) {
        this.latestDividend = latestDividend;
    }

    public String getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(String dividendYield) {
        this.dividendYield = dividendYield;
    }

    public String getEarningPerShare() {
        return earningPerShare;
    }

    public void setEarningPerShare(String earningPerShare) {
        this.earningPerShare = earningPerShare;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "ScriptOverviewBean [name=" + name + ", tickerSymbol=" + tickerSymbol + ", exchange=" + exchange
                + ", exchangeTimezone=" + exchangeTimezone + ", price=" + price + ", priceChange=" + priceChange
                + ", priceChangePercent=" + priceChangePercent + ", quoteTime=" + quoteTime + ", dataSource="
                + dataSource + ", priceCurrency=" + priceCurrency + ", url=" + url + ", customerId=" + customerId
                + ", todayLow=" + todayLow + ", todayHigh=" + todayHigh + ", weekLow=" + weekLow + ", weekHigh="
                + weekHigh + ", todayOpen=" + todayOpen + ", volume=" + volume + ", marketCapital=" + marketCapital
                + ", priceEarningRatio=" + priceEarningRatio + ", latestDividend=" + latestDividend + ", dividendYield="
                + dividendYield + ", earningPerShare=" + earningPerShare + ", shares=" + shares + "]";
    }

}

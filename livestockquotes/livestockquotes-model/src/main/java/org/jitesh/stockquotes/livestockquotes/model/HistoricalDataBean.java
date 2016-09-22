package org.jitesh.stockquotes.livestockquotes.model;

import java.io.Serializable;
import java.util.Date;

public class HistoricalDataBean implements Serializable {

    private Date date;
    private String openPrice;
    private String highPrice;
    private String lowPrice;
    private String closePrice;
    private String volume;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(String highPrice) {
        this.highPrice = highPrice;
    }

    public String getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
    }

    public String getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "HistoricalDataBean [date=" + date + ", openPrice=" + openPrice + ", highPrice=" + highPrice
                + ", lowPrice=" + lowPrice + ", closePrice=" + closePrice + ", volume=" + volume + "]";
    }

}

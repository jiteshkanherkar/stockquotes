package org.jitesh.stockquotes.googleservice.beans;

import org.codehaus.jackson.annotate.JsonProperty;

public class GoogleScriptInfo {

    @JsonProperty("id")
    private String id;
    @JsonProperty("t")
    private String scriptCode;
    @JsonProperty("e")
    private String marketType;
    @JsonProperty("l")
    private String price;
    @JsonProperty("l_fix")
    private String currFix;
    @JsonProperty("l_cur")
    private String currPrice;
    @JsonProperty("s")
    private String s;
    @JsonProperty("ltt")
    private String lastUpdatedTime;
    @JsonProperty("lt")
    private String lastUpdatedDateTime;
    @JsonProperty("lt_dts")
    private String lastUpdatedDate;
    @JsonProperty("c")
    private String change;
    @JsonProperty("c_fix")
    private String changeFix;
    @JsonProperty("cp")
    private String changePerct;
    @JsonProperty("cp_fix")
    private String changePerctFix;
    @JsonProperty("ccol")
    private String changeCol;
    @JsonProperty("pcls_fix")
    private String priceClsFix;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScriptCode() {
        return scriptCode;
    }

    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrFix() {
        return currFix;
    }

    public void setCurrFix(String currFix) {
        this.currFix = currFix;
    }

    public String getCurrPrice() {
        return currPrice;
    }

    public void setCurrPrice(String currPrice) {
        this.currPrice = currPrice;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getLastUpdatedDateTime() {
        return lastUpdatedDateTime;
    }

    public void setLastUpdatedDateTime(String lastUpdatedDateTime) {
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChangeFix() {
        return changeFix;
    }

    public void setChangeFix(String changeFix) {
        this.changeFix = changeFix;
    }

    public String getChangePerct() {
        return changePerct;
    }

    public void setChangePerct(String changePerct) {
        this.changePerct = changePerct;
    }

    public String getChangePerctFix() {
        return changePerctFix;
    }

    public void setChangePerctFix(String changePerctFix) {
        this.changePerctFix = changePerctFix;
    }

    public String getChangeCol() {
        return changeCol;
    }

    public void setChangeCol(String changeCol) {
        this.changeCol = changeCol;
    }

    public String getPriceClsFix() {
        return priceClsFix;
    }

    public void setPriceClsFix(String priceClsFix) {
        this.priceClsFix = priceClsFix;
    }

    @Override
    public String toString() {
        return "GoogleScriptInfo [id=" + id + ", scriptCode=" + scriptCode + ", marketType=" + marketType + ", price="
                + price + ", currFix=" + currFix + ", currPrice=" + currPrice + ", s=" + s + ", lastUpdatedTime="
                + lastUpdatedTime + ", lastUpdatedDateTime=" + lastUpdatedDateTime + ", lastUpdatedDate="
                + lastUpdatedDate + ", change=" + change + ", changeFix=" + changeFix + ", changePerct=" + changePerct
                + ", changePerctFix=" + changePerctFix + ", changeCol=" + changeCol + ", priceClsFix=" + priceClsFix
                + "]";
    }

}

package org.jitesh.stockquotes.googleservice.beans;

import org.codehaus.jackson.annotate.JsonProperty;

public class GoogleScriptBean {

    @JsonProperty("t")
    private String scriptCode;
    @JsonProperty("id")
    private String scriptIndex;
    @JsonProperty("n")
    private String scriptName;
    @JsonProperty("e")
    private String marketType;

    public String getScriptCode() {
        return scriptCode;
    }

    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }

    public String getScriptIndex() {
        return scriptIndex;
    }

    public void setScriptIndex(String scriptIndex) {
        this.scriptIndex = scriptIndex;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    @Override
    public String toString() {
        return "GoogleScriptBean [scriptCode=" + scriptCode + ", scriptIndex=" + scriptIndex + ", scriptName="
                + scriptName + ", marketType=" + marketType + "]";
    }


}

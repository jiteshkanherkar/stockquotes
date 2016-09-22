package org.jitesh.stockquotes.livestockquotes.model;

import java.io.Serializable;

public class ScriptBean implements Serializable {

    private String scriptCode;
    private String customerId;
    private String scriptName;
    private String marketType;

    public String getScriptCode() {
        return scriptCode;
    }

    public void setScriptCode(String scriptCode) {
        this.scriptCode = scriptCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String scriptIndex) {
        this.customerId = scriptIndex;
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
        return "ScriptBean [scriptCode=" + scriptCode + ", scriptIndex=" + customerId + ", scriptName=" + scriptName
                + ", marketType=" + marketType + "]";
    }


}

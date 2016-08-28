package org.jitesh.stockquotes.googleservice.beans;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GoogleScriptList {

    @JsonProperty("matches")
    private List<GoogleScriptBean> scriptBeans;
    
    public List<GoogleScriptBean> getScriptBeans() {
        if (scriptBeans == null) {
            scriptBeans = new ArrayList<GoogleScriptBean>();
        }
        return scriptBeans;
    }

    @Override
    public String toString() {
        return "ScriptDetail [scriptBeans=" + scriptBeans + "]";
    }

}

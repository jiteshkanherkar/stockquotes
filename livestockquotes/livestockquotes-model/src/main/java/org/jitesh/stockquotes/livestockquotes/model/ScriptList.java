package org.jitesh.stockquotes.livestockquotes.model;

import java.util.ArrayList;
import java.util.List;

public class ScriptList {

    private List<ScriptBean> scriptBeans;

    public List<ScriptBean> getScriptBeans() {
        if (scriptBeans == null) {
            scriptBeans = new ArrayList<ScriptBean>();
        }
        return scriptBeans;
    }

    @Override
    public String toString() {
        return "ScriptDetail [scriptBeans=" + scriptBeans + "]";
    }
    
}

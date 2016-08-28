package org.jitesh.stockquotes.googleservice.services;

import org.jitesh.stockquotes.livestockquotes.model.ScriptList;

public interface GoogleStockService {

    void test();
    
    ScriptList getGoogleScriptList(String scriptName);

}

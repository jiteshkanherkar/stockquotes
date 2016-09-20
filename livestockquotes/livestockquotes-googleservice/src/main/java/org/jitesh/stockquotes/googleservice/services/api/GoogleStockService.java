package org.jitesh.stockquotes.googleservice.services.api;

import org.jitesh.stockquotes.googleservice.beans.GoogleScriptInfo;
import org.jitesh.stockquotes.googleservice.beans.GoogleScriptList;

public interface GoogleStockService {

    
    GoogleScriptList getGoogleScriptList(String scriptName);

    GoogleScriptInfo getScriptDetails(String scriptCode, String marketType);

}

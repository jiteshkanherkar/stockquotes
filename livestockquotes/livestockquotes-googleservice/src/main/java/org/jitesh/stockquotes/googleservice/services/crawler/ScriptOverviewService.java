package org.jitesh.stockquotes.googleservice.services.crawler;

import org.jitesh.stockquotes.livestockquotes.model.ScriptOverviewBean;

public interface ScriptOverviewService {

    ScriptOverviewBean getScriptDetailInformation(String scriptCode, String marketType);

}

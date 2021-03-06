package org.jitesh.stockquotes.googleservice.services.api;

import org.jitesh.stockquotes.googleservice.beans.GoogleScriptInfo;
import org.jitesh.stockquotes.googleservice.beans.GoogleScriptList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogleStockServiceImpl implements GoogleStockService {

    @Autowired
    ScriptService scriptService;

    public void test() {
        System.out.println("GoogleStockServiceImpl test");
    }

    @Override
    public GoogleScriptList getGoogleScriptList(String scriptName) {
        GoogleScriptList scriptList = null;
        try {
            scriptList = scriptService.getScriptList(scriptName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return scriptList;
    }


    public static void main(String[] args) {
        new ScriptServiceImpl().getScriptDetails("532215", "BOM");
    }

    @Override
    public GoogleScriptInfo getScriptDetails(String scriptCode, String marketType) {
        GoogleScriptInfo googleScriptInfo = null;
        try {
            googleScriptInfo = scriptService.getScriptDetails(scriptCode, marketType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return googleScriptInfo;
    }
}

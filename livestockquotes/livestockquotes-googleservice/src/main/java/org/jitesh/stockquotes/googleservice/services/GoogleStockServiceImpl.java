package org.jitesh.stockquotes.googleservice.services;

import org.jitesh.stockquotes.googleservice.beans.GoogleScriptList;
import org.jitesh.stockquotes.googleservice.util.JSONUtil;
import org.jitesh.stockquotes.googleservice.util.RestClient;
import org.jitesh.stockquotes.livestockquotes.model.ScriptList;
import org.springframework.stereotype.Service;

@Service
public class GoogleStockServiceImpl implements GoogleStockService {

    public void test() {
        System.out.println("GoogleStockServiceImpl test");
    }

    @Override
    public ScriptList getGoogleScriptList(String scriptName) {
        ScriptList scriptList = null;
        try {
            searchScript(scriptName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return scriptList;
    }

    public GoogleScriptList searchScript(String scriptName) {
        GoogleScriptList googleScriptList = null;
        String ei = "IWLBV4GsG9XmuAT40KbQBw";
        RestClient restClient = new RestClient("https://www.google.com/finance/");
        StringBuilder builder = new StringBuilder();
        builder.append("matchtype=matchall");
        builder.append("&");
        builder.append("ei=").append(ei);
        builder.append("&");
        builder.append("q=").append(scriptName);
        String request = builder.toString();
        System.out.println("request >> " + request);
        String response = restClient.processRequest(null, "match?" + request, "GET");
        System.out.println("response >> " + response);
        googleScriptList = new JSONUtil<GoogleScriptList>().convertStringToObject(response, GoogleScriptList.class);
        System.out.println(googleScriptList);
        return googleScriptList;
    }

    public static void main(String[] args) {
        new GoogleStockServiceImpl().searchScript("sbi");
    }
}

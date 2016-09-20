package org.jitesh.stockquotes.googleservice.services.api;

import org.jitesh.stockquotes.googleservice.beans.GoogleConstant;
import org.jitesh.stockquotes.googleservice.beans.GoogleScriptList;
import org.jitesh.stockquotes.googleservice.util.JSONUtil;
import org.jitesh.stockquotes.googleservice.util.PropertiesReader;
import org.jitesh.stockquotes.googleservice.util.RestClient;
import org.springframework.stereotype.Component;

@Component
public class ScriptServiceImpl implements ScriptService{

    @Override
    public GoogleScriptList getScriptList(String scriptName) {
        return searchScript(scriptName);
    }

    private GoogleScriptList searchScript(String scriptName) {
        GoogleScriptList googleScriptList = null;
        try {
            PropertiesReader propertiesReader = new PropertiesReader("GoogleConfig.properties");
            String ei = propertiesReader.getPropertyValue(GoogleConstant.EI_VALUE);
            String matchValue = propertiesReader.getPropertyValue(GoogleConstant.MATCH_TYPE);
            String url = propertiesReader.getPropertyValue(GoogleConstant.SEARCH_SCRIPT_URL);
            
            //Request generate
            StringBuilder builder = new StringBuilder();
            builder.append("matchtype=").append(matchValue);
            builder.append("&");
            builder.append("ei=").append(ei);
            builder.append("&");
            builder.append("q=").append(scriptName);
            String request = builder.toString();
            
            System.out.println("request >> " + request);
            //API call
            RestClient restClient = new RestClient(url);
            String response = restClient.processRequest(null, "match?" + request, "GET");
            System.out.println("response >> " + response);
            
            //parse response
            googleScriptList = new JSONUtil<GoogleScriptList>().convertStringToObject(response, GoogleScriptList.class);
            System.out.println(googleScriptList);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return googleScriptList;
    }

}

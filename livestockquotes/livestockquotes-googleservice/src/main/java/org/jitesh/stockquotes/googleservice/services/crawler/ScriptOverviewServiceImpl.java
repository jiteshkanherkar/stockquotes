package org.jitesh.stockquotes.googleservice.services.crawler;

import org.jitesh.stockquotes.googleservice.beans.GoogleConstant;
import org.jitesh.stockquotes.googleservice.util.JSOUPUtil;
import org.jitesh.stockquotes.googleservice.util.PropertiesReader;
import org.jitesh.stockquotes.googleservice.util.mapper.DocumentMapper;
import org.jitesh.stockquotes.livestockquotes.model.ScriptOverviewBean;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class ScriptOverviewServiceImpl implements ScriptOverviewService{

    public ScriptOverviewBean getScriptDetailInformation(String scriptCode, String marketType) {
        ScriptOverviewBean scriptOverviewBean = null;
        try {
            Document htmlDocument = getHtmlDocument(scriptCode, marketType);
            if (htmlDocument == null) {
                return null;
            }
            scriptOverviewBean = new DocumentMapper().mapHtmlDocument(htmlDocument);
            System.out.println(scriptOverviewBean);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return scriptOverviewBean;
    }

    private Document getHtmlDocument(String scriptCode, String marketType) {
        Document document = null;
        try {
            PropertiesReader propertiesReader = new PropertiesReader("GoogleConfig.properties");
            String ei = propertiesReader.getPropertyValue(GoogleConstant.EI_VALUE);
            String url = propertiesReader.getPropertyValue(GoogleConstant.GOOGLE_FINANCE_URL);

            StringBuilder builder = new StringBuilder();
            builder.append(url);
            builder.append("?q=");
            builder.append(scriptCode).append(":").append(marketType);
            builder.append("&ei=").append(ei);
            String requestUrl = builder.toString();

            System.out.println("req url >> " + requestUrl);

            document = new JSOUPUtil().parseHtml(requestUrl, Method.GET, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

}

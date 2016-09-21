package org.jitesh.stockquotes.googleservice.services.crawler;

import org.jitesh.stockquotes.googleservice.beans.GoogleConstant;
import org.jitesh.stockquotes.googleservice.util.JSOUPUtil;
import org.jitesh.stockquotes.googleservice.util.PropertiesReader;
import org.jitesh.stockquotes.googleservice.util.mapper.DocumentMapper;
import org.jitesh.stockquotes.livestockquotes.model.ScriptDetailBean;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class GoogleCrawlerServiceImpl implements GoogleCrawlerService {

    public ScriptDetailBean getScriptDetailInformation(String scriptCode, String marketType) {
        ScriptDetailBean scriptDetailBean = null;
        try {
            Document htmlDocument = getHtmlDocument(scriptCode, marketType);
            if (htmlDocument == null) {
                return null;
            }
            scriptDetailBean = new DocumentMapper().mapHtmlDocument(htmlDocument);
            System.out.println(scriptDetailBean);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return scriptDetailBean;
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

    public static void main(String[] args) {
        new GoogleCrawlerServiceImpl().getScriptDetailInformation("532215", "BOM");
    }
}

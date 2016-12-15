package org.jitesh.stockquotes.googleservice.util;

import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public final class JSOUPUtil {

    public static Document parseHtml(String htmlUrl, Method method, Map<String, String> data) {
        Document document = null;
        try {
            Connection connection = Jsoup.connect(htmlUrl);
            if (data != null && !data.isEmpty()) {
                connection.data(data);
            }
            connection.method(method);
            Response response = connection.execute();
            document = response.parse();
            System.out.println(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

    public static void main(String[] args) {
        parseHtml("https://www.google.com/finance?q=BOM:532215&ei=Xl_BV4HPOZLQuATWx7_oDQ", Method.GET,
                null);
    }

}

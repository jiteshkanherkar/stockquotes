package org.jitesh.stockquotes;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) throws IOException {
        AppTest appTest = new AppTest();
        for (int i = 0; i < 10; i++) {
            // Document parseHtml = new
//             Document parseHtml = new JSOUPUtil().parseHtml("http://localhost:8080/primefaces-1.0-SNAPSHOT/result.xhtml", Method.POST, null);
            Connection connect = Jsoup.connect("http://localhost:8080/primefaces-1.0-SNAPSHOT/primefaces-1.0-SNAPSHOT/result.xhtml;jsessionid=1xe-WE1cnh9Vxo-XmwQqBbRRJTgQZCeC_1muZtNO.localhost");
            System.out.println(connect.get());
            Response execute = connect.method(Method.POST).execute();
            System.out.println(execute.statusCode());
            System.out.println("count " + i);
        }
    }
}

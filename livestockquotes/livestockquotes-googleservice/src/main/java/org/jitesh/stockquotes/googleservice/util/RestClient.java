package org.jitesh.stockquotes.googleservice.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

public class RestClient {

    private String URL = "https://www.google.com/finance";

    public RestClient() {

    }

    public RestClient(String url) {
        this.URL = url;
    }


    public String processRequest(String request, String method, String methodType) {
        StringBuilder responseBuilder = new StringBuilder();
        try {
            // call Rest client
            ClientRequest clientRequest = new ClientRequest(URL + method);
            clientRequest.accept("application/json");

            if (request != null) {
                clientRequest.body("application/json", request);
            }
            ClientResponse<String> response = clientRequest.httpMethod(methodType, String.class);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new ByteArrayInputStream(response.getEntity().getBytes())));

            // process response
            String output;
            while ((output = br.readLine()) != null) {
                responseBuilder.append(output);
            }

        } catch (MalformedURLException ex) {

            ex.printStackTrace();

        } catch (IOException ex) {

            ex.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBuilder.toString();
    }

}

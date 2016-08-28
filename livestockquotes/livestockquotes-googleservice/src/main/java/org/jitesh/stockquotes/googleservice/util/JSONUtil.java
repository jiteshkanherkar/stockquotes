package org.jitesh.stockquotes.googleservice.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class JSONUtil<T> {

    public static final String convertObjectToString(Object object){
        String convertedString="";
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
            convertedString = objectWriter.writeValueAsString(object);
        }catch(Exception e){
            e.printStackTrace();
        }
        return convertedString;

    }
    public final T convertStringToObject(String jsonString, Class _class){
        T object=null;
        try{
            ObjectMapper objectMapper=new ObjectMapper();
             object = (T) objectMapper.readValue(jsonString, _class);
        }catch(Exception e){
            e.printStackTrace();
        }
        return object;

    }

}

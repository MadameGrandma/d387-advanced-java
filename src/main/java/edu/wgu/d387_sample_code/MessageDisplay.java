package edu.wgu.d387_sample_code;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MessageDisplay implements Runnable {

    public static List<String> messageList = new ArrayList<>();
    //public String messageArray;
    private String locale;

    //Unused default constructor
    public MessageDisplay() {
    }

    public MessageDisplay(String locale) {
        this.locale = locale;
    }

    public void readWelcomeMessage(String locale){
        Properties properties = new Properties();
        try {
            InputStream stream = new ClassPathResource(locale).getInputStream();
            properties.load(stream);
            messageList.add(properties.getProperty("welcome"));
            System.out.println("In MessageDisplay.java: " + messageList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){
        readWelcomeMessage(locale);
    }

    public List<String> getWelcomeMessage(){
        return messageList;
    }

}









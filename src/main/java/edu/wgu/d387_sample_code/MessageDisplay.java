package edu.wgu.d387_sample_code;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class MessageDisplay implements Runnable {

    static ExecutorService messageExecutor = newFixedThreadPool(5);
    //public String[] messageArray = new String[5];
    public String messageArray;
    private String locale;

    public MessageDisplay() {
    }

    public MessageDisplay(String locale) {
        this.locale = locale;
    }

    public void run(){
        getWelcomeMessage(locale);
    }

    public String getWelcomeMessage(String locale){
        Properties properties = new Properties();

        messageExecutor.execute(() -> {
            try {
                //Load english welcome message and add to array
                //InputStream stream_en = new ClassPathResource("translation_en_US.properties").getInputStream();
                InputStream stream = new ClassPathResource(locale).getInputStream();
                properties.load(stream);
                messageArray = properties.getProperty("welcome");
                System.out.println(messageArray);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        messageExecutor.shutdown();
        return messageArray;
    }



}









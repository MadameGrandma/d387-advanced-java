package edu.wgu.d387_sample_code.rest;


import edu.wgu.d387_sample_code.MessageDisplay;
import edu.wgu.d387_sample_code.model.request.ReservationRequest;
import edu.wgu.d387_sample_code.model.response.ReservableRoomResponse;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class WelcomeController {

    @RequestMapping(path = "/welcome", method = RequestMethod.GET)
    public ResponseEntity<String[]> welcomeMessage() {
        String[] messageArray = new String[2];
        List<String> messageList = new ArrayList<>();

        //English message thread
        MessageDisplay threadOne = new MessageDisplay("welcome_en.properties");
        Thread enThread = new Thread(threadOne);
        enThread.start();

        //French message thread
        MessageDisplay threadTwo = new MessageDisplay("welcome_fr.properties");
        Thread frThread = new Thread(threadTwo);
        frThread.start();

        //Wait until threads are finished
        try {
            enThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Once threads are finished, populate list.
        // This prevents serving list to front end incomplete
        messageList = threadOne.getWelcomeMessage();
        System.out.println("In WelcomeController.java: " + messageList);

        //Convert to array for better serialization
        messageArray = messageList.toArray(messageArray);
        System.out.println("In WelcomeController.java: " + Arrays.toString(messageArray));

        return new ResponseEntity<>(messageArray, HttpStatus.OK);
    }
}
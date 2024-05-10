package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.TimeZoneConversion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TimeController {

    @RequestMapping(path = "/timezones", method = RequestMethod.GET)
    public ResponseEntity<String[]> presentationTimes() throws ParseException {
        TimeZoneConversion tz = new TimeZoneConversion();
        String[] zoneArray;

        zoneArray = tz.getTimezones();

        return new ResponseEntity<>(zoneArray, HttpStatus.OK);

    }

}

package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class TimeZoneConversion {
    // Array to pass data to controller
    public static String[] zoneArray = new String[3];
    //Define current format
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    //Define desired format
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
    public void convertTimeZones() throws ParseException {

        ZoneId zUTC = ZoneId.of("UTC");
        ZoneId zEastern = ZoneId.of("America/New_York");
        ZoneId zMountain = ZoneId.of("America/Phoenix");
        //ZoneId zPacific = ZoneId.of("America/Los_Angeles");
        ZoneId zoneId = ZoneId.systemDefault();

        // Local time
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("local time "+ localDateTime.toString());
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);


        // Eastern Time
        // Define time data
        ZonedDateTime zonedDateTimeEastern = zonedDateTime.withZoneSameInstant(zEastern);
        LocalDateTime localDateTimeEastern = zonedDateTimeEastern.toLocalDateTime();
        // Parse and format time
        String stringEastern = localDateTimeEastern.toString();
        Date parseDate = sdf.parse(stringEastern);
        String output = sdf1.format(parseDate);
        zoneArray[0] = output + " EST";
        System.out.println(zoneArray[0]);


        // Mountain Time
        // Define time data
        ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(zMountain);
        LocalDateTime localDateTimeMountain = zonedDateTimeMountain.toLocalDateTime();
        // Parse and format time
        String stringMountain = localDateTimeMountain.toString();
        parseDate = sdf.parse(stringMountain);
        output = sdf1.format(parseDate);
        zoneArray[1] = " " + output + " MST";
        System.out.println(zoneArray[1]);

        // UTC
        // Define time data
        ZonedDateTime zonedDateTimeUTC = zonedDateTime.withZoneSameInstant(zUTC);
        LocalDateTime localDateTimeUTC = zonedDateTimeUTC.toLocalDateTime();
        // Parse and format time
        String stringUTC = localDateTimeUTC.toString();
        parseDate = sdf.parse(stringUTC);
        output = sdf1.format(parseDate);
        zoneArray[2] = " " + output + " UTC";
        System.out.println(zoneArray[2]);

		/* Not needed for project scope, but including for troubleshooting
        // Pacific Time
		// Define time data
        ZonedDateTime zonedDateTimePacific = zonedDateTime.withZoneSameInstant(zPacific);
        LocalDateTime localDateTimePacific = zonedDateTimePacific.toLocalDateTime();
        System.out.println("Pacific time " + localDateTimePacific.toString());
		String stringPacific = localDateTimePacific.toString();
		// Parse and format time
		Date parseDate = sdf.parse(stringPacific);
		String output = sdf1.format(parseDate);
		System.out.println(output);
		zoneArray[2] = output;
		System.out.println("Pacific Time - " + output);
		*/
    }

    public String[] getTimezones() throws ParseException {
        convertTimeZones();
        return zoneArray;
    }
}

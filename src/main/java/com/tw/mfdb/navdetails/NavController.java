package com.tw.mfdb.navdetails;

import com.tw.mfdb.navdetails.exceptions.NoNavHistoryFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class NavController {
    Logger logger = LoggerFactory.getLogger(NavController.class);

    @Autowired
    NavRepository navRepository;

    @GetMapping("/navhistory")
    public NavDetail getNavHistoryById(@RequestParam Long schemeCode, String date) throws ParseException {
        logger.info("Received request for Nav History");
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date formattedDate = formatter.parse(date);
        NavDetail navDetail =  navRepository.findBySchemeCodeAndDate(schemeCode, formattedDate);
        if (navDetail == null) {
            throw new NoNavHistoryFoundException(String.valueOf(schemeCode), date);
        }

        return navDetail;
    }
}

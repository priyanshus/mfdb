package com.tw.mfdb.schemedetails;

import com.tw.mfdb.schemedetails.exceptions.EntityNotFoundException;
import com.tw.mfdb.schemedetails.exceptions.SchemeAlreadyAddedException;
import com.tw.mfdb.common.SuccessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SchemeController {
    Logger logger = LoggerFactory.getLogger(SchemeController.class);

    @Autowired
    SchemeRepository schemeRepository;

    @GetMapping("/schemes")
    public List<Scheme> getAllSchemes() {
        return schemeRepository.findAll();
    }

    @GetMapping("/schemes/{schemeCode}")
    public Scheme getSchemeBySchemeCode(@PathVariable int schemeCode) {
        logger.info("Received request for get scheme by scheme code");
        return schemeRepository.findById((long) schemeCode)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(schemeCode)));
    }

    @PostMapping("/schemes/add")
    public SuccessResponse addNewScheme(@RequestBody Scheme scheme) {
        logger.info("Received request to add new scheme");
        boolean isExist = schemeRepository.existsById(scheme.getSchemeCode());
        if (!isExist) {
            schemeRepository.save(scheme);
        }else {
            throw new SchemeAlreadyAddedException(String.valueOf(scheme.getSchemeCode()));
        }
        return new SuccessResponse("scheme added");
    }

    @DeleteMapping("/schemes/delete/{schemeCode}")
    public SuccessResponse deleteScheme(@PathVariable int schemeCode) {
        logger.info("Received request to delete a scheme");
        boolean isExist = schemeRepository.existsById((long)schemeCode);
        if (isExist) {
            schemeRepository.deleteById((long)schemeCode);
        }else {
            throw new EntityNotFoundException(String.valueOf(schemeCode));
        }
        return new SuccessResponse("scheme deleted");
    }
}
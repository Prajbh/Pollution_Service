package com.client.pollution_service.Controller;


import com.client.pollution_service.DataObject.PollutionDTO;
import com.client.pollution_service.Service.PollutionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollutionDetailsController {

    @Autowired
    PollutionDetailsService pollutionDetailsService;

    @GetMapping("/pollution")
    public PollutionDTO getResult() {
        return pollutionDetailsService.getPollutionDetails();

    }

}

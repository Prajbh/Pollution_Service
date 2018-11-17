package com.client.pollution_service.Service;


import com.client.pollution_service.DataObject.PollutionDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PollutionDetailsService {

    public PollutionDTO getPollutionDetails() {
        PollutionDTO pollutionDTO = new PollutionDTO();
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        try {
            String encodedUrl = "http://api.airvisual.com/v2/nearest_city?key=wA4kYBguz4PbdSMzs";
            ResponseEntity<String> response = restTemplate.exchange(encodedUrl, HttpMethod.GET, entity, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            pollutionDTO.setCity(root.path("data").path("city").asText());
            pollutionDTO.setCountry(root.path("data").path("country").asText());
            pollutionDTO.setState(root.path("data").path("state").asText());
            pollutionDTO.setTemperature(root.path("data").path("current").path("weather").path("tp").asText());
            pollutionDTO.setAirQualityIndex(root.path("data").path("current").path("pollution").path("aqius").asInt());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pollutionDTO;
    }


}

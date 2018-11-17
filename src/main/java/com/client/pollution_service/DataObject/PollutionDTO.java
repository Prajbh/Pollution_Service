package com.client.pollution_service.DataObject;


import lombok.Data;


@Data
public class PollutionDTO {
    String city;
    String state;
    String country;
    String temperature;
    int airQualityIndex;

}

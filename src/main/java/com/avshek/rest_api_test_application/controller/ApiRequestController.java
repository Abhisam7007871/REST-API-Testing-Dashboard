package com.avshek.rest_api_test_application.controller;

import com.avshek.rest_api_test_application.model.ApiRequest;
import com.avshek.rest_api_test_application.repository.ApiRequestRepository;
import com.avshek.rest_api_test_application.service.ApiRequestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
@CrossOrigin("*")
public class ApiRequestController {

    @Autowired
    private ApiRequestService apiRequestService;

    @PostMapping
    public ResponseEntity<?> testApi(@RequestBody ApiRequest apiRequest){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        Map<String, String> headersMap = parseHeaders(apiRequest.getHeaders());
        headersMap.forEach(headers::set);  // Add headers from map to HttpHeaders

        HttpEntity<String> entity = new HttpEntity<>(apiRequest.getBody(), headers);

        ResponseEntity<String> response = restTemplate.exchange(
                apiRequest.getUrl(),
                HttpMethod.valueOf(apiRequest.getMethod()),
                entity,
                String.class
        );
        return  ResponseEntity.ok(apiRequest.getBody());
    }



    @GetMapping("/saved")
    public List<ApiRequest> getAllSavedRequests(){
        return apiRequestService.getAllApiRequest();
    }

    @PostMapping("/save")
    public ApiRequest saveRequest(@RequestBody ApiRequest apiRequest){
        return apiRequestService.saveApiRequest(apiRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRequest(@PathVariable Long id){
        apiRequestService.deleteApiRequest(id);
    }

    private Map<String, String> parseHeaders(String headersJson) {
        Map<String, String> headersMap = new HashMap<>();
        try{
            if(headersJson != null && !headersJson.isEmpty()){
                headersMap = new ObjectMapper().readValue(headersJson,Map.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return headersMap;

    }


}

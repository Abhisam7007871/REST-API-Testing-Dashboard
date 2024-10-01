package com.avshek.rest_api_test_application.service;

import com.avshek.rest_api_test_application.model.ApiRequest;
import com.avshek.rest_api_test_application.repository.ApiRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiRequestService {
    @Autowired
    private ApiRequestRepository apiRequestRepository;

    public List<ApiRequest> getAllApiRequest(){
        return apiRequestRepository.findAll();
    }

    public ApiRequest saveApiRequest(ApiRequest apiRequest){
        return apiRequestRepository.save(apiRequest);

    }

    public ApiRequest getApiRequestById(Long id){
        return apiRequestRepository.findById(id).orElse(null);
    }


    public void deleteApiRequest(Long id){
        apiRequestRepository.deleteById(id);
    }

}
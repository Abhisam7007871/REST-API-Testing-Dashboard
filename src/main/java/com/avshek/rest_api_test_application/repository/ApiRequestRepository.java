package com.avshek.rest_api_test_application.repository;

import com.avshek.rest_api_test_application.model.ApiRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRequestRepository extends JpaRepository<ApiRequest, Long> {
}

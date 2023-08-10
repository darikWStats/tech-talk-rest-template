package org.example.domian;

import org.example.domian.domain.ExampleStatsPerformServiceCaller;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleStatsPerformServiceCallerTest {

  private final RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

  @Test
  void testingFalseAssumptions() {
    String url = "mock url";
    var caller = new ExampleStatsPerformServiceCaller(url, restTemplate);

    Mockito.when(restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, String.class))
        .thenReturn(ResponseEntity.notFound().build());

    assertEquals(HttpStatus.NOT_FOUND, caller.makeRequest());
  }
}
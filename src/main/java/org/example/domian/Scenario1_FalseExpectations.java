package org.example.domian;

import lombok.extern.log4j.Log4j2;
import org.example.domian.domain.ExampleStatsPerformServiceCaller;
import org.springframework.web.client.RestTemplate;

/**
 *   We expected our Caller to return status code of the request according to
 *   {@link ExampleStatsPerformServiceCaller makeRequest}
 *   <h3>Result</h3>
 *   <p>
 *      {@link RestTemplate} will actually throw {@link org.springframework.web.client.HttpClientErrorException}
 *      on any 4xx and 5xx statuses and not return {@link org.springframework.http.ResponseEntity} at all!
 *   </p>
 */
@Log4j2
public class Scenario1_FalseExpectations {

  public static void main(String[] args) {

    String notARealUrl = "https://www.statsperform.com/midget";
    RestTemplate restTemplate = new RestTemplate();

    var caller = new ExampleStatsPerformServiceCaller(notARealUrl, restTemplate);
    log.info("Our Response was: {}\n", caller.makeRequest());
  }
}

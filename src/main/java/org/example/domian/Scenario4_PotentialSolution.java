package org.example.domian;

import lombok.extern.log4j.Log4j2;
import org.example.domian.domain.ExampleServiceCaller;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Potential solution requires us to at least try and catch {@link RestClientException}, which is the parent of all
 * {@link RestTemplate} error types. Worth to note that {@link HttpClientErrorException} has information about
 * both response status and response body.
 */
@Log4j2
public class Scenario4_PotentialSolution {

  public static void main(String[] args) {

    String notARealUrl = "https://www.statsperform.com/midget";
    RestTemplate restTemplate = new RestTemplate();

    var caller = new ExampleServiceCaller(notARealUrl, restTemplate);

    HttpStatus response = null;
    try {
      response = caller.makeRequest();
    } catch (HttpClientErrorException clientException) {
      log.info("We have access to status and content!");
      response = clientException.getStatusCode();
    } catch (RestClientException generalException) {
      log.info("Couldn't do much about it =( - not a response status related error");
    }

    log.info("Our Response was: {}\n", response);
  }

}

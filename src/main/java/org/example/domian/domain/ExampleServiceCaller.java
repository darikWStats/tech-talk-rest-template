package org.example.domian.domain;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

/**
 * Example of simple service with injected {@link RestTemplate}
 * <p>
 *   This can be dangerous as different configurations of rest template
 *   can result in different behaviour when things are falling apart.
 */
@AllArgsConstructor
public class ExampleServiceCaller {

  private final String url;
  private final RestTemplate restTemplate;

  /**
   * Method showing only the status of response (assuming it is even accessible!)
   */
  public HttpStatus makeRequest() {
    return restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, String.class)
        .getStatusCode();
  }
}
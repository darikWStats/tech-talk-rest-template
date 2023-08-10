package org.example.domian;

import lombok.extern.log4j.Log4j2;
import org.example.domian.domain.CustomRestTemplateErrorHandler;
import org.example.domian.domain.ExampleServiceCaller;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 *   We are overriding {@link RestTemplate} error handling to avoid errors, but they can still pop up.
 *   <h3>Result</h3>
 *   <p>
 *     As stated in {@link Scenario2_InjectedBehavior} - implementing custom {@link ResponseErrorHandler}
 *     won't cover all the cases. Following example shows that non-existing host throws
 *     {@link org.springframework.web.client.ResourceAccessException} which cannot be covered by custom handler!
 *   </p>
 */
@Log4j2
public class Scenario3_InterestingCornerCases {

  public static void main(String[] args) {

    String notARealHost = "https://www.this-doesnt-even-a-real-host.com";
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setErrorHandler(new CustomRestTemplateErrorHandler());

    var caller = new ExampleServiceCaller(notARealHost, restTemplate);
    log.info("Our Response was: {}\n", caller.makeRequest());
  }

}

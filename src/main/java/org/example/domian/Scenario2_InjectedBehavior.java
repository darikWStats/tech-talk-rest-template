package org.example.domian;

import lombok.extern.log4j.Log4j2;
import org.example.domian.domain.CustomRestTemplateErrorHandler;
import org.example.domian.domain.ExampleStatsPerformServiceCaller;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 *   Now that we know {@link RestTemplate} throws errors on different statuses we want to
 *   avoid it by overriding default behavior of {@link org.springframework.web.client.DefaultResponseErrorHandler}
 *   <h3>Result</h3>
 *   <p>
 *   It will work fine... There are two problems with that workaround though:
 *   <ul>
 *     <li>
 *       Custom {@link ResponseErrorHandler} cannot cover all the cases on which RestTemplate throws errors.
 *     </li>
 *     <li>
 *       RestTemplate is still injected from the outside to our service!
 *       Changing shared RestTemplate can impact many places.
 *       (We won't fix it in this exercise, but worth to note it)
 *     </li>
 *   </ul>
 */
@Log4j2
public class Scenario2_InjectedBehavior {

  public static void main(String[] args) {

    String notARealUrl = "https://www.statsperform.com/midget";
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setErrorHandler(new CustomRestTemplateErrorHandler());

    var caller = new ExampleStatsPerformServiceCaller(notARealUrl, restTemplate);
    log.info("Our Response was: {}\n", caller.makeRequest());
  }

}

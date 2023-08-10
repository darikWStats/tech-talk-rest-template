package org.example.domian.domain;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * Error handler which accepts all responses, not marking any of them as errors
 */
public class CustomRestTemplateErrorHandler implements ResponseErrorHandler {
  @Override
  public boolean hasError(ClientHttpResponse response) throws IOException {
    return false;
  }

  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    /* Don't need to do anything as error is never a thing */
  }

}

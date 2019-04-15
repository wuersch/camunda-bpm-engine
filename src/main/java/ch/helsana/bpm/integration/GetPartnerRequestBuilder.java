package ch.helsana.bpm.integration;

import com.example.camunda.types.GetPartner;

import org.springframework.stereotype.Component;

@Component("GetPartnerRequestBuilder")
public class GetPartnerRequestBuilder {

  public GetPartner build(String id) {
    GetPartner request = new GetPartner();
    request.setId(id);

    return request;
  }
}
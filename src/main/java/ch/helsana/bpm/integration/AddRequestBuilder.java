package ch.helsana.bpm.integration;

import org.springframework.stereotype.Component;
import org.tempuri.Add;

@Component("AddRequestBuilder")
public class AddRequestBuilder {
    Add build(String todo) {
        Add request = new Add();
        request.setIntA(2);
        request.setIntB(3);

        return request;
    }
}
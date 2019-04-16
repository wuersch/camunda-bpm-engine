package ch.helsana.bpm.integration;

import org.springframework.stereotype.Component;
import org.tempuri.Add;

@Component("AddRequestBuilder")
public class AddRequestBuilder {
    Add build(int a, int b) {
        Add request = new Add();
        request.setIntA(a);
        request.setIntB(b);

        return request;
    }
}
package ch.helsana.bpm.integration;

import org.tempuri.Add;

public class AddRequestBuilder {
    Add build(String todo) {
        Add request = new Add();
        request.setIntA(2);
        request.setIntB(3);

        return request;
    }
}
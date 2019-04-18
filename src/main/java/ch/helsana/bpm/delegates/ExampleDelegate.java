package ch.helsana.bpm.delegates;

import org.apache.camel.ProducerTemplate;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ExampleDelegate")
public class ExampleDelegate implements JavaDelegate {
	private final Logger LOGGER = LoggerFactory.getLogger(ExampleDelegate.class.getName());

	@Autowired
	private ProducerTemplate producerTemplate;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("Invocation of " + ExampleDelegate.class.getName());

		producerTemplate.sendBody("direct:example", "10070024");
	}
}
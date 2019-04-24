package ch.helsana.bpm.delegates;

import org.apache.camel.ProducerTemplate;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.StringValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("AnotherExampleDelegate")
public class AnotherExampleDelegate implements JavaDelegate {
	private final Logger LOGGER = LoggerFactory.getLogger(AnotherExampleDelegate.class.getName());

	@Autowired
	private ProducerTemplate producerTemplate;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("Invocation of " + AnotherExampleDelegate.class.getName());

		StringValue idTyped = execution.getVariableTyped("blzdetails_id");
		producerTemplate.sendBody("direct:anotherExample", idTyped.getValue());
	}
}
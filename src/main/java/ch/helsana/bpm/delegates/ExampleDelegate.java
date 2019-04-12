package ch.helsana.bpm.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleDelegate implements JavaDelegate {
	private final Logger LOGGER = LoggerFactory.getLogger(ExampleDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("Invocation of " + ExampleDelegate.class.getName());
	}
}
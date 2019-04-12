package ch.helsana.bpm.delegates;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

@Named("CreateTweetDelegate")
public class ExampleDelegate implements JavaDelegate {
	// private final Logger LOGGER = LoggerFactory.getLogger(ExampleDelegate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// LOGGER.info("Invocation of " + ExampleDelegate.class.getName());
	}
}
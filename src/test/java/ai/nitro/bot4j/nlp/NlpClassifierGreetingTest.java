package ai.nitro.bot4j.nlp;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

import ai.nitro.bot4j.TestBase;
import ai.nitro.bot4j.nlp.domain.NlpContext;

public class NlpClassifierGreetingTest extends TestBase {

	private static final String GREETING = "greeting";

	@Inject
	protected NlpClassifier nlpClassifier;

	@Test
	public void testGreeting() throws Exception {
		final NlpContext nlpContext = nlpClassifier.classify("Hi");
		assertEquals(GREETING, nlpContext.getIntent());
	}

}

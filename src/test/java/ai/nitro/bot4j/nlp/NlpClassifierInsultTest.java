package ai.nitro.bot4j.nlp;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

import ai.nitro.bot4j.TestBase;
import ai.nitro.bot4j.nlp.domain.NlpContext;

public class NlpClassifierInsultTest extends TestBase {

	private static final String INSULT = "insult";

	@Inject
	protected NlpClassifier nlpClassifier;

	@Test
	public void testInsult() throws Exception {
		final NlpContext nlpContext = nlpClassifier.classify("you are an idiot");
		assertEquals(INSULT, nlpContext.getIntent());
	}

}

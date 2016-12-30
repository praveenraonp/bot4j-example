package ai.nitro.bot4j.nlp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;

import ai.nitro.bot4j.TestBase;
import ai.nitro.bot4j.nlp.domain.NlpContext;

public class NlpClassifierWeatherTest extends TestBase {

	private static final String CITY = "city";

	private static final String WEATHER = "weather";

	@Inject
	protected NlpClassifier nlpClassifier;

	@Test
	public void testInsult() throws Exception {
		final NlpContext nlpContext = nlpClassifier.classify("how is the weather in Berlin");
		assertEquals(WEATHER, nlpContext.getIntent());
		assertNotNull(nlpContext.getNamedEntities().get(CITY));
		assertEquals("berlin", nlpContext.getNamedEntities().get(CITY)[0]);
	}

}

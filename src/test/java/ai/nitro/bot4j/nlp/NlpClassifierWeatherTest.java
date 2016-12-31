/*
 * Copyright (C) 2016, nitro.ai
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

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

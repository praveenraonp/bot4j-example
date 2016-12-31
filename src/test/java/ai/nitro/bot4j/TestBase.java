/*
 * Copyright (C) 2016, nitro.ai
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package ai.nitro.bot4j;

import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;

public abstract class TestBase {

	@Before
	public void setUp() throws Exception {
		final Injector injector = Guice.createInjector(new Module());
		injector.injectMembers(this);
	}
}

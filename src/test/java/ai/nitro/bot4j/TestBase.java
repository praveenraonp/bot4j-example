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

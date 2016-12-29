package ai.nitro.bot4j;

import com.google.inject.AbstractModule;

import ai.nitro.bot4j.bot.Bot;

public class NitroBotModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new Bot4jModule());

		bind(Bot.class).to(ExampleBotImpl.class);
	}

}

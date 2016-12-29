package ai.nitro.bot4j;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import com.google.inject.Guice;
import com.google.inject.Injector;

import ai.nitro.bot4j.integration.facebook.receive.webhook.FacebookWebhook;
import ai.nitro.bot4j.integration.slack.receive.webhook.SlackActionWebhook;
import ai.nitro.bot4j.integration.slack.receive.webhook.SlackEventWebhook;
import ai.nitro.bot4j.integration.slack.receive.webhook.SlackOAuthWebhook;

public class Application {

	public static void main(final String[] args) {
		final Injector injector = Guice.createInjector(new NitroBotModule());

		final FacebookWebhook facebookWebhook = injector.getInstance(FacebookWebhook.class);
		final SlackActionWebhook slackActionWebhook = injector.getInstance(SlackActionWebhook.class);
		final SlackEventWebhook slackEventWebhook = injector.getInstance(SlackEventWebhook.class);
		final SlackOAuthWebhook slackOAuthWebhook = injector.getInstance(SlackOAuthWebhook.class);

		if (System.getenv("PORT") != null) {
			port(Integer.valueOf(System.getenv("PORT")));
		}

		get("/facebook", (req, res) -> facebookWebhook.get(req.raw(), res.raw()));
		post("/facebook", (req, res) -> facebookWebhook.post(req.raw(), res.raw()));

		get("/slack/oauth", (req, res) -> slackOAuthWebhook.get(req.raw(), res.raw()));
		post("/slack/action", (req, res) -> slackActionWebhook.post(req.raw(), res.raw()));
		post("/slack/event", (req, res) -> slackEventWebhook.post(req.raw(), res.raw()));
	}
}

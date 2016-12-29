package ai.nitro.bot4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ai.nitro.bot4j.bot.impl.BotImpl;
import ai.nitro.bot4j.middle.domain.Participant;
import ai.nitro.bot4j.middle.domain.receive.payload.TextReceivePayload;
import ai.nitro.bot4j.nlp.domain.NlpContext;

public class ExampleBotImpl extends BotImpl {

	protected final static Logger LOG = LogManager.getLogger(ExampleBotImpl.class);

	@Override
	protected void onReceiveText(final TextReceivePayload receiveTextPayload, final Participant sender)
			throws Exception {
		final Participant recipient = sender;

		final String text = receiveTextPayload.getText();
		final NlpContext nlpContext = receiveTextPayload.getNlpContext();
		final String intent = nlpContext.getIntent();

		LOG.info("received {} with intent {}", text, intent);

		sendText("received '" + text + "' with intent " + intent, recipient);
	}

}
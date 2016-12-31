package ai.nitro.bot4j;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ai.nitro.bot4j.bot.impl.BotImpl;
import ai.nitro.bot4j.middle.domain.Participant;
import ai.nitro.bot4j.middle.domain.receive.payload.PostbackReceivePayload;
import ai.nitro.bot4j.middle.domain.receive.payload.TextReceivePayload;
import ai.nitro.bot4j.middle.domain.send.SendMessage;
import ai.nitro.bot4j.middle.domain.send.button.PostbackSendButton;
import ai.nitro.bot4j.middle.domain.send.payload.ButtonsSendPayload;
import ai.nitro.bot4j.nlp.domain.NlpContext;

public class ExampleBot extends BotImpl {

	private static final String BUTTON = "button";

	protected final static Logger LOG = LogManager.getLogger(ExampleBot.class);

	@Override
	protected void onReceivePostback(final PostbackReceivePayload postback, final Participant sender) throws Exception {
		final Participant recipient = sender;

		final String name = postback.getName();
		final String[] payload = postback.getPayload();

		switch (postback.getName()) {
		case BUTTON:
			final String joinedPayload = StringUtils.join(payload, ", ");
			sendText(joinedPayload, recipient);
			break;
		default:
			LOG.warn("Unknown postback {}", name);
		}
	}

	@Override
	protected void onReceiveText(final TextReceivePayload receiveTextPayload, final Participant sender)
			throws Exception {
		final Participant recipient = sender;

		final NlpContext nlpContext = receiveTextPayload.getNlpContext();
		final String intent = nlpContext.getIntent();
		final String text = receiveTextPayload.getText();

		LOG.info("received {} with intent {}", text, intent);

		switch (text) {
		case BUTTON:
			sendButton(text, recipient);
			break;
		default:
			sendText("received '" + text + "' with intent " + intent, recipient);
			break;
		}
	}

	protected void sendButton(final String title, final Participant recipient) {
		final SendMessage sendMessage = new SendMessage();
		sendMessage.setRecipient(recipient);

		final ButtonsSendPayload buttonsSendPayload = new ButtonsSendPayload();
		buttonsSendPayload.setTitle("some button");

		{
			final PostbackSendButton button = new PostbackSendButton();
			button.setTitle(title);
			button.setName(BUTTON);
			button.setPayload("test_payload");
			buttonsSendPayload.addButton(button);
		}

		sendMessage.addPayload(buttonsSendPayload);
		messageSender.send(sendMessage);
	}

}
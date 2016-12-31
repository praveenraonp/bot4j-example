bot4j example bot
=================

<a href="https://travis-ci.org/nitro-code/bot4j-example"><img src="https://api.travis-ci.org/nitro-code/bot4j-example.png"></a>

This is an example bot for the bot4j framework. It illustrates basic natural language processing (NLP) capabilities for recognizing greetings, insults and weather requests including named entity recognition (NER).


Getting started
---------------

* Clone or download this repo
* Start bot web server
  * In [Eclipse](https://eclipse.org) import the directory as a an `existing Maven project`. Right click class `ai.nitro.bot4j.Application`, choose `Run As` and click `Java Application`. A Jetty Web server will start on address `0.0.0.0:4567`.
  * Alternatively you can start by 

```
$ mvn clean package exec:java
```

* Optionally install [ngrok](https://ngrok.com) for exposing the web server on the internet. Start by `ngrok http 4567`.
* Facebook setup
   * Create a Facebook page, app, webhook and access token (cf. [Facebook Messenger Platform Quick Start](https://developers.facebook.com/docs/messenger-platform/guides/quick-start)).
   * Store the Facebook `access token` in file `facebook.properties` and restart the web server.
* Chat
  * In Facebook Messenger send a message to your Facebook page. Facebook should forward the message via the configured webhook to your web server.
  * `ExampleBot` will process the message and answer.
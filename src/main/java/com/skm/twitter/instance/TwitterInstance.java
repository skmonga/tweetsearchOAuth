package com.skm.twitter.instance;

import com.skm.twitter.constants.Constants;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterInstance {

	private static volatile Twitter twitter = null;
	
	public static Twitter getInstance() {
		if(twitter == null) {
			synchronized (TwitterInstance.class) {
				if(twitter == null) {
					ConfigurationBuilder builder = new ConfigurationBuilder();
					builder.setOAuthAccessToken(Constants.ACCESS_TOKEN);
					builder.setOAuthAccessTokenSecret(Constants.ACCESS_TOKEN_SECRET);
					builder.setOAuthConsumerKey(Constants.CONSUMER_KEY);
					builder.setOAuthConsumerSecret(Constants.CONSUMER_KEY_SECRET);
					OAuthAuthorization auth = new OAuthAuthorization(builder.build());
					twitter = new TwitterFactory().getInstance(auth);
				}
			}
		}
		return twitter;
	}
}

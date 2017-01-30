package com.skm.twitter.query;

import java.util.Iterator;
import java.util.List;

import org.apache.solr.common.SolrInputDocument;

import com.skm.twitter.constants.Constants;
import com.skm.twitter.constants.Constants.TextLocation;
import com.skm.twitter.instance.TwitterInstance;
import com.skm.twitter.store.SolrDocumentBuilder;

import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class Query {

	public void getSearchResults(String text) {
		Twitter twitter = TwitterInstance.getInstance();
		twitter4j.Query query = null;
		QueryResult queryResult = null;
		try {
			Iterator<TextLocation> it = Constants.patterns.keySet().iterator();
			while(it.hasNext()) {
				TextLocation key = it.next();
				String queryformat = Constants.patterns.get(key);
				queryformat = queryformat.replace(Constants.replaceWithActualText, text);
				query = new twitter4j.Query(queryformat);
				queryResult = twitter.search(query);
				List<Status> tweets = queryResult.getTweets();
		        for (Status tweet : tweets) {
		        	//add this document to Solr
//		            SolrDocumentBuilder.build(text, key.toString(), tweet.getText());
		        	System.out.println(tweet.getUser());
		        }
			}
		} catch(TwitterException te) {
			//Error handling
		}
	}
}

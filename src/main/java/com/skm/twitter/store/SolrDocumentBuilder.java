package com.skm.twitter.store;

import org.apache.solr.common.SolrInputDocument;

/**
 * The tweets can be searched and stored as Solr document.
 * This is just the skeleton of how we can add the document after querying for the text.
 * The persistence of the document to SolrServer is not shown here
 */
public class SolrDocumentBuilder {

	//text is the actual text while type is where text is found ,i.e. with hashtag or inside tweet or username
	public static SolrInputDocument build(String text,String type,String tweet) {
		SolrInputDocument document = new SolrInputDocument();
		document.addField("content", text);
		document.addField("type", type);
		document.addField("tweet", tweet);
		document.addField("id", type + "-" + text);
		return document;
	}
}

package com.skm.twitter.search;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;

public class TweetSearch {

	public QueryResponse searchSolr(String solrServerUrl, String query) {
		//initialise solr server with proper url
		QueryResponse response = null;
		/*SolrServer server = new HttpSolrServer(solrServerUrl);
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		query.addFilterQuery(query);
		
		response = server.query(query);*/
		return response;
	}
}

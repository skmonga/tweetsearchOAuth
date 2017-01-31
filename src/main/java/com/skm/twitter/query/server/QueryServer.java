package com.skm.twitter.query.server;

import java.util.Timer;
import java.util.TimerTask;

import com.skm.twitter.query.Query;

public class QueryServer {

	private static Query query = new Query();
	
	//1 hour interval
	private static long intevalPeriod = 60 * 60 * 1000;
	
	public static void main(String[] args) {
	    String textToSearch = "";
		if(args.length > 0) {
		 textToSearch = args[0];
		}
		final String searchString = textToSearch;
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				//run the query and persist the results in Solr for later querying
				query.getSearchResults(searchString);
			}
		};
		
		Timer timer = new Timer();
	    // schedules the task to be run in an interval 
	    timer.scheduleAtFixedRate(task, 0, intevalPeriod);
	}
}

package com.digital.factory.config;


public class Constants {
	
	public static final String REGEX ="/api";
    public static final String PARTICIPANTS_URL = REGEX+"/participants";
    public static final String MATCHES_URL = REGEX+"/matches";
    public static final String LEAGUES_URL =REGEX+ "/leagues";
 
    public static final String MATCHES_List_URL = MATCHES_URL+"/list/{round}";
    public static final String CLOSE_ROUND_URL = MATCHES_URL+"/closeRound/{round}";
    
    public static final String SUBMIT_PARTICIPANT_URL=PARTICIPANTS_URL+"/submit";    
    public static final String numOfGroups_URL = "/{numOfGroups}";
  
    public static final String SubmitLeagueOfChampion_URL = LEAGUES_URL+"/SubmitChampion";
    public static final String SubmitRequestMatch_URL = LEAGUES_URL+"/matche";

    public static final String SUCCESS_CODE ="200";
    public static final String SUCCESS_MESSAGE ="Success";
    public static final int LimitedMathces=3;
    public static final int LimitedParticipants=12;
}

package main.java.org.sharktooth.gms.helper;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Page;
import facebook4j.auth.AccessToken;

public class SocialHelper {
	public static int getFacebookLikes(String username) {
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId("", "");
		AccessToken accessToken = new AccessToken(
				"EAACEdEose0cBAIyoIeysBz6qGCmkOLSftFTdDDxzEk9ZAZBZBYHg13xI7KmzWEnajnZBcMEYuxFaC7wPtJpe3pzqZBCamUimuNgeHxtX58ilFbT9bNup4IOl3dW0qb3gmMeuPeVK0UsCeg5MWE7WAOWVcrL4Pj1ydH3dneOEHqvOCExqorTk20qel9ugIiigZD");
		facebook.setOAuthAccessToken(accessToken);
		Page page = null;
		try {
			page = facebook.getPage(username);
		} catch (FacebookException e) {
			e.printStackTrace();
		}
		return page.getLikes();
	}

	public static int getTwitterFollowers(String username) {

		return 1;
	}
}

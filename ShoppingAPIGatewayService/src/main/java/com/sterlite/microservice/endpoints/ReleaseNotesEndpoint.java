package com.sterlite.microservice.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="release-notes")
public class ReleaseNotesEndpoint {

	String version1 = 
			 "Version: 1.0 Details\n"
			+ "Author: dharmaraj.pawale@sterlite.com \n"
			+ "Copyright : Sterlite Tech Ltd\n"
			+ "Application Created\n\n";
	
	String version2 = 
			"Version: 2.0 Details\n"
			+ "Author: dharmaraj.pawale@sterlite.com \n"
			+ "Copyright : Sterlite Tech Ltd\n"
			+ "Endpoint Added\n\n";
	
	@ReadOperation
	public String releaseNotes() {
		return version1 + version2;
	}
	
	@ReadOperation
	public String selectReleaseNotes(@Selector String selector ) {
		if ("1".equals(selector)) return version1;
		else if ("2".equals(selector)) return version2; 
		else return releaseNotes();
	}
}

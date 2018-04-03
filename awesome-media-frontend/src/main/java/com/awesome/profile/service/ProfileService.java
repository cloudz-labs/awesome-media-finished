package com.awesome.profile.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.awesome.profile.vo.Profile;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service("profileService")
public class ProfileService {
	
	@Value("${api.services.url}")
	private String serviceUrl;
	
	private RestTemplate restTemplate;
	
	@Autowired
	public ProfileService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@HystrixCommand
	public List<Profile> getProfiles(String username) {
		return Arrays.asList(restTemplate.getForObject(String.format("%s/v1/%s/profiles", serviceUrl, username), Profile[].class));
    }
}

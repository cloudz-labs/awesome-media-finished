package com.skcc.contents.episode.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.skcc.contents.episode.vo.Season;
import com.skcc.contents.vo.Content;

@Service("episodeService")
public class EpisodeService {
	
	@Value("${api.services.url}")
	private String serviceUrl;
	
	private RestTemplate restTemplate;
	
	@Autowired
	public EpisodeService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@HystrixCommand(fallbackMethod = "getContentsByTitleFallBack")
	public List<Content> getContentsByTitle(String title) {
		return Arrays.asList(restTemplate.getForObject(
				String.format("%s/v1/contents/search?title=%s", serviceUrl, title),
				Content[].class));
	}

	public List<Content> getContentsByTitleFallBack(String title) {
		return new ArrayList<Content>();
	}

	@HystrixCommand(fallbackMethod = "getContentsDetailFallback",
			threadPoolKey = "GetContentsDetailThread",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
					@HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests",
							value = "100")})
	public Content getContentsDetail(String id) {
		return restTemplate.getForObject(String.format("%s/v1/contents/%s", serviceUrl, id),
				Content.class);
	}
	
	public Content getContentsDetailFallback(String id) {
		return new Content();
	}

	@HystrixCommand(fallbackMethod = "getEpisodesFallback")
	public List<Season> getAllEpisodes(String content) {
		return Arrays.asList(restTemplate.getForObject(
				String.format("%s/v1/contents/%s/episodes", serviceUrl, content), Season[].class));
	}

	public List<Season> getEpisodesFallback(String content) {
		return new ArrayList<Season>();
	}

}

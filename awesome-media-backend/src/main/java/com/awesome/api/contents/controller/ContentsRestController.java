package com.awesome.api.contents.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.awesome.api.contents.episode.controller.EpisodeRestController;
import com.awesome.api.contents.service.ContentsService;
import com.awesome.api.contents.vo.Content;

@RestController
@RequestMapping("/v1")
public class ContentsRestController {
	
	private static Logger logger = LoggerFactory.getLogger(EpisodeRestController.class);
	
	private ContentsService contentsService;
	
	@Autowired
	public ContentsRestController(ContentsService contentsService) {
		this.contentsService = contentsService;
	}
	
	@RequestMapping(path="/contents", method=RequestMethod.GET, name="getContents")
	public List<Content> getContents(@RequestParam(value = "category") String category) {
		logger.debug("getContents() called!!");
		return contentsService.getContents(category);
	}
	
	@RequestMapping(path="/contents", method=RequestMethod.POST, name="addContents")
	public int addContents(@RequestBody Content content) {
		return contentsService.addContent(content);
	}

}

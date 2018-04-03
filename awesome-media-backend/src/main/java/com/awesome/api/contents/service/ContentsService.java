package com.awesome.api.contents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awesome.api.contents.dao.ContentsMapper;
import com.awesome.api.contents.vo.Content;

@Service("contentsService")
public class ContentsService {
	
	private ContentsMapper contentsMapper;
	
	@Autowired
	public ContentsService(ContentsMapper contentsMapper) {
		this.contentsMapper = contentsMapper;
	}
	
	public List<Content> getContents(String category) {
		return contentsMapper.findByCategory(category);
	}
	
	public int addContent(Content content) {
		return contentsMapper.insertContent(content);
	}

}

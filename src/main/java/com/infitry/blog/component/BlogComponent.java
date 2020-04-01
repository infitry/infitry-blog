package com.infitry.blog.component;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.infitry.blog.entity.BlogPost;
import com.infitry.blog.repository.BlogPostRepository;

@Component
public class BlogComponent {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogComponent.class);
	
	@Autowired
	BlogPostRepository blogPostRepository;
	
	public BlogPost getBlog(long blogPostSeq) {
		return blogPostRepository.getOne(blogPostSeq);
	}
	
	public List<BlogPost> getBlogListAll() {
		return blogPostRepository.findAll();
	}
	
	public Page<BlogPost> getBlogList(Pageable paging) {
		int page = (paging.getPageNumber() == 0) ? 0 : (paging.getPageNumber() - 1); //page는 index 처럼 0부터 시작
		paging = PageRequest.of(page, 10);
		
		return blogPostRepository.findAll(paging);
	}
	
	public void createBlogPost(BlogPost blogPost) {
		try {
			blogPostRepository.save(blogPost);
		} catch (Exception e) {
			logger.error("blogPost save Error : " + e.getMessage());
			throw e;
		}
	}
}

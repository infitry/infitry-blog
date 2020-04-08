package com.infitry.blog.component;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.infitry.blog.entity.BlogPost;
import com.infitry.blog.entity.PostCategory;
import com.infitry.blog.param.BlogPostParam;
import com.infitry.blog.repository.BlogPostRepository;
import com.infitry.blog.repository.PostCategoryRepository;

@Component
public class BlogComponent {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogComponent.class);
	
	@Autowired
	BlogPostRepository blogPostRepository;
	
	@Autowired
	PostCategoryRepository postCategoryRepository;
	
	public BlogPost getBlog(long blogPostSeq) {
		return blogPostRepository.getOne(blogPostSeq);
	}
	
	public List<PostCategory> getCategoryListAll() {
		//sort 처리 방법
		String[] orderBy = {"regDate"};
		return postCategoryRepository.findAll(Sort.by(Sort.Direction.DESC, orderBy));
	}
	
	public List<BlogPost> getBlogListAll() {
		//sort 처리 방법
		String[] orderBy = {"regDate"};
		return blogPostRepository.findAll(Sort.by(Sort.Direction.DESC, orderBy));
	}
	
	public Page<BlogPost> getBlogList(BlogPostParam param) {
		//paging sort 동시 처리 방법
		String[] orderBy = {"regDate"};
		Pageable paging = PageRequest.of(param.getPageNumber(), param.getPageSize(), Sort.by(Sort.Direction.DESC, orderBy));
		Page<BlogPost> result = null;
		//카테고리별로 보기 시 해당카테고리만 조회
		if (param.getBlogPostCategorySeq() > 0) {
			result = blogPostRepository.findByPostCategoryBlogPostCategorySeq(param.getBlogPostCategorySeq(), paging);
		} else {
			result = blogPostRepository.findAll(paging);
		}
		return result;
	}
	
	public void saveBlogPost(BlogPost blogPost) {
		try {
			blogPostRepository.save(blogPost);
		} catch (Exception e) {
			logger.error("blogPost save Error : " + e.getMessage());
			throw e;
		}
	}
	
	public void saveBlogCategory(PostCategory category) {
		category.setRegDate(new Date());
		try {
			postCategoryRepository.save(category);
		} catch (Exception e) {
			logger.error("blogCategory save Error : " + e.getMessage());
			throw e;
		}
	}
}

package com.infitry.blog.component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
import com.infitry.blog.param.PostCategoryParam;
import com.infitry.blog.repository.BlogPostRepository;
import com.infitry.blog.repository.PostCategoryRepository;

@Component
public class BlogComponent {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogComponent.class);
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	BlogPostRepository blogPostRepository;
	
	@Autowired
	PostCategoryRepository postCategoryRepository;
	
	public BlogPost getBlog(long blogPostSeq) {
		return blogPostRepository.getOne(blogPostSeq);
	}
	
	public List<PostCategoryParam> getCategoryListAll() {
		//sort 처리 방법
		String[] orderBy = {"regDate"};
		List<PostCategory> entityResult = postCategoryRepository.findAll(Sort.by(Sort.Direction.DESC, orderBy));
		List<PostCategoryParam> dtoResult = entityResult
				.stream()
				.map(entity -> modelMapper.map(entity, PostCategoryParam.class))
				.collect(Collectors.toList());
		return dtoResult;
	}
	
	public List<BlogPostParam> getBlogListAll() {
		//sort 처리 방법
		String[] orderBy = {"regDate"};
		List<BlogPost> entityResult = blogPostRepository.findAll(Sort.by(Sort.Direction.DESC, orderBy));
		List<BlogPostParam> dtoResult = entityResult
			.stream()
			.map(entity -> modelMapper.map(entity, BlogPostParam.class))
			.collect(Collectors.toList());
		
		return dtoResult;
	}
	
	public Page<BlogPostParam> getBlogList(PostCategoryParam param) {
		//paging sort 동시 처리 방법
		String[] orderBy = {"regDate"};
		Pageable paging = PageRequest.of(param.getPageNumber(), param.getPageSize(), Sort.by(Sort.Direction.DESC, orderBy));
		Page<BlogPost> entityResult = null;
		//카테고리별로 보기 시 해당카테고리만 조회
		if (param.getBlogPostCategorySeq() > 0) {
			entityResult = blogPostRepository.findByPostCategoryBlogPostCategorySeq(param.getBlogPostCategorySeq(), paging);
		} else {
			entityResult = blogPostRepository.findAll(paging);
		}
		
		//entity -> dto 변환
		Page<BlogPostParam> dtoResult = entityResult.map(entity -> modelMapper.map(entity, BlogPostParam.class));
		
		return dtoResult;
	}
	
	public void saveBlogPost(BlogPostParam blogPost) {
		try {
			BlogPost blogPostEntity = modelMapper.map(blogPost, BlogPost.class);	//DTO -> Entity변환
			blogPostRepository.save(blogPostEntity);
		} catch (Exception e) {
			logger.error("blogPost save Error : " + e.getMessage());
			throw e;
		}
	}
	
	public void saveBlogCategory(PostCategoryParam category) {
		category.setRegDate(new Date());
		try {
			PostCategory categoryEntity = modelMapper.map(category, PostCategory.class);	//DTO -> Entity 변환
			postCategoryRepository.save(categoryEntity);
		} catch (Exception e) {
			logger.error("blogCategory save Error : " + e.getMessage());
			throw e;
		}
	}
}

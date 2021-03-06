package com.infitry.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infitry.blog.component.BlogComponent;
import com.infitry.blog.entity.BlogPost;
import com.infitry.blog.param.BlogPostParam;
import com.infitry.blog.param.PostCategoryParam;
import com.infitry.blog.result.TransResult;

/**
 * @since 2020. 4. 1.
 * @author leesw
 * @mail leesw504@gmail.com
 * @description : 블로그 포스트 컨트롤러
 */
@RestController
@CrossOrigin
@RequestMapping("/blog/post")
public class BlogPostController {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogPostController.class);
	
	@Autowired
	BlogComponent blogComponent;
	
	/**
	 * @since 2020. 4. 1.
	 * @author leesw
	 * @description : 블로그 포스트 전체 목록 (관리자 용)
	 */
	@RequestMapping(value="/list-all" , method = RequestMethod.GET)
	List<BlogPostParam> blogPostAllList() {
		List<BlogPostParam> result = new ArrayList<BlogPostParam>();
		result = blogComponent.getBlogListAll();
		return result;
	}
	
	/**
	 * @since 2020. 4. 1.
	 * @author leesw
	 * @description : 블로그 포스트 목록
	 */
	@RequestMapping(value="/list" , method = RequestMethod.POST)
	Page<BlogPostParam> blogPostList(@RequestBody PostCategoryParam param) {
		logger.info("page size : " + param.getPageSize());
		logger.info("page number : " + param.getPageNumber());
		
		Page<BlogPostParam> postList = blogComponent.getBlogList(param);
		logger.info("list Size : " + postList.getTotalElements());
		return postList;
	}
	
	/**
	 * @since 2020. 4. 1.
	 * @author leesw
	 * @description : 블로그포스트 저장, 업데이트
	 */
	@RequestMapping(value="/save" , method = RequestMethod.POST)
	TransResult blogPostCreate(@RequestBody BlogPostParam blogPost) {
		TransResult result = new TransResult(true);
		try {
			blogComponent.saveBlogPost(blogPost);
		} catch (Exception e) {
			result.setErrorMessage(e.getMessage());
			result.setSuccess(false);
		}
		return result;
	}
	
	/**
	 * @since 2020. 4. 1.
	 * @author leesw
	 * @throws Exception 
	 * @description : 블로그포스트 상세
	 */
	@RequestMapping(value="/detail" , method = RequestMethod.GET)
	BlogPost blogPostCreate(long blogPostSeq) throws Exception {
		BlogPost blogPost = new BlogPost();
		try {
			logger.info("blogPostSeq : " + blogPostSeq);
			blogPost = blogComponent.getBlog(blogPostSeq);
		} catch (Exception e) {
			logger.error("/blog/post/detail error : " + e.getMessage());
			throw new Exception();
		}
		return blogPost;
	}
}

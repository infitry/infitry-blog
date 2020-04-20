package com.infitry.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infitry.blog.component.BlogComponent;
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
@RequestMapping("/blog/category")
public class BlogCategoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogCategoryController.class);
	
	@Autowired
	BlogComponent blogComponent;
	
	/**
	 * @since 2020. 4. 1.
	 * @author leesw
	 * @description : 블로그 카테고리 전체목록
	 */
	@RequestMapping(value="/list-all" , method = RequestMethod.GET)
	List<PostCategoryParam> blogPostAllList() {
		List<PostCategoryParam> result = new ArrayList<PostCategoryParam>();
		result = blogComponent.getCategoryListAll();
		logger.info("list-all Size : " + result.size());
		return result;
	}
	
	/**
	 * @since 2020. 4. 1.
	 * @author leesw
	 * @description : 블로그카테고리 생성, 수정
	 */
	@RequestMapping(value="/save" , method = RequestMethod.POST)
	TransResult blogPostCreate(@RequestBody PostCategoryParam category) {
		TransResult result = new TransResult(true);
		try {
			blogComponent.saveBlogCategory(category);
		} catch (Exception e) {
			result.setErrorMessage(e.getMessage());
			result.setSuccess(false);
		}
		return result;
	}
}

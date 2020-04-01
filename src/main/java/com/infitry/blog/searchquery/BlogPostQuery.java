package com.infitry.blog.searchquery;

import java.util.Date;

import org.springframework.data.domain.Pageable;

import lombok.Data;

/**
 * @since 2020. 4. 1.
 * @author leesw
 * @mail leesw504@gmail.com
 * @description : blogPost Search Class
 */
@Data
public class BlogPostQuery {
	Pageable paging;
	
	long blogPostSeq;
	String subject;
	String contents;
	String regUser;
	Date regDate;
}

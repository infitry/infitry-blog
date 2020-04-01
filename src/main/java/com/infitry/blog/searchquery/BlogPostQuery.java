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
	private Pageable paging;
	
	private long blogPostSeq;
	private String subject;
	private String contents;
	private String regUser;
	private Date regDate;
}

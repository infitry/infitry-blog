package com.infitry.blog.param;

import java.util.Date;

import lombok.Data;

@Data
public class BlogPostParam {
	private int pageSize;
	private int pageNumber;
	private long blogPostSeq;
	private long blogPostCategorySeq;
	private String subject;
	private String contents;
	private String regUser;
	private Date regDate;
}

package com.infitry.blog.param;

import java.util.Date;

import lombok.Data;

@Data
public class PostCategoryParam {
	private int pageSize;
	private int pageNumber;
	private long blogPostCategorySeq;
	private int count;
	private String name;
	private String regUser;
	private Date regDate;
}

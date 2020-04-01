package com.infitry.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @since 2020. 4. 1.
 * @author leesw
 * @mail leesw504@gmail.com
 * @description : blogPostCategory Entity
 */
@Entity
@Table(name="INF_BLOG_POST_CATEGORY")
@Data
public class PostCategory {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "BLOG_POST_CATEGORY_SEQ", nullable = false)
	private long blogPostCategorySeq;
	
	@Column(name = "NAME", nullable = false, length = 50)
	private String name;
	
	@Column(name = "REG_USER", nullable = false, length = 20)
	private String regUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REG_DATE", nullable = false)
	private Date regDate;
}

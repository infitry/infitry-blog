package com.infitry.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @since 2020. 4. 1.
 * @author leesw
 * @mail leesw504@gmail.com
 * @description : blogPost Entity
 */
@Entity
@Table(name="INF_BLOG_POST")
@Data
public class BlogPost {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "BLOG_POST_SEQ", nullable = false)
	private long blogPostSeq;
	 
	@ManyToOne
	@JoinColumn(name = "BLOG_POST_CATEGORY_SEQ")
	private PostCategory postCategory;
	
	@Column(name = "SUBJECT", nullable = false, length = 50)
	private String subject;
	
	@Column(name = "DESCRIPTION", nullable = false, length = 150)
	private String description;
	
	@Lob
	@Column(name = "CONTENTS", nullable = false, length = 512)
	private String contents;
	
	@Column(name = "REG_USER", nullable = false, length = 20)
	private String regUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REG_DATE", nullable = false)
	private Date regDate;
}

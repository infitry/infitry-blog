package com.infitry.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
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
	long blogPostSeq;
//	 
//	@OneToOne
//	@Column(name = "CATEGORY_SEQ", nullable = false)
//	String categorySeq;
//	
	@Column(name = "SUBJECT", nullable = false, length = 50)
	String subject;
	
	@Lob
	@Column(name = "CONTENTS", nullable = false, length = 512)
	String contents;
	
	@Column(name = "REG_USER", nullable = false, length = 20)
	String regUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REG_DATE", nullable = false)
	Date regDate;
}

package com.infitry.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

/**
 * @since 2020. 4. 1.
 * @author leesw
 * @mail leesw504@gmail.com
 * @description : blogPostCategory Entity
 */
@Entity
@Table(name="INF_BLOG_POST_CATEGORY")
@Getter
@Setter
public class PostCategory {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "BLOG_POST_CATEGORY_SEQ", nullable = false)
	private long blogPostCategorySeq;
	
	@OneToMany(mappedBy = "postCategory", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<BlogPost> blogPosts = new ArrayList<BlogPost>();
	
	@Formula("(SELECT count(*) FROM INF_BLOG_POST A WHERE A.BLOG_POST_CATEGORY_SEQ = BLOG_POST_CATEGORY_SEQ)")
	private int count;
	
	@Column(name = "NAME", nullable = false, length = 50)
	private String name;
	
	@Column(name = "REG_USER", nullable = false, length = 20)
	private String regUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REG_DATE", nullable = false)
	private Date regDate;
}

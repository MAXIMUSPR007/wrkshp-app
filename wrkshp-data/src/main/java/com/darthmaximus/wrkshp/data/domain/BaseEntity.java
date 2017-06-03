package com.darthmaximus.wrkshp.data.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Audited
@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	
	@CreatedBy
    @Column(name = "createdBy")
	private String createdBy;
	
    @CreatedDate
    @Column(name = "created")
	private LocalDateTime created;
	
	@LastModifiedBy
    @Column(name = "updatedBy")
	private String updatedBy;
	
    @LastModifiedDate
    @Column(name = "updated")
	private LocalDateTime updated;
	
	public BaseEntity() {
		this.created = LocalDateTime.now();
		this.updated = LocalDateTime.now();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public LocalDateTime getUpdated() {
		return updated;
	}
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
}

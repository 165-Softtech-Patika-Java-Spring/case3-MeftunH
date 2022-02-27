package com.CommentControlSystem.CommentControlSystem.General.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.Embedded;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements BaseModel, Cloneable, Serializable{
    private static final long serialVersionUID = 1L;

    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
}

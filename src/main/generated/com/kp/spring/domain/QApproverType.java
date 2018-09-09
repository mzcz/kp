package com.kp.spring.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QApproverType is a Querydsl query type for ApproverType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QApproverType extends EntityPathBase<ApproverType> {

    private static final long serialVersionUID = -1118616124L;

    public static final QApproverType approverType = new QApproverType("approverType");

    public final DatePath<java.time.LocalDate> createdDate = createDate("createdDate", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QApproverType(String variable) {
        super(ApproverType.class, forVariable(variable));
    }

    public QApproverType(Path<? extends ApproverType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QApproverType(PathMetadata<?> metadata) {
        super(ApproverType.class, metadata);
    }

}


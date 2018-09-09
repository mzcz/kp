package com.kp.spring.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QApprover is a Querydsl query type for Approver
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QApprover extends EntityPathBase<Approver> {

    private static final long serialVersionUID = 1429276522L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QApprover approver = new QApprover("approver");

    public final QApproverType approverType;

    public final DatePath<java.time.LocalDate> createdDate = createDate("createdDate", java.time.LocalDate.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QKpUser kpUser;

    public QApprover(String variable) {
        this(Approver.class, forVariable(variable), INITS);
    }

    public QApprover(Path<? extends Approver> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QApprover(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QApprover(PathMetadata<?> metadata, PathInits inits) {
        this(Approver.class, metadata, inits);
    }

    public QApprover(Class<? extends Approver> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.approverType = inits.isInitialized("approverType") ? new QApproverType(forProperty("approverType")) : null;
        this.kpUser = inits.isInitialized("kpUser") ? new QKpUser(forProperty("kpUser")) : null;
    }

}


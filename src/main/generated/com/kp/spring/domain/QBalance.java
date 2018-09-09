package com.kp.spring.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QBalance is a Querydsl query type for Balance
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBalance extends EntityPathBase<Balance> {

    private static final long serialVersionUID = 2023990679L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBalance balance = new QBalance("balance");

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    public final StringPath approvers = createString("approvers");

    public final QCategory category;

    public final StringPath content = createString("content");

    public final StringPath createBy = createString("createBy");

    public final DatePath<java.time.LocalDate> createDate = createDate("createDate", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QBalance(String variable) {
        this(Balance.class, forVariable(variable), INITS);
    }

    public QBalance(Path<? extends Balance> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBalance(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBalance(PathMetadata<?> metadata, PathInits inits) {
        this(Balance.class, metadata, inits);
    }

    public QBalance(Class<? extends Balance> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category")) : null;
    }

}


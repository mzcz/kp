package com.kp.spring.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBalanceDtos is a Querydsl query type for BalanceDtos
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBalanceDtos extends EntityPathBase<BalanceDtos> {

    private static final long serialVersionUID = -1933988693L;

    public static final QBalanceDtos balanceDtos = new QBalanceDtos("balanceDtos");

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    public final StringPath approvers = createString("approvers");

    public final NumberPath<Long> category_id = createNumber("category_id", Long.class);

    public final StringPath content = createString("content");

    public final StringPath createBy = createString("createBy");

    public final DatePath<java.time.LocalDate> createDate = createDate("createDate", java.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath type = createString("type");

    public final StringPath type_name = createString("type_name");

    public QBalanceDtos(String variable) {
        super(BalanceDtos.class, forVariable(variable));
    }

    public QBalanceDtos(Path<? extends BalanceDtos> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBalanceDtos(PathMetadata<?> metadata) {
        super(BalanceDtos.class, metadata);
    }

}


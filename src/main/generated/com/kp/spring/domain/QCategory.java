package com.kp.spring.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = 294542755L;

    public static final QCategory category = new QCategory("category");

    public final SetPath<Balance, QBalance> balance = this.<Balance, QBalance>createSet("balance", Balance.class, QBalance.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath type = createString("type");

    public QCategory(String variable) {
        super(Category.class, forVariable(variable));
    }

    public QCategory(Path<? extends Category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategory(PathMetadata<?> metadata) {
        super(Category.class, metadata);
    }

}


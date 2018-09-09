package com.kp.spring.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QKpUser is a Querydsl query type for KpUser
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QKpUser extends EntityPathBase<KpUser> {

    private static final long serialVersionUID = -356599627L;

    public static final QKpUser kpUser = new QKpUser("kpUser");

    public final ListPath<Approver, QApprover> approvers = this.<Approver, QApprover>createList("approvers", Approver.class, QApprover.class, PathInits.DIRECT2);

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    public final StringPath loginId = createString("loginId");

    public QKpUser(String variable) {
        super(KpUser.class, forVariable(variable));
    }

    public QKpUser(Path<? extends KpUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKpUser(PathMetadata<?> metadata) {
        super(KpUser.class, metadata);
    }

}


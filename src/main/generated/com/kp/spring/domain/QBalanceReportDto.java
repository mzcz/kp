package com.kp.spring.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBalanceReportDto is a Querydsl query type for BalanceReportDto
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBalanceReportDto extends EntityPathBase<BalanceReportDto> {

    private static final long serialVersionUID = 1582960692L;

    public static final QBalanceReportDto balanceReportDto = new QBalanceReportDto("balanceReportDto");

    public final NumberPath<java.math.BigDecimal> apr = createNumber("apr", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> aug = createNumber("aug", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> feb = createNumber("feb", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> jan = createNumber("jan", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> jul = createNumber("jul", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> jun = createNumber("jun", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> mar = createNumber("mar", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> may = createNumber("may", java.math.BigDecimal.class);

    public final StringPath name = createString("name");

    public final NumberPath<java.math.BigDecimal> razem = createNumber("razem", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> sep = createNumber("sep", java.math.BigDecimal.class);

    public QBalanceReportDto(String variable) {
        super(BalanceReportDto.class, forVariable(variable));
    }

    public QBalanceReportDto(Path<? extends BalanceReportDto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBalanceReportDto(PathMetadata<?> metadata) {
        super(BalanceReportDto.class, metadata);
    }

}


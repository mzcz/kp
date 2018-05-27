package com.kp.spring.Mapper;

import com.kp.spring.domain.Balance;
import com.kp.spring.domain.BalanceDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BalanceMapper {

    public Balance mapToBalance(final BalanceDto balanceDto){
        return new Balance(
                balanceDto.getId(),
                balanceDto.getName(),
                balanceDto.getAmount(),
                balanceDto.getApprovers(),
                balanceDto.getCategory(),
                balanceDto.getContent(),
                balanceDto.getCreateDate(),
                balanceDto.getCreateBy()
                );
    }

    public BalanceDto mapToBalanceDto (final Balance balance){
        return new BalanceDto(
                balance.getId(),
                balance.getName(),
                balance.getAmount(),
                balance.getApprovers(),
                balance.getCategory(),
                balance.getContent(),
                balance.getCreateDate(),
                balance.getCreateBy());
    }

    public List<BalanceDto> mapToBalanceDtoList (final List<Balance> balanceList){
        return balanceList.stream()
                .map(t -> new BalanceDto(t.getId(), t.getName(), t.getAmount(), t.getApprovers(),
                        null, t.getContent(), t.getCreateDate(), t.getCreateBy()))
                .collect(Collectors.toList());
    }
}

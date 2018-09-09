package com.kp.spring.Mapper;

import com.kp.spring.domain.KpUser;
import com.kp.spring.domain.KpUserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public KpUser mapToUser(final KpUserDto kpUserDto){
        return new KpUser(kpUserDto.getId(),
                          kpUserDto.getLoginId(),
                          kpUserDto.getFirstName(),
                          kpUserDto.getLastName(),
                          null);
    }

    public KpUserDto mapToUserDto (final KpUser kpUser) {
        return new KpUserDto(kpUser.getId(),
                kpUser.getLoginId(),
                kpUser.getFirstName(),
                kpUser.getLastName());
    }

    public List<KpUserDto> mapToUserDtoList(final List<KpUser> kpUserList ){
        return kpUserList.stream()
                .map(t -> new KpUserDto(t.getId(),
                        t.getLoginId(),
                        t.getFirstName(),
                        t.getLastName())).collect(Collectors.toList());
    }

}

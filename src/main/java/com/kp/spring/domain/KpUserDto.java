package com.kp.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class KpUserDto {
    private long id;
    private String loginId;
    private String firstName;
    private String lastName;
}

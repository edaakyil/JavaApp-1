package com.edaakyil.generator.password.entity;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Accessors(prefix = "m_")
    private String m_username;

    @Accessors(prefix = "m_")
    private String m_password;

    @Accessors(prefix = "m_")
    private int m_count;   // The number of passwords created by user

    @Accessors(prefix = "m_")
    private int m_len;
}

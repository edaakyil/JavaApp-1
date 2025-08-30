package com.edaakyil.data.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode
public class UserInfo {
    @Accessors(prefix = "m_")
    private String m_username;

    @Accessors(prefix = "m_")
    private String m_password;

    @Accessors(prefix = "m_")
    private String m_path;
}

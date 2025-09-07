package com.edaakyil;

import com.edaakyil.generator.password.entity.UserInfo;
import com.edaakyil.generator.password.repository.IUserInfoRepository;
import com.edaakyil.generator.password.repository.UserInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserInfoRepositorySaveTest {
    private IUserInfoRepository m_userInfoRepository;
    private File m_file;

    @BeforeEach
    public void setUp()
    {
        m_file = new File("eda");
        m_file.delete();

        m_userInfoRepository = new UserInfoRepository(m_file, new Random());
    }

    @Test
    public void saveTest()
    {
        var userInfo = new UserInfo("eda", "1234", 10, 4);

        m_userInfoRepository.save(userInfo);

        assertTrue(m_file.exists()); // idda ediyorum ki bu test bittikten sonra bu dosya var.
        assertTrue(m_file.length() > 0);
    }
}

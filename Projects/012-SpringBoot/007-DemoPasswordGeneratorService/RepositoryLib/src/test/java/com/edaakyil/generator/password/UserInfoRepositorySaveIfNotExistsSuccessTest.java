package com.edaakyil.generator.password;

import com.edaakyil.generator.password.entity.UserInfo;
import com.edaakyil.generator.password.repository.IUserInfoRepository;
import com.edaakyil.generator.password.repository.UserInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserInfoRepositorySaveIfNotExistsSuccessTest {
    private IUserInfoRepository m_userInfoRepository;

    @BeforeEach
    public void setUp() throws IOException
    {
        var path = Files.createDirectories(Path.of("passwords"));
        Files.delete(path.resolve("eda"));
        m_userInfoRepository = new UserInfoRepository(new File("passwords"), new Random());
    }

    @Test
    public void test()
    {
        var userInfo = new UserInfo("eda", "1234", 10, 4);
        var result = m_userInfoRepository.saveIfNotExists(userInfo);

        assertTrue(result.isPresent());
    }
}

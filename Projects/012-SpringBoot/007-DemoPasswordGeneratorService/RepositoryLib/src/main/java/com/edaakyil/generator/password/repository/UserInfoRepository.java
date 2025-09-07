package com.edaakyil.generator.password.repository;

import com.edaakyil.generator.password.entity.UserInfo;
import com.edaakyil.java.lib.data.repository.exception.RepositoryException;
import org.csystem.util.string.StringUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

/* Ignore asynchronous access for demo. That repository will use DBMS (Database Management System) and DBMS synchronize the access. */

@Component
@Scope("prototype")
public class UserInfoRepository implements IUserInfoRepository {
    private final File m_directory;
    private final RandomGenerator m_randomGenerator;

    private void savePasswordsCallback(BufferedWriter bw, String password)
    {
        try {
            bw.write(String.format("%s\r\n", password));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void savePasswords(Path path, UserInfo userInfo) throws IOException
    {
        try (var bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
            Stream.generate(() -> StringUtil.generateRandomTextEN(m_randomGenerator, userInfo.getLen()))
                    .limit(userInfo.getCount())
                    .forEach(password -> savePasswordsCallback(bw, password));
        }
    }

    public UserInfoRepository(File directory, RandomGenerator randomGenerator)
    {
        m_directory = directory;
        m_randomGenerator = randomGenerator;
    }

    @Override
    public Optional<UserInfo> saveIfNotExists(UserInfo userInfo)
    {
        return existsById(userInfo.getUsername()) ? Optional.empty() : Optional.of(save(userInfo));
    }

    @Override
    public long count()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void delete(UserInfo entity)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteById(String s)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAll()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAll(Iterable<? extends UserInfo> entities)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public boolean existsById(String username)
    {
        //return m_directory.list((ignore, n) -> n.equals(username)) != null;
        return m_directory.toPath().resolve(username).toFile().exists();
    }

    @Override
    public Optional<UserInfo> findById(String s)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<UserInfo> findAll()
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public Iterable<UserInfo> findAllById(Iterable<String> strings)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }

    @Override
    public <S extends UserInfo> S save(S userInfo)
    {
        try {
            var path = m_directory.toPath().resolve(userInfo.getUsername());

            savePasswords(path, userInfo);

            // returns the saved entity
            return userInfo;
        } catch (IOException ex) {
            throw new RepositoryException("UserInfoRepository.save: IO problem occurred", ex);
        } catch (Throwable ex) {
            throw new RepositoryException("UserInfoRepository: Problem occurred", ex);
        }
    }

    @Override
    public <S extends UserInfo> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new  UnsupportedOperationException("Not yet implemented!...");
    }
}

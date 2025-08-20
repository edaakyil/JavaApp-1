package com.edaakyil.java.app.service.networkinfo.controller;

import com.edaakyil.java.app.service.networkinfo.dto.NetworkInfo;
import com.karandev.datetime.configuration.constant.BeanName;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/info/network")
@Scope("prototype")
@Slf4j
@ComponentScan("com.karandev")
public class NetworkInfoController {
    private final HttpServletRequest m_request;
    private final LocalDateTime m_localDateTime;

    public NetworkInfoController(@Qualifier(BeanName.LOCAL_CURRENT_DATETIME_BEAN) LocalDateTime localDateTime, HttpServletRequest request)
    {
        m_localDateTime = localDateTime;
        m_request = request;
    }
}

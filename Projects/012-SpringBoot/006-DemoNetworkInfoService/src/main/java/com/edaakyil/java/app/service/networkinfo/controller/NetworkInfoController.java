package com.edaakyil.java.app.service.networkinfo.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/info/network")
@Scope("prototype")
@Slf4j
public class NetworkInfoController {
    private final LocalDateTime m_localDateTime;
    private final HttpServletRequest m_request;

    public NetworkInfoController(LocalDateTime localDateTime, HttpServletRequest request)
    {
        m_localDateTime = localDateTime;
        m_request = request;
    }
}

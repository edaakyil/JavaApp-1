package com.edaakyil.java.app.service.networkinfo.controller;

import com.edaakyil.java.app.service.networkinfo.dto.NetworkInfoDTO;
import com.karandev.datetime.configuration.constant.BeanName;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    // Action Method - Business side
    //@RequestMapping(value = "/my", method = RequestMethod.GET)
    @GetMapping("/my")
    public NetworkInfoDTO networkInfo(@RequestParam(name = "name", required = false) String clientName, int age)
    {
        var info = NetworkInfoDTO.builder()
                .age(age)
                .name(clientName == null ? "anonymous" : clientName)
                .remoteHost(m_request.getRemoteHost())
                .localAddress(m_request.getLocalAddr())
                .remotePort(m_request.getRemotePort())
                .localPort(m_request.getLocalPort())
                .serviceRequestTime(m_localDateTime)
                .build();

        log.info("Network information request: {}", info);
        //log.info("Network information request: {}", info.toString());

        return info;
    }
}

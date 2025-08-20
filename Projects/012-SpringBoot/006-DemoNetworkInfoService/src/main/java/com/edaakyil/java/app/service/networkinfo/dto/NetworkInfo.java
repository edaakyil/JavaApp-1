package com.edaakyil.java.app.service.networkinfo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Builder
public class NetworkInfo {
    @Accessors(prefix = "m_") private int m_localPort;
    @Accessors(prefix = "m_") private int m_remotePort; // ephemeral port
    @Accessors(prefix = "m_") private String m_localHost;
    @Accessors(prefix = "m_") private String m_remoteHost;
    @Accessors(prefix = "m_") private LocalDateTime m_serviceRequestTime;
}

package com.nexusy.libra.mvc;

import org.apache.coyote.AbstractProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lanhuidong
 * @since 2019-07-24
 */
@Configuration
public class AppConfig {

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();

        factory.addConnectorCustomizers(connector -> {
                ((AbstractProtocol) connector.getProtocolHandler()).setKeepAliveTimeout(-1);
                ((AbstractProtocol) connector.getProtocolHandler()).setProperty("maxKeepAliveRequests", "-1");
            }
        );

        return factory;
    }
}

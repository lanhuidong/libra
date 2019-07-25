package com.nexusy.libra.mvc;

import org.apache.coyote.http11.AbstractHttp11Protocol;
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
                ((AbstractHttp11Protocol) connector.getProtocolHandler()).setKeepAliveTimeout(-1);
                ((AbstractHttp11Protocol) connector.getProtocolHandler()).setMaxKeepAliveRequests(-1);
            }
        );

        return factory;
    }
}

package org.pocketaces.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

/**
 * @author swatish.s
 */

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApplicationConfiguration {

    private final ConfigProvider configProvider;

    public UndertowServletWebServerFactory getUndertowServletWebServerFactory() {
        return new UndertowServletWebServerFactory(configProvider.getServerPort());
    }

}

package org.pocketaces.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;

/**
 * @author swatish.s
 */

@Getter
@Component
@PropertySource("classpath:application.properties")
public class ConfigProvider {

    @Value("${server.port}")
    private int serverPort;
}

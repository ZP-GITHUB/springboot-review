package com.zp;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ZP
 * @date 2020/8/25.
 */
// 前缀 pengshuai.hello
@ConfigurationProperties(prefix = "pengshuai.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
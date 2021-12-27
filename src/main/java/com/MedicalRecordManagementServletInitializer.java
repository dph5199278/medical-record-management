package com;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 打包成war包需要这个类，如果是打包jar包，可以忽略
 * @author Dely
 */
public class MedicalRecordManagementServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MedicalRecordManagementApplication.class);
    }
}

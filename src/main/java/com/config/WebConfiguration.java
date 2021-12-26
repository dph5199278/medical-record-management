package com.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Dely
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    /*@NonNull
    private final WebMvcProperties webMvcProperties;

    public WebConfiguration(@NonNull final WebMvcProperties webMvcProperties) {
        this.webMvcProperties = webMvcProperties;
    }*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 过滤静态资源文件
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }

    /*@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 添加jsp视图
        registry.jsp(webMvcProperties.getView().getPrefix(), webMvcProperties.getView().getSuffix());
    }*/
}

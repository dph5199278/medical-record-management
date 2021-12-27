package com.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author Dely
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @NonNull
    private final WebMvcProperties webMvcProperties;

    public WebConfiguration(@NonNull final WebMvcProperties webMvcProperties) {
        this.webMvcProperties = webMvcProperties;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 过滤静态资源文件
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath*:/static/");
    }

    /**
     * 方法中的jsp，
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 添加jsp视图
        // 不想用jsp后缀，可以用其他后缀，不过里面的坑到底有多少，需要自己解决

        // 当前开启后，spring.mvc.view的配置就会失效
        // Servlet是禁止直接网络访问路径中包含WEB-INF文件夹的
        // war:读/src/main/webapp/WEB-INF/下的路径,也能读取底下的路径
        // jar:读/src/main/resources/META-INF/resources/WEB-INF/下的路径
        //registry.jsp().viewClass(JstlView.class);

        // 以上或这个启用其一即可，这是直接使用失效的spring.mvc.view配置使其生效
        // 这两个都禁用后，spring.mvc.view配置自动生效
        registry.jsp(webMvcProperties.getView().getPrefix(), webMvcProperties.getView().getSuffix()).viewClass(JstlView.class);
    }
}

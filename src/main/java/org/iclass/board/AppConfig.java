package org.iclass.board;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // c:/upload 경로 url 로 매핑하기 위함
        // 개발자가 url 정함
        final String URL_PATH = "/upload/*";

        // 파일 시스템 위치
        final String LOCATION = "file:///C:/upload/";

        // 위의 2개 값을 매핑
        registry.addResourceHandler(URL_PATH).addResourceLocations(LOCATION);
    }

    // 설정이 완료되면 c:\\upload 폴더의 파일은 브라우저에서 url 접근 가능
}

package com.photogallery;

import com.photogallery.controller.PageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PageControllerTests {

    @Autowired
    private PageController pageController;

    @Test
    void contextLoads() throws Exception {
        assertThat(pageController).isNotNull();
    }
}

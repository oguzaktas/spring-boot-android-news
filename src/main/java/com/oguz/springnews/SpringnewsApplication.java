
package com.oguz.springnews;

import com.mert.javaform.NewsAdmin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Yazilim Laboratuvari II Proje 2
 * @author Oguz Aktas & Mert Var
 */
@SpringBootApplication
public class SpringnewsApplication {

    public static void main(String[] args) {
        new NewsAdmin().setVisible(true);
        SpringApplication.run(SpringnewsApplication.class, args);
    }

}

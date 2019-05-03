
package com.oguz.springnews.repository;

import com.oguz.springnews.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Yazilim Laboratuvari II Proje 2
 * @author Oguz Aktas & Mert Var
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oguz.springnews.repository;

import com.oguz.springnews.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oguz
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    
}

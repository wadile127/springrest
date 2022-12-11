package com.sprngtest.springrest.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprngtest.springrest.entities.CourseEntity;

@Repository
public interface CourseDao extends JpaRepository<CourseEntity, Long> {

}

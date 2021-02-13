package com.crio.xmeme.repository;

import com.crio.xmeme.model.Xmeme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

/**
 * This is Xmeme Repository Interface for Xmeme Application
 * Extended from PageAndSortingRepository , QueryBy EXampleExecuter,JPA Repository to Perform Database Operations
 */
@Repository
public interface XmemeRepository extends PagingAndSortingRepository<Xmeme, Integer>, QueryByExampleExecutor<Xmeme>, JpaRepository<Xmeme, Integer> {
}


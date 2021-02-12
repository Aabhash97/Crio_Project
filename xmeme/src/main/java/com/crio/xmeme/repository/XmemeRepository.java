package com.crio.xmeme.repository;

import com.crio.xmeme.model.Xmeme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface XmemeRepository extends JpaRepository<Xmeme, Integer> {
    }


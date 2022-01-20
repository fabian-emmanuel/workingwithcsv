package com.codewithfibbee.workingwithcsv.repository;

import com.codewithfibbee.workingwithcsv.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepo extends JpaRepository<Tutorial, Long> {
}

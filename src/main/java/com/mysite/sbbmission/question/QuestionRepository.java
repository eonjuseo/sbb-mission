package com.mysite.sbbmission.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    //제목으로 조회
    Question findBySubject(String subject);
    //제목, 내용으로 조회
    Question findBySubjectAndContent(String subject, String content);
    //특정 문자열로 조회
    List<Question> findBySubjectLike(String subject);

    Page<Question> findAll(Pageable pageable);

}
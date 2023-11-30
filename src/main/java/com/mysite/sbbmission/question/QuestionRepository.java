package com.mysite.sbbmission.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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

    Page<Question> findAll(Specification<Question> spec, Pageable pageable);

//    @Query("select "
//            + "distinct q "
//            + "from Question q "
//            + "left outer join SiteUser u1 on q.author=u1 "
//            + "left outer join Answer a on a.question=q "
//            + "left outer join SiteUser u2 on a.author=u2 "
//            + "where "
//            + "   q.subject like %:kw% "
//            + "   or q.content like %:kw% "
//            + "   or u1.username like %:kw% "
//            + "   or a.content like %:kw% "
//            + "   or u2.username like %:kw% ")
//    Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable); 쿼리
}
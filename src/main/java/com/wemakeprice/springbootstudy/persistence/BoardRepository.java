package com.wemakeprice.springbootstudy.persistence;

import com.wemakeprice.springbootstudy.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    //    쿼리메소드
    List<Board> findByTitle(String title);

    List<Board> findByTitleContaining(String title);

    List<Board> findByTitleContainingOrContentContaining(String title, String content);

    List<Board> findByTitleContainingOrderBySeqDesc(String title);

    List<Board> findByContentContaining(String content, Pageable paging);

//    Page<Board> findByWriterContaining(String content, Pageable paging);
}
//    좀 더 복잡한 쿼리를 사용해야할 때 @Query 어노테이션
//    위치
//    @Query("SELECT b From Board b where b.title like %?1% ORDER BY b.seq desc ")
//    List<Board> queryAnnotationTest1(String keyword);
////    이름
//    @Query("SELECT b From Board b where b.title like %:searchKeyword% ORDER BY b.seq desc ")
//    List<Board> queryAnnotationTest2(@Param("searchKeyword") String kkkk);
//
//    @Query("SELECT b From Board b ORDER BY b.seq desc ")
//    List<Board> queryAnnotationTest3(Pageable paging);
//}

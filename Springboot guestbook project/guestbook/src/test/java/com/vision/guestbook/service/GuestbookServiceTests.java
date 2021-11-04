package com.vision.guestbook.service;

import com.vision.guestbook.dto.GuestbookDTO;
import com.vision.guestbook.dto.PageRequestDTO;
import com.vision.guestbook.dto.PageResultDTO;
import com.vision.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GuestbookServiceTests {

    @Autowired
    private GuestbookService guestbookService;

    @Test
    public void testRegister(){
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Title...").content("Sample Content...").writer("user0").build();
        System.out.println(guestbookService.register(guestbookDTO));
    }

//    @Test
//    public void testList(){
//
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
//
//        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = guestbookService.getList(pageRequestDTO);
//
//        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
//            System.out.println(guestbookDTO);
//        }
//    }

    @Test
    public void testList(){

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = guestbookService.getList(pageRequestDTO);

        System.out.println("PREV: "+resultDTO.isPrev());
        System.out.println("NEXT: "+resultDTO.isNext());
        System.out.println("TOTAL: " + resultDTO.getTotalPage());

        System.out.println("-------------------------------------");
        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
            System.out.println(guestbookDTO);
        }

        System.out.println("========================================");
        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }


//    @Test
//    public void testSearch(){
//
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
//                .page(1)
//                .size(10)
//                .type("tc")   //검색 조건 t, c, w, tc, tcw ..
//                .keyword("한글")  // 검색 키워드
//                .build();
//
//        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = guestbookService.getList(pageRequestDTO);
//
//        System.out.println("PREV: "+resultDTO.isPrev());
//        System.out.println("NEXT: "+resultDTO.isNext());
//        System.out.println("TOTAL: " + resultDTO.getTotalPage());
//
//        System.out.println("-------------------------------------");
//        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
//            System.out.println(guestbookDTO);
//        }
//
//        System.out.println("========================================");
//        resultDTO.getPageList().forEach(i -> System.out.println(i));
//    }
}

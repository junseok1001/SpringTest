package com.sourjelly.springtest.ajax;


import com.sourjelly.springtest.ajax.domain.Booking;
import com.sourjelly.springtest.ajax.service.PensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/ajax/pension")
@Controller
public class PensionController {

    @Autowired
    private PensionService pensionService;

    // 팬션 예약 정보 보여주기
    @GetMapping("/list")
    public String pensionList(Model model){

        List<Booking> permissList =  pensionService.selectPermissInfo();

        model.addAttribute("permissList", permissList);

        return "ajax/pension/list";
    }

    // 조회 사이트 보여주기
    @GetMapping("/search")
    public String searchPage(){
        return "ajax/pension/search";
    }

    // 입력사이트 보여주기
    @GetMapping("/input")
    public String inputPage(){
        return "ajax/pension/input";
    }


    // api 만들곳

    // id를 받으면, 그 해당 id 를 삭제하는 api
    @PostMapping("/remove")
    @ResponseBody
    public Map<String, Boolean> removeInfo(
           @RequestParam("id") int id){

        //삭제 되었으면 {"result" : true}
        //삭제 안되어 있으면 {"result": false}

        Map<String, Boolean> isDuplicate = new HashMap<>();
        isDuplicate.put("result", pensionService.deleteBooking(id));

        return isDuplicate;
    }


    //view 로 부터 전달받은 값을 저장하기
    @PostMapping("/input")
    @ResponseBody
    public int inputInfo(@ModelAttribute Booking booking){
        int count = pensionService.insertBooking(booking);

        return count;
    }

    // 조회할 정보를 파라미터로 전달받음
    // response body에서 만약 booking 이 비어있는것을 주면 responseboy를 받은 페이지는 그냥 아무것도 응답에 담지 않는다.
    // 그럼 기준이 엄청 모호 해지기 때문에 내가 명확하게 담아서 줘야한다.
    @PostMapping("/select")
    @ResponseBody
    public Map<String, Object> findInfo(
            @RequestParam("name") String name
            ,@RequestParam("phoneNumber")  String phoneNumber){
        Booking booking =  pensionService.selectBooking(name, phoneNumber);



        // 응답에 담을 JSON 문자열을  생성
        // JSON 문자열 만드는 방법
        // 1. 내가 직접 만들기 이게 맞는듯.
        // 2. 객체를 responsebody에 담기 그러면 spring에 의해서 json 문자열로 변환.(단 JSON 문자열로 변환할때 값들이 비어져 있다면, responsebody에는 아무것도 안보낸다.)

        // 내가 직접 만든다 성공시 결과에 객체를 담고 실패시 null을 담는다.
        // {"name":강하늘, "day":2, "headcount":2}
        Map<String, Object> bookingMap = new HashMap<>();

        if(booking != null){
            // 성공시 {"result":"success"}
            bookingMap.put("result", "success");
            bookingMap.put("booking", booking);
            return bookingMap;

        }else{
            // 실패시 {"result":"fail"}
            bookingMap.put("result", "fail");
            return bookingMap;
        }

//        if(booking != null){
//            // 성공시 {"result":"success"}
//
//            bookingMap.put("result", "success");
//            bookingMap.put("name", booking.getName());
//            bookingMap.put("date", booking.getDate() + "");
//            bookingMap.put("day", booking.getDay() + "");
//            bookingMap.put("headcount", booking.getHeadcount() + "");
//            bookingMap.put("state", booking.getState());
//            return bookingMap;
//        }else{
//            // 실패시 {"result":"fail"}
//            bookingMap.put("result", "fail");
//            return bookingMap;
//        }

    }

}

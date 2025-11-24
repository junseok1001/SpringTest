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
    @PostMapping("/select")
    @ResponseBody
    public Booking findInfo(
            @RequestParam("name") String name
            ,@RequestParam("phoneNumber")  String phoneNumber){
        Booking booking =  pensionService.selectBooking(name, phoneNumber);

        return booking;
    }

}

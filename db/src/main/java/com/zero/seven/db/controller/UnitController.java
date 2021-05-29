package com.zero.seven.db.controller;


import com.zero.seven.common.controller.R;
import com.zero.seven.db.entity.Unit;
import com.zero.seven.db.request.UnitSaveRequest;
import com.zero.seven.db.server.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/snake/unit")
public class UnitController {
    @Autowired
    private UnitService unitService;

    @PostMapping(value = "/save")
   public R save(@RequestBody UnitSaveRequest request){
       Unit unit=new Unit();
       unit.setAge(request.getAge());
       unit.setName(request.getName());
       unitService.save(unit);
       return R.ok();
   }

    @GetMapping(value = "/get/{id}")
    public R getById(@PathVariable("id")Integer id){
       Unit unit= unitService.getById(id);
       return R.ok(unit);

    }
}

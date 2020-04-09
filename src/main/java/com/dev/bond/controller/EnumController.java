package com.dev.bond.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dev.bond.entity.Enum;
import com.dev.bond.mapper.EnumMapper;
import com.dev.bond.result.Result;
import com.dev.bond.service.IEnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wzj123
 * @since 2020-02-19
 */
@RestController
public class EnumController {
    @Autowired
    private EnumMapper enummapper;
    @Autowired
    private IEnumService enumService;
    @CrossOrigin
    @RequestMapping(value = "api/getServiceFee", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, Object> queryFee(@RequestParam(name = "enumName") String enumName){
        System.out.println(enumName);
        HashMap<String,Object> map = new HashMap<>();
        List<Enum> enumList = enummapper.selectServiceFeeByEnumName(enumName);
        System.out.println(enumList);
        System.out.println(enumList.toString());
//        return ResultUtil.success(serviceFeeList);
        map.put("code","200");
        map.put("msg","成功");
        map.put("result",enumList);
        return map;
    }

    @CrossOrigin
    @RequestMapping(value = "api/addServiceFee",method = RequestMethod.POST)
    @ResponseBody
    public Result addServiceFee(@RequestBody Enum serviceFee){
        String enumName = serviceFee.getEnumName();
        String enumType = serviceFee.getEnumType();
        String enumValue= serviceFee.getEnumValue();
        //System.out.println(enumName);
        try {
            if(!enumService.insertService(serviceFee)){
                return new Result(202,"用户已存在");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new Result(201,"新增异常");
        }
        return new Result(200,"添加成功");
    }

    @CrossOrigin
    @RequestMapping(value = "api/updateServiceFee",method = RequestMethod.POST)
    @ResponseBody
    public Result updateServiceFee(@RequestBody Enum serviceFee){
        try {
            enumService.updateService(serviceFee);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(201,"修改异常");
        }
        return new Result(200,"修改成功");
    }

    @CrossOrigin
    @RequestMapping(value = "api/deleteServiceFee",method = RequestMethod.POST)
    @ResponseBody
    public Result deleteServiceFee(@RequestBody Enum serviceFee){
        try {
            enumService.deleteService(serviceFee);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(201,"删除异常");
        }
        return new Result(200,"删除成功");
    }

    @CrossOrigin
    @RequestMapping(value = "api/getEnum" ,method = RequestMethod.POST)
    @ResponseBody
    public Result getEnum (@RequestBody HashMap<String,String> json){
        String enumName = json.get("enumName");
        System.out.println(enumName+"------");
        List<Enum> enumList = enumService.selectList(new EntityWrapper<Enum>().eq("ENUM_NAME", enumName));
        return new Result(200,"获取成功",enumList);
    }

    @CrossOrigin
    @RequestMapping(value = "api/addEnum" ,method = RequestMethod.POST)
    @ResponseBody
    public Result addEnum (@RequestBody Enum enumData){
//        String enumName = json.get("enumName");
//        System.out.println(enumName+"------");
//        List<Enum> enumList = enumService.selectList(new EntityWrapper<Enum>().eq("ENUM_NAME", enumName));
        enumService.insert(enumData);
        return new Result(200,"添加成功");
    }

    @CrossOrigin
    @RequestMapping(value = "api/updateEnum" ,method = RequestMethod.POST)
    @ResponseBody
    public Result updateEnum (@RequestBody Enum enumData){
    boolean delete = enumService.update(enumData,new EntityWrapper<Enum>().eq("ENUM_TYPE",enumData.getEnumType()));
        return new Result(200,"修改成功");
    }

    @CrossOrigin
    @RequestMapping(value = "api/deleteEnum" ,method = RequestMethod.POST)
    @ResponseBody
    public Result deleteEnum (@RequestBody Enum enumData){
//        String enumName = json.get("enumName");
//        System.out.println(enumName+"------");
//        List<Enum> enumList = enumService.selectList(new EntityWrapper<Enum>().eq("ENUM_NAME", enumName));
        boolean delete = enumService.delete(new EntityWrapper<Enum>().eq("ENUM_TYPE",enumData.getEnumType()));
        return new Result(200,"删除成功");
    }

    @CrossOrigin
    @RequestMapping(value = "api/queryServiceFee" ,method = RequestMethod.POST)
    @ResponseBody
    public Result getService (@RequestBody HashMap<String,String> json){
        String enumType = json.get("enumType");
        Enum serviceObjct = enumService.selectOne(new EntityWrapper<Enum>().eq("ENUM_TYPE", enumType));
        String enumValue = serviceObjct.getEnumValue();
        return new Result(200,"获取成功",enumValue);
    }
}


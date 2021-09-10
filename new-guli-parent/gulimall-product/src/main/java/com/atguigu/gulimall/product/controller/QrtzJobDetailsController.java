package com.atguigu.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.gulimall.product.entity.QrtzJobDetailsEntity;
import com.atguigu.gulimall.product.service.QrtzJobDetailsService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-09 23:59:24
 */
@RestController
@RequestMapping("product/qrtzjobdetails")
public class QrtzJobDetailsController {
    @Autowired
    private QrtzJobDetailsService qrtzJobDetailsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzJobDetailsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    public R info(@PathVariable("schedName") String schedName){
		QrtzJobDetailsEntity qrtzJobDetails = qrtzJobDetailsService.getById(schedName);

        return R.ok().put("qrtzJobDetails", qrtzJobDetails);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QrtzJobDetailsEntity qrtzJobDetails){
		qrtzJobDetailsService.save(qrtzJobDetails);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QrtzJobDetailsEntity qrtzJobDetails){
		qrtzJobDetailsService.updateById(qrtzJobDetails);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] schedNames){
		qrtzJobDetailsService.removeByIds(Arrays.asList(schedNames));

        return R.ok();
    }

}

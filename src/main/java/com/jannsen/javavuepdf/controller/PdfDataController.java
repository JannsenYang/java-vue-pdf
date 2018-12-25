package com.jannsen.javavuepdf.controller;


import com.alibaba.fastjson.JSON;
import com.jannsen.javavuepdf.utils.CommonUtils;
import com.jannsen.javavuepdf.vo.Module1Page1Vo;
import com.jannsen.javavuepdf.vo.Module1Page2Vo;
import com.jannsen.javavuepdf.vo.Module2Page1Vo;
import com.jannsen.javavuepdf.vo.Module2Page2Vo;
import org.springframework.web.bind.annotation.*;

/**
 * nuxt服务请求返回业务数据
 * 由于ssr只支持get请求 所以如果一次将所有数据都通过url传送的方式不太好 因此通过一次反向查询数据的方式传递数据更靠谱
 * 此id数据来源于PdfFactoryController PdfUtils.create中url最后一个参数
 */
@RestController
@RequestMapping("/pdfData")
public class PdfDataController {

    @GetMapping("/module1Page1/{id}")
    public Module1Page1Vo module1Page1(@PathVariable String id) {
        // Module1Page1Vo module1Page1Vo = xxxService.selectById(id);
        // 通过id查询数据库获取数据


        Module1Page1Vo module1Page1Vo = JSON.parseObject(CommonUtils.getFileText( this.getClass().getResource("/mock-module1page1.json").getPath()), Module1Page1Vo.class);
        module1Page1Vo.setId(id);
        return module1Page1Vo;
    }

    @GetMapping("/module1Page2/{id}")
    public Module1Page2Vo module1Page2(@PathVariable String id) {
        Module1Page2Vo module1Page2Vo = JSON.parseObject(CommonUtils.getFileText(this.getClass().getResource("/mock-module1page2.json").getPath()), Module1Page2Vo.class);
        module1Page2Vo.setId(id);
        return module1Page2Vo;
    }

    @GetMapping("/module2Page1/{id}")
    public Module2Page1Vo module2Page1(@PathVariable String id) {
        Module2Page1Vo module2Page1Vo = JSON.parseObject(CommonUtils.getFileText(this.getClass().getResource("/mock-module2page1.json").getPath()), Module2Page1Vo.class);
        module2Page1Vo.setId(id);
        return module2Page1Vo;
    }

    @GetMapping("/module2Page2/{id}")
    public Module2Page2Vo module2Page2(@PathVariable String id) {
        Module2Page2Vo module2Page2Vo = JSON.parseObject(CommonUtils.getFileText(this.getClass().getResource("/mock-module2page2.json").getPath()), Module2Page2Vo.class);
        module2Page2Vo.setId(id);
        return module2Page2Vo;
    }
}


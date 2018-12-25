package com.jannsen.javavuepdf.controller;


import com.jannsen.javavuepdf.utils.PdfUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * pdf生成入口
 * 在大多数情况下pdf都是通过定时任务生成的 这里只是一个例子 挪一挪改一改就可以用了
 */
@RestController
@RequestMapping("/pdfDownload")
public class PdfDownloadController {

    @ResponseBody
    @RequestMapping(value = "/module1Page1/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> module1Page1(@PathVariable String id, HttpServletResponse response) {
        return PdfUtils.create("/module1/page1/" + id, "module1-page1.pdf", response);
    }

    @ResponseBody
    @RequestMapping(value = "/module1Page2/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> module1Page2(@PathVariable String id, HttpServletResponse response) {
        return PdfUtils.create("/module1/page2/" + id, "module1-page2.pdf", response);
    }

    @ResponseBody
    @RequestMapping(value = "/module2Page1/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> module2Page1(@PathVariable String id, HttpServletResponse response) {
        return PdfUtils.create("/module2/page1/" + id, "module2-page1.pdf", response);
    }

    @ResponseBody
    @RequestMapping(value = "/module2Page2/{id}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> module2Page2(@PathVariable String id, HttpServletResponse response) {
        return PdfUtils.create("/module2/page2/" + id, "module2-page2.pdf", response);
    }

}


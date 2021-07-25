package com.dxtech.yqdl.controller;

import com.dxtech.yqdl.entity.PowerStation;
import com.dxtech.yqdl.entity.PowerStationImage;
import com.dxtech.yqdl.service.FileInfoService;
import com.dxtech.yqdl.service.PowerStationImageService;
import com.dxtech.yqdl.service.PowerStationService;
import com.dxtech.yqdl.utils.ResponseInfo;
import com.dxtech.yqdl.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PowerStationImageController {

    @Autowired
    private PowerStationService powerStationService;

    @Autowired
    private FileInfoService fileInfoService;

    @Autowired
    private PowerStationImageService powerStationImageService;

    @GetMapping(value = "/getImage")
    public ResponseInfo getImage() {
        List<PowerStationImage> psi =  powerStationImageService.getStationImage();
        return ResponseUtil.success(psi);
    }

    @PostMapping(value = "/uplodeFile")
    public ResponseInfo uplodeFile(@RequestParam("file") MultipartFile file, @RequestParam("stationId") int stationId,@RequestParam("img_desc") String img_desc,HttpServletRequest request) throws IOException {
        if (file.isEmpty()) {
            return ResponseUtil.fail("文件不能为空");
        }
        return fileInfoService.upload(file,stationId,img_desc);

    }


    /**
     * 文件下载
     * @param fileName
     * @param res
     */
    @GetMapping(value = "/downloadFile/{fileName}")
    public void downloadFile(@PathVariable("fileName") String fileName, HttpServletResponse res) throws UnsupportedEncodingException {
        fileInfoService.downloadFile(fileName, res);
    }
}

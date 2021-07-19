package com.DXTech.YQDL.controller;

import com.DXTech.YQDL.entity.PowerStationImage;
import com.DXTech.YQDL.entity.User;
import com.DXTech.YQDL.service.FileInfoService;
import com.DXTech.YQDL.service.PowerStationImageService;
import com.DXTech.YQDL.service.UserService;
import com.DXTech.YQDL.utils.ResponseInfo;
import com.DXTech.YQDL.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

@RestController
public class PowerStationImageController {

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
    public ResponseInfo uplodeFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        if (file.isEmpty()) {
            return ResponseUtil.fail("文件不能为空");
        }
        return fileInfoService.upload(file);

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

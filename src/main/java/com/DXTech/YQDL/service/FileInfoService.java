package com.DXTech.YQDL.service;

import com.DXTech.YQDL.dao.PowerStationImageDao;
import com.DXTech.YQDL.entity.PowerStationImage;
import com.DXTech.YQDL.utils.ResponseInfo;
import com.DXTech.YQDL.utils.ResponseUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

@Service
public class FileInfoService {

    @Autowired
    private PowerStationImageDao powerStationImageDao;

    public ResponseInfo<?> upload(MultipartFile file) throws IOException {
        //基础路径  E:/springboot-upload/image/
        String basePath = "C:/yqdl-upload/image/";
        File fileDir = new File(basePath);
        if(!fileDir.exists()) {
            fileDir.mkdir();
        }
        String suffixname = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        String new_filename = UUID.randomUUID()+suffixname;

        try {
            Path fullPath = Paths.get(basePath,new_filename);
            Files.write(fullPath, file.getBytes(), StandardOpenOption.CREATE);

            //保存文件信息
            PowerStationImage fileInfo = new PowerStationImage();
            fileInfo.setOrigin_name(file.getOriginalFilename());
            fileInfo.setFile_type(file.getContentType());
            fileInfo.setFile_size(String.valueOf(file.getSize()));
            fileInfo.setFile_name(new_filename);
            fileInfo.setFile_desc("");
            fileInfo.setFile_path(basePath);
            fileInfo.setPower_station_id(1);
            System.out.println(fileInfo.toString());
            powerStationImageDao.insertImage(fileInfo);
        } catch (Exception e) {
            return ResponseUtil.fail(e.getMessage());
        }
        return ResponseUtil.success("上传成功");
    }

    /**
     * 文件下载
     *
     * @param fileName
     * @param res
     */
    public void downloadFile(String fileName, HttpServletResponse res) throws UnsupportedEncodingException {

        // 通过文件名查找文件信息
        PowerStationImage fileInfo = powerStationImageDao.getImageByFileName(fileName);

        //设置响应头
        res.setContentType("application/force-download");// 设置强制下载不打开
        res.addHeader("Content-Disposition", "attachment;fileName=" +
                new String(fileInfo.getOrigin_name().getBytes("gbk"), "iso8859-1"));// 设置文件名
        res.setHeader("Context-Type", "application/xmsdownload");

        //判断文件是否存在
        File file = new File(Paths.get(fileInfo.getFile_path(), fileInfo.getFile_name()).toString());
        if (file.exists()) {
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = res.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

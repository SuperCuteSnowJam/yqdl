package com.dxtech.yqdl.service;

import com.dxtech.yqdl.config.CommonConfig;
import com.dxtech.yqdl.dao.PowerStationImageDao;
import com.dxtech.yqdl.entity.PowerStationImage;
import com.dxtech.yqdl.utils.QRCodeUtils;
import com.dxtech.yqdl.utils.ResponseInfo;
import com.dxtech.yqdl.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
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

    public ResponseInfo<?> upload(MultipartFile file,int stationId,String img_desc) throws IOException {
        //基础路径  E:/springboot-upload/image/
        String basePath = CommonConfig.uploadFilePath;
        File fileDir = new File(basePath);
        if(!fileDir.exists()) {
            fileDir.mkdirs();
        }
        if(!new File(CommonConfig.qrcodeFilePath).exists()){
            new File(CommonConfig.qrcodeFilePath).mkdirs();
        }
        String suffixname = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        String new_filename = UUID.randomUUID()+suffixname;

        try {
            Path fullPath = Paths.get(basePath,new_filename);
            Files.write(fullPath, file.getBytes(), StandardOpenOption.CREATE);

            String text = CommonConfig.urlFormatPath + new_filename;  //这里设置自定义网站url或文字
            String logoPath = "";
            String destPath = CommonConfig.qrcodeFilePath;		//保存地址
            //调用工具类

            //保存文件信息
            PowerStationImage fileInfo = new PowerStationImage();
            fileInfo.setOrigin_name(file.getOriginalFilename());
            fileInfo.setFile_type(file.getContentType());
            fileInfo.setFile_size(String.valueOf(file.getSize()));
            fileInfo.setFile_name(new_filename);
            fileInfo.setFile_desc(img_desc);
            fileInfo.setFile_path(basePath);
            fileInfo.setFile_qrcode_path(destPath + QRCodeUtils.encode(text, logoPath, destPath, true));
            fileInfo.setPower_station_id(stationId);
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
     * @param fileid
     * @param res
     */
    public void downloadFile(int fileid, HttpServletResponse res) throws UnsupportedEncodingException {

        // 通过文件名查找文件信息
        PowerStationImage fileInfo = powerStationImageDao.getImageById(fileid);

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

    /**
     * 二维码下载
     */
    public void downloadQRCodeFile(int fileId, HttpServletResponse res) throws UnsupportedEncodingException {

        // 通过文件名查找文件信息
        PowerStationImage fileInfo = powerStationImageDao.getImageById(fileId);

        //设置响应头
        res.setContentType("application/force-download");// 设置强制下载不打开
        res.addHeader("Content-Disposition", "attachment;fileName=" +
                new String(fileInfo.getOrigin_name().getBytes("gbk"), "iso8859-1"));// 设置文件名
        res.setHeader("Context-Type", "application/xmsdownload");

        //判断文件是否存在
        File file = new File(fileInfo.getFile_qrcode_path());
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

    /**
     * 删除文件
     * @param fileId
     */
    public void deleteFile(int fileId){
        powerStationImageDao.deleteFileById(fileId);
    }
}

package studio.jikewang.util;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import studio.jikewang.exception.ErrorException;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;


/**
 * @author 李文浩
 * @version 2017/4/6.
 */

@Component
public class FileUtil {
    @Autowired
    ServletContext servletContext;

    private static String[] fileTypes = {"jpg", "jpeg", "gif", "png"};

    /**
     * 上传功能实现
     *
     * @param file
     * @return
     */
    public String uploadImage(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String type = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        type = type.toLowerCase();
        String savepath;
        String effectPictureAddress;
        //如果扩展名属于允许上传的类型
        if (ArrayUtils.contains(fileTypes, type)) {
            try {
                System.out.println(file.getContentType());
                effectPictureAddress = "image" + File.separator
                        + System.currentTimeMillis() + file.getOriginalFilename();
                savepath = servletContext.getRealPath("/")
                        + effectPictureAddress;
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(savepath));
            } catch (IOException e3) {
                throw new ErrorException("图片上传失败");
            }
        } else {
            throw new ErrorException("文件类型不支持");
        }
        return effectPictureAddress;
    }

    public void delete(String filePath) {
        if (ValidateUtil.NotEmpty(filePath)) {
            String path = servletContext.getRealPath("/")
                    + filePath;
            FileUtils.deleteQuietly(new File(path));
        }
    }
}

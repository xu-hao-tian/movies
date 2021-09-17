package com.example.movies.server.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.example.movies.server.OssService;
import com.example.movies.util.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 实现类 完成图片上传，且返回地址.
 *
 * @Author: 许昊天
 * @Date: 2021/09/15/11:40
 * @Description:
 */
@Component
public class OssServiceImpl implements OssService {
    /**
     * 演员的头像或影像的海报上传
     * @param file 上传的文件
     * @return 返回文件的路径
     */
    @Override
    public String uploadFileAvatar(MultipartFile file) {
        // 通过工具类获取配置数据
        // 获取oss的地址
        String endPoint = ConstantPropertiesUtils.END_POINT;
        // 获取访问凭证的ID
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        // 获取访问凭证的秘钥
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        // 获取 bucker 名称
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        // 完成上传
        try {
            // 获取上传的输入流
            InputStream inputStream = file.getInputStream();
            // 获取文件名
            String filename = file.getOriginalFilename();
            // 为文件起一个唯一的名称
            filename = UUID.randomUUID().toString().replaceAll("-", "") + filename;
            // 按照年月日创建上传的目录存放图片：yyyy/MM/dd
            String datePath = new DateTime().toString("yyyy/MM/dd");
            // 拼接
            filename = datePath + "/" + filename;
            // 调用oss实现上传
            OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
            // 参数: bucker名称、文件名称、输入流
            ossClient.putObject(bucketName, filename, inputStream);
            // 关闭ossClient
            ossClient.shutdown();
            // 上传文件后需要获取文件的路径
            String url = "http://" + bucketName + "." + endPoint + "/" + filename;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

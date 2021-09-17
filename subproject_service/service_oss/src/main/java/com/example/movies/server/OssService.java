package com.example.movies.server;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 业务层 实现上传图片.
 *
 * @Author: 许昊天
 * @Date: 2021/09/15/11:34
 * @Description:
 */
public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}

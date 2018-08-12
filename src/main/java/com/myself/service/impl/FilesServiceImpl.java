package com.myself.service.impl;

import com.myself.common.ServerResponse;
import com.myself.dao.FilesMapper;
import com.myself.pojo.Files;
import com.myself.service.IFilesService;
import com.myself.util.ImageUtil;
import com.myself.util.ImgHolderUtil;
import com.myself.util.KeyUtil;
import com.myself.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 9:30 2018\8\12 0012
 */
@Service("iFilesService")
public class FilesServiceImpl implements IFilesService {

    @Autowired
    private FilesMapper filesMapper;

    @Override
    public ServerResponse saveUserFault(String msg, CommonsMultipartFile faultImage) {
        if (msg == null){
            return ServerResponse.createByErrorMessage("指定参数为传输！！！");
        }
        Files files = new Files();
        files.setId(KeyUtil.genSimpleUniqueKey());
        files.setMsg(msg);
        try {
            if (faultImage != null){
                ImgHolderUtil imgHolder = new ImgHolderUtil(faultImage.getOriginalFilename(),faultImage.getInputStream());
                if (imgHolder.getImage() != null){
                    //存储图片
                    addFaultImg(files,imgHolder);
                }
            }
            int effectNum = filesMapper.insert(files);
            if (effectNum > 0){
                return ServerResponse.createBySuccess("反馈成功！");
            }
            return ServerResponse.createByErrorMessage("上传失败，请稍后上传！");
        }catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("系统异常请稍后重新上传");
        }
    }


    private void addFaultImg(Files files, ImgHolderUtil imgHolder) {
        //获取图片目录的相对值路径
        String dest = PathUtil.getImagePath(files.getId());
        String ImgAddr = ImageUtil.generateThumbnail(imgHolder,dest);
        files.setImg(ImgAddr);
    }
}

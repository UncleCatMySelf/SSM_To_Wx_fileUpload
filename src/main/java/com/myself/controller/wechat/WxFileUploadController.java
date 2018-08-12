package com.myself.controller.wechat;

import com.myself.common.ServerResponse;
import com.myself.service.IFilesService;
import com.myself.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 9:28 2018\8\12 0012
 */
@Controller
@RequestMapping("/api/v1/file")
public class WxFileUploadController {

    @Autowired
    private IFilesService iFilesService;

    @RequestMapping(value = "/save_fault",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public ServerResponse saveFault(HttpSession session, HttpServletRequest request){
        String msg = HttpServletRequestUtil.getString(request,"msg");
        CommonsMultipartFile faultImage = null;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)){
            MultipartHttpServletRequest httpServletRequest = (MultipartHttpServletRequest) request;
            faultImage = (CommonsMultipartFile) httpServletRequest.getFile("file");
        }
        return iFilesService.saveUserFault(msg,faultImage);
    }

}

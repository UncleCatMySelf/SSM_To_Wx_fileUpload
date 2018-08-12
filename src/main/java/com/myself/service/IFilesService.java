package com.myself.service;

import com.myself.common.ServerResponse;
import org.springframework.web.multipart.commons.CommonsMultipartFile; /**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 9:30 2018\8\12 0012
 */
public interface IFilesService {

    ServerResponse saveUserFault(String msg, CommonsMultipartFile faultImage);

}

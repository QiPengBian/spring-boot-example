package com.example.sys.controller;

import cn.com.bluemoon.common.web.exception.AssertUtil;
import cn.com.bluemoon.common.web.response.ResponseBean;
import com.example.common.constant.ParamConstant;
import com.example.common.enums.ErrorCodeEnum;
import com.example.sys.domain.vo.UserQueryVo;
import com.example.sys.domain.vo.UserVo;
import com.example.sys.service.UserService;
import cn.com.bluemoon.mybatis.api.Paging;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 用户信息表
 * @author: QiPeng
 * @date: 2021-02-05 16:01:56
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/crm/admin/")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @description: 分页查询
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: json
     * @return: ResponseBean
     */
    @PostMapping("/queryUserPageList")
    public ResponseBean queryUserPageList(@RequestBody JSONObject json) {
        ResponseBean responseBean = ResponseBean.success();
        Paging paging = json.getObject(ParamConstant.PAGE, Paging.class);
        UserQueryVo userQueryVo = json.getObject(ParamConstant.PARAM, UserQueryVo.class);
        AssertUtil.notNull(paging, ErrorCodeEnum.PARAM_ERROR.getCode(), ErrorCodeEnum.PARAM_ERROR.getMessage());
        AssertUtil.notNull(userQueryVo, ErrorCodeEnum.PARAM_ERROR.getCode(), ErrorCodeEnum.PARAM_ERROR.getMessage());
        responseBean.setData(userService.queryPage(paging, userQueryVo));
        return responseBean;
    }

    /**
     * @description: 主键查询
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: id
     * @return: ResponseBean
     */
    @GetMapping("/queryUserModelById")
    public ResponseBean queryUserModelById(Integer id) {
        ResponseBean responseBean = ResponseBean.success();
        AssertUtil.notNull(id, ErrorCodeEnum.PARAM_ERROR.getCode(), ErrorCodeEnum.PARAM_ERROR.getMessage());
        UserVo userVo = userService.queryModelById(id);
        responseBean.setData(userVo);
        return responseBean;
    }

    /**
     * @description: 新增
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: json
     * @return: ResponseBean
     */
    @PostMapping("/saveOrUpdateUserModel")
    public ResponseBean saveOrUpdateUserModel(@RequestBody JSONObject json) {
        UserVo userVo = json.getObject(ParamConstant.PARAM, UserVo.class);
        AssertUtil.notNull(userVo, ErrorCodeEnum.PARAM_ERROR.getCode(), ErrorCodeEnum.PARAM_ERROR.getMessage());
        userService.saveOrUpdateModelSelective(userVo);
        return ResponseBean.success();
    }

    /**
     * @description: 修改数据
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: json
     * @return: ResponseBean
     */
    @PostMapping("/updateUserModelById")
    public ResponseBean updateUserModelById(@RequestBody JSONObject json) {
        UserVo userVo = json.getObject(ParamConstant.PARAM, UserVo.class);
        AssertUtil.notNull(userVo, ErrorCodeEnum.PARAM_ERROR.getCode(), ErrorCodeEnum.PARAM_ERROR.getMessage());
        userService.updateModelSelectiveForce(userVo);
        return ResponseBean.success();
    }

    /**
     * @description: 批量逻辑删除数据
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: json
     * @return: ResponseBean
     */
    @PostMapping("/deleteUserModelByIdList")
    public ResponseBean deleteUserModelByIdList(@RequestBody JSONObject json) {
        JSONArray jsonJSONArray = json.getJSONArray(ParamConstant.ID_LIST);
        List<Integer> idList = jsonJSONArray.toJavaList(Integer.class);
        userService.deleteModelByIdList(idList);
        return ResponseBean.success();
    }
}

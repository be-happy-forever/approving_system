package com.approving.system.common;

/**
 * @Auth: zhuan
 * @Desc: 返回结果消息提示常量类
 */
public class MessageConstant {
    //---------------------------审批信息（INFORMATION）操作消息提示信息---------------------------------------
    public static final String INFORMATION_SEARCH_SUCCESS="查询列表信息成功！";
    public static final String INFORMATION_ADD_SUCCESS="新增审批信息成功！";
    public static final String INFORMATION_UPDATE_SUCCESS="修改审批信息成功！";
    public static final String INFORMATION_DELETE_SUCCESS="删除审批信息成功！";
    public static final String INFORMATION_FIND_BY_ID_SUCCESS = "根据主键获取审批信息对象成功！";
    public static final String INFORMATION_UPDATE_STATUS_SUCCESS = "审批信息状态更新成功！";
    //---------------------------教工（STUFF）操作消息提示信息---------------------------------------
    public static final String STUFF_SEARCH_SUCCESS="查询教工列表信息成功！";
    public static final String STUFF_ADD_SUCCESS="新增教工信息成功！";
    public static final String STUFF_UPDATE_SUCCESS="修改教工信息成功！";
    public static final String STUFF_DELETE_SUCCESS="删除教工信息成功！";
    public static final String STUFF_FIND_BY_ID_SUCCESS = "根据主键获取教工对象成功！";
    //---------------------------系统提示信息----------------------------------------------------------
    public static final String SYSTEM_BUSY = "系统繁忙，请求稍后重试！";
    //---------------------------文件上传提示信息-------------------------------------------------------
    public static final String NO_FILE_SELECTED = "未选择上传的文件,请求选择后上传!";
    public static final String NO_WRITE_PERMISSION = "上传目录没有写权限!";
    public static final String INCORRECT_DIRECTORY_NAME = "目录名不正确!";
    public static final String SIZE_EXCEEDS__LIMIT = "上传文件大小超过限制!";
    public static final String FILE_TYPE_ERROR = "文件类型错误，只允许上传JPG/PNG/JPEG/GIF等图片类型的文件!";

}

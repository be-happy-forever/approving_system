package com.approving.system.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "tb_stuff")
@Data
public class Stuff implements Serializable {

    @Id
    // 主键id
//    @ExcelIgnore // 生成报表时忽略，不生成次字段
    @ExcelProperty(value = "教工id", index = 0)
    private Integer id;
    @ExcelProperty(value = "教工名字", index = 1)
    private String name;
    @ExcelProperty(value = "性别", index = 2)
    private String sex;
    @ExcelProperty(value = "学院", index = 3)
    private String college;
    @ExcelProperty(value = "系别", index = 4)
    private String department;
    @ExcelProperty(value = "职称", index = 5)
    private String title;
    @ExcelProperty(value = "学历", index = 6)
    private String academic;
    @ExcelProperty(value = "初始密码", index = 7)
    private String password;
    @ExcelProperty(value = "手机号", index = 8)
    private String phoneNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAcademic() {
        return academic;
    }

    public void setAcademic(String academic) {
        this.academic = academic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

}

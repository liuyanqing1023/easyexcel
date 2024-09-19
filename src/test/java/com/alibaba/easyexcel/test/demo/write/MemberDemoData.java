package com.alibaba.easyexcel.test.demo.write;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 基础数据类
 *
 * @author Jiaju Zhuang
 **/
public class MemberDemoData {
    @ExcelProperty("id")
    private String id;
    @ExcelProperty("pmid")
    private String pmid;
    @ExcelProperty("phonePrefix")
    private String phonePrefix;
    @ExcelProperty("phoneNumber")
    private String phoneNumber;
    @ExcelProperty("firstName")
    protected String firstName;
    @ExcelProperty("lastName")
    protected String lastName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public String getPhonePrefix() {
        return phonePrefix;
    }

    public void setPhonePrefix(String phonePrefix) {
        this.phonePrefix = phonePrefix;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName.trim();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public String getLastName() {
        return lastName.trim();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }
}

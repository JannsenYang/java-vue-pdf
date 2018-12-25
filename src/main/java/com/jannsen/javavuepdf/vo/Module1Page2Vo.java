package com.jannsen.javavuepdf.vo;

import com.jannsen.javavuepdf.vo.child.DiseaseItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 真实的业务数据
 */
public class Module1Page2Vo {

    private String id;

    private String name;

    private String mobile;

    private Long birthday;

    private String gender;

    private String bloodGroup;

    private String rhAntigen;

    private String subhealthCode;

    private String salesName;

    private String companyName;

    private Long createdTime;

    private List<DiseaseItem> focusDisease;

    private Map<String, BigDecimal> riskValueMap;

    private Map<String, List<DiseaseItem>> diseaseItemListMap;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getRhAntigen() {
        return rhAntigen;
    }

    public void setRhAntigen(String rhAntigen) {
        this.rhAntigen = rhAntigen;
    }

    public String getSubhealthCode() {
        return subhealthCode;
    }

    public void setSubhealthCode(String subhealthCode) {
        this.subhealthCode = subhealthCode;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public List<DiseaseItem> getFocusDisease() {
        return focusDisease;
    }

    public void setFocusDisease(List<DiseaseItem> focusDisease) {
        this.focusDisease = focusDisease;
    }

    public Map<String, BigDecimal> getRiskValueMap() {
        return riskValueMap;
    }

    public void setRiskValueMap(Map<String, BigDecimal> riskValueMap) {
        this.riskValueMap = riskValueMap;
    }

    public Map<String, List<DiseaseItem>> getDiseaseItemListMap() {
        return diseaseItemListMap;
    }

    public void setDiseaseItemListMap(Map<String, List<DiseaseItem>> diseaseItemListMap) {
        this.diseaseItemListMap = diseaseItemListMap;
    }
}

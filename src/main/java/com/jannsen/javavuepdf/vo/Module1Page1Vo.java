package com.jannsen.javavuepdf.vo;

import com.jannsen.javavuepdf.vo.child.JzexamAdvicePrjGroupVo;

import java.io.Serializable;
import java.util.List;

/**
 * 真实的业务数据
 */
public class Module1Page1Vo implements Serializable {

    private String id;

    private String name;
    private String mobile;
    private String companyName;
    private String salesName;
    private String jzcode;
    private String geneCode;
    private String subhealthCode;
    private String packageGroupName;
    private Long createdTime;
    private List<String> subhealthRisk;
    private List<String> geneRisk;
    private String pkgExamType;
    private String diseaseType;
    private List<JzexamAdvicePrjGroupVo> jzexamAdvicePrjGroupVoList;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public String getJzcode() {
        return jzcode;
    }

    public void setJzcode(String jzcode) {
        this.jzcode = jzcode;
    }

    public String getGeneCode() {
        return geneCode;
    }

    public void setGeneCode(String geneCode) {
        this.geneCode = geneCode;
    }

    public String getSubhealthCode() {
        return subhealthCode;
    }

    public void setSubhealthCode(String subhealthCode) {
        this.subhealthCode = subhealthCode;
    }

    public String getPackageGroupName() {
        return packageGroupName;
    }

    public void setPackageGroupName(String packageGroupName) {
        this.packageGroupName = packageGroupName;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public List<String> getSubhealthRisk() {
        return subhealthRisk;
    }

    public void setSubhealthRisk(List<String> subhealthRisk) {
        this.subhealthRisk = subhealthRisk;
    }

    public List<String> getGeneRisk() {
        return geneRisk;
    }

    public void setGeneRisk(List<String> geneRisk) {
        this.geneRisk = geneRisk;
    }

    public String getPkgExamType() {
        return pkgExamType;
    }

    public void setPkgExamType(String pkgExamType) {
        this.pkgExamType = pkgExamType;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public List<JzexamAdvicePrjGroupVo> getJzexamAdvicePrjGroupVoList() {
        return jzexamAdvicePrjGroupVoList;
    }

    public void setJzexamAdvicePrjGroupVoList(List<JzexamAdvicePrjGroupVo> jzexamAdvicePrjGroupVoList) {
        this.jzexamAdvicePrjGroupVoList = jzexamAdvicePrjGroupVoList;
    }
}

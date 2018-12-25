package com.jannsen.javavuepdf.vo.child;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 真实的业务数据
 */
public class DiseaseItem implements Serializable {

    private String diseaseName;

    private String diseaseId;

    private Integer riskLevel;

    private String organName;

    private String systemCode;

    private BigDecimal value;

    private BigDecimal itemDValue;

    private String itemType;

    private String detail;

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getItemDValue() {
        return itemDValue;
    }

    public void setItemDValue(BigDecimal itemDValue) {
        this.itemDValue = itemDValue;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

package io.github.egnaf.cybercutler.api.model;

import java.util.List;
import java.util.UUID;

public class CalculatorRequest   {
    private List<UUID> clientTypes;
    private Double cost;
    private Double initialFee;
    private Integer kaskoValue;

    public enum LanguageEnum {
        RU_RU("ru-RU"),

        EN("en");

        private String value;

        LanguageEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static LanguageEnum fromValue(String value) {
            for (LanguageEnum b : LanguageEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            return null;
        }
    }

    private LanguageEnum language;

    private Double residualPayment;

    private String settingsName = "Haval";

    private List<UUID> specialConditions;

    private Integer term;


    public List<UUID> getClientTypes() {
        return clientTypes;
    }

    public void setClientTypes(List<UUID> clientTypes) {
        this.clientTypes = clientTypes;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getInitialFee() {
        return initialFee;
    }

    public void setInitialFee(Double initialFee) {
        this.initialFee = initialFee;
    }

    public Integer getKaskoValue() {
        return kaskoValue;
    }

    public void setKaskoValue(Integer kaskoValue) {
        this.kaskoValue = kaskoValue;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEnum language) {
        this.language = language;
    }

    public Double getResidualPayment() {
        return residualPayment;
    }

    public void setResidualPayment(Double residualPayment) {
        this.residualPayment = residualPayment;
    }

    public String getSettingsName() {
        return settingsName;
    }

    public void setSettingsName(String settingsName) {
        this.settingsName = settingsName;
    }

    public List<UUID> getSpecialConditions() {
        return specialConditions;
    }

    public void setSpecialConditions(List<UUID> specialConditions) {
        this.specialConditions = specialConditions;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }
}


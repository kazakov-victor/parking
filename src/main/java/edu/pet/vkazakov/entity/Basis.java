package edu.pet.vkazakov.entity;

public enum Basis {
    СУТКИ("DAY"),
    МЕСЯЦ("MON"),
    ГОД("ANN");
    private String code;

    private Basis(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}

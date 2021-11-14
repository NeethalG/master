package com.movierental.constants;

public enum MovieCode {

    REGULAR("regular", 2.0),
    CHILDRENS("childrens", 1.5),
    NEW("new", 3.0);

    private final String code;
    private final double baseRent;

    MovieCode(String code, double baseRent) {
        this.code = code;
        this.baseRent = baseRent;
    }

    public String getCode() {
        return code;
    }

    public double getBaseRent() {
        return baseRent;
    }
}

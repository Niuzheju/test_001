package com.niuzj.test;

/**
 * @author niuzheju
 * @date 17:26 2022/2/17
 */
public class Subject {

    private String code;
    private String levelName;
    private String percentAge;

    public Subject() {
    }

    public Subject(String code, String levelName, String percentAge) {
        this.code = code;
        this.levelName = levelName;
        this.percentAge = percentAge;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getPercentAge() {
        return percentAge;
    }

    public void setPercentAge(String percentAge) {
        this.percentAge = percentAge;
    }
}

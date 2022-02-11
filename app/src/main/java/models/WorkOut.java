package models;

public class WorkOut {
    private String name;
    private String level;
    private String eqpName;
    private String linkYoutyube;

    public WorkOut(String name, String level, String eqpName, String linkYoutyube) {
        this.name = name;
        this.level = level;
        this.eqpName = eqpName;
        this.linkYoutyube = linkYoutyube;
    }

    public String getLinkYoutyube() {
        return linkYoutyube;
    }

    public void setLinkYoutyube(String linkYoutyube) {
        this.linkYoutyube = linkYoutyube;
    }

    public String getEqpName() {
        return eqpName;
    }

    public void setEqpName(String eqpName) {
        this.eqpName = eqpName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public WorkOut() {
    }


}

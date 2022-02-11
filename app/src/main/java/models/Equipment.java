package models;

public  class Equipment {
    private String name;
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Equipment(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Equipment(String name) {
        this.name = name;
    }
    public Equipment(){

    }

    @Override
    public String toString() {
        return ""+name+"";
    }
}

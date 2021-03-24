package beyond.gilded.rose;

public class Character {
    private String name;
    private String gender;
    private int level;
    private String skillClass;
    private String race;

    public Character(String name, String gender, int level, String skillClass, String race) {
        this.name = name;
        this.gender = gender;
        this.level = level;
        this.skillClass = skillClass;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSkillClass() {
        return skillClass;
    }

    public void setSkillClass(String skillClass) {
        this.skillClass = skillClass;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}

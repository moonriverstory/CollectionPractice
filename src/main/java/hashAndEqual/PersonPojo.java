package hashAndEqual;

public class PersonPojo {
    private String name;
    private String sex;

    private PersonPojo() {
    }

    public PersonPojo(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        String ha = this.name + this.sex;
        return ha.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (!(obj instanceof PersonPojo)) {
            return false;
        }
        PersonPojo temp = (PersonPojo) obj;
        if (!this.name.equals(temp.getName())) {
            return false;
        }
        if (!this.sex.equals(temp.getSex())) {
            return false;
        }
        return true;
    }
}

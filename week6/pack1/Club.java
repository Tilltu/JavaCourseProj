package pack1;

public class Club {
    public String name;
    public String club;

    public Club(String name, String club) {
        this.name = name;
        this.club = club;
    }
    public Club(){}
    public void setName(String name) {
        this.name = name;
    }
    public void setClub(String club) {
        this.club = club;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() ;//+ this.club.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Club)) {
            return false;
        }
        Club club = (Club) obj;
        if(club.name.isEmpty()) {
            return false;
        }

        return (this.name.equals(club.name));//&& this.name.equals(name.club));

    }

    @Override
    public String toString() {
        return (name + " " + club);
    }
}

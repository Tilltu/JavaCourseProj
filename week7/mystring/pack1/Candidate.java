package mystring.pack1;

public class Candidate  implements Comparable<Candidate> {
    public String  name;
    public int    votes;

    @Override
    public int compareTo(Candidate o) {
        if(this.votes > o.votes) {
            return -1;
        } else if(this.votes == o.votes) {
            if(this.name.length() > o.name.length()) {
                return -1;
            } else if(this.name.length() == o.name.length()) {
                return 0;
            }else return 1;
        } else return 1;
    }

    public Candidate(){}
    public Candidate(String name, int votes) {
        this.name  = name;
        this.votes = votes;
    }
}

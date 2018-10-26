package mystring.pack1;

import java.util.ArrayList;
import java.util.Comparator;

public class CountVotes extends ArrayList<Candidate>{
    ArrayList<Candidate> candidates;

    private int findPerson(String name) {
        int i;
        int len = candidates.size();

        for (i = 0; i < len; i++) {
            if (candidates.get(i).name.equals(name)) {
                return i;
            }
        }


        return -1;
    }

    public void addVotes(ArrayList<String[]> statistics) {
        int len;
        int i, j;
        int pos;
        candidates = new ArrayList<>();

        for (i = 0; i < 10; i++) {
            for(j = 0;j < statistics.get(i).length;j++) {
                if (statistics.get(i)[j].isEmpty()) {
                    continue;
                }

                pos = findPerson(statistics.get(i)[j]);

                if (!(pos == -1)) {
                    candidates.get(pos).votes++;
                } else {
                    candidates.add(new Candidate(statistics.get(i)[j], 1));
                }

            }
        }
    }

    public void printCandidate() {
        int i;
        int len = candidates.size();
        candidates.sort(Candidate::compareTo);

        for(i = 0;i < len;i++) {
            System.out.printf("Name : %13s, Votes : %3d\n", candidates.get(i).name, candidates.get(i).votes);
        }
    }


}

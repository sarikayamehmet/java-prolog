import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Johannes Krampf <johkra@gmail.com>
 * Date: 06.02.11
 */
public class Rule {
    private Term head;
    private ArrayList<Term> goals;

    public Rule(String rule) throws ParseException {
        String[] flds = rule.split(":-");
        head = new Term(flds[0], null);
        goals = new ArrayList<Term>();

        if (flds.length == 2) {
            flds = flds[1].split(",");
            for (String fld : flds) {
                goals.add(new Term(fld, null));
            }
        }
    }

    private Rule() {

    }

    public Term getHead() {
        return head;
    }

    public List<Term> getGoals() {
        return goals;
    }

    public void setGoals(ArrayList<Term> goals) {
        this.goals = goals;
    }

    public Rule clone() {
        Rule clone = new Rule();
        clone.head = head;
        clone.goals = new ArrayList<Term>(goals);
        return clone;
    }

    @Override
    public String toString() {
        String goalsString = "";
        for(int i = 0; i < goals.size(); i++) {
            if (i != 0) {
                goalsString += ", ";
            }
            goalsString += goals.get(i);
        }
        return head + " :- " + goalsString;
    }
}

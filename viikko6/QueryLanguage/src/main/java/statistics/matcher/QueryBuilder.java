/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;

public class QueryBuilder {
    ArrayList<Matcher> matchers;
    
    public QueryBuilder() {
        this.matchers = new ArrayList();
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.matchers.add(new Or(matchers));
        return this;
    }
    
    public QueryBuilder not(Matcher matcher) {
        this.matchers.add(new Not(matcher));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matchers.add(new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matchers.add(new PlaysIn(team));
        return this;
    }
    
    public Matcher build() {
        int matchSize = this.matchers.size();
        Matcher match = new And(matchers.toArray(new Matcher[matchSize]));
        this.matchers.clear();
        return match;
    }
}
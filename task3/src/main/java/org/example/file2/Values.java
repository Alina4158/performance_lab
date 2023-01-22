package org.example.file2;

import java.util.ArrayList;

public class Values {
    private ArrayList<Value> values;

    public ArrayList<Value> getValues() {
        return values;
    }

    public void setValues(ArrayList<Value> values) {
        this.values = values;
    }

    public String findById(int id){
        return values.stream()
                .filter(it -> it.getId() == id)
                .map(Value::getValue)
                .findFirst()
                .orElse(null);
    }
}

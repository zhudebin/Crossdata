package com.stratio.meta.statements;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Statement;
import com.stratio.meta.structures.ListType;
import com.stratio.meta.structures.Path;

public class ListStatement extends MetaStatement {

    private ListType _type = null;

    public ListStatement(String type){
            _type = ListType.valueOf(type);
    }

    @Override
    public Path estimatePath() {
            return Path.CASSANDRA;
    }

    @Override
    public String toString() {
            return "LIST " + _type;
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public String getSuggestion() {
        return this.getClass().toString().toUpperCase()+" EXAMPLE";
    }

    @Override
    public String translateToCQL() {
        return this.toString();
    }

    @Override
    public String parseResult(ResultSet resultSet) {
        return "\t"+resultSet.toString();
    }
    
    @Override
    public Statement getDriverStatement() {
        Statement statement = null;
        return statement;
    }
    
}
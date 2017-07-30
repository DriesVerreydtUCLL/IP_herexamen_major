package db;

import exception.DatabaseException;

/**
 *
 * @author Dries
 */
public class DatabaseFactory {
    
    public static PlayerDatabase getDatabase(String dbType) throws DatabaseException {
        if(dbType.equalsIgnoreCase("Memory")){
            return new DatabaseInMemory();
        }
        if(dbType.equalsIgnoreCase("JPA")){
            return new DatabaseJPA();
        }
        return null;
    }
}

package org.example.designpatterns.singleton;

public class DatabaseConnection {
    //public static DatabaseConnection dbc =new DatabaseConnection(); ---> Early initialisation not good approach
    //static objects are initialised at compile time, so increase load time of application.

    public static DatabaseConnection dbc =null;
    String url;
    int portNo;
    String userName;
    String password;

    private DatabaseConnection(){

    }

    /*public static synchronized DatabaseConnection getInstance(){
        if(dbc==null){
            dbc= new DatabaseConnection();
        }
        return dbc;// DatabaseConnection();
    }*/

    public static DatabaseConnection getInstance() {
        if (dbc == null) { // Check-1
            synchronized (DatabaseConnection.class) { // lock.lock();
                if (dbc == null) { // Check-2
                    dbc = new DatabaseConnection();
                }
            }
        }
        return dbc;
    }

}

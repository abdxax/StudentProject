package com.example.abdulrahman.studentproject;

/**
 * Created by Abdulrahman on 26/10/17.
 */

public class DBModel {
    public final static String DBName="Student";
    public final static int version=1;

    public final static String DBTablestudent="stu";
    public final static String DBTableSbject="subject";
    //public final static String DBName="Student";

    public final static String colstuNmae="Name";
    public final static String colstuclo="Class";
    public final static String colstunote="Note";
    public final static String ColstuSub="SubjectNote";

    public final static String colsubjectNmae="NameSub";

    public final static String CreateStudentTabel="Create Table "+DBTablestudent+" ( ID integer PRIMARY KEY AUTOINCREMENT ,"+
            colstuNmae+" Text ,"+colstuclo+" Text ,"+colstunote+" Text ,"+ColstuSub+" Text)";

    public final static String CreateTableSubject="Create Table "+DBTableSbject+" ( ID integer PRIMARY KEY AUTOINCREMENT , "+
            colsubjectNmae+" Text )";


}

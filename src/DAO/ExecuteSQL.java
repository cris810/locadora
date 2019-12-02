/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.*;

/**
 *
 * @author crisl
 */
public class ExecuteSQL {
    
    private Conncetion con;
    
        public ExecuteSQL(Connection con){
        setCon(con);
        }
        public Conncetion getCon() {
            return con;
        }
        public void setCon(Connection con){
        this.con = (Conncetion) con;
    }

    private static class Conncetion {

        public Conncetion() {
        }
    }
    
   
}

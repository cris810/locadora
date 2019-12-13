/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Modelo.*;
import static java.awt.PageAttributes.MediaType.A;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.ImageIcon;

public class CategoriaDAO extends ExecuteSQL {
    
     public CategoriaDAO(Connection con) {
     super (con); 
    }
    
     public String Inserir_Categoria(Categoria a) {
        try{
                String sql = "insert into categoria values(0,?)";
                PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setString(1, a.getNome());
    

            if (ps.executeUpdate() > 0 ) {
            return "Inserido com sucesso.";
            }else {
            return "Erro ao inserir";
            }
           }catch(SQLException e){
            return e.getMessage();
        }

            }


     public List<Categoria> ListarCategoria(){
         String sql = "select nome from categoria order by nome";
         List<Categoria> lista = new ArrayList<>();
   try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    
    if (rs != null){
        while (rs.next()) { 
                Categoria a = new Categoria();
                a.setNome(rs.getString(1));
            
                lista.add(a);             
     }   
            return lista;
        }else{ 
            return null;
        } 
   }catch (SQLException e){
        return null;
        }
     }
     
     
     public List<Categoria> Pesquisar_Nome_Categoria(String nome){
        String sql = "select idcategoria, nome"
                +"from categoria where nome Like'"+nome+"'";
        return null;
}
     
     public List<Categoria> Pesquisar_Cod_Categoria(int cod){
        String sql = "select idcategoria, Nome "+" from categoria where idcategoria = '" + cod + "'";
        return null;
}
     
     public boolean Testar_Categoria(int cod){
         boolean Resultado = false;
     try{
         
         String sql = "select * from categoria where idcategoria = "+ cod +"";
         PreparedStatement ps = getCon().prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         
         if(rs != null){
            while (rs.next()){
                Resultado = true;
                  
            }
         }
     }catch(SQLException ex){
         ex.getMessage();
     }
   
     return Resultado;
  }
     
     public List<Categoria> CapturarCategoria(int cod){
         String sql = "select idcategoria, nome from categoria where idcategoria =" + cod +" ";
         List<Categoria> lista = new ArrayList<>();
         try{
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             if (rs != null){
                 while (rs.next()){
                     Categoria a = new Categoria();
                     a.setCodigo(rs.getInt(1));
                     a.setNome(rs.getString(2));
                   
                     lista.add(a);
                 }
                 return lista;
             }else{
                 return null;
             }  
         }catch(SQLException e){
             return null;
         }
     }
     
     
     public String Alterar_Categoria(Categoria a) {
         String sql="update categoria set nome = ? where idcategoria = ?";
         try{
             PreparedStatement ps = getCon().prepareStatement(sql);
             ps.setString(1, a.getNome());             
             ps.setInt(2, a.getCodigo());

             
             if (ps.executeUpdate() > 0) {
                 return "Atualizado com sucesso.";
                             
             } else {
                 return "Erro ao Autalizar";
             }
         }catch(SQLException e) {
             return e. getMessage();
         }
     }
     
    public List<Categoria> ListarComboCategoria(){
    
        String sql = "select nome from categoria order by nome ";
        List<Categoria> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null) {
                while (rs.next()) {
                    
                    Categoria a = new Categoria();
                    a.setNome(rs.getString(1));
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        } catch (SQLException e){
            return null;
        }
    }
   
    
    public List<Categoria> ConsultaCodigoCategoria (String nome){
        
        String sql = "select idcategoria from categoria where nome ='" + nome + "'";
        List<Categoria> lista = new ArrayList<>();
        try { 
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {

                    Categoria a = new Categoria();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            }else {
                return null;
            }
         } catch (SQLException e) {
                return null;
        }
    }
    
    public String Excluir_Categoria (Categoria a){
        String sql = "delete from categoria where idcategoria = ? and nome = ?";
        
    try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setInt(1, a.getCodigo());
        ps.setString(2, a.getNome());
        if (ps.executeUpdate()> 0 ) {
            return "Excluído com sucesso.";
        }else{
            return "Erro ao excluir";
        }
    }catch (SQLException e){
        return e.getMessage();
    }
    }
    
    
    public boolean Testar_DVD(int cod) {
        boolean teste = false;
        try {
            String sql = "Select iddvd from dvd where iddvd = " + cod + "";
            PreparedStatement ps = getCon(). prepareStatement (sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    teste = true;
                }
            }
        } catch (SQLException ex) {
    }
        return teste;
    }

    
    public boolean Testar_Situacao(int cod){
        boolean teste = false;
        try {
            
            String sql = "select iddvd from dvd where iddvd =" +cod+ "" 
                    + "and situacao = 'Disponível'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    teste = true;
                }
            }
        }catch(SQLException ex) {
        }
        return teste;
        }
 
       
    public List<DVD> ListarCodFilme (int cod) {
        String sql = "select idfilme from dvd where iddvd = " + cod + "";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()){
                    DVD a = new DVD();
                    a.setCod_filme(rs.getInt(1));
                    
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        }catch (SQLException e) {
            return null;
        }
    }
    
    public List<Filme> Pesquisar_Cod_Filme(int cod) { 
    String sql = "select idfilme,titulo,ano,duracao,idcategoria,idclassificacao,"
            +"capa from filme where idfilme = '" + cod + "'";
    List<Filme> lista = new ArrayList<>();
    try{
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if (rs != null){
            while (rs.next()) {
                Filme a = new Filme();
                a.setCodigo(rs.getInt(1));
                a.setTitulo(rs.getString(2));
                a.setAno(rs.getInt(3));
                a.setDuracao(rs.getString(4));
                a.setCod_categoria(rs.getInt(5));
                a.setCod_classificacao(rs.getInt(6));
                lista.add(a);
            }
            return lista;
        }else {
            return null;
        }
    }catch(SQLException e) {
            return null;
        }
    }

    public List<Cliente> ListarComboCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}

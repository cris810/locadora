/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author crisl
 */
public class FilmeDAO extends ExecuteSQL{
    
    public FilmeDAO(Connection con) {
        super(con);
    }
    
    
     public String Inserir_Filme(Filme a) {
        try{
                String sql = "insert into filme values(0,?,?,?,?,?,?)";
                PreparedStatement ps = getCon().prepareStatement(sql);

          
            ps.setString(1, a.getTitulo());
            ps.setInt(2, a.getAno());
            ps.setString(3, a.getDuracao());
            ps.setInt(4, a.getCod_categoria());
            ps.setInt(5, a.getCod_classificacao());
            ps.setString(6, a.getCapa());
            
            
    
            if (ps.executeUpdate() > 0 ) {
            return "Inserido com sucesso.";
            }else {
            return "Erro ao inserir";
            }
           }catch(SQLException e){
            return e.getMessage();
        }

            }


     public List<Filme> ListarFilme(){
         String sql = "select idfilme,titulo,ano,duracao,idcategoria,idclassificacao from filme";
         List<Filme> lista = new ArrayList<>();
   try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    
    if (rs != null){
        while (rs.next()) { 
                Filme a = new Filme();
                a.setCodigo(rs.getInt(1));
                a.setTitulo(rs.getString(2));
                a.setAno(rs.getInt(3));
                a.setCategoria(rs.getInt(4));
                a.setClassificacao(rs.getInt(5));
                a.setCapa(rs.getString(6));
                a.setDuracao(rs.getString(7));
                
                
            
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
     
     
     public List<Filme> Pesquisar_Nome_Filme(String nome){
        String sql = "select idfilme, nome"
                +"from filme where nome Like'"+nome+"'";
        return null;
}
     
     public List<Filme> Pesquisar_Cod_Filme(int cod){
        String sql = "select idfilme, titulo "+" from Filme where idfilme = '" + cod + "'";
        return null;
}
     
     public boolean Testar_Filme(int cod){
         boolean Resultado = false;
     try{
         
         String sql = "select * from filme where idfilme = "+ cod +"";
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
     
     public List<Filme> CapturarFilme(int cod){
         String sql = "select idfilme, titulo from filme where idfilme =" + cod +" ";
         List<Filme> lista = new ArrayList<>();
         try{
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             if (rs != null){
                 while (rs.next()){
                     Filme a = new Filme();
                                   a.setCodigo(rs.getInt(1));
                                   a.setTitulo(rs.getString(2));
                                   a.setAno(rs.getInt(3));
                                    a.setDuracao(rs.getString(4));
                                   a.setCategoria(rs.getInt(5));
                                   a.setClassificacao(rs.getInt(6));
                                   a.setCapa(rs.getString(7));
                                  

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
     
     
     public String Alterar_Filme(Filme a) {
         String sql="update filme set titulo = ? where idfilme = ?";
         try{
             PreparedStatement ps = getCon().prepareStatement(sql);
             ps.setInt(1, a.getCodigo());
             ps.setString(2, a.getTitulo());             
             ps.setInt(3, a.getAno());
             ps.setString(4, a.getDuracao());
             ps.setInt(5, a.getCategoria());
             ps.setInt(6, a.getClassificacao());
             ps.setString(7, a.getCapa());
             

             
             if (ps.executeUpdate() > 0) {
                 return "Atualizado com sucesso.";
                             
             } else {
                 return "Erro ao Autalizar";
             }
         }catch(SQLException e) {
             return e. getMessage();
         }
     }
     
    public List<Filme> ListarComboFilme(){
    
        String sql = "select titulo from filme order by titulo ";
        List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null) {
                while (rs.next()) {
                    
                    Filme a = new Filme();
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
   
    
    public List<Filme> ConsultaCodigoFilme (String nome){
        
        String sql = "select idfilme from filme where titulo ='" + nome + "'";
        List<Filme> lista = new ArrayList<>();
        try { 
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {

                    Filme a = new Filme();
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
    
    public String Excluir_Filme (Filme a){
        String sql = "delete from filme where idfilme = ? and titulo = ?";
        
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
 
       
    public List<DVD> ListarFilme (int cod) {
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

    public List <Filme> Pesquisar_Nome_Filme(int cod) { 
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

}
    


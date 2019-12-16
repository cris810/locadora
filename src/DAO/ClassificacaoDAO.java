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
public class ClassificacaoDAO extends ExecuteSQL{
    
     public ClassificacaoDAO(Connection con) {
     super(con);   
    }
    
     public String Inserir_Classificacao(Classificacao a) {
        String sql = "insert into classificacao values(0,?,?)";
        try{
    PreparedStatement ps = getCon().prepareStatement(sql);

    ps.setString(1, a.getNome());
    ps.setDouble(2, a.getPreco());
    

            if (ps.executeUpdate() > 0 ) {
            return "Inserido com sucesso.";
            }else {
            return "Erro ao inserir";
            }
           }catch(SQLException e){
            return e.getMessage();
        }

            }
     


     public List<Classificacao> ListarClassificacao(){
         String sql = "select idcliente, nome,rg,cpf,telefone,email from cliente";
         List<Classificacao> lista = new ArrayList<>();
   try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    
    if (rs != null){
        while (rs.next()) { 
                Classificacao a = new Classificacao();
                a.setPreco(rs.getDouble(1));
                a.setNome(rs.getString(2));
              

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
     
     
     public List<Classificacao> Pesquisar_Nome_Classificacao(String nome){
        String sql = "select idcliente, nome, RG, CPF, Telefone, Email"
                +"from cliente where nome Like'"+nome+"'";
        return null;
}
     
     public List<Classificacao> Pesquisar_Cod_Classificacao(int cod){
        String sql = "select idcliente, Nome, RG, CPF, Telefone, Email"
                +"from Cliente where idcliente = '" + cod + "'";
        return null;
}
     
     public boolean Testar_Classificacao(int cod){
         boolean Resultado = false;
     try{
         
         String sql = "select * from classificacao where idclassificacao = "+ cod +"";
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
     
     public List<Classificacao> CapturarClassificacao(int cod){
         String sql = "select * from classificacao where idclassificacao =" + cod +" ";
         List<Classificacao> lista = new ArrayList<>();
         try{
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             if (rs != null){
                 while (rs.next()){
                     Classificacao a = new Classificacao();
                     a.setCodigo (rs.getInt(1));
                     a.setNome(rs.getString(2));
                     a.setPreco(rs.getDouble(3));
                     
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
     
     
   public String Alterar_Classificacao(Classificacao a) {
         String sql="update classificacao set nome = ? , preco = ? where idclassificacao = ? ";
         try{
             PreparedStatement ps = getCon().prepareStatement(sql);
              ps.setString(1, a.getNome());
              ps.setDouble(2,  a.getPreco());
              ps.setInt(3, a.getCodigo());
             
             
             if (ps.executeUpdate() > 0) {
                 return "Atualizado com sucesso.";
                             
             } else {
                 return "Erro ao Autalizar";
             }
         }catch(SQLException e) {
             return e. getMessage();
         }
     }
     
     
     
    public List<Classificacao> ListarComboClassificacao(){
    
        String sql = "select nome from classificacao order by nome ";
        List<Classificacao> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null) {
                while (rs.next()) {
                    
                    Classificacao a = new Classificacao();
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
   
    
    public List<Classificacao> ConsultaCodigoClassificacao (String nome){
        
        String sql = "select idclassificacao from classificacao where nome ='" + nome + "'";
        List<Classificacao> lista = new ArrayList<>();
        try { 
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {

                    Classificacao a = new Classificacao();
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
    
    public String Excluir_Classificacao (Classificacao a){
        String sql = "delete from classificacao where idclassificacao = ? and nome = ? ";
        
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
    
}

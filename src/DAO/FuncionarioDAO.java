
package DAO;

import Modelo.*;
import java.sql.*;
import static java.awt.PageAttributes.MediaType.A;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.ImageIcon;

public class FuncionarioDAO extends  ExecuteSQL{

    public FuncionarioDAO(Connection con) {
        super(con);
    }
       
     public String Inserir_Funcionario(Funcionario a) {
        String sql = "insert into funcionario values(0,?,?,?)";
        try{
    PreparedStatement ps = getCon().prepareStatement(sql);

    ps.setString(1, a.getNome());
    ps.setString(2, a.getLogin());
    ps.setString(3, a.getSenha());
    

            if (ps.executeUpdate() > 0 ) {
            return "Inserido com sucesso.";
            }else {
            return "Erro ao inserir";
            }
           }catch(SQLException e){
            return e.getMessage();
        }

            }
     


     public List<Funcionario> ListarFuncionario(){
         String sql = "select idfuncionario, nome,login,senha from funcionario";
         List<Funcionario> lista = new ArrayList<>();
   try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    
    if (rs != null){
        while (rs.next()) { 
                Funcionario a = new Funcionario();
                a.setNome(rs.getString(1));
                a.setLogin(rs.getString(2));
                a.setSenha(rs.getString(3));
                

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
     
     
     public List<Funcionario> Pesquisar_Nome_Funcionario(String nome){
        String sql = "select idfuncionario, Nome, Login,Senha "
                +"from funcionario where nome like '"+ nome +"%'";
     List<Funcionario> lista = new ArrayList<>();
   try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    
    if (rs != null){
        while (rs.next()) { 
                Funcionario a = new Funcionario();
                a.setNome(rs.getString(1));
                a.setLogin(rs.getString(2));
                a.setSenha(rs.getString(3));
                

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
     
     public List<Funcionario> Pesquisar_Cod_Funcionario(int cod){
        String sql = "select idfuncionario, Nome, Login,Senha "
                +"from funcionario where idfuncionario = '" + cod + "'";
       List<Funcionario> lista = new ArrayList<>();
   try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    
    if (rs != null){
        while (rs.next()) { 
                Funcionario a = new Funcionario();
                a.setNome(rs.getString(1));
                a.setLogin(rs.getString(2));
                a.setSenha(rs.getString(3));
               
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
     
     public boolean Testar_Funcionario(int cod){
         boolean Resultado = false;
     try{
         
         String sql = "select * from funcionario where idfuncionario = "+ cod +"";
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
     
     public List<Funcionario> CapturarFuncionario(int cod){
         String sql = "select * from funcionario where idfuncionario =" + cod +" ";
         List<Funcionario> lista = new ArrayList<>();
         try{
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             if (rs != null){
                 while (rs.next()){
                     Funcionario a = new Funcionario();
                     a.setCodigo(rs.getInt(1));
                     a.setNome(rs.getString(2));
                     a.setLogin(rs.getString(3));
                     a.setSenha(rs.getString(4));
                   
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
     
     
     public String Alterar_Funcionario(Funcionario a) {
         String sql="update funcionario set nome = ? , login = ? ,senha = ? where idfuncionario = ? ";
         try{
             PreparedStatement ps = getCon().prepareStatement(sql);
             ps.setString(1, a.getNome());
             ps.setString(2, a.getLogin());
             ps.setString(3, a.getSenha());
             ps.setInt(4, a.getCodigo());
             if (ps.executeUpdate() > 0) {
                 return "Atualizado com sucesso.";
                             
             } else {
                 return "Erro ao Autalizar";
             }
         }catch(SQLException e) {
             return e. getMessage();
         }
     }
     
    public List<Funcionario> ListarComboFuncionario(){
    
        String sql = "select nome from funcionario order by nome ";
        List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null) {
                while (rs.next()) {
                    
                    Funcionario a = new Funcionario();
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
   
    
    public List<Funcionario> ConsultaCodigoFuncionario (String nome){
        
        String sql = "select idfuncionario from funcionario where nome ='" + nome + "'";
        List<Funcionario> lista = new ArrayList<>();
        try { 
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {

                    Funcionario a = new Funcionario();
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
    
    public String Excluir_Funcionario (Funcionario a){
        String sql = "delete from funcionario where idfuncionario = ? and nome = ? , login =? , senha = ?";
        
    try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, a.getNome());
        ps.setString(2, a.getLogin());
        ps.setString(3, a.getSenha());
        
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

    public boolean Logar(String login, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   }

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


public class ClienteDAO extends ExecuteSQL{
    
     public ClienteDAO(Connection con) {
     super(con);   
    }
    
     public String Inserir_Cliente(Cliente a) {
        String sql = "insert into cliente values(0,?,?,?,?,?,?,?,?,?,?)";
        try{
    PreparedStatement ps = getCon().prepareStatement(sql);

    ps.setString(1, a.getNome());
    ps.setString(2, a.getNascimento());
    ps.setString(3, a.getRG());
    ps.setString(4, a.getCPF());
    ps.setString(5, a.getEmail());
    ps.setString(6, a.getTelefone());
    ps.setString(7, a.getBairro());
    ps.setString(8, a.getRua());
    ps.setInt(9, a.getNumero());
    ps.setString(10, a.getCEP());

            if (ps.executeUpdate() > 0 ) {
            return "Inserido com sucesso.";
            }else {
            return "Erro ao inserir";
            }
           }catch(SQLException e){
            return e.getMessage();
        }

            }
     


     public List<Cliente> ListarCliente(){
         String sql = "select idcliente, nome,rg,cpf,telefone,email from cliente";
         List<Cliente> lista = new ArrayList<>();
   try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    
    if (rs != null){
        while (rs.next()) { 
                Cliente a = new Cliente();
                a.setCodigo(rs.getInt(1));
                a.setNome(rs.getString(2));
                a.setRG(rs.getString(3));
                a.setCPF(rs.getString(4));
                a.setTelefone(rs.getString(5));
                a.setEmail(rs.getString(6));

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
     
     
     public List<Cliente> Pesquisar_Nome_Cliente(String nome){
        String sql = "select idcliente, nome, RG, CPF, Telefone, Email"
                +"from cliente where nome Like'"+nome+"'";
        return null;
}
     
     public List<Cliente> Pesquisar_Cod_Cliente(int cod){
        String sql = "select idcliente, Nome, RG, CPF, Telefone, Email"
                +"from Cliente where idcliente = '" + cod + "'";
        return null;
}
     
     public boolean Testar_Cliente(int cod){
         boolean Resulltado = false;
     try{
         
         String sql = "select * from cliente where idcliente = "+ cod +"";
         PreparedStatement ps = getCon().prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         
         if(rs != null){
            while (rs.next()){
                boolean Resultado = true;
                  
            }
         }
     }catch(SQLException ex){
         ex.getMessage();
     }
         boolean Resultado = false;
     return Resultado;
  }
     
     public List<Cliente> CapturarCliente(int cod){
         String sql = " from cliente where idcliente =" + cod +" ";
         List<Cliente> lista = new ArrayList<>();
         try{
             PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             if (rs != null){
                 while (rs.next()){
                     Cliente a = new Cliente();
                     a.setCodigo(rs.getInt(1));
                     a.setNome(rs.getString(2));
                     a.setNascimento(rs.getString(3));
                     a.setRG(rs.getString(4));
                     a.setCPF(rs.getString(5));
                     a.setEmail(rs.getString(6));
                     a.setTelefone(rs.getString(7));
                     a.setBairro(rs.getString(8));
                     a.setRua(rs.getString(9));
                     a.setNumero(rs.getInt(10));
                     a.setCEP(rs.getString(11));
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
     
     
     public String Alterar_Cliente(Cliente a) {
         String sql="update cliente set nome = ? , data_nasc = ?, rg = ?"
                 + ",cpf = ?, email = ?, telefone = ?, bairro = ?, rua = ?"
                 +"numero = ?, cep = ?, where idcliente = ?";
         try{
             PreparedStatement ps = getCon().prepareStatement(sql);
             ps.setString(1, a.getNome());
             ps.setString(2, a.getNascimento());
             ps.setString(3, a.getRG());
             ps.setString(4, a.getCPF());
             ps.setString(5, a.getEmail());
             ps.setString(6, a.getTelefone());
             ps.setString(7, a.getBairro());
             ps.setString(8, a.getRua());
             ps.setInt(9, a.getNumero());
             ps.setString(10, a.getCEP());
             ps.setInt(11, a.getCodigo());
             if (ps.executeUpdate() > 0) {
                 return "Atualizado com sucesso.";
                             
             } else {
                 return "Erro ao Autalizar";
             }
         }catch(SQLException e) {
             return e. getMessage();
         }
     }
     
    public List<Cliente> ListarComboCliente(){
    
        String sql = "select nome from cliente order by nome ";
        List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null) {
                while (rs.next()) {
                    
                    Cliente a = new Cliente();
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
   
    
    public List<Cliente> ConsultaCodigoCliente (String nome){
        
        String sql = "select idcliente from cliente where nome ='" + nome + "'";
        List<Cliente> lista = new ArrayList<>();
        try { 
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {

                    Cliente a = new Cliente();
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
    
    public String Excluir_Cliente (Cliente a){
        String sql = "delete from cliente where idcliente = ? and nome = ?";
        
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

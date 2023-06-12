/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import util.FabricaConexao;

/**
 *
 * @author lucas
 */
public class ClienteDAO {
    
    public void inserir(Cliente c) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.criarConexao();
        PreparedStatement cmd = con.prepareStatement("insert into clientes (idade, nome, logradouro, cidade, estado, cpf, telefone, email, dataNascimento) values "
                                                    + "(?,?,?,?,?,?,?,?,?)");
        cmd.setInt(1, c.getIdade());
        cmd.setString(2, c.getNome());
        cmd.setString(3, c.getLogradouro());
        cmd.setString(4, c.getCidade());
        cmd.setString(5, c.getEstado());
        cmd.setString(6, c.getCpf());
        cmd.setString(7, c.getTelefone());
        cmd.setString(8, c.getEmail());
        cmd.setString(9, c.getDataNascimento());
        cmd.execute();
    }
    
    public void deletar(Cliente c) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.criarConexao();
        PreparedStatement cmd = con.prepareStatement("delete from clientes where id = ?");
        cmd.setInt(1, c.getId());
        cmd.execute();
    }
    
    public void atualizar(Cliente c) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.criarConexao();
        PreparedStatement cmd = con.prepareStatement("update clientes set idade=?, nome=?, logradouro=?, cidade=?, estado=?, cpf=?, telefone=?, email=?, dataNascimento=? where id = ?");
        cmd.setInt(1, c.getIdade());
        cmd.setString(2, c.getNome());
        cmd.setString(3, c.getLogradouro());
        cmd.setString(4, c.getCidade());
        cmd.setString(5, c.getEstado());
        cmd.setString(6, c.getCpf());
        cmd.setString(7, c.getTelefone());
        cmd.setString(8, c.getEmail());
        cmd.setString(9, c.getDataNascimento());
        cmd.setInt(10, c.getId());
        cmd.execute();
    }
    
    public Cliente buscarPorId(Cliente c) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.criarConexao();
        PreparedStatement cmd = con.prepareStatement("select * from clientes where id=?");
        cmd.setInt(1, c.getId());
        
        ResultSet rs = cmd.executeQuery();
        Cliente cli = new Cliente();
        if(rs.next()) {
            cli.setId(rs.getInt("id"));
            cli.setIdade(rs.getInt("idade"));
            cli.setNome(rs.getString("nome"));
            cli.setLogradouro(rs.getString("logradouro"));
            cli.setCidade(rs.getString("cidade"));
            cli.setEstado(rs.getString("estado"));
            cli.setCpf(rs.getString("cpf"));
            cli.setTelefone(rs.getString("telefone"));
            cli.setEmail(rs.getString("email"));
            cli.setDataNascimento(rs.getString("dataNascimento"));
        }
        return cli;
    }
    
    public List<Cliente> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.criarConexao();
        PreparedStatement cmd = con.prepareStatement("select * from clientes");
        
        ResultSet rs = cmd.executeQuery();
        List<Cliente> lprod = new ArrayList<>();
        
        while(rs.next()) {
            Cliente cli = new Cliente();
            cli.setId(rs.getInt("id"));
            cli.setIdade(rs.getInt("idade"));
            cli.setNome(rs.getString("nome"));
            cli.setLogradouro(rs.getString("logradouro"));
            cli.setCidade(rs.getString("cidade"));
            cli.setEstado(rs.getString("estado"));
            cli.setCpf(rs.getString("cpf"));
            cli.setTelefone(rs.getString("telefone"));
            cli.setEmail(rs.getString("email"));
            cli.setDataNascimento(rs.getString("dataNascimento"));
            lprod.add(cli);
        }
        return lprod;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author crisl
 */
public class Filme {
    private int codigo;
    private String titulo;
    private int ano;
    private String capa;
    private int classificacao;
    private int categoria;
    private String duracao;
    private String nome;

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

        
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    private int cod_categoria;
    private int cod_classificacao;
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public int getCod_classificacao() {
        return cod_classificacao;
    }

    public void setCod_classificacao(int cod_classificacao) {
        this.cod_classificacao = cod_classificacao;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

}

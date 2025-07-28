package org.ars.sqlite_dll.models;

public class ColunaDTO {
    private String nome;
    private String tipo;
    private Integer tamanho;
    private boolean nullable;
    private boolean pk;
    private String alias;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Integer getTamanho() { return tamanho; }
    public void setTamanho(Integer tamanho) { this.tamanho = tamanho; }

    public boolean isNullable() { return nullable; }
    public void setNullable(boolean nullable) { this.nullable = nullable; }

    public boolean isPk() { return pk; }
    public void setPk(boolean pk) { this.pk = pk; }

    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
}

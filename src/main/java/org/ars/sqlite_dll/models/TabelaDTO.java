package org.ars.sqlite_dll.models;

import java.util.List;

public class TabelaDTO {
    private String nomeTabela;
    private List<ColunaDTO> colunas;

    public String getNomeTabela() { return nomeTabela; }
    public void setNomeTabela(String nomeTabela) { this.nomeTabela = nomeTabela; }

    public List<ColunaDTO> getColunas() { return colunas; }
    public void setColunas(List<ColunaDTO> colunas) { this.colunas = colunas; }
}

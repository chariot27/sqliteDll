package org.ars.sqlite_dll.services;

import org.ars.sqlite_dll.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DDLService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void criarTabelaComMetadados(TabelaDTO tabela) {
        String ddl = gerarDDL(tabela);
        jdbcTemplate.execute(ddl);
        salvarMetadados(tabela);
    }

    private String gerarDDL(TabelaDTO tabela) {
        StringBuilder ddl = new StringBuilder("CREATE TABLE ");
        ddl.append(tabela.getNomeTabela()).append(" (\n");

        List<String> pks = new ArrayList<>();
        for (ColunaDTO col : tabela.getColunas()) {
            ddl.append("  ").append(col.getNome()).append(" ").append(col.getTipo());

            if ("VARCHAR".equalsIgnoreCase(col.getTipo()) && col.getTamanho() != null) {
                ddl.append("(").append(col.getTamanho()).append(")");
            }

            if (!col.isNullable()) ddl.append(" NOT NULL");
            ddl.append(",\n");

            if (col.isPk()) pks.add(col.getNome());
        }

        if (!pks.isEmpty()) {
            ddl.append("  PRIMARY KEY (").append(String.join(", ", pks)).append(")\n");
        } else {
            ddl.setLength(ddl.length() - 2); // remove última vírgula
            ddl.append("\n");
        }

        ddl.append(");");
        return ddl.toString();
    }

    private void salvarMetadados(TabelaDTO tabela) {
        String sql = "INSERT INTO metadados_coluna (tabela, coluna, alias) VALUES (?, ?, ?)";
        for (ColunaDTO col : tabela.getColunas()) {
            if (col.getAlias() != null && !col.getAlias().isBlank()) {
                jdbcTemplate.update(sql, tabela.getNomeTabela(), col.getNome(), col.getAlias());
            }
        }
    }
}

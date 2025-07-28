package org.ars.sqlite_dll.controllers;

import org.ars.sqlite_dll.models.TabelaDTO;
import org.ars.sqlite_dll.services.DDLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tabelas")
@CrossOrigin(origins = "http://localhost:3000")
public class DDLController {

    @Autowired
    private DDLService ddlService;

    @PostMapping
    public String criarTabela(@RequestBody TabelaDTO tabela) {
        ddlService.criarTabelaComMetadados(tabela);
        return "Tabela '" + tabela.getNomeTabela() + "' criada com sucesso.";
    }
}
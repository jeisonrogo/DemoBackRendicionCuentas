package com.demo.accion.demorendicioncuentas.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Información principal del cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGeneric {

    String RendicionesGeneradasTxt;
}

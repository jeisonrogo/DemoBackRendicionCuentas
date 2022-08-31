package com.demo.accion.demorendicioncuentas.services.interfaces;

import java.io.ByteArrayInputStream;

public interface RendicionTemplateInterfaces {
    byte[] generateProvisionalRendicion();

    byte[] geenerarPDFrendicion();
}

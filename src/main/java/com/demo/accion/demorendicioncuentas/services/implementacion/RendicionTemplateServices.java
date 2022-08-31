package com.demo.accion.demorendicioncuentas.services.implementacion;

import com.demo.accion.demorendicioncuentas.entities.AdmResultadosRendicionEntity;
import com.demo.accion.demorendicioncuentas.entities.AdmTemplatesRendicionCuenEntity;
import com.demo.accion.demorendicioncuentas.repository.AdmResultadosRendicionRepo;
import com.demo.accion.demorendicioncuentas.repository.AdmTemplatesRendicionCuenRepo;
import com.demo.accion.demorendicioncuentas.services.interfaces.RendicionTemplateInterfaces;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.tool.xml.XMLWorkerHelper;


@Service
public class RendicionTemplateServices implements RendicionTemplateInterfaces {

    final AdmTemplatesRendicionCuenRepo admTemplatesRendicionCuenRepo;
    final AdmResultadosRendicionRepo admResultadosRendicionRepo;

    public RendicionTemplateServices(AdmTemplatesRendicionCuenRepo admTemplatesRendicionCuenRepo, AdmResultadosRendicionRepo admResultadosRendicionRepo) {
        this.admTemplatesRendicionCuenRepo = admTemplatesRendicionCuenRepo;
        this.admResultadosRendicionRepo = admResultadosRendicionRepo;
    }


    @Override
    public byte[] generateProvisionalRendicion(){

        String plantilla = this.replaceTagsPlantillasHtml(1L);
        AdmResultadosRendicionEntity admResultadosRendicionEntity =  guardarPlantillaGenerada(plantilla);

        try {
            CSVPrinter csvPrinter = null;
            try {
                csvPrinter = new CSVPrinter(new FileWriter("answers.csv"), CSVFormat.EXCEL.withHeader("nombre Archivo", "Id edicion"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Object[] responseData = new String[15];
            int count = 0;
            //for (Object data : responseData) {
                csvPrinter.printRecord(Arrays.asList(admResultadosRendicionEntity.getNombreArchivo(), admResultadosRendicionEntity.getIdRendicion()));
           // }
            csvPrinter.flush();

            File downloadFile = new File("answers.csv");
            InputStream in = new FileInputStream(downloadFile);
            downloadFile.delete();
            return IOUtils.toByteArray(in);

        } catch (IOException ex) {
            return null;
        }

     //   return new ResponseGeneric();
    }


    private String replaceTagsPlantillasHtml(Long id_template){
        AdmTemplatesRendicionCuenEntity admTemplatesRendicionCuenEntity = admTemplatesRendicionCuenRepo.findById(id_template).orElse(null);
        String rendicionNueva = admTemplatesRendicionCuenEntity.getPlantilla();
        rendicionNueva = rendicionNueva.replace("[TERCERO_NOMBRE_TXT]", "JEISON RODRIGUEZ")
        .replace("[TERCERO_DIRECCION_TXT]", "CALLE FALSA 123")
        .replace("[NOMBRE_NEGOCIO_TXT]","19908-Fa-989_FIDEICOMISO_BACATA_AREAS_COMERCIALES")
        .replace("[FECHA_INICIO_TXT]","01 Diciembre 2022")
        .replace("[FECHA_FIN_TXT]", "01 Diciembre 2023");

        return  rendicionNueva;
    }

    private AdmResultadosRendicionEntity guardarPlantillaGenerada(String plantilla){
        AdmResultadosRendicionEntity admResultadosRendicionEntity = new AdmResultadosRendicionEntity("19908-Fa-989_FIDEICOMISO_BACATA_AREAS_COMERCIALES_BA_0001200102966_900396542",
                "19908",
                1L,
                plantilla,
                "jj",
                new Timestamp( new Date().getTime()));

        return  admResultadosRendicionEntity = admResultadosRendicionRepo.save(admResultadosRendicionEntity);
    }

    @Override
    public byte[]  geenerarPDFrendicion() {
        AdmResultadosRendicionEntity admResultadosRendicionEntity = admResultadosRendicionRepo.findById(2L).orElse(null);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        ITextRenderer renderer = new ITextRenderer();
//        renderer.setDocumentFromString(AdmResultadosRendicionEntity.getPlantillaResultado());
//        renderer.layout();
//        renderer.createPDF(outputStream, false);
//        renderer.finishPDF();
//        byte[] inputStream = outputStream.toByteArray();
//        return inputStream;

        try (OutputStream os = new FileOutputStream("D:/demo2.pdf")) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(admResultadosRendicionEntity.getPlantillaResultado(), "/home");
            builder.toStream(os);
            builder.run();
            InputStream oss = new FileInputStream("D:/demo2.pdf");
            byte[] inputStream = IOUtils.toByteArray(oss);
            return inputStream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

//        InputStream intputStream = null;
//        try {
//            intputStream = new ByteArrayInputStream(AdmResultadosRendicionEntity.getPlantillaResultado().getBytes());
//            OutputStream outputStream = new FileOutputStream("D:/demo.pdf");
//            Document document = new Document();
//            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
//
//            document.open();
//
//            XMLWorkerHelper.getInstance().parseXHtml(writer,
//                    document,
//                    intputStream,
//                    Charset.forName("UTF-8"));
//            document.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;

    }


}

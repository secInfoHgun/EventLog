package com.hgun.sti.components;

import com.hgun.sti.models.*;
import com.hgun.sti.repository.types.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExportPDF {

    @Autowired
    private TipoOcorrenciaRepository tipoOcorrenciaRepository;

    @Autowired
    private TipoIncidenciaRepository tipoIncidenciaRepository;

    @Autowired
    private TipoDanoRepository tipoDanoRepository;

    @Autowired
    private TipoFaseAssistenciaRepository tipoFaseAssistenciaRepository;

    @Autowired
    private TipoSetorRepository tipoSetorRepository;

    @Autowired
    private TipoLesaoRepository tipoLesaoRepository;

    private Ocorrencia ocorrencia;
    private Analise analise;
    private Providencia providencia;
    private Obito obito;

    public ExportPDF(
            Ocorrencia ocorrencia,
            Analise analise,
            Providencia providencia,
            Obito obito
    ) {
        this.ocorrencia = ocorrencia;
        this.analise = analise;
        this.providencia = providencia;
        this.obito = obito;
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        var font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);

        var p = new Paragraph("Hospital de Guarnição de Natal\n\n", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);


        font.setSize(11);
        p = new Paragraph("Notficação de Incidente / Notficação de Evento Adverso                                         Nº da notficação: " + ( this.ocorrencia.id < 10 ? ("0" + this.ocorrencia.id) : this.ocorrencia.id.toString()) , font);
        p.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(p);

        font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setSize(10);
        p = new Paragraph("Data / Hora do Evento: " + this.ocorrencia.data + " / " + this.ocorrencia.hora , font);
        p.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(p);


        font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(10);
        p = new Paragraph("\nDados do paciente:", font);
        document.add(p);

        font = FontFactory.getFont(FontFactory.HELVETICA);
        p = new Paragraph("Nome: " + this.ocorrencia.paciente.nome , font);
        font.setSize(10);
        document.add(p);

        p = new Paragraph(
                "Sexo: " + (this.ocorrencia.paciente.sexo.equals("M") ? "(X) Masculino ( ) Feminino" : "( ) Masculino (X) Feminino") +
                "                               " + "Idade: " + this.ocorrencia.paciente.idade + " anos" +
                "                               " + "Nº do PRECCP: " + this.ocorrencia.paciente.preccp, font);
        document.add(p);


        document.close();
    }
}

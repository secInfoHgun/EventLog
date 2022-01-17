package com.hgun.sti.components;

import com.hgun.sti.models.*;
import com.hgun.sti.repository.types.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExportPDF {

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

    public Document headerDocument(Document document){
        var font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        var p = new Paragraph("Hospital de Guarnição de Natal\n\n", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);

        font.setSize(11);
        p = new Paragraph("Notificação  de Incidente / Notificação  de Evento Adverso                                  Nº da notificação : " + ( this.ocorrencia.id < 10 ? ("0" + this.ocorrencia.id) : this.ocorrencia.id.toString()) , font);
        p.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(p);

        font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setSize(10);
        p = new Paragraph("Data / Hora do Evento: " + this.ocorrencia.data + " - " + this.ocorrencia.hora , font);
        p.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(p);

        return document;
    }

    public Document dadosDoPaciente(Document document){
        var font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(10);
        var p = new Paragraph("\n\nDados do paciente:", font);
        document.add(p);

        font = FontFactory.getFont(FontFactory.HELVETICA);
        p = new Paragraph("Nome: " + this.ocorrencia.paciente.nome , font);
        font.setSize(10);
        document.add(p);

        p = new Paragraph(
                "Sexo: " + (this.ocorrencia.paciente.sexo == 'M' ? "(X) Masculino ( ) Feminino" : "( ) Masculino (X) Feminino") +
                        "                               " + "Idade: " + this.ocorrencia.paciente.idade + " anos" +
                        "                               " + "Nº do PRECCP: " + (this.ocorrencia.paciente.preccp == null ? "-" : this.ocorrencia.paciente.preccp), font);
        document.add(p);

        return document;
    }

    public Document dadosOcorrencia(Document document){
        var font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(10);
        var p = new Paragraph("\n\nDados da ocorrência:", font);
        document.add(p);

        font = FontFactory.getFont(FontFactory.HELVETICA);
        p = new Paragraph(
                "1. Tipo da ocorrência:\n" +
                       this.ocorrencia.tipoOcorrencia.nome +
                       (!this.ocorrencia.tipoOcorrencia.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoOcorrencia.descricao)+")" : ""), font);
        font.setSize(10);
        document.add(p);

        p = new Paragraph(
                "\n2. Tipo da incidência (com / sem dano):\n" +
                        this.ocorrencia.tipoIncidencia.nome +
                        (!this.ocorrencia.tipoIncidencia.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoIncidencia.descricao)+")" : ""), font);
        document.add(p);

        p = new Paragraph(
                "\n3. Características do dano (grau do dano):\n" +
                        this.ocorrencia.tipoDano.nome +
                        (!this.ocorrencia.tipoDano.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoDano.descricao)+")" : ""), font);
        document.add(p);

        p = new Paragraph(
                "\n4. Setor onde o evento ocorreu:\n" +
                        this.ocorrencia.tipoSetor.nome +
                        (!this.ocorrencia.tipoSetor.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoSetor.descricao)+")" : ""), font);
        document.add(p);

        p = new Paragraph(
                "\n5. Em que fase da assistência o evento ocorreu:\n" +
                        this.ocorrencia.tipoFaseAssistencia.nome +
                        (!this.ocorrencia.tipoFaseAssistencia.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoFaseAssistencia.descricao)+")" : ""), font);
        document.add(p);

        p = new Paragraph("\n6. Resumo do evento:\n" + this.ocorrencia.resumo, font);
        document.add(p);

        p = new Paragraph("\n7. Descrição do evento:\n" + this.ocorrencia.descricao, font);
        document.add(p);

        p = new Paragraph("\n8. Fator contribuinte para a ocorrência do evento:\n" + (this.ocorrencia.fatorContribuinte == null ? "-" : this.ocorrencia.fatorContribuinte), font);
        document.add(p);

        p = new Paragraph("\n9. O paciente foi internado:\n\t" + (this.ocorrencia.pacienteFoiInternado ? "(X) Sim ( ) Não" : "( ) Sim (X) Não"), font);
        document.add(p);

        p = new Paragraph("\n10. O paciente foi a óbito:\n\t" + (this.ocorrencia.pacienteFaleceu ? "(X) Sim ( ) Não" : "( ) Sim (X) Não"), font);
        document.add(p);

        return document;
    }

    public Document dadosAnalise(Document document){
        if(this.analise != null){
            var font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setSize(10);
            var p = new Paragraph("\n\nDados da análise:", font);
            document.add(p);

            font = FontFactory.getFont(FontFactory.HELVETICA);
            p = new Paragraph("1. Data / Hora que foi feito o registro da análise:\n\t" + this.analise.data + " - " + this.analise.hora , font);
            font.setSize(10);
            document.add(p);

            p = new Paragraph("\n2. Fatores contribuintes para ocorrência:\n" + this.analise.fatoresContribuintes, font);
            document.add(p);

            p = new Paragraph("\n3. Consequências organizacionais:\n" + this.analise.consequenciasOrganizacionais, font);
            document.add(p);

            p = new Paragraph("\n4. Identificação e análise de fatores:\n" + this.analise.identificacaoeAnaliseDeFatores, font);
            document.add(p);

            p = new Paragraph("\n5. Fatores atenuantes da ocorrência\n" + this.analise.fatoresAtenuantesDaOcorrencia, font);
            document.add(p);
        }
        return document;
    }

    public Document dadosProvidencia(Document document){
        if(this.providencia != null){
            var font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setSize(10);
            var p = new Paragraph("\n\nDados da providência:", font);
            document.add(p);

            font = FontFactory.getFont(FontFactory.HELVETICA);
            p = new Paragraph("1. Data / Hora que foi feito o registro da providência:\n\t" + this.providencia.data + " - " + this.providencia.hora , font);
            font.setSize(10);
            document.add(p);

            p = new Paragraph("\n2. Ações de melhoria:\n" + (this.providencia.acoesDeMelhoria == null ? "-" : this.providencia.acoesDeMelhoria), font);
            document.add(p);

            p = new Paragraph("\n3. Ações para reduzir riscos:\n" + (this.providencia.acoesParaReduzirRiscos == null ? "-" : this.providencia.acoesParaReduzirRiscos), font);
            document.add(p);

            p = new Paragraph("\n4. Não caracteriza um evento adverso:\n\t" + (this.providencia.naoCaracterizaEventoAdverso ? "(X) Sim ( ) Não" : "( ) Sim (X) Não"), font);
            document.add(p);

            p = new Paragraph("\n5. Outras providências:\n" + (this.providencia.outrasProvidencias == null ? "-" : this.providencia.outrasProvidencias), font);
            document.add(p);
        }
        return document;
    }

    public Document dadosObito(Document document){
        if(this.obito != null){
            var font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setSize(10);
            var p = new Paragraph("\n\nDados do óbito:", font);
            document.add(p);

            font = FontFactory.getFont(FontFactory.HELVETICA);
            p = new Paragraph("1. Data / Hora que foi feito o registro do óbito:\n\t" + this.obito.data + " - " + this.obito.hora , font);
            font.setSize(10);
            document.add(p);

            p = new Paragraph("\n2. Data do óbito:\n\t" + this.obito.dataDoObito, font);
            document.add(p);

            p = new Paragraph("\n3. Número da declaração de óbito:\n" + this.obito.numeroDaDeclaracao, font);
            document.add(p);

            p = new Paragraph(
                    "\n4. Tipo de lesão:\n" +
                            this.obito.tipoLesao.nome +
                            (!this.obito.tipoLesao.descricao.isEmpty() ? (" ("+this.obito.tipoLesao.descricao)+")" : ""), font);
            document.add(p);

            p = new Paragraph("\n5. Causa da morte conforme a declaração de óbito:\n" + this.obito.causaDaMorte, font);
            document.add(p);
        }
        return document;
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        document = headerDocument(document);
        document = dadosDoPaciente(document);
        document = dadosOcorrencia(document);
        document = dadosAnalise(document);
        document = dadosProvidencia(document);
        document = dadosObito(document);

        document.close();
    }
}

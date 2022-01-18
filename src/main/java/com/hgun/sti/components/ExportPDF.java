package com.hgun.sti.components;

import com.hgun.sti.models.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ExportPDF {

    private static final float identacao = 25;
    private static final int fontSizeMin = 10;


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

    private String formataNumeroNotificacao(Long id){
        String result = null;

        if(id < 10){
            result = "000"+id;
        }else if(id < 100){
            result = "00"+id;
        }else if(id < 1000){
            result = "0"+id;
        }else {
            result = id.toString();
        }

        return result;
    }

    private Paragraph getParagrafoNovo(
            String texto,
            boolean identado,
            boolean centralizado,
            boolean fontBold,
            boolean alinhadoDireita
    ){
        Font font;

        if(fontBold){
            font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        }else {
            font = FontFactory.getFont(FontFactory.HELVETICA);
        }

        font.setSize(fontSizeMin);

        var result = new Paragraph(texto , font);

        if(identado){
            result.setIndentationLeft(identacao);
        }

        if(centralizado){
            result.setAlignment(Paragraph.ALIGN_CENTER);
        }

        if(alinhadoDireita){
            result.setAlignment(Paragraph.ALIGN_RIGHT);
        }

        return result;
    }

    private String getDataFormatada(){

        var pattern = "EEEEE dd MMMMM yyyy";
        var simpleDateFormat = new SimpleDateFormat(pattern, new Locale("pt","BR"));
        var date = simpleDateFormat.format(new Date());

        return "NATAL, " + date.toString();
    }

    private Image getImagemNova(String caminhoImagem) throws IOException {
        Image image = Image.getInstance(caminhoImagem);
        image.setAlignment(Image.ALIGN_CENTER);

        return image;
    }

    public Document headerDocument(Document document) throws IOException {

        document.add(getImagemNova("src/main/resources/static/img/brasao-da-republica-do-brasil.com.png"));

        document.add(getParagrafoNovo("MINISTERIO DA DEFESA", false, true, true, false));

        document.add(getParagrafoNovo("EXERCITO BRASILEIRO", false, true, true, false));

        document.add(getParagrafoNovo("HOSPPITAL DE GUARNIÇÃO DE NATAL", false, true, true, false));


        document.add(getParagrafoNovo(" ", false, false, false, false));
        document.add(getParagrafoNovo(" ", false, false, false, false));
        document.add(getParagrafoNovo(" ", false, false, false, false));


        document.add(getParagrafoNovo("Notificação  de Incidente / Notificação  de Evento Adverso                                               Nº da notificação : " + formataNumeroNotificacao(this.ocorrencia.id), false, false, true, false));

        document.add(getParagrafoNovo("Data / Hora do Evento: " + this.ocorrencia.data + " - " + this.ocorrencia.hora, false, false, false, true));

        return document;
    }

    public Document dadosDoPaciente(Document document){

        document.add(getParagrafoNovo("\n\nDados do paciente:", false, false, true, false));

        document.add(getParagrafoNovo("Nome: " + this.ocorrencia.paciente.nome, false, false, false, false));

        document.add(getParagrafoNovo("Sexo: " + (this.ocorrencia.paciente.sexo == 'M' ? "(X) Masculino ( ) Feminino" : "( ) Masculino (X) Feminino") +
                "                              " + "Idade: " + this.ocorrencia.paciente.idade + " anos" +
                "                              " + "Nº do PRECCP: " + (this.ocorrencia.paciente.preccp == null ? "-" : this.ocorrencia.paciente.preccp), false, false, false, false));


        return document;
    }

    public Document dadosOcorrencia(Document document){

        document.add(getParagrafoNovo("\n\nDados da ocorrência:", false, false, true, false));

        document.add(getParagrafoNovo("1. Tipo da ocorrência:\n", false, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.tipoOcorrencia.nome + (!this.ocorrencia.tipoOcorrencia.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoOcorrencia.descricao)+")" : ""), true, false, false, false));

        document.add(getParagrafoNovo("\n2. Tipo da incidência (com / sem dano):\n", false, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.tipoIncidencia.nome + (!this.ocorrencia.tipoIncidencia.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoIncidencia.descricao)+")" : ""), true, false, false, false));

        document.add(getParagrafoNovo("\n3. Características do dano (grau do dano):\n", false, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.tipoDano.nome + (!this.ocorrencia.tipoDano.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoDano.descricao)+")" : ""), true, false, false, false));

        document.add(getParagrafoNovo("\n4. Setor onde o evento ocorreu:\n", false, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.tipoSetor.nome + (!this.ocorrencia.tipoSetor.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoSetor.descricao)+")" : ""), true, false, false, false));

        document.add(getParagrafoNovo("\n5. Em que fase da assistência o evento ocorreu:\n", false, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.tipoFaseAssistencia.nome + (!this.ocorrencia.tipoFaseAssistencia.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoFaseAssistencia.descricao)+")" : ""), true, false, false, false));

        document.add(getParagrafoNovo("\n6. Resumo do evento:\n", false, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.resumo, true, false, false, false));

        document.add(getParagrafoNovo("\n7. Descrição do evento:\n", false, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.descricao, true, false, false, false));

        document.add(getParagrafoNovo("\n8. Fator contribuinte para a ocorrência do evento:\n", false, false, false, false));
        document.add(getParagrafoNovo((this.ocorrencia.fatorContribuinte.isEmpty() ? "-" : this.ocorrencia.fatorContribuinte), true, false, false, false));

        document.add(getParagrafoNovo("\n9. O paciente foi internado:\n", false, false, false, false));
        document.add(getParagrafoNovo((this.ocorrencia.pacienteFoiInternado ? "(X) Sim ( ) Não" : "( ) Sim (X) Não"), true, false, false, false));

        document.add(getParagrafoNovo("\n10. O paciente foi a óbito:\n", false, false, false, false));
        document.add(getParagrafoNovo((this.ocorrencia.pacienteFaleceu ? "(X) Sim ( ) Não" : "( ) Sim (X) Não"), true, false, false, false));

        return document;
    }

    public Document dadosAnalise(Document document){
        if(this.analise != null){

            document.add(getParagrafoNovo("\n\nDados da análise:", false, false, true, false));

            document.add(getParagrafoNovo("1. Data / Hora que foi feito o registro da análise:\n", false, false, false, false));
            document.add(getParagrafoNovo(this.analise.data + " - " + this.analise.hora , true, false, false, false));

            document.add(getParagrafoNovo("\n2. Fatores contribuintes para ocorrência:\n", false, false, false, false));
            document.add(getParagrafoNovo(this.analise.fatoresContribuintes, true, false, false, false));

            document.add(getParagrafoNovo("\n3. Consequências organizacionais:\n", false, false, false, false));
            document.add(getParagrafoNovo(this.analise.consequenciasOrganizacionais, true, false, false, false));

            document.add(getParagrafoNovo("\n4. Identificação e análise de fatores:\n", false, false, false, false));
            document.add(getParagrafoNovo(this.analise.identificacaoeAnaliseDeFatores, true, false, false, false));

            document.add(getParagrafoNovo("\n5. Fatores atenuantes da ocorrência\n", false,false, false, false));
            document.add(getParagrafoNovo(this.analise.fatoresAtenuantesDaOcorrencia, true, false, false, false));
        }
        return document;
    }

    public Document dadosProvidencia(Document document){
        if(this.providencia != null){

            document.add(getParagrafoNovo("\n\nDados da providência:", false, false, true, false));

            document.add(getParagrafoNovo("1. Data / Hora que foi feito o registro da providência:\n", false, false, false, false));
            document.add(getParagrafoNovo(this.providencia.data + " - " + this.providencia.hora , true, false, false, false));

            document.add(getParagrafoNovo("\n2. Ações de melhoria:\n", false, false, false, false));
            document.add(getParagrafoNovo((this.providencia.acoesDeMelhoria.isEmpty() ? "-" : this.providencia.acoesDeMelhoria), true, false, false, false));

            document.add(getParagrafoNovo("\n3. Ações para reduzir riscos:\n", false, false, false, false));
            document.add(getParagrafoNovo((this.providencia.acoesParaReduzirRiscos.isEmpty() ? "-" : this.providencia.acoesParaReduzirRiscos), true, false, false, false));

            document.add(getParagrafoNovo("\n4. Não caracteriza um evento adverso:\n", false, false, false, false));
            document.add(getParagrafoNovo((this.providencia.naoCaracterizaEventoAdverso ? "(X) Sim ( ) Não" : "( ) Sim (X) Não"), true, false, false, false));

            document.add(getParagrafoNovo("\n5. Outras providências:\n", false, false, false, false));
            document.add(getParagrafoNovo((this.providencia.outrasProvidencias.isEmpty() ? "-" : this.providencia.outrasProvidencias), true, false, false, false));
        }
        return document;
    }

    public Document dadosObito(Document document){
        if(this.obito != null){

            document.add(getParagrafoNovo("\n\nDados do óbito:", false, false, true, false));

            document.add(getParagrafoNovo("1. Data / Hora que foi feito o registro do óbito:\n", false, false, false, false));
            document.add(getParagrafoNovo(this.obito.data + " - " + this.obito.hora , true, false, false, false));

            document.add(getParagrafoNovo("\n2. Data do óbito:\n", false, false, false, false));
            document.add(getParagrafoNovo(this.obito.dataDoObito, true, false, false, false));

            document.add(getParagrafoNovo("\n3. Número da declaração de óbito:\n", false, false, false, false));
            document.add(getParagrafoNovo(this.obito.numeroDaDeclaracao, true, false, false, false));

            document.add(getParagrafoNovo("\n4. Tipo de lesão:\n", false, false, false, false));
            document.add(getParagrafoNovo(this.obito.tipoLesao.nome + (!this.obito.tipoLesao.descricao.isEmpty() ? (" ("+this.obito.tipoLesao.descricao)+")" : ""),true, false, false, false));

            document.add(getParagrafoNovo("\n5. Causa da morte conforme a declaração de óbito:\n", false, false, false, false));
            document.add(getParagrafoNovo(this.obito.causaDaMorte, true, false, false, false));
        }
        return document;
    }

    public Document footerDocument(Document document) throws IOException {

        document.add(getParagrafoNovo(" ", false, false, false, false));
        document.add(getParagrafoNovo(" ", false, false, false, false));

        document.add(getParagrafoNovo("Equipe de análise do incidente / evento adverso:", false, false, false, false));
        document.add(getParagrafoNovo("Assinatura / Carimbo", false, false, false, false));

        document.add(getParagrafoNovo(" ", false, false, false, false));
        document.add(getParagrafoNovo("_____________________________________________________________", false, true, true, false));

        document.add(getParagrafoNovo(" ", false, false, false, false));
        document.add(getParagrafoNovo("_____________________________________________________________", false, true, true, false));

        document.add(getParagrafoNovo(" ", false, false, false, false));
        document.add(getParagrafoNovo("_____________________________________________________________", false, true, true, false));

        document.add(getParagrafoNovo(" ", false, false, false, false));

        document.add(getParagrafoNovo(getDataFormatada(), false, true, false, false));

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

        document = footerDocument(document);

        document.close();
    }
}

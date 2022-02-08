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

    private static final float semIdentacao = 0;
    private static final float identacao1 = 25;
    private static final float identacao2 = 50;

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
            float identacao,
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

        if(identacao != 0){
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

        document.add(getParagrafoNovo("MINISTERIO DA DEFESA", semIdentacao, true, true, false));

        document.add(getParagrafoNovo("EXERCITO BRASILEIRO", semIdentacao, true, true, false));

        document.add(getParagrafoNovo("HOSPITAL DE GUARNIÇÃO DE NATAL", semIdentacao, true, true, false));


        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));


        document.add(getParagrafoNovo("Notificação  de Incidente / Notificação  de Evento Adverso                                               Nº da notificação : " + formataNumeroNotificacao(this.ocorrencia.id), semIdentacao, false, true, false));

        document.add(getParagrafoNovo("Data / Hora do Evento: " + this.ocorrencia.dataDaOcorrencia + " - " + this.ocorrencia.horaDaOcorrencia, semIdentacao, false, false, true));

        return document;
    }

    public Document dadosDoPaciente(Document document){

        document.add(getParagrafoNovo("\n\nDados do paciente:", semIdentacao, false, true, false));

        document.add(getParagrafoNovo("Nome: " + this.ocorrencia.paciente.nome, semIdentacao, false, false, false));

        document.add(getParagrafoNovo("Sexo: " + (this.ocorrencia.paciente.sexo == 'M' ? "(X) Masculino ( ) Feminino" : "( ) Masculino (X) Feminino") +
                "                              " + "Idade: " + this.ocorrencia.paciente.idade + " anos" +
                "                              " + "Nº do PRECCP: " + (this.ocorrencia.paciente.preccp == null ? "-" : this.ocorrencia.paciente.preccp), semIdentacao, false, false, false));

        document.add(getParagrafoNovo("Diagnóstico do paciente:", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.diagnostico, identacao1, false, false, false));

        document.add(getParagrafoNovo("Data / Hora da internação do paciente:                " + this.ocorrencia.dataDaInternacao + " - " + this.ocorrencia.horaDaInternacao, semIdentacao, false, false, false));

        return document;
    }

    public Document dadosOcorrencia(Document document){

        document.add(getParagrafoNovo("\n\nDados da ocorrência:", semIdentacao, false, true, false));

        document.add(getParagrafoNovo("1. Tipo da ocorrência:\n", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.tipoOcorrencia.nome + (!this.ocorrencia.tipoOcorrencia.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoOcorrencia.descricao)+")" : ""), identacao1, false, false, false));

        document.add(getParagrafoNovo("\n2. Tipo da incidência (com / sem dano):\n", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.tipoIncidencia.nome + (!this.ocorrencia.tipoIncidencia.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoIncidencia.descricao)+")" : ""), identacao1, false, false, false));

        document.add(getParagrafoNovo("\n3. Características do dano (grau do dano):\n", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.tipoDano.nome + (!this.ocorrencia.tipoDano.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoDano.descricao)+")" : ""), identacao1, false, false, false));

        document.add(getParagrafoNovo("\n4. Setor onde o evento ocorreu:\n", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.tipoSetor.nome + (!this.ocorrencia.tipoSetor.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoSetor.descricao)+")" : ""), identacao1, false, false, false));

        document.add(getParagrafoNovo("\n5. Em que fase da assistência o evento ocorreu:\n", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.tipoFaseAssistencia.nome + (!this.ocorrencia.tipoFaseAssistencia.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoFaseAssistencia.descricao)+")" : ""), identacao1, false, false, false));

        document.add(getParagrafoNovo("\n6. Como foi identificado o incidente / evento adverso:\n", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.tipoIdentificacao.nome + (!this.ocorrencia.tipoIdentificacao.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoIdentificacao.descricao)+")" : ""), identacao1, false, false, false));

        document.add(getParagrafoNovo("\n7. Quem identificou o incidente / evento adverso:\n", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.tipoIdentificador.nome + (!this.ocorrencia.tipoIdentificador.descricao.isEmpty() ? (" ("+this.ocorrencia.tipoIdentificador.descricao)+")" : ""), identacao1, false, false, false));

        document.add(getParagrafoNovo("\n8. Resumo do evento:\n", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.resumo, identacao1, false, false, false));

        document.add(getParagrafoNovo("\n9. Descrição do evento:\n", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(this.ocorrencia.descricao, identacao1, false, false, false));

        document.add(getParagrafoNovo("\n10. Fator contribuinte para a ocorrência do evento:\n", semIdentacao, false, false, false));
        document.add(getParagrafoNovo((this.ocorrencia.fatorContribuinte.isEmpty() ? "-" : this.ocorrencia.fatorContribuinte), identacao1, false, false, false));

        document.add(getParagrafoNovo("\n11. O paciente foi internado:\n", semIdentacao, false, false, false));
        document.add(getParagrafoNovo((this.ocorrencia.pacienteFoiInternado ? "(X) Sim ( ) Não" : "( ) Sim (X) Não"), identacao1, false, false, false));

        document.add(getParagrafoNovo("\n12. O paciente foi a óbito:\n", semIdentacao, false, false, false));
        document.add(getParagrafoNovo((this.ocorrencia.pacienteFaleceu ? "(X) Sim ( ) Não" : "( ) Sim (X) Não"), identacao1, false, false, false));

        return document;
    }

    public Document dadosAnalise(Document document){
        if(this.analise != null){

            document.add(getParagrafoNovo("\n\nDados da análise:", semIdentacao, false, true, false));

            document.add(getParagrafoNovo("1. Data / Hora que foi feito o registro da análise:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo(this.analise.data + " - " + this.analise.hora , identacao1, false, false, false));


            document.add(getParagrafoNovo("\n2. Fatores contribuintes:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo("\n2.1. Fatores cognitivos:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.analise.tipoFatorContribuinteCognitivo.nome.isEmpty() ?  this.analise.tipoFatorContribuinteCognitivo.nome : "-") + (!this.analise.tipoFatorContribuinteCognitivo.descricao.isEmpty() ? (" ("+this.analise.tipoFatorContribuinteCognitivo.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n2.2. Fatores de comportamento:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.analise.tipoFatorContribuinteComportamento.nome.isEmpty() ?  this.analise.tipoFatorContribuinteComportamento.nome : "-") + (!this.analise.tipoFatorContribuinteComportamento.descricao.isEmpty() ? (" ("+this.analise.tipoFatorContribuinteComportamento.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n2.3. Fatores da comunicação:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.analise.tipoFatorContribuinteComunicacao.nome.isEmpty() ?  this.analise.tipoFatorContribuinteComunicacao.nome : "-") + (!this.analise.tipoFatorContribuinteComunicacao.descricao.isEmpty() ? (" ("+this.analise.tipoFatorContribuinteComunicacao.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n2.4. Fatores de desenpenho:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.analise.tipoFatorContribuinteDesenpenho.nome.isEmpty() ?  this.analise.tipoFatorContribuinteDesenpenho.nome : "-") + (!this.analise.tipoFatorContribuinteDesenpenho.descricao.isEmpty() ? (" ("+this.analise.tipoFatorContribuinteDesenpenho.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n2.5. Fatores Organizacionais:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.analise.tipoFatorContribuinteOrganizacional.nome.isEmpty() ?  this.analise.tipoFatorContribuinteOrganizacional.nome : "-") + (!this.analise.tipoFatorContribuinteOrganizacional.descricao.isEmpty() ? (" ("+this.analise.tipoFatorContribuinteOrganizacional.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n2.6. Fatores do paciente:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.analise.tipoFatorContribuintePaciente.nome.isEmpty() ?  this.analise.tipoFatorContribuintePaciente.nome : "-") + (!this.analise.tipoFatorContribuintePaciente.descricao.isEmpty() ? (" ("+this.analise.tipoFatorContribuintePaciente.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n2.7. Fatores profissionais:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.analise.tipoFatorContribuinteProfissional.nome.isEmpty() ?  this.analise.tipoFatorContribuinteProfissional.nome : "-") + (!this.analise.tipoFatorContribuinteProfissional.descricao.isEmpty() ? (" ("+this.analise.tipoFatorContribuinteProfissional.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n2.8. Fatores do trabalho / ambiente:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.analise.tipoFatorContribuinteTrabalho.nome.isEmpty() ?  this.analise.tipoFatorContribuinteTrabalho.nome : "-") + (!this.analise.tipoFatorContribuinteTrabalho.descricao.isEmpty() ? (" ("+this.analise.tipoFatorContribuinteTrabalho.descricao)+")" : ""), identacao2, false, false, false));


            document.add(getParagrafoNovo("\n3. Fatores atenuantes do dano:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo("\n3.1. Dirigidos à um agente:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.analise.tipoFatorAtenuanteAgente.nome.isEmpty() ?  this.analise.tipoFatorAtenuanteAgente.nome : "-") + (!this.analise.tipoFatorAtenuanteAgente.descricao.isEmpty() ? (" ("+this.analise.tipoFatorAtenuanteAgente.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n3.2. Dirigidos à organização:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.analise.tipoFatorAtenuanteOrganizacao.nome.isEmpty() ?  this.analise.tipoFatorAtenuanteOrganizacao.nome : "-") + (!this.analise.tipoFatorAtenuanteOrganizacao.descricao.isEmpty() ? (" ("+this.analise.tipoFatorAtenuanteOrganizacao.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n3.3. Dirigidos ao paciente:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.analise.tipoFatorAtenuantePaciente.nome.isEmpty() ?  this.analise.tipoFatorAtenuantePaciente.nome : "-") + (!this.analise.tipoFatorAtenuantePaciente.descricao.isEmpty() ? (" ("+this.analise.tipoFatorAtenuantePaciente.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n3.4. Dirigidos ao profissional:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo( (!this.analise.tipoFatorAtenuanteProfissional.nome.isEmpty() ?  this.analise.tipoFatorAtenuanteProfissional.nome : "-") + (!this.analise.tipoFatorAtenuanteProfissional.descricao.isEmpty() ? (" ("+this.analise.tipoFatorAtenuanteProfissional.descricao)+")" : ""), identacao2, false, false, false));


            document.add(getParagrafoNovo("\n4. Consequências organizacionais:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo((!this.analise.tipoConsequenciaOrganizacional.nome.isEmpty() ?  this.analise.tipoConsequenciaOrganizacional.nome : "-") + (!this.analise.tipoConsequenciaOrganizacional.descricao.isEmpty() ? (" ("+this.analise.tipoConsequenciaOrganizacional.descricao)+")" : ""), identacao1, false, false, false));
        }

        return document;
    }

    public Document dadosProvidencia(Document document){
        if(this.providencia != null){

            document.add(getParagrafoNovo("\n\nDados da providência:", semIdentacao, false, true, false));

            document.add(getParagrafoNovo("1. Data / Hora que foi feito o registro da providência:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo(this.providencia.data + " - " + this.providencia.hora , identacao1, false, false, false));

            document.add(getParagrafoNovo("\n2. Não caracteriza um evento adverso:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo((this.providencia.naoCaracterizaEventoAdverso ? "(X) Sim ( ) Não" : "( ) Sim (X) Não"), identacao1, false, false, false));

            document.add(getParagrafoNovo("\n3. Não foram adotadas ações de redução de risco:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo((this.providencia.naoAdotadasAcoesReducaoRisco ? "(X) Sim ( ) Não" : "( ) Sim (X) Não"), identacao1, false, false, false));

            document.add(getParagrafoNovo("\n4. Açoes de melhoria:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo("\n4.1. Relacionadas ao paciente:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.providencia.tipoAcaoMelhoriaPaciente.nome.isEmpty() ? this.providencia.tipoAcaoMelhoriaPaciente.nome : "-") + (!this.providencia.tipoAcaoMelhoriaPaciente.descricao.isEmpty() ? (" ("+this.providencia.tipoAcaoMelhoriaPaciente.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n4.2. Relacionadas com a organização:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.providencia.tipoAcaoMelhoriaOrganizacao.nome.isEmpty() ? this.providencia.tipoAcaoMelhoriaOrganizacao.nome : "-") + (!this.providencia.tipoAcaoMelhoriaOrganizacao.descricao.isEmpty() ? (" ("+this.providencia.tipoAcaoMelhoriaOrganizacao.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n5. Açoes para reduzir riscos:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo("\n5.1. Relacionadas ao paciente:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.providencia.tipoAcaoReduzirRiscoPaciente.nome.isEmpty() ? this.providencia.tipoAcaoReduzirRiscoPaciente.nome : "-") + (!this.providencia.tipoAcaoReduzirRiscoPaciente.descricao.isEmpty() ? (" ("+this.providencia.tipoAcaoReduzirRiscoPaciente.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n5.2. Relacionadas ao profissional:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.providencia.tipoAcaoReduzirRiscoProfissional.nome.isEmpty() ? this.providencia.tipoAcaoReduzirRiscoProfissional.nome : "-") + (!this.providencia.tipoAcaoReduzirRiscoProfissional.descricao.isEmpty() ? (" ("+this.providencia.tipoAcaoReduzirRiscoProfissional.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n5.3. Relacionadas ao ambiente / organizacional:\n", identacao1, false, false, false));
            document.add(getParagrafoNovo((!this.providencia.tipoAcaoReduzirRiscoOrganizacional.nome.isEmpty() ? this.providencia.tipoAcaoReduzirRiscoOrganizacional.nome : "-") + (!this.providencia.tipoAcaoReduzirRiscoOrganizacional.descricao.isEmpty() ? (" ("+this.providencia.tipoAcaoReduzirRiscoOrganizacional.descricao)+")" : ""), identacao2, false, false, false));

            document.add(getParagrafoNovo("\n6. Outras providências:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo((this.providencia.outrasProvidencias.isEmpty() ? "-" : this.providencia.outrasProvidencias), identacao1, false, false, false));

        }

        return document;
    }

    public Document dadosObito(Document document){
        if(this.obito != null){

            document.add(getParagrafoNovo("\n\nDados do óbito:", semIdentacao, false, true, false));

            document.add(getParagrafoNovo("1. Data / Hora que foi feito o registro do óbito:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo(this.obito.data + " - " + this.obito.hora , identacao1, false, false, false));

            document.add(getParagrafoNovo("\n2. Data do óbito:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo(this.obito.dataDoObito, identacao1, false, false, false));

            document.add(getParagrafoNovo("\n3. Número da declaração de óbito:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo(this.obito.numeroDaDeclaracao, identacao1, false, false, false));

            document.add(getParagrafoNovo("\n4. Tipo de lesão:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo(this.obito.tipoLesao.nome + (!this.obito.tipoLesao.descricao.isEmpty() ? (" ("+this.obito.tipoLesao.descricao)+")" : ""),identacao1, false, false, false));

            document.add(getParagrafoNovo("\n5. Causa da morte conforme a declaração de óbito:\n", semIdentacao, false, false, false));
            document.add(getParagrafoNovo(this.obito.causaDaMorte, identacao1, false, false, false));
        }

        return document;
    }

    public Document footerDocument(Document document){

        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));

        document.add(getParagrafoNovo("Equipe de análise do incidente / evento adverso:", semIdentacao, false, false, false));
        document.add(getParagrafoNovo("Assinatura / Carimbo", semIdentacao, false, false, false));

        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo("_____________________________________________________________", semIdentacao, true, true, false));

        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo("_____________________________________________________________", semIdentacao, true, true, false));

        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));
        document.add(getParagrafoNovo("_____________________________________________________________", semIdentacao, true, true, false));

        document.add(getParagrafoNovo(" ", semIdentacao, false, false, false));

        document.add(getParagrafoNovo(getDataFormatada(), semIdentacao, true, false, false));

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

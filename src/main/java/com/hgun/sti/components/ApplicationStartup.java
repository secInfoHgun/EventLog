package com.hgun.sti.components;

import com.hgun.sti.models.types.*;
import com.hgun.sti.models.types.acao.reduzirRisco.*;
import com.hgun.sti.models.types.acao.melhoria.*;
import com.hgun.sti.models.types.fator.atenuante.*;
import com.hgun.sti.models.types.fator.contribuinte.*;
import com.hgun.sti.models.types.identificacao.*;
import com.hgun.sti.repository.types.*;
import com.hgun.sti.repository.types.acao.melhoria.*;
import com.hgun.sti.repository.types.acao.reduzirRisco.*;
import com.hgun.sti.repository.types.fator.atenuante.*;
import com.hgun.sti.repository.types.fator.contribuinte.*;
import com.hgun.sti.repository.types.identificacao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

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

    @Autowired
    private TipoIdentificacaoRepository tipoIdentificacaoRepository;

    @Autowired
    private TipoIdentificadorRepository tipoIdentificadorRepository;

    @Autowired
    private TipoConsequenciaOrganizacionalRepository tipoConsequenciaOrganizacionalRepository;

    @Autowired
    private TipoFatorContribuinteCognitivoRepository tipoFatorContribuinteCognitivoRepository;

    @Autowired
    private TipoFatorContribuinteComportamentoRepository tipoFatorContribuinteComportamentoRepository;

    @Autowired
    private TipoFatorContribuinteComunicacaoRepository tipoFatorContribuinteComunicacaoRepository;

    @Autowired
    private TipoFatorContribuinteDesenpenhoRepository tipoFatorContribuinteDesenpenhoRepository;

    @Autowired
    private TipoFatorContribuinteOrganizacionalRepository tipoFatorContribuinteOrganizacionalRepository;

    @Autowired
    private TipoFatorContribuintePacienteRepository tipoFatorContribuintePacienteRepository;

    @Autowired
    private TipoFatorContribuinteProfissionalRepository tipoFatorContribuinteProfissionalRepository;

    @Autowired
    private TipoFatorContribuinteTrabalhoRepository tipoFatorContribuinteTrabalhoRepository;

    @Autowired
    private TipoFatorAtenuanteAgenteRepository tipoFatorAtenuanteAgenteRepository;

    @Autowired
    private TipoFatorAtenuanteOrganizacaoRepository tipoFatorAtenuanteOrganizacaoRepository;

    @Autowired
    private TipoFatorAtenuantePacienteRepository tipoFatorAtenuantePacienteRepository;

    @Autowired
    private TipoFatorAtenuanteProfissionalRepository tipoFatorAtenuanteProfissionalRepository;

    @Autowired
    private TipoAcaoMelhoriaOrganizacaoRepository tipoAcaoMelhoriaOrganizacaoRepository;

    @Autowired
    private TipoAcaoMelhoriaPacienteRepository tipoAcaoMelhoriaPacienteRepository;

    @Autowired
    private TipoAcaoReduzirRiscoOrganizacionalRepository tipoAcaoReduzirRiscoOrganizacionalRepository;

    @Autowired
    private TipoAcaoReduzirRiscoPacienteRepository tipoAcaoReduzirRiscoPacienteRepository;

    @Autowired
    private TipoAcaoReduzirRiscoProfissionalRepository tipoAcaoReduzirRiscoProfissionalRepository;


    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        var listaTipoOcorrencia = tipoOcorrenciaRepository.findAll();
        var listaTipoIncidencia = tipoIncidenciaRepository.findAll();
        var listaTipoDano = tipoDanoRepository.findAll();
        var listaTipoFaseAssistencia = tipoFaseAssistenciaRepository.findAll();
        var listaTipoSetor = tipoSetorRepository.findAll();
        var listaTipoLesao = tipoLesaoRepository.findAll();
        var listaTipoIdentificacao = tipoIdentificacaoRepository.findAll();
        var listaTipoIdentificador = tipoIdentificadorRepository.findAll();

        var listaTipoConsequenciaOrganizacional = tipoConsequenciaOrganizacionalRepository.findAll();

        var listaTipoFatorContibuinteCognitivo = tipoFatorContribuinteCognitivoRepository.findAll();
        var listaTipoFatorContribuinteComportamento = tipoFatorContribuinteComportamentoRepository.findAll();
        var listaTipoFatorContribuinteComunicacao = tipoFatorContribuinteComunicacaoRepository.findAll();
        var listaTipoFatorContribuinteDesenpenho = tipoFatorContribuinteDesenpenhoRepository.findAll();
        var listaTipoFatorContribuinteOrganizacional = tipoFatorContribuinteOrganizacionalRepository.findAll();
        var listaTipoFatorContribuintePaciente = tipoFatorContribuintePacienteRepository.findAll();
        var listaTipoFatorContribuinteProfissional = tipoFatorContribuinteProfissionalRepository.findAll();
        var listaTipoFatorContribuinteTrabalho = tipoFatorContribuinteTrabalhoRepository.findAll();

        var listaTipoFatorAtenuanteAgente = tipoFatorAtenuanteAgenteRepository.findAll();
        var listaTipoFatorAtenuanteOrganizacao = tipoFatorAtenuanteOrganizacaoRepository.findAll();
        var listaTipoFatorAtenuantePaciente = tipoFatorAtenuantePacienteRepository.findAll();
        var listaTipoFatorAtenuanteProfissional = tipoFatorAtenuanteProfissionalRepository.findAll();

        var listaTipoAcaoMelhoriaOrganizacao = tipoAcaoMelhoriaOrganizacaoRepository.findAll();
        var listaTipoAcaoMelhoriaPaciente = tipoAcaoMelhoriaPacienteRepository.findAll();
        var listaTipoAcaoReduzirRiscoOrganizacional = tipoAcaoReduzirRiscoOrganizacionalRepository.findAll();
        var listaTipoAcaoReduzirRiscoPaciente = tipoAcaoReduzirRiscoPacienteRepository.findAll();
        var listaTipoAcaoReduzirRiscoProfissional = tipoAcaoReduzirRiscoProfissionalRepository.findAll();

        if( listaTipoOcorrencia.isEmpty()){
            String[][] aux = {
                    {"Acidentes do paciente", ""},
                    {"Admiss??o no servi??o de sa??de", ""},
                    {"Falha na assist??ncia radiol??gica", ""},
                    {"Falhas no cuidado / prote????o do paciente", ""},
                    {"Falta de identifica????o no leito do paciente", ""},
                    {"Falta de pulseiras de identifica????o", ""},
                    {"Incidente / evento adverso durante procedimento cir??rgico", ""},
                    {"Infec????o hospitalar no local da cirurgia", ""},
                    {"Infec????es hospitalar como pneumonia", ""},
                    {"Infec????es relacionadas ?? assist??ncia ?? sa??de", ""},
                    {"Les??o por dispositivo m??dico", "feridas na pele provocadas por contato prolongado com dispositivo m??dico"},
                    {"Les??o por press??o", "feridas na pele provocadas pelo tempo prolongado sentado ou deitado"},
                    {"Incidente / evento adverso na identifica????o do paciente", ""},
                    {"Incidente / evento adverso nas atividades administrativas", ""},
                    {"Incidente / evento adverso ocorridas em laborat??rios cl??nicos ou de patologia", ""},
                    {"Incidente / evento adverso na administra????o de dietas", ""},
                    {"Incidente / evento adverso de infec????o hospitalar causada pelo cateter colocado na veia", ""},
                    {"Infec????o hospitalar como infec????o urin??ria", ""},
                    {"Problema /evento adverso relacionado ao enxerto (osso, pele ou outros) fertiliza????o", ""},
                    {"Problema / evento adverso relacionado ao uso de medicamentos", ""},
                    {"Problema / evento adverso relacionado ao uso de sangue / hemocomponente", ""},
                    {"Problemas / eventos adversos associados a equipamento m??dico-hospitalar", ""},
                    {"Problemas / eventos adversos associados a produtos para a sa??de: artigo / material m??dico-hospitalar", ""},
                    {"Queda do paciente", ""},
                    {"Transfer??ncia para outros servi??os de sa??de", ""},
                    {"Troca de nome dos pacientes", ""},
                    {"Outros", ""}
            };


            for (String[] i: aux) {
                var tipoOcorrencia =  new TipoOcorrencia();
                tipoOcorrencia.setNome(i[0]);
                tipoOcorrencia.setDescricao(i[1]);
                tipoOcorrenciaRepository.save(tipoOcorrencia);
            }

            System.out.println("cadastrei os tipos de ocorrencia");
        }



        if(listaTipoIncidencia.isEmpty()){
            String[][] aux = {
                    {"Incidente com dano ou EA", "incidente que resulta em dano ao paciente"},
                    {"Incidente sem dano", "evento que atingiu o paciente, mas n??o causou dano"},
                    {"Near miss", "incidente que n??o atingiu o paciente"},
                    {"Circunst??ncia notific??vel", "N??o ocorreu um acidente, mas sim um evento expressivo para o dano do paciente"}
            };

            for (String[] i: aux) {
                var tipoIncidencia =  new TipoIncidencia();
                tipoIncidencia.setNome(i[0]);
                tipoIncidencia.setDescricao(i[1]);
                tipoIncidenciaRepository.save(tipoIncidencia);
            }

            System.out.println("cadastrei os tipos de incidencia");
        }

        if(listaTipoDano.isEmpty()){
            String[][] aux = {
                {"NENHUM", ""},
                {"LEVE", "O paciente apresentou sintomas leves, danos m??nimos ou intermedi??rios de curta dura????o"},
                {"MODERADO", "O paciente necessitou de interven????o, prolongamento da interna????o, perda de fun????o"},
                {"GRAVE", "Foi necess??ria interven????o para salvar a vida, grande interven????o m??dico-cir??rgica ou casou grandes danos permanentes"},
                {"MORTE", "Foi causada pelo EA"}
            };

            for (String[] i: aux) {
                var tipoDano =  new TipoDano();
                tipoDano.setNome(i[0]);
                tipoDano.setDescricao(i[1]);
                tipoDanoRepository.save(tipoDano);
            }

            System.out.println("cadastrei os tipos de dano");
        }

        if(listaTipoFaseAssistencia.isEmpty()){
            String[][] aux = {
                {"", ""},
                {"Durante a fase de diagn??stico", "exames laboratoriais ou de imagem e consultas m??dicas"},
                {"Durante a fase de presta????o dos cuidados, o tratamento ou a cirurgia", ""},
                {"Durante ou ap??s a fase de doa????o de sangue", ""},
                {"Na fase de admiss??o ou no acesso ao servi??o de sa??de", ""},
                {"Na fase de alta", ""},
                {"Na fase de transfer??ncia interna entre setores", ""},
                {"Na fase de transfer??ncia para outra institui????o ou servi??o", ""},
                {"Na fase do acompanhamento p??s-alta", ""},
                {"N??o estava internado", ""}
            };

            for (String[] i: aux) {
                var tipoFaseAssistencia =  new TipoFaseAssistencia();
                tipoFaseAssistencia.setNome(i[0]);
                tipoFaseAssistencia.setDescricao(i[1]);
                tipoFaseAssistenciaRepository.save(tipoFaseAssistencia);
            }

            System.out.println("cadastrei os tipos de fase de assistencia");
        }

        if(listaTipoSetor.isEmpty()){
            String[][] aux = {
                    {"1?? ANDAR", ""},
                    {"2?? ANDAR", ""},
                    {"2?? SE????O", ""},
                    {"ABAS", "P TRIG"},
                    {"ALMOXARIFADO", ""},
                    {"AMBULAT??RIO", ""},
                    {"CENTRO CIRURGICO", ""},
                    {"CME", "CENTRO DE MATERIAL E ESTERILIZA????O"},
                    {"CONTAS M??DICAS", ""},
                    {"CONTIGENTE", ""},
                    {"CORPO DA GUARDA", ""},
                    {"BLOCO ADMINISTRATIVO", ""},
                    {"FARM??CIA", ""},
                    {"FARN??CIA", "CENTRO CIRURGICO"},
                    {"FARM??CIA SAT??LITE", ""},
                    {"FISIOTERAPIA", ""},
                    {"FUSEX", ""},
                    {"GARAGEM", "SETOR DE NANUTEN????O E TRANSPORTE"},
                    {"LABORAT??RIO DE AN??LISES CL??NICAS", ""},
                    {"NUTRI????O", ""},
                    {"ODONTOLOGIA", ""},
                    {"PAD", "PROGRAMA DE ACOMPANHAMENTO DOMICILIAR"},
                    {"PRONTO ATENDIMENTO M??DICO", ""},
                    {"RADIOLOGIA", ""},
                    {"SE????O DE AUDITORIA DE LISURA", ""},
                    {"SE????O DE INFORM??TICA", ""},
                    {"SE????O DE PER??CIAS M??DICAS", ""},
                    {"SERVI??O DE APROVISIONAMENTO", ""},
                    {"SETOR DE ENDOSCOPIA", ""},
                    {"UMITI", "UNIDADE MILITAR INTEGRADA DE TERAPIA INTENSIVA"},
                    {"UPRSS", "UNIDADE DE PROCESSAMENTO DE ROUPAS DE SERVI??OS DE SA??DE"},
            };

            for (String[] i: aux) {
                var tipoSetor =  new TipoSetor();
                tipoSetor.setNome(i[0]);
                tipoSetor.setDescricao(i[1]);
                tipoSetorRepository.save(tipoSetor);
            }

            System.out.println("cadastrei os tipos de setor");
        }

        if(listaTipoLesao.isEmpty()){
            String[][] aux = {
                    {"Houve Les??o Permanente", ""},
                    {"Houve Les??o Tempor??ria", ""},
                    {"N??o Houve Les??o", ""}
            };

            for (String[] i: aux) {
                var tipoLesao =  new TipoLesao();
                tipoLesao.setNome(i[0]);
                tipoLesao.setDescricao(i[1]);
                tipoLesaoRepository.save(tipoLesao);
            }

            System.out.println("cadastrei os tipos de fase de assistencia");
        }

        if(listaTipoIdentificacao.isEmpty()){
            String[][] aux = {
                    {"Identifica????o pr??-ativa de riscos", ""},
                    {"Por meio de m??quina / sistema / altera????o ambiental / alarme", ""},
                    {"Por meio de uma contagem / auditoria / revis??o", ""},
                    {"Reconhecimento do erro", ""},
                    {"Por altera????o do estado do paciente", ""}
            };

            for (String[] i: aux) {
                var tipoIdentificacao =  new TipoIdentificacao();
                tipoIdentificacao.setNome(i[0]);
                tipoIdentificacao.setDescricao(i[1]);
                tipoIdentificacaoRepository.save(tipoIdentificacao);
            }

            System.out.println("cadastrei os tipos de identificacao");
        }

        if(listaTipoIdentificador.isEmpty()){
            String[][] aux = {
                    {"Pr??prio paciente", ""},
                    {"Outro paciente", ""},
                    {"Familiar", ""},
                    {"Cuidador", ""},
                    {"Volunt??rio", ""},
                    {"Amiga / Visitante", ""},
                    {"Pessoa de assist??ncia espiritual", ""},
                    {"Profissional de sa??de", ""},
                    {"Outro profissional do servi??o de sa??de", ""},
            };

            for (String[] i: aux) {
                var tipoIdentificador =  new TipoIdentificador();
                tipoIdentificador.setNome(i[0]);
                tipoIdentificador.setDescricao(i[1]);
                tipoIdentificadorRepository.save(tipoIdentificador);
            }

            System.out.println("cadastrei os tipos de identificador");
        }

        if(listaTipoConsequenciaOrganizacional.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Dano ?? propriedade", ""},
                    {"Aumento dos recursos necess??rios para o paciente", ""},
                    {"Aten????o da m??dia", ""},
                    {"Reclama????o formal", ""},
                    {"Reputa????o denegrida", ""},
                    {"Implica????es legais", ""}
            };

            for (String[] i: aux) {
                var  tipoConsequenciaOrganizacional =  new TipoConsequenciaOrganizacional();
                tipoConsequenciaOrganizacional.setNome(i[0]);
                tipoConsequenciaOrganizacional.setDescricao(i[1]);
                tipoConsequenciaOrganizacionalRepository.save(tipoConsequenciaOrganizacional);
            }

            System.out.println("cadastrei os tipos de consequencias organizacionais");
        }

        if(listaTipoFatorContibuinteCognitivo.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Percep????o / compreens??o", ""},
                    {"Resolu????o de problemas baseada em conhecimento", ""},
                    {"Correla????o ilus??ria", "associa????o incorreta entre duas vari??veis ou classe de acontecimentos"},
                    {"Efeito de Halo", "tende??ncia a qualificar o indiv??duo de forma equivocada devido a uma informa????o pr??via ou impress??o geral que se tenha do indiv??duo"},
            };

            for (String[] i: aux) {
                var  tipoFatorContribuinteCognitivo =  new TipoFatorContribuinteCognitivo();
                tipoFatorContribuinteCognitivo.setNome(i[0]);
                tipoFatorContribuinteCognitivo.setDescricao(i[1]);
                tipoFatorContribuinteCognitivoRepository.save(tipoFatorContribuinteCognitivo);
            }

            System.out.println("cadastrei os tipos de fatores contribuintes cognitivos");
        }

        if(listaTipoFatorContribuinteComportamento.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Problemas de aten????o", ""},
                    {"Fadiga / exaust??o", ""},
                    {"Excesso de confian??a", ""},
                    {"N??o cumprimento de normas / protocolos", ""},
                    {"Infra????es sistem??ticas", ""},
                    {"Problemas de aten????o", ""},
                    {"Comportamento de risco", ""},
                    {"Comportamento negligente", ""},
                    {"Ato de sabotagem / criminal", ""},
                    {"Problemas com uso / abuso de subst??ncias", ""},
                    {"Fatores emocionais", ""},
            };

            for (String[] i: aux) {
                var  tipoFatorContribuinteComportamento =  new TipoFatorContribuinteComportamento();
                tipoFatorContribuinteComportamento.setNome(i[0]);
                tipoFatorContribuinteComportamento.setDescricao(i[1]);
                tipoFatorContribuinteComportamentoRepository.save(tipoFatorContribuinteComportamento);
            }

            System.out.println("cadastrei os tipos de fatores contribuintes comportamentais");
        }

        if(listaTipoFatorContribuinteComunicacao.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"M??todo de comunica????o", ""},
                    {"Aus??ncia ou inadequada transmiss??o de informa????es durante a passagem de plant??o", ""},
                    {"Problema / evento adverso na compreens??o das orienta????es", "escritas ou verbais"},
                    {"Aus??ncia de anota????es", "prontu??rio / ficha do paciente"},
                    {"Informa????es ilegiveis", "prontu??rio / ficha do paciente"},
                    {"Dificuldades linguisticas", ""},
                    {"Literacia em sa??de", "capacidade de compreender a informa????o de sa??de e usar essa informa????o para tomar decis??es sobre a sa??de e cuidados m??dicos"},
            };

            for (String[] i: aux) {
                var  tipoFatorContribuinteComunicacao =  new TipoFatorContribuinteComunicacao();
                tipoFatorContribuinteComunicacao.setNome(i[0]);
                tipoFatorContribuinteComunicacao.setDescricao(i[1]);
                tipoFatorContribuinteComunicacaoRepository.save(tipoFatorContribuinteComunicacao);
            }

            System.out.println("cadastrei os tipos de fatores contribuintes comunica????es");
        }

        if(listaTipoFatorContribuinteDesenpenho.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Erro t??cnico na execu????o", "baseado na aptid??o f??sica"},
                    {"Baseado em regras", ""},
                    {"Seletividade", ""},
                    {"Parcialidade", ""},

            };

            for (String[] i: aux) {
                var  tipoFatorContribuinteDesenpenho =  new TipoFatorContribuinteDesenpenho();
                tipoFatorContribuinteDesenpenho.setNome(i[0]);
                tipoFatorContribuinteDesenpenho.setDescricao(i[1]);
                tipoFatorContribuinteDesenpenhoRepository.save(tipoFatorContribuinteDesenpenho);
            }

            System.out.println("cadastrei os tipos de fatores contribuintes desempenho");
        }

        if(listaTipoFatorContribuinteOrganizacional.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Protocolos / pol??ticas / procedimentos / processos", ""},
                    {"Decis??es organizacionais / cultura", ""},
                    {"Organiza????o das equipes", ""},
                    {"Recursos / carga de trabalho", ""},
            };

            for (String[] i: aux) {
                var  tipoFatorContribuinteOrganizacional =  new TipoFatorContribuinteOrganizacional();
                tipoFatorContribuinteOrganizacional.setNome(i[0]);
                tipoFatorContribuinteOrganizacional.setDescricao(i[1]);
                tipoFatorContribuinteOrganizacionalRepository.save(tipoFatorContribuinteOrganizacional);
            }

            System.out.println("cadastrei os tipos de fatores contribuintes organizacionais");
        }

        if(listaTipoFatorContribuintePaciente.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Percep????o / compreens??o", ""},
                    {"Problemas de aten????o", ""},
                    {"Fadiga / exaust??o", ""},
                    {"Excesso de confian??a", ""},
                    {"N??o cumprimento de orienta????es", ""},
                    {"Comportamento de risco", ""},
                    {"Comportamento negligente", ""},
                    {"Ato de sabotagem / criminal", ""},
                    {"Dificuldades linguisticas", ""},
                    {"Dificuldade de compreens??o das orienta????es de sa??de", ""},
                    {"Problemas com uso / abuso de subst??ncias", ""},
                    {"Fatores emocionais", ""},
            };

            for (String[] i: aux) {
                var  tipoFatorContribuintePaciente =  new TipoFatorContribuintePaciente();
                tipoFatorContribuintePaciente.setNome(i[0]);
                tipoFatorContribuintePaciente.setDescricao(i[1]);
                tipoFatorContribuintePacienteRepository.save(tipoFatorContribuintePaciente);
            }

            System.out.println("cadastrei os tipos de fatores contribuintes pacientes");
        }

        if(listaTipoFatorContribuinteProfissional.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Discuido / distra????o / omiss??o", ""},
                    {"Sobrecarga de trabalho / fadiga / esgotamento", ""},
                    {"Problema / evento adverso na execu????o do trabalho", ""},
                    {"Descumprimento de normas", ""},
                    {"Viola????o de rotinas estabelecidas pelo servi??o de sa??de", ""},
                    {"Comportamento arriscado / imprudente", ""},
                    {"Problemas com abuso de subst??ncias", ""},
                    {"Sabotagem / ato criminoso", ""},
                    {"Aus??ncia ou inadequada transmiss??o de informa????es durante a passagem de plant??o", ""},
                    {"Problema / evento adverso na compreens??o das orienta????es", "escritas ou verbais"},
                    {"Aus??ncia de anota????es", "prontu??rio / ficha do paciente"},
                    {"Informa????es ilegiveis", "prontu??rio / ficha do paciente"},
            };

            for (String[] i: aux) {
                var  tipoFatorContribuinteProfissional =  new TipoFatorContribuinteProfissional();
                tipoFatorContribuinteProfissional.setNome(i[0]);
                tipoFatorContribuinteProfissional.setDescricao(i[1]);
                tipoFatorContribuinteProfissionalRepository.save(tipoFatorContribuinteProfissional);
            }

            System.out.println("cadastrei os tipos de fatores contribuintes profissionais");
        }

        if(listaTipoFatorContribuinteTrabalho.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Infraestrutura / ambiente f??sico", ""},
                    {"Afastado ou a longa dist??ncia do servi??o", ""},
                    {"Avalia????o de risco ambiental / avalia????o de seguran??a", ""},
            };

            for (String[] i: aux) {
                var  tipoFatorContribuinteTrabalho =  new TipoFatorContribuinteTrabalho();
                tipoFatorContribuinteTrabalho.setNome(i[0]);
                tipoFatorContribuinteTrabalho.setDescricao(i[1]);
                tipoFatorContribuinteTrabalhoRepository.save(tipoFatorContribuinteTrabalho);
            }

            System.out.println("cadastrei os tipos de fatores contribuintes trabalho / ambiente");
        }

        if(listaTipoFatorAtenuanteAgente.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Medida de seguran??a / ambiente f??sico", ""},
                    {"Corrigido o erro de utiliza????o do equipamento / produto", ""},
            };

            for (String[] i: aux) {
                var  tipoFatorAtenuanteAgente =  new TipoFatorAtenuanteAgente();
                tipoFatorAtenuanteAgente.setNome(i[0]);
                tipoFatorAtenuanteAgente.setDescricao(i[1]);
                tipoFatorAtenuanteAgenteRepository.save(tipoFatorAtenuanteAgente);
            }

            System.out.println("cadastrei os tipos de fatores atenuantes agentes");
        }

        if(listaTipoFatorAtenuanteOrganizacao.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Protocolo eficaz dispon??vel", ""},
                    {"Corrigido erro de documenta????o", ""},
            };

            for (String[] i: aux) {
                var  tipoFatorAtenuanteOrganizacao =  new TipoFatorAtenuanteOrganizacao();
                tipoFatorAtenuanteOrganizacao.setNome(i[0]);
                tipoFatorAtenuanteOrganizacao.setDescricao(i[1]);
                tipoFatorAtenuanteOrganizacaoRepository.save(tipoFatorAtenuanteOrganizacao);
            }

            System.out.println("cadastrei os tipos de fatores atenuantes organizacionais");
        }

        if(listaTipoFatorAtenuantePaciente.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Pedido de ajuda", ""},
                    {"Empreendidas medidas de gest??o / tratamento / cuidado", ""},
                    {"Paciente encaminhado", ""},
                    {"Explica????o / informa????o para o paciente", ""},
                    {"Pedido de desculpas", ""},
            };

            for (String[] i: aux) {
                var  tipoFatorAtenuantePaciente =  new TipoFatorAtenuantePaciente();
                tipoFatorAtenuantePaciente.setNome(i[0]);
                tipoFatorAtenuantePaciente.setDescricao(i[1]);
                tipoFatorAtenuantePacienteRepository.save(tipoFatorAtenuantePaciente);
            }

            System.out.println("cadastrei os tipos de fatores atenuantes pacientes");
        }

        if(listaTipoFatorAtenuanteProfissional.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Boa supervis??o / lideran??a", ""},
                    {"Bom trabalho de equipe", ""},
                    {"Comunica????o efetiva", ""},
                    {"Forma????o de pessoas-chave", ""},
                    {"Boa sorte / causalidade", ""},
            };

            for (String[] i: aux) {
                var  tipoFatorAtenuanteProfissional =  new TipoFatorAtenuanteProfissional();
                tipoFatorAtenuanteProfissional.setNome(i[0]);
                tipoFatorAtenuanteProfissional.setDescricao(i[1]);
                tipoFatorAtenuanteProfissionalRepository.save(tipoFatorAtenuanteProfissional);
            }

            System.out.println("cadastrei os tipos de fatores atenuantes profissionais");
        }

        if(listaTipoAcaoMelhoriaOrganizacao.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Gest??o da m??dia / rela????es p??blica", ""},
                    {"Gest??o de reclama????es", ""},
                    {"Gest??o de a????o judicial / riscos", ""},
                    {"Gest??o do stress / acompanhamento psicol??gico para os profissionais", ""},
                    {"Notifica????o local e ideniza????o", ""},
                    {"Reconcilia????o / media????o", ""},
                    {"Mudan??a de cultura organizacional", ""},
                    {"Forma????o / treinamento", ""},
                    {"Ainda n??o foram realizadas a????es de melhoria", ""},
            };

            for (String[] i: aux) {
                var tipoAcaoMelhoriaOrganizacao  =  new TipoAcaoMelhoriaOrganizacao();
                tipoAcaoMelhoriaOrganizacao.setNome(i[0]);
                tipoAcaoMelhoriaOrganizacao.setDescricao(i[1]);
                tipoAcaoMelhoriaOrganizacaoRepository.save(tipoAcaoMelhoriaOrganizacao);
            }

            System.out.println("cadastrei os tipos de a????es de melhorias organizacionais");
        }

        if(listaTipoAcaoMelhoriaPaciente.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Gest??o da doen??a", ""},
                    {"Gest??o da les??o", ""},
                    {"Gest??o da incapacidade", ""},
                    {"Compensa????o", ""},
                    {"Releva????o / desculpa p??blica", ""},
                    {"Gest??o da doen??a", ""},
                    {"Ainda n??o foram realizadas a????es de melhoria", ""},
            };

            for (String[] i: aux) {
                var  tipoAcaoMelhoriaPaciente =  new TipoAcaoMelhoriaPaciente();
                tipoAcaoMelhoriaPaciente.setNome(i[0]);
                tipoAcaoMelhoriaPaciente.setDescricao(i[1]);
                tipoAcaoMelhoriaPacienteRepository.save(tipoAcaoMelhoriaPaciente);
            }

            System.out.println("cadastrei os tipos de a????es de melhorias do paciente");
        }

        if(listaTipoAcaoReduzirRiscoOrganizacional.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Ambiente f??sico adequado ??s necessidades", ""},
                    {"Providenciar acesso a um servi??o", ""},
                    {"Efetuar avalia????es de risco / an??lise de causa-raiz", ""},
                    {"Cumprir c??digos / especifica????es / regulamentos", ""},
                    {"Disponibilizar o r??pido acesso a protocolos / politicas / apoio ?? decis??o", ""},
                    {"Melhoia de lideran??a / orienta????o", ""},
                    {"Adequa????o dos profissionais ??s tarefas / aptid??es", ""},
                    {"Melhoria da cultura de seguran??a", ""},

            };

            for (String[] i: aux) {
                var  tipoAcaoReduzirRiscoOrganizacional =  new TipoAcaoReduzirRiscoOrganizacional();
                tipoAcaoReduzirRiscoOrganizacional.setNome(i[0]);
                tipoAcaoReduzirRiscoOrganizacional.setDescricao(i[1]);
                tipoAcaoReduzirRiscoOrganizacionalRepository.save(tipoAcaoReduzirRiscoOrganizacional);
            }

            System.out.println("cadastrei os tipos de a????es para reduzir riscos organizacionais");
        }

        if(listaTipoAcaoReduzirRiscoPaciente.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Disponibiliza????o de cuidados / apoio adequado", ""},
                    {"Disponibiliza????o de instru????o / orienta????es para o paciente", ""},
                    {"Disponibiliza????o de protocolos de apoio ?? decis??o", ""},
                    {"Disponibiliza????o de equipamento de monitoriza????o", ""},
                    {"Disponibiliza????o de sistema de ajuda e dispensa????o da medica????o", ""},

            };

            for (String[] i: aux) {
                var  tipoAcaoReduzirRiscoPaciente =  new TipoAcaoReduzirRiscoPaciente();
                tipoAcaoReduzirRiscoPaciente.setNome(i[0]);
                tipoAcaoReduzirRiscoPaciente.setDescricao(i[1]);
                tipoAcaoReduzirRiscoPacienteRepository.save(tipoAcaoReduzirRiscoPaciente);
            }

            System.out.println("cadastrei os tipos de a????es para reduzir riscos do paciente");
        }

        if(listaTipoAcaoReduzirRiscoProfissional.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Forma????o", ""},
                    {"Orienta????o", ""},
                    {"Supervis??o / assist??ncia", ""},
                    {"Estrat??gias para gest??o da fadiga", ""},
                    {"Disponibilidade de checkilist / protocolos / pol??ticas", ""},
                    {"N??mero de profissionais adequado ?? demanda", ""},
            };

            for (String[] i: aux) {
                var  tipoAcaoReduzirRiscoProfissional =  new TipoAcaoReduzirRiscoProfissional();
                tipoAcaoReduzirRiscoProfissional.setNome(i[0]);
                tipoAcaoReduzirRiscoProfissional.setDescricao(i[1]);
                tipoAcaoReduzirRiscoProfissionalRepository.save(tipoAcaoReduzirRiscoProfissional);
            }

            System.out.println("cadastrei os tipos de a????es para reduzir riscos profissionais");
        }

        return;
    }

}
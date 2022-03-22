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
                    {"Admissão no serviço de saúde", ""},
                    {"Falha na assistência radiológica", ""},
                    {"Falhas no cuidado / proteção do paciente", ""},
                    {"Falhas no cuidado / proteção do paciente", ""},
                    {"Falta de identificação no leito do paciente", ""},
                    {"Falta de pulseiras de identificação", ""},
                    {"Incidente / evento adverso durante procedimento cirúrgico", ""},
                    {"Infecção hospitalar no local da cirurgia", ""},
                    {"Infecções hospitalar como pneumonia", ""},
                    {"Infecções relacionadas à assistência à saúde", ""},
                    {"Lesão por dispositivo médico", "feridas na pele provocadas por contato prolongado com dispositivo médico"},
                    {"Lesão por pressão", "feridas na pele provocadas pelo tempo prolongado sentado ou deitado"},
                    {"Incidente / evento adverso na identificação do paciente", ""},
                    {"Incidente / evento adverso nas atividades administrativas", ""},
                    {"Incidente / evento adverso ocorridas em laboratórios clínicos ou de patologia", ""},
                    {"Incidente / evento adverso na administração de dietas infecção hospitalar causada pelo cateter colocado na veia", ""},
                    {"Infecção hospitalar como infecção urinária", ""},
                    {"Problema /evento adverso relacionado ao enxerto (osso, pele ou outros) fertilização", ""},
                    {"Problema / evento adverso relacionado ao uso de medicamentos", ""},
                    {"Problema / evento adverso relacionado ao uso de sangue", ""},
                    {"Problema / evento adverso relacionado ao uso de sangue / hemocomponente", ""},
                    {"Problemas / eventos adversos associados a equipamento médico-hospitalar", ""},
                    {"Problemas / eventos adversos associados a produtos para a saúde: artigo / material médico-hospitalar", ""},
                    {"Queda do paciente", ""},
                    {"Transferência para outros serviços de saúde", ""},
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
                    {"Incidente sem dano", "evento que atingiu o paciente, mas não causou dano"},
                    {"Near miss", "incidente que não atingiu o paciente"},
                    {"Circunstância notificável", "Não ocorreu um acidente, mas sim um evento expressivo para o dano do paciente"}
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
                {"LEVE", "O paciente apresentou sintomas leves, danos mínimos ou intermediários de curta duração"},
                {"MODERADO", "O paciente necessitou de intervenção, prolongamento da internação, perda de função"},
                {"GRAVE", "Foi necessária intervenção para salvar a vida, grande intervenção médico-cirúrgica ou casou grandes danos permanentes"},
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
                {"Durante a fase de diagnóstico", "exames laboratoriais ou de imagem e consultas médicas"},
                {"Durante a fase de prestação dos cuidados, o tratamento ou a cirurgia", ""},
                {"Durante ou após a fase de doação de sangue", ""},
                {"Na fase de admissão ou no acesso ao serviço de saúde", ""},
                {"Na fase de alta", ""},
                {"Na fase de transferência interna entre setores", ""},
                {"Na fase de transferência para outra instituição ou serviço", ""},
                {"Na fase do acompanhamento pós-alta", ""},
                {"Não estava internado", ""}
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
                    {"1º ANDAR", ""},
                    {"2º ANDAR", ""},
                    {"2ª SEÇÃO", ""},
                    {"ALMOXARIFADO", ""},
                    {"AMBULATÓRIO", ""},
                    {"CENTRO CIRURGICO", ""},
                    {"CME", "CENTRO DE MATERIAL E ESTERILIZAÇÃO"},
                    {"CONTAS MÉDICAS", ""},
                    {"CONTIGENTE", ""},
                    {"CORPO DA GUARDA", ""},
                    {"BLOCO ADMINISTRATIVO", ""},
                    {"FARMÁCIA", ""},
                    {"FARNÁCIA", "CENTRO CIRURGICO"},
                    {"FARMÁCIA SATÉLITE", ""},
                    {"FISIOTERAPIA", ""},
                    {"FUSEX", ""},
                    {"GARAGEM", "SETOR DE NANUTENÇÃO E TRANSPORTE"},
                    {"LABORATÓRIO DE ANÁLISES CLÍNICAS", ""},
                    {"NUTRIÇÃO", ""},
                    {"ODONTOLOGIA", ""},
                    {"PAD", "PROGRAMA DE ACOMPANHAMENTO DOMICILIAR"},
                    {"PRONTO ATENDIMENTO MÉDICO", ""},
                    {"RADIOLOGIA", ""},
                    {"SEÇÃO DE AUDITORIA DE LISURA", ""},
                    {"SEÇÃO DE INFORMÁTICA", ""},
                    {"SEÇÃO DE PERÍCIAS MÉDICAS", ""},
                    {"SERVIÇO DE APROVISIONAMENTO", ""},
                    {"SETOR DE ENDOSCOPIA", ""},
                    {"UMITI", "UNIDADE MILITAR INTEGRADA DE TERAPIA INTENSIVA"},
                    {"UPRSS", "UNIDADE DE PROCESSAMENTO DE ROUPAS DE SERVIÇOS DE SAÚDE"},
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
                    {"Houve Lesão Permanente", ""},
                    {"Houve Lesão Temporária", ""},
                    {"Não Houve Lesão", ""}
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
                    {"Identificação pró-ativa de riscos", ""},
                    {"Por meio de máquina / sistema / alteração ambiental / alarme", ""},
                    {"Por meio de uma contagem / auditoria / revisão", ""},
                    {"Reconhecimento do erro", ""},
                    {"Por alteração do estado do paciente", ""}
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
                    {"Próprio paciente", ""},
                    {"Outro paciente", ""},
                    {"Familiar", ""},
                    {"Cuidador", ""},
                    {"Voluntário", ""},
                    {"Amiga / Visitante", ""},
                    {"Pessoa de assistência espiritual", ""},
                    {"Profissional de saúde", ""},
                    {"Outro profissional do serviço de saúde", ""},
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
                    {"Dano à propriedade", ""},
                    {"Aumento dos recursos necessários para o paciente", ""},
                    {"Atenção da mídia", ""},
                    {"Reclamação formal", ""},
                    {"Reputação denegrida", ""},
                    {"Implicações legais", ""}
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
                    {"Percepção / compreensão", ""},
                    {"Resolução de problemas baseada em conhecimento", ""},
                    {"Correlação ilusória", "associação incorreta entre duas variáveis ou classe de acontecimentos"},
                    {"Efeito de Halo", "tendeência a qualificar o indivíduo de forma equivocada devido a uma informação prévia ou impressão geral que se tenha do indivíduo"},
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
                    {"Problemas de atenção", ""},
                    {"Fadiga / exaustão", ""},
                    {"Excesso de confiança", ""},
                    {"Não cumprimento de normas / protocolos", ""},
                    {"Infrações sistemáticas", ""},
                    {"Problemas de atenção", ""},
                    {"Comportamento de risco", ""},
                    {"Comportamento negligente", ""},
                    {"Ato de sabotagem / criminal", ""},
                    {"Problemas com uso / abuso de substâncias", ""},
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
                    {"Método de comunicação", ""},
                    {"Ausência ou inadequada transmissão de informações durante a passagem de plantão", ""},
                    {"Problema / evento adverso na compreensão das orientações", "escritas ou verbais"},
                    {"Ausência de anotações", "prontuário / ficha do paciente"},
                    {"Informações ilegiveis", "prontuário / ficha do paciente"},
                    {"Dificuldades linguisticas", ""},
                    {"Literacia em saúde", "capacidade de compreender a informação de saúde e usar essa informação para tomar decisões sobre a saúde e cuidados médicos"},
            };

            for (String[] i: aux) {
                var  tipoFatorContribuinteComunicacao =  new TipoFatorContribuinteComunicacao();
                tipoFatorContribuinteComunicacao.setNome(i[0]);
                tipoFatorContribuinteComunicacao.setDescricao(i[1]);
                tipoFatorContribuinteComunicacaoRepository.save(tipoFatorContribuinteComunicacao);
            }

            System.out.println("cadastrei os tipos de fatores contribuintes comunicações");
        }

        if(listaTipoFatorContribuinteDesenpenho.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Erro técnico na execução", "baseado na aptidão física"},
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
                    {"Protocolos / políticas / procedimentos / processos", ""},
                    {"Decisões organizacionais / cultura", ""},
                    {"Organização das equipes", ""},
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
                    {"Percepção / compreensão", ""},
                    {"Problemas de atenção", ""},
                    {"Fadiga / exaustão", ""},
                    {"Excesso de confiança", ""},
                    {"Não cumprimento de orientações", ""},
                    {"Comportamento de risco", ""},
                    {"Comportamento negligente", ""},
                    {"Ato de sabotagem / criminal", ""},
                    {"Dificuldades linguisticas", ""},
                    {"Dificuldade de compreensão das orientações de saúde", ""},
                    {"Problemas com uso / abuso de substâncias", ""},
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
                    {"Discuido / distração / omissão", ""},
                    {"Sobrecarga de trabalho / fadiga / esgotamento", ""},
                    {"Problema / evento adverso na execução do trabalho", ""},
                    {"Descumprimento de normas", ""},
                    {"Violação de rotinas estabelecidas pelo serviço de saúde", ""},
                    {"Comportamento arriscado / imprudente", ""},
                    {"Problemas com abuso de substâncias", ""},
                    {"Sabotagem / ato criminoso", ""},
                    {"Ausência ou inadequada transmissão de informações durante a passagem de plantão", ""},
                    {"Problema / evento adverso na compreensão das orientações", "escritas ou verbais"},
                    {"Ausência de anotações", "prontuário / ficha do paciente"},
                    {"Informações ilegiveis", "prontuário / ficha do paciente"},
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
                    {"Infraestrutura / ambiente físico", ""},
                    {"Afastado ou a longa distância do serviço", ""},
                    {"Avaliação de risco ambiental / avaliação de segurança", ""},
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
                    {"Medida de segurança / ambiente físico", ""},
                    {"Corrigido o erro de utilização do equipamento / produto", ""},
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
                    {"Protocolo eficaz disponível", ""},
                    {"Corrigido erro de documentação", ""},
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
                    {"Empreendidas medidas de gestão / tratamento / cuidado", ""},
                    {"Paciente encaminhado", ""},
                    {"Explicação / informação para o paciente", ""},
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
                    {"Boa supervisão / liderança", ""},
                    {"Bom trabalho de equipe", ""},
                    {"Comunicação efetiva", ""},
                    {"Formação de pessoas-chave", ""},
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
                    {"Gestão da mídia / relações pública", ""},
                    {"Gestão de reclamações", ""},
                    {"Gestão de ação judicial / riscos", ""},
                    {"Gestão do stress / acompanhamento psicológico para os profissionais", ""},
                    {"Notificação local e idenização", ""},
                    {"Reconciliação / mediação", ""},
                    {"Mudança de cultura organizacional", ""},
                    {"Formação / treinamento", ""},
                    {"Ainda não foram realizadas ações de melhoria", ""},
            };

            for (String[] i: aux) {
                var tipoAcaoMelhoriaOrganizacao  =  new TipoAcaoMelhoriaOrganizacao();
                tipoAcaoMelhoriaOrganizacao.setNome(i[0]);
                tipoAcaoMelhoriaOrganizacao.setDescricao(i[1]);
                tipoAcaoMelhoriaOrganizacaoRepository.save(tipoAcaoMelhoriaOrganizacao);
            }

            System.out.println("cadastrei os tipos de ações de melhorias organizacionais");
        }

        if(listaTipoAcaoMelhoriaPaciente.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Gestão da doença", ""},
                    {"Gestão da lesão", ""},
                    {"Gestão da incapacidade", ""},
                    {"Compensação", ""},
                    {"Relevação / desculpa pública", ""},
                    {"Gestão da doença", ""},
                    {"Ainda não foram realizadas ações de melhoria", ""},
            };

            for (String[] i: aux) {
                var  tipoAcaoMelhoriaPaciente =  new TipoAcaoMelhoriaPaciente();
                tipoAcaoMelhoriaPaciente.setNome(i[0]);
                tipoAcaoMelhoriaPaciente.setDescricao(i[1]);
                tipoAcaoMelhoriaPacienteRepository.save(tipoAcaoMelhoriaPaciente);
            }

            System.out.println("cadastrei os tipos de ações de melhorias do paciente");
        }

        if(listaTipoAcaoReduzirRiscoOrganizacional.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Ambiente físico adequado às necessidades", ""},
                    {"Providenciar acesso a um serviço", ""},
                    {"Efetuar avaliações de risco / análise de causa-raiz", ""},
                    {"Cumprir códigos / especificações / regulamentos", ""},
                    {"Disponibilizar o rápido acesso a protocolos / politicas / apoio á decisão", ""},
                    {"Melhoia de liderança / orientação", ""},
                    {"Adequação dos profissionais às tarefas / aptidões", ""},
                    {"Melhoria da cultura de segurança", ""},

            };

            for (String[] i: aux) {
                var  tipoAcaoReduzirRiscoOrganizacional =  new TipoAcaoReduzirRiscoOrganizacional();
                tipoAcaoReduzirRiscoOrganizacional.setNome(i[0]);
                tipoAcaoReduzirRiscoOrganizacional.setDescricao(i[1]);
                tipoAcaoReduzirRiscoOrganizacionalRepository.save(tipoAcaoReduzirRiscoOrganizacional);
            }

            System.out.println("cadastrei os tipos de ações para reduzir riscos organizacionais");
        }

        if(listaTipoAcaoReduzirRiscoPaciente.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Disponibilização de cuidados / apoio adequado", ""},
                    {"Disponibilização de instrução / orientações para o paciente", ""},
                    {"Disponibilização de protocolos de apoio á decisão", ""},
                    {"Disponibilização de equipamento de monitorização", ""},
                    {"Disponibilização de sistema de ajuda e dispensação da medicação", ""},

            };

            for (String[] i: aux) {
                var  tipoAcaoReduzirRiscoPaciente =  new TipoAcaoReduzirRiscoPaciente();
                tipoAcaoReduzirRiscoPaciente.setNome(i[0]);
                tipoAcaoReduzirRiscoPaciente.setDescricao(i[1]);
                tipoAcaoReduzirRiscoPacienteRepository.save(tipoAcaoReduzirRiscoPaciente);
            }

            System.out.println("cadastrei os tipos de ações para reduzir riscos do paciente");
        }

        if(listaTipoAcaoReduzirRiscoProfissional.isEmpty()){
            String[][] aux = {
                    {"", ""},
                    {"Formação", ""},
                    {"Orientação", ""},
                    {"Supervisão / assistência", ""},
                    {"Estratégias para gestão da fadiga", ""},
                    {"Disponibilidade de checkilist / protocolos / políticas", ""},
                    {"Número de profissionais adequado á demanda", ""},
            };

            for (String[] i: aux) {
                var  tipoAcaoReduzirRiscoProfissional =  new TipoAcaoReduzirRiscoProfissional();
                tipoAcaoReduzirRiscoProfissional.setNome(i[0]);
                tipoAcaoReduzirRiscoProfissional.setDescricao(i[1]);
                tipoAcaoReduzirRiscoProfissionalRepository.save(tipoAcaoReduzirRiscoProfissional);
            }

            System.out.println("cadastrei os tipos de ações para reduzir riscos profissionais");
        }

        return;
    }

}
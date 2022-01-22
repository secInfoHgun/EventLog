package com.hgun.sti.components;

import com.hgun.sti.models.types.*;
import com.hgun.sti.models.types.identificacao.*;
import com.hgun.sti.repository.types.*;
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

        if(listaTipoOcorrencia.isEmpty()){
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
                {"Troca de nome dos pacientes", ""}
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
                {"Near miss", "incidente que não atingiu o paciente"}
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

        return;
    }

}
package com.hgun.sti.components;

import com.hgun.sti.models.types.*;
import com.hgun.sti.repository.types.*;
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

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        var listaTipoOcorrencia = tipoOcorrenciaRepository.findAll();
        var listaTipoIncidencia = tipoIncidenciaRepository.findAll();
        var listaTipoDano = tipoDanoRepository.findAll();
        var listaTipoFaseAssistencia = tipoFaseAssistenciaRepository.findAll();
        var listaSetor = tipoSetorRepository.findAll();

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

        if(listaSetor.isEmpty()){
            String[][] aux = {
                    {"1º ANDAR", ""},
                    {"2º ANDAR", ""},
                    {"3º ANDAR ALA SUL", ""},
                    {"4º ANDAR ALA NORTE", ""},
                    {"4º ANDAR ALA SUL", ""},
                    {"2ª SEÇÃO", ""},
                    {"AGENCIA TRANSFUSIONAL", ""},
                    {"ALMOXARIFADO", ""},
                    {"AMBULATÓRIO", ""},
                    {"BIBLIOTECA", ""},
                    {"BUCO MAXILO FACIAL", "OTORRINO"},
                    {"CARDIOLOGIA", ""},
                    {"CCIH", "CENTRO DE CONTROLE DE INFECÇÃO HOSPITALAR"},
                    {"CENTRO CIRURGICO", ""},
                    {"CHEFIA ENFERMAGEM", ""},
                    {"CME", "CENTRO DE MATERIAL E ESTERILIZAÇÃO"},
                    {"COMISÃO DE PRONTUÁRIOS", ""},
                    {"CONTAS MÉDICAS", ""},
                    {"CONTIGENTE", ""},
                    {"CONTROLADORIA E GESTÃO", "PEG"},
                    {"CORPO DA GUARDA", ""},
                    {"CIREÇÃO", ""},
                    {"DIVISÃO DE APOIO ADMINISTRATIVO", ""},
                    {"DIVISÃO DE MEDICINA", ""},
                    {"ECOGRAFIA", ""},
                    {"FAEX", "FARMÁCIA AMBULATORIAL DO EXÉRCITO"},
                    {"FARMÁCIA", ""},
                    {"FARMÁCIA", "CENTRAL"},
                    {"FARNÁCIA", "CENTRO CIRURGICO"},
                    {"FARMÁCIA SATÉLITE", ""},
                    {"FISCALIZAÇÃO ADMINISTRATIVA", ""},
                    {"FISIOTERAPIA", ""},
                    {"FUSEX", ""},
                    {"GARAGEM", "SETOR DE NANUTENÇÃO E TRANSPORTE"},
                    {"HEMODINAMICA", ""},
                    {"HOME CARE", ""},
                    {"HOTELARIA", ""},
                    {"INSPETORIA DE SAÚDE DO CMS", ""},
                    {"LABORATÓRIO DE ANÁLISES CLÍNICAS", ""},
                    {"LIMPEZA GERAL", "LIDERANÇA"},
                    {"MANIPULAÇÃO", ""},
                    {"MATERNIDADE", "NUCELO DE SAÚDE DA MULHER"},
                    {"NUTRIÇÃO", ""},
                    {"ODONTOLOGIA", ""},
                    {"OFTALMOLOGIA", ""},
                    {"OTORRINOLARINGOLOGIA", ""},
                    {"OUVIDORIA", ""},
                    {"PAD", "PROGRAMA DE ACOMPANHAMENTO DOMICILIAR"},
                    {"PORTARIA", ""},
                    {"PRONTO ATENDIMENTO MÉDICO", ""},
                    {"PSIQUIATRIA", ""},
                    {"QUIMIOTERAPIA", ""},
                    {"RADIOLOGIA", ""},
                    {"RELAÇÕES PÚBLICAS", ""},
                    {"ROUPARIA GERAL", ""},
                    {"S1", "SETOR DE PESSOAL MILITAR"},
                    {"S3", "SETOR DE OPERAÇÕES"},
                    {"SALA DE RECUPERAÇÃO", "CENTRO CIRURGICO"},
                    {"SAME", ""},
                    {"SAME", "INTERNAÇÃO"},
                    {"SEÇÃO DE AUDITORIA DE LISURA", ""},
                    {"SEÇÃO DE COMANDO DO CONTINGENTE", ""},
                    {"SEÇÃO DE INFORMÁTICA", "A MELHOR DAS MELHORES, A MAIS OPERACIONAL DO HGuN"},
                    {"SEÇÃO DE PERÍCIAS MÉDICAS", "JUNTA"},
                    {"SEÇÃO ORÇAMENTÁRIA", ""},
                    {"SECRETARIA", ""},
                    {"SERVIÇO DE ANESTESIA", ""},
                    {"SERVIÇO DE APROVISIONAMENTO", ""},
                    {"SERVIÇO DE PSICOLOGIA", ""},
                    {"SERVIÇO DE UROLOGIA", ""},
                    {"SERVIÇO SOCIAL", ""},
                    {"SERVIÇOS GERAIS", ""},
                    {"SETOR DE AQUISIÇÃO", ""},
                    {"SETOR DE CONTRATOS DE SAÚDE", ""},
                    {"SETOR DE ENDOSCOPIA", ""},
                    {"SETOR DE LICITAÇÃO", ""},
                    {"SETOR DE NEUROLOGIA", ""},
                    {"SETOR DE OTORRINOLARINGOLOGIA", ""},
                    {"SETOR DE PAGAMENTOS DO PESSOAL MILITAR", ""},
                    {"SETOR DE PERÍCIAS MÉDICAS", ""},
                    {"SETOR DE PESSOAL CIVIL", ""},
                    {"SETOR FINANCEIRO", "TESOURARIA E CONTADORIA"},
                    {"SUB-DIREÇÃO", ""},
                    {"SUBTENENCIA", ""},
                    {"SUPORTE DOCUMENTAL", ""},
                    {"TRAUMATOLOGIA", ""},
                    {"UMITI", "UNIDADE MILITAR INTEGRADA DE TERAPIA INTENSIVA"},
                    {"UNIDADE DE PEQUENAS CIRURGIAS", ""},
                    {"UNIDADE PAM", "LEITOS"},
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

        return;
    }

}
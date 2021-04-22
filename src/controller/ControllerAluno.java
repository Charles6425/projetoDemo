package controller;

import model.ModelAluno;
import DAO.DAOAluno;
import relatorios.DAORelatorios;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Charles
 */
public class ControllerAluno {

    private DAOAluno daoAluno = new DAOAluno();
    private DAORelatorios dAORelatorios = new DAORelatorios();

    /**
     * grava Aluno
     *
     * @param pModelAluno return int
     */
    public int salvarAlunoController(ModelAluno pModelAluno) {
        return this.daoAluno.salvarAlunoDAO(pModelAluno);
    }

    public int salvarGeralController(ModelAluno pModelAluno) {
        return this.daoAluno.salvarCadGeralDAO(pModelAluno);
    }

    /**
     * recupera Aluno
     *
     * @param pId return ModelAluno
     */
    public ModelAluno getAlunoController(int pId) {
        return this.daoAluno.getAlunoDAO(pId);
    }

    public ModelAluno getGeralController(int pId) {
        return this.daoAluno.getGeralDAO(pId);
    }

    /**
     * recupera Aluno
     *
     * @param pId return ModelAluno
     *
     *
     * /**
     * recupera uma lista deAluno
     *
     * @param pId return ArrayList
     */
    public ArrayList<ModelAluno> getListaAlunoController() {
        return this.daoAluno.getListaAlunoDAO();
    }

    /**
     * recupera uma lista deAluno
     *
     * @param pId return ArrayList
     */
    public ArrayList<ModelAluno> getListaGeralController() {
        return this.daoAluno.getListaGeralDAO();
    }

    /**
     * recupera uma lista deAluno
     *
     * @param pId return ArrayList
     */
    public ArrayList<ModelAluno> getListaEncSemController(int pSituacao, int pTurma, String pNascimento, String pNascimentoFim, String pSexo, String pBairro) {
        return this.daoAluno.getListaEncSemDAO(pSituacao, pTurma, pNascimento, pNascimentoFim, pSexo, pBairro);
    }

    public ArrayList<ModelAluno> getListaEncSemTurmaController(int pSituacao, String pNascimento, String pNascimentoFim, String pSexo, String pBairro) {
        return this.daoAluno.getListaEncSemTurmaDAO(pSituacao, pSituacao, pNascimento, pNascimentoFim, pSexo, pBairro);
    }

    public ArrayList<ModelAluno> getListaTodosBairrosController(int pSituacao, int pTurma, String pNascimento, String pNascimentoFim, String pSexo) {
        return this.daoAluno.getListaTodosBairrosDAO(pSituacao, pTurma, pNascimento, pNascimentoFim, pSexo);
    }

    public ArrayList<ModelAluno> getListaEncSemSexoController(int pSituacao, int pTurma, String pNascimento, String pNascimentoFim, String pBairro) {
        return this.daoAluno.getListaEncSemSexoDAO(pSituacao, pTurma, pNascimento, pNascimentoFim, pBairro);
    }

    public ArrayList<ModelAluno> getListaTodosSexosBairrosController(int pSituacao, int pTurma, String pNascimento, String pNascimentoFim) {
        return this.daoAluno.getTodosSexosBairrosDAO(pSituacao, pTurma, pNascimento, pNascimentoFim);
    }

    public ArrayList<ModelAluno> getListaTodosSexosBairrosTurmaController(int pSituacao, String pNascimento, String pNascimentoFim) {
        return this.daoAluno.getTodosSexosBairrosTurmaDAO(pSituacao, pNascimento, pNascimentoFim);
    }

    public boolean getListaRelatorioPorAss(String pSala) {
        return this.daoAluno.gerarRelatorioAssPorSala(pSala);
    }

    public boolean gerarRelatorioAssPorTurma(String pSala) {
        return this.daoAluno.gerarRelatorioAssPorTurma(pSala);

    }
//Preparatorio e aprendizagem
    public boolean gerarRelatorioPreparatorioSala(String pSala) {
        return this.daoAluno.gerarRelatorioPreparatorioSala(pSala);
    }
    public boolean gerarRelatorioPreparatorioTurma(String pSala) {
        return this.daoAluno.gerarRelatorioPreparatorioTurma(pSala);
    }

    public boolean gerarRelatorioPreparatorioGeral(String pSala, String pTurma) {
        return this.daoAluno.gerarRelatorioPreparatorioGeral(pSala, pTurma);
    }
 

    public boolean gerarRelatoriopreparatorioAssSala(String pSala) {
        return this.daoAluno.gerarRelatorioPreparatorioAssSala(pSala);
    }
    public boolean gerarRelatoriopreparatorioAssTurma(String pSala) {
        return this.daoAluno.gerarRelatorioPreparatorioAssTurma(pSala);
    }

    public boolean gerarRelatoriopreparatorioAssGeral(String pSala, String pTurma) {
        return this.daoAluno.gerarRelatorioPreparatorioAssGeral(pSala, pTurma);
    }
 

    public boolean gerarRelatorioAprendizagemSala(String pSala) {
        return this.daoAluno.gerarRelatorioAprendizagemSala(pSala);
    }
    public boolean gerarRelatorioAprendizagemGeral(String pSala, String pTurma) {
        return this.daoAluno.gerarRelatorioAprendizagemGeral(pSala,pTurma);
    }
    public boolean gerarRelatorioAprendizagemTurma(String pSala) {
        return this.daoAluno.gerarRelatorioAprendizagemTurma(pSala);
    }
  
    public boolean gerarRelatorioAprendizagemAssSala(String pSala) {
        return this.daoAluno.gerarRelatorioAprendizagemAssSala(pSala);
    }
 
    public boolean gerarRelatorioAprendizagemAssTurma(String pSala) {
        return this.daoAluno.gerarRelatorioAprendizagemAssTurma(pSala);
    }
    public boolean gerarRelatorioAprendizagemAssGeral(String pSala, String pTurma) {
        return this.daoAluno.gerarRelatorioAprendizagemAssGeral(pSala, pTurma);
    }
    
    

    public boolean gerarRelatorioListaChamadaSala(String pSala) {
        return this.daoAluno.gerarRelatorioListaChamadaSala(pSala);
    }
    public boolean gerarRelatorioListaChamadaTurma(String pSala) {
        return this.daoAluno.gerarRelatorioListaChamadaTurma(pSala);
    }
    public boolean gerarRelatorioListaChamadaAmbos(String pSala, String pTurma) {
        return this.daoAluno.gerarRelatorioListaChamadaAmbos(pSala, pTurma);
    }

    public boolean gerarRelatorioOcorrenciaSala(String pSala) {
        return this.daoAluno.gerarRelatorioOcorrenciaSala(pSala);
    }
    public boolean gerarRelatorioOcorrenciaTurma(String pSala) {
        return this.daoAluno.gerarRelatorioOcorrenciaTurma(pSala);
    }
    public boolean gerarRelatorioOcorrenciaAmbos(String pSala, String pTurma) {
        return this.daoAluno.gerarRelatorioOcorrenciaAmbos(pSala, pTurma);
    }

    public boolean gerarRelatorioAdvertenciaSala(int pSala) {
        return this.daoAluno.gerarRelatorioAdvertenciaSala(pSala);
    }

    public boolean gerarRelatorioDeclaracao(int pSala) {
        return this.daoAluno.gerarRelatorioDeclaracao(pSala);
    }

    public boolean gerarRelatorioAvaliacaoSala(String pSala) {
        return this.daoAluno.gerarRelatorioAvaliacaoSala(pSala);
    }
    public boolean gerarRelatorioAvaliacaoTurma(String pSala) {
        return this.daoAluno.gerarRelatorioAvaliacaoTurma(pSala);
    }
    public boolean gerarRelatorioAvaliacaoAmbos(String pSala, String pTurma) {
        return this.daoAluno.gerarRelatorioAvaliacaoAmbos(pSala, pTurma);
    }
    
    public boolean gerarRelatorioVersoCertificado(int pCodigo) {
        return this.daoAluno.gerarRelatorioVersoCertificado(pCodigo);
    }
    public boolean gerarRelatorioCertificadoAprendiz(int pCodigo) {
        return this.daoAluno.gerarRelatorioCertificadoAprendiz(pCodigo);
    }
    public boolean gerarRelatorioCertificadoAspirante(int pCodigo, int pAluno) {
        return this.daoAluno.gerarRelatorioCertificadoAspirante(pCodigo, pAluno);
    }
    
    
    public boolean gerarRelatorioAvaliacaoInstitucionalSala(String pCodigo) {
        return this.daoAluno.gerarRelatorioAvaliacaoInstitucionalSala(pCodigo);
    }

    public boolean gerarRelatorioAprendizagemTeorica(int pCodigo, int pAluno) {
        return this.daoAluno.gerarRelatorioAprendizagemTeorica(pCodigo, pAluno);
    }
    public boolean gerarRelatorioListaPresencaDiaria(int pTurma) {
        return this.daoAluno.gerarRelatorioListaPresencaDiaria(pTurma);
    }

    /**
     * atualiza Aluno
     *
     * @param pModelAluno return boolean
     */
    public boolean atualizarAlunoController(ModelAluno pModelAluno) {
        return this.daoAluno.atualizarAlunoDAO(pModelAluno);
    }

    /**
     * atualiza Geral
     *
     * @param pModelAluno return boolean
     */
    public boolean atualizarGeralController(ModelAluno pModelAluno) {
        return this.daoAluno.atualizarGeralDAO(pModelAluno);
    }

    public boolean gerarRelatorioEncaminhamento(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioEncaminhamento(pCodigo);

    }

    public boolean gerarRelatorioSaida(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioSaida(pCodigo);

    }

    public boolean gerarRelatorioContrato411005(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioContrato411005(pCodigo);
    }

    public boolean gerarRelatorioFichaMatrAuxAdm(int pCodigo) {
        return this.dAORelatorios.gerarFichaMatAuxAdm(pCodigo);

    }

    public boolean gerarRelatorioFichaMatrAuxAdm2(int pCodigo) {
        return this.dAORelatorios.gerarFichaMatAux2(pCodigo);

    }

    public boolean gerarRelatorioFichaMatrAssistAdm(int pCodigo) {
        return this.dAORelatorios.gerarFichaMatAssAdm(pCodigo);

    }

    public boolean gerarRelatorioFichaMatrAssistAdm2(int pCodigo) {
        return this.dAORelatorios.gerarFichaMatAss2(pCodigo);

    }

    public boolean gerarRelatorioFichaMatrComercio2(int pCodigo) {
        return this.dAORelatorios.gerarFichaMatComercio2(pCodigo);

    }

    public boolean gerarRelatorioFichaMatrAlimentador2(int pCodigo) {
        return this.dAORelatorios.gerarFichaMatAlimentador2(pCodigo);

    }

    public boolean gerarRelatorioFichaMatrComercio(int pCodigo) {
        return this.dAORelatorios.gerarFichaMatComercio(pCodigo);

    }

    public boolean gerarRelatorioFichaMatrAlimentador(int pCodigo) {
        return this.dAORelatorios.gerarFichaMatAlimentador(pCodigo);

    }

    public boolean gerarRelatorioFichaMatrArco(int pCodigo) {
        return this.dAORelatorios.gerarFichaMatArco(pCodigo);

    }

    public boolean gerarRelatorioFichaMatrArco2(int pCodigo) {
        return this.dAORelatorios.gerarFichaMatArco2(pCodigo);

    }

    public boolean gerarRelatorioFichaRegistro(int pCodigo) {
        return this.dAORelatorios.gerarFichaRegistro(pCodigo);

    }

    public boolean gerarRelatorioContratoBanco(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioContratoBanco(pCodigo);

    }

    /**
     * exclui Aluno
     *
     * @param pId return boolean
     */
    public boolean excluirAlunoController(int pId) {
        return this.daoAluno.excluirAlunoDAO(pId);
    }
}

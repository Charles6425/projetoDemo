/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Arrays;
import java.util.List;
import view.ViewAluno;

/**
 *
 * @author charles
 */
public class FolhaPagamento {

   
    

    /**
     * Charles Müller
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        List<FaixaIRPF> faixas = Arrays.asList(
                new FaixaIRPF(0.0, 0.0, 1499.15),
                new FaixaIRPF(7.5, 1499.16, 2246.75),
                new FaixaIRPF(15.0, 2246.76, 2995.70),
                new FaixaIRPF(22.5, 2995.70, 3743.19),
                new FaixaIRPF(27.5, 3743.20, Double.MAX_VALUE));

        Double salario = 900.0;

        Double salarioAux = 900.0;
        Double imposto = 0.0;
        for (FaixaIRPF faixa : faixas) {

            if (faixa.getAliquota() == 0.0) {

                salarioAux -= faixa.getValorFinal();
                continue;
            }

            Double valorCalculo = salarioAux;
            if (salario > faixa.getValorFinal()) {

                valorCalculo = faixa.getValorFinal() - faixa.getValorInicio();
            }

            imposto += ((valorCalculo / 100) * faixa.getAliquota());
            salarioAux -= valorCalculo;

            if (faixa.getValorFinal() > salario) {
                break;
            }
        }
       
        System.out.println("Valor imposto: " + imposto);
        System.out.println("Salario sem IRPF: " + (salario - imposto));

    }

    public static class FaixaIRPF {

        private Double aliquota;

        private Double valorInicio;

        private Double valorFinal;

        public FaixaIRPF(Double aliquota, Double valorInicio, Double valorFinal) {
            this.aliquota = aliquota;
            this.valorFinal = valorFinal;
            this.valorInicio = valorInicio;
        }

        public Double getAliquota() {
            return aliquota;
        }

        public void setAliquota(Double aliquota) {
            this.aliquota = aliquota;
        }

        public Double getValorFinal() {
            return valorFinal;
        }

        public void setValorFinal(Double valorFinal) {
            this.valorFinal = valorFinal;
        }

        public Double getValorInicio() {
            return valorInicio;
        }

        public void setValorInicio(Double valorInicio) {
            this.valorInicio = valorInicio;
        }

    }

}

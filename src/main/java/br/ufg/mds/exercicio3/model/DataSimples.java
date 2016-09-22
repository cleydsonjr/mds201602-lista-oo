package br.ufg.mds.exercicio3.model;

/**
 * Abstração simplificada de data que trata as entradas para dia, mês e ano.
 * Ainda não contempla anos bissextos
 */
public class DataSimples {
    private static final int[] DIAS_POR_MES = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private Integer dia;
    private Integer mes;
    private Integer ano;

    public void setDia(Integer dia) {
        valideDia(dia, this.mes);

        this.dia = dia;
    }

    private void valideDia(Integer dia, Integer mes) {
        int maximo = 31;
        if (mes != null) {
            maximo = DIAS_POR_MES[mes - 1];
        }

        if (dia < 1 || dia > maximo) {
            throw new IllegalArgumentException("Dia inválido");
        }
    }

    public void setMes(Integer mes) {
        if (this.dia != null) {
            valideDia(this.dia, mes);
        }

        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mês inválido");
        }
        this.mes = mes;
    }

    public void setAno(Integer ano) {
        if (mes < 1) {
            throw new IllegalArgumentException("Ano inválido");
        }
        this.ano = ano;
    }

    public String toString() {
        String dataConvertida;

        if (dia != null && mes != null && ano != null) {
            dataConvertida = dia + "/" + mes + "/" + ano;
        } else {
            dataConvertida = "Data incompleta";
        }

        return dataConvertida;
    }
}

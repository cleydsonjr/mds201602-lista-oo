package br.ufg.mds.exercicio1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContadorTest {

    @Test
    public void metodoZereDeveZerarOContador() {
        Contador contador = new Contador(5);
        assertEquals(5, contador.getValorAtual());

        contador.zere();
        assertEquals(0, contador.getValorAtual());
    }

    @Test
    public void metodoIncrementeDeveIncrementarOContador() {
        Contador contador = new Contador();
        assertEquals(0, contador.getValorAtual());

        contador.incremente();
        assertEquals(1, contador.getValorAtual());
    }

}
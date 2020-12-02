package pl.matuszewski.hasloporzadnie.crypto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AsymmetricTest{

    @Test
    public void test() throws Exception {
        Asymmetric symmetric = new Asymmetric();
        byte[] encrypted = symmetric.encrypt("Ala ma kota");
        assertEquals("Ala ma kota", symmetric.decrypt( encrypted ) );
    }
}
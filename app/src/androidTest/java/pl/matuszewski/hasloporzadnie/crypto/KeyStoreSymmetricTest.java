package pl.matuszewski.hasloporzadnie.crypto;

import org.junit.Test;

import static org.junit.Assert.*;

public class KeyStoreSymmetricTest {

    @Test
    public void test(){
        KeyStoreSymmetric keyStoreSymmetric = new KeyStoreSymmetric("test1");
        String encrypted = keyStoreSymmetric.encryption("ALA Ma kota");
        String decrypted = keyStoreSymmetric.decryption(encrypted);
        assertEquals("ALA Ma kota", decrypted);
    }

    @Test
    public void test2(){
        KeyStoreSymmetric keyStoreSymmetric = new KeyStoreSymmetric("test");
        String encrypted = "emojoDPhKUfP9kqj--BREAK--Vz31zkKbUgrqEx2Xt5XQOq5FOqlqgUcvoJcH";
        String decrypted = keyStoreSymmetric.decryption(encrypted);
        assertEquals("ALA Ma kota", decrypted);
    }

}
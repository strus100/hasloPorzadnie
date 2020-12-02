package pl.matuszewski.hasloporzadnie.crypto;

import org.junit.Test;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import static org.junit.Assert.assertEquals;

public class SymmetricTest{

    @Test
    public void test() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {


        String originalString = "howtodoinjava.com";

        String encryptedString = Symmetric.encrypt(originalString, Symmetric.mockSecret, Symmetric.mockSalt, Symmetric.mockIv) ;
        String decryptedString = Symmetric.decrypt(encryptedString, Symmetric.mockSecret, Symmetric.mockSalt, Symmetric.mockIv) ;

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
        assertEquals(originalString,decryptedString );
    }
}
package pl.matuszewski.hasloporzadnie.crypto;

import org.junit.Assert;
import org.junit.Test;

import java.util.Base64;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HashTest {

    String salt = "o3dsI+R4UW6XczhKmo1I+A==";
    @Test
    public void t(){
        byte[] salt = Hash.prepareSalt();
        System.out.println( Base64.getEncoder().encodeToString(salt) );
    }

    @Test
    public void adminTest(){

        assertEquals("40Za6oG8Ina3orq+aQlSOg==", Hash.encrypt("admin", "o3dsI+R4UW6XczhKmo1I+A==") );
    }

    @Test
    public void admin1Test(){
        assertEquals("EaDgwPtVZZx7V2bFWB6K2w==", Hash.encrypt("admin1", "o3dsI+R4UW6XczhKmo1I+A==") );
    }


    @Test
    public void simpleTest(){
//        assertEquals("ea6177922cf84bd32af98e6b497face3f76024bc827404676c8f37db547a74910308858248dd7bb4a0900d3a11d0b98f0f84c5c03dff7290c1da448c4d8a5d62", Hash.encrypt("Ala ma kota") );
    }

    @Test
    public void hashedHashShouldNotReturnSameHash(){
//        assertNotEquals("c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec",
//                Hash.encrypt("c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec") );
    }

    @Test
    public void longStringIsEncrypted(){
        String veryLongString = "ala";

        for (int i = 0; i <20000 ; i++) {
            veryLongString += "ala";
        }
//       assertEquals(128, Hash.encrypt(veryLongString).length() );
    }

}
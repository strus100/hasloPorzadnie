package pl.matuszewski.hasloporzadnie.crypto;

import org.junit.Assert;
import org.junit.Test;

import java.util.Base64;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HashTest {

    String salt = "o3dsI+R4UW6XczhKmo1I+A==";

    @Test
    public void adminTest(){

        assertEquals("6Bw5YCoGUw3wFPxzQqSuwh9jWDKiExwnc7kibCbf8I620/6xKFlk3OUqVUDSzy4VZMve+7NkGKSMLvLN0buXxw==", Hash.encrypt("admin", "o3dsI+R4UW6XczhKmo1I+A==") );
    }

    @Test
    public void admin1Test(){
        assertEquals("bQpwig9XZ9GZobicUdsGF9ydWEuGIzt7JMLZZmsBGVY0hlyvV2SHLdeP1ntQhsrU+2r4v1hY8UPvJw3+onmELQ==", Hash.encrypt("admin1", "o3dsI+R4UW6XczhKmo1I+A==") );
    }


    @Test
    public void longStringIsEncrypted(){
        String veryLongString = "ala";

        for (int i = 0; i <20000 ; i++) {
            veryLongString += "ala";
        }
       assertNotEquals( veryLongString, Hash.encrypt(veryLongString, salt) );
    }

}
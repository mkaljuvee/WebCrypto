import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class AdvancedCrypto implements Crypto {
    private static final String key = "aesEncryptionKey";
    private static final String initVector = "encryptionIntVec";

    public String encrypt(String word) {
            try {
                IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
                SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

                byte[] encrypted = cipher.doFinal(word.getBytes());
                return Base64.encodeBase64String(encrypted);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }

    public String decrypt(String word) {
            try {
                IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
                SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
                byte[] original = cipher.doFinal(Base64.decodeBase64(word));

                return new String(original);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
    }
}

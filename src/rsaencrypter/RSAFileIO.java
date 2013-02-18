package rsaencrypter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Evan
 */
public class RSAFileIO {

    public static void save(File directory, KeyPair keyPair) throws Exception {
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Store the public key.
        X509EncodedKeySpec publicSpec = new X509EncodedKeySpec(
                publicKey.getEncoded());
        FileOutputStream out = new FileOutputStream(directory + "/public.key");
        out.write(DatatypeConverter.printBase64Binary(publicSpec.getEncoded())
                .getBytes());
        out.close();

        // Store the private key.
        PKCS8EncodedKeySpec privateSpec = new PKCS8EncodedKeySpec(
                privateKey.getEncoded());
        out = new FileOutputStream(directory + "/private.key");
        out.write(DatatypeConverter.printBase64Binary(privateSpec.getEncoded())
                .getBytes());
        out.close();
    }

    public static PublicKey load(File directory) throws Exception {
        // Read the public key file.
        File publicKeyFile = new File(directory + "/public.key");
        FileInputStream in = new FileInputStream(directory + "/public.key");
        byte[] encodedPublicKey = new byte[(int) publicKeyFile.length()];
        in.read(encodedPublicKey);
        encodedPublicKey = DatatypeConverter.parseBase64Binary(new String(
                encodedPublicKey));
        in.close();

        // Instantiate and return the key pair.
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
                encodedPublicKey);
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
        return publicKey;
    }

    public static PrivateKey loadPrivateKey(File directory) throws Exception {

        FileInputStream in;

        // Read the private key file.
        File privateKeyFile = new File(directory + "/private.key");
        in = new FileInputStream(directory + "/private.key");
        byte[] encodedPrivateKey = new byte[(int) privateKeyFile.length()];
        in.read(encodedPrivateKey);
        encodedPrivateKey = DatatypeConverter.parseBase64Binary(new String(
                encodedPrivateKey));
        in.close();

        // Instantiate and return the key pair.
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(
                encodedPrivateKey);
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
        return privateKey;
    }
}

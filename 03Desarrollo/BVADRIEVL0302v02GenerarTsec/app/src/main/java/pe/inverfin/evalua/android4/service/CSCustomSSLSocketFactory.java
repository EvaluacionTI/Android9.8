package pe.inverfin.evalua.android4.service;
//https://ssl-ccp.godaddy.com/repository?origin=CALLISTO
import android.content.Context;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class CSCustomSSLSocketFactory {
    private static SSLSocketFactory oSslSocketFactory;
    //https://www.programacion.com.py/moviles/android/https-y-ssl-en-android
    //https://danielme.com/2015/03/14/servicios-web-soap-con-jax-ws-spring-y-cxf-iii-securizacion-tls-basic/#certificado
    //https://developer.android.com/training/articles/security-ssl.html
    //https://www.natapuntes.es/trustmanager-android/
    private static final String FILE_CA = "gdroot-g2";

    private CSCustomSSLSocketFactory(){
        super();
    }

    public SSLSocketFactory getSSLSocketFactory(Context context) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        //Solo se instancia la primera vez  que se necesita
        if (oSslSocketFactory==null) {
            CertificateFactory oCFactory = CertificateFactory.getInstance("X.509");
            InputStream oIStream = new BufferedInputStream(context.getAssets().open(FILE_CA));
            Certificate oCa;
            try{
                oCa = oCFactory.generateCertificate(oIStream);
            }finally {
                oIStream.close();
            }

            // Se añaden todos los certificados obtenidos desde el assets
            String lsKeyStoreType = KeyStore.getDefaultType();
            KeyStore oKeyStore = KeyStore.getInstance(lsKeyStoreType);
            oKeyStore.load(null, null);
            oKeyStore.setCertificateEntry("ca", oCa);

            // Create a TrustManager that trusts the CAs in our KeyStore
            String lsTManagerAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory oTMFactory = TrustManagerFactory.getInstance(lsTManagerAlgorithm);
            oTMFactory.init(oKeyStore);

            // Create an SSLContext that uses our TrustManager
            SSLContext oSslContext = SSLContext.getInstance("TLS");
            oSslContext.init(null, oTMFactory.getTrustManagers(),null);
            oSslSocketFactory = oSslContext.getSocketFactory();
        }
        return oSslSocketFactory;
    }
}

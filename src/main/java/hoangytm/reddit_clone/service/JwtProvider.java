package hoangytm.reddit_clone.service;


import hoangytm.reddit_clone.common.Constant;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.time.Instant;
import java.util.Date;

import static io.jsonwebtoken.Jwts.parser;

/**
 * @author PhanHoang
 * 4/21/2020
 */
@Service
public class JwtProvider {

    private KeyStore keyStore;

//    @PostConstruct
//    public void init() {
//        try {
//            keyStore = KeyStore.getInstance("JKS");
//            InputStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks");
//            keyStore.load(resourceAsStream, "secret".toCharArray());
//        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
//            throw new RuntimeException("Exception occurred while loading keystore");
//        }
//
//    }
    public String generateToken(Authentication authentication) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + Constant.JWT_EXPIRATION);
        org.springframework.security.core.userdetails.User principal = (User) authentication.getPrincipal();
        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, Constant.JWT_SECRET)
                .compact();
    }
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(Constant.JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (Exception ex) {
            throw ex;

        }
//        return false;
    }
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(Constant.JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
/*
    public String generateToken(Authentication authentication) {
        String token = "";
        try {
            org.springframework.security.core.userdetails.User principal = (User) authentication.getPrincipal();
//        return Jwts.builder()
//                .setSubject(principal.getUsername())
//                .signWith(getPrivateKey())
//                .compact();
             token = Jwts.builder()
                    .claim("name", principal.getUsername())
                    .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode("jwtSecretKey"))
                    .compact();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey("jwtSecretKey", "jwtSecretKey".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new RuntimeException("Exception occured while retrieving public key from keystore");
        }
    }

    public boolean validateToken(String jwt) {
//        parser().setSigningKey(getPublickey()).parseClaimsJws(jwt);
        return true;
    }
    private PublicKey getPublickey() {
        try {
            return keyStore.getCertificate("jwtSecretKey").getPublicKey();
        } catch (KeyStoreException e) {
            throw new RuntimeException("Exception occured while retrieving public key from keystore");
        }
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = parser()
                .setSigningKey(getPublickey())
                .parseClaimsJws(token)
                .getBody();
        Jws<Claims> jws = Jwts.parser()
                .setSigningKeyResolver(getSigningKeyResolver())
                .parseClaimsJws(jwt);

        return new JwtResponse(jws);
        return claims.getSubject();
    }
    public byte[] resolveSigningKeyBytes(JwsHeader header, Claims claims) {
        return TextCodec.BASE64.decode(secrets.get(header.getAlgorithm()));
    }

 */
}
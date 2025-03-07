package com.engeto.crypto;

import java.util.*;

public class CryptoService {

    private List<Crypto> cryptos = new ArrayList<>();

    public void addCrypto(Crypto crypto) { cryptos.add(crypto); }

    public List<Crypto> getCryptos(){
        return cryptos;
    }

    public List<Crypto> sortCryptosByName() {
        cryptos.sort(Comparator.comparing(Crypto::getName));
        return cryptos;
    }

    public List<Crypto> sortCryptosByPrice() {
        cryptos.sort(Comparator.comparing(Crypto::getPrice));
        return cryptos;
    }

    public List<Crypto> sortCryptosByQuantity() {
        cryptos.sort(Comparator.comparing(Crypto::getQuantity));
        return cryptos;
    }
}

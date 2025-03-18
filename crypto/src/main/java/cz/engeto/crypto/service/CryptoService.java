package cz.engeto.crypto.service;

import cz.engeto.crypto.model.CryptoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CryptoService {

    private List<CryptoDTO> cryptos = new ArrayList<>();

    public void addCrypto(CryptoDTO cryptoDTO) {
        cryptos.add(cryptoDTO);
    }

    public List<CryptoDTO> getAllCryptos() {

        return cryptos;
    }

    //Další metoda, která není v zadání. Projít s Tomem, jestli existuje i jiné řešení.
    public List<CryptoDTO> getCryptoById(Integer id) {
        List<CryptoDTO> cryptoById = new ArrayList<>();
        for (CryptoDTO crypto : cryptos) {
            if (crypto.getId().equals(id)) {
                cryptoById.add(crypto);
            }
        }
        return cryptoById;
    }

    public List<CryptoDTO> sortCryptosByName() {
        cryptos.sort(Comparator.comparing(CryptoDTO::getName));
        return cryptos;
    }

    public List<CryptoDTO> sortCryptosByPrice() {
        cryptos.sort(Comparator.comparing(CryptoDTO::getPrice));
        return cryptos;
    }

    public List<CryptoDTO> sortCryptosByQuantity() {
        cryptos.sort(Comparator.comparing(CryptoDTO::getQuantity));
        return cryptos;
    }
}

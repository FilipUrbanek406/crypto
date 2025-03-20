package cz.engeto.crypto.service;

import cz.engeto.crypto.model.CryptoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CryptoService {

    private final List<CryptoDTO> cryptos = new ArrayList<>();

    public void addCrypto(CryptoDTO cryptoDTO) {
        cryptos.add(cryptoDTO);
    }

    public List<CryptoDTO> getAllCryptos() {

        return cryptos;
    }

    public CryptoDTO getCryptoById(Integer id) {
        for (CryptoDTO crypto : cryptos) {
            if (crypto.getId().equals(id)) {
                return crypto;
            }
        }
        return null;
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

    public double getPortfolioValue() {
        double portfolioValue = 0.0;
        for (CryptoDTO crypto : cryptos) {
            double value = crypto.getPrice() * crypto.getQuantity();
            portfolioValue += value;
        }
        return portfolioValue;
    }
}
